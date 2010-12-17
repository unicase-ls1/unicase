package org.unicase.patchAttachment.exported;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;

/**
 * A Create patch method creates a patch from a source
 * @author jfinis
 *
 */
public interface ICreatePatchMethod {

	/**
	 * Creates a patch.
	 * @param source from which source?
	 * @return the patch
	 */
	IStorage createPatch(IResource source);
}
