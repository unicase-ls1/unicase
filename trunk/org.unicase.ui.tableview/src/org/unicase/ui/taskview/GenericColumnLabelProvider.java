package org.unicase.ui.taskview;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.ModelPackage;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.TaskPackage;

public class GenericColumnLabelProvider extends
		org.eclipse.jface.viewers.ColumnLabelProvider {

	private EStructuralFeature feature;
	private DecoratingLabelProvider decoratingLabelProvider;
	private static final String CHECKED_KEY = "CHECKED";
	private static final String UNCHECK_KEY = "UNCHECKED";

	public GenericColumnLabelProvider(METableViewer viewer,
			EStructuralFeature feature) {
		super();
		this.feature = feature;
		IDecoratorManager decoratorManager = PlatformUI.getWorkbench()
				.getDecoratorManager();
		decoratingLabelProvider = new DecoratingLabelProvider(
				new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE)),
				decoratorManager.getLabelDecorator());
		if (JFaceResources.getImageRegistry().getDescriptor(CHECKED_KEY) == null) {
			JFaceResources.getImageRegistry().put(UNCHECK_KEY,
					makeShot(viewer.getControl().getShell(), false));
			JFaceResources.getImageRegistry().put(CHECKED_KEY,
					makeShot(viewer.getControl().getShell(), true));
		}
	}

	private Image makeShot(Control control, boolean type) {
		// Hopefully no platform uses exactly this color
		// because we'll make it transparent in the image.
		Color greenScreen = new Color(control.getDisplay(), 222, 223, 224);

		Shell shell = new Shell(control.getShell(), SWT.NO_TRIM);

		// otherwise we have a default gray color
		shell.setBackground(greenScreen);

		Button button = new Button(shell, SWT.CHECK);
		button.setBackground(greenScreen);
		button.setSelection(type);

		// otherwise an image is located in a corner
		button.setLocation(1, 1);
		Point bsize = button.computeSize(SWT.DEFAULT, SWT.DEFAULT);

		// otherwise an image is stretched by width
		bsize.x = Math.max(bsize.x - 1, bsize.y - 1);
		bsize.y = Math.max(bsize.x - 1, bsize.y - 1);
		button.setSize(bsize);
		shell.setSize(bsize);

		shell.open();
		GC gc = new GC(shell);
		Image image = new Image(control.getDisplay(), bsize.x, bsize.y);
		gc.copyArea(image, 0, 0);
		gc.dispose();
		shell.close();

		ImageData imageData = image.getImageData();
		imageData.transparentPixel = imageData.palette.getPixel(greenScreen
				.getRGB());

		return new Image(control.getDisplay(), imageData);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof EObject) {
			Object attr = ((EObject) element).eGet(feature, true);
			if ((attr == null)
					|| (feature.equals(TaskPackage.Literals.CHECKABLE__CHECKED))) {
				return "";
			}
			try {
				Method getName = attr.getClass().getMethod("getName");
				Object name = getName.invoke(attr);
				return (String) name;
			} catch (SecurityException e) {
				return attr != null ? attr.toString() : "";
			} catch (NoSuchMethodException e) {
				return attr != null ? attr.toString() : "";
			} catch (IllegalArgumentException e) {
				return attr != null ? attr.toString() : "";
			} catch (IllegalAccessException e) {
				return attr != null ? attr.toString() : "";
			} catch (InvocationTargetException e) {
				return attr != null ? attr.toString() : "";
			} catch (NullPointerException e) {
				return attr != null ? attr.toString() : "";
			}

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
		if (this.feature.equals(ModelPackage.Literals.MODEL_ELEMENT__NAME)) {
			image = decoratingLabelProvider.getImage(element);
			decoratingLabelProvider.getLabelDecorator().decorateImage(image,
					element);
		}
		if ((element instanceof Checkable)
				&& (feature.equals(TaskPackage.Literals.CHECKABLE__CHECKED))) {
			Checkable c = (Checkable) element;
			if (c.isChecked()) {
				return JFaceResources.getImageRegistry().getDescriptor(
						CHECKED_KEY).createImage();
			} else {
				return JFaceResources.getImageRegistry().getDescriptor(
						UNCHECK_KEY).createImage();
			}
		}
		return image;
	}
}
