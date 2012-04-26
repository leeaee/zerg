package com.nsn.zerg.viper.realm;

import com.google.common.collect.Lists;
import com.nsn.zerg.viper.entity.Admin;
import com.nsn.zerg.viper.service.dao.AdminDao;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.inject.Inject;

/**
 * User: YiLi
 * Date: 4/24/12
 * Time: 4:53 PM
 */
public class ShiroDbRealm extends AuthorizingRealm
{
    //Properties
    private AdminDao adminDao;

    public ShiroDbRealm()
    {
        setCachingEnabled(false);
        setCredentialsMatcher(new HashedCredentialsMatcher(Md5Hash.ALGORITHM_NAME));
    }

    //Methods
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException
    {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String username = token.getUsername();
        Admin admin = adminDao.find(1L);

        if (admin != null)
        {
            return new SimpleAuthenticationInfo(admin.getName(), admin.getPassword(), getName());
        }
        else
        {
            return null;
        }
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
    {
        String username = (String) principals.fromRealm(getName()).iterator().next();
        Admin admin = adminDao.find(1L);
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

    @Inject
    public void setAdminDao(AdminDao adminDao)
    {
        this.adminDao = adminDao;
    }
} // end class
