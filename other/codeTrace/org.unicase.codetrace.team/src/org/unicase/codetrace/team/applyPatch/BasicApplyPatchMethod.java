package org.unicase.codetrace.team.applyPatch;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.patch.ApplyPatchOperation;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.team.internal.ui.TeamUIPlugin;
import org.eclipse.team.internal.ui.actions.TeamAction;
import org.unicase.codetrace.team.exported.IApplyPatchMethod;

public class BasicApplyPatchMethod extends TeamAction implements IApplyPatchMethod{

	/**
	 * Applies a patch onto a target. Target may be null.
	 */
	@Override
	public void applyPatch(IStorage patch, IResource target) {
		
		
		ApplyPatchOperation	op= new ApplyPatchOperation(getTargetPart(), patch, target, new CompareConfiguration());
		BusyIndicator.showWhile(Display.getDefault(), op); 
		
	}

	@Override
	protected void execute(IAction action) throws InvocationTargetException,
			InterruptedException {
		// TODO Auto-generated method stub
		
	}

}
