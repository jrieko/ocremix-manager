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
     * Get the String between the first match of a and a subsequent b from
     * source. For example, if the source were "a cat is walking this way" and
     * the boundaries were "a cat" and "this" then the result would be " is
     * walking ".
     * 
     * @param source
     *            the source String
     * @param a
     *            the first boundary
     * @param b
     *            the second boundary
     * @return the String between, or null if either boundary was not found in
     *         the source
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

        return source.substring(aIndex + a.length(), bIndex);
    }
}
