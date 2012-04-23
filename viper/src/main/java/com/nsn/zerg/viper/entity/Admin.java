package com.nsn.zerg.viper.entity;

import com.nsn.zerg.viper.core.mapper.JsonMapper;
import com.nsn.zerg.viper.entity.common.IdEntity;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Author: Genkyo Lee <genkyo.lee@gmail.com>
 * Date: 3/11/12
 * Time: 5:10 PM
 * Revision: 1.01
 */
@XmlRootElement(name = "admin")
public class Admin extends IdEntity implements Serializable
{
    private static final long serialVersionUID = -2505591172046127150L;
    public static final String KEY = "entity.admin";

    //Properties
    private String name;
    private String password;
    private String trueName;
    private String phone;
    private String mobile;
    private String email;
    private Integer state;
    private String description;
    private Long lastLogin;
    private Long lastModify;
    private Long createTime;

    //Constructors
    public Admin()
    {
    }

    public Admin(String name)
    {
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

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getTrueName()
    {
        return trueName;
    }

    public void setTrueName(String trueName)
    {
        this.trueName = trueName;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Integer getState()
    {
        return state;
    }

    public void setState(Integer state)
    {
        this.state = state;
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
        return JsonMapper.buildNonNullMapper().toJson(this);
    }
} // end class
