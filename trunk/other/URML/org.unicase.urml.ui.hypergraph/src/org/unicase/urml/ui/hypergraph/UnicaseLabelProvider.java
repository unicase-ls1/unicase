package org.unicase.urml.ui.hypergraph;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.zest.core.viewers.EntityConnectionData;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;

public class UnicaseLabelProvider extends LabelProvider {

	private AdapterFactoryLabelProvider parent;

	public UnicaseLabelProvider() {
		parent = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	@Override
	public String getText(Object element) {
		if (element instanceof EntityConnectionData) {
			return "";
		}
		element = ((GraphEObjectLayouted) element).object;
		if (element instanceof Project) {
			element = ((EObject) element).eContainer();
		} else if (element instanceof UnicaseModelElement) {
			return ((UnicaseModelElement) element).getName();
		}
		return parent.getText(element);
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof EntityConnectionData) {
			return null;
		}
		element = ((GraphEObjectLayouted) element).object;
		if (element instanceof Project) {
			element = ((EObject) element).eContainer();
		}
		return parent.getImage(element);
	}
}
