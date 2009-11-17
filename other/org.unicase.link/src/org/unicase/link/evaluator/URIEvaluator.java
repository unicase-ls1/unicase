package org.unicase.link.evaluator;

import java.io.IOException;
import java.util.Date;
import java.util.Set;

import org.eclipse.swt.widgets.Display;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.unicase.emfstore.esmodel.url.ModelElementUrl;
import org.unicase.emfstore.esmodel.url.impl.UrlFactoryImpl;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.ProjectUrlResolutionException;
import org.unicase.workspace.util.WorkspaceUtil;


public class URIEvaluator {

	public URIEvaluator() {
		
	}
	
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
					EList<ModelElement> modelElements = 
						currProjectSpace.getProject().getAllModelElements();
					
					final ModelElement model = currProjectSpace.getProject().getModelElement(
						modElmUrl.getModelElementUrlFragment().getModelElementId());
					if(model != null) {
						// when the according element is found, open it 
						Display.getDefault().asyncExec(new Runnable() {
							public void run() {
								ActionHelper.openModelElement(model, "asd");
							}
						});; 
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
