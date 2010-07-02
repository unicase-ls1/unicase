/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.navigator.wizards;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.unicase.ui.common.MEClassLabelProvider;

/**
 * @author Hodaie This is the first page of NewModelElementWizard. On this page the model packages and their class (only
 *         those who inherit ModelElement and are not abstract) are shown in a TreeViewer. If user selects a class in
 *         this tree, the wizard can finish.
 */
public class ModelTreePage extends WizardPage implements Listener {

	private TreeViewer treeViewer;
	private static final String PAGE_TITLE = "Add new model element";
	private static final String PAGE_DESCRIPTION = "Select model element type";

	/**
	 * Constructor.
	 * 
	 * @param pageName page name
	 */
	protected ModelTreePage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);

	}

	/**
	 * {@inheritDoc}
	 */
	public void createControl(Composite parent) {

		Composite composite = new Composite(parent, SWT.NULL);

		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).applyTo(composite);

		Label filterLabel = new Label(composite, SWT.LEFT);
		filterLabel.setText("Search:");
		final Text filterInput = new Text(composite, SWT.SEARCH);
		filterInput.setMessage("Model Element class");
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(filterInput);
		Tree tree = new Tree(composite, SWT.SINGLE);
		final ModelClassFilter filter = new ModelClassFilter();
		filterInput.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				String text = filterInput.getText();
				filter.setSearchTerm(text);
				treeViewer.expandAll();
				if (text != null && text.length() == 0) {
					treeViewer.collapseAll();
				}
				treeViewer.refresh();
			}
		});

		treeViewer = new TreeViewer(tree);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(2, 1).applyTo(
			treeViewer.getControl());
		treeViewer.setContentProvider(new ModelTreeContentProvider());
		treeViewer.setLabelProvider(new MEClassLabelProvider());
		treeViewer.addFilter(filter);
		// give an empty object, otherwise it does not initialize
		treeViewer.setInput(new Object());
		treeViewer.getTree().addListener(SWT.Selection, this);
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				if (getWizard().canFinish()) {
					getWizard().performFinish();
					getWizard().getContainer().getShell().close();
				}

			}

		});

		setControl(composite);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canFlipToNextPage() {

		return false;

	}

	/**
	 * Check if tree selection is a ME and wizard can complete. This Method sets the newMEType and treeCompleted fields
	 * in NewModelElementWizard
	 * 
	 * @return
	 */
	private boolean checkSelection() {

		NewModelElementWizard wizard = (NewModelElementWizard) getWizard();
		boolean canFinish = false;
		ISelection sel = treeViewer.getSelection();
		if (sel == null) {
			canFinish = false;
		}

		if (!(sel instanceof IStructuredSelection)) {
			canFinish = false;
		}

		IStructuredSelection ssel = (IStructuredSelection) sel;
		if (ssel.isEmpty()) {
			canFinish = false;
		}
		Object o = ssel.getFirstElement();
		if (o instanceof EClass) {
			canFinish = true;
		}

		else {
			canFinish = false;
		}

		// if (o instanceof MEDiagram) {
		// wizard.setNewMEType(((MEDiagram) o).eClass());
		// wizard.setNewDiagramType(((MEDiagram) o).getType());
		// wizard.setTreePageCompleted(true);
		// return true;
		// }
		if (canFinish) {
			EClass newMEType = (EClass) o;
			wizard.setNewMEType(newMEType);
			wizard.setTreePageCompleted(true);
			return true;
		} else {
			wizard.setNewMEType(null);
			wizard.setTreePageCompleted(false);
			return false;
		}

	}

	/**
	 * {@inheritDoc} On selection change in TreeViewer updates wizard buttons accordingly.
	 */
	public void handleEvent(Event event) {

		checkSelection();
		getWizard().getContainer().updateButtons();

	}

}
