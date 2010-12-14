package org.unicase.xmi.views;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.LayoutConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.xmi.exceptions.XMIWorkspaceException;
import org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject;
import org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructureFactory;

public class CreateProjectDialog extends TitleAreaDialog {
	
	private Text txtProjectName;
	private Text txtProjectLocation;
	private Text txtProjectDesc;
	private Usersession session;

	/**
	 * Default constructor.
	 * 
	 * @param parent
	 *            the parent shell
	 * @param session
	 *            the target usersession
	 */
	public CreateProjectDialog(Shell parent, Usersession session) {
		super(parent);
		this.session = session;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite contents = new Composite(parent, SWT.NONE);
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		setTitle("Create New Project");
		setMessage("Please enter the name, the location and a description of the project.");

		Label name = new Label(contents, SWT.NULL);
		name.setText("Name:");
		txtProjectName = new Text(contents, SWT.SINGLE | SWT.BORDER);
		txtProjectName.setSize(150, 20);
		Label dummy = new Label (contents, SWT.NULL);
		dummy.setText("");
		
		Label location = new Label(contents, SWT.NULL);
		location.setText("Location:");
		txtProjectLocation = new Text(contents, SWT.SINGLE | SWT.BORDER);
		txtProjectLocation.setSize(150, 20);
		
		Button browse = new Button(contents, SWT.PUSH);
		browse.setText("Browse");
		// TODO add selectionListener

		Label desc = new Label(contents, SWT.NULL);
		desc.setText("Description:");
		txtProjectDesc = new Text(contents, SWT.MULTI | SWT.BORDER);
		txtProjectDesc.setSize(150, 60);

		Point defaultMargins = LayoutConstants.getMargins();
		GridLayoutFactory.fillDefaults().numColumns(3).margins(
				defaultMargins.x, defaultMargins.y).generateLayout(contents);

		return contents;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void okPressed() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				try {

					if (session != null) {
						new XMIWorkspaceException("Session not known to Workspace-Provider.");
					} else {						
						// get ECPWorkspace
						ECPWorkspace ws = ECPWorkspaceManager.getInstance().getWorkSpace();
						XMIECPFileProject project = XmiworkspacestructureFactory.eINSTANCE.createXMIECPFileProject();
						project.setProjectName(txtProjectName.getText());
						project.setXmiFilePath(txtProjectLocation.getText());
						project.setWorkspace(ws);
						
						// add a new XMIFileProject to the workspace
						ws.getProjects().add(project);
					}

				} catch (Exception e) {
					new XMIWorkspaceException("Could not create new model element.", e);
				}
			}

		}.run();
		close();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void cancelPressed() {
		close();
	}

}
