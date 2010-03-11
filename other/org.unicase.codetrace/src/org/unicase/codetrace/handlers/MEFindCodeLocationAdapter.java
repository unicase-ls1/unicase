/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.codetrace.handlers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.unicase.model.trace.CodeLocation;

/**
 * A mouse adapter starts searching for a code location.
 * 
 * @author snogina
 */
public class MEFindCodeLocationAdapter  extends MouseAdapter {

	private EObject link;

	/**
	 * Default constructor.
	 * 
	 * @param link - link to the attached code location.
	 */
	public MEFindCodeLocationAdapter (EObject link) {
		
		this.link = link;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mouseUp(MouseEvent e) {
	
		new FindCodeLocationCommand((CodeLocation) link).run();
	}
}

