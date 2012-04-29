package com.nsn.zerg.viper.realm;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import com.nsn.zerg.viper.entity.Admin;
import com.nsn.zerg.viper.service.dao.AdminDao;
import com.nsn.zerg.viper.service.spi.cache.AdminByNameCacheLoder;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.inject.Inject;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * User: YiLi
 * Date: 4/24/12
 * Time: 4:53 PM
 */
public class ShiroDbRealm extends AuthorizingRealm
{
    //Properties
    private LoadingCache<String, Admin> cache;

    @Inject
    public ShiroDbRealm(AdminDao adminDao)
    {
        setCachingEnabled(false);
        setCredentialsMatcher(new HashedCredentialsMatcher(Md5Hash.ALGORITHM_NAME));
        this.cache = CacheBuilder.newBuilder().maximumSize(1000).expireAfterAccess(15, TimeUnit.MINUTES).build(new AdminByNameCacheLoder(adminDao));
    }

    //Methods
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException
    {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

        try
        {
            Admin admin = cache.get(token.getUsername());
            return new SimpleAuthenticationInfo(admin.getName(), admin.getPassword(), getName());
        }
        catch (ExecutionException e)
        {
            throw new AuthenticationException(e.getCause().getMessage());
        }
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
    {
        String username = (String) principals.fromRealm(getName()).iterator().next();
        Admin admin = cache.getIfPresent(username);

        if (admin != null)
        {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.addStringPermissions(Lists.newArrayList("admin:read"));
            return info;
        }
        else
        {
            return null;
        }
    }
} // end class
