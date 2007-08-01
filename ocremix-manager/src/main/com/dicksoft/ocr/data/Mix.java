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

/**
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 *
 */
public class Mix {
    protected String id;
    protected String name;
    protected Date postDate;
    protected String filename;
    protected byte[] md5Hash;
    protected int filesize;
    protected int length;
    protected int bitrate;
    protected String djpComment;
    protected String lyrics;
    protected int lastfmId;
    protected int judgeId;
    protected int topicId;
    protected boolean inCollection;
    protected boolean ignored;
}
