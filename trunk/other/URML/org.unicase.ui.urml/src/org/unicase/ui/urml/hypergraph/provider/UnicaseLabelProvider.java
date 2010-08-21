package org.unicase.ui.urml.hypergraph.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.zest.core.viewers.EntityConnectionData;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.urml.hypergraph.layout.GraphEObjectLayouted;

/**
 * Reduce standard Unicase label provider to minimum of label text.
 * 
 * @author Michael
 */
public class UnicaseLabelProvider extends LabelProvider {

	private AdapterFactoryLabelProvider parent;

	public UnicaseLabelProvider() {
		parent = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	@Override
	public String getText(Object element) {
		if (element instanceof EntityConnectionData) {
			// connections without label
			return "";
		}
		// unwrap
		element = ((GraphEObjectLayouted) element).object;
		if (element instanceof Project) {
			// for project get the project space (to get name and icon)
			element = ((EObject) element).eContainer();
		} else if (element instanceof UnicaseModelElement) {
			// only display name
			return ((UnicaseModelElement) element).getName();
		}
		// display type and name if don't know type before
		return parent.getText(element);
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof EntityConnectionData) {
			// connections without icons
			return null;
		}
		// unwrap
		element = ((GraphEObjectLayouted) element).object;
		if (element instanceof Project) {
			// for project get the project space (to get name and icon)
			element = ((EObject) element).eContainer();
		}
		return parent.getImage(element);
	}
}
