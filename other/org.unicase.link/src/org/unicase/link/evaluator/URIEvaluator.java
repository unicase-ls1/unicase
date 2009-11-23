/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.link.evaluator;

import java.io.IOException;
import java.util.Date;
import java.util.Set;

import org.eclipse.swt.widgets.Display;
import org.eclipse.jface.dialogs.MessageDialog;
import org.unicase.emfstore.esmodel.url.ModelElementUrl;
import org.unicase.emfstore.esmodel.url.impl.UrlFactoryImpl;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.ProjectUrlResolutionException;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * TODO: javadoc
 * TODO: @author?
 */
public class URIEvaluator {
	
	/**
	 * The constructor.
	 */
	public URIEvaluator() {
		
	}
	
	/**
	 * TODO: Javadoc for handleArguments.
	 * @param args -insert doc-
	 */
	public void handleArguments(String args) {

		try {
			ModelElementUrl modElmUrl = UrlFactoryImpl
				.eINSTANCE.createModelElementUrl(args);

			try {
				Set<ProjectSpace> projectSet = WorkspaceManager.getInstance()
					.getCurrentWorkspace().resolve(modElmUrl.getProjectUrlFragment());

				if (!projectSet.isEmpty()) {
					// fetch latest project
					ProjectSpace currProjectSpace = null;
					currProjectSpace = projectSet.iterator().next();

					for (ProjectSpace space : projectSet) {
						Date lastUpdated = space.getLastUpdated();
						Date currProjectDate = currProjectSpace.getLastUpdated();

						if (lastUpdated.after(currProjectDate)) {
							currProjectSpace = space;
						}
					}
					
					final ModelElement model = currProjectSpace.getProject().getModelElement(
						modElmUrl.getModelElementUrlFragment().getModelElementId());
					if(model != null) {
						// when the according element is found, open it 
						Display.getDefault().asyncExec(new Runnable() {
							public void run() {
								ActionHelper.openModelElement(model, "asd");
							}
						});
					} else {
						// inform client, that the model is not available
						Display.getDefault().asyncExec(new Runnable() {
							public void run() {
								MessageDialog.openError(Display.getDefault().getActiveShell(),
									"Model not found.",
									"The model you have requested is not available.\n"
									+ "Maybe you did not yet check it out?");
							}
						});
					}
				} else {					
					// inform client, that the project is not available
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							MessageDialog.openError(Display.getDefault().getActiveShell(),
								"Project not found.",
								"The project you have requested is not available.\n"
								+ "Maybe you did not yet check it out?");
						}
					});
				}

			} catch (ProjectUrlResolutionException e) {
				WorkspaceUtil.logException(e.getMessage(), e);
			}
		} catch (IOException exc) {
			WorkspaceUtil.logException(exc.getMessage(), exc);
		} 
	}
	
}
