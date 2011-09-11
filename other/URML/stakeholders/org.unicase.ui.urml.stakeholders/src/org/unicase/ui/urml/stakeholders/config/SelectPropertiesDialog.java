/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Dialog for selecting the model element properties for the review view.
 * 
 * @author kterzieva
 */
public class SelectPropertiesDialog extends TitleDialogWithoutMinSize {

	//private String referenceName;
	private String displayReferenceName;
	private ArrayList<Button> buttons;
	private boolean reviewSet;
	private EList<EStructuralFeature> propertiesList;
	private EClass selectedClass;
	private Map<Button, EStructuralFeature> buttonToFeatureMapping = new HashMap<Button, EStructuralFeature>();

	/**
	 * The construct.
	 * 
	 * @param parentShell the parent shell
	 * @param selectedClass the class is used to represent the name of the references shown in this dialog
	 * @param referenceList list with the name/reference mapping
	 * @param reviewSet
	 * @param reviewSet .
	 */
	//, HashMap<EClass, EStructuralFeature> reviewMapping
	public SelectPropertiesDialog(Shell parentShell, EClass selectedClass, boolean reviewSet, EList<EStructuralFeature> referenceList) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		this.selectedClass = selectedClass;
		this.reviewSet = reviewSet;
		this.propertiesList = referenceList;

	}

	@Override
	protected void configureShell(Shell parent) {
		super.configureShell(parent);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		if (reviewSet) {
			setTitle("Select one reference");
			setMessage("Choose a reference for the review view");
		} else {
			setTitle("Select references");
			setMessage("Choose references for the Unicase Navigator which can be shown in MEEditor");
		}

		// Create composite
		Composite wrap = (Composite) super.createDialogArea(parent);

		Composite composite = new Composite(wrap, SWT.NONE);
		// Layout stuff
		GridLayout gridLayout = new GridLayout(1, false);
		composite.setLayout(gridLayout);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
		composite.setFont(parent.getFont());

		Group group = new Group(composite, SWT.HORIZONTAL);
		group.setLayout(new GridLayout(2, false));
		group.setLayoutData(new GridData(SWT.BEGINNING, SWT.FILL, false, true));
		group.setText("Reference list");

		//create instance of the selected class
		EObject selectedClassInstance = selectedClass.getEPackage().getEFactoryInstance().create(selectedClass);
		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		List<IItemPropertyDescriptor> propertyDescriptors = adapterFactoryItemDelegator.getPropertyDescriptors(selectedClassInstance);

		buttons = new ArrayList<Button>();

		for (IItemPropertyDescriptor itemDescriptor : propertyDescriptors) {
			if (reviewSet) {
				Button b = new Button(group, SWT.RADIO);
				propertiesButtonSetUp(itemDescriptor, b, selectedClassInstance, reviewSet);
			} else {
				Button b = new Button(group, SWT.CHECK);
				propertiesButtonSetUp(itemDescriptor, b, selectedClassInstance, reviewSet);
			}
			
		}
		Label titleBarSeparator = new Label(wrap, SWT.HORIZONTAL | SWT.SEPARATOR);
		titleBarSeparator.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		return group;
	}

	private void propertiesButtonSetUp(IItemPropertyDescriptor itemDescriptor, final Button b, EObject selectedClassInstance, boolean isReviewSet) {
		b.setLayoutData(new GridData());
		buttons.add(b);
		String currentName = itemDescriptor.getDisplayName(itemDescriptor);
		Object feature = itemDescriptor.getFeature(selectedClassInstance);
		buttonToFeatureMapping.put(b, (EStructuralFeature) feature);
		b.setText(currentName);
		
		//read the reference list from model for the button settings
		
		if (propertiesList.contains(feature)) {
			b.setSelection(isReviewSet);
		} else {
			b.setSelection(!isReviewSet);
		}

		b.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				displayReferenceName = b.getText();
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});
	}

	/**
	 * Writes the input made by the user into the model.
	 * 
	 * @param displayReferenceName the name of the reference
	 */
	protected void writePropertiesInputToModel(final String displayReferenceName) {
		propertiesList.clear();
		
		for (Button b : buttons) {
			if(reviewSet){
				if (b.getSelection()) {
					EStructuralFeature feature = buttonToFeatureMapping.get(b);
					propertiesList.add(feature);
				}
			} else {
				if (!b.getSelection()) {
					EStructuralFeature feature = buttonToFeatureMapping.get(b);
					propertiesList.add(feature);
				}	
			}
			
		}
		
	}

	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == Window.OK) {
			new UnicaseCommand() {

				@Override
				protected void doRun() {
					writePropertiesInputToModel(displayReferenceName);
				}
			}.run();

		}
		super.buttonPressed(buttonId);
	}
}
