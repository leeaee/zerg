package com.nsn.zerg.viper.service.dao;

import com.nsn.zerg.viper.entity.Admin;
import com.nsn.zerg.viper.exception.EntityNotFoundException;
import org.mybatis.guice.transactional.Transactional;

/**
 * User: YiLi
 * Date: 4/17/12
 * Time: 4:48 PM
 */
public interface AdminDao
{
    @Transactional
    public Admin find(Long id) throws EntityNotFoundException;

    @Transactional
    public void update(Admin admin);

    @Transactional
    public void delete(Long id);
}
