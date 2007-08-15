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

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dicksoft.ocr.util.HttpUtil;
import com.dicksoft.ocr.util.StringUtil;
import com.dicksoft.ocr.xml.Parseable;
import com.dicksoft.ocr.xml.Parser;

/**
 * TODO The emulator detail page is broken (both html and xml), so we must parse
 * the html listing page for now; change to regular xml detail parsing once it's
 * fixed
 * 
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 * @see http://ocremix.org/emulators/
 * @see http://ocremix.org/emulator/id/[id]/
 */
public class Emulator extends OCRElement implements Serializable, Parseable {
    public static final String NO_EXIST_TAG = "";
    public static final String TAG = "";
    public static final String ID_TAG = "";
    public static final String NAME_TAG = "";
    public static final String URL_TAG = "";
    public static final String SYSTEM_TAG = "";
    public static final String BEST_BET_TAG = "";
    public static final String COPYRIGHT_TAG = "";
    public static final String PLATFORMS_TAG = "";
    private static final long serialVersionUID = 1L;
    private static final Log LOG = LogFactory.getLog(Emulator.class);

    public enum Platform {
        DOS("MSDOS", "ocr4_icon_small_pdos.gif"),
        LINUX("Linux", "ocr4_icon_small_plinux.gif"),
        MAC("Macintosh", "ocr4_icon_small_pmac.gif"),
        WINDOWS("Windows", "ocr4_icon_small_pwin32.gif");
        private String name;
        private String iconFile;

        private Platform(String name, String iconFile) {
            this.name = name;
            this.iconFile = iconFile;
        }

        /**
         * @return the iconFile
         */
        public String getIconFile() {
            return this.iconFile;
        }

        /**
         * @return the name
         */
        public String getName() {
            return this.name;
        }
    }

    protected URL url;
    protected System system;
    protected boolean bestBet;
    protected Publisher copyright;
    protected Set<Platform> platforms = new OCRSet<Platform>();

    public Emulator(int id, String name, String url, boolean bestBet)
            throws MalformedURLException {
        super(id, name);
        if (url != null)
            this.url = new URL(url);
        this.bestBet = bestBet;
    }

    /**
     * Parse the XML for an element. The detail pages for emulators are proken
     * for now, so this won't work. Use parseListing() until it's fixed.
     * 
     * @param xml
     *            the XML
     * @return the element if a valid one is described in the XML, null
     *         otherwise
     */
    public static Emulator parse(String xml) {
        if (Boolean.parseBoolean(StringUtil.getElement(xml, NO_EXIST_TAG)))
            return null;
        String element = StringUtil.getElement(xml, TAG);
        try {
            return new Emulator(Integer.parseInt(StringUtil.getElement(element,
                    ID_TAG)), StringUtil.getElement(element, NAME_TAG),
                    StringUtil.getElement(element, URL_TAG), Boolean
                            .parseBoolean(StringUtil.getElement(element,
                                    BEST_BET_TAG)));
        } catch (MalformedURLException e) {
            return null;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public static Set<Emulator> parseListing() {
        int size = Parser.parseSize("http://ocremix.org/emulators/");
        OCRSet<Emulator> result = new OCRSet<Emulator>(size);
        String html = null;
        for (int i = 0; i < size; i += 100) {
            try {
                html =
                        HttpUtil
                                .fetchText("http://ocremix.org/emulators/?offset="
                                        + i + "&limit=100&sort=emuasc");
            } catch (IOException e) {
                LOG.debug("Couldn't read page offset " + i);
                continue;
            }
            String[] rows = StringUtil.getElements(html, "tr");
            for (String row : rows) {
                String[] columns = StringUtil.getElements(row, "td");
                if (columns[0].contains("<a href=\"/detailemulator.php")) {
                    try {
                        result.add(new Emulator(Integer.parseInt(StringUtil
                                .getSuffix(StringUtil.getAttribute(columns[0],
                                        "a", "href"), "emuid=")), StringUtil
                                .getElement(columns[0], "a"), StringUtil
                                .getAttribute(columns[2], "a", "href"),
                                columns[1] == null));
                    } catch (NumberFormatException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (MalformedURLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    // TODO
                }
            }
        }
        return result;
    }

    /**
     * @return the URL of the page that describes the list of this element
     */
    public static String listUrl() {
        return OCREMIX_URL + "/emulators/";
    }

    /**
     * @param id
     *            the ID of the element
     * @return the URL of the XML that describes the element with the specified
     *         ID
     */
    public static String elementUrl(int id) {
        return OCREMIX_URL + "/emulator/id/" + id + "/" + XML_STYLE;
    }

    /**
     * @return the bestBet
     */
    public boolean isBestBet() {
        return this.bestBet;
    }

    /**
     * @return the copyright
     */
    public Publisher getCopyright() {
        return this.copyright;
    }

    /**
     * @return the platforms
     */
    public Set<Platform> getPlatforms() {
        return this.platforms;
    }

    /**
     * @return the system
     */
    public System getSystem() {
        return this.system;
    }

    /**
     * @return the url
     */
    public URL getUrl() {
        return this.url;
    }
}
