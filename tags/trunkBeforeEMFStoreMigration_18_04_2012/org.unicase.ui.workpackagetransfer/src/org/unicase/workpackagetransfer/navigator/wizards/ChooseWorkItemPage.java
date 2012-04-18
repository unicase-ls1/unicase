/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workpackagetransfer.navigator.wizards;

import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.unicase.ecp.model.ECPModelelementContext;
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.ecp.model.NoWorkspaceException;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.util.DialogHandler;
import org.unicase.ui.workpackagetransfer.TreeHandler;

/**
 * @author mkagel Wizard page of the WorkpackageTransferWizard. Contains a checkboxlist of WorkItems to move.
 */
public class ChooseWorkItemPage extends WizardPage {

	// Title and description
	private static final String PAGE_TITLE = "Move WorkItems";
	private static final String PAGE_DESCRIPTION = "Select WorkItems for moving in new Workpackage";
	private static final String BROWSE_BUTTON_TEXT = "Browse Workpackages";
	private static final String CLABEL_INIT_TEXT = ">> Select target Workpackage <<";

	private AdapterFactoryLabelProvider labelProvider;

	private WorkPackage targetWorkPackage;

	private WorkpackageTransferWizard parentWizard;

	// Tree contains WorkItems
	private Tree tree;

	// Button for browsing the WorkPackages
	private Button browseButton;
	private CLabel workPackageLabel;

	private ChooseWorkItemPageListener listener;
	private TreeHandler treeHandler;

	/**
	 * Default Constructor.
	 * 
	 * @param pageName page name, handled by the the super constructor
	 * @param parentWizard the wizard which contains this page
	 */
	protected ChooseWorkItemPage(String pageName, WorkpackageTransferWizard parentWizard) {
		super(pageName);

		this.parentWizard = parentWizard;

		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);

		labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		listener = new ChooseWorkItemPageListener();
		treeHandler = new TreeHandler(labelProvider, parentWizard.getSelectedWorkPackage());
	}

	/**
	 * . ({@inheritDoc})
	 */
	public void createControl(Composite parent) {

		// Composite (Container)
		Composite composite = new Composite(parent, SWT.NULL);

		// Layout managing
		GridLayout gridLayout = new GridLayout(4, false);
		composite.setLayout(gridLayout);

		workPackageLabel = new CLabel(composite, SWT.BORDER);
		workPackageLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		workPackageLabel.setAlignment(SWT.CENTER);
		workPackageLabel.setText(CLABEL_INIT_TEXT);

		browseButton = new Button(composite, SWT.PUSH);
		browseButton.setText(BROWSE_BUTTON_TEXT);
		browseButton.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 2, 1));
		browseButton.addListener(SWT.Selection, listener);

		tree = new Tree(composite, SWT.CHECK | SWT.BORDER);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1));
		tree.addListener(SWT.Selection, listener);

		// Fill Tree with data
		fillTree(tree);

		setControl(composite);
	}

	/**
	 * Returns the selected WorkItems which should be moved.
	 * 
	 * @return List of WorkItems
	 */
	public List<WorkItem> getSelectedWorkItems() {
		return treeHandler.getCheckedWorkItems(tree);
	}

	/**
	 * Returns the target WorkPackage, where the WorkItems should be moved.
	 * 
	 * @return WorkPackage
	 */
	public WorkPackage getTargetWorkPackage() {
		return targetWorkPackage;
	}

	/**
	 * Fills the Tree with Data.
	 * 
	 * @param tree tree Object to fill with data
	 */
	private void fillTree(Tree tree) {
		tree.setRedraw(false);

		treeHandler.createTreeStructure(tree);

		tree.setRedraw(true);
	}

	/**
	 * Listener handling button pressed events and selection events in the table.
	 * 
	 * @author mkagel
	 */
	private class ChooseWorkItemPageListener implements Listener, SelectionListener {

		public void handleEvent(Event event) {
			Widget widget = event.widget;

			if (widget == browseButton) {
				showChooseWorkPackageDialog();
			}

			else if (widget == tree && event.detail == SWT.CHECK) {

				TreeItem treeItem = (TreeItem) event.item;

				manageSelection(treeItem);
			}

		}

		/**
		 * shows the dialog for choosing the target workPackage of the move-operation.
		 */
		private void showChooseWorkPackageDialog() {
			WorkPackage workPackage = parentWizard.getSelectedWorkPackage();
			ECPModelelementContext context;

			try {
				context = ECPWorkspaceManager.getInstance().getWorkSpace().getProject(workPackage);
				ChooseWorkPackagePage dialog = new ChooseWorkPackagePage(context, ModelUtil.getProject(workPackage),
					workPackage);

				if (dialog.open() == Window.OK) {
					Object[] result = dialog.getResult();

					if (result.length == 1) {
						if (result[0] instanceof WorkPackage) {
							targetWorkPackage = (WorkPackage) result[0];

							workPackageLabel.setImage(labelProvider.getImage(targetWorkPackage));
							workPackageLabel.setText(labelProvider.getText(targetWorkPackage));

							parentWizard.setCanFinish(true);
							setPageComplete(true);
						}
					}
				}
			} catch (NoWorkspaceException e) {
				DialogHandler.showExceptionDialog(e);
			}
		}

		/**
		 * Managing the Selection-Event, new checked treeItems have to check their children treeItems and newly
		 * unchecked treeItems have to uncheck their parent and children treeItems.
		 * 
		 * @param treeItem whose checking has been changed
		 */
		private void manageSelection(TreeItem treeItem) {

			if (treeItem.getChecked()) {
				treeHandler.checkTreeItem(treeItem, true);
			} else {
				treeHandler.uncheckTreeItem(treeItem, true, true);
			}
		}

		public void widgetDefaultSelected(SelectionEvent e) {
		}

		public void widgetSelected(SelectionEvent e) {
		}

	}
}
