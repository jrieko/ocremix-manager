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
import java.util.Set;

/**
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 * @see http://ocremix.org/remixers/
 * @see http://ocremix.org/remixer/[urlName]/
 */
public class Mixer extends OCRElement implements Serializable {
    private static final long serialVersionUID = 180055796751326196L;
    protected String imageFile;
    protected String realName;
    protected String urlName;
    protected URL url;
    protected URL urlBrainz;
    protected String email;
    protected int forumId;
    protected Set<Mix> mixes = new OCRSet<Mix>();
    /**
     * @param id
     * @param name
     * @param imageFile
     * @param realName
     * @param urlName
     * @param url
     * @param urlBrainz
     * @param email
     * @param forumId
     * @throws IllegalArgumentException
     */
    public Mixer(int id, String name, String imageFile, String realName, String urlName, URL url, URL urlBrainz, String email, int forumId) throws IllegalArgumentException {
        super(id, name);
        this.imageFile = imageFile;
        this.realName = realName;
        this.urlName = urlName;
        this.url = url;
        this.urlBrainz = urlBrainz;
        this.email = email;
        this.forumId = forumId;
    }
}
