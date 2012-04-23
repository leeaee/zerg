package com.nsn.zerg.viper.core.exception;

import javax.ws.rs.core.Response.Status;
import java.text.MessageFormat;

/**
 * User: YiLi
 * Date: 3/20/12
 * Time: 11:34 AM
 */
public class JerseyException extends Exception
{
    //Properties
    private static final long serialVersionUID = 6538550594551417029L;
    private Object[] params;
    private Status status;

    //Constructors

    /**
     * Construct a exception with throwable cause.
     *
     * @param cause
     */
    public JerseyException(Throwable cause)
    {
        super(cause.getMessage(), cause);
    }

    /**
     * Construct a exception with http status and user message.
     *
     * @param status
     * @param msg
     */
    public JerseyException(Status status, String msg)
    {
        super(msg);
        this.status = status;
    }

    /**
     * Construct a exception with http status, user message and input parameters.
     *
     * @param status
     * @param msg
     * @param params
     */
    public JerseyException(Status status, String msg, Object[] params)
    {
        super(msg);
        this.params = params;
        this.status = status;
    }

    //Methods

    /**
     * Return the parameter object.
     * @return
     */
    public Object[] getParams()
    {
        return params;
    }

    /**
     * Return the http status code.
     * @return
     */
    public int getStatus()
    {
        return status.getStatusCode();
    }

    /**
     * Override the getMessage() method.
     * Return the format message with parameters.
     *
     * @return
     */
    @Override
    public String getMessage()
    {
        if (this.params != null && this.params.length > 0)
        {
            return formatMessage(super.getMessage(), params);
        }
        else if (this.getCause() != null)
        {
            if (this.getCause() instanceof JerseyException)
            {
                JerseyException cause = (JerseyException) this.getCause();
                return formatMessage(super.getMessage(), new Object[]{cause.getMessage()});
            }
            else
            {
                return formatMessage(super.getMessage(), new Object[]{this.getCause().getMessage()});
            }
        }
        else
        {
            return super.getMessage();
        }
    }
    
    public String formatMessage(String message, Object[] params)
    {
        return MessageFormat.format(message, params);
    }
} // end class
