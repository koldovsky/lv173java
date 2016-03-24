package com.softserveinc.ita.redplatform.business.accessory.imageHandlers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import org.springframework.stereotype.Component;

/**
 * The Class LocalImageHandler.
 */
@Component
public class LocalImageHandler implements ImageHandler {

    @Override
    public final void saveImage(final byte[] image, final String filePath)
	    throws IOException {
	File outputFile = new File(filePath);
	createParentDirs(outputFile);
	if (!outputFile.exists()) {
	    outputFile.createNewFile();
	} else {
	    throw new FileAlreadyExistsException(filePath);
	}
	try (FileOutputStream fileOutputStream =
		new FileOutputStream(outputFile)) {
	    fileOutputStream.write(image);
	}
    }

    /**
     * Creates the parent directories.
     *
     * @param outputFile
     *            the output file
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void createParentDirs(final File outputFile) throws IOException {
	File parent = outputFile.getParentFile();
	if (!parent.exists() && !parent.mkdirs()) {
	    throw new IOException("Couldn't create dir: " + parent);
	}
    }
}
