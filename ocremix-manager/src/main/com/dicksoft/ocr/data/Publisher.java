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
package com.dicksoft.ocr.data;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import com.dicksoft.ocr.util.StringUtil;
import com.dicksoft.ocr.xml.Parseable;

/**
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 * @see http://ocremix.org/list.php?type=copyright
 * @see http://ocremix.org/publisher/id/[id]/
 */
public class Publisher extends OCRElement implements Serializable, Parseable {
    public static final String NO_EXIST_TAG = "nocopyright";
    public static final String TAG = "copyright";
    public static final String NAME_TAG = "copyrightname";
    public static final String ID_TAG = "copyrightid";
    public static final String URL_TAG = "copyrighturl";
    private static final long serialVersionUID = 1334763956983751946L;
    protected URL url;
    protected Set<Mix> remixes = new OCRSet<Mix>();
    protected Set<Song> songs = new OCRSet<Song>();
    protected Set<System> systems = new OCRSet<System>();
    protected Set<Emulator> emulators = new OCRSet<Emulator>();
    protected Set<Game> games = new OCRSet<Game>();

    /**
     * @param id
     *            the unique ID
     * @param name
     *            the name of the element; must not be null or empty
     * @param url
     *            the URL of the Publisher's website
     * @throws IllegalArgumentException
     *             if name is null or empty
     * @throws MalformedURLException
     *             if a URL could not be parsed
     */
    public Publisher(int id, String name, String url)
            throws IllegalArgumentException, MalformedURLException {
        super(id, name);
        if (url != null)
            this.url = new URL(url);
    }

    /**
     * Parse the XML for an element
     * 
     * @param xml
     *            the XML
     * @return the element if a valid one is described in the XML, null
     *         otherwise
     */
    public static Publisher parse(String xml) {
        if (Boolean.parseBoolean(StringUtil.getElement(xml, NO_EXIST_TAG)))
            return null;
        String element = StringUtil.getElement(xml, TAG);
        try {
            return new Publisher(Integer.parseInt(StringUtil.getElement(
                    element, ID_TAG)),
                    StringUtil.getElement(element, NAME_TAG), StringUtil
                            .getElement(element, URL_TAG));
        } catch (MalformedURLException e) {
            return null;
        } catch (NumberFormatException e) {
            return null;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /**
     * @return the URL of the page that describes the list of this element
     */
    public static String listUrl() {
        return OCREMIX_URL + "/list.php?type=copyright";
    }

    /**
     * @param id
     *            the ID of the element
     * @return the URL of the XML that describes the element with the specified
     *         ID
     */
    public static String elementUrl(int id) {
        return OCREMIX_URL + "/publisher/id/" + id + "/" + XML_STYLE;
    }
}
