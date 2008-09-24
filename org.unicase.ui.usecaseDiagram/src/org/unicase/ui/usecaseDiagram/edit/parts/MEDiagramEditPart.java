package org.unicase.ui.usecaseDiagram.edit.parts;

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
 * @generated
 */
public class MEDiagramEditPart extends DiagramEditPart {

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "UseCase"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 77;

	/**
	 * @generated
	 */
	public MEDiagramEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new org.unicase.ui.usecaseDiagram.edit.policies.MEDiagramItemSemanticEditPolicy());
		installEditPolicy(
				EditPolicyRoles.CANONICAL_ROLE,
				new org.unicase.ui.usecaseDiagram.edit.policies.MEDiagramCanonicalEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DiagramDragDropEditPolicy() {
					public Command getDropObjectsCommand(
							DropObjectsRequest dropRequest) {
						List viewDescriptors = new ArrayList();
						for (Iterator it = dropRequest.getObjects().iterator(); it
								.hasNext();) {
							Object nextObject = it.next();
							if (false == nextObject instanceof EObject) {
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
											new org.unicase.ui.usecaseDiagram.edit.commands.UseCaseAddCommand(req)));
													
						}
						return null;
					}
				});
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}
	protected void handleNotificationEvent(Notification event) {
		int type = event.getEventType();
		Object feature = event.getFeature();
		if (DiagramPackage.eINSTANCE.getMEDiagram_Elements().equals(feature)) {
			CanonicalEditPolicy canonicalEditPolicy = (CanonicalEditPolicy) this
					.getEditPolicy(EditPolicyRoles.CANONICAL_ROLE);
			canonicalEditPolicy.refresh();			
		}
		super.handleNotificationEvent(event);
	}
}