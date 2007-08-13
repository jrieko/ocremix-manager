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
package com.dicksoft.ocr.persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.dicksoft.ocr.data.Root;

/**
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 */
public class Deserializer {
    // private static ObjectInputStream deserializer;

    public static Root read(String filename) throws FileNotFoundException,
            IOException, ClassNotFoundException {
        ObjectInputStream deserializer =
                new ObjectInputStream(new FileInputStream(filename));
        Root root = (Root) deserializer.readObject();
        deserializer.close();
        return root;
    }

    // private synchronized static ObjectInputStream deserializer(String
    // filename)
    // throws FileNotFoundException, IOException {
    // if (deserializer == null)
    // deserializer = new ObjectInputStream(new FileInputStream(filename));
    // return deserializer;
    // }
    //
    // private synchronized static ObjectInputStream deserializer() {
    // if (deserializer == null)
    // throw new IllegalStateException("deserializer must be initialized"
    // + " with deserializer(String) first.");
    // return deserializer;
    // }
}
