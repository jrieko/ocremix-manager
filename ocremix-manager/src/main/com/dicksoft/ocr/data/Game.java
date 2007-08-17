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
import java.util.List;

/**
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 * @see http://ocremix.org/games/
 * @see http://ocremix.org/game/[urlName]/
 */
public class Game extends OCRElement implements Serializable {
    private static final long serialVersionUID = -2841719747816951953L;
    protected String urlName;
    protected int year;
    protected String screenshotFile;
    protected String soundtrackFile;
    protected int soundtrackFileSize;
    protected String soundtrackFileExt;
    protected Publisher copyright;
    protected System system;
    protected OCRSet<Composer> composers = new OCRSet<Composer>();
    protected OCRSet<Mix> mixes = new OCRSet<Mix>();
    protected OCRSet<Song> songs = new OCRSet<Song>();

    /**
     * @param id
     *            the unique ID
     * @param name
     *            the name of the element; must not be null or empty
     * @param urlName
     *            the name of the game as used in a URL
     * @param year
     *            the release year
     * @param screenshotFile
     * @param soundtrackFile
     * @param soundtrackFileSize
     * @param soundtrackFileExt
     * @throws IllegalArgumentException
     *             if name is null or empty
     */
    public Game(Root root, int id, String name, String urlName, int year,
            String screenshotFile, String soundtrackFile,
            int soundtrackFileSize, String soundtrackFileExt)
            throws IllegalArgumentException {
        super(root, id, name);
        this.urlName = urlName;
        this.year = year;
        this.screenshotFile = screenshotFile;
        this.soundtrackFile = soundtrackFile;
        this.soundtrackFileSize = soundtrackFileSize;
        this.soundtrackFileExt = soundtrackFileExt;
    }

    /**
     * @return the composers
     */
    public List<Composer> getComposers() {
        return this.composers.toList();
    }

    /**
     * @param composers
     *            the composers to set
     */
    public void addComposer(Composer composer) {
        this.composers.add(this.root.composers.tryAdd(composer));
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
    }

    /**
     * @return the screenshotFile
     */
    public String getScreenshotFile() {
        return this.screenshotFile;
    }

    /**
     * @return the soundtrackFile
     */
    public String getSoundtrackFile() {
        return this.soundtrackFile;
    }

    /**
     * @return the soundtrackFileExt
     */
    public String getSoundtrackFileExt() {
        return this.soundtrackFileExt;
    }

    /**
     * @return the soundtrackFileSize
     */
    public int getSoundtrackFileSize() {
        return this.soundtrackFileSize;
    }

    /**
     * @return the urlName
     */
    public String getUrlName() {
        return this.urlName;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return this.year;
    }
}
