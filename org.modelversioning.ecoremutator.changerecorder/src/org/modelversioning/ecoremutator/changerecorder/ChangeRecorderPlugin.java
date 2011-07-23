/**
 * <copyright>
 *
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * </copyright>
 */
package org.modelversioning.ecoremutator.changerecorder;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle. This class also manages
 * the recordings of {@link EditingDomain EditingDomains}.
 */
public class ChangeRecorderPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.modelversioning.ecoremutator.changerecorder"; //$NON-NLS-1$

	// The shared instance
	private static ChangeRecorderPlugin plugin;

	/** Saves the current recordings. */
	private Map<EditingDomain, ChangeRecorder> currentRecordings = new HashMap<EditingDomain, ChangeRecorder>();

	/**
	 * The constructor
	 */
	public ChangeRecorderPlugin() {
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static ChangeRecorderPlugin getDefault() {
		return plugin;
	}

	/**
	 * Specifies whether the specified <code>editingDomain</code> is currently
	 * recorded.
	 * 
	 * @param editingDomain
	 *            the {@link EditingDomain} in question.
	 * @return <code>true</code> if currently recording, otherwise
	 *         <code>false</code>.
	 */
	public boolean isRecording(EditingDomain editingDomain) {
		if (currentRecordings.containsKey(editingDomain)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Starts recording the specified <code>editingDomain</code>.
	 * 
	 * @param editingDomain
	 *            to record.
	 */
	public void startRecording(EditingDomain editingDomain) {
		ChangeRecorder recorder = new ChangeRecorder(
				editingDomain.getResourceSet());
		this.currentRecordings.put(editingDomain, recorder);
	}

	/**
	 * Ends recording the specified <code>editingDomain</code>.
	 * 
	 * @param editingDomain
	 *            to stop recording.
	 */
	public void stopRecording(EditingDomain editingDomain) {
		if (currentRecordings.containsKey(editingDomain)) {
			ChangeRecorder recorder = currentRecordings.get(editingDomain);
			final ChangeDescription changeDescription = recorder.endRecording();

			boolean redo = MessageDialog.openQuestion(this.getWorkbench()
					.getActiveWorkbenchWindow().getShell(), "Restore Model?",
					"Do you want to restore the model state before the "
							+ "recorded changes have been performed?");
			
			changeDescription.applyAndReverse();
			saveChangeDescription(changeDescription, editingDomain);

			// redo changes if user said so
			if (!redo) {
				changeDescription.applyAndReverse();
			}

			// clean up recordings map
			currentRecordings.remove(editingDomain);
		}
	}

	/**
	 * Queries the user for a file location and saves the specified
	 * <code>changeDescription</code> to that location.
	 * 
	 * @param changeDescription
	 *            to save.
	 */
	private void saveChangeDescription(ChangeDescription changeDescription,
			EditingDomain editingDomain) {
		SaveAsDialog saveAsDialog = new SaveAsDialog(this.getWorkbench()
				.getActiveWorkbenchWindow().getShell()) {
			@Override
			protected Control createContents(Composite parent) {
				Control contents2 = super.createContents(parent);
				setTitle("Save Change Description");
				setMessage("Select a file to save the change description.");
				return contents2;
			}
		};

		// get path of recorded file.
		Resource firstRecordedResource = editingDomain.getResourceSet()
				.getResources().get(0);
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		Path changeFilePath = new Path(firstRecordedResource.getURI()
				.toPlatformString(true));
		IFile firstRecordedFile = workspaceRoot.getFile(changeFilePath);

		// suggest file next to the recorded file
		IFile changeDescFile = firstRecordedFile.getParent().getFile(
				new Path(firstRecordedFile.getName() + "." //$NON-NLS-1$
						+ "changedescription")); //$NON-NLS-1$

		// open save as dialog
		saveAsDialog.setOriginalFile(changeDescFile);
		saveAsDialog.open();
		IPath path = saveAsDialog.getResult();
		if (path != null) {
			IFile file = workspaceRoot.getFile(path);
			if (file != null) {
				ResourceSet resourceSet = new ResourceSetImpl();
				Resource conflictReportResource = resourceSet
						.createResource(URI.createPlatformResourceURI(file
								.getFullPath().toString(), true));
				conflictReportResource.getContents().add(changeDescription);
				try {
					conflictReportResource.save(Collections.emptyMap());
				} catch (IOException e) {
					IStatus status = new Status(IStatus.ERROR, PLUGIN_ID,
							"Error while saving change description", e);
					this.getLog().log(status);
				}
			}
		}
	}

}
