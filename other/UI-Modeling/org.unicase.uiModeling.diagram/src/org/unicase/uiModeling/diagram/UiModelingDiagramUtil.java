package org.unicase.uiModeling.diagram;

import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.render.RenderedImage;
import org.eclipse.gmf.runtime.draw2d.ui.render.factory.RenderedImageFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.unicase.ui.unicasecommon.diagram.util.EditPartUtility;
import org.unicase.uiModeling.Button;
import org.unicase.uiModeling.Checkbox;
import org.unicase.uiModeling.DropdownItem;
import org.unicase.uiModeling.ImageButton;
import org.unicase.uiModeling.Panel;
import org.unicase.uiModeling.RadioButton;
import org.unicase.uiModeling.RadioGroup;
import org.unicase.uiModeling.diagram.edit.commands.SetFeatureCommand;
import org.unicase.uiModeling.diagram.edit.parts.DropdownItemEditPart;
import org.unicase.uiModeling.diagram.edit.parts.DropdownList2EditPart;
import org.unicase.uiModeling.diagram.edit.parts.DropdownListEditPart;
import org.unicase.uiModeling.diagram.edit.parts.RadioButtonEditPart;
import org.unicase.uiModeling.diagram.providers.UiModelingElementTypes;

/**
 * This utility class provides access to all images required by the edit parts.
 * 
 * @author mharut
 */
public final class UiModelingDiagramUtil {

	/**
	 * Image to display an error has occurred.
	 */
	private static Map<String, Image> imageRegistry = new HashMap<String, Image>();

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
		URL url = UiModelingDiagramUtil.class.getResource("/icons/figures/" + name);
		Image image = ImageDescriptor.createFromURL(url).createImage();
		imageRegistry.put(url.toString(), image);
		return image;
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
			Image image = ImageDescriptor.createFromURL(url).createImage();
			imageRegistry.put(url.toString(), image);
			return image;
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
		return getLocalImage("error.png");
	}

	/**
	 * Retrieves an image for an {@link EObject} based on its type.
	 * 
	 * @param eObject the object to get the image for
	 * @return the proper image of <code>eObject</code> if any exists,<br />
	 *         {@link #ERROR_IMAGE} otherwise.
	 */
	public static RenderedImage getImage(EObject eObject) {
		Image image = null;
		if (eObject instanceof org.unicase.uiModeling.Image) {
			image = getImageImage((org.unicase.uiModeling.Image) eObject);
		} else if (eObject instanceof ImageButton) {
			image = getButtonImage((ImageButton) eObject);
		}
		if (image == null) {
			image = getErrorImage();
		}

		// load the image and return a rendered instance
		ImageLoader imageLoader = new ImageLoader();
		ByteArrayOutputStream byteOS = new ByteArrayOutputStream();
		imageLoader.data = new ImageData[] { image.getImageData() };
		imageLoader.logicalScreenHeight = image.getBounds().width;
		imageLoader.logicalScreenHeight = image.getBounds().height;
		imageLoader.save(byteOS, SWT.IMAGE_BMP);
		return RenderedImageFactory.getInstance(byteOS.toByteArray());
	}

	/**
	 * Sets a feature of an edit part's view.
	 * 
	 * @param editPart the edit part to retrieve the view from
	 * @param feature the view's feature to set
	 * @param value the value to set the feature to
	 */
	public static void setViewFeature(final ShapeNodeEditPart editPart, final EStructuralFeature feature,
		final Object value) {
		View view = editPart.getNotationView();

		final ICommandProxy command = new ICommandProxy(new SetFeatureCommand(view, feature, value));
		if (command.canExecute()) {
			new Thread() {
				public void run() {
					editPart.getDiagramEditDomain().getDiagramCommandStack().execute(command);
				}
			}.start();
		}
	}

	/**
	 * Sets a feature of an edit part's element.
	 * 
	 * @param editPart the edit part to retrieve the element from
	 * @param feature the element's feature to set
	 * @param value the value to set the feature to
	 */
	public static void setElementFeature(final ShapeNodeEditPart editPart, final EStructuralFeature feature,
		final Object value) {
		final EObject element = EditPartUtility.getElement(editPart);
		new Thread() {
			public void run() {
				new ECPCommand(element) {

					@Override
					protected void doRun() {
						element.eSet(feature, value);
					}
				}.run(true);
			}
		}.start();
	}

	/**
	 * Checks whether positioning is enabled for an element based on its containing {@link Panel}.
	 * 
	 * @param element the element to check
	 * @return <b>true</b> if positioning is enabled by the element's panel,<br />
	 *         <b>false</b> otherwise
	 */
	public static boolean isPositioningEnabled(EObject element) {
		EObject container = element.eContainer();
		while (container != null) {
			if (container instanceof Panel) {
				return ((Panel) container).isPositioningEnabled();
			}
			container = container.eContainer();
		}
		return false;
	}

	/**
	 * Checks whether sizing is enabled for an element based on its containing {@link Panel}.
	 * 
	 * @param element the element to check
	 * @return <b>true</b> if sizing is enabled by the element's panel,<br />
	 *         <b>false</b> otherwise
	 */
	public static boolean isSizingEnabled(EObject element) {
		EObject container = element.eContainer();
		while (container != null) {
			if (container instanceof Panel) {
				return ((Panel) container).isSizingEnabled();
			}
			container = container.eContainer();
		}
		return false;
	}

	/**
	 * Retrieves the key in the image registry for an {@link EObject}.
	 * 
	 * @param element the element to ket the image key for
	 * @return the key of <code>element</code> in the image registry as a string
	 */
	public static String getImageKey(EObject element) {
		if (element == null) {
			return UiModelingConstants.ERROR_KEY;
		}
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
		return getImageKey(element.eClass());
	}

	/**
	 * Updates the images of radio buttons in a radio group within a UI Modeling diagram.
	 * 
	 * @param children the list of children of the containing compartment
	 * @param oldRadio the radio button that was selected before (may be null)
	 * @param newRadio the radio button that is selected now (may be null);
	 */
	@SuppressWarnings("rawtypes")
	public static void updateRadioButtonImage(List children, Object oldRadio, Object newRadio) {
		for (Object child : children) {
			RadioButtonEditPart editPart = (RadioButtonEditPart) child;
			EObject element = EditPartUtility.getElement(editPart);
			if (newRadio == element || oldRadio == element) {
				WrappingLabel label = editPart.getPrimaryShape().getRadioButton_text();
				if (label != null) {
					label.setIcon(UiModelingElementTypes.getImage(element));
				}
			}
		}
	}

	/**
	 * Updates the label of a dropdown list by setting it to the value of the currently selected item.
	 * 
	 * @param editPart the edit part of the currently selected item
	 */
	public static void updateDropdownListLabel(DropdownItemEditPart editPart) {
		EObject element = EditPartUtility.getElement(editPart);
		if (element != null && element instanceof DropdownItem) {
			String text = ((DropdownItem) element).getText();
			EditPart parent = editPart.getParent();
			while (parent != null) {
				if (parent instanceof DropdownListEditPart) {
					WrappingLabel label = ((DropdownListEditPart) parent).getPrimaryShape().getDropdownList_text();
					label.setText(text);
					return;
				}
				if (parent instanceof DropdownList2EditPart) {
					WrappingLabel label = ((DropdownList2EditPart) parent).getPrimaryShape().getDropdownList_text();
					label.setText(text);
					return;
				}
				parent = parent.getParent();
			}
		}
	}
}
