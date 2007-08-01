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
package com.dicksoft.ocr;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.security.provider.MD5;

import com.dicksoft.ocr.util.HttpUtil;
import com.dicksoft.ocr.util.StringUtil;

/**
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 */
public class Temp {
    // private static final String TOTAL_GAME_PREFIX = "games&nbsp;1 to 100 of
    // ";
    // private static final int TOTAL_GAME_MAX_DIGITS = 30;
    // private static final int NUM_GAMES_PER_PAGE = 100;
    private static final Log LOG = LogFactory.getLog(Temp.class);

    /**
     * @param args
     */
    public static void main(String[] args) {
        LOG.info("Fetching");
        String result = null;
        boolean done = false;
        for (int i = 1; !done; i++) {
            try {
                result =
                        HttpUtil.fetchText("http://ocremix.org/remix/OCR"
                                + String.format("%1$05d", i) + "/?style=xml");
                 System.out.println(result);
                String game =
                        StringUtil.getBetween(result,
                                "<html>\n  <head>\n    <title>ReMix: ", "\n");
                
                if (game==null || game.equals(""))
                    done = true;
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            done = true;// TODO
        }

        // ////////////
        // try {
        // result =
        // HttpUtil
        // .fetchText("http://ocremix.org/games/?&offset=0&limit="
        // + NUM_GAMES_PER_PAGE + "&sort=");
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        // int totalGames =
        // Integer.parseInt(result.substring(
        // result.indexOf(TOTAL_GAME_PREFIX)
        // + TOTAL_GAME_PREFIX.length(),
        // TOTAL_GAME_MAX_DIGITS).split(" ")[0]);
        // int numPages = (int) Math.ceil(totalGames / NUM_GAMES_PER_PAGE);
        // for (int i = 2; i <= numPages; i++) {
        //
        // }
    }
}
