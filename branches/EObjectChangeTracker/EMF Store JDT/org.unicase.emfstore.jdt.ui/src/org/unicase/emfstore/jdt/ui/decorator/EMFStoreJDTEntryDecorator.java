/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.ui.decorator;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.jdt.ITeamSynchronizer;
import org.unicase.emfstore.jdt.TeamSynchronizerRegistry;
import org.unicase.emfstore.jdt.configuration.ConfigurationManager;
import org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration;
import org.unicase.emfstore.jdt.configuration.Entry;
import org.unicase.emfstore.jdt.configuration.HistoryVersionMapping;
import org.unicase.emfstore.jdt.configuration.HistoryVersionMappingEntry;
import org.unicase.emfstore.jdt.configuration.SimpleVersionMapping;
import org.unicase.emfstore.jdt.configuration.VersionMapping;
import org.unicase.emfstore.jdt.exception.EntryNotFoundException;
import org.unicase.emfstore.jdt.exception.NoEMFStoreJDTConfigurationException;
import org.unicase.emfstore.jdt.exception.NoSuitableTeamSynchronizerException;
import org.unicase.emfstore.jdt.exception.TeamSynchronizerException;

/**
 * Decorator to show visually to the user for each resource if it is pushed or not.
 * 
 * @author Adrian Staudt
 */
public class EMFStoreJDTEntryDecorator extends LabelProvider implements ILightweightLabelDecorator {

	/**
	 * This decorator id is defined in the plugin.xml.
	 */
	private static final String DECORATOR_ID = "org.unicase.emfstore.jdt.ui.decorator";

	private IDecoration decoration;
	private ITeamSynchronizer teamSynchronizer;
	private IFile fileToDecorate;

	/**
	 * Decorator will be called for each resource.
	 */
	public static void refreshDecorator() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				PlatformUI.getWorkbench().getDecoratorManager().update(DECORATOR_ID);
			}
		});
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ILightweightLabelDecorator#decorate(java.lang.Object,
	 *      org.eclipse.jface.viewers.IDecoration)
	 */
	public void decorate(Object element, IDecoration decoration) {
		if (!(element instanceof IFile)) {
			// This object is not a file and therefore it must not be decorated.
			return;
		}
		this.decoration = decoration;

		fileToDecorate = (IFile) element;
		try {
			EMFStoreJDTConfiguration emfStoreJDTConfiguration = ConfigurationManager.getConfiguration(fileToDecorate
				.getProject());
			Entry entry = ConfigurationManager.getEntry(emfStoreJDTConfiguration, fileToDecorate);
			if (!entry.isMarkedForDeletion()) {
				decoration.addPrefix("@emfstore ");
				teamSynchronizer = TeamSynchronizerRegistry.getTeamSynchronizer(fileToDecorate.getProject());
				boolean isFileShared = teamSynchronizer.isFileShared(fileToDecorate);
				if (!isFileShared) {
					// nothing more to decorate yet
					return;
				}

				// get current ProjectSpace revision
				VersionMapping versionMapping = entry.getVersionMapping();
				if (versionMapping instanceof SimpleVersionMapping) {
					SimpleVersionMapping simpleVersionMapping = (SimpleVersionMapping) versionMapping;
					int emfStoreRevision = simpleVersionMapping.getEMFStoreRevision();
					decoration.addSuffix(" [v" + emfStoreRevision + "]");

				} else if (versionMapping instanceof HistoryVersionMapping) {
					HistoryVersionMapping historyVersionMapping = (HistoryVersionMapping) versionMapping;
					decorateHistoryVersionMapping(historyVersionMapping);
				}
			}

		} catch (NoEMFStoreJDTConfigurationException e) {
			// Can be ignored. File is not pushed.
		} catch (EntryNotFoundException e) {
			// will be thrown for pushed files, so ignore
		} catch (NoSuitableTeamSynchronizerException e) {
			// will be thrown for unsupported team provider, so ignore
		}
	}

	private void decorateHistoryVersionMapping(HistoryVersionMapping historyVersionMapping) {
		try {
			String workingCopyRevision = teamSynchronizer.getWorkingCopyRevision(fileToDecorate);
			// if the current local file team revision is smaller than the smallest in the history,
			// this file has been reverted back to a point, where the file wasn't under EMFStore control.

			HistoryVersionMappingEntry lowestTeamVersionMapping = historyVersionMapping
				.getLowestTeamVersionMapping(teamSynchronizer);
			if (lowestTeamVersionMapping == null) {
				// missing information, so do not more decoration
				return;
			}

			if (!(teamSynchronizer.compare(workingCopyRevision, lowestTeamVersionMapping.getTeamProviderRevision()) == 1)) {
				HistoryVersionMappingEntry versionMapping4TeamRevision = historyVersionMapping
					.getVersionMapping4TeamRevision(workingCopyRevision);
				if (versionMapping4TeamRevision != null) {
					int emfStoreRevision = versionMapping4TeamRevision.getEMFStoreRevision();
					decoration.addSuffix(" [v" + emfStoreRevision + "]");

				} else {
					decoration.addSuffix(" [unsynced]");
				}
			}

		} catch (TeamSynchronizerException e) {
			// ignore

		}

	}

}
