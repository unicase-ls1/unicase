/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.mergetest;

import java.util.List;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.unicase.emfstore.conflictDetection.ConflictDetector;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.ui.dialogs.merge.DecisionManager;
import org.unicase.workspace.ui.dialogs.merge.MergeWizard;
import org.unicase.workspace.util.UnicaseCommand;

public class ShowConflictsDialog extends TitleAreaDialog {

	private ListViewer listViewer;
	private final ShowConflictsController analyzeConflict;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite contents = new Composite(parent, SWT.NONE);
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		contents.setLayout(new GridLayout());
		Label lbl1 = new Label(contents, SWT.NONE);
		lbl1
				.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
						false));
		lbl1.setText("Selected Conflict:");

		listViewer = new ListViewer(contents, SWT.SINGLE);
		listViewer.getList().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));
		listViewer.setContentProvider(new IStructuredContentProvider() {
			public Object[] getElements(Object inputElement) {
				return analyzeConflict.conflicts.toArray();
			}

			public void dispose() {
			}

			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
			}
		});

		listViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				String res = "";
				if (element instanceof int[]) {
					int[] v = (int[]) element;
					res = "Conflict in: " + v[0] + " (" + v[1] + "-" + v[2]
							+ ")";
				}
				return res;
			}

		});
		listViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				Object source = (((StructuredSelection) event.getSelection())
						.getFirstElement());
				if (source instanceof int[]) {
					final int[] v = (int[]) source;

					new UnicaseCommand() {
						@Override
						protected void doRun() {
							try {
								ProjectSpace projectSpace = WorkspaceFactory.eINSTANCE
										.createProjectSpace();
								projectSpace.setProject(analyzeConflict
										.getProject(v[0]));

								WorkspaceManager.getInstance()
										.getCurrentWorkspace()
										.setActiveProjectSpace(projectSpace);

								MergeDialog mergeDialog = new MergeDialog(
										getShell());
								ChangePackage myChanges = analyzeConflict
										.getChanges(v[0] - 1, v[0]).get(0);
								List<ChangePackage> theirChanges = analyzeConflict
										.getChanges(v[1], v[2]);
								
								ConflictDetector conflictDetector = new ConflictDetector();
								conflictDetector.filterToConflictInvolved(myChanges, theirChanges);
								
								DecisionManager decisionManager = new DecisionManager(analyzeConflict
										.getProject(v[0]),analyzeConflict
										.getChanges(v[0] - 1, v[0]).get(0),analyzeConflict
										.getChanges(v[1], v[2]));
								
								MergeWizard wizard = new MergeWizard(decisionManager);
								
//								MergeWizard wizard = new MergeWizard(analyzeConflict.getProject(v[0]), theirChanges, myChanges);
								
								WizardDialog dialog = new WizardDialog(Display.getCurrent().getActiveShell(), wizard);
								dialog.create();
								dialog.open();
								
//								mergeDialog.setChanges(analyzeConflict
//								.getChanges(v[0] - 1, v[0]).get(0), analyzeConflict
//												.getChanges(v[1], v[2]));
//								mergeDialog.open();
//								
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}.run();

				}
			}
		});
		listViewer.setInput(new Object());

		this.setTitle("Please choose a title");
		return contents;
	}

	@Override
	protected void okPressed() {
		super.okPressed();
	}

	public ShowConflictsDialog(ShowConflictsController con) {
		super(Display.getCurrent().getActiveShell());
		this.analyzeConflict = con;
		this.setShellStyle(this.getShellStyle() | SWT.RESIZE);
	}

}
