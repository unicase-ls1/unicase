/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.ui.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;
import org.unicase.emfstore.jdt.ITeamSynchronizer;
import org.unicase.emfstore.jdt.TeamSynchronizerRegistry;
import org.unicase.emfstore.jdt.configuration.ConfigurationManager;
import org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration;
import org.unicase.emfstore.jdt.configuration.Entry;
import org.unicase.emfstore.jdt.eclipseworkspace.Synchronizer;
import org.unicase.emfstore.jdt.exception.CannotSyncFileException;
import org.unicase.emfstore.jdt.exception.EntryNotFoundException;
import org.unicase.emfstore.jdt.exception.NoEMFStoreJDTConfigurationException;
import org.unicase.emfstore.jdt.exception.NoSuitableTeamSynchronizerException;

/**
 * This class can be used for the EMFStoreJDT editors to decide which editor input should be used. If the requested file
 * is "pushed" the editor input will different than the usual FileEditorInput. The editor input is substantial for the
 * data and the manner how the content will be loaded.
 * 
 * @author Adrian Staudt
 */
public class EditorInputDecider {

	private IEditorInput suitableEditorInput;
	private boolean isSuitableEditorInputEMFStoreCompatible;

	/**
	 * Constructor.
	 * 
	 * @param editorInput the default editor input that is given to an editor
	 */
	public EditorInputDecider(IEditorInput editorInput) {
		this.suitableEditorInput = editorInput;

		if (editorInput instanceof FileEditorInput) {
			FileEditorInput fileEditorInput = (FileEditorInput) editorInput;
			IFile file = fileEditorInput.getFile();

			try {
				EMFStoreJDTConfiguration emfStoreJDTConfiguration = ConfigurationManager.getConfiguration(file
					.getProject());
				Entry entry = ConfigurationManager.getEntry(emfStoreJDTConfiguration, file);
				URI emfStoreURI = ConfigurationManager.getEMFStoreURI(entry).getEMFURI();
				this.suitableEditorInput = new URIEditorInput(emfStoreURI, fileEditorInput.getName());
				isSuitableEditorInputEMFStoreCompatible = true;

				try {
					ITeamSynchronizer teamsynchronizer = TeamSynchronizerRegistry
						.getTeamSynchronizer(file.getProject());
					try {
						Synchronizer.sync(file, teamsynchronizer, true);

					} catch (CannotSyncFileException e) {
						// ignored, keep editorInput
						this.suitableEditorInput = editorInput;
					}

				} catch (NoSuitableTeamSynchronizerException e) {
					// project is not shared, or it is shared by an unsupported team provider
					// use the adapted EditorInput but don not try to synchronize the state
				}

			} catch (NoEMFStoreJDTConfigurationException e) {
				// ignored, keep editorInput
			} catch (EntryNotFoundException e) {
				// ignored, keep editorInput
			}
		}
	}

	/**
	 * @return true if the editor input will load the content from the EMFStore
	 */
	boolean isSuitableEditorInputEMFStoreCompatible() {
		return isSuitableEditorInputEMFStoreCompatible;
	}

	/**
	 * @return the old editor input if the file is not pushed, or an editor input that will load the content directly
	 *         from an EMFStore
	 */
	IEditorInput getSuitableEditorInput() {
		return suitableEditorInput;
	}

}