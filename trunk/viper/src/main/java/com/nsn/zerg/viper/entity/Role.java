package com.nsn.zerg.viper.entity;

import com.nsn.zerg.viper.core.mapper.JsonMapper;
import com.nsn.zerg.viper.entity.common.IdEntity;

import java.io.Serializable;

/**
 * User: YiLi
 * Date: 4/27/12
 * Time: 2:37 PM
 */
public class Role extends IdEntity implements Serializable
{
    //Properties
    private static final long serialVersionUID = 520695627881046030L;
    private String name;
    private String description;
    private Long lastModify;
    private Long createTime;

    //Constructors
    public Role()
    {
    }

    public Role(Long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    //Methods
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Long getLastModify()
    {
        return lastModify;
    }

    public void setLastModify(Long lastModify)
    {
        this.lastModify = lastModify;
    }

    public Long getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Long createTime)
    {
        this.createTime = createTime;
    }

    @Override
    public String toString()
    {
        return JsonMapper.buildNormalMapper().toJson(this);
    }
} //end class