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
import java.util.Set;

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
    protected Set<Composer> composers = new OCRSet<Composer>();
    protected Set<Mix> mixes = new OCRSet<Mix>();
    protected Set<Song> songs = new OCRSet<Song>();

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
    public Game(int id, String name, String urlName, int year,
            String screenshotFile, String soundtrackFile,
            int soundtrackFileSize, String soundtrackFileExt)
            throws IllegalArgumentException {
        super(id, name);
        this.urlName = urlName;
        this.year = year;
        this.screenshotFile = screenshotFile;
        this.soundtrackFile = soundtrackFile;
        this.soundtrackFileSize = soundtrackFileSize;
        this.soundtrackFileExt = soundtrackFileExt;
    }
}
