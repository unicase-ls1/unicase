/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.ui;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.unicase.emfstore.jdt.ITeamSynchronizer;
import org.unicase.emfstore.jdt.TeamSynchronizerRegistry;
import org.unicase.emfstore.jdt.configuration.ConfigurationManager;
import org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration;
import org.unicase.emfstore.jdt.configuration.Entry;
import org.unicase.emfstore.jdt.eclipseworkspace.IFileEntryTuple;
import org.unicase.emfstore.jdt.eclipseworkspace.ResourceCommitHolder;
import org.unicase.emfstore.jdt.eclipseworkspace.ResourceDeltaVisitor;
import org.unicase.emfstore.jdt.eclipseworkspace.Synchronizer;
import org.unicase.emfstore.jdt.exception.CannotSyncFileException;
import org.unicase.emfstore.jdt.exception.EntryNotFoundException;
import org.unicase.emfstore.jdt.exception.NoEMFStoreJDTConfigurationException;
import org.unicase.emfstore.jdt.exception.NoSuitableTeamSynchronizerException;
import org.unicase.emfstore.jdt.ui.decorator.EMFStoreJDTEntryDecorator;

/**
 * The available team provider offers to insufficient extension points. It is not possible to get be directly informed
 * from a team provider which files have been modified. A modification is done e.g. by actions like "update",
 * "update to version", "revert". So it is necessary get a notifier
 * 
 * @author Adrian Staudt
 */
public class WorkspaceObserver implements IResourceChangeListener {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.resources.IResourceChangeListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)
	 */
	public void resourceChanged(IResourceChangeEvent event) {
		IResourceDelta delta = event.getDelta();
		final ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();
		try {
			delta.accept(visitor);

			// remove resource from emfstoreconf
			Collection<IFile> removedResources = visitor.getRemovedResources();
			for (IFile removedResource : removedResources) {
				try {
					EMFStoreJDTConfiguration emfStoreJDTConfiguration = ConfigurationManager
						.getConfiguration(removedResource.getProject());
					Entry entry = ConfigurationManager.getEntry(emfStoreJDTConfiguration, removedResource);
					ConfigurationManager.rejectEntry(emfStoreJDTConfiguration, entry);
					emfStoreJDTConfiguration.save();

				} catch (NoEMFStoreJDTConfigurationException e) {
					// can be ignored
				} catch (EntryNotFoundException e) {
					// can be ignored
				}
			}

			// files to sync
			Collection<IFile> changedResources = visitor.getChangedResources();

			// whole projects to sync
			{
				Set<IProject> projectsToSync = getProjectsToSync(changedResources);
				for (IProject projectToSync : projectsToSync) {
					try {
						ITeamSynchronizer teamSynchronizer = TeamSynchronizerRegistry
							.getTeamSynchronizer(projectToSync);
						try {
							Synchronizer.sync(projectToSync, teamSynchronizer);

						} catch (CannotSyncFileException e) {
							if (!e.wasHarmless()) {
								ModelUtil.logException(e);
							}
						}

					} catch (NoSuitableTeamSynchronizerException e) {
						// can be ignored, not suitable team synchronizer registered
					}
				}

				// files to sync
				Set<IFile> filesToSync = getIFilesNotIncludedInProject(projectsToSync, changedResources);
				Set<IFileEntryTuple> emfStoreManagedIFileEntryTuplesWithStatusChanged = new ResourceCommitHolder(
					filesToSync.toArray(new IFile[0])).getEMFStoreManagedFETuples();

				for (IFileEntryTuple tuple : emfStoreManagedIFileEntryTuplesWithStatusChanged) {
					try {
						ITeamSynchronizer teamSynchronizer = TeamSynchronizerRegistry.getTeamSynchronizer(tuple
							.getFile().getProject());
						try {
							Synchronizer.sync(tuple.getFile(), teamSynchronizer);

						} catch (CannotSyncFileException e) {
							if (!e.wasHarmless()) {
								ModelUtil.logException(e);
							}
						}

					} catch (NoSuitableTeamSynchronizerException e) {
						// can be ignored, not suitable team synchronizer registered
					}
				}
			}

		} catch (CoreException e) {
			ModelUtil.logException(e);
		}

		EMFStoreJDTEntryDecorator.refreshDecorator();
	}

	private Set<IProject> getProjectsToSync(Collection<IFile> files) {
		Set<IProject> projectsToSync = new HashSet<IProject>();

		for (IFile file : files) {
			if (file.getName().equals(ConfigurationManager.EMFSTORECONF)) {
				projectsToSync.add(file.getProject());
			}
		}

		return projectsToSync;
	}

	private Set<IFile> getIFilesNotIncludedInProject(Set<IProject> projectsToIgnore, Collection<IFile> allFiles) {
		Set<IFile> filesToSync = new HashSet<IFile>();

		for (IFile file : allFiles) {
			if (projectsToIgnore.contains(file.getProject())) {
				continue;
			}

			filesToSync.add(file);
		}

		return filesToSync;
	}
}
