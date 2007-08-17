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
import java.util.Date;
import java.util.List;

/**
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 * @see http://ocremix.org/remixes/
 * @see http://ocremix.org/remix/[id]/
 */
public class Mix extends OCRElement implements Serializable {
    private static final long serialVersionUID = 5548809044578971054L;
    protected Date postDate;
    protected String filename;
    protected int topicId;
    protected int judgeId;
    protected int lastfmId;
    protected byte[] md5Hash;
    protected int filesize;
    protected int length;
    protected int bitrate;
    protected String djpComment;
    protected String lyrics;
    protected boolean inCollection;
    protected boolean ignored;
    protected Game game;
    protected OCRSet<Mixer> mixers = new OCRSet<Mixer>();
    protected OCRSet<Composer> composers = new OCRSet<Composer>();
    protected Publisher copyright;
    protected System system;
    protected OCRSet<Song> songs = new OCRSet<Song>();
    protected ForumTopic forumTopic;

    /**
     * @param id
     * @param name
     * @param postDate
     * @param filename
     * @param topicId
     * @param judgeId
     * @param lastfmId
     * @param md5Hash
     * @param filesize
     * @param length
     * @param bitrate
     * @param djpComment
     * @param lyrics
     * @param inCollection
     * @param ignored
     * @param forumTopic
     * @throws IllegalArgumentException
     */
    public Mix(Root root, int id, String name, Date postDate, String filename,
            int topicId, int judgeId, int lastfmId, byte[] md5Hash,
            int filesize, int length, int bitrate, String djpComment,
            String lyrics, boolean inCollection, boolean ignored,
            ForumTopic forumTopic) throws IllegalArgumentException {
        super(root, id, name);
        this.postDate = postDate;
        this.filename = filename;
        this.topicId = topicId;
        this.judgeId = judgeId;
        this.lastfmId = lastfmId;
        this.md5Hash = md5Hash;
        this.filesize = filesize;
        this.length = length;
        this.bitrate = bitrate;
        this.djpComment = djpComment;
        this.lyrics = lyrics;
        this.inCollection = inCollection;
        this.ignored = ignored;
        this.forumTopic = forumTopic;
    }

    /**
     * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
     * @see http://ocremix.org/forums/showthread.php?t=[id]
     */
    private class ForumTopic {
        protected String recentComment;
        protected int numComments;
        protected int id;
        protected int lastPostId;
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
     * @return the inCollection
     */
    public boolean isInCollection() {
        return this.inCollection;
    }

    /**
     * @param inCollection
     *            the inCollection to set
     */
    public void setInCollection(boolean inCollection) {
        this.inCollection = inCollection;
    }

    /**
     * @return the mixers
     */
    public List<Mixer> getMixers() {
        return this.mixers.toList();
    }

    /**
     * @param mixers
     *            the mixers to set
     */
    public void addMixer(Mixer mixer) {
        this.mixers.add(this.root.mixers.tryAdd(mixer));
    }

    /**
     * @return the songs
     */
    public List<Song> getSongs() {
        return this.songs.toList();
    }

    /**
     * @param songs
     *            the songs to set
     */
    public void addSong(Song song) {
        this.songs.add(this.root.songs.tryAdd(song));
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

    /**
     * @return the bitrate
     */
    public int getBitrate() {
        return this.bitrate;
    }

    /**
     * @return the djpComment
     */
    public String getDjpComment() {
        return this.djpComment;
    }

    /**
     * @return the filename
     */
    public String getFilename() {
        return this.filename;
    }

    /**
     * @return the filesize
     */
    public int getFilesize() {
        return this.filesize;
    }

    /**
     * @return the forumTopic
     */
    public ForumTopic getForumTopic() {
        return this.forumTopic;
    }

    /**
     * @return the ignored
     */
    public boolean isIgnored() {
        return this.ignored;
    }

    /**
     * @return the judgeId
     */
    public int getJudgeId() {
        return this.judgeId;
    }

    /**
     * @return the lastfmId
     */
    public int getLastfmId() {
        return this.lastfmId;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return this.length;
    }

    /**
     * @return the lyrics
     */
    public String getLyrics() {
        return this.lyrics;
    }

    /**
     * @return the md5Hash
     */
    public byte[] getMd5Hash() {
        return this.md5Hash;
    }

    /**
     * @return the postDate
     */
    public Date getPostDate() {
        return this.postDate;
    }

    /**
     * @return the topicId
     */
    public int getTopicId() {
        return this.topicId;
    }
}
