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
import java.util.List;

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
    protected OCRSet<Emulator> emulators = new OCRSet<Emulator>();
    protected OCRSet<Mix> mixes = new OCRSet<Mix>();
    protected OCRSet<Song> songs = new OCRSet<Song>();
    protected OCRSet<Game> games = new OCRSet<Game>();
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
    public System(Root root, int id, String name, String urlName, Type type,
            String screenshotFile, String iconFile, URL urlMoby,
            URL urlVGMusic, URL urlWiki) throws IllegalArgumentException {
        super(root, id, name);
        this.urlName = urlName;
        this.type = type;
        this.screenshotFile = screenshotFile;
        this.iconFile = iconFile;
        this.urlMoby = urlMoby;
        this.urlVGMusic = urlVGMusic;
        this.urlWiki = urlWiki;
    }

    /**
     * @return the copyright
     */
    public Publisher getCopyright() {
        return this.copyright;
    }

    /**
     * @param copyright
     *            the copyright to set
     */
    public void setCopyright(Publisher copyright) {
        this.copyright = this.root.publishers.tryAdd(copyright);
    }

    /**
     * @return the emulators
     */
    public List<Emulator> getEmulators() {
        return this.emulators.toList();
    }

    /**
     * @param emulators
     *            the emulators to set
     */
    public void addEmulator(Emulator emulator) {
        this.emulators.add(this.root.emulators.tryAdd(emulator));
    }

    /**
     * @return the games
     */
    public List<Game> getGames() {
        return this.games.toList();
    }

    /**
     * @param games
     *            the games to set
     */
    public void addGame(Game game) {
        this.games.add(this.root.games.tryAdd(game));
    }

    /**
     * @return the mixes
     */
    public List<Mix> getMixes() {
        return this.mixes.toList();
    }

    /**
     * @param mixes
     *            the mixes to set
     */
    public void addMix(Mix mix) {
        this.mixes.add(this.root.mixes.tryAdd(mix));
    }

    /**
     * @return the songs
     */
    public List<Song> getSongs() {
        return this.songs.toList();
    }

    /**
     * @param songs
     *            the songs to set
     */
    public void addSong(Song song) {
        this.songs.add(this.root.songs.tryAdd(song));
    }

    /**
     * @return the iconFile
     */
    public String getIconFile() {
        return this.iconFile;
    }

    /**
     * @return the screenshotFile
     */
    public String getScreenshotFile() {
        return this.screenshotFile;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return this.type;
    }

    /**
     * @return the urlMoby
     */
    public URL getUrlMoby() {
        return this.urlMoby;
    }

    /**
     * @return the urlName
     */
    public String getUrlName() {
        return this.urlName;
    }

    /**
     * @return the urlVGMusic
     */
    public URL getUrlVGMusic() {
        return this.urlVGMusic;
    }

    /**
     * @return the urlWiki
     */
    public URL getUrlWiki() {
        return this.urlWiki;
    }

}
