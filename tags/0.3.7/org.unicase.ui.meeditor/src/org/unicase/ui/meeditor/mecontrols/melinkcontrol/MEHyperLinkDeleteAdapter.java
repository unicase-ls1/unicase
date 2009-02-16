/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols.melinkcontrol;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.unicase.model.ModelElement;
import org.unicase.model.NonDomainElement;
import org.unicase.ui.common.commands.DeleteModelElementCommand;
import org.unicase.ui.common.commands.DeleteReferenceCommand;

/**
 * A {@link HyperlinkAdapter} regarding deletion of model elements.
 * 
 * @author helming
 */
public class MEHyperLinkDeleteAdapter extends HyperlinkAdapter implements IHyperlinkListener {

	private EObject modelElement;
	private EReference reference;
	private EObject opposite;

	/**
	 * Default constructor.
	 * 
	 * @param modelElement the model element
	 * @param reference the reference link
	 * @param opposite the model element on the other side of the link
	 */
	public MEHyperLinkDeleteAdapter(EObject modelElement, EReference reference, EObject opposite) {
		this.modelElement = modelElement;
		this.reference = reference;
		this.opposite = opposite;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void linkActivated(HyperlinkEvent e) {
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(modelElement);
		RecordingCommand command = null;
		if (reference.isContainment() && opposite instanceof NonDomainElement) {
			command = new DeleteModelElementCommand(domain, (ModelElement) opposite);
		} else {
			command = new DeleteReferenceCommand(domain, (ModelElement) modelElement, reference,
				(ModelElement) opposite);
		}
		domain.getCommandStack().execute(command);
	}
}
