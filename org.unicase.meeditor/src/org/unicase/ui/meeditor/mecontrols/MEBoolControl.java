package org.unicase.ui.meeditor.mecontrols;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * This is the standard Control to edit boolean values.
 * 
 * @author helming
 * 
 */
public class MEBoolControl extends AbstractMEControl implements MEControl {

	private EAttribute attribute;

	private Button check;

	/**
	 * Standard Constructor. {@inheritDoc}
	 * 
	 * @param attribute
	 *            the boolean attribute
	 * @param toolkit
	 *            see {@link AbstractMEControl}
	 * @param modelElement
	 *            see {@link AbstractMEControl}
	 * @param editingDomain
	 *            see {@link AbstractMEControl}
	 */
	public MEBoolControl(EAttribute attribute, FormToolkit toolkit,
			EObject modelElement, EditingDomain editingDomain) {
		super(editingDomain, modelElement, toolkit);
		this.attribute = attribute;
	}

	/**
	 * returns a check button without Label. {@inheritDoc}
	 * 
	 * @return Control
	 */
	public Control createControl(Composite parent, int style) {
		check = toolkit.createButton(parent, "", SWT.CHECK);
		IObservableValue model = EMFEditObservables.observeValue(editingDomain,
				modelElement, attribute);
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		dbc
				.bindValue(SWTObservables.observeSelection(check), model, null,
						null);
		return check;
	}

}
