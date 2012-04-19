package com.nsn.zerg.viper.module;

import com.google.inject.AbstractModule;
import com.nsn.zerg.viper.core.util.PropertiesUtils;

import static com.google.inject.name.Names.bindProperties;

/**
 * User: YiLi
 * Date: 4/17/12
 * Time: 4:58 PM
 */
public class ConfigModule extends AbstractModule
{
    //Properties

    //Methods
    @Override
    protected void configure()
    {
        bindProperties(binder(), PropertiesUtils.loadConfigtProperties());
    }
} // end class
