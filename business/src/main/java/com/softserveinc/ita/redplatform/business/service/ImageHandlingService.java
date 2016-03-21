package com.softserveinc.ita.redplatform.business.service;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.redplatform.business.accessory
    .imageHandlers.ImageHandler;

/**
 * The Class ImageHandlingService.
 */
@Service
public class ImageHandlingService {

    /** The secure random. */
    @Autowired
    private SecureRandom secureRandom;

    /** The image handler. */
    @Autowired
    private ImageHandler imageHandler;

    /** The constant UNIQUE_ID_LEN. */
    private static final int UNIQUE_ID_LEN = 10;

    /**
     * The path to save the images.
     */
    @Value("${fileUploadLocal.path}")
    private String uploadPath;

    /**
     * Generate unique name.
     *
     * @return the string
     */
    private String generateUniqueName() {
	return new Long(new Date().getTime()).toString() + RandomStringUtils
		.random(UNIQUE_ID_LEN, 0, 0, true, true, null, secureRandom);
    }

    /**
     * Save image.
     *
     * @param image
     *            the image
     * @return the string
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public final String saveImage(final byte[] image) throws IOException {
	String name = generateUniqueName();
	imageHandler.saveImage(image, uploadPath + name);
	return name;

    }
}
