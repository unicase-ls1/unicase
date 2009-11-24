package org.unicase.link.handlers;

import java.net.MalformedURLException;
import java.util.Date;
import java.util.Set;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.unicase.emfstore.esmodel.url.ModelElementUrl;
import org.unicase.emfstore.esmodel.url.ModelElementUrlFragment;
import org.unicase.emfstore.esmodel.url.ProjectUrlFragment;
import org.unicase.emfstore.esmodel.url.impl.UrlFactoryImpl;
import org.unicase.link.util.ProjectProxy;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.ProjectUrlResolutionException;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Help class for resolving project or
 * model element in a workspace
 * 
 * @author svetlana
 *
 */
public class OpenLink {
	
	private static final String EXTERNAL_URL = "EXTERNAL_URL"; 

	public static void openME(ProjectSpace projectSpace, ModelElementUrlFragment meUrl){
		
		
		final ModelElement me = projectSpace.getProject().getModelElement(meUrl.getModelElementId());
		if(me != null){
				// when the according element is found, open it 
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						ActionHelper.openModelElement(me, EXTERNAL_URL);
					}});;
			}
		}

	/**
	 * Opens the model element with the specified URL in the MEEditor view.
	 * If the passed URL is invalid a MessageBox will be shown to the user 
	 * informing him about the invalid URL.
	 * 
	 * @param url The ModelElementUrl of the model element to be opened.
	 */
	public static void openURL(ModelElementUrl url){
		ProjectSpace projectSpace = null; 
						
		projectSpace = ProjectProxy.getInstance().getLatestProjectSpace(url);
		
		if(projectSpace != null){
			OpenLink.openME(projectSpace, 
					url.getModelElementUrlFragment());
		}
	}
	
	/**
	 * Opens the model element with the specified URL in the MEEditor view.
	 * If the passed URL is invalid a MessageBox will be shown to the user 
	 * informing him about the invalid URL.
	 * 
	 * @param url The UNICASE URL of the model element to be opened.
	 */
	public static void openURL(String url) {
		try {
			ModelElementUrl modElmUrl = UrlFactoryImpl.eINSTANCE
				.createModelElementUrl(url);
			openURL(modElmUrl);
		} catch (MalformedURLException e) {
			// invalid URL has been passed, inform user
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					MessageDialog.openError(
							Display.getDefault().getActiveShell(),
							"Malformed URL",
							"The unicase URL you tried to open is not valid.");
					
				}}); 
		}
	}
}
