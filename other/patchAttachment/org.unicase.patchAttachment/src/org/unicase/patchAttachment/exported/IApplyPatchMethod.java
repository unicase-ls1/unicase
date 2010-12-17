package org.unicase.patchAttachment.exported;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;

/**
 * An apply patch method is a class that allows to apply a patch.
 * @author jfinis
 *
 */
public interface IApplyPatchMethod {

	/**
	 * Applies a patch onto a target
	 * @param patch the storage containing the patch
	 * @param target the target for the patch
	 */
	void applyPatch(IStorage patch, IResource target);
}
