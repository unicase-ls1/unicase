/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.ui.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.unicase.emfstore.jdt.ui.PreferenceManager;

/**
 * This page is displayed in the configuration dialog. It adds a new item to the list. The layout and functionality of
 * that page is defined by this class.
 * 
 * @author Adrian Staudt
 */
public class FileExtensionPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	/**
	 * The list that displays the current supported extensions.
	 */
	private List extensionList;

	/**
	 * The newEntryText is the text where new extensions are specified.
	 */
	private Text newEntryText;

	/**
	 * Constructor.
	 */
	public FileExtensionPreferencePage() {
	}

	/**
	 * Constructor.
	 * 
	 * @param title The title.
	 */
	public FileExtensionPreferencePage(String title) {
		super(title);
	}

	/**
	 * Constructor.
	 * 
	 * @param title The title.
	 * @param image The image descriptor.
	 */
	public FileExtensionPreferencePage(String title, ImageDescriptor image) {
		super(title, image);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createContents(Composite parent) {
		Label labeTitle = new Label(parent, SWT.NONE);
		labeTitle.setText("Enabled Extensions");

		Composite entryTable = new Composite(parent, SWT.NULL);

		// Create a data that takes up the extra space in the dialog .
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.grabExcessHorizontalSpace = true;
		entryTable.setLayoutData(data);

		GridLayout layout = new GridLayout();
		entryTable.setLayout(layout);

		extensionList = new List(entryTable, SWT.BORDER);
		extensionList.setItems(PreferenceManager.getExtensionPreference());

		// Create a data that takes up the extra space in the dialog and spans both columns.
		data = new GridData(GridData.FILL_BOTH);
		extensionList.setLayoutData(data);

		Composite buttonComposite = new Composite(entryTable, SWT.NULL);

		GridLayout buttonLayout = new GridLayout();
		buttonLayout.numColumns = 2;
		buttonComposite.setLayout(buttonLayout);

		// Create a data that takes up the extra space in the dialog and spans both columns.
		data = new GridData(GridData.FILL_BOTH | GridData.VERTICAL_ALIGN_BEGINNING);
		buttonComposite.setLayoutData(data);

		Button addButton = new Button(buttonComposite, SWT.PUSH | SWT.CENTER);

		addButton.setText("Add to List"); //$NON-NLS-1$
		addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				extensionList.add(newEntryText.getText(), extensionList.getItemCount());
			}
		});

		newEntryText = new Text(buttonComposite, SWT.BORDER);
		// Create a data that takes up the extra space in the dialog .
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.grabExcessHorizontalSpace = true;
		newEntryText.setLayoutData(data);

		Button removeButton = new Button(buttonComposite, SWT.PUSH | SWT.CENTER);

		removeButton.setText("Remove Selection"); //$NON-NLS-1$
		removeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				if (extensionList.getSelectionIndex() == -1) {
					// no item selected, but button pressed.
					return;
				}

				extensionList.remove(extensionList.getSelectionIndex());
			}
		});

		data = new GridData();
		data.horizontalSpan = 2;
		removeButton.setLayoutData(data);

		return entryTable;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
		// Initialize the preference store we wish to use
		setPreferenceStore(PreferenceManager.getPreferenceStore());
	}

	/**
	 * Performs special processing when this page's restore defaults button has been pressed. Sets the extension content
	 * field to be the default.
	 */
	@Override
	protected void performDefaults() {
		extensionList.setItems(PreferenceManager.getDefaultExtensionPreference());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#performOk()
	 */
	@Override
	public boolean performOk() {
		// Saves the extension content to the preference store.
		PreferenceManager.setExtensionPreference(extensionList.getItems());
		return super.performOk();
	}
}
