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
package com.dicksoft.ocr.net;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;

/**
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 */
public final class HttpUtil {
    private HttpUtil() {
    }

    /**
     * Downloads the text from the specified URL.
     * 
     * @param url
     *            the URL of the text to read
     * @return the text
     * @throws IOException
     *             if url is malformed, or problem reading the stream
     */
    public static String fetchText(String url) throws IOException {
        StringBuffer result = new StringBuffer();
        URL urlReal = null;
        urlReal = new URL(url);
        BufferedInputStream in = null;
        in = new BufferedInputStream(urlReal.openStream());

        int data = 0;
        while (true) {
            data = in.read();
            if (data == -1)
                break;
            else
                result.append((char) data);
        }
        return result.toString();
    }
}
