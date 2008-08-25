package org.unicase.ui.stem.views.statusview;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.unicase.model.ModelElement;
import org.unicase.model.task.Assignable;
import org.unicase.model.task.Checkable;

public class TableContentProvider extends AdapterFactoryContentProvider {

	public TableContentProvider() {
		super(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object[] getElements(Object object) {
		if (object instanceof ModelElement) {
			ModelElement me = (ModelElement) object;
			Set<ModelElement> result = getContentsRecursive(me);
			return result.toArray(new Object[result.size()]);

		} else {
			return null;
		}

	}

	private Set<ModelElement> getContentsRecursive(ModelElement me) {
		Set<ModelElement> result = new HashSet<ModelElement>();
		EList<EObject> contents = me.eContents();
		for (EObject eObject : contents) {
			if (eObject instanceof ModelElement) {
				ModelElement modelElement = (ModelElement)eObject;
				if(modelElement instanceof Checkable || modelElement instanceof Assignable){
					result.add(modelElement);
				}
				
				result.addAll(getContentsRecursive((ModelElement) eObject));
			}
		}
		for (ModelElement annotation : me.getAnnotations()) {
			result.add(annotation);
		}

		return result;

	}

}

