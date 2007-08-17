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
import java.util.List;

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
    protected OCRSet<Mix> mixes = new OCRSet<Mix>();

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
    public Mixer(Root root, int id, String name, String imageFile,
            String realName, String urlName, URL url, URL urlBrainz,
            String email, int forumId) throws IllegalArgumentException {
        super(root, id, name);
        this.imageFile = imageFile;
        this.realName = realName;
        this.urlName = urlName;
        this.url = url;
        this.urlBrainz = urlBrainz;
        this.email = email;
        this.forumId = forumId;
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
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @return the forumId
     */
    public int getForumId() {
        return this.forumId;
    }

    /**
     * @return the imageFile
     */
    public String getImageFile() {
        return this.imageFile;
    }

    /**
     * @return the realName
     */
    public String getRealName() {
        return this.realName;
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
     * @return the urlName
     */
    public String getUrlName() {
        return this.urlName;
    }
}
