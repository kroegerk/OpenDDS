/*
 * $Id$
 */

package org.opendds.jms.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author  Steven Stallion
 * @version $Revision$
 */
public class Streams {
    public static final int BUFFER_CAPACITY = 16384;
    public static final int EOF = -1;

    public static byte[] createBuffer() {
        return new byte[BUFFER_CAPACITY];
    }

    public static void tie(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = createBuffer();

        int read;
        do {
            read = in.read(buffer);
            if (read > 0) {
                out.write(buffer, 0, read);
            }

        } while (read != EOF);

        out.flush();
    }

    //

    private Streams() {}
}
