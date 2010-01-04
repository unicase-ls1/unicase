/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.linkrecommendation.wizards;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.IWizardPage;
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
import org.eclipse.swt.widgets.TreeItem;
import org.unicase.ui.common.MEClassLabelProvider;
import org.unicase.ui.unicasecommon.common.ModelTreeContentProvider;
import org.unicase.ui.unicasecommon.navigator.wizards.ModelClassFilter;

/**
 * @author henning femmer
 */
public class TypeSelectionPage extends WizardPage implements Listener {

	private static final String TITLE = "Model Element Type Selection";

	private TreeViewer treeViewer;

	/**
	 * The Constructor.
	 * 
	 * @param description the textual description
	 */
	protected TypeSelectionPage(String description) {
		super(TITLE);
		this.setTitle(TITLE);
		this.setDescription(description);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);

		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).applyTo(composite);

		Label filterLabel = new Label(composite, SWT.LEFT);
		filterLabel.setText("Search:");
		final Text filterInput = new Text(composite, SWT.SEARCH);
		filterInput.setMessage("Model Element class");
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(filterInput);

		Tree tree = new Tree(composite, SWT.MULTI | SWT.CHECK);
		tree.addListener(SWT.Selection, this);
		treeViewer = new TreeViewer(tree);

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

		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(2, 1).applyTo(
			treeViewer.getControl());
		treeViewer.setContentProvider(new ModelTreeContentProvider());
		treeViewer.setLabelProvider(new MEClassLabelProvider());
		treeViewer.addFilter(filter);
		// give an empty object, otherwise it does not initialize
		treeViewer.setInput(new Object());
		setControl(composite);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
	 */
	@Override
	public IWizardPage getNextPage() {
		// determine selected classes
		Set<EClass> classes = new TreeSet<EClass>(new Comparator<EClass>() {
			public int compare(EClass o1, EClass o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

		treeViewer.expandAll();
		for (TreeItem ti : treeViewer.getTree().getItems()) {
			for (TreeItem subitem : ti.getItems()) {
				if (subitem.getChecked() && subitem.getData() != null) {
					Object obj = subitem.getData();
					if (obj instanceof EClass) {
						classes.add((EClass) obj);
					}
				}
			}
		}
		treeViewer.collapseAll();

		if (super.getNextPage() instanceof LinkTypeSelectionPage) {
			LinkTypeSelectionPage page = (LinkTypeSelectionPage) super.getNextPage();
			page.setElements(classes);
			// set the type in the results
			((RecoveryWizard) getWizard()).getResultsPage().setRelevantBaseClasses(classes);
		} else {
			// set the type in the results
			((RecoveryWizard) getWizard()).getResultsPage().setRelevantTargetClasses(classes);
			if (classes.size() > 0) {
				((RecoveryWizard) getWizard()).getResultsPage().calculateSuggestions();
			}
		}

		return super.getNextPage();
	}

	/**
	 * Handles the checking of boxes by passing the value to subelements.
	 * 
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 * @param event the event
	 */
	public void handleEvent(Event event) {
		if (event.detail == SWT.CHECK) {
			TreeItem ti = (TreeItem) event.item;
			treeViewer.setExpandedState(ti, true);
			ti.setExpanded(true);
			treeViewer.refresh();
			for (TreeItem subitem : ti.getItems()) {
				subitem.setChecked(ti.getChecked());
			}

			if (!ti.getChecked()) {
				treeViewer.setExpandedState(ti, false);
				ti.setExpanded(false);
			}
			treeViewer.refresh();
		}
	}

}
