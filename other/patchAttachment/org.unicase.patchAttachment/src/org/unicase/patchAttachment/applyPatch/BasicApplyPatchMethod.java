package org.unicase.patchAttachment.applyPatch;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.patch.ApplyPatchOperation;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.team.internal.ui.actions.TeamAction;
import org.unicase.patchAttachment.exported.IApplyPatchMethod;

public class BasicApplyPatchMethod extends TeamAction{



	@Override
	protected void execute(IAction action) throws InvocationTargetException,
			InterruptedException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Applies a patch onto a target. Target may be null.
	 * Returns true if the patch was applied and false if the user canceled
	 */
	public boolean applyPatch(IStorage patch, IResource target) {
		ApplyPatchAttachmentOperation	op= new ApplyPatchAttachmentOperation(getTargetPart(), patch, target, new CompareConfiguration());
		BusyIndicator.showWhile(Display.getDefault(), op); 
		try {
			op.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return !op.wasCanceled();
	}

}
