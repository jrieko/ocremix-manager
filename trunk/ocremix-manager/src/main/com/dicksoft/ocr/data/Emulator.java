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
import com.dicksoft.ocr.xml.NotParseableException;
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
        DOS("DOS", "ocr4_icon_small_pdos.gif"),
        LINUX("Linux", "ocr4_icon_small_plinux.gif"),
        MACINTOSH("Macintosh", "ocr4_icon_small_pmac.gif"),
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

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return this.getName();
        }
    }

    protected URL url;
    protected System system;
    protected boolean bestBet;
    protected Publisher copyright;
    protected Set<Platform> platforms = new OCRSet<Platform>();

    public Emulator(Root root, int id, String name, String url,
            boolean bestBet, Set<Platform> platforms)
            throws MalformedURLException {
        super(root, id, name);
        if (url != null)
            this.url = new URL(url);
        this.bestBet = bestBet;
        this.platforms = platforms;
    }

    /**
     * Parse the XML for an element. The detail pages for emulators are broken
     * for now, so this won't work. Use parseListing() until it's fixed.
     * 
     * @param xml
     *            the XML
     * @return the element if a valid one is described in the XML, null
     *         otherwise
     */
    public static Emulator parse(Root root, String xml) {
        if (Boolean.parseBoolean(StringUtil.getElement(xml, NO_EXIST_TAG)))
            return null;
        String element = StringUtil.getElement(xml, TAG);
        try {
            return new Emulator(root, Integer.parseInt(StringUtil.getElement(
                    element, ID_TAG)),
                    StringUtil.getElement(element, NAME_TAG), StringUtil
                            .getElement(element, URL_TAG), Boolean
                            .parseBoolean(StringUtil.getElement(element,
                                    BEST_BET_TAG)), null);
        } catch (MalformedURLException e) {
            return null;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /**
     * Temporary hack to accomodate the site's broken emulator detail pages.
     * 
     * @param root
     *            the Root
     * @return the parsed Emulators
     * @throws NotParseableException
     *             if a parsing error occurred
     */
    public static Set<Emulator> parseListing(Root root)
            throws NotParseableException {
        int size = Parser.parseSize("http://ocremix.org/emulators/");
        LOG.debug("parseListing() size=" + size);
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
            LOG.debug("parseListing() numRows=" + rows.length);
            for (String row : rows) {
                String[] columns = StringUtil.getElements(row, "td");
                if (columns.length == 0)
                    continue;
                if (columns[0].contains("<a href=\"/detailemulator.php")) {
                    OCRSet<Platform> platforms = new OCRSet<Platform>(4);
                    for (int j = 3; j < 7; j++) {
                        if (columns[j] != null)
                            platforms.add(Platform.valueOf(StringUtil
                                    .getAttribute(columns[j], "img", "alt")
                                    .toUpperCase()));
                    }
                    try {
                        result.add(new Emulator(root, Integer
                                .parseInt(StringUtil.getSuffix(StringUtil
                                        .getAttribute(columns[0], "a", "href"),
                                        "emuid=")), StringUtil.getElement(
                                columns[0], "a"), StringUtil.getAttribute(
                                columns[2], "a", "href"), columns[1] == null,
                                platforms));
                    } catch (NumberFormatException e) {
                        throw new NotParseableException(e);
                    } catch (MalformedURLException e) {
                        throw new NotParseableException(e);
                    }
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
     * @param system
     *            the system to set
     */
    public void setSystem(System system) {
        this.system = this.root.systems.tryAdd(system);
        // TODO
    }

    /**
     * @param copyright
     *            the copyright to set
     */
    public void setCopyright(Publisher copyright) {
        this.copyright = this.root.publishers.tryAdd(copyright);
    }

    /**
     * @return the url
     */
    public URL getUrl() {
        return this.url;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.getId() + ": name=" + this.getName() + " URL="
                + this.getUrl() + " platforms=" + this.getPlatforms()
                + " system=" + this.getSystem() + " copyright="
                + this.getCopyright();
    }
}
