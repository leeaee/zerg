package com.nsn.zerg.viper.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.nsn.zerg.viper.module.ConfigModule;
import com.nsn.zerg.viper.module.DataSourceModule;
import com.nsn.zerg.viper.module.ServiceModule;
import com.nsn.zerg.viper.service.impl.AdminServiceImpl;

/**
 * User: YiLi
 * Date: 4/17/12
 * Time: 5:16 PM
 */
public class AdminServiceTest
{
    //Properties

    //Constructors

    //Methods
    public static void main(String[] args)
    {
        Injector injector = Guice.createInjector(new ConfigModule(), new DataSourceModule(), new ServiceModule());
        AdminServiceImpl service = injector.getInstance(AdminServiceImpl.class);

        System.out.println(service.getAdmin(1L));

//        long startTime = System.currentTimeMillis();
//        for (int i = 0; i < 10000; i ++)
//        {
//            service.getAdmin(1L);
//        }
//        System.out.println("Guice cast time: " + (System.currentTimeMillis() - startTime));
    }
} // end class
