package org.unicase.ui.meeditor.mecontrols;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.forms.widgets.FormToolkit;



public abstract class AbstractMEControl implements MEControl {
	protected FormToolkit toolkit;
	protected EObject modelElement;
	protected EditingDomain editingDomain;
	
	/**
	 * Default constructor.
	 * @param editingDomain
	 * @param modelElement
	 * @param toolkit
	 */
	public AbstractMEControl(EditingDomain editingDomain, EObject modelElement,
			FormToolkit toolkit) {
		super();
		this.editingDomain = editingDomain;
		this.modelElement = modelElement;
		this.toolkit = toolkit;
	}
	
}
