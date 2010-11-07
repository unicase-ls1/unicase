package org.unicase.rap.ui.start;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.actions.ContributionItemFactory;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.unicase.emfstore.ServerConfiguration;
import org.unicase.emfstore.accesscontrol.AuthenticationControl;
import org.unicase.emfstore.accesscontrol.authentication.SimplePropertyFileVerifier;
import org.unicase.emfstore.esmodel.ClientVersionInfo;
import org.unicase.emfstore.esmodel.impl.EsmodelFactoryImpl;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.ui.navigator.Activator;

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
		// AuthenticationControl auth = new SimpleAuth();
		AuthenticationControl auth = null;
		ClientVersionInfo clientVersionInfo = EsmodelFactoryImpl.init().createClientVersionInfo();
		clientVersionInfo.setName("unicase.org eclipse rap client");
		clientVersionInfo.setVersion("1.0.0.qualifier");
		Properties serverProps = new Properties();
		try {
			serverProps.load(new FileInputStream(System.getProperty("user.home")
				+ "/.unicase.dev/emfstore/conf/es.properties"));
		} catch (FileNotFoundException e) {
			Activator.logException(e);
			return;
		} catch (IOException e) {
			Activator.logException(e);
			return;
		}
		// serverProps.put(ServerConfiguration.ACCEPTED_VERSIONS, "any");
		// serverProps.put(ServerConfiguration.KEYSTORE_CIPHER_ALGORITHM, "none");
		ServerConfiguration.setProperties(serverProps);

		try {
			auth = new SimplePropertyFileVerifier(System.getProperty("user.home")
				+ "/.unicase.dev/emfstore/conf/user.properties");
		} catch (FatalEmfStoreException e) {
			Activator.logException(e);
			return;
		}

		LoginDialog loginDialog = new LoginDialog(Display.getCurrent().getActiveShell());
		while (username.isEmpty()) {
			try {
				if (loginDialog.open() == Window.OK
					&& auth.logIn(loginDialog.getUsername(), loginDialog.getEncryptedPassword(), clientVersionInfo) != null) {
					username = loginDialog.getUsername();
					MessageDialog.openConfirm(Display.getCurrent().getActiveShell(), "Welcome",
						"Welcome to the Unicase RAP Alpha, " + username + "!");
				} else {
					MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error", "Wrong Username/Password!");
				}
			} catch (AccessControlException e) {
				Activator.logException(e);
			}
		}
	}
    
	public void postWindowCreate() {
		super.postWindowCreate();
		Shell shell = getWindowConfigurer().getWindow().getShell();
		shell.setMaximized( true );
	}

}
