package com.softserveinc.ita.redplatform.business.service;

import java.io.IOException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.redplatform.business.accessory.imageHandlers
.ImageHandler;
import com.softserveinc.ita.redplatform.persistence.dao.OrderDao;

/**
 * The Class ImageHandlingService.
 */
@Service
public class ImageHandlingService {

    /** The image handler. */
    @Autowired
    private ImageHandler imageHandler;

    /**
     * The order Dao.
     */
    @Autowired
    private OrderDao orderDao;

    /**
     * The path to save the images.
     */
    @Value("${fileUploadLocal.path}")
    private String uploadPath;

    /**
     * Save image.
     *
     * @param image
     *            the image
     * @param path
     *            the path
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public final void saveImage(final byte[] image, final String path)
	    throws IOException {
	imageHandler.saveImage(image, path);
    }

    /**
     * Gets the new full path of a file to be saved.
     *
     * @param orderId
     *            the order id
     * @return the new full path
     */
    public String getNewFullPath(final Long orderId) {
	String name = new Long(new Date().getTime()).toString();
	return uploadPath + getCompanyId(orderId) + "/" + orderId + "/" + name;
    }

    /**
     * Gets the company id.
     *
     * @param orderId
     *            the order id
     * @return the company id
     */
    private String getCompanyId(final Long orderId) {
	return orderDao.getAgencyId(orderId).toString();
    }
}
