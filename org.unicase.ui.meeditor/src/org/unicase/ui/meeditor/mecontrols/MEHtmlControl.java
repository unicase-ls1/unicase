package org.unicase.ui.meeditor.mecontrols;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class MEHtmlControl extends AbstractMEControl {

	public MEHtmlControl(EditingDomain editingDomain, EObject modelElement,
			FormToolkit toolkit) {
		super(editingDomain, modelElement, toolkit);
		// TODO Auto-generated constructor stub
	}

	public MEHtmlControl(EAttribute attribute, FormToolkit toolkit,
			EObject modelElement, EditingDomain editingDomain) {
		super(editingDomain, modelElement, toolkit);
		// TODO Auto-generated constructor stub
	}

	public Control createControl(Composite parent, int style) {
		Browser browser = new Browser(parent, style);
	
		return browser;
	}

}
