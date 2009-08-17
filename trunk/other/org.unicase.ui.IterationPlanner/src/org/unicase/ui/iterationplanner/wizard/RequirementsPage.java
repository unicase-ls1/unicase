/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.iterationplanner.wizard;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.ui.common.TreeViewerColumnSorter;
import org.unicase.ui.iterationplanner.core.IterationPlannerManager;
import org.unicase.workspace.WorkspaceManager;

import java.util.ArrayList;
import java.util.List;

/**
 * In this page we can select requirements which should be implemented in this
 * sprint.
 * 
 * @author hodaie
 */
public class RequirementsPage extends WizardPage {

	/**
	 * @author Hodaie
	 */
	private final class TreeContentProvider implements ITreeContentProvider {
		@SuppressWarnings("unchecked")
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof List) {
				return ((List) inputElement).toArray();
			}
			return new Object[0];
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof FunctionalRequirement) {
				return ((FunctionalRequirement) parentElement)
						.getRefiningRequirements().toArray();
			}
			return null;
		}

		public Object getParent(Object element) {
			if (element instanceof FunctionalRequirement) {
				((FunctionalRequirement) element).getRefinedRequirement();
			}
			return null;
		}

		public boolean hasChildren(Object element) {
			if (element instanceof FunctionalRequirement) {
				return ((FunctionalRequirement) element)
						.getRefiningRequirements().size() > 0;
			}
			return false;
		}
	}

	private IterationPlannerManager iterationPlanner;
	private CheckboxTreeViewer treeViewer;

	/**
	 * Constructor.
	 * 
	 * @param planner
	 *            iteration planner
	 */
	RequirementsPage(IterationPlannerManager planner) {
		super("requirements page");
		this.iterationPlanner = planner;

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite contents = new Composite(parent, SWT.NONE);
		contents.setLayout(new GridLayout());

		Label lblReq = new Label(contents, SWT.NONE);
		lblReq.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false));
		lblReq
				.setText("Select functional requirements which should be implemented in this sprint:");

		Label label = new Label(contents, SWT.NONE);
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false));

		treeViewer = new CheckboxTreeViewer(contents, SWT.BORDER
				| SWT.FULL_SELECTION);
		treeViewer.getTree().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));
		treeViewer.getTree().setHeaderVisible(true);

		treeViewer.addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				if (event.getChecked()) {
					treeViewer.setSubtreeChecked(event.getElement(), true);

				} else {
					treeViewer.setSubtreeChecked(event.getElement(), false);
				}
				RequirementsPage.this.getWizard().getContainer()
						.updateButtons();
			}
		});

		TreeViewerColumn clmFR = new TreeViewerColumn(treeViewer, SWT.NONE);
		clmFR.getColumn().setText("Functional Requirement");
		clmFR.getColumn().setWidth(300);
		clmFR.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				if (element instanceof FunctionalRequirement) {
					return ((FunctionalRequirement) element).getName();
				}
				return super.getText(element);
			}

		});

		TreeViewerColumn clmPriority = new TreeViewerColumn(treeViewer,
				SWT.NONE);
		clmPriority.getColumn().setText("Priority");
		clmPriority.getColumn().setWidth(100);
		ColumnLabelProvider priorityLabelProvider = new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				if (element instanceof FunctionalRequirement) {
					return ((FunctionalRequirement) element).getPriority() + "";
				}
				return super.getText(element);
			}

		};
		clmPriority.setLabelProvider(priorityLabelProvider);
		TreeViewerColumnSorter sorter = new TreeViewerColumnSorter(treeViewer,
				clmPriority, priorityLabelProvider);
		treeViewer.setComparator(sorter);

		treeViewer.setContentProvider(new TreeContentProvider());
		treeViewer.setInput(getFirsLevelFunctionalRequirments());

		setControl(contents);
		setPageComplete(true);
	}

	/**
	 * @return
	 */
	private List<FunctionalRequirement> getFirsLevelFunctionalRequirments() {
		List<FunctionalRequirement> result = new ArrayList<FunctionalRequirement>();
		List<FunctionalRequirement> allFRs = WorkspaceManager
				.getInstance()
				.getCurrentWorkspace()
				.getActiveProjectSpace()
				.getProject()
				.getAllModelElementsbyClass(
						RequirementPackage.eINSTANCE.getFunctionalRequirement(),
						new BasicEList<FunctionalRequirement>());

		for (FunctionalRequirement fr : allFRs) {
			if (fr.getRefinedRequirement() == null) {
				result.add(fr);
			}
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
	 */
	@Override
	public IWizardPage getNextPage() {
		List<FunctionalRequirement> reqs = new ArrayList<FunctionalRequirement>();
		for (Object obj : treeViewer.getCheckedElements()) {
			reqs.add((FunctionalRequirement) obj);
		}
		iterationPlanner.getTaskProvider().setRequirements(reqs);
		return super.getNextPage();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
	 */
	@Override
	public boolean canFlipToNextPage() {
		return treeViewer.getCheckedElements().length > 0;
	}

}
