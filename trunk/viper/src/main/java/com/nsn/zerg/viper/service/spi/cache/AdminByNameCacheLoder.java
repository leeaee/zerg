package com.nsn.zerg.viper.service.spi.cache;

import com.google.common.cache.CacheLoader;
import com.nsn.zerg.viper.entity.Admin;
import com.nsn.zerg.viper.exception.EntityNotFoundException;
import com.nsn.zerg.viper.service.dao.AdminDao;

/**
 * User: YiLi
 * Date: 4/27/12
 * Time: 12:40 PM
 */
public class AdminByNameCacheLoder extends CacheLoader<String, Admin>
{
    //Properties
    private AdminDao adminDao;

    public AdminByNameCacheLoder(AdminDao adminDao)
    {
        this.adminDao = adminDao;
    }

    //Methods
    @Override
    public Admin load(String key) throws EntityNotFoundException
    {
        Admin admin = adminDao.findByName(key);

        if (admin == null)
        {
            throw new EntityNotFoundException("Admin", key);
        }

        return admin;
    }
} // end class
