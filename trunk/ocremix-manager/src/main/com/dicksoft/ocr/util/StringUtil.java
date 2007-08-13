/**
 * Copyright (C) 2007 Richard Taylor
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3, or (at your option)
 * any later version.
 *
 * You should have received a copy of the GNU General Public License
 * (for example /usr/src/linux/COPYING); if not, write to the Free
 * Software Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */
package com.dicksoft.ocr.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 */
public final class StringUtil {
    private static final Log LOG = LogFactory.getLog(StringUtil.class);

    private StringUtil() {
    }

    /**
     * Get the String between the first match of a and the first subsequent
     * match of b from source. For example, if the source were "a cat is walking
     * this way" and the boundaries were "a cat" and "this" then the result
     * would be " is walking ".
     * 
     * @param source
     *            the source String
     * @param a
     *            the first boundary
     * @param b
     *            the second boundary
     * @return the String between, or null if either boundary was not found in
     *         the source or if the String between was the empty String, "".
     */
    public static String getBetween(String source, String a, String b) {
        int aIndex = source.indexOf(a);
        if (aIndex == -1) {
            LOG.debug("String a, " + a
                    + " was not found in the target String, " + source);
            return null;
        }
        int bIndex = source.indexOf(b, aIndex + a.length());
        if (bIndex == -1) {
            LOG.debug("String b, " + b
                    + " was not found in the target String, " + source);
            return null;
        }

        String result = source.substring(aIndex + a.length(), bIndex);
        if (result.equals(""))
            return null;
        return result;
    }

    /**
     * Get the String following the first match of a from source. For example,
     * if the source were "a cat is walking this way" and the boundary were "a
     * cat" then the result would be " is walking this way".
     * 
     * @param source
     *            the source String
     * @param a
     *            the boundary
     * @return the suffix String, or null if the boundary was not found or if
     *         the suffix String was the empty String, "".
     */
    public static String getSuffix(String source, String a) {
        int aIndex = source.indexOf(a);
        if (aIndex == -1) {
            LOG.debug("String a, " + a
                    + " was not found in the target String, " + source);
            return null;
        }
        String result = source.substring(aIndex + a.length());
        if (result.equals(""))
            return null;
        return result;
    }

    /**
     * Get the value of the element with the specified tag in the specified XML.<br>
     * Example: <code>getElement({@literal "<tag>value</tag>"}, "tag")</code>
     * would return "value".
     * 
     * @param xml
     *            the source XML
     * @param tag
     *            the tag of the sought after element
     * @return the value of the element, or null if the element was not found or
     *         the value was empty
     */
    public static String getElement(String xml, String tag) {
        String value = getBetween(xml, "<" + tag + ">", "</" + tag + ">");
        if (value == null) {
            String t = getBetween(xml, "<" + tag, "</" + tag + ">");
            if (t == null)
                return null;
            value = getSuffix(t, ">");
        }
        return value;
    }

    /**
     * Get the value of the attribute in the specified element with the
     * specified name within the specified XML.<br>
     * Example:
     * <code>getAttribute({@literal "<tag attribute="value">foo</tag>"}, "tag", "attribute")</code>
     * would return "value".
     * 
     * @param xml
     *            the source XML
     * @param tag
     *            the tag of the element
     * @param name
     *            the name of the attribute
     * @return the value of the attribute, or null if either the element or
     *         attribute were not found or the attribute value was empty
     */
    public static String getAttribute(String xml, String tag, String name) {
        String element = getBetween(xml, "<" + tag, "/>");
        if (element == null) {
            element = getBetween(xml, "<" + tag, ">");
        }
        if (element == null) {
            return null;
        }
        return getBetween(element, name + "=\"", "\"");
    }
}
