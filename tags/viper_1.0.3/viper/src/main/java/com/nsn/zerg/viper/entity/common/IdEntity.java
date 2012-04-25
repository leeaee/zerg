package com.nsn.zerg.viper.entity.common;

/**
 * Author: Genkyo Lee <genkyo.lee@gmail.com>
 * Date: 3/11/12
 * Time: 2:12 PM
 * Revision: 1.01
 */
public abstract class IdEntity
{
    protected Long id;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
} // end class
