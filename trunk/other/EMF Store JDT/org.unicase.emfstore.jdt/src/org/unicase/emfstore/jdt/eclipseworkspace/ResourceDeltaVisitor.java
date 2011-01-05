/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.eclipseworkspace;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;

/**
 * Finds out which files have been changed in the eclipse workspace.
 * 
 * @author Adrian Staudt
 */
public class ResourceDeltaVisitor implements IResourceDeltaVisitor {

	private Collection<IFile> changedResources = new ArrayList<IFile>();

	private Collection<IFile> removedResources = new ArrayList<IFile>();

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse.core.resources.IResourceDelta)
	 */
	public boolean visit(IResourceDelta delta) {
		if (delta.getResource().getType() == IResource.FILE) {
			IFile fileResource = (IFile) delta.getResource();

			if (delta.getKind() == IResourceDelta.REMOVED && delta.getFlags() != IResourceDelta.MARKERS) {
				removedResources.add(fileResource);
			} else if (delta.getKind() == IResourceDelta.CHANGED && delta.getFlags() != IResourceDelta.MARKERS) {
				changedResources.add(fileResource);
			}
		}

		return true;
	}

	/**
	 * Returns all resources that have been changed.
	 * 
	 * @return All changed resources.
	 */
	public Collection<IFile> getChangedResources() {
		return changedResources;
	}

	/**
	 * Returns all resources that have been removed.
	 * 
	 * @return All removed resources.
	 */
	public Collection<IFile> getRemovedResources() {
		return removedResources;
	}
}