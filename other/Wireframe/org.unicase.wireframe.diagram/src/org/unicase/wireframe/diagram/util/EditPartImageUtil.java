package org.unicase.wireframe.diagram.util;

import org.eclipse.gmf.runtime.common.ui.util.DisplayUtils;
import org.eclipse.swt.graphics.Image;
import org.unicase.wireframe.Button;
import org.unicase.wireframe.Window;

/**
 * This utility class provides access to all images required by the edit parts.
 * 
 * @author mharut
 */
public final class EditPartImageUtil {

	private static Image BUTTON_LEFT_IMAGE;
	private static Image BUTTON_RIGHT_IMAGE;
	private static Image BUTTON_SQUARE_IMAGE;

	/**
	 * MN: Has "Minimize" button
	 * MX: Has "Maximize" button
	 * CL: Has "Close" button
	 */
	private static Image WINDOW_IMAGE;
	private static Image WINDOW_MN_IMAGE;
	private static Image WINDOW_MX_IMAGE;
	private static Image WINDOW_CL_IMAGE;
	private static Image WINDOW_MN_MX_IMAGE;
	private static Image WINDOW_MN_CL_IMAGE;
	private static Image WINDOW_MX_CL_IMAGE;
	private static Image WINDOW_MN_MX_CL_IMAGE;
	
	private static Image IMAGE_IMAGE;
	
	/**
	 * Private constructor. All methods should be accessed in a static way.
	 */
	private EditPartImageUtil() {
		// nothing to do
	}
	
	private static Image getImage(String name) {
		return new Image(DisplayUtils.getDisplay(), EditPartImageUtil.class.getResourceAsStream("/icons/figures/"
			+ name));
	}

	public static Image getButtonImage(Button button) {
		switch (button.getStyle()) {
		case POINT_LEFT:
			return getButtonLeftImage();
		case POINT_RIGHT:
			return getButtonRightImage();
		case SQUARE:
		default:
			return getButtonSquareImage();
		}
	}
	
	private static Image getButtonLeftImage() {
		if (BUTTON_LEFT_IMAGE == null) {
			BUTTON_LEFT_IMAGE = getImage("button_left.png");
		}
		return BUTTON_LEFT_IMAGE;
	}

	private static Image getButtonRightImage() {
		if (BUTTON_RIGHT_IMAGE == null) {
			BUTTON_RIGHT_IMAGE = getImage("button_right.png");
		}
		return BUTTON_RIGHT_IMAGE;
	}

	private static Image getButtonSquareImage() {
		if (BUTTON_SQUARE_IMAGE == null) {
			BUTTON_SQUARE_IMAGE = getImage("button_square.png");
		}
		return BUTTON_SQUARE_IMAGE;
	}

	/**
	 * Returns the correct {@link Window} image based on the window's attributes.
	 * 
	 * @param window the {@link Window} to get the image for
	 * @return the corresponding {@link Image} for the <code>window</code>
	 * @see Window#isHasMinimize()
	 * @see Window#isHasMaximize()
	 * @see Window#isHasClose()
	 */
	public static Image getWindowImage(Window window) {
		boolean hasMin = window.isHasMinimize();
		boolean hasMax = window.isHasMaximize();
		boolean hasClose = window.isHasClose();
		if (!hasMin && !hasMax && !hasClose) {
			return getWindowImage();
		} else if (hasMin && !hasMax && !hasClose) {
			return getWindowMnImage();
		} else if (!hasMin && hasMax && !hasClose) {
			return getWindowMxImage();
		} else if (!hasMin && !hasMax && hasClose) {
			return getWindowClImage();
		} else if (hasMin && hasMax && !hasClose) {
			return getWindowMnMxImage();
		} else if (hasMin && !hasMax && hasClose) {
			return getWindowMnClImage();
		} else if (!hasMin && hasMax && hasClose) {
			return getWindowMxClImage();
		} else if (hasMin && hasMax && hasClose) {
			return getWindowMnMxClImage();
		}
		return getWindowImage();
	}

	private static Image getWindowImage() {
		if (WINDOW_IMAGE == null) {
			WINDOW_IMAGE = getImage("window.png");
		}
		return WINDOW_IMAGE;
	}

	private static Image getWindowMnImage() {
		if (WINDOW_MN_IMAGE == null) {
			WINDOW_MN_IMAGE = getImage("window_Mn.png");
		}
		return WINDOW_MN_IMAGE;
	}

	private static Image getWindowMxImage() {
		if (WINDOW_MX_IMAGE == null) {
			WINDOW_MX_IMAGE = getImage("window_Mx.png");
		}
		return WINDOW_MX_IMAGE;
	}

	private static Image getWindowClImage() {
		if (WINDOW_CL_IMAGE == null) {
			WINDOW_CL_IMAGE = getImage("window_Cl.png");
		}
		return WINDOW_CL_IMAGE;
	}

	private static Image getWindowMnMxImage() {
		if (WINDOW_MN_MX_IMAGE == null) {
			WINDOW_MN_MX_IMAGE = getImage("window_MnMx.png");
		}
		return WINDOW_MN_MX_IMAGE;
	}

	private static Image getWindowMnClImage() {
		if (WINDOW_MN_CL_IMAGE == null) {
			WINDOW_MN_CL_IMAGE = getImage("window_MnCl.png");
		}
		return WINDOW_MN_CL_IMAGE;
	}

	private static Image getWindowMxClImage() {
		if (WINDOW_MX_CL_IMAGE == null) {
			WINDOW_MX_CL_IMAGE = getImage("window_MxCl.png");
		}
		return WINDOW_MX_CL_IMAGE;
	}

	private static Image getWindowMnMxClImage() {
		if (WINDOW_MN_MX_CL_IMAGE == null) {
			WINDOW_MN_MX_CL_IMAGE = getImage("window_MnMxCl.png");
		}
		return WINDOW_MN_MX_CL_IMAGE;
	}

	/**
	 * @return the SWT {@link Image} for the {@link org.unicase.wireframe.Image} node
	 */
	public static Image getImageImage() {
		if (IMAGE_IMAGE == null) {
			IMAGE_IMAGE = getImage("image.png");
		}
		return IMAGE_IMAGE;
	}

}
