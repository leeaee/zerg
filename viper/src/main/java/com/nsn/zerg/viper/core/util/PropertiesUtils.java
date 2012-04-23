package com.nsn.zerg.viper.core.util;

import com.nsn.zerg.viper.core.constant.Constants;
import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationConverter;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * User: YiLi
 * Date: 4/18/12
 * Time: 11:46 AM
 */
public class PropertiesUtils
{
    private static Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);
    public static Properties properties;

    //Methods
    public static Properties loadConfigtProperties()
    {
        if (properties == null)
        {
            try
            {
                CompositeConfiguration configuration = new CompositeConfiguration();
                configuration.addConfiguration(new PropertiesConfiguration(Constants.JDBC_CONFIG));
                properties = ConfigurationConverter.getProperties(configuration);
            }
            catch (ConfigurationException e)
            {
                logger.error("load configuration files failed: {}", e.getMessage());
            }
        }

        return properties;
    }
} // end class
