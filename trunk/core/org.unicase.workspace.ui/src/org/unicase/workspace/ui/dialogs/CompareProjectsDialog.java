/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs;

import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * Dialog for project comparison.
 * 
 * @author zardosht
 */
public class CompareProjectsDialog extends TitleAreaDialog {

	private ProjectSpace selectedProjectSpace;
	private ListViewer listViewer;

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
		lbl1.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lbl1.setText("Selected Project:");
		Label lblSelectedProj = new Label(contents, SWT.BORDER);
		lblSelectedProj.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		lblSelectedProj.setText(selectedProjectSpace.getProjectName());

		Label lbl3 = new Label(contents, SWT.NONE);
		lbl3.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lbl3.setText("Compare to:");

		listViewer = new ListViewer(contents, SWT.SINGLE);
		listViewer.getList().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		listViewer.setContentProvider(new IStructuredContentProvider() {
			public Object[] getElements(Object inputElement) {
				List<ProjectSpace> projectSpaces = WorkspaceManager.getInstance().getCurrentWorkspace()
					.getProjectSpaces();
				return projectSpaces.toArray();
			}

			public void dispose() {
			}

			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}
		});

		listViewer.setLabelProvider(new LabelProvider() {

			@Override
			public String getText(Object element) {
				// TODO Auto-generated method stub
				return ((ProjectSpace) element).getProjectName();
			}

		});
		listViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				ProjectSpace secondProjectSpace = (ProjectSpace) (((StructuredSelection) event.getSelection())
					.getFirstElement());
				if (secondProjectSpace.equals(selectedProjectSpace)) {
					CompareProjectsDialog.this.setErrorMessage("Selected projects must be different");
					CompareProjectsDialog.this.getButton(CompareProjectsDialog.OK).setEnabled(false);
				} else {
					CompareProjectsDialog.this.setErrorMessage(null);
					CompareProjectsDialog.this.getButton(CompareProjectsDialog.OK).setEnabled(true);
				}
			}
		});
		listViewer.setInput(new Object());

		this.setTitle("Select a project from list to compare");
		return contents;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	@Override
	protected void okPressed() {

		ProjectSpace secondProjectSpace = (ProjectSpace) (((StructuredSelection) listViewer.getSelection())
			.getFirstElement());
		boolean areEqual = ModelUtil.areEqual(selectedProjectSpace.getProject(), secondProjectSpace.getProject());
		String message;
		if (areEqual) {
			message = "The projects are identical.";
		} else {
			message = "The projects are NOT identical!";
		}

		MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), null, message);

		super.okPressed();
	}

	/**
	 * Constructor.
	 * 
	 * @param parentShell the parent shell
	 * @param selectedProjectSpace the selected project space
	 */
	public CompareProjectsDialog(Shell parentShell, ProjectSpace selectedProjectSpace) {
		super(parentShell);
		this.setShellStyle(this.getShellStyle() | SWT.RESIZE);
		this.selectedProjectSpace = selectedProjectSpace;

	}

}
