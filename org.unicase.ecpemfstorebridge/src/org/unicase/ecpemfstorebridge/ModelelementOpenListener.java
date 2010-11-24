/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecpemfstorebridge;

import org.eclipse.emf.ecore.EObject;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.ui.common.ModelElementOpenListener;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Logs an Open Event as Event.
 * 
 * @author helming
 */
public class ModelelementOpenListener implements ModelElementOpenListener {
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.ModelElementOpenListener#onOpen(org.eclipse.emf.ecore.EObject, java.lang.String,
	 *      java.lang.String)
	 */
	public void onOpen(EObject opened, String sourceView, String openView) {
		final String source = sourceView;
		final String readView = openView;
		final EObject me = opened;
		final ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(me);
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				Project p = ModelUtil.getProject(me);
				WorkspaceUtil
					.logReadEvent(projectSpace, (p == null ? null : p.getModelElementId(me)), source, readView);
			}
		}.run();
	}

}
