/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.dialogs.admin.acimport;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolFactory;
import org.unicase.ui.util.DialogHandler;
import org.unicase.ui.util.PreferenceHelper;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * @author gurcankarakoc, deser
 */

public class CSVImportSource extends ImportSource {

	private static final String CSV_IMPORT_SOURCE_PATH = "org.unicase.workspace.ui.CSVImportSourcePath";

	private HashMap<String, ImportItemWrapper> groupMap = new HashMap<String, ImportItemWrapper>();

	private ArrayList<ImportItemWrapper> groups;
	private ArrayList<ImportItemWrapper> users;

	private String absFileName;

	/**
	 * Constructor.
	 */
	public CSVImportSource() {
	}

	/**
	 * @see org.unicase.workspace.ui.views.emfstorebrowser.dialogs.admin.acimport.ImportSource#getChildren(java.lang.Object)
	 * @param ob
	 *            the object to get the children from
	 * @return the children of the given object
	 */
	@Override
	public Object[] getChildren(Object ob) {
		ImportItemWrapper importWrapper = (ImportItemWrapper) ob;
		if (importWrapper != null && importWrapper.getChildOrgUnits() != null) {
			return importWrapper.getChildOrgUnits().toArray();
		}
		return null;
	}

	/**
	 * @param ob
	 *            The object to get the root elements from
	 * @return The list of groups, which were read from the specified file.
	 * @see org.unicase.workspace.ui.views.emfstorebrowser.dialogs.admin.acimport.ImportSource#getElements(java.lang.Object)
	 */
	@Override
	public Object[] getElements(Object ob) {
		return this.groups.toArray();
	}

	/**
	 * @see org.unicase.workspace.ui.views.emfstorebrowser.dialogs.admin.acimport.ImportSource#getLabel()
	 * @return String label.
	 */
	@Override
	public String getLabel() {
		return "import from CSV file";
	}

	/**
	 * @see org.unicase.workspace.ui.views.emfstorebrowser.dialogs.admin.acimport.ImportSource#init()
	 * @param shell
	 *            the shell, which holds the dialog for file selection
	 * @return if a file was selected and successfully handled
	 */
	@Override
	public boolean init(Shell shell) {
		// clear old data
		groups = new ArrayList<ImportItemWrapper>();
		users = new ArrayList<ImportItemWrapper>();

		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell(), SWT.OPEN);
		dialog.setText("Choose import file");
		String initialPath = PreferenceHelper.getPreference(
				CSV_IMPORT_SOURCE_PATH, System.getProperty("user.home"));
		dialog.setFilterPath(initialPath);
		String fn = dialog.open();
		if (fn == null) {
			return false;
		}

		String fileName = dialog.getFileName();
		String filterPath = dialog.getFilterPath();
		if (fileName == null) {
			return false;
		}

		this.absFileName = filterPath + File.separatorChar + fileName;
		final File file = new File(absFileName);
		PreferenceHelper.setPreference(CSV_IMPORT_SOURCE_PATH, filterPath);
		BufferedReader bufferedReader = null;
		InputStreamReader isr = null;

		try {
			isr = new InputStreamReader(new FileInputStream(file)); // "8859_1","ASCII"
			bufferedReader = new BufferedReader(isr);
			String line = bufferedReader.readLine();

			int indexUserName = 0;
			int indexForGroup = 1;

			int counter = 0;
			while ((line = bufferedReader.readLine()) != null) {
				// Get the user information from the next line
				String[] title = line.split(",");

				String userName = title[indexUserName];
				String groupName = title[indexForGroup];

				ImportItemWrapper importWrapper = null;
				ArrayList<ImportItemWrapper> childOrgUnits;
				if (groupMap.get(groupName) == null) {
					ACGroup group = AccesscontrolFactory.eINSTANCE
							.createACGroup();
					importWrapper = new ImportItemWrapper(null, group);

					group.setName(groupName);
					groups.add(importWrapper);
					groupMap.put(groupName, importWrapper);
					childOrgUnits = new ArrayList<ImportItemWrapper>();
				} else {
					importWrapper = groupMap.get(groupName);
					childOrgUnits = importWrapper.getChildOrgUnits();
				}

				ACUser user = AccesscontrolFactory.eINSTANCE.createACUser();
				user.setName(userName);
				ImportItemWrapper userImportWrapper = new ImportItemWrapper(
						null, user, importWrapper);
				users.add(userImportWrapper);

				childOrgUnits.add(userImportWrapper);
				importWrapper.setChildOrgUnits(childOrgUnits);

				counter++;

			}

			bufferedReader.close();
			isr.close();

		} catch (FileNotFoundException e) {
			WorkspaceUtil.logWarning(e.getMessage(), e);
			DialogHandler.showExceptionDialog("File not found", e);
			return false;
		} catch (IOException e) {
			WorkspaceUtil.logWarning(e.getMessage(), e);
			DialogHandler.showExceptionDialog("An I/O-exception occured", e);
			return false;
		} catch (ArrayIndexOutOfBoundsException e) {
			WorkspaceUtil.logWarning(e.getMessage(), e);
			DialogHandler.showExceptionDialog("ArrayIndexOutOfBoundsException",
					e);
			return false;
		}

		return true;
	}

	/**
	 * @see org.unicase.workspace.ui.views.emfstorebrowser.dialogs.admin.acimport.ImportSource#getMessage()
	 * @return a small message which indicates from which is getting imported
	 */
	@Override
	public String getMessage() {
		return "Importing from file: " + this.absFileName;
	}

	/**
	 * Disposes any created resources.
	 */
	public void dispose() {
		// Nothing to dispose
	}

	/**
	 * Called when the input changes.
	 * 
	 * @param arg0
	 *            the viewer
	 * @param arg1
	 *            the old input
	 * @param arg2
	 *            the new input
	 */
	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
		// Nothing to change
	}
}
