package org.unicase.codetrace.team.exported;

import java.io.File;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.unicase.codetrace.team.applyPatch.BasicApplyPatchMethod;

public abstract class AbstractTeamAdapter {
	
	public void applyPatch(IStorage patch, IResource target) throws CodetraceTeamException{
		new BasicApplyPatchMethod().applyPatch(patch, target);
	}
	
	public abstract File createPatch(IResource[] sources) throws CodetraceTeamException;
	

}
