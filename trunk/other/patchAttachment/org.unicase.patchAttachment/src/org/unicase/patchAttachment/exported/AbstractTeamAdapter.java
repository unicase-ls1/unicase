package org.unicase.patchAttachment.exported;

import java.io.File;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.patch.ApplyPatchOperation;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;
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
