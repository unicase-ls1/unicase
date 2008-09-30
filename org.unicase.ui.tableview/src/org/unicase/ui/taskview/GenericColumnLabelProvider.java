package org.unicase.ui.taskview;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.ModelPackage;

public class GenericColumnLabelProvider extends
		org.eclipse.jface.viewers.ColumnLabelProvider {

	private EStructuralFeature feature;
	private DecoratingLabelProvider decoratingLabelProvider;

	public GenericColumnLabelProvider(EStructuralFeature feature) {
		super();
		this.feature = feature;
		IDecoratorManager decoratorManager = PlatformUI.getWorkbench()
				.getDecoratorManager();
		decoratingLabelProvider = new DecoratingLabelProvider(
				new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE)),
				decoratorManager.getLabelDecorator());
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
		return image;
	}

}
