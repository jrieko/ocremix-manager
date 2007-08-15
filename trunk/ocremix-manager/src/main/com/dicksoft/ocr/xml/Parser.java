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

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dicksoft.ocr.data.Composer;
import com.dicksoft.ocr.data.Emulator;
import com.dicksoft.ocr.data.Root;
import com.dicksoft.ocr.util.HttpUtil;
import com.dicksoft.ocr.util.StringUtil;

/**
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 */
public class Parser {
    // public static final String OCREMIX_URL = "http://ocremix.org";
    // public static final String XML_STYLE = "?style=xml";
    // public static final String COMPOSERS_URL = OCREMIX_URL + "/composers/";
    // public static final String EMULATORS_URL = OCREMIX_URL + "/emulators/";
    // public static final String GAMES_URL = OCREMIX_URL + "/games/";
    // public static final String MIXES_URL = OCREMIX_URL + "/remixes/";
    // public static final String MIXERS_URL = OCREMIX_URL + "/mixers/";
    // public static final String PUBLISHERS_URL =
    // OCREMIX_URL + "/list.php?type=copyright";
    // public static final String SONGS_URL = OCREMIX_URL + "/songs/";
    // public static final String SYSTEMS_URL = OCREMIX_URL + "/systems/";
    private static final Log LOG = LogFactory.getLog(Parser.class);

    /**
     * Download and parse the full data map. This should be used sparingly as
     * it's resource-heavy.
     * 
     * @param root
     *            the root of the data map
     * @throws NotParseableException
     *             if the contract of Parseable is breached
     */
    public static void parse(Root root) throws NotParseableException {
        parse(Composer.class, root.getComposers());
        parse(Emulator.class, root.getEmulators());
        // parse(Game.class, root.getGames());
        // parse(Mix.class, root.getMixes());
        // parse(Mixer.class, root.getMixers());
        // parse(Song.class, root.getSongs());
        // parse(System.class, root.getSystems());
    }

    /**
     * Download and parse the specified data set.
     * 
     * @param <T>
     * @param clazz
     *            the Class of the type to be parsed
     * @param elements
     *            the set of elements to add parsed data to
     * @throws NotParseableException
     *             if the contract of Parseable is breached
     */
    public static <T extends Parseable> void parse(Class<T> clazz,
            Set<T> elements) throws NotParseableException {
        int numElements = 0;
        try {
            numElements =
                    parseSize((String) clazz.getMethod(
                            Parseable.LIST_URL_METHOD, new Class[0]).invoke(
                            null, new Object[0]));
            for (int i = 0; i < numElements; i++) {
                String xml = null;
                try {
                    xml =
                            HttpUtil.fetchText((String) clazz.getMethod(
                                    Parseable.ELEMENT_URL_METHOD,
                                    new Class[] { Integer.TYPE }).invoke(null,
                                    new Object[] { i }));
                } catch (IOException e) {
                    LOG.debug("Composer with ID " + i + "was not found.");
                    continue;
                }
                elements.add(clazz.cast(clazz.getMethod("parse",
                        new Class[] { String.class }).invoke(null,
                        new Object[] { xml })));
            }
        } catch (IllegalArgumentException e) {
            throw new NotParseableException(e);
        } catch (SecurityException e) {
            throw new NotParseableException(e);
        } catch (IllegalAccessException e) {
            throw new NotParseableException(e);
        } catch (InvocationTargetException e) {
            throw new NotParseableException(e);
        } catch (NoSuchMethodException e) {
            throw new NotParseableException(e);
        }
    }

    // public static void parseComposers(Set<Composer> composers) {
    // int numComposers = parseSize(COMPOSERS_URL);
    // for (int i = 0; i < numComposers; i++) {
    // String xml = null;
    // try {
    // xml = HttpUtil.fetchText(composerURL(i));
    // } catch (IOException e) {
    // LOG.debug("Composer with ID " + i + "was not found.");
    // continue;
    // }
    // composers.add(Composer.parse(xml));
    // }
    // }
    //
    // public static void parseEmulators(Set<Emulator> emulators) {
    // int numEmulators = parseSize(COMPOSERS_URL);
    // for (int i = 0; i < numComposers; i++) {
    // String xml = null;
    // try {
    // xml = HttpUtil.fetchText(composerURL(i));
    // } catch (IOException e) {
    // LOG.debug("Composer with ID " + i + "was not found.");
    // continue;
    // }
    // composers.add(Composer.parse(xml));
    // }
    // }
    //
    // public static void parseGames(Set<Game> games) {
    // }
    //
    // public static void parseMixes(Set<Mix> mixes) {
    // }
    //
    // public static void parseMixers(Set<Mixer> mixers) {
    // }
    //
    // public static void parseSongs(Set<Song> songs) {
    // }
    //
    // public static void parseSystems(Set<System> systems) {
    // }
    //
    // public static String composerURL(int id) {
    // return OCREMIX_URL + "/composer/id/" + id + "/" + XML_STYLE;
    // }
    //
    // public static String emulatorURL(int id) {
    // return OCREMIX_URL + "/emulator/id/" + id + "/" + XML_STYLE;
    // }
    //
    // public static String gameURL(int id) {
    // return OCREMIX_URL + "/game/id/" + id + "/" + XML_STYLE;
    // }
    //
    // public static String mixURL(int id) {
    // return OCREMIX_URL + "/remix/id/OCR" + String.format("%1$05d", id)
    // + "/" + XML_STYLE;
    // }
    //
    // public static String mixerURL(int id) {
    // return OCREMIX_URL + "/remixer/id/" + id + "/" + XML_STYLE;
    // }
    //
    // public static String publisherURL(int id) {
    // return OCREMIX_URL + "/publisher/id/" + id + "/" + XML_STYLE;
    // }
    //
    // public static String songURL(int id) {
    // return OCREMIX_URL + "/song/id/" + id + "/" + XML_STYLE;
    // }
    //
    // public static String systemURL(int id) {
    // return OCREMIX_URL + "/system/id/" + id + "/" + XML_STYLE;
    // }

    /**
     * Get the size of the list described in the page given by the URL.
     * 
     * @param url
     *            the URL of the page that lists the elements
     * @return the size of the list
     */
    public static int parseSize(String url) {
        try {
            return Integer.parseInt(StringUtil.getBetween(StringUtil
                    .getElement(HttpUtil.fetchText(url
                            + (url.contains("?") ? "&limit=20" : "?limit=20")),
                            "title"), "(", ")"));
        } catch (IOException e) {
            LOG.error("parseSize():", e);
            return -1;
        }
    }
}
