package com.nsn.zerg.viper.module;

import com.google.inject.Scopes;
import com.nsn.zerg.viper.realm.ShiroDbRealm;
import org.apache.shiro.guice.web.ShiroWebModule;

import javax.servlet.ServletContext;

/**
 * User: YiLi
 * Date: 4/24/12
 * Time: 4:43 PM
 */
public class ShiroSecurityModule extends ShiroWebModule
{
    //Constructors
    public ShiroSecurityModule(ServletContext servletContext)
    {
        super(servletContext);
    }

    //Methods
    @SuppressWarnings("unchecked")
    @Override
    protected void configureShiroWeb()
    {
        bindRealm().to(ShiroDbRealm.class).in(Scopes.SINGLETON);

        addFilterChain("/admin/**", NO_SESSION_CREATION, AUTHC_BASIC, config(REST, "admin"));
    }
} // end class
