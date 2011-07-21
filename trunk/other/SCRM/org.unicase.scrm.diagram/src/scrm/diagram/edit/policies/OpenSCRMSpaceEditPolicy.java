package scrm.diagram.edit.policies;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
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
 * Policy to enable double-click behavior for SCRMDiagram-Compartment-EditParts.
 * Upon double-clicking a SCRMSpace-Node, the representing SCRMDiagram is opened,
 * containing all of the SCRMSpaces-elements including references between them.
 * If no such SCRMDiagram exists, this policy creates one and links it to the space.
 * 
 * @author mharut
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
				(HintedDiagramLinkStyle) link));
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

	/**
	 * The command to open diagrams from an already existent <code>SCRMDiagram</code>.
	 * This command will open the diagram and initialize its content, if necessary.
	 * 
	 * @author mharut
	 */
	public static class OpenDiagramCommand extends AbstractTransactionalCommand {

		private final HintedDiagramLinkStyle diagramFacet;

		private final SCRMDiagram containingDiagram;

		/**
		 * Creates a new command to open the diagram linked by <code>linkStyle</code>.
		 * @param linkStyle the link style of the edit part to open the diagram for
		 */
		public OpenDiagramCommand(HintedDiagramLinkStyle linkStyle) {
			// editing domain is taken for original diagram, 
			// if we open diagram from another file, we should use another editing domain
			super(TransactionUtil.getEditingDomain(linkStyle),
					Messages.CommandName_OpenDiagram, null);
			diagramFacet = linkStyle;
			containingDiagram = (SCRMDiagram) ((View) linkStyle.eContainer()).
				getDiagram().eContainer();
		}

		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			try {
				SCRMSpace representedSpace = (SCRMSpace) ((View) diagramFacet
						.eContainer()).getElement();
				SCRMDiagram scrmDiagram = representedSpace
						.getRepresentingDiagram();
				if (scrmDiagram == null) {
					scrmDiagram = intializeNewDiagram(representedSpace);
				}
				containingDiagram.getElements().add(scrmDiagram);
				ActionHelper.openModelElement(scrmDiagram, "");
				scrmDiagram.setNewElementContainer(representedSpace);
				scrmDiagram.getElements().addAll(
						representedSpace.getContainedModelElements());
				
				return CommandResult.newOKCommandResult();
			} catch (Exception ex) {
				throw new ExecutionException("Can't open diagram", ex);
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
