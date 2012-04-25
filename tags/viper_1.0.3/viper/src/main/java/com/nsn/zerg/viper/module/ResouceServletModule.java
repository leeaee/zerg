package com.nsn.zerg.viper.module;

import com.nsn.zerg.viper.webservice.rs.AdminResouceService;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import org.apache.shiro.guice.web.GuiceShiroFilter;

/**
 * User: YiLi
 * Date: 4/19/12
 * Time: 12:51 PM
 */
public class ResouceServletModule extends JerseyServletModule
{
    //Methods
    protected void configureServlets()
    {
        //Bind the resouce services.
        install(new ShiroSecurityModule(getServletContext()));
        bind(AdminResouceService.class);

        filter("/*").through(GuiceShiroFilter.class);
        serve("/*").with(GuiceContainer.class);
    }
} // end class
