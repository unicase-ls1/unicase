/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.common.preferences;

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
 * Unicase preferences root node.
 * 
 * @author Hodaie
 */
public class UnicasePreferencesPage extends PreferencePage implements IWorkbenchPreferencePage {

	/**
	 * Constructor.
	 */
	public UnicasePreferencesPage() {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param title title
	 */
	public UnicasePreferencesPage(String title) {
		super(title);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param title title
	 * @param image image
	 */
	public UnicasePreferencesPage(String title, ImageDescriptor image) {
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
