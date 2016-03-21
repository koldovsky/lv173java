package com.softserveinc.ita.redplatform.business.accessory.imageHandlers;

import java.io.IOException;

/**
 * The Interface ImageHandler.
 */
public interface ImageHandler {

    /**
     * Save image.
     *
     * @param image
     *            the image byte array
     * @param filepath
     *            the path to a file
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    void saveImage(byte[] image, String filepath) throws IOException;
}
