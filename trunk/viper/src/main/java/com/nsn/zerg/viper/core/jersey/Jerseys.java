package com.nsn.zerg.viper.core.jersey;

import com.nsn.zerg.viper.core.exception.JerseyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * Jersey∏®÷˙¿‡
 * <p/>
 * Author: Genkyo Lee <genkyo.lee@gmail.com>
 * Date: 3/11/12
 * Time: 3:14 PM
 * Revision: 1.01
 */
public class Jerseys
{
    private static Logger logger = LoggerFactory.getLogger(Jerseys.class);

    public static WebApplicationException buildException(JerseyException exception)
    {
        return buildException(exception.getStatus(), exception.getMessage());
    }

    /**
     * Build webApplicationException with stander http status and log information.
     */
    public static WebApplicationException buildException(Status status, String message)
    {
        return buildException(status.getStatusCode(), message);
    }

    /**
     * Build webApplicationException with http status code and log information.
     */
    public static WebApplicationException buildException(int status, String message)
    {
        logger.error("RESTful service error " + status + ": " + message);
        return new WebApplicationException(buildTextResponse(status, message));
    }

    /**
     * Create text/plain format return response.
     *
     * @param status
     * @param message
     * @return
     */
    public static Response buildTextResponse(Status status, String message)
    {
        return buildTextResponse(status.getStatusCode(), message);
    }

    public static Response buildTextResponse(int status, String message)
    {
        return Response.status(status).entity(message).type(MediaType.TEXT_PLAIN).build();
    }

    /**
     * Create status 500 WebApplicatonExcetpion and log RuntimeException
     * if RuntimeException is WebApplicatonExcetpion, ignored.
     */
    public static WebApplicationException buildDefaultException(RuntimeException e)
    {
        if (e instanceof WebApplicationException)
        {
            return (WebApplicationException) e;
        }
        else
        {
            logger.error("RESTful service error 500: " + e.getMessage(), e);
            return new WebApplicationException();
        }
    }
}
