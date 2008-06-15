package org.unicase.ui.meeditor.mecontrols;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * Abstract class for the ME controls.
 * 
 * @author helming
 * 
 */
public abstract class AbstractMEControl implements MEControl {

	// AS: change to private and generate getters?
	protected FormToolkit toolkit;
	protected EObject modelElement;
	protected EditingDomain editingDomain;

	/**
	 * Default constructor.
	 * 
	 * @param editingDomain
	 *            the editing domain
	 * @param modelElement
	 *            the ME
	 * @param toolkit
	 *            gui toolkit used for rendering
	 */
	public AbstractMEControl(EditingDomain editingDomain, EObject modelElement,
			FormToolkit toolkit) {
		super();
		this.editingDomain = editingDomain;
		this.modelElement = modelElement;
		this.toolkit = toolkit;
	}

}
