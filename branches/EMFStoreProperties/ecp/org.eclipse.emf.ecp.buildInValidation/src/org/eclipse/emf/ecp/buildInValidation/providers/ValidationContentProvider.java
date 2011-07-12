package org.eclipse.emf.ecp.buildInValidation.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

/**
 * Content Provider for validation view.
 * 
 * @author Carmen Carlan
 * 
 */
public class ValidationContentProvider extends AdapterFactoryContentProvider {

	/**
	 * Default constructor.
	 */
	public ValidationContentProvider() {
		super(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getElements
	 * (java.lang.Object)
	 */
	@Override
	public Object[] getElements(Object inputElement) {
		IStatus status = BasicDiagnostic
				.toIStatus((BasicDiagnostic) inputElement);

		List<IStatus> constraints = new ArrayList<IStatus>();
		if (status.isMultiStatus()) {
			IStatus[] statuses = status.getChildren();
			for (int i = 0; i < statuses.length; i++) {
				constraints.add(statuses[i]);

			}
		} else {
			constraints.add(status);
		}

		return constraints.toArray(new Object[constraints.size()]);
	}

}
