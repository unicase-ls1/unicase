package scrm.diagram.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableLabelEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import scrm.ScrmPackage;
import scrm.diagram.commands.CommandFactory;
import scrm.diagram.edit.policies.SCRMDiagramCanonicalEditPolicy;
import scrm.diagram.edit.policies.SCRMDiagramItemSemanticEditPolicy;

/**
 * @generated
 */
public class SCRMDiagramEditPart extends DiagramEditPart {

	private final class DiagramDragDropEditPolicyExtension extends
			DiagramDragDropEditPolicy {
		@Override
		public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {
			List<ViewDescriptor> viewDescriptors = new ArrayList<ViewDescriptor>();
			for (Iterator it = dropRequest.getObjects().iterator(); it
					.hasNext();) {
				Object nextObject = it.next();
				if (!(nextObject instanceof EObject)) {
					continue;
				}
				viewDescriptors.add(new CreateViewRequest.ViewDescriptor(
						new EObjectAdapter((EObject) nextObject), Node.class,
						null, getDiagramPreferencesHint()));
			}
			return createDropCommand(dropRequest, viewDescriptors);
		}

		private Command createDropCommand(DropObjectsRequest dropRequest,
				List<ViewDescriptor> viewDescriptors) {
			Command command = createViewsAndArrangeCommand(dropRequest,
					viewDescriptors);
			if (command != null && dropRequest.getObjects().size() > 0) {

				return command.chain(CommandFactory
						.createDiagramElementAddCommand((EObject) dropRequest
								.getObjects().iterator().next(),
								SCRMDiagramEditPart.this, true));

			}
			return null;
		}
	}

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "Scrm"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1000;

	/**
	 * @generated
	 */
	public SCRMDiagramEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new SCRMDiagramItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new SCRMDiagramCanonicalEditPolicy());
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}

	@Override
	protected void handleNotificationEvent(Notification event) {
		Object feature = event.getFeature();
		if (ScrmPackage.eINSTANCE.getSCRMDiagram_Elements().equals(feature)) {
			updateView();
		}
		super.handleNotificationEvent(event);
	}

	public void updateView() {
		CanonicalEditPolicy canonicalEditPolicy = (CanonicalEditPolicy) getEditPolicy(EditPolicyRoles.CANONICAL_ROLE);
		canonicalEditPolicy.refresh();
	}

	/**
	 * @generated
	 */
	/*package-local*/static class NodeLabelDragPolicy extends
			NonResizableEditPolicy {

		/**
		 * @generated
		 */
		@SuppressWarnings("rawtypes")
		protected List createSelectionHandles() {
			MoveHandle h = new MoveHandle((GraphicalEditPart) getHost());
			h.setBorder(null);
			return Collections.singletonList(h);
		}

		/**
		 * @generated
		 */
		public Command getCommand(Request request) {
			return null;
		}

		/**
		 * @generated
		 */
		public boolean understandsRequest(Request request) {
			return false;
		}
	}

	/**
	 * @generated
	 */
	/*package-local*/static class LinkLabelDragPolicy extends
			NonResizableLabelEditPolicy {

		/**
		 * @generated
		 */
		@SuppressWarnings("rawtypes")
		protected List createSelectionHandles() {
			MoveHandle mh = new MoveHandle((GraphicalEditPart) getHost());
			mh.setBorder(null);
			return Collections.singletonList(mh);
		}
	}

}
