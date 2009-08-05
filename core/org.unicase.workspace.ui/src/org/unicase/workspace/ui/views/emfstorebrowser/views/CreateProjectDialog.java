/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.views;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.LayoutConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.ModelFactory;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.impl.WorkspaceImpl;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Create project dialog.
 * 
 * @author shterev
 */
public class CreateProjectDialog extends TitleAreaDialog {

	private Text txtProjectName;
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

		setTitle("Create new project");
		setMessage("Enter the name and the description of the project");

		Label name = new Label(contents, SWT.NULL);
		name.setText("Name:");
		txtProjectName = new Text(contents, SWT.SINGLE | SWT.BORDER);
		txtProjectName.setSize(150, 20);

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
						session.createProject(txtProjectName.getText(),
								txtProjectDesc.getText());
					} else {
						createLocalProject();
					}

				} catch (AccessControlException e) {
					DialogHandler.showExceptionDialog(e);
				} catch (EmfStoreException e) {
					DialogHandler.showExceptionDialog(e);
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

	private void createLocalProject() {
		WorkspaceImpl workspace = (WorkspaceImpl) WorkspaceManager
				.getInstance().getCurrentWorkspace();

		ProjectSpace projectSpace = WorkspaceFactory.eINSTANCE
				.createProjectSpace();
		projectSpace.setProject(ModelFactory.eINSTANCE.createProject());
		projectSpace.setProjectName(txtProjectName.getText());
		projectSpace.setProjectDescription(txtProjectDesc.getText());
		projectSpace.setLocalOperations(WorkspaceFactory.eINSTANCE
				.createOperationComposite());

		projectSpace.initResources((workspace).getWorkspaceResourceSet());

		workspace.addProjectSpace(projectSpace);
		workspace.save();

	}
}
