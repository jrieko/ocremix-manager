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

import com.dicksoft.ocr.data.OCRElement;

/**
 * @author <a href="mailto:ryo.away@gmail.com">Richard Taylor</a>
 */
public interface Parsable {
    public <T extends OCRElement> T parse(String xml);
}
