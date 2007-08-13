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
 * @see http://ocremix.org/songs/
 * @see http://ocremix.org/song/id/[id]/
 */
public class Song extends OCRElement implements Serializable {
    private static final long serialVersionUID = 7688386478808844299L;
    protected Game game;
    protected Publisher copyright;
    protected System system;
    protected Set<Composer> composers = new OCRSet<Composer>();
    protected Set<Mix> mixes = new OCRSet<Mix>();
}
