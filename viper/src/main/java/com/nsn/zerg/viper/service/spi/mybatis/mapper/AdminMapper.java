package com.nsn.zerg.viper.service.spi.mybatis.mapper;

import com.nsn.zerg.viper.entity.Admin;

/**
 * User: YiLi
 * Date: 4/17/12
 * Time: 5:27 PM
 */
public interface AdminMapper
{
    public Admin find(Long id);
    public void delete(Long id);
}
