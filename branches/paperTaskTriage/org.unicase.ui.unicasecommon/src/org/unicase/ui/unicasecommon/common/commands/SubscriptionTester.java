/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.unicasecommon.common.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.metamodel.ModelElement;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.preferences.DashboardKey;
import org.unicase.workspace.preferences.PreferenceManager;

/**
 * Tests if the element is already subscribed.
 * 
 * @author shterev
 */
public class SubscriptionTester extends PropertyTester {

	private static final String DOES_CONTAIN = "isSubscribed";
	private static final String DOES_NOT_CONTAIN = "isNotSubscribed";

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[],
	 *      java.lang.Object)
	 */
	public boolean test(Object receiver, String property, Object[] args, final Object expectedValue) {
		if (receiver instanceof ModelElement) {
			ModelElement modelElement = (ModelElement) receiver;
			if (modelElement.getProject() == null) {
				return false;
			}
			ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(modelElement);
			OrgUnitProperty orgUnitProperty = PreferenceManager.INSTANCE.getProperty(projectSpace,
				DashboardKey.SUBSCRIPTIONS);
			List<EObject> propertyList = orgUnitProperty.getEObjectListProperty(new ArrayList<EObject>());
			boolean contains = propertyList.contains(modelElement.getModelElementId());
			if (property.equals(DOES_CONTAIN)) {
				return contains;
			} else if (property.equals(DOES_NOT_CONTAIN)) {
				return !contains;
			}
		}
		return false;

	}

}
