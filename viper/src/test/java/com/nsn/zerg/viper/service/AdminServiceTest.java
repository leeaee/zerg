package com.nsn.zerg.viper.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.nsn.zerg.viper.entity.Admin;
import com.nsn.zerg.viper.exception.EntityNotFoundException;
import com.nsn.zerg.viper.module.ConfigModule;
import com.nsn.zerg.viper.module.DataSourceModule;
import com.nsn.zerg.viper.module.ServiceModule;

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
    public static void main(String[] args) throws EntityNotFoundException
    {
        Injector injector = Guice.createInjector(new ConfigModule(), new DataSourceModule(), new ServiceModule());
        AdminService service = injector.getInstance(AdminService.class);
        long startTime = System.currentTimeMillis();
        service.getAdmin(1L);
        //        for (int i = 0; i < 10000; i ++)
        //        {
        //            service.getAdmin(1L);
        //        }
        System.out.println("Guice cast time: " + (System.currentTimeMillis() - startTime));
//        System.out.println(service.getAdmin(118L));
//        Admin admin = new Admin();
//        admin.setId(118L);
//        admin.setMobile("12344007788");
//        service.updateAdmin(admin);
    }
} // end class
