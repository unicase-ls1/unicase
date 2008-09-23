/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views.dialogs;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.ui.stem.Activator;
import org.unicase.ui.stem.views.ChangesTreeComposite;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.impl.ProjectSpaceImpl;

/**.
 * This class shows a ChangesTreeComposite and a Text control to enter
 * commit message.
 * 
 * @author Hodaie
 *
 */
public class CommitDialog extends TitleAreaDialog {

	private Text txtLogMsg;
	private String logMsg = "";
	private ProjectSpace projectSpace;

	/**.
	 * Constructor
	 * 
	 * @param parentShell shell
	 */
	public CommitDialog(Shell parentShell, ProjectSpace projectSpace) {

		super(parentShell);
		this.setShellStyle(this.getShellStyle() | SWT.RESIZE );
		this.projectSpace = projectSpace;

	}

	
	/**
	 * {@inheritDoc}
	 */
	protected Control createDialogArea(Composite parent) {
		Composite contents = new Composite(parent, SWT.NONE);
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		contents.setLayout(new GridLayout(2, false));
		
		setTitle("Commit your changes");
		setMessage("Don't forget the commit message!");
		setTitleImage(Activator.getImageDescriptor("icons/dontForget.png").createImage());
		
		//Log message
		Label lblLogMsg = new Label(contents, SWT.NONE);
		lblLogMsg.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false, 2, 1));
		lblLogMsg.setText("Log message:");
		
		txtLogMsg = new Text(contents, SWT.MULTI | SWT.LEAD | SWT.BORDER);
		txtLogMsg.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		txtLogMsg.setText("");
		
		//ChangesTree	
		ChangesTreeComposite changesTree = new ChangesTreeComposite(contents,
				SWT.BORDER, true);
		changesTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		ChangePackage changePackage = VersioningFactory.eINSTANCE.createChangePackage();
		changePackage.getOperations().addAll(projectSpace.getOperations());
		changesTree.setInput(changePackage);
		
		return contents;

	}
	
	/**.
	 * {@inheritDoc}
	 * 
	 */
	@Override
	protected void configureShell(Shell newShell) {
		
		super.configureShell(newShell);
		newShell.setText("Commit");
	}


	/**.
	 * {@inheritDoc}
	 * 
	 * 
	 */
	@Override
	protected void okPressed() {
		logMsg = txtLogMsg.getText();
		super.okPressed();
	}
	
	/**
	 * @return the log message that has been set by the user.
	 */
	public String getLogText(){
		return logMsg.equals("")?"<Empty log message>":logMsg;
	}
	
}

