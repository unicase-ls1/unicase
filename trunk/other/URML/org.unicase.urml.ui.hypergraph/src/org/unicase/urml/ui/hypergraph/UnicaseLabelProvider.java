package org.unicase.urml.ui.hypergraph;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.zest.core.viewers.EntityConnectionData;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;

public class UnicaseLabelProvider extends LabelProvider {

	private AdapterFactoryLabelProvider parent;
	private static UnicaseLabelProvider _instance;

	public static UnicaseLabelProvider getInstance() {
		if (_instance == null) {
			_instance = new UnicaseLabelProvider();
		}
		return _instance;
	}

	private UnicaseLabelProvider() {
		parent = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	@Override
	public String getText(Object element) {
		if (element instanceof EntityConnectionData) {
			return "";
		} else if (element instanceof Project) {
			return "Project";
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
		return parent.getImage(element);
	}
}
