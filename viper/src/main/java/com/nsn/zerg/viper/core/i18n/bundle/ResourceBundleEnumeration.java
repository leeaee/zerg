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
 * Function:		Implements an Enumeration that combines elements from a Set and an Enumeration. Used by ListResourceBundle and PropertyResourceBundle.
 *
 * $RCSfile: ResourceBundleEnumeration.java,v $
 * $Revision: 1.1.1.1 $
 * $Date: 2005/07/27 01:34:09 $
 * $Author: gregory $
 */

package com.nsn.zerg.viper.core.i18n.bundle;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Implements an Enumeration that combines elements from a Set and an Enumeration. Used by ListResourceBundle and
 * PropertyResourceBundle. <p /> This class is get from java.util.ResourceBundleEnumeration, which is not public out of
 * java.util.
 *
 * @author <A href="mailto:gregory@konlink.com">Gregory Song</A>
 * @version $Revision: 1.1.1.1 $
 * @since 7.00.00
 */
public class ResourceBundleEnumeration implements Enumeration<String>
{
    Set<String> set;
    Iterator<String> iterator;
    Enumeration<String> enumeration; // may remain null

    /**
     * Constructs a resource bundle enumeration.
     *
     * @param set         an set providing some elements of the enumeration
     * @param enumeration an enumeration providing more elements of the enumeration. enumeration may be null.
     */
    public ResourceBundleEnumeration(Set<String> set, Enumeration<String> enumeration)
    {
        this.set = set;
        this.iterator = set.iterator();
        this.enumeration = enumeration;
    }

    String next;

    public boolean hasMoreElements()
    {
        if (next == null)
        {
            if (iterator.hasNext())
            {
                next = iterator.next();
            }
            else if (enumeration != null)
            {
                while (next == null && enumeration.hasMoreElements())
                {
                    next = enumeration.nextElement();
                    if (set.contains(next))
                    {
                        next = null;
                    }
                }
            }
        }
        return next != null;
    }

    public String nextElement()
    {
        if (hasMoreElements())
        {
            String result = next;
            next = null;
            return result;
        }
        else
        {
            throw new NoSuchElementException();
        }
    }
}
