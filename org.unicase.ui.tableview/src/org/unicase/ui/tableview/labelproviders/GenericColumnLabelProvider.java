/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tableview.labelproviders;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.ModelPackage;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.TaskPackage;
import org.unicase.ui.tableview.viewer.METableViewer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * A specific ColumnLabelProvider for the display of features of Checkable instances. For the
 * {@link TaskPackage.Literals.CHECKABLE__CHECKED} feature, it returns images of CheckBoxes. For the
 * {@link ModelPackage.Literals.MODEL_ELEMENT__NAME} feature, it uses a {@link DecoratingLabelProvider} to return a
 * decorated image consisting of a symbol corresponding to the model element type and possible decorations.
 * 
 * @author Florian Schneider
 * @author Jonas Helming
 */
public class GenericColumnLabelProvider extends org.eclipse.jface.viewers.ColumnLabelProvider {
	/**
	 * The feature.
	 */
	private EStructuralFeature feature;
	private DecoratingLabelProvider decoratingLabelProvider;
	private static final String CHECKED_KEY = "CHECKED";
	private static final String UNCHECK_KEY = "UNCHECKED";

	/**
	 * Creates a specific ColumnLabelProvider for the display of features of Checkable instances.
	 * 
	 * @param viewer the viewer that uses this column provider for a specific column
	 * @param feature the feature that this provider shall return a label for
	 */
	public GenericColumnLabelProvider(METableViewer viewer, EStructuralFeature feature) {
		super();
		this.setFeature(feature);
		IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
		decoratingLabelProvider = new DecoratingLabelProvider(new AdapterFactoryLabelProvider(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)), decoratorManager
			.getLabelDecorator());
		if (JFaceResources.getImageRegistry().getDescriptor(CHECKED_KEY) == null) {
			JFaceResources.getImageRegistry().put(UNCHECK_KEY, makeShot(false));
			JFaceResources.getImageRegistry().put(CHECKED_KEY, makeShot(true));
		}
	}

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

		Point bsize = button.computeSize(SWT.DEFAULT, SWT.DEFAULT);

		// otherwise an image is stretched by width
		bsize.x = Math.min(bsize.x, 16);
		bsize.y = Math.min(bsize.y, 16);
		button.setSize(bsize);

		tmpShell.setSize(17, 17);
		GridLayout gridLayout = new GridLayout(1, true);
		gridLayout.marginHeight = 0;
		gridLayout.marginTop = 0;
		gridLayout.marginRight = 2;
		gridLayout.marginWidth = 0;
		gridLayout.horizontalSpacing = 0;
		gridLayout.verticalSpacing = 0;

		tmpShell.setLayout(gridLayout);

		GridData gridData = new GridData(SWT.RIGHT, SWT.TOP, false, false);
		button.setLayoutData(gridData);

		button.setLocation(17 - bsize.x, 0);

		tmpShell.setBackground(display.getSystemColor(SWT.COLOR_RED));

		tmpShell.open();
		GC gc = new GC(tmpShell);
		Image image = new Image(display, 16, 16);
		gc.copyArea(image, 1, 1);
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
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof EObject) {
			Object attr = ((EObject) element).eGet(getFeature(), true);
			if ((attr == null) || (getFeature().equals(TaskPackage.Literals.CHECKABLE__CHECKED))) {
				return "";
			}
			Method getName;
			Object name;
			try {
				getName = attr.getClass().getMethod("getName");
			} catch (NoSuchMethodException e) {
				return attr.toString();
			}

			try {
				name = getName.invoke(attr);
			} catch (IllegalArgumentException e) {
				return attr.toString();
			} catch (IllegalAccessException e) {
				return attr.toString();
			} catch (InvocationTargetException e) {
				return attr.toString();
			}
			if (name == null) {
				attr.toString();
			}
			return (String) name;

		} else {
			return super.getText(element);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {
		Image image = null;
		if (this.getFeature().equals(ModelPackage.Literals.MODEL_ELEMENT__NAME)) {
			image = decoratingLabelProvider.getImage(element);
			decoratingLabelProvider.getLabelDecorator().decorateImage(image, element);
		}
		if ((element instanceof Checkable) && (getFeature().equals(TaskPackage.Literals.CHECKABLE__CHECKED))) {
			Checkable c = (Checkable) element;
			if (c.isChecked()) {
				return JFaceResources.getImageRegistry().get(CHECKED_KEY);
			} else {
				return JFaceResources.getImageRegistry().get(UNCHECK_KEY);
			}
		}
		return image;
	}

	/**
	 * set the feature.
	 * 
	 * @param feature the feature.
	 */
	public void setFeature(EStructuralFeature feature) {
		this.feature = feature;
	}

	/**
	 * get the feature.
	 * 
	 * @return the feature.
	 */
	public EStructuralFeature getFeature() {
		return feature;
	}
}
