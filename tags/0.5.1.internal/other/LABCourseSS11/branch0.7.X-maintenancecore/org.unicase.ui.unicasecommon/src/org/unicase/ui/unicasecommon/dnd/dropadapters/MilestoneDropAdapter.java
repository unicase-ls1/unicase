/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.dnd.dropadapters;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.task.Milestone;
import org.unicase.model.task.TaskPackage;

/**
 * This is the drop adapter for Milestones.
 * 
 * @author mkagel
 */
public class MilestoneDropAdapter extends UCDropAdapter {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void drop(DropTargetEvent event, EObject target, List<EObject> source) {
		UnicaseModelElement dropee = (UnicaseModelElement) source.get(0);
		((Milestone) target).getContainedModelElements().add(dropee);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.unicasecommon.dnd.dropadapters.UCDropAdapter#isDropAdapterfor()
	 */
	@Override
	public EClass isDropAdapterfor() {
		return TaskPackage.eINSTANCE.getMilestone();
	}

}
