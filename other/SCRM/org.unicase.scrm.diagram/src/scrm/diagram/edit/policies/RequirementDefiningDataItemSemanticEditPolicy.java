package scrm.diagram.edit.policies;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class RequirementDefiningDataItemSemanticEditPolicy extends ScrmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public RequirementDefiningDataItemSemanticEditPolicy() {
		super(ScrmElementTypes.RequirementDefiningData_4038);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req) {
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info)
				throws ExecutionException {
				EObject referencedObject = getReferencedObject();
				Resource resource = referencedObject.eResource();
				CommandResult result = super.doExecuteWithResult(progressMonitor, info);
				if (resource != null) {
					resource.getContents().add(referencedObject);
				}
				return result;
			}
		});
	}

}
