package org.unicase.ui.navigator.wizards;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.unicase.workspace.WorkspaceManager;

/**
 * 
 * @author Hodaie This is the first page of NewModelElementWizard. On this page
 *         the model packages and their class (only those who inherit
 *         ModelElement and are not abstract) are shown in a TreeViewer. If user
 *         selects a class in this tree, the wizard can finish.
 * 
 */
public class ModelTreePage extends WizardPage implements Listener {

	private TreeViewer treeViewer;
	private static final String PAGE_TITLE = "Add new model element";
	private static final String PAGE_DESCRIPTION = "Select model element type";

	/**
	 * . Constructor
	 * 
	 * @param pageName
	 *            page name
	 */
	protected ModelTreePage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);

	}

	/**
	 * . ({@inheritDoc})
	 */
	public void createControl(Composite parent) {

		Composite composite = new Composite(parent, SWT.NULL);

		GridLayout gl = new GridLayout();
		gl.numColumns = 4;
		composite.setLayout(gl);

		// TODO: treeViewer must be initialized with a SWT Tree to prevent multi
		// selection.
		treeViewer = new TreeViewer(composite);
		treeViewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
		treeViewer.setContentProvider(new ModelTreeContentProvider());
		treeViewer.setLabelProvider(new ModelTreeLabelProvider());
		treeViewer.setInput(WorkspaceManager.getInstance()
				.getCurrentWorkspace());
		treeViewer.getTree().addListener(SWT.Selection, this);

		setControl(composite);

	}

	/**
	 * . ({@inheritDoc}
	 */
	@Override
	public boolean canFlipToNextPage() {

		return false;

	}

	/**
	 * Check if tree selection is a ME and wizard can complete. This Method sets
	 * the newMEType and treeCompleted fields in NewModelElementWizard
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
		} else {
			canFinish = false;
		}

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
	 * . ({@inheritDoc} On selection change in TreeViewer updates wizard buttons
	 * accordingly
	 */
	public void handleEvent(Event event) {

		checkSelection();
		getWizard().getContainer().updateButtons();

	}

}
