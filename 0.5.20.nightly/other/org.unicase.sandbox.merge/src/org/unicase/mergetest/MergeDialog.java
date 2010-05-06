/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.mergetest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

/**
 * This is the merge dialog. It shows three ChangesTreeComposites (my changes, merged changes, and their changes).
 * 
 * @author Hodaie
 * @author Shterev
 */
public class MergeDialog extends TitleAreaDialog {

	private MergeChangesComposite mergeComposite;

	private List<AbstractOperation> acceptedMine;
	private List<AbstractOperation> rejectedTheirs;
	private ChangePackage myChangePackage;
	private List<ChangePackage> theirChangePackages;

	/**
	 * Constructor.
	 * 
	 * @param parentShell shell
	 */
	public MergeDialog(Shell parentShell) {
		super(parentShell);
		this.setShellStyle(this.getShellStyle() | SWT.RESIZE);
		acceptedMine = new ArrayList<AbstractOperation>();
		rejectedTheirs = new ArrayList<AbstractOperation>();
	}

	/**
	 * Initializes this dialog.
	 * 
	 * @param myChanges my changes
	 * @param theirChanges their changes
	 */
	public void setChanges(ChangePackage myChanges, List<ChangePackage> theirChanges) {
		this.myChangePackage = myChanges;
		this.theirChangePackages = theirChanges;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Merge");
		Rectangle area = Display.getCurrent().getClientArea();
		int width = area.width * 8 / 9;
		int height = area.height * 8 / 9;
		newShell.setBounds((area.width - width) / 2, (area.height - height) / 2, width, height);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setMessage("Please select the changes you want to accept using the checkboxes. \n"
			+ "To show a quick conflict preview just mark the given operation.");

		Composite contents = new Composite(parent, SWT.NONE);
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		contents.setLayout(new GridLayout(2, false));

		// lblMyChanges
		Label lblMyChanges = new Label(contents, SWT.NONE);
		lblMyChanges.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false, 1, 1));
		lblMyChanges.setText("My changes");

		// lblTheirChanges
		Label lblTheirChanges = new Label(contents, SWT.NONE);
		lblTheirChanges.setLayoutData(new GridData(SWT.END, SWT.CENTER, false, false, 1, 1));
		lblTheirChanges.setText("Their changes");

		// Sash
		mergeComposite = new MergeChangesComposite(contents, SWT.NONE, Arrays.asList(myChangePackage),
			theirChangePackages);
		mergeComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		Button acceptMine = new Button(contents, SWT.PUSH);
		acceptMine.setText("Accept all");
		acceptMine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				mergeComposite.selectAllMine();
			}
		});
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(acceptMine);

		Button acceptTheirs = new Button(contents, SWT.PUSH);
		acceptTheirs.setText("Accept all");
		acceptTheirs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				mergeComposite.selectAllTheirs();
			}
		});
		GridDataFactory.fillDefaults().align(SWT.END, SWT.BEGINNING).applyTo(acceptTheirs);
		
		return contents;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void okPressed() {

		HashMap<String, List<AbstractOperation>> resultSet = mergeComposite.getResultSet();
		acceptedMine = resultSet.get("mineChecked");
		rejectedTheirs = resultSet.get("theirsNotChecked");

		super.okPressed();
		this.close();
	}

	/**
	 * @return the accepted operations
	 */
	public List<AbstractOperation> getAcceptedMine() {
		return acceptedMine;
	}

	/**
	 * @return the rejected operations
	 */
	public List<AbstractOperation> getRejectedTheirs() {
		return rejectedTheirs;
	}
}
