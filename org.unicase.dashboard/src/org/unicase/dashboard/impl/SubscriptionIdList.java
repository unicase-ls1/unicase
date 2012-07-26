/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.dashboard.impl;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.unicase.dashboard.DashboardPackage;

/**
 * Containment list that will properly handle basic list operations for subscription model element ids.
 * 
 * @author mharut
 */
public class SubscriptionIdList extends EObjectContainmentEList.Resolving<ModelElementId> {

	private static final long serialVersionUID = -7636508435027366525L;

	/**
	 * Constructs a list for a certain owner.
	 * 
	 * @param owner the owner of the containments in this list
	 */
	public SubscriptionIdList(InternalEObject owner) {
		super(ModelElementId.class, owner, DashboardPackage.SUBSCRIPTION_COMPOSITE__SUBSCRIPTIONS);
	}

	@Override
	public boolean contains(Object object) {
		if (data == null) {
			return false;
		}
		if (object instanceof ModelElementId) {
			ModelElementId id = (ModelElementId) object;
			for (Object subscriptionId : data) {
				if (subscriptionId instanceof ModelElementId) {
					if (((ModelElementId) subscriptionId).getId().equals(id.getId())) {
						return true;
					}
				}
			}
		}
		return super.contains(object);
	}

	@Override
	public boolean add(ModelElementId id) {
		ModelElementId clonedId = ModelUtil.clone(id);
		return super.add(clonedId);
	}

	@Override
	public boolean remove(Object object) {
		if (data == null) {
			return false;
		}
		ModelElementId subscriptionId = null;
		if (object instanceof ModelElementId) {
			ModelElementId id = (ModelElementId) object;
			for (Object dataObject : data) {
				if (dataObject instanceof ModelElementId) {
					ModelElementId possibleId = (ModelElementId) dataObject;
					if (possibleId.getId().equals(id.getId())) {
						subscriptionId = possibleId;
						break;
					}
				}
			}
		}
		if (subscriptionId == null) {
			return false;
		}
		return super.remove(subscriptionId);
	}

}
