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
 * Function:		An implementation of XmlResourceBundle.
 *
 * $RCSfile: LangResource.java,v $
 * $Revision: 1.2 $
 * $Date: 2006/03/14 08:27:17 $
 * $Author: biliang $
 */

package com.nsn.zerg.viper.core.i18n.resource;

import com.nsn.zerg.viper.core.i18n.bundle.XmlResourceBundle;

import java.io.InputStream;
import java.io.Serializable;

/**
 * An implementation of XmlResourceBundle.
 *
 * @author <A href="mailto:gregory@konlink.com">Gregory Song</A>
 * @version $Revision: 1.2 $
 * @since 7.00.00
 */
public class LangResource extends XmlResourceBundle implements Serializable
{
    //Properties
    private static final long serialVersionUID = -7681694536644069796L;

    //Constructor
    public LangResource()
    {
    }

    //Methods
    @Override
    protected InputStream getXmlResource()
    {
        System.out.println("LangResource.class.getResourceAsStream(\"LangResource.xml\")");
        return LangResource.class.getResourceAsStream("LangResource.xml");
    }
}
