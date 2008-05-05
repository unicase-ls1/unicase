package org.unicase.ui.repository.views;

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
import org.unicase.workspace.impl.WorkspaceFactoryImpl;

public class RepositoryWizard extends Wizard implements INewWizard {

	RepositoryView parent;

	ServerInfo serverInfo;

	RepositoryMainPage mainPage;

	protected IStructuredSelection selection;

	// the workbench instance
	protected IWorkbench workbench;

	/**
	 * Default constructor.
	 */
	public RepositoryWizard() {
		super();
		serverInfo = WorkspaceFactoryImpl.eINSTANCE.createServerInfo();
	}

	public void setRepositoryView(RepositoryView repositoryView) {
		this.parent = repositoryView;
	}

	public void addPages() {
		mainPage = new RepositoryMainPage(workbench, selection);
		addPage(mainPage);
	}

	/**
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		if (selection != null && !selection.isEmpty()) {
			// 
		}
	}

	public boolean canFinish() {
		return true;
	}

	public boolean performFinish() {
		if (this.getContainer().getCurrentPage().canFlipToNextPage()) {
			parent.addRepository(serverInfo);
			MessageDialog.openInformation(workbench.getActiveWorkbenchWindow()
					.getShell(), "Success",
					"Repository was successfully added!");
		} else {
			MessageDialog.openError(workbench.getActiveWorkbenchWindow()
					.getShell(), "Error", "Field(s) were left blank!");
		}
		return true;
	}

}

class RepositoryMainPage extends WizardPage {

	IWorkbench workbench;
	IStructuredSelection selection;

	Text name;
	Text displayName;
	Text url;
	Text port;

	public RepositoryMainPage(IWorkbench workbench,
			IStructuredSelection selection) {
		super("Main");
		setTitle("Server Details");
		setDescription("Select the details for the new repository");
		this.workbench = workbench;
		this.selection = selection;
	}

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


	public boolean canFlipToNextPage() {
		if (getErrorMessage() != null)
			return false;
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
		// Gets the model
		RepositoryWizard wizard = (RepositoryWizard) getWizard();
		ServerInfo serverInfo = wizard.serverInfo;
		serverInfo.setDisplayName(displayName.getText());
		serverInfo.setName(name.getText());
		serverInfo.setUrl(url.getText());
		serverInfo.setPort(port.getText());
	}

	private static boolean isTextNonEmpty(Text t) {
		String s = t.getText();
		if ((s != null) && (s.trim().length() > 0))
			return true;
		return false;
	}

}