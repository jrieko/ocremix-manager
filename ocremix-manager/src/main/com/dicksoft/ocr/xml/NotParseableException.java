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
package com.dicksoft.ocr.xml;

/**
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 */
public class NotParseableException extends Exception {
    private static final long serialVersionUID = 1845744524333035641L;
    protected static final String MESSAGE =
            "You've violated the honor system of the Parseable interface.  "
                    + "Shame on you.";

    /**
     * 
     */
    public NotParseableException() {
        super(MESSAGE);
    }

    /**
     * @param message
     */
    public NotParseableException(String message) {
        super(MESSAGE + "\n" + message);
    }

    /**
     * @param cause
     */
    public NotParseableException(Throwable cause) {
        super(MESSAGE, cause);
    }

    /**
     * @param message
     * @param cause
     */
    public NotParseableException(String message, Throwable cause) {
        super(MESSAGE + "\n" + message, cause);
    }

}
