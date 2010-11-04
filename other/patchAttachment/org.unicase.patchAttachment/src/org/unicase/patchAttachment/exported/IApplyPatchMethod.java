package org.unicase.patchAttachment.exported;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;

public interface IApplyPatchMethod {

	void applyPatch(IStorage patch, IResource target);
}