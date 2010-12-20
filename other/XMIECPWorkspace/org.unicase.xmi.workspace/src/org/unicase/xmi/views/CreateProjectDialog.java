package org.unicase.xmi.views;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.LayoutConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.xmi.exceptions.XMIWorkspaceException;
import org.unicase.xmi.workspace.XMIECPWorkspace;
import org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject;
import org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructureFactory;

public class CreateProjectDialog extends TitleAreaDialog {
	
	private Text txtProjectName;
	private Text txtProjectDesc;
	private Text txtProjectLocation;
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

		// Ask for project name
		Label name = new Label(contents, SWT.NULL);
		name.setText("Name:");
		txtProjectName = new Text(contents, SWT.SINGLE | SWT.BORDER);
		txtProjectName.setSize(150, 20);
		
		// Determine Location
		Label locationLabel = new Label(contents, SWT.NULL);
		locationLabel.setText("Location:");
		
		Composite location = new Composite(contents, SWT.NONE);
		location.setLayout(new FillLayout());
		txtProjectLocation = new Text(location, SWT.SINGLE | SWT.BORDER); 
		txtProjectLocation.setSize(140, 20);
		Button browseButton = new Button(location, SWT.NONE);
		browseButton.setText("Browse...");
		final Shell shell = super.getParentShell();
		browseButton.addSelectionListener(new SelectionListener() {

			DirectoryDialog dirDialog = new DirectoryDialog(shell, SWT.OPEN);
			String path = Platform.getLocation().toOSString();
			
			public void widgetDefaultSelected(SelectionEvent e) {
				path = dirDialog.open();
				if(txtProjectName.getText() == null || txtProjectName.getText() == "") {
					path += "/newproject.ucw";
				}
				else {
					path += "/" + txtProjectName.getText() + ".ucw";
				}
				txtProjectLocation.setText(path);
			}

			public void widgetSelected(SelectionEvent e) {
				widgetDefaultSelected(e);
			}
			
		});
		browseButton.setEnabled(true);

		Label desc = new Label(contents, SWT.NULL);
		desc.setText("Description:");
		txtProjectDesc = new Text(contents, SWT.MULTI | SWT.BORDER);
		txtProjectDesc.setSize(150, 60);

		Point defaultMargins = LayoutConstants.getMargins();
		GridLayoutFactory.fillDefaults().numColumns(2).margins(
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
						if(ws instanceof XMIECPWorkspace) {
							XMIECPFileProject project = XmiworkspacestructureFactory.eINSTANCE.createXMIECPFileProject();
							project.setProjectName(txtProjectName.getText());
							project.setProjectDescription(txtProjectDesc.getText());
							project.setXmiFilePath(txtProjectLocation.getText());
							
							// add a new XMIFileProject to the workspace
							((XMIECPWorkspace) ws).addProject(project);
						}
						else {
							new XMIWorkspaceException("Could not add project to workspace. Unknown workspace.");
						}
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
