package org.unicase.patch.handlers;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.IAction;
import org.eclipse.team.internal.ccvs.ui.actions.GenerateDiffFileAction;
import org.unicase.patch.adapters.IAbstractAdapter;

@SuppressWarnings("restriction")
public class CVSAdapter implements IAbstractAdapter {
	
	public CVSAdapter() {
		
	}
	
	public void createPatch(IProject project) {
		IAction a = null;
		GenerateDiffFileAction act = new GenerateDiffFileAction();
		try {
			act.execute(a);
		} catch (Throwable t) {
			System.out.println(t.getMessage());
		}
	}

	public boolean isResponsible(String repositoryId) {
		if (repositoryId.contains(".cvsnature")) {
			return true;
		}
		
		return false;
	}

}

