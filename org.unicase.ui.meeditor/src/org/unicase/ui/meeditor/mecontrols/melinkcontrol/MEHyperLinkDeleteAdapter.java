package org.unicase.ui.meeditor.mecontrols.melinkcontrol;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.unicase.model.ModelElement;

/**
 * A {@link HyperlinkAdapter} regarding deletion of model elements. 
 * @author helming
 *
 */
public class MEHyperLinkDeleteAdapter extends HyperlinkAdapter implements
		IHyperlinkListener {

	private EObject modelElement;
	private EReference reference;
	private EObject opposite;
	
	/**
	 * Default constructor.
	 * @param modelElement the model element
	 * @param reference the reference link
	 * @param opposite the model element on the other side of the link
	 */
	public MEHyperLinkDeleteAdapter(EObject modelElement, EReference reference,
			EObject opposite) {
		this.modelElement = modelElement;
		this.reference = reference;
		this.opposite = opposite;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void linkActivated(HyperlinkEvent e) {
		Object object = modelElement.eGet(reference);
		
		if (reference.isContainer()) {
			ModelElement me = ((ModelElement) modelElement);
			((ModelElement) opposite).getProject().addModelElement(me);
			return;
		}
		if(reference.isContainment()){
			ModelElement me = ((ModelElement) opposite);
			((ModelElement) modelElement).getProject().addModelElement(me);
			return;
		}
		
		if (object instanceof EList) {
			EList<EObject> list = (EList<EObject>) object;
			list.remove(opposite);
			return;
		}
		else{
			modelElement.eSet(reference, null);
			return;
		}

		
	}
}
