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
import java.util.HashSet;
import java.util.Set;

import com.dicksoft.ocr.xml.Parsable;

/**
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 * @see http://ocremix.org/composers/
 * @see http://ocremix.org/composer/id/[id]/
 */
public class Composer extends OCRElement implements Serializable, Parsable {
    private static final long serialVersionUID = 7766261829995228374L;
    protected int id;
    protected String name;
    protected String imageFile;
    protected URL url;
    protected URL urlMoby;
    protected URL urlBrainz;
    protected URL urlWiki;
    protected Set<Mix> mixes = new HashSet<Mix>();
    protected Set<Song> songs = new HashSet<Song>();
    protected Set<Game> games = new HashSet<Game>();

    public Composer(int id, String name, String imageFile) {
        this.id = id;
        this.name = name;
        this.imageFile = imageFile;
    }

    /**
     * @return the games
     */
    public Set<Game> getGames() {
        return this.games;
    }

    /**
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * @return the imageFile
     */
    public String getImageFile() {
        return this.imageFile;
    }

    /**
     * @return the mixes
     */
    public Set<Mix> getMixes() {
        return this.mixes;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the songs
     */
    public Set<Song> getSongs() {
        return this.songs;
    }

    /**
     * @return the url
     */
    public URL getUrl() {
        return this.url;
    }

    /**
     * @return the urlBrainz
     */
    public URL getUrlBrainz() {
        return this.urlBrainz;
    }

    /**
     * @return the urlMoby
     */
    public URL getUrlMoby() {
        return this.urlMoby;
    }

    /**
     * @return the urlWiki
     */
    public URL getUrlWiki() {
        return this.urlWiki;
    }

    /* (non-Javadoc)
     * @see com.dicksoft.ocr.xml.Parsable#parse(java.lang.String)
     */
    public <T extends OCRElement> T parse(String xml) {
        //TODO
    }
}
