/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.urml.stakeholderview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.urml.StakeholderRole;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Dialog for editing or adding one stakeholder role.
 * 
 * @author kterzieva
 */
public class EditRoleDialog extends TitleAreaDialog {

	private static final String FILTER_SET = "Filter Set";
	private static final String REVIEW_SET = "Review Set";
	private Composite composite;
	private StakeholderRole stakeholderRole;
	private String dialogName, dialogMessage;
	private Text roleName;
	private Collection<Button> buttons;
	private ArrayList<Button> reviewSetElements, reviewFilterElements;
	private EList<String> reviewSet;
	private EList<String> filterSet;

	/**
	 * The construct.
	 * 
	 * @param parentShell the shell
	 * @param role the stakeholder role
	 * @param dialogName the name of the dialog
	 * @param dialogMessage the dialog message
	 */
	public EditRoleDialog(Shell parentShell, StakeholderRole role, String dialogName, String dialogMessage) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		this.stakeholderRole = role;
		this.dialogName = dialogName;
		this.dialogMessage = dialogMessage;
	}

	@Override
	protected void configureShell(Shell parent) {
		super.configureShell(parent);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		setTitleAndMessage(dialogName, dialogMessage);
		// Create composite
		Composite wrap = (Composite) super.createDialogArea(parent);
		
		composite = new Composite(wrap, SWT.NONE);
		// Layout stuff
		GridLayout gridLayout = new GridLayout(1, true);
		composite.setLayout(gridLayout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		composite.setFont(parent.getFont());
	//	composite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

		createNameLabel();

		Set<EClass> subClass = ModelUtil.getSubclasses(UrmlPackage.eINSTANCE.getUrmlModelElement());
		EList<String> reviewSet = stakeholderRole.getReviewSet();
		EList<String> filterSet = stakeholderRole.getFilterSet();
		reviewSetElements = createButtonGroup(subClass, composite, REVIEW_SET, reviewSet);
		reviewFilterElements = createButtonGroup(subClass, composite, FILTER_SET, filterSet);
		return composite;
	}

	private void createNameLabel() {
		roleName = new Text(composite, SWT.BORDER);
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = SWT.FILL;
		roleName.setLayoutData(gridData);
		roleName.setText(stakeholderRole.getName());
	}

	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == Window.OK) {
			writeInputToModel();
		}
		super.buttonPressed(buttonId);
	}

	/**
	 * Writes the user input to the model.
	 */
	private void writeInputToModel() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				String newRoleName = roleName.getText();
				stakeholderRole.setName(newRoleName);
				stakeholderRole.getReviewSet().clear();
				stakeholderRole.getFilterSet().clear();
				writeInputToSets();
			}
		}.run();

	}

	private void writeInputToSets() {
		for (Button b : reviewSetElements) {
			if (b.getSelection()) {
				reviewSet = stakeholderRole.getReviewSet();
				reviewSet.add(b.getText());
			}
		}
		for (Button b : reviewFilterElements) {
			if (b.getSelection()) {
				if (b.getSelection()) {
					filterSet = stakeholderRole.getFilterSet();
					filterSet.add(b.getText());
				}
			}
		}
	}

	private void setTitleAndMessage(String dialogName, String dialogMessage) {
		setTitle(dialogName);
		setMessage(dialogMessage);
	}

	private ArrayList<Button> createButtonGroup(Set<EClass> subClass, Composite composite, String setName,
		EList<String> set) {
		Group group = new Group(composite, SWT.HORIZONTAL);
		group.setLayoutData(new GridData(SWT.BEGINNING, SWT.DEFAULT, false, false));
		group.setText(setName);
		group.setLayout(new GridLayout(6, false));

		buttons = new ArrayList<Button>();
		for (final EClass e : subClass) {
			final Button button = new Button(group, SWT.CHECK);
			button.setLayoutData(new GridData());
			buttons.add(button);
			final Link l = new Link(group, SWT.WRAP);
			l.setText(e.getName());
			if (set.contains(e.getName())) {
				button.setSelection(true);
			}
			for (EReference reference : e.getEAllReferences()) {
				System.out.println(reference.getName());
			}
			l.setText("<a>" + e.getName() + "</a> ");
			l.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent ev) {
						SelectReferenceDialog referenceDialog = new SelectReferenceDialog(button.getShell(), e
							.getEAllReferences());
						referenceDialog.setBlockOnOpen(true);
						if(referenceDialog.open() == Window.OK){
							new UnicaseCommand() {
								@Override
								protected void doRun() {
									
								}
							}.run();
						}
				}

			});
		}
		return (ArrayList<Button>) buttons;
	}

	@Override
	protected Button createButton(Composite parent, int id, String label, boolean defaultButton) {
		if (id == IDialogConstants.OK_ID) {
			label = "Save";
		}
		Button saveButton = super.createButton(parent, id, label, defaultButton);
		return saveButton;
	}

}
