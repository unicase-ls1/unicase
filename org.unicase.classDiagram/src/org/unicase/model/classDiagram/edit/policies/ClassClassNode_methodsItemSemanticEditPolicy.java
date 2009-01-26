package org.unicase.model.classDiagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.unicase.model.classes.ClassesPackage;

/**
 * @generated
 */
public class ClassClassNode_methodsItemSemanticEditPolicy extends
	org.unicase.model.classDiagram.edit.policies.ModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (org.unicase.model.classDiagram.providers.ModelElementTypes.Method_3002 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(ClassesPackage.eINSTANCE.getClass_Methods());
			}
			return getGEFWrapper(new org.unicase.model.classDiagram.edit.commands.MethodCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
