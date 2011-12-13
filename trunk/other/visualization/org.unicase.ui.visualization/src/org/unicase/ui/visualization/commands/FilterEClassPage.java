package org.unicase.ui.visualization.commands;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
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
import org.unicase.ui.unicasecommon.navigator.wizards.ModelClassFilter;
import org.unicase.ui.unicasecommon.navigator.wizards.ModelTreeContentProvider;

/**
 * 
 * @author Julian Sommerfeldt
 *
 */
public class FilterEClassPage extends WizardPage implements Listener {

	private TreeViewer treeViewer;
	private static final String PAGE_TITLE = "Filter for model element types";
	private static final String PAGE_DESCRIPTION = "Select model element types";

	protected FilterEClassPage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
	}

	public void createControl(Composite parent) {

		Composite composite = new Composite(parent, SWT.NULL);

		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).applyTo(composite);

		Label filterLabel = new Label(composite, SWT.LEFT);
		filterLabel.setText("Search:");
		final Text filterInput = new Text(composite, SWT.SEARCH);
		filterInput.setMessage("Model Element class");
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(filterInput);
		Tree tree = new Tree(composite, SWT.MULTI);
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
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(2, 1).applyTo(treeViewer.getControl());
		treeViewer.setContentProvider(new ModelTreeContentProvider());
		treeViewer.setLabelProvider(new MEClassLabelProvider());
		treeViewer.addFilter(filter);
		treeViewer.setInput(new Object());
		treeViewer.getTree().addListener(SWT.Selection, this);
		
		setControl(composite);
	}

	@Override
	public boolean canFlipToNextPage() {
		return false;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private boolean checkSelection() {

		FilterEClassTypeWizard wizard = (FilterEClassTypeWizard) getWizard();
		boolean canFinish = false;
		ISelection sel = treeViewer.getSelection();
		
		if (sel == null || !(sel instanceof IStructuredSelection)) {
			canFinish = false;
		}

		IStructuredSelection ssel = (IStructuredSelection) sel;
		if (ssel.isEmpty()) {
			canFinish = false;
		}
		
		List list = ssel.toList();
		canFinish = true;
		for (Object o : list) {
			if(!(o instanceof EClass)) canFinish = false;
		}
		
		if (canFinish) {			
			wizard.setEClassTypes(list);
			wizard.setTreePageCompleted(true);
			return true;
		} else {
			wizard.setEClassTypes(null);
			wizard.setTreePageCompleted(false);
			return false;
		}
	}

	public void handleEvent(Event event) {
		checkSelection();
		getWizard().getContainer().updateButtons();
	}
}
