/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecpemfstorebridge;

import org.eclipse.emf.ecore.EObject;
import org.unicase.metamodel.ModelElement;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Logs a trace event as Event.
 * 
 * @author helming
 */
public class TraceListener implements org.unicase.ui.common.TraceListener {
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.TraceListener#onTrace(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject,
	 *      java.lang.String, java.lang.String)
	 */
	public void onTrace(EObject source, EObject target, String feature, String view) {
		if (source instanceof ModelElement && target instanceof ModelElement) {
			final ModelElement targetModelElement = (ModelElement) target;
			final ModelElement sourceModelElement = (ModelElement) source;
			final String featureName = feature;

			new UnicaseCommand() {
				@Override
				protected void doRun() {
					ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace()
						.getActiveProjectSpace();
					WorkspaceUtil.logTraceEvent(activeProjectSpace, sourceModelElement.getModelElementId(),
						targetModelElement.getModelElementId(), featureName);
				}
			}.run();
		}

	}

}
