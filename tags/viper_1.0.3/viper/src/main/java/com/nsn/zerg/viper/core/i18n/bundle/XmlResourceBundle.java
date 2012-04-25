/*
 * +--------------------------------------------------------------------------+
 * | Project: EWORK_SERVER                                                    |
 * +--------------------------------------------------------------------------+
 * | Copyright (c) 2000-2004 Konlink R&D Center.	All Righrs Reserved.	  |
 * +--------------------------------------------------------------------------+
 * | This source file is subject to Konlink(c) Software/Webware license,      |
 * | that is bundled with this package in the file LICENSE, and is            |
 * | available at through the world-wide-web at                               |
 * | http://www.konlink.com/                                                  |
 * | If you did not receive a copy of the Konlink(c) Software/Webware license |
 * | and are unable to obtain it through the world-wide-web, please send a    |
 * | note to license@konlink.com so we can mail you a copy immediately.       |
 * +--------------------------------------------------------------------------+
 * | Authors: Gregory Song <gregory@konlink.com>                              |
 * +--------------------------------------------------------------------------+
 *
 * Create Author:	Gregory Song
 * Create Date:		2004-11-16
 * Function:		The Resource Bundle implemented with XML Properties Files
 *
 * $RCSfile: XmlResourceBundle.java,v $
 * $Revision: 1.3 $
 * $Date: 2006/07/05 07:00:48 $
 * $Author: biliang $
 */

package com.nsn.zerg.viper.core.i18n.bundle;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * The Resource Bundle implemented with XML Properties Files.
 * <p/>
 * 本类用支持 XML 配置文件的Properties实现ResourceBundle，所有本类的实现类，都应该继承 getXmlResource() 方法以提供一个 XML 文件的读
 * 取流。
 *
 * @author <A href="mailto:gregory@konlink.com">Gregory Song</A>
 * @version $Revision: 1.3 $
 * @since 7.00.00
 */
public abstract class XmlResourceBundle extends ResourceBundle
{
    //Properties
    private static Logger logger = LoggerFactory.getLogger(XmlResourceBundle.class);
    private ImmutableMap<String, String> lookup;

    //Constructor
    public XmlResourceBundle()
    {
        Properties props = new Properties();
        try
        {
            props.loadFromXML(getXmlResource());
        }
        catch (IOException e)
        {
            logger.warn("Load xml resource error: ", e);
        }
        lookup = Maps.fromProperties(props);
    }

    //Methods

    /**
     * 获取读取XML配置文件的InputStream
     *
     * @return 读取 XML 配置文件的 InputStream
     */
    protected abstract InputStream getXmlResource();

    @Override
    protected Object handleGetObject(String key)
    {
        if (key == null)
        {
            throw new NullPointerException();
        }
        return lookup.get(key);
    }

    @Override
    public Enumeration<String> getKeys()
    {
        ResourceBundle tmpParent = this.parent;
        return new ResourceBundleEnumeration(lookup.keySet(), (tmpParent != null ? tmpParent.getKeys() : null));
    }

}
