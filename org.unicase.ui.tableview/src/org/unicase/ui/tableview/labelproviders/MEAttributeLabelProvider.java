/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.tableview.labelproviders;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.TaskPackage;

/**
 * A specific ColumnLabelProvider for the display of IItemPropertyDescriptors . LabelProvider for UnicaseTableView .
 * 
 * @author abdelhamidbarzali.
 */
public class MEAttributeLabelProvider extends ColumnLabelProvider {
	private IItemPropertyDescriptor propertyDescriptor;

	private AdapterFactoryLabelProvider adapterFactoryLabelProvider;
	private EStructuralFeature estructuralfeature;
	private DecoratingLabelProvider decoratingLabelProvider;

	private static final String CHECKED_KEY = "CHECKED";
	private static final String UNCHECK_KEY = "UNCHECKED";

	/**
	 * the constructor.
	 */
	public MEAttributeLabelProvider() {

		super();
		adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param propertyDescriptor {@link IItemPropertyDescriptor}.
	 * @param estructuralfeature {@link EStructuralFeature} feature the feature that this provider shall return a label
	 *            for.
	 */
	public MEAttributeLabelProvider(IItemPropertyDescriptor propertyDescriptor, EStructuralFeature estructuralfeature) {
		this();
		this.propertyDescriptor = propertyDescriptor;
		setEstructuralfeature(estructuralfeature);
		IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
		setDecoratingLabelProvider(new DecoratingLabelProvider(new AdapterFactoryLabelProvider(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)), decoratorManager
			.getLabelDecorator()));
		if (JFaceResources.getImageRegistry().getDescriptor(CHECKED_KEY) == null) {
			JFaceResources.getImageRegistry().put(UNCHECK_KEY, makeShot(false));
			JFaceResources.getImageRegistry().put(CHECKED_KEY, makeShot(true));
		}

	}

	/**
	 * @return {@link DecoratingLabelProvider}.
	 */
	public DecoratingLabelProvider getDecoratingLabelProvider() {
		return decoratingLabelProvider;
	}

	/**
	 * @param decoratingLabelProvider {@link DecoratingLabelProvider}.
	 */
	public void setDecoratingLabelProvider(DecoratingLabelProvider decoratingLabelProvider) {
		this.decoratingLabelProvider = decoratingLabelProvider;
	}

	/**
	 * @return {@link EStructuralFeature}.
	 */
	public EStructuralFeature getEstructuralfeature() {
		return estructuralfeature;
	}

	/**
	 * @param estructuralfeature {@link EStructuralFeature}.
	 */
	public void setEstructuralfeature(EStructuralFeature estructuralfeature) {
		this.estructuralfeature = estructuralfeature;
	}

	/**
	 * @return AdapterFactoryLabelProvider .
	 */
	protected AdapterFactoryLabelProvider getAdAdapterFactoryLabelProvider() {

		return adapterFactoryLabelProvider;
	}

	/**
	 * @param object Object.
	 * @return Image.
	 */
	protected Image getAdapterImage(Object object) {
		return getAdAdapterFactoryLabelProvider().getImage(object);
	}

	/**
	 * @param type {@link Boolean}.
	 * @return {@link Image}.
	 */
	private Image makeShot(boolean type) {
		// Hopefully no platform uses exactly this color
		// because we'll make it transparent in the image.
		Display display = Display.getDefault();
		Color greenScreen = new Color(display, 222, 223, 224);

		Shell tmpShell = new Shell(display, SWT.NO_TRIM | SWT.ON_TOP);
		tmpShell.setVisible(false);

		// otherwise we have a default gray color
		tmpShell.setBackground(greenScreen);

		Button button = new Button(tmpShell, SWT.CHECK);
		button.setBackground(greenScreen);
		button.setSelection(type);

		// otherwise an image is located in a corner
		button.setLocation(1, 1);
		Point bsize = button.computeSize(SWT.DEFAULT, SWT.DEFAULT);

		// otherwise an image is stretched by width
		// bsize.x = bsize.x - 1;
		// bsize.y = bsize.y - 3;
		bsize.x = Math.max(bsize.x - 1, bsize.y - 1);
		bsize.y = Math.max(bsize.x - 1, bsize.y - 1);
		button.setSize(bsize);
		tmpShell.setSize(bsize);

		tmpShell.open();
		GC gc = new GC(tmpShell);
		Image image = new Image(display, bsize.x, bsize.y);
		gc.copyArea(image, 0, 0);
		gc.dispose();
		tmpShell.close();
		tmpShell.dispose();

		ImageData imageData = image.getImageData();
		imageData.transparentPixel = imageData.palette.getPixel(greenScreen.getRGB());
		image.dispose();

		Image ret = new Image(display, imageData);

		return ret;
	}

	/**
	 * . ({@inheritDoc})
	 * 
	 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {

		if (getEstructuralfeature().getEType().getInstanceClass().equals(boolean.class)) {

			return "";

		}

		if (element instanceof ModelElement) {
			// Returns the plain text of the description.
			if (getEstructuralfeature().equals(ModelPackage.Literals.MODEL_ELEMENT__DESCRIPTION)) {
				ModelElement me = (ModelElement) element;

				return me.getDescriptionPlainText();

			}
		}
		String result = "";
		if (propertyDescriptor != null) {
			if (propertyDescriptor.isPropertySet(element)) {
				ItemPropertyDescriptor.PropertyValueWrapper valueWrapper = (ItemPropertyDescriptor.PropertyValueWrapper) propertyDescriptor
					.getPropertyValue(element);
				result = valueWrapper.getText(element);

			} else {
				result = "";
			}
		}

		return result;

	}

	/**
	 *{@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {

		Image image = null;

		if (getEstructuralfeature().equals(ModelPackage.Literals.MODEL_ELEMENT__NAME)) {
			image = getDecoratingLabelProvider().getImage(element);
			getDecoratingLabelProvider().getLabelDecorator().decorateImage(image, element);

		}

		if ((element instanceof Checkable) && (getEstructuralfeature().equals(TaskPackage.Literals.CHECKABLE__CHECKED))) {
			Checkable c = (Checkable) element;
			if (c.isChecked()) {
				image = JFaceResources.getImageRegistry().get(CHECKED_KEY);
			} else {
				image = JFaceResources.getImageRegistry().get(UNCHECK_KEY);
			}
		}

		if (image == null) {
			ItemPropertyDescriptor.PropertyValueWrapper valueWrapper = null;

			if (propertyDescriptor != null) {

				if (propertyDescriptor.isPropertySet(element)) {
					valueWrapper = (ItemPropertyDescriptor.PropertyValueWrapper) propertyDescriptor
						.getPropertyValue(element);

					image = getAdapterImage(valueWrapper);

				}
			}

		}

		return image;

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.BaseLabelProvider#dispose()
	 */
	@Override
	public void dispose() {
		if (JFaceResources.getImageRegistry().getDescriptor(CHECKED_KEY) == null) {
			Image uncheckimage = JFaceResources.getImageRegistry().get(UNCHECK_KEY);
			if (uncheckimage != null) {
				uncheckimage.dispose();
			}
			Image checkimage = JFaceResources.getImageRegistry().get(CHECKED_KEY);
			if (checkimage != null) {
				checkimage.dispose();
			}
		}
		if (getAdAdapterFactoryLabelProvider() != null) {
			getAdAdapterFactoryLabelProvider().dispose();
		}

		super.dispose();
	}
}
