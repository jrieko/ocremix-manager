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

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 * @see http://ocremix.org/remixes/
 * @see http://ocremix.org/remix/[id]/
 */
public class Mix {
    protected String id;
    protected String name;
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
    protected Set<Mixer> mixers = new HashSet<Mixer>();
    protected Set<Composer> composers = new HashSet<Composer>();
    protected Publisher copyright;
    protected System system;
    protected Set<Song> songs = new HashSet<Song>();
    protected ForumTopic forumTopic;

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
