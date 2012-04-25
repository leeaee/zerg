package com.nsn.zerg.viper.service.spi.cache;

import com.google.common.cache.CacheLoader;
import com.nsn.zerg.viper.entity.Admin;
import com.nsn.zerg.viper.exception.EntityNotFoundException;
import com.nsn.zerg.viper.service.dao.AdminDao;

/**
 * Author: Genkyo Lee <genkyo.lee@gmail.com>
 * Date: 4/22/12
 * Time: 2:04 PM
 * Revision: 1.01
 */
public class AdminCacheLoder extends CacheLoader<Long, Admin>
{
    //Properties
    private AdminDao adminDao;

    public AdminCacheLoder(AdminDao adminDao)
    {
        this.adminDao = adminDao;
    }

    //Methods
    @Override
    public Admin load(Long key) throws EntityNotFoundException
    {
        return adminDao.find(key);
    }
} // end class