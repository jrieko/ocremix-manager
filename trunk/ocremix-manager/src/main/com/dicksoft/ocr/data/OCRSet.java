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
import java.util.Collection;
import java.util.HashSet;

/**
 * A HashSet that does not allow null elements.
 * TODO synchronized access
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 */
public class OCRSet<E> extends HashSet<E> implements Serializable {
    private static final long serialVersionUID = 8572039892434025006L;

    /**
     * 
     */
    public OCRSet() {
    }

    /**
     * @param c
     */
    public OCRSet(Collection<E> c) {
        super(c);
    }

    /**
     * @param initialCapacity
     */
    public OCRSet(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * @param initialCapacity
     * @param loadFactor
     */
    public OCRSet(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.HashSet#add(java.lang.Object)
     */
    @Override
    public boolean add(E o) {
        if (o != null)
            return super.add(o);
        return false;
    }
}
