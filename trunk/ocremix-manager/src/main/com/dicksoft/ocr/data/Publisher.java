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

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 * @see http://ocremix.org/publisher/id/[id]/
 */
public class Publisher {
    protected String name;
    protected int id;
    protected URL url;
    protected Set<Mix> remixes = new HashSet<Mix>();
    protected Set<Song> songs = new HashSet<Song>();
    protected Set<System> systems = new HashSet<System>();
    protected Set<Emulator> emulators = new HashSet<Emulator>();
    protected Set<Game> games = new HashSet<Game>();
}
