package scrm.diagram.edit.policies;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.metamodel.Project;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.WorkspaceManager;

import scrm.SCRMDiagram;
import scrm.SCRMSpace;
import scrm.ScrmFactory;
import scrm.diagram.part.Messages;

/**
 * @author mharut
 * Policy to enable double-click behavior for SCRMDiagram-Compartment-EditParts.
 * Upon double-clicking a SCRMSpace-Node, the representing SCRMDiagram is opened,
 * containing all of the SCRMSpaces-elements including references between them.
 * If no such SCRMDiagram exists, this policy creates one and links it to the space.
 * 
 * @generated NOT
 */
public class OpenSCRMSpaceEditPolicy extends OpenEditPolicy {

	@Override
	protected Command getOpenCommand(Request request) {
		EditPart targetEditPart = getTargetEditPart(request);
		if (!(targetEditPart.getModel() instanceof View)) {
			return null;
		}
		
		View view = (View) targetEditPart.getModel();
		Style link = getLink(view);

		if (!(link instanceof HintedDiagramLinkStyle)) {
			return null;
		}
		
		return new ICommandProxy(new OpenDiagramCommand(
				(HintedDiagramLinkStyle) link, view.getDiagram().eContainer()));
	}

	private Style getLink(View view) {
		Style link = view.getStyle(NotationPackage.eINSTANCE
				.getHintedDiagramLinkStyle());
		while (!(link instanceof HintedDiagramLinkStyle)) {
			Object container = view.eContainer();
			if (container instanceof View) {
				view = (View) container;
				link = view.getStyle(NotationPackage.eINSTANCE
						.getHintedDiagramLinkStyle());
			} else {
				return null;
			}
		}
		return link;
	}

	public static class OpenDiagramCommand extends AbstractTransactionalCommand {

		private final HintedDiagramLinkStyle diagramFacet;

		private final SCRMDiagram containingDiagram;

		public OpenDiagramCommand(HintedDiagramLinkStyle linkStyle, EObject eObject) {
			// editing domain is taken for original diagram, 
			// if we open diagram from another file, we should use another editing domain
			super(TransactionUtil.getEditingDomain(linkStyle),
					Messages.CommandName_OpenDiagram, null);
			diagramFacet = linkStyle;
			containingDiagram = (SCRMDiagram) eObject;
		}

		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			try {
				boolean requiresArrangement = false;
				SCRMSpace representedSpace = (SCRMSpace) ((View) diagramFacet
						.eContainer()).getElement();
				SCRMDiagram scrmDiagram = representedSpace
						.getRepresentingDiagram();
				if (scrmDiagram == null) {
					scrmDiagram = intializeNewDiagram(representedSpace);
					requiresArrangement = true;
				}
				containingDiagram.getElements().add(scrmDiagram);
				ActionHelper.openModelElement(scrmDiagram, "");
				scrmDiagram.setNewElementContainer(representedSpace);
				scrmDiagram.getElements().addAll(
						representedSpace.getContainedModelElements());
//				if(requiresArrangement) {
//					DiagramEditor editor = (DiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
//					arrange(editor.getDiagramGraphicalViewer().getRootEditPart().getContents());
//				}
				
				return CommandResult.newOKCommandResult();
			} catch (Exception ex) {
				throw new ExecutionException("Can't open diagram", ex);
			}
		}

		private void arrange(EditPart rootEditPart) {
			
			ArrangeRequest arrangeRequest = new
			ArrangeRequest(ActionIds.ACTION_ARRANGE_ALL);
			
			List<EditPart> l = new ArrayList<EditPart>();
			l.add(rootEditPart);
			
			arrangeRequest.setPartsToArrange(l);
			
			Command cmd = rootEditPart.getCommand(arrangeRequest);
			
			if(cmd.canExecute()) {
				cmd.execute();
			}
			
		}

		private SCRMDiagram intializeNewDiagram(SCRMSpace representedSpace)
				throws ExecutionException {
			SCRMDiagram scrmDiagram = ScrmFactory.eINSTANCE.createSCRMDiagram();
			Project project = WorkspaceManager.getProjectSpace(
					containingDiagram).getProject();
			project.addModelElement(scrmDiagram);
			scrmDiagram.setDiagramType(representedSpace);
			representedSpace.setRepresentingDiagram(scrmDiagram);
			return scrmDiagram;
		}

	}

}
