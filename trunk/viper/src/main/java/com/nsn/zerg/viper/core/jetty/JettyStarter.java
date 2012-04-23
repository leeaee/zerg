package com.nsn.zerg.viper.core.jetty;

import com.google.inject.servlet.GuiceFilter;
import com.nsn.zerg.viper.core.listener.InitListener;
import com.nsn.zerg.viper.core.listener.LogbackConfigListener;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * User: YiLi
 * Date: 4/23/12
 * Time: 2:54 PM
 */
public class JettyStarter
{
    //Methods
    public static void main(String[] args) throws Exception
    {
        Server server = new Server(8080);

        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/viper");
        handler.setResourceBase(".");
        handler.setInitParameter("logbackConfigLocation", "classpath:conf/logback.xml");
        handler.addEventListener(new LogbackConfigListener());
        handler.addEventListener(new InitListener());
        handler.addFilter(GuiceFilter.class, "/*", null);
        handler.addServlet(DefaultServlet.class, "/");

        server.setHandler(handler);
        server.start();
        server.join();
    }
} // end class
