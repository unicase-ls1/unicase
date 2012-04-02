/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.adapter.commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.team.core.RepositoryProvider;
import org.eclipse.team.core.TeamException;
import org.tigris.subversion.subclipse.core.ISVNLocalResource;
import org.tigris.subversion.subclipse.core.SVNException;
import org.tigris.subversion.subclipse.core.SVNTeamProvider;
import org.tigris.subversion.subclipse.core.commands.GetStatusCommand;
import org.tigris.subversion.subclipse.core.resources.SVNWorkspaceRoot;
import org.tigris.subversion.svnclientadapter.ISVNClientAdapter;
import org.tigris.subversion.svnclientadapter.ISVNStatus;
import org.tigris.subversion.svnclientadapter.SVNClientException;
import org.tigris.subversion.svnclientadapter.SVNStatusKind;
import org.tigris.subversion.svnclientadapter.utils.SVNStatusUtils;
import org.unicase.changetracking.common.IUserInterfaceRunnable;
import org.unicase.changetracking.exceptions.VCSException;
import org.unicase.changetracking.ui.UIUtil;

/**
 * Subclipse implementation for creating a patch.
 * 
 * @author jfinis
 * 
 */
public class SubclipseCreatePatchAction {

	private static final String ECLIPSE_PATCH_HEADER = "### Eclipse Workspace Patch 1.0"; //$NON-NLS-1$
	private static final String ECLIPSE_PROJECT_MARKER = "#P "; //$NON-NLS-1$
	private static final String EOL = System.getProperty("line.separator");

	private ArrayList<IResource> unaddedList;
	private HashMap<IResource, SVNStatusKind> statusMap;

	/**
	 * Creates a patch from a set of input sources.
	 * 
	 * @param sources set of input sources
	 * @param recurse whether to recurse into sub directories
	 * @return a file containing the patch.
	 * @throws VCSException if Subclipse throws an exception.
	 */
	public File createPatch(final IResource[] sources, boolean recurse) throws VCSException {

		// Step 1: Find resources
		statusMap = new HashMap<IResource, SVNStatusKind>();
		unaddedList = new ArrayList<IResource>();
		UIUtil.run(new IUserInterfaceRunnable() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
				try {
					getModifiedResources(sources, monitor);
				} catch (SVNException e) {
					e.printStackTrace();
				}
			}

			public ProgressDisplayKind getPreferredProgressDisplayKind() {
				return ProgressDisplayKind.BUSY_CURSOR;
			}

		});

		// Step 2: register unadded resources at their team provider
		if (unaddedList.size() > 0) {

			try {
				// associate the resources with their respective
				// RepositoryProvider
				HashMap<RepositoryProvider, List<IResource>> table = getProviderMapping(unaddedList);
				for (Entry<RepositoryProvider, List<IResource>> e : table.entrySet()) {

					IProgressMonitor subMonitor = subMonitorFor(null, 100);
					SVNTeamProvider provider = (SVNTeamProvider) e.getKey();
					List<IResource> list = table.get(provider);
					IResource[] providerResources = (IResource[]) list.toArray(new IResource[list.size()]);

					provider.add(providerResources, IResource.DEPTH_INFINITE, subMonitor);
				}
			} catch (TeamException e) {
				throw new VCSException(e);
			}

		}

		// Step 3: Create the patch
		File f = null;
		FileOutputStream fos = null;
		try {
			f = /* new File("/Users/gex/Documents/unicasePatch.txt");// */File.createTempFile("unicaseTempPatch", ".txt");
			fos = new FileOutputStream(f);
			createEclipsePatch(sources, fos, recurse);
			fos.close();
		} catch (SVNClientException e) {
			throw new VCSException(e);
		} catch (IOException e) {
			throw new VCSException(e);
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {}
			}
		}
		return (f);
	}

	/**
	 * Create a sub progress monitor for another monitor.
	 * 
	 * @param monitor parent monitor
	 * @param ticks amount of ticks in the subprogress
	 * @return sub progress monitor
	 */
	public static IProgressMonitor subMonitorFor(IProgressMonitor monitor, int ticks) {
		if (monitor == null) {
			return new NullProgressMonitor();
		}
		if (monitor instanceof NullProgressMonitor) {
			return monitor;
		}
		return new SubProgressMonitor(monitor, ticks);
	}

	/**
	 * Retrieves a map from provider to the resources provided by them.
	 * 
	 * @param resources input resources
	 * @return map
	 */
	protected HashMap<RepositoryProvider, List<IResource>> getProviderMapping(List<IResource> resources) {
		HashMap<RepositoryProvider, List<IResource>> result = new HashMap<RepositoryProvider, List<IResource>>();
		for (IResource r : resources) {
			RepositoryProvider provider = RepositoryProvider.getProvider(r.getProject());
			List<IResource> list = result.get(provider);
			if (list == null) {
				list = new ArrayList<IResource>();
				result.put(provider, list);
			}
			list.add(r);
		}
		return result;
	}

	/**
	 * conducts the patch creation.
	 */
	private void createEclipsePatch(IResource[] paths, OutputStream os, boolean recurse) throws SVNClientException {

		InputStream is = null;
		try {
			byte[] buffer = new byte[4096];

			if (paths.length > 0) {
				os.write(ECLIPSE_PATCH_HEADER.getBytes());
				os.write(EOL.getBytes());
			}

			Map<IProject, List<File>> projectToResources = new HashMap<IProject, List<File>>();

			for (int i = 0; i < paths.length; i++) {
				IResource resource = paths[i];
				IProject project = resource.getProject();
				List<File> files = projectToResources.get(project);
				if (files == null) {
					files = new ArrayList<File>();
					projectToResources.put(project, files);
				}
				files.add(resource.getLocation().toFile());
			}

			for (Iterator<Entry<IProject, List<File>>> iEntry = projectToResources.entrySet().iterator(); iEntry.hasNext();) {
				Entry<IProject, List<File>> entry = iEntry.next();

				IResource project = (IResource) entry.getKey();
				List<File> files = entry.getValue();

				ISVNClientAdapter client = SVNWorkspaceRoot.getSVNResourceFor(project).getRepository().getSVNClient();

				os.write(ECLIPSE_PROJECT_MARKER.getBytes());
				os.write(project.getName().getBytes());
				os.write(EOL.getBytes());

				File tempFile = File.createTempFile("tempDiff", ".txt");
				tempFile.deleteOnExit();
				client.createPatch((File[]) files.toArray(new File[files.size()]), project.getLocation().toFile(), tempFile, recurse);

				try {
					is = new FileInputStream(tempFile);

					int bytesRead;
					while ((bytesRead = is.read(buffer)) != -1) {
						os.write(buffer, 0, bytesRead);
					}
				} finally {
					if (is != null) {
						try {
							is.close();
						} catch (IOException e) {}
					}
				}
			}
		} catch (IOException e) {
			throw new SVNClientException(e);
		} catch (SVNException e) {
			throw new SVNClientException(e);
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {}
			}
		}
	}

	// BEGIN COMPLEX CODE
	/**
	 * Retrieves the set of modified resources from a set of resources.
	 * 
	 * @param resources input resources (as array)
	 * @param monitor progress monitor
	 * @return set of modified resources (as array)
	 * @throws SVNException thrown for various reasons.
	 */
	private IResource[] getModifiedResources(IResource[] resources, IProgressMonitor monitor) throws SVNException {
		final List<IResource> modified = new ArrayList<IResource>();
		List<IResource> unversionedFolders = new ArrayList<IResource>();
		for (int i = 0; i < resources.length; i++) {
			IResource resource = resources[i];
			ISVNLocalResource svnResource = SVNWorkspaceRoot.getSVNResourceFor(resource);

			// This check is for when the action is called with unmanaged
			// resources
			if (svnResource.getRepository() == null) {
				continue;
			}

			// get adds, deletes, updates and property updates.
			GetStatusCommand command = new GetStatusCommand(svnResource, true, false);
			command.run(monitor);
			ISVNStatus[] statuses = command.getStatuses();
			for (int j = 0; j < statuses.length; j++) {
				if (SVNStatusUtils.isReadyForCommit(statuses[j]) || SVNStatusUtils.isMissing(statuses[j])) {
					IResource currentResource = SVNWorkspaceRoot.getResourceFor(resource, statuses[j]);
					if (currentResource != null) {
						ISVNLocalResource localResource = SVNWorkspaceRoot.getSVNResourceFor(currentResource);
						if (!localResource.isIgnored()) {
							if (!SVNStatusUtils.isManaged(statuses[j])) {
								if (!isSymLink(currentResource)) {
									if (currentResource.getType() != IResource.FILE)
										unversionedFolders.add(currentResource);
									else if (!modified.contains(currentResource)) {
										modified.add(currentResource);
										if (currentResource instanceof IContainer)
											statusMap.put(currentResource, statuses[j].getPropStatus());
										else
											statusMap.put(currentResource, statuses[j].getTextStatus());
										if (addToUnadded(currentResource))
											unaddedList.add(currentResource);
									}
								}
							} else if (!modified.contains(currentResource)) {
								modified.add(currentResource);
								if (currentResource instanceof IContainer)
									statusMap.put(currentResource, statuses[j].getPropStatus());
								else
									statusMap.put(currentResource, statuses[j].getTextStatus());
							}
						}
					}
				}
			}
		}
		// get unadded resources and add them to the list.
		IResource[] unaddedResources = getUnaddedResources(unversionedFolders, monitor);
		for (int i = 0; i < unaddedResources.length; i++) {
			if (!modified.contains(unaddedResources[i])) {
				if (unaddedResources[i].getType() == IResource.FILE) {
					modified.add(unaddedResources[i]);
					statusMap.put(unaddedResources[i], SVNStatusKind.UNVERSIONED);
				}
				if (addToUnadded(unaddedResources[i]))
					unaddedList.add(unaddedResources[i]);
			}
		}
		return (IResource[]) modified.toArray(new IResource[modified.size()]);
	}

	private IResource[] getUnaddedResources(List<IResource> resources, IProgressMonitor iProgressMonitor) throws SVNException {
		final List<IResource> unadded = new ArrayList<IResource>();
		final SVNException[] exception = new SVNException[] { null };
		for (Iterator<IResource> iter = resources.iterator(); iter.hasNext();) {
			IResource resource = iter.next();
			if (resource.exists()) {
				// visit each resource deeply
				try {
					resource.accept(new IResourceVisitor() {
						public boolean visit(IResource aResource) {
		 					ISVNLocalResource svnResource = SVNWorkspaceRoot.getSVNResourceFor(aResource);
							// skip ignored resources and their children
							try {
								if (svnResource.isIgnored()) {
									return false;
								}
								// visit the children of shared resources
								if (svnResource.isManaged()) {
									return true;
								}
								if ((aResource.getType() == IResource.FOLDER) && isSymLink(aResource)) {
									// traverse
									// into
									// symlink
									// folders
									return false;
								}
							} catch (SVNException e) {
								exception[0] = e;
							}
							// file/folder is unshared so record it
							unadded.add(aResource);
							return aResource.getType() == IResource.FOLDER;
						}
					}, IResource.DEPTH_INFINITE, false /* include phantoms */);
				} catch (CoreException e) {
					throw SVNException.wrapException(e);
				}
				if (exception[0] != null) {
					throw exception[0];
				}
			}
		}
		return (IResource[]) unadded.toArray(new IResource[unadded.size()]);
	}


	// END COMPLEX CODE
	
	/**
	 * Tests whether a file is a sym link.
	 * 
	 * @param resource resource
	 * @return whether resource is sym link
	 */
	protected boolean isSymLink(IResource resource) {
		File file = resource.getLocation().toFile();
		try {
			if (!file.exists()) {
				return true;
			} else {
				String cnnpath = file.getCanonicalPath();
				String abspath = file.getAbsolutePath();
				return !abspath.equals(cnnpath);
			}
		} catch (IOException ex) {
			return true;
		}
	}

	private boolean addToUnadded(IResource resource) {
		IResource parent = resource;
		while (parent != null) {
			parent = parent.getParent();
			if (unaddedList.contains(parent)) {
				return false;
			}
		}
		return true;
	}

}
