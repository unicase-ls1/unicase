/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.common.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * ECP preferences root node.
 * 
 * @author Hodaie
 */
public class ECPPreferencesPage extends PreferencePage implements IWorkbenchPreferencePage {

	/**
	 * Default constructor.
	 */
	public ECPPreferencesPage() {
	}

	/**
	 * Constructor.
	 * 
	 * @param title title
	 */
	public ECPPreferencesPage(String title) {
		super(title);
	}

	/**
	 * Constructor.
	 * 
	 * @param title title
	 * @param image image
	 */
	public ECPPreferencesPage(String title, ImageDescriptor image) {
		super(title, image);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createContents(Composite parent) {
		parent.setLayout(new GridLayout());
		Composite content = new Composite(parent, SWT.NONE);
		content.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		content.setLayout(new GridLayout());

		Label label = new Label(content, SWT.WRAP);
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label.setText("Unicase Preferences");

		return content;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {

	}

}
