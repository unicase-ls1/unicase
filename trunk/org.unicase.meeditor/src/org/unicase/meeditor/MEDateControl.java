package org.unicase.meeditor;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class MEDateControl extends AbstractMEControl implements MEControl {
	FormToolkit toolkit;
	EAttribute attribute;
	EObject modelElement;
	EditingDomain editingDomain;
	
	public MEDateControl(EAttribute attribute, FormToolkit toolkit,
			EObject modelElement, EditingDomain editingDomain) {
		super();
		this.attribute = attribute;
		this.editingDomain = editingDomain;
		this.modelElement = modelElement;
		this.toolkit = toolkit;
	}

	public Control createControl(Composite parent, int style) {
		Composite composite = toolkit.createComposite(parent);
		composite.setLayout(new GridLayout(2,false));
		
//		Label label= toolkit.createLabel(composite, modelElement.eGet(attribute).toString());
		
		DateTime date = new DateTime(composite, style);
		
		IObservableValue model = EMFEditObservables.observeValue(editingDomain,
				modelElement, attribute);
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		//dbc.bindValue(SWTObservables., model, null,		null);
		

		
		return composite;
	}

}
