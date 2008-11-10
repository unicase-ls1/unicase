package org.unicase.workspace.edit.views.validationview;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.unicase.model.ModelElement;

/**
 * Lableprovider for validation view.
 * 
 * @author wesendon
 */
public class ValidationLableProvider extends AdapterFactoryLabelProvider {

	private static final int SEVERITY = 0;
	private static final int DESCRIPTION = 1;
	private static final int MODELELEMENT = 2;

	/**
	 * Default constructor.
	 */
	public ValidationLableProvider() {
		super(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getColumnText(Object object, int columnIndex) {
		if(object instanceof IConstraintStatus) {
			IConstraintStatus constraint = (IConstraintStatus) object;
			switch (columnIndex) {
			case SEVERITY:
				return ""+constraint.getSeverity();
			case DESCRIPTION:
				return constraint.getMessage();
			case MODELELEMENT:
				EObject target = constraint.getTarget();
				if(target instanceof ModelElement) {
					return ((ModelElement) target).getName();
				}
				break;
			default:
					break;
			}
		} 
		return super.getColumnText(object, columnIndex);
	}
}
