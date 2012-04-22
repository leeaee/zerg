package com.nsn.zerg.viper.core.jersey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * Jersey辅助类
 * <p/>
 * Author: Genkyo Lee <genkyo.lee@gmail.com>
 * Date: 3/11/12
 * Time: 3:14 PM
 * Revision: 1.01
 */
public class Jerseys
{
    private static Logger logger = LoggerFactory.getLogger(Jerseys.class);

    private Jerseys()
    {
    }

    /**
     * 创建WebApplicationException并记打印日志, 使用标准状态码与自定义信息并记录错误信息.
     */
    public static WebApplicationException buildException(Status status, String message)
    {
        return buildException(status.getStatusCode(), message);
    }

    /**
     * 创建WebApplicationException并打印日志, 使用自定义状态码与自定义信息并记录错误信息.
     */
    public static WebApplicationException buildException(int status, String message)
    {
        logger.error("Restful Service Error, Status " + status + ": " + message);
        return new WebApplicationException(buildTextResponse(status, message));
    }

    /**
     * 创建状态码为500的默认WebApplicatonExcetpion, 并在日志中打印RuntimeExcetpion的信息.
     * 如RuntimeException为WebApplicatonExcetpion则跳过不进行处理.
     */
    public static WebApplicationException buildDefaultException(RuntimeException e)
    {
        if (e instanceof WebApplicationException)
        {
            return (WebApplicationException) e;
        }
        else
        {
            logger.error("Restful Service Error, Status 500: " + e.getMessage(), e);
            return new WebApplicationException();
        }
    }

    public static Response buildTextResponse(Status status, String message)
    {
        return buildTextResponse(status.getStatusCode(), message);
    }

    public static Response buildTextResponse(int status, String message)
    {
        return Response.status(status).entity(message).type(MediaType.TEXT_PLAIN).build();
    }
} // end class
