package org.unicase.ui.esbrowser.views;


import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;

/**
 * Class for the login dialog.
 * 
 * @author shterev
 */
public class RepositoryLoginDialog extends Dialog implements Listener, SelectionListener {

	private Text username;
	private Text password;
	private Usersession session;
	private Shell shell;
	private Combo savedSessionsCombo;
	private EList<Usersession> savedSessionsList;
	private Button savePassword;
	private Button buttonOK;
	private Button buttonCancel;
	private ServerInfo serverInfo;

	/**
	 * Default constructor.
	 * 
	 * @param parent
	 *            the parent shell
	 * @param session
	 *            the target usersession
	 * @param serverInfo 
	 * 			  the serverinfo
	 */
	public RepositoryLoginDialog(Shell parent, Usersession session, ServerInfo serverInfo) {
		super(parent);
		this.session = session;
		this.serverInfo=serverInfo;
	}

	/**
	 * @return the new usersession for the selected project.
	 */
	public Usersession open() {
		Shell parent = getParent();
		shell = new Shell(parent, SWT.TITLE | SWT.BORDER
				| SWT.APPLICATION_MODAL);
		shell.setText("Login");
		shell.setLayout(new GridLayout(2, true));

		
		Label savedSessionsLabel = new Label(shell, SWT.NULL);
		savedSessionsLabel.setText("Saved sessions:");
		savedSessionsCombo = new Combo(shell,SWT.READ_ONLY);
		savedSessionsCombo.add("<new session>");
		savedSessionsList = WorkspaceManager.getInstance().getCurrentWorkspace().getUsersessions();
		for (int i=0; i<savedSessionsList.size(); i++){
			savedSessionsCombo.add(savedSessionsList.get(i).getUsername());
		}
		savedSessionsCombo.addSelectionListener(this);
		Label user = new Label(shell, SWT.NULL);
		user.setText("Username:");
		username = new Text(shell, SWT.SINGLE | SWT.BORDER);
		username.setSize(150,20);
		username.setEnabled(false);
		
		Label pass = new Label(shell, SWT.NULL);
		pass.setText("Password:");
		password = new Text(shell, SWT.PASSWORD | SWT.BORDER);
		password.setSize(150,20);
		password.setEnabled(false);
		
		Label savePasswordLabel = new Label(shell, SWT.NULL);
		savePasswordLabel.setText("Save password");
		savePassword = new Button(shell, SWT.CHECK);
		savePassword.setEnabled(false);
		
		buttonOK = new Button(shell, SWT.PUSH);
		buttonOK.setText("Ok");
		buttonOK.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
		buttonCancel = new Button(shell, SWT.PUSH);
		buttonCancel.setText("Cancel");

		buttonOK.addListener(SWT.Selection, this);
		shell.setDefaultButton(buttonOK);
		buttonCancel.addListener(SWT.Selection, this);

		
		if(session!=null){
			savedSessionsCombo.select(1+savedSessionsList.indexOf(session));
			username.setText(session.getUsername());
		}
		
		shell.addListener(SWT.Traverse, this);
		shell.pack();
		shell.open();

		Rectangle shellBounds = parent.getBounds();
		Point dialogSize = shell.getSize();
		shell.setLocation(
				shellBounds.x + (shellBounds.width - dialogSize.x) / 2,
				shellBounds.y + (shellBounds.height - dialogSize.y) / 2);

		Display display = parent.getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return session;

	}
	
	/**
	 * {@inheritDoc}
	 */
	public void handleEvent(Event event) {
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");
		if (event.type == SWT.Selection) {
			if (event.widget.equals(buttonOK)) {
				if(username.getEnabled()){
					session = WorkspaceFactory.eINSTANCE.createUsersession();
					session.setUsername(username.getText());
					
					domain.getCommandStack().execute(new RecordingCommand(domain){
						protected void doExecute() {
							WorkspaceManager.getInstance().getCurrentWorkspace().getUsersessions().add(session);
						}
					});
					
				}else{
					session = savedSessionsList.get(savedSessionsCombo.getSelectionIndex()-1);
				}
				domain.getCommandStack().execute(new RecordingCommand(domain){
					protected void doExecute() {
						session.setPassword(password.getText());
						session.setSavePassword(savePassword.getSelection());
						session.setServerInfo(serverInfo);
						serverInfo.setLastUsersession(session);
						WorkspaceManager.getInstance().getCurrentWorkspace().save();
					}
				});
				
			}else{
				session = null;
			}
			shell.dispose();
		}
	}

	
	/**
	 * {@inheritDoc}
	 */
	public void widgetDefaultSelected(SelectionEvent e) {
		// nothing to do here.
	}

	/**
	 * {@inheritDoc}
	 */
	public void widgetSelected(SelectionEvent e) {
		password.setEnabled(true);
		savePassword.setEnabled(true);
		if(savedSessionsCombo.getSelectionIndex()==0){
			username.setText("");
			password.setText("");
			username.setEnabled(true);
		}else{
			Usersession loadSession = savedSessionsList.get(savedSessionsCombo.getSelectionIndex()-1);
			username.setEnabled(false);
			username.setText(loadSession.getUsername());
			password.setText(loadSession.getPassword()+"");
			savePassword.setSelection(loadSession.isSavePassword());
		}
		
	}
}
