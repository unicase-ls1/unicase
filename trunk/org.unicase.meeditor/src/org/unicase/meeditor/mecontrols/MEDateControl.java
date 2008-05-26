package org.unicase.meeditor.mecontrols;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * Standard widgets to edit a date attribute.
 * 
 * @author helming
 * 
 */
public class MEDateControl extends AbstractMEControl implements MEControl {

	private EAttribute attribute;

	/**
	 * default constructor.
	 * 
	 * @param attribute
	 *            the date attribute
	 * @param toolkit
	 *            see {@link AbstractMEControl}
	 * @param modelElement
	 *            see {@link AbstractMEControl}
	 * @param editingDomain
	 *            see {@link AbstractMEControl}
	 */
	public MEDateControl(EAttribute attribute, FormToolkit toolkit,
			EObject modelElement, EditingDomain editingDomain) {
		super(editingDomain, modelElement, toolkit);
		this.attribute = attribute;
	}

	/**
	 * @return A composite with a DateTime and a DatePicker on it. {@inheritDoc}
	 */
	public Control createControl(Composite parent, int style) {
		Composite composite = toolkit.createComposite(parent);
		composite.setLayout(new GridLayout(2, false));

		DateTime date = new DateTime(composite, style);
		IObservableValue model = EMFEditObservables.observeValue(editingDomain,
				modelElement, attribute);
		// JH: make this work if SWTObserveable.observeDate is released
		// JH: include date Picker
		// IObservableValue target = SWTObservables.observeEditable(date);
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		// dbc.bindValue(target, model, null, null);

		return composite;
	}

}
