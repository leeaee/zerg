package com.nsn.zerg.viper.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.nsn.zerg.viper.entity.Admin;
import com.nsn.zerg.viper.exception.EntityNotFoundException;
import com.nsn.zerg.viper.service.dao.AdminDao;
import com.nsn.zerg.viper.service.spi.cache.AdminCacheLoder;

import javax.inject.Inject;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * User: YiLi
 * Date: 4/17/12
 * Time: 4:51 PM
 */
public class AdminService
{
    //Properties
    private AdminDao adminDao;
    private LoadingCache<Long, Admin> cache;

    @Inject
    public AdminService(AdminDao adminDao)
    {
        this.adminDao = adminDao;
        this.cache = CacheBuilder.newBuilder().maximumSize(1000).expireAfterAccess(15, TimeUnit.MINUTES).build(new AdminCacheLoder(adminDao));
    }

    //Methods
    public Admin getAdmin(Long id) throws EntityNotFoundException
    {
        try
        {
            return cache.get(id);
        }
        catch (ExecutionException e)
        {
            throw new EntityNotFoundException(e);
        }
    }

    public void updateAdmin(Admin admin)
    {
        adminDao.update(admin);
        cache.refresh(admin.getId());
    }

    public void deleteAdmin(Long id)
    {
        adminDao.delete(id);
        cache.invalidate(id);
    }
} // end class
