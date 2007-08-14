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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import com.dicksoft.ocr.xml.Parseable;

/**
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 * @see http://ocremix.org/emulators/
 * @see http://ocremix.org/emulator/id/[id]/
 */
public class Emulator extends OCRElement implements Serializable, Parseable {
    private static final long serialVersionUID = 1L;

    public enum Platform {
        DOS("MSDOS", "ocr4_icon_small_pdos.gif"),
        LINUX("Linux", "ocr4_icon_small_plinux.gif"),
        MAC("Macintosh", "ocr4_icon_small_pmac.gif"),
        WINDOWS("Windows", "ocr4_icon_small_pwin32.gif");
        private String name;
        private String iconFile;

        private Platform(String name, String iconFile) {
            this.name = name;
            this.iconFile = iconFile;
        }

        /**
         * @return the iconFile
         */
        public String getIconFile() {
            return this.iconFile;
        }

        /**
         * @return the name
         */
        public String getName() {
            return this.name;
        }
    }

    protected URL url;
    protected System system;
    protected boolean bestBet;
    protected Publisher copyright;
    protected Set<Platform> platforms = new OCRSet<Platform>();

    public Emulator(int id, String name, String url, boolean bestBet)
            throws MalformedURLException {
        super(id, name);
        if (url != null)
            this.url = new URL(url);
        this.bestBet = bestBet;
    }
}
