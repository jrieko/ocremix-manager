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

import com.dicksoft.ocr.xml.Parser;

/**
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 */
public class Root implements Serializable {
    private static final long serialVersionUID = -4755428645861211749L;
    protected OCRSet<Composer> composers =
            new OCRSet<Composer>(Parser.parseSize(Composer.listUrl()));
    protected OCRSet<Emulator> emulators =
            new OCRSet<Emulator>(Parser.parseSize(Emulator.listUrl()));
    protected OCRSet<Game> games = new OCRSet<Game>();// (Parser.parseSize(Game.listUrl()));
    protected OCRSet<Mix> mixes = new OCRSet<Mix>();// (Parser.parseSize(Mix.listUrl()));
    protected OCRSet<Mixer> mixers = new OCRSet<Mixer>();// (Parser.parseSize(Mixer.listUrl()));
    protected OCRSet<Song> songs = new OCRSet<Song>();// (Parser.parseSize(Song.listUrl()));
    protected OCRSet<System> systems = new OCRSet<System>();// (Parser.parseSize(System.listUrl()));
    protected OCRSet<Publisher> publishers =
            new OCRSet<Publisher>(Parser.parseSize(Publisher.listUrl()));

    /**
     * @return the composers
     */
    public Set<Composer> getComposers() {
        return this.composers;
    }

    /**
     * @return the emulators
     */
    public Set<Emulator> getEmulators() {
        return this.emulators;
    }

    /**
     * @return the games
     */
    public Set<Game> getGames() {
        return this.games;
    }

    /**
     * @return the mixers
     */
    public Set<Mixer> getMixers() {
        return this.mixers;
    }

    /**
     * @return the mixes
     */
    public Set<Mix> getMixes() {
        return this.mixes;
    }

    /**
     * @return the songs
     */
    public Set<Song> getSongs() {
        return this.songs;
    }

    /**
     * @return the systems
     */
    public Set<System> getSystems() {
        return this.systems;
    }

    /**
     * @return the publishers
     */
    public Set<Publisher> getPublishers() {
        return this.publishers;
    }
}
