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
import java.util.List;

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
    protected OCRSet<Composer> composers = new OCRSet<Composer>();
    protected OCRSet<Mix> mixes = new OCRSet<Mix>();

    /**
     * @param id
     * @param name
     * @throws IllegalArgumentException
     */
    public Song(Root root, int id, String name) throws IllegalArgumentException {
        super(root, id, name);
    }

    /**
     * @return the composers
     */
    public List<Composer> getComposers() {
        return this.composers.toList();
    }

    /**
     * @param composers
     *            the composers to set
     */
    public void addComposer(Composer composer) {
        this.composers.add(this.root.composers.tryAdd(composer));
    }

    /**
     * @return the copyright
     */
    public Publisher getCopyright() {
        return this.copyright;
    }

    /**
     * @param copyright
     *            the copyright to set
     */
    public void setCopyright(Publisher copyright) {
        this.copyright = this.root.publishers.tryAdd(copyright);
    }

    /**
     * @return the game
     */
    public Game getGame() {
        return this.game;
    }

    /**
     * @param game
     *            the game to set
     */
    public void setGame(Game game) {
        this.game = this.root.games.tryAdd(game);
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
    public void addMixes(Mix mix) {
        this.mixes.add(this.root.mixes.tryAdd(mix));
    }

    /**
     * @return the system
     */
    public System getSystem() {
        return this.system;
    }

    /**
     * @param system
     *            the system to set
     */
    public void setSystem(System system) {
        this.system = this.root.systems.tryAdd(system);
    }
}
