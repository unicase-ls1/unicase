/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.edit.views.dialogs;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.edit.views.changescomposite.ChangesTreeComposite;

/**
 * This class shows a ChangesTreeComposite and a Text control to enter commit
 * message.
 * 
 * @author Hodaie
 * @author Shterev
 * 
 */
public class CommitDialog extends TitleAreaDialog {

	private Text txtLogMsg;
	private String logMsg = "";
	private ChangePackage changes;
	private EList<String> oldLogMessages;

	/**
	 * Constructor.
	 * 
	 * @param parentShell
	 *            shell
	 * @param changes
	 *            the {@link ChangePackage} to be displayed
	 */
	public CommitDialog(Shell parentShell, ChangePackage changes) {
		super(parentShell);
		this.setShellStyle(this.getShellStyle() | SWT.RESIZE);
		this.changes = changes;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite contents = new Composite(parent, SWT.NONE);
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		contents.setLayout(new GridLayout(2, false));

		setTitle("Commit your changes");
		setMessage("Don't forget the commit message!");
//		setTitleImage(Activator.getImageDescriptor("icons/dontForget.png")
//				.createImage());

		// Log message
		Label lblLogMsg = new Label(contents, SWT.NONE);
		lblLogMsg.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false, 2, 1));
		lblLogMsg.setText("Log message:");

		txtLogMsg = new Text(contents, SWT.MULTI | SWT.LEAD | SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).span(2, 1).align(
				SWT.FILL, SWT.TOP).hint(1, 150).applyTo(txtLogMsg);
		txtLogMsg.setText("");

		// previous log messages
		Label oldLabel = new Label(contents, SWT.NONE);
		oldLabel.setText("Previous messages:");
		final Combo oldMsg = new Combo(contents, SWT.READ_ONLY);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.TOP).grab(true,
				false).applyTo(oldMsg);
		oldLogMessages = WorkspaceManager.getInstance().getCurrentWorkspace()
				.getActiveProjectSpace().getOldLogMessages();
		oldMsg.setItems((String[]) oldLogMessages.toArray());
		oldMsg.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				// nothing to do here
			}

			public void widgetSelected(SelectionEvent e) {
				txtLogMsg.setText(oldMsg.getItem(oldMsg.getSelectionIndex()));
			}

		});

		// ChangesTree
		ArrayList<ChangePackage> changePackages = new ArrayList<ChangePackage>();
		changePackages.add(changes);
		ChangesTreeComposite changesTree = new ChangesTreeComposite(contents,
				SWT.BORDER, changePackages);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true,
				true).span(2, 1).applyTo(changesTree);
		changesTree.setInput(changePackages);

		return contents;

	}

	/**
	 * . {@inheritDoc}
	 * 
	 */
	@Override
	protected void configureShell(Shell newShell) {

		super.configureShell(newShell);
		newShell.setText("Commit");
		Rectangle area = Display.getCurrent().getClientArea();
		int width = area.width * 2 / 3;
		int height = area.height * 2 / 3;
		newShell.setBounds((area.width - width) / 2,
				(area.height - height) / 2, width, height);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void okPressed() {
		logMsg = txtLogMsg.getText();

		// suppress duplicates
		if (!oldLogMessages.contains(logMsg)) {
			oldLogMessages.add(logMsg);
		}

		// remove older messages
		if (oldLogMessages.size() > 10) {
			// the list can only grow one element at a time,
			// so only one element should be deleted
			oldLogMessages.remove(0);
		}
		super.okPressed();
	}

	/**
	 * @return the log message that has been set by the user.
	 */
	public String getLogText() {
		return logMsg.equals("") ? "<Empty log message>" : logMsg;
	}

}
