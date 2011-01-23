/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholderview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
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
 * Dialog for selecting the reference elements for the review view.
 * 
 * @author kterzieva
 */
public class SelectReferenceDialog extends TitleDialogWithoutMinSize {

	private String referenceName;
	private EClass eClassName;
	private String displayReferenceName;
	private ArrayList<Button> buttons;
	private HashMap<String, String> mapping;

	/**
	 * The construct.
	 * 
	 * @param parentShell the parent shell
	 * @param eClass the class is used to represent the name of the references shown in this dialog
	 * @param classNameToReferenceMapping list with the name/reference mapping
	 */
	public SelectReferenceDialog(Shell parentShell, EClass eClass, HashMap<String, String> classNameToReferenceMapping) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		this.eClassName = eClass;
		this.mapping = classNameToReferenceMapping;
		referenceName = mapping.get(eClass.getName());
	}

	@Override
	protected void configureShell(Shell parent) {
		super.configureShell(parent);
	}

	@Override
	protected Control createDialogArea(Composite parent) {

		setTitle("Test");
		setMessage("Choose a reference for the review view");
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

		EObject test = eClassName.getEPackage().getEFactoryInstance().create(eClassName);
		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		List<IItemPropertyDescriptor> propertyDescriptors = adapterFactoryItemDelegator.getPropertyDescriptors(test);

		buttons = new ArrayList<Button>();
		
		for (IItemPropertyDescriptor itemDescriptor : propertyDescriptors) {
			final Button b = new Button(group, SWT.RADIO);
			b.setLayoutData(new GridData());
			buttons.add(b);
			String currentName = itemDescriptor.getDisplayName(itemDescriptor);
			b.setText(currentName);
			
			if(referenceName != null && referenceName.equals(b.getText())){
				b.setSelection(true);
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
		Label titleBarSeparator = new Label(wrap, SWT.HORIZONTAL | SWT.SEPARATOR);
		titleBarSeparator.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		return group;
	}

	/**
	 * Writes the input made by the user into the model.
	 * @param displayReferenceName the name of the reference
	 */
	protected void writeReferenceInputToModel(final String displayReferenceName) {
		for (Button b : buttons) {
			if (b.getSelection()) {
				mapping.put(eClassName.getName(), b.getText());
			}
		}
	}

	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == Window.OK) {
			new UnicaseCommand() {
				
				@Override
				protected void doRun() {
					writeReferenceInputToModel(displayReferenceName);					
				}
			}.run();
			
		}
		super.buttonPressed(buttonId);
	}
}
