/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.patchAttachment.applyPatch;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.team.internal.ui.actions.TeamAction;
import org.unicase.metamodel.util.ModelUtil;

/**
 * Basic method for applying patches.
 * 
 * @author jfinis
 */
@SuppressWarnings("restriction")
public class BasicApplyPatchMethod extends TeamAction{



	@Override
	protected void execute(IAction action) throws InvocationTargetException,
			InterruptedException {
	}

	/**
	 * Applies a patch onto a target. Target may be null.
	 * Returns true if the patch was applied and false if the user canceled
	 * 
	 * @param patch storage containing the patch
	 * @param target target for the patch
	 * @return whether the operation was not canceled
	 */
	public boolean applyPatch(IStorage patch, IResource target) {
		ApplyPatchAttachmentOperation	op= new ApplyPatchAttachmentOperation(getTargetPart(), patch, target, new CompareConfiguration());
		BusyIndicator.showWhile(Display.getDefault(), op); 
		try {
			op.join();
		} catch (InterruptedException e) {
			ModelUtil.logException(e);
		}
		return !op.wasCanceled();
	}

}
