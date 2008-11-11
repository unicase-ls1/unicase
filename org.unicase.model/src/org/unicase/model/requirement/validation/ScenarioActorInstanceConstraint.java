package org.unicase.model.requirement.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.requirement.ActorInstance;
import org.unicase.model.requirement.Scenario;

/**
 *Checks whether a scenario has a initial actor instance.
 * 
 * @author wesendonk
 */
public class ScenarioActorInstanceConstraint extends AbstractModelConstraint {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();

		if (eType == EMFEventType.NULL) {
			if (eObj instanceof Scenario) {
				ActorInstance actorInstance = ((Scenario) eObj).getInitiatingActorInstance();
				if (actorInstance == null) {
					return ctx.createFailureStatus(new Object[] { eObj.eClass()
							.getName()
							+ ": '" + ((Scenario) eObj).getName() + "'" });
				}
			}
		}
		return ctx.createSuccessStatus();
	}

}
