package scrm.diagram.edit.policies;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
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
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.metamodel.Project;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.WorkspaceManager;

import scrm.SCRMDiagram;
import scrm.SCRMModelElement;
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
				
		SCRMSpace representedSpace = (SCRMSpace) view.getElement();
		
		SCRMDiagram containingDiagram = (SCRMDiagram) view
				.getDiagram().eContainer();
		
		return new ICommandProxy(new OpenDiagramCommand(
				representedSpace, containingDiagram));
	}

	/**
	 * The command to open diagrams from an already existent <code>SCRMDiagram</code>.
	 * This command will open the diagram and initialize its content, if necessary.
	 * 
	 * @author mharut
	 * @generated NOT
	 */
	public static class OpenDiagramCommand extends AbstractTransactionalCommand {

		private final SCRMSpace representedSpace;

		private final SCRMDiagram containingDiagram;

		/**
		 * Creates a new command to open the diagram linked by <code>linkStyle</code>.
		 * @param linkStyle the link style of the edit part to open the diagram for
		 */
		public OpenDiagramCommand(SCRMSpace representedSpace,
				SCRMDiagram containingDiagram) {
			// editing domain is taken for original diagram, 
			// if we open diagram from another file, we should use another editing domain
			super(TransactionUtil.getEditingDomain(representedSpace),
					Messages.CommandName_OpenDiagram, null);
			this.representedSpace = representedSpace;
			this.containingDiagram = containingDiagram;
		}

		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			try {
				SCRMDiagram scrmDiagram = representedSpace
						.getRepresentingDiagram();
				if (scrmDiagram == null) {
					scrmDiagram = intializeNewDiagram();
				}
				if (containingDiagram != null) {
					containingDiagram.getElements().add(scrmDiagram);
				}
				ActionHelper.openModelElement(scrmDiagram, "");
				scrmDiagram.setNewElementContainer(representedSpace);
				scrmDiagram.getElements().addAll(getAllContents(representedSpace));
				
				return CommandResult.newOKCommandResult();
			} catch (Exception ex) {
				throw new ExecutionException("Can't open diagram", ex);
			}
		}

		private SCRMDiagram intializeNewDiagram()
				throws ExecutionException {
			SCRMDiagram scrmDiagram = ScrmFactory.eINSTANCE.createSCRMDiagram();
			Project project = WorkspaceManager.getProjectSpace(
					representedSpace).getProject();
			project.addModelElement(scrmDiagram);
			scrmDiagram.setDiagramType(representedSpace);
			representedSpace.setRepresentingDiagram(scrmDiagram);
			return scrmDiagram;
		}
		
		private Collection<SCRMModelElement> getAllContents(
				SCRMSpace representedSpace) {
			List<SCRMModelElement> result = new LinkedList<SCRMModelElement>();
			for(SCRMModelElement scrmModelElement : representedSpace.getContainedModelElements()) {
				result.add(scrmModelElement);
				for(Iterator<EObject> it = scrmModelElement.eAllContents(); it.hasNext();) {
					EObject content = it.next();
					if(content instanceof SCRMModelElement) {
						result.add((SCRMModelElement) content);	
					}
				}
			}
			return result;
		}
	}

}
