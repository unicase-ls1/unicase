package org.unicase.xmi.views;



import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.LayoutConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
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

public class ImportProjectDialog extends TitleAreaDialog {

	private Text txtProjectName;
	private FileDialog projectLocation;
	private Usersession session;

	/**
	 * Name of the project that can be set before the dialog is opened.
	 */
	private String presetName;
	
	/**
	 * Default constructor.
	 * 
	 * @param parent
	 *            the parent shell
	 * @param session
	 *            the target usersession
	 */
	public ImportProjectDialog(Shell parent, Usersession session) {
		super(parent);
		this.session = session;
		presetName = "";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite contents = new Composite(parent, SWT.NONE);
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		setTitle("Import Project");
		setMessage("Please enter the name of your project-file and its location.");
		
		Label name = new Label(contents, SWT.NULL);
		name.setText("Name:");
		txtProjectName = new Text(contents, SWT.SINGLE | SWT.BORDER);
		txtProjectName.setSize(150, 20);
		if(presetName != "") txtProjectName.setText(presetName);
		
		projectLocation = new FileDialog(super.getParentShell(), SWT.OPEN);
		//projectLocation.setFilterPath(Platform.getLocation().toOSString());
		projectLocation.setFilterNames(new String[] {"XMI Project Resources (*.ucw)",
			"XML Model Resources (*.xml)",
			"XMI Model Resources (*.xmi)"});
		projectLocation.setFilterExtensions(new String[] {"*.ucw", "*.xml", "*.xmi"});
		
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
						if(ws instanceof XMIECPWorkspace) {
							XMIECPFileProject project = XmiworkspacestructureFactory.eINSTANCE.createXMIECPFileProject();
							project.setProjectName(txtProjectName.getText());
							project.setXmiFilePath(projectLocation.open());
							
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

	/**
	 * Sets a name for the project.
	 * @param name Name of the new project.
	 */
	public void setProjectName(String name) {
		this.presetName = name;
	}
}
