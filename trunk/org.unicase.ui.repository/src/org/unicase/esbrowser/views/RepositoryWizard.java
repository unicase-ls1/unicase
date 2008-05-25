package org.unicase.esbrowser.views;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;

/**
 * Wizard for adding a new repository.
 * @author shterev
 *
 */
public class RepositoryWizard extends Wizard implements INewWizard {

	private ServerInfo serverInfo;

	private RepositoryMainPage mainPage;

	private IStructuredSelection selection;

	private IWorkbench workbench;

	private RepositoryView view;

	/**
	 * Default constructor.
	 * @param invoker the invoker view; needed to refresh it after the repository has been added.
	 */
	public RepositoryWizard(RepositoryView invoker) {
		super();
		view = invoker;
		serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
	}
	
	/**
	 * Adds all pages in the wizard.
	 */
	public void addPages() {
		mainPage = new RepositoryMainPage(workbench, selection);
		addPage(mainPage);
	}

	/**
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)	
	 * @param workbench the workbench
	 * @param selection the selection
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		if (selection != null && !selection.isEmpty()) {
			// 
		}
	}

	/**
	 * {@inheritDoc} 
	 */
	public boolean canFinish() {
		return true;
	}
	
	/**
	 * {@inheritDoc} 
	 */
	public boolean performFinish() {
		if (this.getContainer().getCurrentPage().canFlipToNextPage()) {
			//save serverInfo to workspace
			Workspace workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
			workspace.getServerInfos().add(this.serverInfo);
			workspace.save();
			view.getViewer().refresh();
			dispose();
		} else {
			MessageDialog.openError(workbench.getActiveWorkbenchWindow()
					.getShell(), "Error", "Field(s) were left blank!");
		}
		return true;
	}

	/**
	 * Getter for the ServerInfo.
	 * @return the {@link ServerInfo}
	 */
	public ServerInfo getServerInfo() {
		return serverInfo;
	}

}

/**
 * The main page of the wizard. 
 * @author shterev
 *
 */
class RepositoryMainPage extends WizardPage {

	private Text name;
	private Text displayName;
	private Text url;
	private Text port;

	/**
	 * Default constructor.
	 * @param workbench the current workbench
	 * @param selection the current selection
	 */
	public RepositoryMainPage(IWorkbench workbench,
			IStructuredSelection selection) {
		super("Main");
		setTitle("Server Details");
		setDescription("Select the details for the new repository");
	}

	/**
	 * {@inheritDoc}
	 */
	public void createControl(Composite parent) {

		GridData gd;
		Composite composite = new Composite(parent, SWT.NULL);

		GridLayout gl = new GridLayout();
		int ncol = 2;
		gl.numColumns = ncol;
		composite.setLayout(gl);

		new Label(composite, SWT.NONE).setText("Display name:");
		displayName = new Text(composite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol - 1;
		displayName.setLayoutData(gd);

		new Label(composite, SWT.NONE).setText("Name:");
		name = new Text(composite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol - 1;
		name.setLayoutData(gd);

		new Label(composite, SWT.NONE).setText("URL:");
		url = new Text(composite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol - 1;
		url.setLayoutData(gd);

		new Label(composite, SWT.NONE).setText("Port:");
		port = new Text(composite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol - 1;
		port.setLayoutData(gd);

		setControl(composite);
	}

	/**
	 * @return if the input on the current page is valid.
	 */
	public boolean canFlipToNextPage() {
		if (getErrorMessage() != null){
			return false;
		}
		if (isTextNonEmpty(name) && isTextNonEmpty(displayName)
				&& isTextNonEmpty(url) && isTextNonEmpty(port)){
			saveDataToModel();
			return true;
		}
		return false;
	}

	/**
	 * Saves the uses choices from this page to the model. Called on exit of the
	 * page
	 */
	private void saveDataToModel() {
		RepositoryWizard wizard = (RepositoryWizard) getWizard();
		ServerInfo serverInfo = wizard.getServerInfo();
		serverInfo.setDisplayName(displayName.getText());
		serverInfo.setName(name.getText());
		serverInfo.setUrl(url.getText());
		serverInfo.setPort(port.getText());
	}

	private static boolean isTextNonEmpty(Text t) {
		String s = t.getText();
		if ((s != null) && (s.trim().length() > 0)){
			return true;
		}
		return false;
	}

}
