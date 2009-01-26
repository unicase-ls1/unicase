package org.unicase.workspace.edit.views.validationview;

import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.validation.model.IConstraintStatus;

/**
 * Contentprovider for validation view.
 * 
 * @author wesendonk
 */
public class ValidationContentProvider extends AdapterFactoryContentProvider {

	/**
	 * Default constructor.
	 */
	public ValidationContentProvider() {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object[] getElements(Object inputElement) {
		List<IConstraintStatus> constraints = (List<IConstraintStatus>) inputElement;
		return constraints.toArray(new Object[constraints.size()]);
	}

}
