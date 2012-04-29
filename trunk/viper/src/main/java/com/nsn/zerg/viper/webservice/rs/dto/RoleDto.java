package com.nsn.zerg.viper.webservice.rs.dto;

import com.nsn.zerg.viper.core.constant.Constants;
import com.nsn.zerg.viper.core.mapper.JsonMapper;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Author: Genkyo Lee <genkyo.lee@gmail.com>
 * Date: 3/11/12
 * Time: 5:19 PM
 * Revision: 1.01
 */
@XmlType
(
    namespace = Constants.NS,
    propOrder =
    {
        "id", "name", "description", "lastLogin", "lastModify"
    }
)
@XmlRootElement(name = "role")
public class RoleDto
{
    private Long id;
    private String name;
    private String description;
    private Long lastLogin;
    private Long lastModify;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

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

    public Long getLastLogin()
    {
        return lastLogin;
    }

    public void setLastLogin(Long lastLogin)
    {
        this.lastLogin = lastLogin;
    }

    public Long getLastModify()
    {
        return lastModify;
    }

    public void setLastModify(Long lastModify)
    {
        this.lastModify = lastModify;
    }

    @Override
    public String toString()
    {
        return JsonMapper.buildNonNullMapper().toJson(this);
    }
}
