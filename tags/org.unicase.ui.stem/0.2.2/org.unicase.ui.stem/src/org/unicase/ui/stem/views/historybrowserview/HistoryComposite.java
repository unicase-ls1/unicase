/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views.historybrowserview;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.TagVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.ui.stem.views.changebrowserview.ChangeBrowserView;

/**
 * . This class provides contents of borwser tab of HistoryBrowserView. It
 * contains a table of versions based on Query criteria, and some buttons for
 * different operations (diff, create tag, update, switch, rollback) There is
 * currently no implementation for how the contents should be set, nor for
 * buttons.
 * 
 * 
 * @author Hodaie
 * 
 */
public class HistoryComposite extends Composite {

	private TableViewer tableViewer;
	private HistoryBrowserView parentView;
	private HistoryInfo sourceHistoryInfo;
	private HistoryInfo targetHistoryInfo;
	private Label lblSourceVersion;
	private Label lblTargetVersion;

	/**
	 * . Constructor
	 * 
	 * @param parentView
	 * 
	 * @param parent
	 *            parent
	 * @param style
	 *            style
	 */
	public HistoryComposite(HistoryBrowserView parentView, Composite parent,
			int style) {
		super(parent, style);
		this.parentView = parentView;
		this.setLayout(new GridLayout());
		createTable();

		tableViewer.setInput(getHistoryInfos());
		for (TableColumn column : tableViewer.getTable().getColumns()) {
			column.pack();
		}

		//TODO functionality for buttons isnt implemented 
		//createButtons();
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
		tableViewer = new TableViewer(this, SWT.FULL_SELECTION);
		tableViewer.getTable().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));

		Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		// revision column
		TableViewerColumn tclmRevision = new TableViewerColumn(tableViewer,
				SWT.LEAD);
		tclmRevision.getColumn().setText("Revision");

		// tag column
		TableViewerColumn tclmTag = new TableViewerColumn(tableViewer, SWT.LEAD);
		tclmTag.getColumn().setText("Tag");

		// date column
		TableViewerColumn tclmDate = new TableViewerColumn(tableViewer,
				SWT.LEAD);
		tclmDate.getColumn().setText("Date");

		// author column
		TableViewerColumn tclmAuthor = new TableViewerColumn(tableViewer,
				SWT.LEAD);
		tclmAuthor.getColumn().setText("Author");

		// log message column
		TableViewerColumn tclmLogMsg = new TableViewerColumn(tableViewer,
				SWT.LEAD);
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
				IStructuredSelection selection = (IStructuredSelection) tableViewer
						.getSelection();
				if (!selection.isEmpty()) {
					setSourceVersion((HistoryInfo) selection.getFirstElement());
				}
			}

		};

		Action actionSetTarget = new Action("Set as target") {
			@Override
			public void run() {
				IStructuredSelection selection = (IStructuredSelection) tableViewer
						.getSelection();
				if (!selection.isEmpty()) {
					setTargetHistoryInfo((HistoryInfo) selection
							.getFirstElement());
				}
			}
		};

		Action actionShowChangePackages = new Action(
				"Show associated change packages...") {
			@Override
			public void run() {
				IStructuredSelection selection = (IStructuredSelection) tableViewer
						.getSelection();
				if (!selection.isEmpty()) {
					showChangePackages((HistoryInfo) selection
							.getFirstElement());
				}
			}
		};

		MenuManager mgr = new MenuManager();
		mgr.add(actionSetSource);
		mgr.add(actionSetTarget);
		mgr.add(new Separator());
		mgr.add(actionShowChangePackages);

		tableViewer.getControl().setMenu(
				mgr.createContextMenu(tableViewer.getControl()));

	}

	/**
	 * . This invokes ChangeBrowserView and sets its input.
	 * 
	 * @param version
	 */
	protected void showChangePackages(HistoryInfo info) {
		// show ChangeBrowserView with version.ChangePackage as input

		IWorkbenchPage page = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		ChangeBrowserView changeBrowserView = null;
		try {
			changeBrowserView = (ChangeBrowserView) page
					.showView("org.unicase.ui.stem.ChangeBrowserView");
		} catch (PartInitException e) {
			DialogHandler.showExceptionDialog(e);
		}

		if (changeBrowserView != null) {
			// FIXME: OW ZH was muss hier hin?
			// changeBrowserView.setInput(version.getChanges());
		}

	}
	private int a = 6;
	// a dummay input to table
	private List<HistoryInfo> getHistoryInfos() {
		return parentView.getHistoryInfos();
	}

	 private List<HistoryInfo> createDummyVersions() {
	 HistoryInfo[] versions = new HistoryInfo[a];
	 for (int i = 0; i < a; i++) {
	 versions[i] = VersioningFactory.eINSTANCE.createHistoryInfo();
	 LogMessage logMessage = VersioningFactory.eINSTANCE
	 .createLogMessage();
	 logMessage.setAuthor("author" + i);
	 logMessage.setDate(new Date());
	 logMessage.setMessage("a mesage " + i);
	
	 PrimaryVersionSpec verSpec = VersioningFactory.eINSTANCE
	 .createPrimaryVersionSpec();
	 verSpec.setIdentifier(i);
	
	 TagVersionSpec tagSpec = VersioningFactory.eINSTANCE
	 .createTagVersionSpec();
	 tagSpec.setName("tag" + i+"test");
	
	 versions[i].setLogMessage(logMessage);
	 versions[i].setPrimerySpec(verSpec);
	 versions[i].getTagSpecs().add(tagSpec);
	 }
	 a++;
	 return Arrays.asList(versions);
	
	 }

	private void createButtons() {
		Group grpButtons = new Group(this, SWT.NONE);
		grpButtons.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false));
		grpButtons.setLayout(new GridLayout(10, false));

		// label for source version
		Label lblFrom = new Label(grpButtons, SWT.NONE);
		lblFrom
				.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		lblFrom.setText("From:");
		lblFrom.setFont(new Font(Display.getDefault(), "Tahoma", 8, SWT.BOLD));
		lblSourceVersion = new Label(grpButtons, SWT.NONE);
		lblSourceVersion.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 4, 1));
		lblSourceVersion
				.setText("here is the selected From version shown ....");

		// label for target version
		Label lblTo = new Label(grpButtons, SWT.NONE);
		lblTo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		lblTo.setText("To:");
		lblTo.setFont(new Font(Display.getDefault(), "Tahoma", 8, SWT.BOLD));
		lblTargetVersion = new Label(grpButtons, SWT.NONE);
		lblTargetVersion.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 4, 1));
		lblTargetVersion.setText("here is the selected To version shown ....");

		// a helper composite for buttons
		Composite composite = new Composite(grpButtons, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 10, 1));
		composite.setLayout(new GridLayout(5, true));

		// btnDiff
		Button btnDiff = new Button(composite, SWT.PUSH);
		btnDiff.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		btnDiff.setText("Diff");
		// TODO final implementation (implement button selected operation)

		// btnCreateTag
		Button btnCreateTag = new Button(composite, SWT.PUSH | SWT.CENTER);
		btnCreateTag
				.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		btnCreateTag.setText("Create Tag");
		// TODO final implementation (implement button selected operation)

		// btnUpdate
		Button btnUpdate = new Button(composite, SWT.PUSH);
		btnUpdate.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		btnUpdate.setText("Update");
		// TODO final implementation (implement button selected operation)

		// btnSwitch
		Button btnSwitch = new Button(composite, SWT.PUSH);
		btnSwitch.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		btnSwitch.setText("Switch");
		// TODO final implementation (implement button selected operation)

		// btnRollback
		Button btnRollback = new Button(composite, SWT.PUSH);
		btnRollback.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		btnRollback.setText("Rollback");
		// TODO final implementation (implement button selected operation)
	}

	/**
	 * .
	 * 
	 * @param sourceVersion
	 *            sourceVersion
	 */
	public void setSourceVersion(HistoryInfo sourceVersion) {
		this.sourceHistoryInfo = sourceVersion;
		lblSourceVersion.setText(Integer.toString(sourceVersion
				.getPrimerySpec().getIdentifier()));

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
	 * @param targetVersion
	 *            targetVersion
	 */
	public void setTargetHistoryInfo(HistoryInfo targetVersion) {
		this.targetHistoryInfo = targetVersion;
		lblTargetVersion.setText(Integer.toString(targetVersion
				.getPrimerySpec().getIdentifier()));
	}

	/**
	 * .
	 * 
	 * @return targetVersion
	 */
	public HistoryInfo getTargetHistoryInfo() {
		return targetHistoryInfo;
	}

}
