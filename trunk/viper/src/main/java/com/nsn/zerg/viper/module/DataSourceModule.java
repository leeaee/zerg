package com.nsn.zerg.viper.module;

import com.nsn.zerg.viper.entity.Admin;
import com.nsn.zerg.viper.service.spi.mybatis.mapper.AdminMapper;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.bonecp.BoneCPProvider;

/**
 * User: YiLi
 * Date: 4/17/12
 * Time: 5:06 PM
 */
public class DataSourceModule extends MyBatisModule
{
    //Properties

    //Constructors

    //Methods
    @Override
    protected void initialize()
    {
        environmentId("zerg-viper");
        bindDataSourceProviderType(BoneCPProvider.class);
        bindTransactionFactoryType(JdbcTransactionFactory.class);
        addMapperClass(AdminMapper.class);
        addSimpleAlias(Admin.class);
    }
} // end class
