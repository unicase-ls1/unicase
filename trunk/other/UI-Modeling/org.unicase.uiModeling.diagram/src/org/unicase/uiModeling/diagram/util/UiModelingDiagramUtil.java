package org.unicase.uiModeling.diagram.util;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.unicase.ui.unicasecommon.diagram.util.EditPartUtility;
import org.unicase.uiModeling.Button;
import org.unicase.uiModeling.Checkbox;
import org.unicase.uiModeling.ImageButton;
import org.unicase.uiModeling.Panel;
import org.unicase.uiModeling.RadioButton;
import org.unicase.uiModeling.RadioGroup;
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
		String imageUrl = button.getImageUrl();
		if (imageUrl == null || imageUrl.length() == 0) {
			return getLocalImage("image.png");
		}
		try {
			return getImage(new URL(imageUrl));
		} catch (MalformedURLException e) {
			return getErrorImage();
		}
	}

	/**
	 * @param image the {@link org.unicase.uiModeling.Image} to get the SWT {@link Image} for
	 * @return the SWT {@link Image} for the {@link org.unicase.uiModeling.Image} node
	 */
	public static Image getImageImage(org.unicase.uiModeling.Image image) {
		String imageUrl = image.getImageUrl();
		if (imageUrl == null || imageUrl.length() == 0) {
			return getLocalImage("image.png");
		}
		try {
			return getImage(new URL(imageUrl));
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
	 * Updates the layout of this edit part based on {@link #size} and {@link #location}.
	 */
	public static void setViewFeature(final ShapeNodeEditPart editPart, final EStructuralFeature feature,
		final Object value) {
		View view = editPart.getNotationView();

		final ICommandProxy command = new ICommandProxy(new SetConstraintCommand(view, feature, value));
		if (command.canExecute()) {
			new Thread() {
				public void run() {
					editPart.getDiagramEditDomain().getDiagramCommandStack().execute(command);
				}
			}.start();
		}
	}

	public static void setElementFeature(final ShapeNodeEditPart editPart, final EStructuralFeature feature,
		final Object newValue) {
		final EObject element = EditPartUtility.getElement(editPart);
		new Thread() {
			public void run() {
				new ECPCommand(element) {

					@Override
					protected void doRun() {
						element.eSet(feature, newValue);
					}
				}.run(true);
			}
		}.start();
	}

	public static boolean isPositioningEnabled(EObject element) {
		EObject container = element.eContainer();
		if (container != null && container instanceof Panel) {
			return ((Panel) container).isPositioningEnabled();
		}
		return false;
	}

	public static boolean isSizingEnabled(EObject element) {
		EObject container = element.eContainer();
		if (container != null && container instanceof Panel) {
			return ((Panel) container).isSizingEnabled();
		}
		return false;
	}

	public static String getImageKey(EObject element) {
		if (element instanceof RadioButton) {
			RadioButton button = (RadioButton) element;
			RadioGroup group = button.getGroup();
			if (group != null) {
				RadioButton selectedButton = group.getSelectedItem();
				if (button == selectedButton) {
					return UiModelingConstants.RADIO_CHECKED_KEY;
				} else {
					return UiModelingConstants.RADIO_UNCHECKED_KEY;
				}
			}
		} else if (element instanceof Checkbox) {
			if (((Checkbox) element).isChecked()) {
				return UiModelingConstants.CHECKBOX_CHECKED_KEY;
			} else {
				return UiModelingConstants.CHECKBOX_UNCHECKED_KEY;
			}
		}
		if (element instanceof ENamedElement) {
			return ((ENamedElement) element).getName();
		}
		return UiModelingConstants.ERROR_KEY;
	}

	public static Image getImage(EObject eObject) {
		Image image = null;
		if (eObject instanceof org.unicase.uiModeling.Image) {
			image = getImageImage((org.unicase.uiModeling.Image) eObject);
		} else if (eObject instanceof ImageButton) {
			image = getButtonImage((ImageButton) eObject);
		}
		if (image == null) {
			image = getErrorImage();
		}
		return image;
	}
}
