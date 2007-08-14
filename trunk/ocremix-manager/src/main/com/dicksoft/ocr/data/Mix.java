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
import java.util.Set;

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
    protected Set<Mixer> mixers = new OCRSet<Mixer>();
    protected Set<Composer> composers = new OCRSet<Composer>();
    protected Publisher copyright;
    protected System system;
    protected Set<Song> songs = new OCRSet<Song>();
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
    public Mix(int id, String name, Date postDate, String filename,
            int topicId, int judgeId, int lastfmId, byte[] md5Hash,
            int filesize, int length, int bitrate, String djpComment,
            String lyrics, boolean inCollection, boolean ignored,
            ForumTopic forumTopic) throws IllegalArgumentException {
        super(id, name);
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
}
