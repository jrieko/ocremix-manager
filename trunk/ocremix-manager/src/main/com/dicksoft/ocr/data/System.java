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
import java.net.URL;
import java.util.Set;

/**
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 * @see http://ocremix.org/systems/
 * @see http://ocremix.org/system/[urlName]/
 */
public class System extends OCRElement implements Serializable {
    private static final long serialVersionUID = 9145563592660998914L;

    /**
     * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
     */
    public enum Type {
        ARCADE("Arcade"),
        CONSOLE("Console"),
        COMPUTER("Computer"),
        HANDHELD("Handheld");
        private String name;

        private Type(String name) {
            this.name = name;
        }

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }
    }

    protected String urlName;
    protected Type type;
    protected String screenshotFile;
    protected String iconFile;
    protected Publisher copyright;
    protected Set<Emulator> emulators = new OCRSet<Emulator>();
    protected Set<Mix> mixes = new OCRSet<Mix>();
    protected Set<Song> songs = new OCRSet<Song>();
    protected Set<Game> games = new OCRSet<Game>();
    protected URL urlMoby;
    protected URL urlVGMusic;
    protected URL urlWiki;

    /**
     * @param id
     * @param name
     * @param urlName
     * @param type
     * @param screenshotFile
     * @param iconFile
     * @param urlMoby
     * @param urlVGMusic
     * @param urlWiki
     * @throws IllegalArgumentException
     */
    public System(int id, String name, String urlName, Type type,
            String screenshotFile, String iconFile, URL urlMoby,
            URL urlVGMusic, URL urlWiki) throws IllegalArgumentException {
        super(id, name);
        this.urlName = urlName;
        this.type = type;
        this.screenshotFile = screenshotFile;
        this.iconFile = iconFile;
        this.urlMoby = urlMoby;
        this.urlVGMusic = urlVGMusic;
        this.urlWiki = urlWiki;
    }

}
