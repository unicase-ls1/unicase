/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.eclipseworkspace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.jdt.configuration.ConfigurationManager;
import org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration;
import org.unicase.emfstore.jdt.configuration.EMFStoreLocation;
import org.unicase.emfstore.jdt.configuration.EObjectLocation;
import org.unicase.emfstore.jdt.configuration.Entry;
import org.unicase.emfstore.jdt.eclipseworkspace.emfstore.ProjectSpaceUtil;
import org.unicase.emfstore.jdt.exception.EntryNotFoundException;
import org.unicase.emfstore.jdt.exception.NoEMFStoreJDTConfigurationException;
import org.unicase.emfstore.jdt.exception.ProjectSpaceNotFoundException;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.workspace.ProjectSpace;

/**
 * Utility class to get information which files are under EMFStore control and other related work.
 * 
 * @author Adrian Staudt
 */
public class ResourceCommitHolder {

	private final Set<IFileEntryTuple> emfStoreManagedFETuples = new HashSet<IFileEntryTuple>();
	private final Set<IFile> emfStoreUnmanagedFiles = new HashSet<IFile>();
	// private final Set<IFileEntryTuple> forcedFETuplesToCommit = new HashSet<IFileEntryTuple>();

	private final Set<IFile> allFiles = new HashSet<IFile>();
	private final Set<IProject> relevantProjects = new HashSet<IProject>();

	/**
	 * Constructor.
	 * 
	 * @param resource Resource that will be checked.
	 */
	public ResourceCommitHolder(IResource resource) {
		this(new IResource[] { resource });
	}

	/**
	 * Constructor.
	 * 
	 * @param resources An array of resources that will be checked.
	 */
	public ResourceCommitHolder(IResource[] resources) {
		this.allFiles.addAll(getIFiles(resources));
		this.relevantProjects.addAll(getRelatedProjects(allFiles));

		// classify files
		for (IFile file : allFiles) {
			try {
				EMFStoreJDTConfiguration emfStoreJDTConfiguration = ConfigurationManager.getConfiguration(file
					.getProject());
				Entry entry = ConfigurationManager.getEntry(emfStoreJDTConfiguration, file);
				IFileEntryTuple tuple = new IFileEntryTuple(file, entry);
				emfStoreManagedFETuples.add(tuple);

			} catch (NoEMFStoreJDTConfigurationException e) {
				// project has no configuration file => file cannot be managed by an EFMStore
				emfStoreUnmanagedFiles.add(file);

			} catch (EntryNotFoundException e) {
				// no entry was found in the configuration file => file is not managed by an EFMStore
				emfStoreUnmanagedFiles.add(file);
			}
		}

		// add .emfstoreconf files
		for (IProject relevantProject : this.relevantProjects) {
			IFile confFile = relevantProject.getFile(ConfigurationManager.EMFSTORECONF);
			allFiles.add(confFile);
		}

		// inspect also "AnyawayCommit"
		for (IProject project : this.relevantProjects) {
			try {
				EMFStoreJDTConfiguration emfStoreJDTConfiguration = ConfigurationManager.getConfiguration(project);
				EList<EMFStoreLocation> anywayCommits = emfStoreJDTConfiguration.getAnywayCommit();
				EList<Entry> entries = emfStoreJDTConfiguration.getEntry();
				for (Entry entry : entries) {
					for (EMFStoreLocation anywayCommit : anywayCommits) {
						IFile file = project.getFile(entry.getProjectRelativeLocation());
						if (file.exists()) {
							if (entry.getEObjectLocation().getEMFStoreLocation().equals(anywayCommit)) {
								// Add all forced commit files.
								// A team commit will ignore this file if its not modified
								allFiles.add(file);

								IFileEntryTuple feTuple = new IFileEntryTuple(file, entry);
								emfStoreManagedFETuples.add(feTuple);
							}

						}
					}
				}

			} catch (NoEMFStoreJDTConfigurationException e) {
				// TODO Auto-generated catch block
				// Do NOT catch all Exceptions ("catch (Exception e)")
				// Log AND handle Exceptions if possible
				//
				// You can just uncomment one of the lines below to log an exception:
				// logException will show the logged excpetion to the user
				// ModelUtil.logException(e);
				// ModelUtil.logException("YOUR MESSAGE HERE", e);
				// logWarning will only add the message to the error log
				// ModelUtil.logWarning("YOUR MESSAGE HERE", e);
				// ModelUtil.logWarning("YOUR MESSAGE HERE");
				//
				// If handling is not possible declare and rethrow Exception
			}
		}
	}

	/**
	 * Returns all files.
	 * 
	 * @return All files.
	 */
	public Set<IFile> getAllFiles() {
		return this.allFiles;
	}

	private static Set<IProject> getRelatedProjects(Set<IFile> files) {
		Set<IProject> relatedProjects = new HashSet<IProject>();

		// get related projects and classify files
		for (IFile file : files) {
			IProject project = file.getProject();
			relatedProjects.add(project);
		}

		return relatedProjects;
	}

	/**
	 * Returns all related eclipse workspace projects.
	 * 
	 * @return All related projects.
	 */
	public Set<IProject> getReleatedProjects() {
		return this.relevantProjects;
	}

	/**
	 * Returns all ProjectSpaces that need to be committed.
	 * 
	 * @return All ProjectSpaces that need to be committed.
	 */
	public Collection<ProjectSpace> getProjectSpacesToCommit() {
		// ProjectSpaces can't be used in a set, two identical but different ProjectSpace-objects are not equal.
		Map<String, ProjectSpace> projectsToCommit = new HashMap<String, ProjectSpace>();

		// Set<ProjectSpace> projectsToCommit = new HashSet<ProjectSpace>();

		// get ProjectSpaces from tuples to commit
		for (IFileEntryTuple commitedFileEntryTuple : emfStoreManagedFETuples) {
			IFile commitedFile = commitedFileEntryTuple.file;
			IProject project = commitedFile.getProject();
			try {
				EMFStoreJDTConfiguration emfStoreJDTConfiguration = ConfigurationManager.getConfiguration(project);
				Entry entry = ConfigurationManager.getEntry(emfStoreJDTConfiguration, commitedFile);
				StructuredEMFStoreURI structuredEMFStoreURI = ConfigurationManager.getEMFStoreURI(entry);
				ProjectSpace projectSpace = ProjectSpaceUtil.getProjectSpace(structuredEMFStoreURI.getProjectID());

				projectsToCommit.put(projectSpace.getProjectId().getId(), projectSpace);

			} catch (NoEMFStoreJDTConfigurationException e) {
				// ignore this project
			} catch (EntryNotFoundException e) {
				// maybe there is an entry, but this entry is marked for deletion,
				// so that getEntry(..) will not return this object. Anyway if so
				// there will be an entry in the list "AnywayCommit", so that this
				// exception may be ignored.

			} catch (ProjectSpaceNotFoundException e) {
				ModelUtil.logException(e);
			}
		}

		// get ProjectSpaces from "AnywayCommit"
		for (IProject project : this.relevantProjects) {
			try {
				EMFStoreJDTConfiguration emfStoreJDTConfiguration = ConfigurationManager.getConfiguration(project);
				EList<EMFStoreLocation> anywayCommits = emfStoreJDTConfiguration.getAnywayCommit();
				for (EMFStoreLocation emfStoreLocation : anywayCommits) {
					try {
						ProjectSpace projectSpace = ProjectSpaceUtil.getProjectSpace(emfStoreLocation.getProjectID());
						projectsToCommit.put(projectSpace.getProjectId().getId(), projectSpace);

					} catch (ProjectSpaceNotFoundException e) {
						ModelUtil.logException(e);
					}
				}

			} catch (NoEMFStoreJDTConfigurationException e) {
				ModelUtil.logException(e);
			}
		}

		return projectsToCommit.values();
	}

	/**
	 * All resources hat are managed by an EMFStore.
	 * 
	 * @return A set of tuples of the local file and the configuration entry.
	 */
	public Set<IFileEntryTuple> getEMFStoreManagedFETuples() {
		return emfStoreManagedFETuples;
	}

	/**
	 * All resources that are not managed by an EMFStore.
	 * 
	 * @return A set of IFiles that represents the input resources.
	 */
	public Set<IFile> getEMFStoreUnanagedFiles() {
		return emfStoreUnmanagedFiles;
	}

	/**
	 * Removed all ProjectSpaces that have been marked as "force to commit".
	 */
	public void cleanForcedEMFStoresToCommit() {
		for (IProject project : this.relevantProjects) {
			try {
				EMFStoreJDTConfiguration emfStoreJDTConfiguration = ConfigurationManager.getConfiguration(project);
				emfStoreJDTConfiguration.getAnywayCommit().clear();
				emfStoreJDTConfiguration.save();

			} catch (NoEMFStoreJDTConfigurationException e) {
				ModelUtil.logException(e);
			}
		}
	}

	/**
	 * Removes all entries that are marked for deletion.
	 */
	public void removeEntriesThatAreMarkedForDeletion() {
		for (IProject project : this.relevantProjects) {
			try {
				boolean saveNeed = false;
				EMFStoreJDTConfiguration emfStoreJDTConfiguration = ConfigurationManager.getConfiguration(project);
				Iterator<Entry> entryIterator = emfStoreJDTConfiguration.getEntry().iterator();
				while (entryIterator.hasNext()) {
					Entry entry = entryIterator.next();
					if (entry.isMarkedForDeletion()) {
						entryIterator.remove();
						saveNeed = true;
					}
				}

				if (saveNeed) {
					emfStoreJDTConfiguration.save();
				}

			} catch (NoEMFStoreJDTConfigurationException e) {
				ModelUtil.logException(e);
			}
		}
	}

	/**
	 * Casts all resources that are of the type "IFile" to these class.
	 * 
	 * @param iResources An array of resources.
	 * @return A set of IFiles.
	 */
	private Set<IFile> getIFiles(IResource[] iResources) {
		Set<IFile> iFiles = new HashSet<IFile>();
		for (IResource iResource : iResources) {
			if (iResource instanceof IFile) {
				IFile iFile = (IFile) iResource;
				iFiles.add(iFile);
			}
		}

		return iFiles;
	}

	/**
	 * A list of local files that point to the given EMFStore URI. Typically this list should contain only one file.
	 * 
	 * @param structuredEMFStoreURI A EMFStore URI that identifies a pushed EObject.
	 * @return A list of corresponding files.
	 */
	public static List<IFile> getFilesInWorkspace(StructuredEMFStoreURI structuredEMFStoreURI) {
		List<IFile> filesInWorkspace = new ArrayList<IFile>();

		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (IProject project : projects) {
			try {
				EMFStoreJDTConfiguration configuration = ConfigurationManager.getConfiguration(project);
				EList<Entry> entryList = configuration.getEntry();
				for (Entry entry : entryList) {
					EObjectLocation eObjectLocation = entry.getEObjectLocation();
					if (structuredEMFStoreURI.equals(eObjectLocation)) {
						String projectRelativeLocation = entry.getProjectRelativeLocation();
						IFile file = project.getFile(projectRelativeLocation);
						filesInWorkspace.add(file);
					}
				}

			} catch (NoEMFStoreJDTConfigurationException e) {
				// can be ignored
			}
		}

		return filesInWorkspace;
	}

}
