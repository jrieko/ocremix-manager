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

import com.dicksoft.ocr.util.StringUtil;
import com.dicksoft.ocr.xml.Parseable;

/**
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 * @see http://ocremix.org/composers/
 * @see http://ocremix.org/composer/id/[id]/
 */
public class Composer extends OCRElement implements Serializable, Parseable {
    public static final String NO_EXIST_TAG = "nocomposer";
    public static final String TAG = "composer";
    public static final String ID_TAG = "composerid";
    public static final String NAME_TAG = "composername";
    public static final String IMAGE_FILE_TAG = "composerimagefile";
    public static final String URL_TAG = "composerurl";
    public static final String URL_MOBY_TAG = "composerurl_moby";
    public static final String URL_BRAINZ_TAG = "composerurl_brainz";
    public static final String URL_WIKI_TAG = "composerurl_wiki";
    private static final long serialVersionUID = 7766261829995228374L;
    protected String imageFile;
    protected URL url;
    protected URL urlMoby;
    protected URL urlBrainz;
    protected URL urlWiki;
    protected Set<Mix> mixes = new OCRSet<Mix>();
    protected Set<Song> songs = new OCRSet<Song>();
    protected Set<Game> games = new OCRSet<Game>();

    /**
     * @param id
     *            the unique ID
     * @param name
     *            the name of the element; must not be null or empty
     * @param imageFile
     *            the filename of the image associated with the composer
     * @param url
     *            the URL of the composer's site
     * @param urlMoby
     *            the URL of the composer's Moby page
     * @param urlBrainz
     *            the URL of the composer's Brainz page
     * @param urlWiki
     *            the URL of the composer's Wikipedia page
     * @throws MalformedURLException
     *             if a URL could not be parsed
     * @throws IllegalArgumentException
     *             if name is null or empty
     */
    public Composer(int id, String name, String imageFile, String url,
            String urlMoby, String urlBrainz, String urlWiki)
            throws MalformedURLException {
        super(id, name);
        this.imageFile = imageFile;
        if (url != null)
            this.url = new URL(url);
        if (urlMoby != null)
            this.urlMoby = new URL(urlMoby);
        if (urlBrainz != null)
            this.urlBrainz = new URL(urlBrainz);
        if (urlWiki != null)
            this.urlWiki = new URL(urlWiki);
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

    /**
     * Parse the XML for an element
     * 
     * @param xml
     *            the XML
     * @return the element if a valid one is described in the XML, null
     *         otherwise
     */
    public static Composer parse(String xml) {
        if (Boolean.parseBoolean(StringUtil.getElement(xml, NO_EXIST_TAG)))
            return null;
        String element = StringUtil.getElement(xml, TAG);
        try {
            return new Composer(Integer.parseInt(StringUtil.getElement(
                    element, ID_TAG)), StringUtil.getElement(element,
                    NAME_TAG), StringUtil.getElement(element, IMAGE_FILE_TAG),
                    StringUtil.getElement(element, URL_TAG), StringUtil
                            .getElement(element, URL_MOBY_TAG), StringUtil
                            .getElement(element, URL_BRAINZ_TAG), StringUtil
                            .getElement(element, URL_WIKI_TAG));
        } catch (MalformedURLException e) {
            return null;
        } catch (NumberFormatException e) {
            return null;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /**
     * @return the URL of the page that describes the list of this element
     */
    public static String listUrl() {
        return OCREMIX_URL + "/composers/";
    }

    /**
     * @param id
     *            the ID of the element
     * @return the URL of the XML that describes the element with the specified
     *         ID
     */
    public static String elementUrl(int id) {
        return OCREMIX_URL + "/composer/id/" + id + "/" + XML_STYLE;
    }
}
