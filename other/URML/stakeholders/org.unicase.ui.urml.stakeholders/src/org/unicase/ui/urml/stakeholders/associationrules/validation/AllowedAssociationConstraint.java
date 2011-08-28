package org.unicase.ui.urml.stakeholders.associationrules.validation;

	import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.urml.UrmlModelElement;

	public class AllowedAssociationConstraint extends AbstractModelConstraint {
		@Override
		public IStatus validate(IValidationContext ctx) {
			UrmlModelElement eObj = (UrmlModelElement)ctx.getTarget();
			EList<UrmlModelElement> associations = (EList<UrmlModelElement>) eObj.getAssociations();
			//eObj.getAssociations();
			for (UrmlModelElement association : associations){
//				allowedAssociation = 
//				if (allowedAssociation.contains(association))
			}
			//check if the associations are included in the
			//allowedAssociation for the current stage
			//if no, return appropriate failure status message
			return ctx.createFailureStatus("done", "done");
				
			
			//return ctx.createSuccessStatus();
		}
	}

