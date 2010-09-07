package org.unicase.patchAttachment.exported;

import java.io.File;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.patch.ApplyPatchOperation;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;
import org.unicase.patchAttachment.applyPatch.BasicApplyPatchMethod;

public abstract class AbstractTeamAdapter {
	
	public void applyPatch(IStorage patch, IResource target) throws PatchAttachmentException{
		new BasicApplyPatchMethod().applyPatch(patch, target);
	}
	
	public abstract File createPatch(IResource[] sources) throws PatchAttachmentException;
	

}
