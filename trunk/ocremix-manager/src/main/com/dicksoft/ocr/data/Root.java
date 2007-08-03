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
import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 */
public class Root implements Serializable {
    private static final long serialVersionUID = -4755428645861211749L;
    protected Set<Composer> composers = new HashSet<Composer>();
    protected Set<Emulator> emulators = new HashSet<Emulator>();
    protected Set<Game> games = new HashSet<Game>();
    protected Set<Mix> mixes = new HashSet<Mix>();
    protected Set<Mixer> mixers = new HashSet<Mixer>();
    protected Set<Song> songs = new HashSet<Song>();
    protected Set<System> systems = new HashSet<System>();

    public void addComposer(Composer composer) {
        this.composers.add(composer);
    }

    public void addEmulator(Emulator emulator) {
        this.emulators.add(emulator);
    }

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
}
