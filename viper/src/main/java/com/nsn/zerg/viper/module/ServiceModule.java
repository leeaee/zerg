package com.nsn.zerg.viper.module;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.nsn.zerg.viper.service.dao.AdminDao;
import com.nsn.zerg.viper.service.spi.mybatis.AdminDaoImpl;
import com.nsn.zerg.viper.service.AdminService;

/**
 * User: YiLi
 * Date: 4/17/12
 * Time: 4:12 PM
 */
public class ServiceModule extends AbstractModule
{
    //Methods
    @Override
    protected void configure()
    {
        bind(AdminDao.class).to(AdminDaoImpl.class).in(Scopes.SINGLETON);
        bind(AdminService.class).in(Scopes.SINGLETON);
    }
} // end class
