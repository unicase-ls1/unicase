package org.unicase.uiModeling.diagram.util;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.unicase.ui.unicasecommon.diagram.util.EditPartUtility;
import org.unicase.uiModeling.Button;
import org.unicase.uiModeling.ImageButton;
import org.unicase.uiModeling.Label;
import org.unicase.uiModeling.Panel;
import org.unicase.uiModeling.Text;
import org.unicase.uiModeling.TextField;
import org.unicase.uiModeling.Widget;
import org.unicase.uiModeling.Window;
import org.unicase.uiModeling.diagram.UiModelingConstants;
import org.unicase.uiModeling.diagram.edit.commands.SetConstraintCommand;

/**
 * This utility class provides access to all images required by the edit parts.
 * 
 * @author mharut
 */
public final class UiModelingDiagramUtil {

	/**
	 * Image to display an error has occurred.
	 */
	private static Image ERROR_IMAGE;

	/**
	 * Private constructor. All methods should be accessed in a static way.
	 */
	private UiModelingDiagramUtil() {
		// nothing to do
	}

	/**
	 * Retrieves an image which exists locally on the classpath.
	 * 
	 * @param name the name of the image
	 * @return the image specified by <code>name</code>
	 */
	private static Image getLocalImage(String name) {
		return ImageDescriptor.createFromURL(UiModelingDiagramUtil.class.getResource("/icons/figures/" + name))
			.createImage();
	}

	/**
	 * Retrieves a remote image which is specified by an URL.
	 * 
	 * @param url the URL at which the image is located
	 * @return the image specified by <code>url</code> or<br />
	 *         <b>null</b> if the image can't be located
	 */
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
	 * @return an error SWT {@link Image} used to indicate an error has occurred
	 */
	public static Image getErrorImage() {
		if (ERROR_IMAGE == null) {
			ERROR_IMAGE = getLocalImage("error.png");
		}
		return ERROR_IMAGE;
	}

	/**
	 * Retrieves the size for an edit part if it is properly defined. Proper definition requires that automatic sizing
	 * is enabled as well as valid values for the widgets width and height. Never returns null.
	 * 
	 * @param editPart the edit part to get the size for
	 * @return the size for the edit part as a {@link Size} object
	 */
	public static Dimension getSize(ShapeNodeEditPart editPart) {
		EObject element = EditPartUtility.getElement(editPart);
		// sizing is only enabled for widgets
		if (element instanceof Widget) {
			Diagram diagram = EditPartUtility.getDiagramEditPart(editPart).getDiagramView();
			EObject container = diagram.eContainer();
			if (container == null || !(container instanceof Panel)) {
				// invalid diagram type
				return getFigureSize(element);
			}
			Panel panel = (Panel) container;
			// check if automatic sizing is enabled in the diagram
			if (panel.isSizingEnabled()) {
				Widget widget = (Widget) element;
				int width = widget.getWidth();
				int height = widget.getHeight();
				// check if values are valid
				if (width > 0 && height > 0) {
					return new Dimension(width, height);
				}
			}
		}
		return getFigureSize(element);
	}

	/**
	 * Retrieves the default size for UI Modeling elements in GMF diagrams.
	 * 
	 * @param element the {@link EObject} to get the size for
	 * @return the default size of <code>element</code> when represented by a GMF figure
	 */
	private static Dimension getFigureSize(EObject element) {
		if (element instanceof Button) {
			return UiModelingConstants.BUTTON_SIZE;
		}
		if (element instanceof org.unicase.uiModeling.Image) {
			return UiModelingConstants.IMAGE_SIZE;
		}
		if (element instanceof Label) {
			return UiModelingConstants.LABEL_SIZE;
		}
		if (element instanceof Text) {
			return UiModelingConstants.TEXT_SIZE;
		}
		if (element instanceof TextField) {
			return UiModelingConstants.TEXT_FIELD_SIZE;
		}
		if (element instanceof Window) {
			return UiModelingConstants.WINDOW_SIZE;
		}
		return UiModelingConstants.DEFAULT_SIZE;
	}

	/**
	 * Retrieves the proper location of an edit part based on the attributes specified by its element.
	 * 
	 * @param editPart the edit part to get the location for
	 * @return the proper location of <code>editPart</code> in the diagram
	 */
	public static Point getLocation(ShapeNodeEditPart editPart) {
		Diagram diagram = EditPartUtility.getDiagramEditPart(editPart).getDiagramView();
		EObject container = diagram.eContainer();
		if (container == null || !(container instanceof Panel)) {
			// invalid diagram type
			return editPart.getLocation();
		}
		Panel panel = (Panel) container;
		// check if automatic sizing is enabled in the diagram
		if (panel.isPositioningEnabled()) {
			EObject element = EditPartUtility.getElement(editPart);
			// sizing is only enabled for widgets
			if (element instanceof Widget) {
				Widget widget = (Widget) element;
				int x = widget.getX();
				int y = widget.getY();
				// check if values are valid
				if (x >= 0 && y >= 0) {
					return new Point(x, y);
				}
			}
		}
		return editPart.getLocation();
	}

	/**
	 * Retrieves the new size for an edit part based on a notification.
	 * 
	 * @param notification the notification used to compute the new size
	 * @param editPart the edit part to retrieve the size for
	 * @return the new size of <code>editPart</code> if an update is required,<br />
	 *         <b>null</b> otherwise
	 * @see #requiresUpdate(Notification, EAttribute, EAttribute, EAttribute)
	 */
	public static Dimension getSize(Notification notification, ShapeNodeEditPart editPart) {
		Dimension result;
		if (requiresUpdate(notification, UiModelingConstants.SIZING_ENABLED, UiModelingConstants.WIDGET_WIDTH,
			UiModelingConstants.WIDGET_HEIGHT)) {
			result = UiModelingDiagramUtil.getSize(editPart);
		} else {
			result = null;
		}
		return result;
	}

	/**
	 * Retrieves the new location for an edit part based on a notification.
	 * 
	 * @param notification the notification used to compute the new size
	 * @param editPart the edit part to retrieve the size for
	 * @return the new size of <code>editPart</code> if an update is required,<br />
	 *         <b>null</b> otherwise
	 * @see #requiresUpdate(Notification, EAttribute, EAttribute, EAttribute)
	 */
	public static Point getLocation(Notification notification, ShapeNodeEditPart editPart) {
		Point result;
		if (requiresUpdate(notification, UiModelingConstants.POSITIONING_ENABLED, UiModelingConstants.WIDGET_X,
			UiModelingConstants.WIDGET_Y)) {
			result = UiModelingDiagramUtil.getLocation(editPart);
		} else {
			result = null;
		}
		return result;
	}

	/**
	 * Checks whether an update for the layout of this edit part is required or not.
	 * 
	 * @param notification the notification that initially notified this adapter
	 * @param boolAttribute the boolean attribute to check for notification changes
	 * @param firstFeature first feature to check for changes
	 * @param secondFeature second feature to check for changes
	 * @return whether the layout of this edit part needs to be updated or not
	 */
	private static boolean requiresUpdate(Notification notification, EAttribute boolAttribute, EAttribute firstFeature,
		EAttribute secondFeature) {
		Object feature = notification.getFeature();
		EObject notifier = (EObject) notification.getNotifier();
		if (boolAttribute.equals(feature) && notification.getNewBooleanValue() == true) {
			return true;
		}
		if ((firstFeature.equals(feature) || secondFeature.equals(feature)) && notifier.eIsSet(firstFeature)
			&& notifier.eIsSet(secondFeature)) {
			return true;
		}
		return false;
	}

	/**
	 * Updates the layout of this edit part based on {@link #size} and {@link #location}.
	 */
	public static void updateLayout(Dimension size, Point location, final ShapeNodeEditPart editPart) {
		if (size == null) {
			size = UiModelingDiagramUtil.getSize(editPart);
		}
		if (location == null) {
			location = UiModelingDiagramUtil.getLocation(editPart);
		}
		View view = editPart.getNotationView();

		final ICommandProxy command = new ICommandProxy(new SetConstraintCommand(view, location, size));
		if (command.canExecute()) {
			new Thread() {
				public void run() {
					editPart.getDiagramEditDomain().getDiagramCommandStack().execute(command);
				}
			}.start();
		}
	}

}
