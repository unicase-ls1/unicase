package org.unicase.patchAttachment.adapter.subclipse;

import java.io.File;

import org.eclipse.core.resources.IResource;
import org.unicase.patchAttachment.exported.AbstractTeamAdapter;
import org.unicase.patchAttachment.exported.PatchAttachmentException;

public class SubclipseTeamAdapter extends AbstractTeamAdapter{

	@Override
	public File createPatch(IResource[] source) throws PatchAttachmentException  {
		return new SubclipseCreatePatchAction().createPatch(source, true);
	}

}
