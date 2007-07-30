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

import com.dicksoft.ocr.net.HttpUtil;

/**
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 */
public class Temp {
    private static final String TOTAL_GAME_PREFIX = "games&nbsp;1 to 100 of ";
    private static final int TOTAL_GAME_MAX_DIGITS = 30;
    private static final int NUM_GAMES_PER_PAGE = 100;

    /**
     * @param args
     */
    public static void main(String[] args) {
        String result = null;
        try {
            result =
                    HttpUtil
                            .fetchText("http://ocremix.org/games/?&offset=0&limit="
                                    + NUM_GAMES_PER_PAGE + "&sort=");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // //
        int totalGames =
                Integer.parseInt(result.substring(
                        result.indexOf(TOTAL_GAME_PREFIX)
                                + TOTAL_GAME_PREFIX.length(),
                        TOTAL_GAME_MAX_DIGITS).split(" ")[0]);
        int numPages = (int) Math.ceil(totalGames / NUM_GAMES_PER_PAGE);
        for (int i = 2; i <= numPages; i++) {

        }
    }
}
