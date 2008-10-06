/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.common.diagram;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.diagram.DiagramPackage;

/**
 * @author denglerm
 * This class is a superclass for the specific MEDiagramEditPart in each diagram.
 */
public class MEDiagramEditPart extends DiagramEditPart {

	/**.
	 * The constructor
	 * @param view the view controlled by this edit part
	 */
	public MEDiagramEditPart(View view) {
		super(view);
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();		
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DiagramDragDropEditPolicy() {
					@Override
					public Command getDropObjectsCommand(
							DropObjectsRequest dropRequest) {
						List viewDescriptors = new ArrayList();
						for (Iterator it = dropRequest.getObjects().iterator(); it
								.hasNext();) {
							Object nextObject = it.next();
							if (!(nextObject instanceof EObject)) {
								continue;
							}
							viewDescriptors
									.add(new CreateViewRequest.ViewDescriptor(
											new EObjectAdapter(
													(EObject) nextObject),
											Node.class, null,
											getDiagramPreferencesHint()));
						}						
						return createShortcutsCommand(dropRequest,
								viewDescriptors);
					}

					private Command createShortcutsCommand(
							DropObjectsRequest dropRequest, List viewDescriptors) {
						Command command = createViewsAndArrangeCommand(
								dropRequest, viewDescriptors);
						if (command != null) {
							CreateElementRequest req = new CreateElementRequest(((View)getModel()).getElement(),
									ElementTypeRegistry.getInstance().getElementType(dropRequest.getObjects().
											iterator().next()));
									req.setNewElement((EObject)dropRequest.getObjects().iterator().next());
											
							return command
									.chain(new ICommandProxy(
											new org.unicase.ui.common.commands.DiagramElementAddCommand(req)));
													
						}
						return null;
					}
				});

	}
	/**
	 * . {@inheritDoc}
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {
		Object feature = event.getFeature();
		if(DiagramPackage.eINSTANCE.getMEDiagram_Elements().equals(feature)) {
			CanonicalEditPolicy canonicalEditPolicy = (CanonicalEditPolicy) this
					.getEditPolicy(EditPolicyRoles.CANONICAL_ROLE);
			canonicalEditPolicy.refresh();			
		}
		super.handleNotificationEvent(event);
	}
}