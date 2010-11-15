package org.unicase.rap.ui.start;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.rap.sessionmanagement.UserSessionInfo;
import org.unicase.workspace.util.EMFStoreClientUtil;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}
	
	public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
	    return new ApplicationActionBarAdvisor(configurer);
	}
	
	public void preWindowOpen() {
	    IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
	    configurer.setTitle("Unicase RAP Alpha");
	    //getWindowConfigurer().setShellStyle(SWT.NO_TRIM);
	    getWindowConfigurer().setShowMenuBar( true );
	    getWindowConfigurer().setShowFastViewBars(true);
	    //getWindowConfigurer().setShowPerspectiveBar(true);
	    getWindowConfigurer().setShowCoolBar(true);
	    login();
	}
	
	private void login() {
		String username = "";
		LoginDialog loginDialog = new LoginDialog(Display.getCurrent().getActiveShell());
		while (username.isEmpty()) {
			try {
				if (loginDialog.open() == Window.OK
					//&& auth.logIn(loginDialog.getUsername(), loginDialog.getEncryptedPassword(), clientVersionInfo) != null) {
					 && EMFStoreClientUtil.dryLogin(loginDialog.getUsername(), loginDialog.getPassword(), "localhost", 8080)) {
					username = loginDialog.getUsername();
					MessageDialog.openConfirm(Display.getCurrent().getActiveShell(), "Welcome",
						"Welcome to the Unicase RAP Alpha, " + username + "!");
				} else {
					MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error", "Wrong Username/Password!");
				}
			} catch (EmfStoreException e) {
				MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error", "Problem with the Authentication Server!");
			}
			/*catch (AccessControlException e) {
				Activator.logException(e);
			}*/
		}
	}
    
	public void postWindowCreate() {
		super.postWindowCreate();
		Shell shell = getWindowConfigurer().getWindow().getShell();
		shell.setMaximized( true );
	}

}
