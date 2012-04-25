package com.nsn.zerg.viper.core.listener;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.OptionHelper;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.regex.Pattern;

/**
 * User: YiLi
 * Date: 3/8/12
 * Time: 12:18 PM
 */
public class LogbackConfigListener implements ServletContextListener
{
    public static final String CONFIG_LOCATION_PARAM = "logbackConfigLocation";

    /**
     * Regex for prefix of "classpath:" and "classpath*:".
     */
    public static final String LOCATION_CLASSPATH_REGEX = "^classpath\\*?:(.*)";

    public void contextInitialized(ServletContextEvent sce)
    {
        ServletContext sc = sce.getServletContext();
        ILoggerFactory ilc = LoggerFactory.getILoggerFactory();

        if (!(ilc instanceof LoggerContext))
        {
            sc.log("Can not configure logback. " + LoggerFactory.class + " is using " + ilc.getClass() + " which is not a " + LoggerContext.class);
            return;
        }

        LoggerContext lc = (LoggerContext) ilc;
        String location = getLocation(sc, lc);
        if (location == null) return;

        sc.log("Configuring logback from config resource located at " + location);

        InputStream is = openInputStream(sc, location);
        if (is == null)
        {
            sc.log("Could not open logback config neither as servlet context-, nor as url-, nor as file system resource. Location: " + location);
            return;
        }

        try
        {
            configureLogback(sc, lc, is);
        }
        finally
        {
            try
            {
                is.close();
            }
            catch (IOException e)
            {
                sc.log("Could not close logback config inputstream.", e);
            }
        }
    }

    protected String getLocation(ServletContext sc, LoggerContext lc)
    {
        String location = sc.getInitParameter(CONFIG_LOCATION_PARAM);
        location = OptionHelper.substVars(location, lc);

        return location;
    }

    protected InputStream openInputStream(ServletContext sc, String location)
    {
        InputStream is = null;
        if (location == null) return is;

        Pattern pattern = Pattern.compile(LOCATION_CLASSPATH_REGEX);
        if (pattern.matcher(location).matches())
        {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(location.substring(location.indexOf(":") + 1));
        }
        else if (location.startsWith("/"))
        {
            is = sc.getResourceAsStream(location);
        }
        else
        {
            try
            {
                is = new URL(location).openStream();
            }
            catch (IOException ignored)
            {
            }
        }

        if (is == null)
        {
            try
            {
                is = new FileInputStream(location);
            }
            catch (FileNotFoundException ignored)
            {
            }
        }

        return is;
    }

    protected void configureLogback(ServletContext sc, LoggerContext lc, InputStream is)
    {
        JoranConfigurator configurator = new JoranConfigurator();
        configurator.setContext(lc);
        lc.stop();
        try
        {
            configurator.doConfigure(is);
        }
        catch (JoranException e)
        {
            sc.log("Logback configuration failed.", e);
        }
        StatusPrinter.printInCaseOfErrorsOrWarnings(lc);
    }

    public void contextDestroyed(ServletContextEvent sce)
    {
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        lc.stop();
    }
}
