package com.nsn.zerg.viper.module;

import com.nsn.zerg.viper.webservice.rs.AdminResouceService;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

/**
 * User: YiLi
 * Date: 4/19/12
 * Time: 12:51 PM
 */
public class ResouceServletModule extends JerseyServletModule
{
    //Properties

    //Methods
    protected void configureServlets()
    {
        bind(AdminResouceService.class);
        serve("/*").with(GuiceContainer.class);
    }
} // end class
