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
package com.dicksoft.ocr.xml;

/**
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 */
public interface Parseable {
    public static final String OCREMIX_URL = "http://ocremix.org";
    public static final String XML_STYLE = "?style=xml";
    public static final String LIST_URL_METHOD = "listUrl";
    public static final String ELEMENT_URL_METHOD = "elementUrl";

    // The following method should also be implemented. However, this cannot be
    // enforced as java interfaces don't allow static methods. The honor system
    // will have to do for now.

    // public static <T extends OCRElement> T parse(Root root, String xml);
    // public static String listURL();
    // public static String elementUrl(int id);
}
