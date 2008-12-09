package org.unicase.model.requirement.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.ActorInstance;

/**
 * Checks whether a actor instance is connected to a actor.
 * 
 * @author wesendonk
 */
public class ActorInstanceActorConstraint extends AbstractModelConstraint {

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();

		if (eType == EMFEventType.NULL) {
			if (eObj instanceof ActorInstance) {
				Actor actor = ((ActorInstance) eObj).getInstantiatedActor();
				if (actor == null) {
					return ctx.createFailureStatus(new Object[] { eObj.eClass()
							.getName()
							+ ": '" + ((ActorInstance) eObj).getName() + "'" });
				}
			}
		}
		return ctx.createSuccessStatus();
	}

}
