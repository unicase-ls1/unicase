package org.unicase.link.handlers;

import java.net.MalformedURLException;
import java.util.Observable;
import java.util.Observer;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.unicase.emfstore.esmodel.url.ModelElementUrl;
import org.unicase.emfstore.esmodel.url.ModelElementUrlFragment;
import org.unicase.emfstore.esmodel.url.impl.UrlFactoryImpl;
import org.unicase.link.util.ProjectProxy;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;

/**
 * Help class for resolving project or
 * model element in a workspace
 * 
 * @author svetlana, emueller
 *
 */
public class OpenLink implements Observer {
	
	private static final String EXTERNAL_URL = "EXTERNAL_URL";
	private static OpenLink instance = null;
	
	public static OpenLink getInstance() {
		if (instance == null) {
			instance = new OpenLink();
		}
		
		return instance;
	}

	public static void openME(ProjectSpace projectSpace, ModelElementUrlFragment meUrl){
		
		
		final ModelElement me = projectSpace.getProject().getModelElement(meUrl.getModelElementId());
		if(me != null){
				// when the according element is found, open it 
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						ActionHelper.openModelElement(me, EXTERNAL_URL);
					}});
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

	/**
	 * @param
	 * @param
	 */
	public void update(Observable o, Object arg) {
		// TODO: error case regarding arg
		String url = (String) arg;
		openURL(url);
	}
}
