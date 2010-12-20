/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.patchAttachment.exported;

import java.io.File;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.unicase.patchAttachment.applyPatch.BasicApplyPatchMethod;

/**
 * The abstract super class for all team adapters.
 * Every team addapter must provider a createPatch method.
 * @author gex
 *
 */
public abstract class AbstractTeamAdapter {
	
	/**
	 * Applies a patch.
	 * @param patch the file containing the patch
	 * @param target the target for the patch
	 * @throws PatchAttachmentException any error occurring during that process
	 */
	public void applyPatch(IStorage patch, IResource target) throws PatchAttachmentException{
		new BasicApplyPatchMethod().applyPatch(patch, target);
	}
	
	/**
	 * Creates a patch in unified diff format and returns it as a file.
	 * @param sources the resources to include into the patch.
	 * @return the patch in a file
	 * @throws PatchAttachmentException any errors occuring during that process
	 */
	public abstract File createPatch(IResource[] sources) throws PatchAttachmentException;
	

}
