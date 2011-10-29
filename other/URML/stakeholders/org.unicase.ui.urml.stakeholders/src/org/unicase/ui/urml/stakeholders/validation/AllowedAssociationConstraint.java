package org.unicase.ui.urml.stakeholders.validation;

	import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.urml.UrmlModelElement;

	public class AllowedAssociationConstraint extends AbstractModelConstraint {
		@Override
		public IStatus validate(IValidationContext ctx) {
			if(ctx.getTarget() instanceof UrmlModelElement){
			UrmlModelElement eObj = (UrmlModelElement)ctx.getTarget();
			EList<UrmlModelElement> associations = (EList<UrmlModelElement>) eObj.getAssociations();
			//eObj.getAssociations();
			for (UrmlModelElement other : associations){
//				allowedAssociation = 
//				if (allowedAssociation.contains(association))

				return ctx.createFailureStatus(eObj.eClass().getName(), other.eClass().getName(), "Analysis");
			}
			//check if the associations are included in the
			//allowedAssociation for the current stage
			//if no, return appropriate failure status message
			}
			return ctx.createSuccessStatus();
			//return ctx.createSuccessStatus();
		}
	}

