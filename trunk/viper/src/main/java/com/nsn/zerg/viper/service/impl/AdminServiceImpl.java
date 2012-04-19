package com.nsn.zerg.viper.service.impl;

import com.nsn.zerg.viper.dao.AdminDao;
import com.nsn.zerg.viper.entity.Admin;
import com.nsn.zerg.viper.service.AdminService;
import org.mybatis.guice.transactional.Transactional;

import javax.inject.Inject;

/**
 * User: YiLi
 * Date: 4/17/12
 * Time: 4:51 PM
 */
public class AdminServiceImpl implements AdminService
{
    //Properties
    private AdminDao adminDao;

    //Methods
    @Override
    @Transactional
    public Admin getAdmin(Long id)
    {
        return adminDao.getAdmin(id);
    }

    @Inject
    public void setAdminDao(AdminDao adminDao)
    {
        this.adminDao = adminDao;
    }
} // end class
