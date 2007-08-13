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
 */
public class Root implements Serializable {
    private static final long serialVersionUID = -4755428645861211749L;
    protected Set<Composer> composers = new OCRSet<Composer>();
    protected Set<Emulator> emulators = new OCRSet<Emulator>();
    protected Set<Game> games = new OCRSet<Game>();
    protected Set<Mix> mixes = new OCRSet<Mix>();
    protected Set<Mixer> mixers = new OCRSet<Mixer>();
    protected Set<Song> songs = new OCRSet<Song>();
    protected Set<System> systems = new OCRSet<System>();

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
}
