package org.unicase.ui.repository.views;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.connectionmanager.ConnectionException;

/**
 * Class for the login dialog.
 * 
 * @author shterev
 */
public class RepositoryLoginDialog extends Dialog implements Listener {

	private Text username;
	private Text password;
	private Usersession session;
	private Shell shell;

	/**
	 * Default constructor.
	 * 
	 * @param parent
	 *            the parent shell
	 * @param session
	 *            the target usersession
	 */
	public RepositoryLoginDialog(Shell parent, Usersession session) {
		super(parent);
		this.session = session;
	}

	/**
	 * @return .
	 */
	public int open() {
		Shell parent = getParentShell();
		shell = new Shell(parent, SWT.TITLE | SWT.BORDER
				| SWT.APPLICATION_MODAL);
		shell.setText("Login");
		shell.setLayout(new GridLayout(2, true));
		shell.setLocation(parent.getLocation());
		Label user = new Label(shell, SWT.NULL);
		user.setText("Username:");
		username = new Text(shell, SWT.SINGLE | SWT.BORDER);

		Label pass = new Label(shell, SWT.NULL);
		pass.setText("Password:");
		password = new Text(shell, SWT.PASSWORD | SWT.BORDER);

		final Button buttonOK = new Button(shell, SWT.PUSH);
		buttonOK.setText("Ok");
		buttonOK.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
		Button buttonCancel = new Button(shell, SWT.PUSH);
		buttonCancel.setText("Cancel");

		buttonOK.addListener(SWT.Selection, this);
		shell.setDefaultButton(buttonOK);
		buttonCancel.addListener(SWT.Selection, this);

		shell.addListener(SWT.Traverse, this);
		shell.pack();
		shell.open();

		Display display = parent.getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return Window.OK;

	}
	
	/**
	 * @param event .
	 */
	public void handleEvent(Event event) {
		if (event.type == SWT.Selection) {
			if (event.button == 0) {
				session.setUsername(username.getText());
				session.setPassword(password.getText());
				try {
					session.logIn(password.getText());
				} catch (ConnectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (AccessControlException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			shell.dispose();
		} else if (event.type == SWT.Traverse) {
			if (event.detail == SWT.TRAVERSE_ESCAPE) {
				event.doit = false;
			}
		}

	}
}
// /**
// * Default method for initializing the UI.
// * @param parent the parent Composite
// */
// public Control createContents(Composite parent) {
//		
// GridData gd;
// Composite composite = new Composite(parent, SWT.NULL);
//
// GridLayout gl = new GridLayout();
// int ncol = 2;
// gl.numColumns = ncol;
// composite.setLayout(gl);
//
// new Label(composite, SWT.NONE).setText("Username:");
// username = new Text(composite, SWT.BORDER);
// gd = new GridData(GridData.FILL_HORIZONTAL);
// gd.horizontalSpan = ncol - 1;
// username.setLayoutData(gd);
//
// new Label(composite, SWT.NONE).setText("Password:");
// password = new Text(composite, SWT.BORDER);
// gd = new GridData(GridData.FILL_HORIZONTAL);
// gd.horizontalSpan = ncol - 1;
// password.setLayoutData(gd);
//		
// Button ok = new Button(composite, SWT.PUSH);
// ok.setText("OK");
// gd = new GridData(GridData.FILL_HORIZONTAL);
// ok.setLayoutData(gd);
// ok.addSelectionListener(new SelectionAdapter() {
// public void widgetSelected(SelectionEvent event) {
// session.setUsername(username.getText());
// session.setPassword(password.getText());
// try {
// session.logIn(password.getText());
// } catch (ConnectionException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// } catch (AccessControlException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }
// close();
// }
// });
//
// Button cancel = new Button(composite, SWT.PUSH);
// cancel.setText("Cancel");
// gd = new GridData(GridData.FILL_HORIZONTAL);
// cancel.setLayoutData(gd);
// cancel.addSelectionListener(new SelectionAdapter() {
// public void widgetSelected(SelectionEvent event) {
// session = null;
// close();
// }
// });
//
// return composite;
// }
// }
