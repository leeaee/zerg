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
public class AdminByIdCacheLoder extends CacheLoader<Long, Admin>
{
    //Properties
    private AdminDao adminDao;

    public AdminByIdCacheLoder(AdminDao adminDao)
    {
        this.adminDao = adminDao;
    }

    //Methods
    @Override
    public Admin load(Long id) throws EntityNotFoundException
    {
        Admin admin = adminDao.find(id);

        if (admin == null)
        {
            throw new EntityNotFoundException("Admin(id)", id);
        }

        return admin;
    }
} // end class