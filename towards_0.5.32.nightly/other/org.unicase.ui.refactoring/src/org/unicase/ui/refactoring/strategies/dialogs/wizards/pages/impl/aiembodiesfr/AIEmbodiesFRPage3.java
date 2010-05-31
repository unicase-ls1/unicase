/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.impl.aiembodiesfr;

import java.util.ArrayList;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.TaskPackage;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.AbstractRefactoringWizard;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.AbstractRefactoringWizardPage;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.text.TextSnippets;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * @author pfeifferc
 */
public class AIEmbodiesFRPage3 extends AbstractRefactoringWizardPage {

	private List listActionItems;

	private ArrayList<ModelElement> actionItems;

	// reusable variables
	private Composite composite;

	/**
	 * The default constructor.
	 * 
	 * @param wizard the
	 * @param pageName the
	 */
	public AIEmbodiesFRPage3(String pageName, AbstractRefactoringWizard wizard) {
		super(pageName, wizard);
		actionItems = getRefactoringWizard().getChildModelElements();
		actionItems.add(getRefactoringWizard().getInvalidModelElement());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		// the body composite to place everything else on
		Composite body = createBodyComposite(parent);
		// create affected model element composite
		createModelElementInformationComposite(body);
		// create information text composite
		createExplanatoryTextComposite(body, TextSnippets.AIEMBODIESFRPAGE3INFORMATION, "information.png");
		// create instruction text composite
		createExplanatoryTextComposite(body, TextSnippets.AIEMBODIESFRPAGE3INSTRUCTION1, "exclamation.png");
		// create the composite to put the widgets on
		composite = createComposite(body, SWT.NONE, new GridLayout(3, false), new GridData(SWT.FILL, SWT.FILL, true,
			true));
		// create add icon
		createIconLabel(composite, "add2.png");
		// create choose action items text
		createText(composite, "Choose action items:");
		// create the composite to put the widgets on
		composite = createComposite(composite, SWT.NONE, new GridLayout(2, false), new GridData(SWT.FILL, SWT.FILL,
			true, true));
		// create list widget
		listActionItems = new List(composite, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		listActionItems.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		// create the composite to put the widgets on
		composite = createComposite(composite, SWT.NONE, new GridLayout(1, false), new GridData(SWT.FILL, SWT.TOP,
			false, false));
		// create add button
		Button add = new Button(composite, SWT.NONE);
		add.setText("Add");
		add.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
		add.addSelectionListener(new AddActionItemSelectionListener());
		// create add button
		Button link = new Button(composite, SWT.NONE);
		link.setText("Link");
		link.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
		link.addSelectionListener(new LinkActionItemSelectionListener());
		// create remove button
		Button remove = new Button(composite, SWT.NONE);
		remove.setText("Remove");
		remove.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
		remove.addSelectionListener(new RemoveActionItemSelectionListener());
		// set body as control
		setControl(body);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.unicasecommon.refactoringstrategies.dialogs.wizards.pages.AbstractRefactoringWizardPage#pageSelected()
	 */
	@Override
	public void pageSelected() {
		updateTable();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
	 */
	@Override
	public IWizardPage getNextPage() {
		if (getRefactoringWizard().getChildModelElements().size() == 0) {
			return getRefactoringWizard().getNextPage(this).getNextPage();
		}
		return super.getNextPage();
	}

	private void updateTable() {
		String[] strings = new String[actionItems.size()];
		int i = 0;
		for (ModelElement item : actionItems) {
			strings[i++] = ((ActionItem) item).getName();
		}
		listActionItems.setItems(strings);
	}

	/**
	 * @author pfeifferc
	 */
	private final class AddActionItemSelectionListener implements SelectionListener {

		public void widgetSelected(SelectionEvent e) {
			final InputDialog inputDialog = new InputDialog(getShell(), "Choose name for new AI",
				"Choose name for new AI", "", null);
			inputDialog.open();
			if (inputDialog.getReturnCode() == Status.OK) {
				final ActionItem actionItem = TaskFactory.eINSTANCE.createActionItem();
				getRefactoringWizard().addModelElement(actionItem);
				getRefactoringWizard().getChildModelElementsCreated().add(actionItem);
				actionItems.add(actionItem);
				new UnicaseCommand() {

					@Override
					protected void doRun() {
						actionItem.setName(inputDialog.getValue());
						actionItem.setDescription(inputDialog.getValue());
					}
				}.run();
			}
			updateTable();
		}

		public void widgetDefaultSelected(SelectionEvent e) {
			// nothing to do here
		}
	}

	/**
	 * @author pfeifferc
	 */
	private final class RemoveActionItemSelectionListener implements SelectionListener {

		public void widgetSelected(SelectionEvent e) {
			final int index = listActionItems.getSelectionIndex();
			if (index >= 0 && index < actionItems.size()) {
				new UnicaseCommand() {

					@Override
					protected void doRun() {
						if (getRefactoringWizard().getChildModelElementsCreated().contains(actionItems.get(index))) {
							actionItems.get(index).delete();
							getRefactoringWizard().getChildModelElementsCreated().remove(actionItems.get(index));
						}
						actionItems.remove(index);
					}
				}.run();
			}
			updateTable();
		}

		public void widgetDefaultSelected(SelectionEvent e) {
			// nothing to do here
		}
	}

	/**
	 * @author pfeifferc
	 */
	private final class LinkActionItemSelectionListener implements SelectionListener {

		public void widgetSelected(SelectionEvent e) {
			AdapterFactoryLabelProvider provider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
			ElementListSelectionDialog dialog = new ElementListSelectionDialog(getShell(), provider);
			Project project = WorkspaceManager.getProjectSpace(getRefactoringWizard().getInvalidModelElement())
				.getProject();
			EList<ActionItem> projectActionItems = project.getAllModelElementsbyClass(TaskPackage.eINSTANCE
				.getActionItem(), new BasicEList<ActionItem>());
			dialog.setElements(projectActionItems.toArray());
			dialog.open();
			if (dialog.getReturnCode() == Status.OK) {
				for (Object object : dialog.getResult()) {
					if (object instanceof ActionItem) {
						if (!actionItems.contains(object)) {
							actionItems.add((ActionItem) object);
						}
					}
				}
			}
			updateTable();
		}

		public void widgetDefaultSelected(SelectionEvent e) {
			// nothing to do here
		}
	}
}