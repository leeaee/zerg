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
public class AdminCacheLoder extends CacheLoader<Object, Admin>
{
    //Properties
    private AdminDao adminDao;

    public AdminCacheLoder(AdminDao adminDao)
    {
        this.adminDao = adminDao;
    }

    //Methods
    @Override
    public Admin load(Object key) throws EntityNotFoundException
    {
        Admin admin = null;
        if (key instanceof Long)
        {
            admin = adminDao.find(Long.valueOf(key.toString()));
        }
        else if (key instanceof String)
        {
            System.out.println("key >>> " + key);
            admin = adminDao.findByName(key.toString());
        }

        if (admin == null)
        {
            throw new EntityNotFoundException(Admin.KEY, key);
        }
        return admin;
    }
} // end class