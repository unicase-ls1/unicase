/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.esbrowser.views;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
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
import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.Usersession;

/**
 * Create project dialog.
 * 
 * @author shterev
 */
public class CreateProjectDialog extends TitleAreaDialog {

	private Text projetname;
	private Text projectdesc;
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
		projetname = new Text(contents, SWT.SINGLE | SWT.BORDER);
		projetname.setSize(150, 20);

		Label desc = new Label(contents, SWT.NULL);
		desc.setText("Description:");
		projectdesc = new Text(contents, SWT.MULTI | SWT.BORDER);
		projectdesc.setSize(150, 60);

		Point defaultMargins = LayoutConstants.getMargins();
		GridLayoutFactory.fillDefaults().numColumns(2).margins(defaultMargins.x, defaultMargins.y).generateLayout(contents);

		return contents;
	}

	/**
	 * {@inheritDoc}
	 */
	public void okPressed() {
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				try {
					session.createProject(projetname.getText(), projectdesc.getText());
				} catch (AccessControlException e) {
					DialogHandler.showExceptionDialog(e);
				} catch (EmfStoreException e) {
					DialogHandler.showExceptionDialog(e);
				}
			}
		});
		close();
	}

	/**
	 * {@inheritDoc}
	 */
	public void cancelPressed() {
		close();
	}

}
