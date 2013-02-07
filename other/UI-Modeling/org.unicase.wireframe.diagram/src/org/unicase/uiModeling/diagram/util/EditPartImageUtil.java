package org.unicase.uiModeling.diagram.util;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.unicase.uiModeling.Button;
import org.unicase.uiModeling.ImageButton;

/**
 * This utility class provides access to all images required by the edit parts.
 * 
 * @author mharut
 */
public final class EditPartImageUtil {

	private static Image ERROR_IMAGE;

	/**
	 * Private constructor. All methods should be accessed in a static way.
	 */
	private EditPartImageUtil() {
		// nothing to do
	}

	private static Image getLocalImage(String name) {
		return ImageDescriptor.createFromURL(EditPartImageUtil.class.getResource("/icons/figures/" + name))
			.createImage();
	}

	private static Image getImage(URL url) {
		try {
			return ImageDescriptor.createFromURL(url).createImage();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Retrieves an SWT {@link Image} for a {@link ImageButton} element, based on the value returned by
	 * {@link Button#getStyle()}.
	 * 
	 * @param button the {@link ImageButton} to get the {@link Image} for
	 * @return the proper SWT image
	 */
	public static Image getButtonImage(ImageButton button) {
		String imageURL = button.getImageURL();
		if (imageURL == null || imageURL.length() == 0) {
			return getLocalImage("image.png");
		}
		try {
			return getImage(new URL(imageURL));
		} catch (MalformedURLException e) {
			return getErrorImage();
		}
	}

	/**
	 * @param image the {@link org.unicase.uiModeling.Image} to get the SWT {@link Image} for
	 * @return the SWT {@link Image} for the {@link org.unicase.uiModeling.Image} node
	 */
	public static Image getImageImage(org.unicase.uiModeling.Image image) {
		String imageURL = image.getImageURL();
		if (imageURL == null || imageURL.length() == 0) {
			return getLocalImage("image.png");
		}
		try {
			return getImage(new URL(imageURL));
		} catch (MalformedURLException e) {
			return getErrorImage();
		}
	}

	/**
	 * @return an error SWT {@link Image} used to indicate something went wrong
	 */
	public static Image getErrorImage() {
		if (ERROR_IMAGE == null) {
			ERROR_IMAGE = getLocalImage("error.png");
		}
		return ERROR_IMAGE;
	}

}
