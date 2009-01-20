/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright> $Id$
 */
package org.unicase.workspace.edit.views.historybrowserview;

import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.TagVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.ui.common.commands.ActionHelper;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.edit.views.changes.AbstractChangesComposite;
import org.unicase.workspace.edit.views.changes.TabbedChangesComposite;

/**
 * . This class provides contents of borwser tab of HistoryBrowserView. It contains a table of versions based on Query
 * criteria, and some buttons for different operations (diff, create tag, update, switch, rollback) There is currently
 * no implementation for how the contents should be set, nor for buttons.
 * 
 * @author Hodaie
 */
public class HistoryComposite extends Composite implements ISelectionChangedListener, IDoubleClickListener {

	private TableViewer tableViewer;
	private HistoryBrowserView parentView;
	private HistoryInfo sourceHistoryInfo;
	private HistoryInfo targetHistoryInfo;
	private Label lblSourceVersion;
	private Label lblTargetVersion;
	private TabbedChangesComposite changesComposite;
	private SashForm sash;
	private Composite bottom;
	private Composite top;

	/**
	 * Constructor.
	 * 
	 * @param parentView the parent view
	 * @param parent parent
	 * @param style style
	 */
	public HistoryComposite(HistoryBrowserView parentView, Composite parent, int style) {
		super(parent, style);
		this.parentView = parentView;
		this.setLayout(new GridLayout());
		sash = new SashForm(this, SWT.VERTICAL);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(this);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(sash);
		top = new Composite(sash, SWT.NONE);
		bottom = new Composite(sash, SWT.NONE);
		top.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_BLUE));
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).applyTo(top);
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).applyTo(bottom);
		int[] topWeights = { 50, 50 };
		sash.setWeights(topWeights);

		createTable();
		tableViewer.setInput(getHistoryInfos());
		for (TableColumn column : tableViewer.getTable().getColumns()) {
			column.pack();
		}

		// TODO functionality for buttons isnt implemented
		// createButtons();
	}

	/**
	 * Updates the table.
	 */
	public void updateTable() {
		tableViewer.setInput(getHistoryInfos());
		for (TableColumn column : tableViewer.getTable().getColumns()) {
			column.pack();
		}
		tableViewer.refresh();
	}

	private void createTable() {
		tableViewer = new TableViewer(top, SWT.FULL_SELECTION);
		tableViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		tableViewer.addSelectionChangedListener(this);

		Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		// revision column
		TableViewerColumn tclmRevision = new TableViewerColumn(tableViewer, SWT.LEAD);
		tclmRevision.getColumn().setText("Revision");

		// tag column
		TableViewerColumn tclmTag = new TableViewerColumn(tableViewer, SWT.LEAD);
		tclmTag.getColumn().setText("Tag");

		// date column
		TableViewerColumn tclmDate = new TableViewerColumn(tableViewer, SWT.LEAD);
		tclmDate.getColumn().setText("Date");

		// author column
		TableViewerColumn tclmAuthor = new TableViewerColumn(tableViewer, SWT.LEAD);
		tclmAuthor.getColumn().setText("Author");

		// log message column
		TableViewerColumn tclmLogMsg = new TableViewerColumn(tableViewer, SWT.LEAD);
		tclmLogMsg.getColumn().setText("Log Message");

		tableViewer.setContentProvider(new HistoryTableContentProvider());
		tableViewer.setLabelProvider(new HistoryTableLabelProvider());
		tableViewer.setInput(getHistoryInfos());

		hookTableCntextMenu();

	}

	// a context menu with tree commands (set as source, set as target, and
	// show change package) shown on versions table
	private void hookTableCntextMenu() {
		Action actionSetSource = new Action("Set as source") {
			@Override
			public void run() {
				IStructuredSelection selection = (IStructuredSelection) tableViewer.getSelection();
				if (!selection.isEmpty()) {
					setSourceVersion((HistoryInfo) selection.getFirstElement());
				}
			}

		};
		actionSetSource.setEnabled(false);

		Action actionSetTarget = new Action("Set as target") {
			@Override
			public void run() {
				IStructuredSelection selection = (IStructuredSelection) tableViewer.getSelection();
				if (!selection.isEmpty()) {
					setTargetHistoryInfo((HistoryInfo) selection.getFirstElement());
				}
			}
		};
		actionSetTarget.setEnabled(false);

		Action actionShowChangePackages = new Action("Show associated change packages...") {
			@Override
			public void run() {
				IStructuredSelection selection = (IStructuredSelection) tableViewer.getSelection();
				if (!selection.isEmpty()) {
					showChangePackages((HistoryInfo) selection.getFirstElement());
				}
			}
		};
		actionShowChangePackages.setEnabled(false);

		Action actionAddTag = new Action("Add tag") {
			@Override
			public void run() {
				IStructuredSelection selection = (IStructuredSelection) tableViewer.getSelection();
				if (!selection.isEmpty()) {
					HistoryInfo info = (HistoryInfo) selection.getFirstElement();
					InputDialog inputDialog = new InputDialog(getShell(), "Add tag", "Please enter the tag's name.",
						"", null);
					inputDialog.open();
					String str = inputDialog.getValue().trim();
					if (!(str == null || str.equals(""))) {
						TagVersionSpec tag = VersioningFactory.eINSTANCE.createTagVersionSpec();
						tag.setName(str);
						parentView.addTag(info.getPrimerySpec(), tag);
						parentView.refresh();
					}
				}
			}

		};

		Action actionRemoveTag = new Action("Remove tag") {
			@Override
			public void run() {
				// TODO OW: implement
			}

		};
		actionRemoveTag.setEnabled(false);

		MenuManager mgr = new MenuManager();
		mgr.add(actionSetSource);
		mgr.add(actionSetTarget);
		mgr.add(new Separator());
		mgr.add(actionShowChangePackages);
		mgr.add(new Separator());
		mgr.add(actionAddTag);
		mgr.add(actionRemoveTag);

		tableViewer.getControl().setMenu(mgr.createContextMenu(tableViewer.getControl()));

	}

	/**
	 * This invokes ChangeBrowserView and sets its input.
	 * 
	 * @param info the history info
	 */
	protected void showChangePackages(HistoryInfo info) {
		// show ChangeBrowserView with version.ChangePackage as input
		// do nothing
	}

	private List<HistoryInfo> getHistoryInfos() {
		return parentView.getHistoryInfos();
	}

	// private void createButtons() {
	// Group grpButtons = new Group(this, SWT.NONE);
	// grpButtons.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
	// false));
	// grpButtons.setLayout(new GridLayout(10, false));
	//
	// // label for source version
	// Label lblFrom = new Label(grpButtons, SWT.NONE);
	// lblFrom
	// .setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
	// lblFrom.setText("From:");
	// lblFrom.setFont(new Font(Display.getDefault(), "Tahoma", 8, SWT.BOLD));
	// lblSourceVersion = new Label(grpButtons, SWT.NONE);
	// lblSourceVersion.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER,
	// false, false, 4, 1));
	// lblSourceVersion
	// .setText("here is the selected From version shown ....");
	//
	// // label for target version
	// Label lblTo = new Label(grpButtons, SWT.NONE);
	// lblTo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
	// lblTo.setText("To:");
	// lblTo.setFont(new Font(Display.getDefault(), "Tahoma", 8, SWT.BOLD));
	// lblTargetVersion = new Label(grpButtons, SWT.NONE);
	// lblTargetVersion.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER,
	// false, false, 4, 1));
	// lblTargetVersion.setText("here is the selected To version shown ....");
	//
	// // a helper composite for buttons
	// Composite composite = new Composite(grpButtons, SWT.NONE);
	// composite.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
	// false, 10, 1));
	// composite.setLayout(new GridLayout(5, true));
	//
	// // btnDiff
	// Button btnDiff = new Button(composite, SWT.PUSH);
	// btnDiff.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	// btnDiff.setText("Diff");
	// // TODO final implementation (implement button selected operation)
	//
	// // btnCreateTag
	// Button btnCreateTag = new Button(composite, SWT.PUSH | SWT.CENTER);
	// btnCreateTag
	// .setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	// btnCreateTag.setText("Create Tag");
	// // TODO final implementation (implement button selected operation)
	//
	// // btnUpdate
	// Button btnUpdate = new Button(composite, SWT.PUSH);
	// btnUpdate.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	// btnUpdate.setText("Update");
	// // TODO final implementation (implement button selected operation)
	//
	// // btnSwitch
	// Button btnSwitch = new Button(composite, SWT.PUSH);
	// btnSwitch.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	// btnSwitch.setText("Switch");
	// // TODO final implementation (implement button selected operation)
	//
	// // btnRollback
	// Button btnRollback = new Button(composite, SWT.PUSH);
	// btnRollback.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	// btnRollback.setText("Rollback");
	// // TODO final implementation (implement button selected operation)
	// }

	/**
	 * .
	 * 
	 * @param sourceVersion sourceVersion
	 */
	public void setSourceVersion(HistoryInfo sourceVersion) {
		this.sourceHistoryInfo = sourceVersion;
		lblSourceVersion.setText(Integer.toString(sourceVersion.getPrimerySpec().getIdentifier()));

	}

	/**
	 * .
	 * 
	 * @return sourceVersion
	 */
	public HistoryInfo getSourceHistoryInfo() {
		return sourceHistoryInfo;
	}

	/**
	 * .
	 * 
	 * @param targetVersion targetVersion
	 */
	public void setTargetHistoryInfo(HistoryInfo targetVersion) {
		this.targetHistoryInfo = targetVersion;
		lblTargetVersion.setText(Integer.toString(targetVersion.getPrimerySpec().getIdentifier()));
	}

	/**
	 * .
	 * 
	 * @return targetVersion
	 */
	public HistoryInfo getTargetHistoryInfo() {
		return targetHistoryInfo;
	}

	/**
	 * {@inheritDoc}
	 */
	public void selectionChanged(SelectionChangedEvent event) {
		Object selection = ((IStructuredSelection) event.getSelection()).getFirstElement();
		if (selection != null && selection instanceof HistoryInfo) {
			HistoryInfo historyInfo = (HistoryInfo) selection;
			PrimaryVersionSpec currentVersionSpec = historyInfo.getPrimerySpec();
			int current = currentVersionSpec.getIdentifier();

			if (changesComposite != null && !changesComposite.isDisposed()) {
				changesComposite.dispose();
			}
			// skip the initial change package
			if (current != 0) {
				int prev = current - 1;
				PrimaryVersionSpec prevVersionSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
				prevVersionSpec.setIdentifier(prev);
				List<ChangePackage> changes = null;
				try {
					changes = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace().getChanges(
						prevVersionSpec, currentVersionSpec);
				} catch (EmfStoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				changesComposite = new TabbedChangesComposite(bottom, SWT.NONE, changes);
				for (AbstractChangesComposite tab : changesComposite.getTabs()) {
					tab.getTreeViewer().addDoubleClickListener(this);
				}
				GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(changesComposite);
			}
			bottom.layout(true);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void doubleClick(DoubleClickEvent event) {
		TreeSelection selection = (TreeSelection) event.getSelection();
		Object element = selection.getFirstElement();
		Project project = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace().getProject();
		ModelElement me = null;
		String message = "The element you are trying to open was deleted in a later revision.";
		String title = "Deleted element";
		if (element instanceof ModelElement) {
			me = (ModelElement) element;
		} else if (element instanceof AbstractOperation) {
			AbstractOperation op = (AbstractOperation) element;
			me = project.getModelElement(op.getModelElementId());
			if (me == null) {
				MessageDialog.openWarning(getShell(), title, message);
			}
		}
		if (me != null) {
			if (project.contains(me)) {
				ActionHelper.openModelElement(me, parentView.getClass().getName());
			} else {
				MessageDialog.openWarning(getShell(), title, message);
			}
		}
	}
}
