package com.nsn.zerg.viper.module;

import com.google.inject.Provides;
import org.apache.shiro.config.Ini;
import org.apache.shiro.guice.web.ShiroWebModule;
import org.apache.shiro.realm.text.IniRealm;

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
    @Override
    @SuppressWarnings("unchecked")
    protected void configureShiroWeb()
    {
        try
        {
            bindRealm().toConstructor(IniRealm.class.getConstructor(Ini.class));
        }
        catch (NoSuchMethodException e)
        {
            addError(e);
        }

//        addFilterChain("/admin/**", AUTHC, config(ROLES, "admin"));
        addFilterChain("/**", AUTHC_BASIC);
    }

    @Provides
    Ini loadShiroIni()
    {
        return Ini.fromResourcePath("classpath:conf/shiro.ini");
    }
} // end class
