/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.urml.stakeholders.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.urml.Phase;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.ui.urml.stakeholders.StakeholderUtil;
import org.unicase.ui.urml.stakeholders.config.UrmlSettingsManager;

/**
 * New constraint class, which defines new validation "rule".
 * Here, the settings within the current active development phase are checked
 * against the current project. Development phase settings define which association 
 * between model elements are allowed and which not. A validation message is generated
 * every time a unallowed association is found. 
 * @author kterzieva
 *
 */
public class AllowedAssociationConstraint extends AbstractModelConstraint {
	@Override
	public IStatus validate(IValidationContext ctx) {

		if (ctx.getTarget() instanceof UrmlModelElement) {
			UrmlModelElement eObj = (UrmlModelElement) ctx.getTarget();
			EList<UrmlModelElement> associations = (EList<UrmlModelElement>) eObj
					.getAssociations();
			Phase activePhase = UrmlSettingsManager.INSTANCE.getActivePhase();
			EMap<EClass, EList<EClass>> allowedAssociation;
			HashMap<EClass, ArrayList<EClass>> staticAssociations = StakeholderUtil.getStaticAssociationMap();
			String phaseName;
			if (activePhase != null) {
				allowedAssociation = activePhase.getAllowedAssociations();
				phaseName = activePhase.getName();
			} else {
				allowedAssociation = new BasicEMap<EClass, EList<EClass>>();
				phaseName = "no phase";
			}
			String failStr = "";
			outer: for (UrmlModelElement other : associations) {
				
				//Check static associations from the URML meta model
				List<EClass> allowedTargets = staticAssociations.get(eObj.eClass());
				if (allowedTargets != null) {
					for (EClass cls : allowedTargets) {
						if (cls != null && cls.equals(other.eClass())) {
							continue outer;
						}
					}
				}

				allowedTargets = allowedAssociation.get(eObj.eClass());
				if (allowedTargets != null) {
					for (EClass cls : allowedTargets) {
						if (cls != null && cls.equals(other.eClass())) {
							continue outer;
						}
					}
				}
				failStr += other.eClass().getName() + "/";
			}

			// Any failures detected?
			if (!failStr.equals("")) {
				failStr = failStr.substring(0, failStr.length() - 1);
				return ctx.createFailureStatus(eObj.eClass().getName(),
						failStr, phaseName);
			}

		}
		return ctx.createSuccessStatus();
	}
}
