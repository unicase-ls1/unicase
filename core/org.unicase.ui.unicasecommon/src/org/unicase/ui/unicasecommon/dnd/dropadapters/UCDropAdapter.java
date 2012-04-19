/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.dnd.dropadapters;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecp.common.dnd.MEDropAdapter;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.accesscontrol.AccessControlHelper;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.model.Annotation;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.document.Section;

/**
 * Parent class for all UNICASE drop adapters.
 * 
 * @author helming
 */
public class UCDropAdapter extends MEDropAdapter {
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.unicasecommon.dnd.dropadapters.UCDropAdapter#isDropAdapterfor()
	 */
	@Override
	public void drop(DropTargetEvent event, EObject target, List<EObject> source) {
		if (source.get(0) instanceof Annotation && target instanceof UnicaseModelElement) {
			annotateME(source, (UnicaseModelElement) target);
		} else {
			super.drop(event, target, source);
		}
	}

	private void annotateME(List<EObject> source, final UnicaseModelElement target) {
		Annotation[] arr = source.toArray(new Annotation[source.size()]);
		List<Annotation> newAnnotations = Arrays.asList(arr);
		target.getAnnotations().addAll(newAnnotations);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.unicasecommon.dnd.dropadapters.UCDropAdapter#isDropAdapterfor()
	 */
	@Override
	public boolean canDrop(int eventFeedback, DropTargetEvent event, List<EObject> source, EObject target,
		EObject dropee) {
		ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(target);
		Usersession userSession = projectSpace.getUsersession();

		if (userSession == null) {
			return true;
		}

		AccessControlHelper accessHelper = new AccessControlHelper(userSession);

		try {
			accessHelper.checkProjectAdminAccess(projectSpace.getProjectId());
		} catch (AccessControlException e) {
			if (dropee instanceof Section) {
				event.detail = DND.DROP_NONE;
				return false;
			}
		}

		if ((eventFeedback & DND.FEEDBACK_INSERT_AFTER) == DND.FEEDBACK_INSERT_AFTER
			|| (eventFeedback & DND.FEEDBACK_INSERT_BEFORE) == DND.FEEDBACK_INSERT_BEFORE) {
			if (!hasThisContainmentReference(target.eContainer(), dropee.eClass())) {
				return false;
			}
		} else if (!(dropee instanceof Annotation) && !hasThisContainmentReference(target, dropee.eClass())) {
			return false;
		}
		return super.canDrop(eventFeedback, event, source, target, dropee);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.unicasecommon.dnd.dropadapters.UCDropAdapter#isDropAdapterfor()
	 */
	@Override
	public EClass isDropAdapterfor() {
		// TODO: PlainEObjectMode, any criteria to filter for?
		return EcoreFactory.eINSTANCE.getEcorePackage().getEObject().eClass();
	}

}
