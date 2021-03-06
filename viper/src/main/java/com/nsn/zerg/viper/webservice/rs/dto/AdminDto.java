package com.nsn.zerg.viper.webservice.rs.dto;

import com.nsn.zerg.viper.core.constant.Constants;
import com.nsn.zerg.viper.core.mapper.JsonMapper;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Roger Li
 * Date: 3/6/12
 * Time: 13:08 PM
 */
@XmlType
(
    namespace = Constants.NS,
    propOrder =
    {
        "id", "name", "trueName", "phone", "mobile", "email",
        "state", "description", "lastLogin", "lastModify", "createTime", "roles"
    }
)
@XmlRootElement(name = "admin")
public class AdminDto
{
    private Long id;
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

    private List<RoleDto> roles = new ArrayList<RoleDto>();

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

    @XmlTransient
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

    @XmlElementWrapper(name = "roles")
    @XmlElement(name = "role")
    public List<RoleDto> getRoles()
    {
        return roles;
    }

    public void setRoles(List<RoleDto> roles)
    {
        this.roles = roles;
    }

    @Override
    public String toString()
    {
        return JsonMapper.buildNonNullMapper().toJson(this);
    }
} // end class

