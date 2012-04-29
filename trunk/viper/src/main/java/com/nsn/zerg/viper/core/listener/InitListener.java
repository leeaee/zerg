package com.nsn.zerg.viper.core.listener;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.servlet.GuiceServletContextListener;
import com.nsn.zerg.viper.module.ResouceServletModule;
import com.nsn.zerg.viper.module.ConfigModule;
import com.nsn.zerg.viper.module.DataSourceModule;
import com.nsn.zerg.viper.module.ServiceModule;

import java.util.List;

/**
 * User: YiLi
 * Date: 4/19/12
 * Time: 12:44 PM
 */
public class InitListener extends GuiceServletContextListener
{
    //Methods
    @Override
    protected Injector getInjector()
    {
        List<Module> modules = Lists.newArrayList();
        modules.add(new ConfigModule());
        modules.add(new DataSourceModule());
        modules.add(new ServiceModule());
        modules.add(new ResouceServletModule());

        return Guice.createInjector(modules);
    }
} // end class
