package com.nsn.zerg.viper.dao.impl;

import com.nsn.zerg.viper.dao.AdminDao;
import com.nsn.zerg.viper.entity.Admin;
import org.apache.ibatis.session.SqlSession;

import javax.inject.Inject;

/**
 * User: YiLi
 * Date: 4/17/12
 * Time: 4:50 PM
 */
public class AdminDaoImpl implements AdminDao
{
    //Properties
    private SqlSession sqlSession;

    //Methods
    @Override
    public Admin getAdmin(Long id)
    {
        return this.sqlSession.selectOne("com.nsn.zerg.viper.mapper.AdminMapper.find", id);
    }

    @Inject
    public void setSqlSession(SqlSession sqlSession)
    {
        this.sqlSession = sqlSession;
    }
} // end class
