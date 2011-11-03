/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.urml.stakeholders.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
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

	private static final String FILTER_SET = "Elements shown in navigator";
	private static final String REVIEW_SET = "Elements shown in review view";
	private Composite composite;
	private StakeholderRole stakeholderRole;
	private String dialogName, dialogMessage;
	private Text roleName;
	private Collection<Button> buttons;
	private ArrayList<Button> reviewSetElements, filterSetElements;
	private EMap<EClass, EList<EStructuralFeature>> reviewSet;
	private EMap<EClass, EList<EStructuralFeature>> filterSet;
	private HashMap<Button, EClass> buttonClassMapping;
	// private HashMap<EClass, EStructuralFeature> reviewMapping, filterMapping;
	private BasicEMap<EClass, EList<EStructuralFeature>> reviewSetCopy;
	private BasicEMap<EClass, EList<EStructuralFeature>> filterSetCopy;

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

		createSetCopies();

		Set<EClass> subClasses = ModelUtil.getSubclasses(UrmlPackage.eINSTANCE.getUrmlModelElement());
		// List<EClass> reviewClassNames = new ArrayList<EClass>();
		// for (Entry<EClass, EList<EStructuralFeature>> entry : stakeholderRole.getReviewSet()) {
		// reviewClassNames.add(entry.getKey());
		// }
		// List<EClass> filterClassNames = new ArrayList<EClass>();
		// for (Entry<EClass, EList<EStructuralFeature>> entry : stakeholderRole.getFilterSet()) {
		// filterClassNames.add(entry.getKey());
		// }

		createNameLabel();
		buttonClassMapping = new HashMap<Button, EClass>();
		reviewSetElements = createButtonGroup(subClasses, composite, REVIEW_SET, reviewSetCopy);
		filterSetElements = createButtonGroup(subClasses, composite, FILTER_SET, filterSetCopy);
		return composite;
	}

	private void createSetCopies() {
		reviewSetCopy = new BasicEMap<EClass, EList<EStructuralFeature>>();
		copyMap(stakeholderRole.getReviewSet(),reviewSetCopy);
		filterSetCopy = new BasicEMap<EClass, EList<EStructuralFeature>>();
		copyMap(stakeholderRole.getFilterSet(),filterSetCopy);
	}

	private void copyMap(EMap<EClass, EList<EStructuralFeature>> from,
		BasicEMap<EClass, EList<EStructuralFeature>> to) {
		for(Entry<EClass, EList<EStructuralFeature>> entry : from){
			to.put(entry.getKey(), entry.getValue());
		}
		
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
		filterSet = stakeholderRole.getFilterSet();
		reviewSet = stakeholderRole.getReviewSet();
		for (Button b : reviewSetElements) {
			if (b.getSelection()) {
				EClass buttonClass = buttonClassMapping.get(b);
				EList<EStructuralFeature> test = reviewSetCopy.get(buttonClass);
				if (test != null) {
					reviewSet.put(buttonClass, test);
				} else {
					reviewSet.put(buttonClass, new BasicEList<EStructuralFeature>());
				}
			}
		}
		for (Button b : filterSetElements) {
			if (b.getSelection()) {
				EClass buttonClass = buttonClassMapping.get(b);
				EList<EStructuralFeature> test = filterSetCopy.get(buttonClass);
				if (test != null) {
					filterSet.put(buttonClass, test);
				} else {
					filterSet.put(buttonClass, new BasicEList<EStructuralFeature>());
				}
			}
		}
	}

	private void setTitleAndMessage(String dialogName, String dialogMessage) {
		setTitle(dialogName);
		setMessage(dialogMessage);
	}

	private ArrayList<Button> createButtonGroup(Set<EClass> subClasses, Composite composite, final String setName,
		final EMap<EClass, EList<EStructuralFeature>> set) {
		Group group = groupSetUp(composite, setName);

		buttons = new ArrayList<Button>();
		
		List<EClass> subClassesSorted = new ArrayList<EClass>();
		subClassesSorted.addAll(subClasses);
		Collections.sort(subClassesSorted, new Comparator<EClass>() {
			@Override
			public int compare(EClass o1, EClass o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		// Create a button for each of the classes
		for (final EClass eSubClass : subClassesSorted) {

			// Create the button
			final Button button = new Button(group, SWT.CHECK);
			button.setLayoutData(new GridData());
			buttons.add(button);

			// Create the text for the buttons
			final Link link = new Link(group, SWT.WRAP);
			String elementName = eSubClass.getName();
			link.setText(elementName);

			// Add the button class pair to the mapping, so that
			// we can get the class of a button later on
			buttonClassMapping.put(button, eSubClass);

			if (set.containsKey(eSubClass)) {
				button.setSelection(true);
			}
			link.setText("<a>" + eSubClass.getName() + "</a> ");
			link.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent ev) {
					EList<EStructuralFeature> refenceList = null;
					if (!set.containsKey(eSubClass)) {
						set.put(eSubClass, new BasicEList<EStructuralFeature>());
						button.setSelection(true);
					}
					refenceList = set.get(eSubClass);

					if (setName.equals(REVIEW_SET)) {
						SelectPropertiesDialog referenceDialog = new SelectPropertiesDialog(button.getShell(), eSubClass,
							true, refenceList);
						referenceDialog.setBlockOnOpen(true);
						referenceDialog.open();
					}
					if (setName.equals(FILTER_SET)) {
						SelectPropertiesDialog referenceDialogFilterSet = new SelectPropertiesDialog(button.getShell(),
							eSubClass, false, refenceList);
						referenceDialogFilterSet.setBlockOnOpen(true);
						referenceDialogFilterSet.open();
					}

				}

			});

		}
		return (ArrayList<Button>) buttons;
	}

	private Group groupSetUp(Composite composite, String setName) {
		Group group = new Group(composite, SWT.HORIZONTAL);
		group.setLayoutData(new GridData(SWT.BEGINNING, SWT.DEFAULT, false, false));
		group.setText(setName);
		group.setLayout(new GridLayout(6, false));
		return group;
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
