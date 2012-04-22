package com.nsn.zerg.viper.exception;

import javax.ws.rs.core.Response.Status;

/**
 * 没有找到实体的异常.
 * <p/>
 * Author: Genkyo Lee <genkyo.lee@gmail.com>
 * Date: 3/15/12
 * Time: 6:19 PM
 * Revision: 1.01
 */
public class EntityNotFoundException extends Exception
{
    //Properties
    private static final long serialVersionUID = 1158620018143052355L;
    public static final Status NOT_FOUND = Status.NOT_FOUND;

    //Constructor
    public EntityNotFoundException(Throwable cause)
    {
        super(cause.getMessage(), cause);
    }

    /**
     * 用一个消息的key构造, 仅仅简单的说明.
     */
    public EntityNotFoundException(Object msg)
    {
        super("Admin(id) " + msg + " not found!");
    }
} // end class
