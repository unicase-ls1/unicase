/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.model.changeTracking.notification.filter;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.emfstore.client.model.changeTracking.notification.NotificationInfo;
import org.eclipse.emf.emfstore.common.model.impl.ProjectImpl;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;

/**
 * Filter to ignore Reference Notifications to Elements outside of the project.
 * 
 * @author koegel
 */
public class IgnoreOutsideProjectReferencesFilter implements NotificationFilter {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.changeTracking.notification.filter.NotificationFilter#check(org.eclipse.emf.emfstore.client.model.changeTracking.notification.NotificationInfo)
	 */
	public boolean check(NotificationInfo notificationInfo) {
		ProjectImpl project = (ProjectImpl) ModelUtil.getProject(notificationInfo.getNotifierModelElement());
		if (project == null) {
			return false;
		}
		if (!notificationInfo.isReferenceNotification()) {
			return false;
		}
		if (!(notificationInfo.getFeature() instanceof EReference)) {
			return false;
		}
		EReference reference = (EReference) notificationInfo.getFeature();
		if (reference.isContainer() || reference.isContainment()) {
			return false;
		}

		// we have a reference feature notification
		if (notificationInfo.getNewValue() != null && notificationInfo.getNewValue() instanceof List) {
			return checkNewValueList(notificationInfo, project);
		} else if (notificationInfo.getOldValue() != null && notificationInfo.getOldValue() instanceof List) {
			return checkOldValueList(notificationInfo, project);
		} else {
			return checkSingleReference(notificationInfo, project);
		}

	}

	private boolean checkSingleReference(NotificationInfo notificationInfo, ProjectImpl project) {
		// if new value is in project then do NOT filter
		if (notificationInfo.getOldValue() != null && !notificationInfo.isMoveEvent()
			&& isOrWasInProject(project, notificationInfo.getOldModelElementValue())) {
			return false;
		}
		// if old value is in project then do NOT filter
		if (notificationInfo.getNewValue() != null
			&& isOrWasInProject(project, notificationInfo.getNewModelElementValue())) {
			return false;
		}
		// neither old nor new value are in project => filter
		return true;
	}

	@SuppressWarnings("unchecked")
	private boolean checkOldValueList(NotificationInfo notificationInfo, ProjectImpl project) {
		for (EObject referencedElement : ((List<EObject>) notificationInfo.getOldValue())) {
			if (isOrWasInProject(project, referencedElement)) {
				return false;
			}
		}
		// all referenced elements are NOT in the project
		return true;
	}

	@SuppressWarnings("unchecked")
	private boolean checkNewValueList(NotificationInfo notificationInfo, ProjectImpl project) {
		for (EObject referencedElement : ((List<EObject>) notificationInfo.getNewValue())) {
			if (isOrWasInProject(project, referencedElement)) {
				return false;
			}
		}
		// all referenced elements are NOT in the project
		return true;
	}

	private boolean isOrWasInProject(ProjectImpl project, EObject referencedElement) {
		boolean b = project.containsInstance(referencedElement)
			|| project.getDeletedModelElementId(referencedElement) != null;
		return b;
	}
}
