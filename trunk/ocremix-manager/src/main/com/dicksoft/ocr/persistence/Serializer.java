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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.dicksoft.ocr.data.Root;

/**
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 */
public class Serializer {
    private static ObjectOutputStream serializer;

    public static void write(Root data, String filename)
            throws FileNotFoundException, IOException {
        serializer(filename).writeObject(data);
    }

    private static ObjectOutputStream serializer(String filename)
            throws FileNotFoundException, IOException {
        if (serializer == null) {
            serializer = new ObjectOutputStream(new FileOutputStream(filename));
        }
        return serializer;
    }
}
