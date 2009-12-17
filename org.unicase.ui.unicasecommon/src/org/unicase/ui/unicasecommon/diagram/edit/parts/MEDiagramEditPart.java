/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.diagram.edit.parts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.ui.unicasecommon.diagram.commands.CommandFactory;
import org.unicase.ui.unicasecommon.diagram.policies.ContainerNodeEditPolicy;

/**
 * @author denglerm This class is a superclass for the generated MEDiagramEditPart in each diagram plugin. It adds DND
 *         functionality
 */
public class MEDiagramEditPart extends DiagramEditPart {
	/**
	 * The Drag & Drop policy for diagrams. This class specifies what to with a DND on the diagram. It provides a
	 * command for the DropTargetListener in class @link org.unicase.ui.common.diagram.part.ModelDiagramEditor The
	 * provided command is a @link org.unicase.ui.common.diagram.commands.DiagramElementAddCommand.
	 * 
	 * @author denglerm
	 */
	// dengler: document more detailed
	private final class DiagramDragDropEditPolicyExtension extends DiagramDragDropEditPolicy {
		@SuppressWarnings("unchecked")
		@Override
		public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {
			List<ViewDescriptor> viewDescriptors = new ArrayList<ViewDescriptor>();
			for (Iterator it = dropRequest.getObjects().iterator(); it.hasNext();) {
				Object nextObject = it.next();
				if (!(nextObject instanceof EObject)) {
					continue;
				}
				viewDescriptors.add(new CreateViewRequest.ViewDescriptor(new EObjectAdapter((EObject) nextObject),
					Node.class, null, getDiagramPreferencesHint()));
			}
			return createDropCommand(dropRequest, viewDescriptors);
		}

		private Command createDropCommand(DropObjectsRequest dropRequest, List<ViewDescriptor> viewDescriptors) {
			Command command = createViewsAndArrangeCommand(dropRequest, viewDescriptors);
			if (command != null && dropRequest.getObjects().size() > 0) {

				return command.chain(CommandFactory.createDiagramElementAddCommand((EObject) dropRequest.getObjects()
					.iterator().next(), MEDiagramEditPart.this, true));

			}
			return null;
		}
	}

	/**
	 * The constructor.
	 * 
	 * @param view the view controlled by this edit part
	 */
	public MEDiagramEditPart(View view) {
		super(view);
	}

	/**
	 * This method installs the DND policy and a modified ContainerNodeEditPolicy. {@inheritDoc}
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ContainerNodeEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DiagramDragDropEditPolicyExtension());

	}

	/**
	 * This method updates the view if the elements list has changed.
	 * 
	 * @param event the event
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {
		Object feature = event.getFeature();
		if (DiagramPackage.eINSTANCE.getMEDiagram_Elements().equals(feature)) {
			this.updateView();
		}
		super.handleNotificationEvent(event);
	}

	/**
	 * Workaround if view gets not updated automatically.
	 */
	public void updateView() {
		CanonicalEditPolicy canonicalEditPolicy = (CanonicalEditPolicy) this
			.getEditPolicy(EditPolicyRoles.CANONICAL_ROLE);
		canonicalEditPolicy.refresh();
	}
}