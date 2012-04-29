package com.nsn.zerg.viper.service.spi.mybatis;

import com.nsn.zerg.viper.entity.Admin;
import com.nsn.zerg.viper.service.dao.AdminDao;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.guice.transactional.Transactional;

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
    @Transactional
    public Admin find(Long id)
    {
        return this.sqlSession.selectOne("com.nsn.zerg.viper.service.spi.mybatis.mapper.AdminMapper.find", id);
    }

    @Override
    @Transactional
    public Admin findByName(String name)
    {
        return this.sqlSession.selectOne("com.nsn.zerg.viper.service.spi.mybatis.mapper.AdminMapper.findByName", name);
    }

    @Override
    @Transactional
    public void update(Admin admin)
    {
        this.sqlSession.update("com.nsn.zerg.viper.service.spi.mybatis.mapper.AdminMapper.update", admin);
    }

    @Override
    @Transactional
    public void delete(Long id)
    {
        this.sqlSession.delete("com.nsn.zerg.viper.service.spi.mybatis.mapper.AdminMapper.delete", id);
    }

    @Inject
    public void setSqlSession(SqlSession sqlSession)
    {
        this.sqlSession = sqlSession;
    }
} // end class