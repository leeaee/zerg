package com.nsn.zerg.viper.exception;

import com.nsn.zerg.viper.core.exception.JerseyException;

import javax.ws.rs.core.Response.Status;

/**
 * Exception to describe entity is missing.
 *
 * User: YiLi
 * Date: 3/20/12
 * Time: 18:08 PM
 */
public class EntityNotFoundException extends JerseyException
{
    private static final long serialVersionUID = -7101437880545394435L;
    private static final String BASE_MSG = "entity {0} {1} not found!";
    public static final Status NOT_FOUND = Status.NOT_FOUND;

    public EntityNotFoundException(String msg)
    {
        super(NOT_FOUND, msg);
    }

    public EntityNotFoundException(String entityKey, Object entityId)
    {
        super(NOT_FOUND, BASE_MSG, new Object[]{ entityKey, entityId });
    }
} // end class