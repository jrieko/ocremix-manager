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
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dicksoft.ocr.data.Composer;
import com.dicksoft.ocr.data.Emulator;
import com.dicksoft.ocr.data.Game;
import com.dicksoft.ocr.data.Mix;
import com.dicksoft.ocr.data.Mixer;
import com.dicksoft.ocr.data.Root;
import com.dicksoft.ocr.data.Song;
import com.dicksoft.ocr.data.System;
import com.dicksoft.ocr.util.HttpUtil;
import com.dicksoft.ocr.util.StringUtil;

/**
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 */
public class Parser {
    public static final String XML_STYLE = "?style=xml";
    public static final String OCREMIX_URL = "http://ocremix.org";
    public static final String COMPOSERS_URL = OCREMIX_URL + "/composers/";
    public static final String EMULATORS_URL = OCREMIX_URL + "/emulators/";
    public static final String GAMES_URL = OCREMIX_URL + "/games/";
    public static final String MIXES_URL = OCREMIX_URL + "/remixes/";
    public static final String MIXERS_URL = OCREMIX_URL + "/";
    public static final String PUBLISHERS_URL = OCREMIX_URL + "/";
    public static final String SONGS_URL = OCREMIX_URL + "/";
    public static final String SYSTEMS_URL = OCREMIX_URL + "/";
    private static final Log LOG = LogFactory.getLog(Parser.class);

    public static void parse(Root root) {
        parseComposers(root.getComposers());
        parseEmulators(root.getEmulators());
        parseGames(root.getGames());
        parseMixes(root.getMixes());
        parseMixers(root.getMixers());
        parseSongs(root.getSongs());
        parseSystems(root.getSystems());
    }

    public static void parseComposers(Set<Composer> composers) {
        int numComposers = 0;
        try {
            numComposers =
                    Integer.parseInt(StringUtil.getBetween(HttpUtil
                            .fetchText(COMPOSERS_URL), "Listing: Composers (",
                            ")"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < numComposers; i++) {
            String xml = null;
            try {
                xml = HttpUtil.fetchText(composerURL(i));
            } catch (IOException e) {
                LOG.debug("Composer with ID " + i + "was not found.");
                continue;
            }
            Composer composer = Composer.parse(xml);
            composers.add(composer);
        }
    }

    public static void parseEmulators(Set<Emulator> emulators) {

        // TODO
    }

    public static void parseGames(Set<Game> games) {
        // TODO
    }

    public static void parseMixes(Set<Mix> mixes) {
        // TODO
    }

    public static void parseMixers(Set<Mixer> mixers) {
        // TODO
    }

    public static void parseSongs(Set<Song> songs) {
        // TODO
    }

    public static void parseSystems(Set<System> systems) {
        // TODO
    }

    public static String composerURL(int id) {
        return OCREMIX_URL + "/composer/id/" + id + "/" + XML_STYLE;
    }

    public static String emulatorURL(int id) {
        return OCREMIX_URL + "/emulator/id/" + id + "/" + XML_STYLE;
    }

    public static String gameURL(int id) {
        return OCREMIX_URL + "/game/id/" + id + "/" + XML_STYLE;
    }

    public static String mixURL(int id) {
        return OCREMIX_URL + "/remix/id/OCR" + String.format("%1$05d", id)
                + "/" + XML_STYLE;
    }

    public static String mixerURL(int id) {
        return OCREMIX_URL + "/remixer/id/" + id + "/" + XML_STYLE;
    }

    public static String publisherURL(int id) {
        return OCREMIX_URL + "/publisher/id/" + id + "/" + XML_STYLE;
    }

    public static String songURL(int id) {
        return OCREMIX_URL + "/song/id/" + id + "/" + XML_STYLE;
    }

    public static String systemURL(int id) {
        return OCREMIX_URL + "/" + id + "/" + XML_STYLE;
    }
}
