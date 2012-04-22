package com.nsn.zerg.viper.exception;

import javax.ws.rs.core.Response.Status;

/**
 * 实体已经存在的异常.
 * <p/>
 * Author: Genkyo Lee <genkyo.lee@gmail.com>
 * Date: 3/15/12
 * Time: 10:15 PM
 * Revision: 1.01
 */
public class EntityAlreadyExistException extends Exception
{
    //Properties
    private static final long serialVersionUID = 2276118015440841776L;
    public static final Status ENTITY_EXISTED = Status.CONFLICT;

    //Constructor

    /**
     * 用一个消息的key构造, 仅仅简单的说明.
     */
    public EntityAlreadyExistException(Throwable cause)
    {
        super(cause.getMessage(), cause);
    }

    public EntityAlreadyExistException(Object msg)
    {
        super("Admin(id) " + msg + " already exist!");
    }
} // end class
