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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;

import com.dicksoft.ocr.data.Emulator;
import com.dicksoft.ocr.util.StringUtil;
import com.dicksoft.ocr.xml.NotParseableException;

/**
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 */
public class Temp {
    // private static final String TOTAL_GAME_PREFIX = "games&nbsp;1 to 100 of
    // ";
    // private static final int TOTAL_GAME_MAX_DIGITS = 30;
    // private static final int NUM_GAMES_PER_PAGE = 100;
    private static Log LOG;
    private static final String LOG4JPROPERTIES =
            "src" + StringUtil.FS + "conf" + StringUtil.FS + "log4j.properties";
    private static final String LOG4JLOCATION = "log" + StringUtil.FS;

    /**
     * @param args
     * @throws NotParseableException
     */
    public static void main(String[] args) throws NotParseableException {
        setupLog();
        Set<Emulator> emus = Emulator.parseListing();
        for (Emulator emu : emus) {
            System.out.println(emu);
        }
        // ////////////////////////
        // Root root = null;
        // if (new File("temp.dat").exists()) {
        // try {
        // root = Deserializer.read("temp.dat");
        // } catch (FileNotFoundException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // } catch (ClassNotFoundException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // } else {
        // root = new Root();
        // Parser.parse(root);
        // }
        // System.out.println(root.getComposers().size());
        // for (Composer c : root.getComposers()) {
        // System.out.print(c.getName() + ", ");
        // }
        // if (!new File("temp.dat").exists()) {
        // try {
        // Serializer.write(root, "temp.dat");
        // } catch (FileNotFoundException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // }
        // /////////////////////
        // Root root = new Root();
        // root.addComposer(new Composer(20, "dood", "dood.jpg"));
        // root.addEmulator(new Emulator());
        // try {
        // Serializer.write(root, "temp.dat");
        // } catch (FileNotFoundException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // try {
        // Root newRoot = Deserializer.read("temp.dat");
        // System.out.println(root.getComposers().size());
        // for (Composer comp : newRoot.getComposers()) {
        // System.out.println(comp.getId() + ", " + comp.getName() + ", "
        // + comp.getImageFile());
        // }
        // System.out.println(root.getEmulators().size());
        // } catch (FileNotFoundException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // } catch (ClassNotFoundException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // ///////////////////
        // LOG.info("Fetching");
        // String result = null;
        // boolean done = false;
        // for (int i = 1; !done; i++) {
        // try {
        // result =
        // HttpUtil.fetchText("http://ocremix.org/remix/OCR"
        // + String.format("%1$05d", i) + "/?style=xml");
        // // System.out.println(result);
        // String game =
        // StringUtil.getBetween(result, "<gamename>",
        // "</gamename>");
        //
        // if (game == null || game.equals("")) {
        // System.out.println("OCR" + String.format("%1$05d", i));
        // done = true;
        // }
        // } catch (IOException e) {
        // e.printStackTrace();
        // return;
        // }
        // // done = true;// TODO
        // }

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

    private static void setupLog() {
        System.getProperties().setProperty("org.apache.commons.logging.Log",
                "org.apache.commons.logging.impl.Log4JLogger");
        Properties properties = new Properties();
        InputStream input;
        try {
            input = new FileInputStream(LOG4JPROPERTIES);
            properties.load(input);
        } catch (FileNotFoundException e) {
            System.err.println("Log4J properties file not found at "
                    + LOG4JPROPERTIES);
        } catch (Exception e) {
            System.err.println("Log4J properties file read error.");
        }
        File logDir = new File(LOG4JLOCATION + StringUtil.FS);
        if (!logDir.exists()) {
            logDir.mkdirs();
        }
        properties.setProperty("log4j.appender.FILE.File", logDir
                .getAbsolutePath()
                + StringUtil.FS + "main.log");
        PropertyConfigurator.configure(properties);
        LOG = LogFactory.getLog(Temp.class);
    }
}
