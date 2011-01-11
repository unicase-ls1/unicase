/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.urml.stakeholderview;

import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.urml.UrmlPackage;

/**
 * Dialog for editing the selected stakeholder role.
 * @author kterzieva
 *
 */
public class EditRoleDialog extends TitleAreaDialog{


	private static final String FILTER_SET = "Filter Set";
	private static final String REVIEW_SET = "Review Set";
	private Composite composite;

	/**
	 * The construct.
	 * @param parentShell the shell
	 */
	public EditRoleDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		
	}

	@Override
	protected void configureShell(Shell parent) {
		super.configureShell(parent);
		//parent.setSize(300, 300);
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("Edit role.");
		setMessage("Edit the role settings");
		
		Set<EClass> subClass = ModelUtil.getSubclasses(UrmlPackage.eINSTANCE.getUrmlModelElement());
		
		
		// Create composite
		 composite = (Composite) super.createDialogArea(parent);
		// Layout stuff
		GridLayout gridLayout = new GridLayout(1, true);
		composite.setLayout(gridLayout);
		composite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		
		

		createButtonGroup(subClass, composite, REVIEW_SET );

		createButtonGroup(subClass, composite, FILTER_SET);

		return composite;
	}

	private void createButtonGroup(Set<EClass> subClass, Composite composite,  String setName) {
		Group group = new Group(composite, SWT.HORIZONTAL);
		group.setLayoutData(new GridData(SWT.BEGINNING, SWT.DEFAULT, false, false));
		group.setText(setName);
		group.setLayout(new GridLayout(3, false));
		group.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

		
		for(EClass e : subClass){
		
			// Buttons
			Button button = new Button(group, SWT.CHECK);
			button.setText(e.getName());
			button.setLayoutData(new GridData());
			button.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
			
		}
	}
	
	@Override
	protected Button createButton(Composite parent, int id, String label, boolean defaultButton) {
		if(id == IDialogConstants.OK_ID){
			label = "SAVE";	
		}
		return super.createButton(parent, id, label, defaultButton);
	}
	
}
