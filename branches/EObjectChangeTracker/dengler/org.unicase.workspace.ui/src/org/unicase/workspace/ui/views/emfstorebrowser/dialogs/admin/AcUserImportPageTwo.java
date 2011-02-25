/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.dialogs.admin;

import java.util.ArrayList;

import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.unicase.workspace.ui.views.emfstorebrowser.acimport.ImportContentProvider;
import org.unicase.workspace.ui.views.emfstorebrowser.acimport.ImportLabelProvider;
import org.unicase.workspace.ui.views.emfstorebrowser.acimport.ImportWrapper;

/**
 * @author deser, karakoc
 */
public class AcUserImportPageTwo extends WizardPage {

	private TreeViewer tv;
	private ArrayList<ImportWrapper> wrappedOrgUnits;

	/**
	 * Page for displaying the OrgUnits that can be imported.
	 * 
	 * @param title
	 * @param message
	 */
	public AcUserImportPageTwo() {
		super("Page two");
	}

	/**
	 * @param parent composite, that will be filled.
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);

		composite.setLayout(new GridLayout(2, false));

		Button selectAll = new Button(composite, SWT.CHECK);
		selectAll.setText("Select/deselect all");

		selectAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				boolean selection = ((Button) event.widget).getSelection();
				traverseCheck(tv.getTree(), selection);
				setPageComplete(selection);
			}
		});

		tv = new TreeViewer(composite, SWT.CHECK | SWT.BORDER);

		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.horizontalSpan = 2;
		gridData.heightHint = 280; // TODO remove this "magic number"?
		tv.getTree().setLayoutData(gridData);

		tv.getTree().addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				if (event.detail == SWT.CHECK) {
					TreeItem item = (TreeItem) event.item;
					boolean checked = item.getChecked();
					traverseCheck(item, checked);

					// TODO not perfect:
					setPageComplete(true);
					// walk through the whole tree and look, if sth. is
					// selected now, if this is the case, then we can
					// finish otherwise not.
				}
			}
		});

		Button expandAllButton = new Button(composite, SWT.PUSH);
		expandAllButton.setText("Expand all");
		expandAllButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				tv.expandAll();
			}
		});

		Button collapseAllButton = new Button(composite, SWT.PUSH);
		collapseAllButton.setText("Collapse all");
		collapseAllButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				tv.collapseAll();
			}
		});

		setControl(composite);
		setPageComplete(false);
	}

	/**
	 * @return Returns all items, that are checked in the tree.
	 */
	public ArrayList<ImportWrapper> getCheckedItems() {
		// first clear old checked items
		wrappedOrgUnits = new ArrayList<ImportWrapper>();
		this.traverse(tv.getTree());
		return this.wrappedOrgUnits;
	}

	private void traverseCheck(TreeItem item, boolean check) {
		if (check) {
			tv.expandToLevel(item, AbstractTreeViewer.ALL_LEVELS);
		} else {
			tv.collapseToLevel(item, AbstractTreeViewer.ALL_LEVELS);
		}
		TreeItem[] items = item.getItems();
		for (int i = 0; i < items.length; i++) {
			items[i].setChecked(check);
			traverseCheck(items[i], check);
		}
	}

	private void traverseCheck(Tree tree, boolean check) {
		TreeItem[] items = tree.getItems();
		for (int i = 0; i < items.length; i++) {
			items[i].setChecked(check);
			traverseCheck(items[i], check);
		}
	}

	private void traverse(TreeItem item) {
		TreeItem[] items = item.getItems();
		for (int i = 0; i < items.length; i++) {
			if (items[i].getChecked()) {
				this.wrappedOrgUnits.add((ImportWrapper) items[i].getData());
			}
			traverse(items[i]);
		}

	}

	private void traverse(Tree tree) {
		TreeItem[] items = tree.getItems();
		for (int i = 0; i < items.length; i++) {
			if (items[i].getChecked()) {
				this.wrappedOrgUnits.add((ImportWrapper) items[i].getData());
			}
			traverse(items[i]);
		}

	}

	/**
	 * Initializes the page, i.e. this method is not called at the time this class gets instantiated but later, when the
	 * page is going to get displayed.
	 */
	public void init() {
		AcUserImportWizard wizard = (AcUserImportWizard) getWizard();

		// TODO progress monitor!

		tv.setContentProvider(new ImportContentProvider(wizard.getController()));
		tv.setLabelProvider(new ImportLabelProvider(wizard.getController()));
		tv.setInput(new Object()); // argument is a non-null that will be ignored

		this.setTitle(wizard.getController().getTitle());
		this.setMessage(wizard.getController().getMessage());
	}
}
