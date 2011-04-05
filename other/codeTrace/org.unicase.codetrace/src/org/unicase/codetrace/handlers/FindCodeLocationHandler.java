/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.codetrace.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.unicase.codetrace.CodetraceUtil;
import org.unicase.model.trace.CodeLocation;
import org.unicase.ui.common.util.ActionHelper;

/**
 * This handler changes current perspective to the java perspective 
 * and shows the code location in the editor. 
 * @author snogina
 *
 */
public class FindCodeLocationHandler extends AbstractHandler {



	/***
	 * . ({@inheritDoc})
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		EObject me = ActionHelper.getModelElement(event);
		if (me instanceof CodeLocation) {
			CodetraceUtil.findCodeLocation((CodeLocation)me);
		}

		return null;
	}

}
