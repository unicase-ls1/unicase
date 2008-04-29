package org.unicase.meeditor;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class METextControl extends AbstractMEControl implements MEControl
		 {

	Text text;
	FormToolkit toolkit;
	EAttribute attribute;
	EObject modelElement;
	EditingDomain editingDomain;

	public METextControl(EAttribute attribute, FormToolkit toolkit,
			EObject modelElement,EditingDomain editingDomain) {
		super();
		this.attribute = attribute;
		this.toolkit = toolkit;
		this.modelElement = modelElement;
		this.editingDomain= editingDomain;
	}

	
	public Control createControl(Composite parent, int style) {
		text = toolkit.createText(parent, new String(), style);
		IObservableValue model = EMFEditObservables.observeValue(editingDomain, modelElement, attribute);
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		dbc.bindValue(SWTObservables.observeText(text, SWT.FocusOut), model, null, null);	
		return text;
	}

}
