/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.esbrowser.dialogs;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.Usersession;

/**
 * Class for the login dialog.
 * 
 * @author shterev
 */
public class RepositoryCreateProjectDialog extends Dialog implements Listener {

	private Text projetname;
	private Text projectdesc;
	private Usersession session;
	private Shell shell;
	private Button buttonOK;
	private Button buttonCancel;

	/**
	 * Default constructor.
	 * 
	 * @param parent
	 *            the parent shell
	 * @param session
	 *            the target usersession
	 */
	public RepositoryCreateProjectDialog(Shell parent, Usersession session) {
		super(parent);
		this.session = session;
	}

	/**
	 * Runs the dialog.
	 */
	public void open() {
		Shell parent = getParent();
		shell = new Shell(parent, SWT.TITLE | SWT.BORDER
				| SWT.APPLICATION_MODAL);
		shell.setText("Create project");
		shell.setLayout(new GridLayout(2, true));

		Label name = new Label(shell, SWT.NULL);
		name.setText("Name:");
		projetname = new Text(shell, SWT.SINGLE | SWT.BORDER);
		projetname.setSize(150, 20);

		Label desc = new Label(shell, SWT.NULL);
		desc.setText("Description:");
		projectdesc = new Text(shell, SWT.MULTI | SWT.BORDER);
		projectdesc.setSize(150, 60);

		buttonOK = new Button(shell, SWT.PUSH);
		buttonOK.setText("Ok");
		buttonOK.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
		buttonCancel = new Button(shell, SWT.PUSH);
		buttonCancel.setText("Cancel");

		buttonOK.addListener(SWT.Selection, this);
		shell.setDefaultButton(buttonOK);
		buttonCancel.addListener(SWT.Selection, this);

		shell.addListener(SWT.Traverse, this);
		shell.pack();
		shell.open();

		Rectangle shellBounds = parent.getBounds();
		Point dialogSize = shell.getSize();
		shell.setLocation(shellBounds.x + (shellBounds.width - dialogSize.x)
				/ 2, shellBounds.y + (shellBounds.height - dialogSize.y) / 2);

		Display display = parent.getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void handleEvent(Event event) {
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		if (event.type == SWT.Selection) {
			if (event.widget.equals(buttonOK)) {
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						try {
							session.createProject(projetname.getText(),
									projectdesc.getText());
						} catch (AccessControlException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (EmfStoreException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
			}
			shell.dispose();
		}
	}
}
