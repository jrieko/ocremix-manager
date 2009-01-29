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

/**
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 */
public abstract class OCRElement implements Serializable {
    private static final long serialVersionUID = -2452307344001632613L;
    protected Root root;
    protected int id;
    protected String name;

    /**
     * @param id
     *            the unique ID
     * @param name
     *            the name of the element; must not be null or empty
     * @throws IllegalArgumentException
     *             if name is null or empty
     */
    public OCRElement(Root root, int id, String name)
            throws IllegalArgumentException {
        if (root == null)
            throw new IllegalArgumentException("root must not be null");
        if (name == null || name.equals(""))
            throw new IllegalArgumentException("name must not be null or empty");
        this.root = root;
        this.id = id;
        this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        OCRElement element = null;
        try {
            element = this.getClass().cast(obj);
        } catch (ClassCastException e) {
            return false;
        }
        return (element.id == this.id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return this.id;
    }

    /**
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }
}
