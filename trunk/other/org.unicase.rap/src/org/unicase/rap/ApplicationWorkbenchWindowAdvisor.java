package org.unicase.rap;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.unicase.rap.login.UserCredential;
import org.unicase.rap.view.LoginDialog;

/**
 * Configures the initial size and appearance of a workbench window.
 */
public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

    public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        super(configurer);
    }

    public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
        return new ApplicationActionBarAdvisor(configurer);
    }
    
    public void preWindowOpen() {
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
        configurer.setInitialSize(new Point(400, 300));
        configurer.setShowCoolBar(false);
        configurer.setShowStatusLine(false);
        configurer.setTitle("Hello RAP");
    }
    
    public void postWindowOpen() {
    	IWorkbench workbench = PlatformUI.getWorkbench();
    	IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
		final Shell shell = window.getShell();
		shell.setLocation( 70, 25 );
		shell.setVisible( false );
		
		LoginDialog loginDialog = new LoginDialog(null);

		while (loginDialog.open() == Window.OK){
			UserCredential userCredential = loginDialog.getUserCredential();
			if (userCredential.getUsername().equalsIgnoreCase("fatih")) {
				shell.setVisible(true);
				break;
			} else {
				MessageDialog.openError(shell, "Error", "Login Failed");
			}
		}
		
    }
    
}
