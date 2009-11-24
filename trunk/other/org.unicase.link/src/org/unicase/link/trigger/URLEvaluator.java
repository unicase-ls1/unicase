/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.link.trigger;

import java.util.Set;
import java.util.Date;
import java.io.IOException;

import org.eclipse.swt.widgets.Display;
import org.unicase.metamodel.ModelElement;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.util.WorkspaceUtil;
import org.unicase.emfstore.esmodel.url.ModelElementUrl;
import org.unicase.emfstore.esmodel.url.impl.UrlFactoryImpl;
import org.unicase.workspace.exceptions.ProjectUrlResolutionException;

/**
 * It is responsible for opening requested model element with a link.
 * 
 * 
 * @author fxulusoy
 */
public class URLEvaluator {

	/**
	 * Constructor of <code>URLEvaluator</code>.
	 */
	public URLEvaluator() {
		
	}
	
	/**
	 * Opens the related model element which is given by an url argument.
	 * 
	 * @param url It is an URL for a model element in an UNICASE project.
	 *            
	 */
	public void execute(String url) {
		try {
			
			// TODO : this message dialog will be removed.
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					MessageDialog.openError(Display.getDefault().getActiveShell(),
						"Hey Dude:)", "Be patient! It's coming.......");
				}
			});

			ModelElementUrl modElmUrl = UrlFactoryImpl.eINSTANCE.createModelElementUrl(url);
			try {
				Set<ProjectSpace> projectSet = WorkspaceManager.getInstance()
				.getCurrentWorkspace().resolve(modElmUrl.getProjectUrlFragment());

				ProjectSpace currProjectSpace = null;
				
				if (!projectSet.isEmpty()) {
					
					currProjectSpace = getProjectSpace(projectSet);

					final ModelElement model = currProjectSpace.getProject().getModelElement(
						modElmUrl.getModelElementUrlFragment().getModelElementId());
					if(model != null) {
						// when the related element is found, open it 
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
	
	/**
	 * Returns the latest project.
	 * 
	 * @param projectSet
	 * @return current project space
	 */
	private ProjectSpace getProjectSpace(Set<ProjectSpace> projectSet) {
		// fetch latest project
		ProjectSpace currProjectSpace = projectSet.iterator().next();

		for (ProjectSpace space : projectSet) {
			Date lastUpdated = space.getLastUpdated();
			Date currProjectDate = currProjectSpace.getLastUpdated();
			if (lastUpdated.after(currProjectDate)) {
				currProjectSpace = space;
			}
		}

		return currProjectSpace;
	}
	
}
