/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.impl.ProjectSpaceImpl;
import org.unicase.workspace.ui.views.changes.MergeChangesComposite;

/**
 * This is the merge dialog. It shows three ChangesTreeComposites (my changes, merged changes, and their changes).
 * 
 * @author Hodaie
 * @author Shterev
 */
public class MergeDialog extends TitleAreaDialog {

	private List<ChangePackage> newChangePackages;
	private MergeChangesComposite mergeComposite;

	/**
	 * Constructor.
	 * 
	 * @param parentShell shell
	 * @param changePackages a the list of changes that are merged into the workspace
	 */
	public MergeDialog(Shell parentShell, List<ChangePackage> changePackages) {
		super(parentShell);
		this.setShellStyle(this.getShellStyle() | SWT.RESIZE);
		this.newChangePackages = changePackages;
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
		ChangePackage changePackage = VersioningFactory.eINSTANCE.createChangePackage();
		// FIXME AS MK: add the correct operations
		for (AbstractOperation operation : ((ProjectSpaceImpl) WorkspaceManager.getInstance().getCurrentWorkspace()
			.getActiveProjectSpace()).getLocalOperations().getOperations()) {
			changePackage.getOperations().add((AbstractOperation) EcoreUtil.copy(operation));
		}
		ArrayList<ChangePackage> myChangePackages = new ArrayList<ChangePackage>();
		myChangePackages.add(changePackage);
		mergeComposite = new MergeChangesComposite(contents, SWT.NONE, myChangePackages, newChangePackages);
		mergeComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		return contents;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void okPressed() {

		// MK fixme: we need the previous head version here
		VersionSpec headVersion = VersioningFactory.eINSTANCE.createHeadVersionSpec();

		// TODO MK: deal with the checked changes
		HashMap<String, List<AbstractOperation>> resultSet = mergeComposite.getResultSet();
		List<AbstractOperation> myChanges = resultSet.get("mineChecked");
		List<AbstractOperation> theirNotChecked = resultSet.get("theirsNotChecked");

		List<AbstractOperation> mergeResult = new ArrayList<AbstractOperation>();
		for (AbstractOperation operationToReverse : theirNotChecked) {
			mergeResult.add(0, operationToReverse.reverse());
		}
		mergeResult.addAll(myChanges);

		try {
			WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace().applyMergeResult(mergeResult,
				headVersion);
		} catch (EmfStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		super.okPressed();
		this.close();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int open() {
		return super.open();
	}

}
