package org.unicase.ui.taskview;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class GenericColumnLabelProvider extends
		org.eclipse.jface.viewers.ColumnLabelProvider {

	private EStructuralFeature feature;

	public GenericColumnLabelProvider(EStructuralFeature feature) {
		super();
		this.feature = feature;
	}

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

}
