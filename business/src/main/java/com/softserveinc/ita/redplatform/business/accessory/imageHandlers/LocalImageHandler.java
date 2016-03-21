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

	if (!outputFile.exists()) {
	    outputFile.createNewFile();
	} else {
	    throw new FileAlreadyExistsException(filePath);
	}

	FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
	fileOutputStream.write(image);
	fileOutputStream.close();
    }

}
