package org.unicase.ui.taskview;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.Format;
import java.text.SimpleDateFormat;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.model.task.TaskPackage;

/**
 * @author hamidmomeny
 */
public class CreationDateColumnLabelProvider extends GenericColumnLabelProvider {

	/**
	 * default constructor.
	 * 
	 * @param viewer the table viewer
	 * @param feature the feature.
	 */
	public CreationDateColumnLabelProvider(METableViewer viewer, EStructuralFeature feature) {
		super(viewer, feature);
		// TODO Auto-generated constructor stub
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		Format formatter = new SimpleDateFormat("yyyy MM.dd. HH:mm:ss");
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
				return formatter.format(attr);
			}

			try {
				name = getName.invoke(attr);
			} catch (IllegalArgumentException e) {
				return formatter.format(attr);
			} catch (IllegalAccessException e) {
				return formatter.format(attr);
			} catch (InvocationTargetException e) {
				return formatter.format(attr);
			}
			if (name == null) {
				formatter.format(attr);
			}
			return formatter.format(name);

		} else {
			return element == null ? "" : formatter.format(element);
		}
	}

}
