/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.codetrace.handlers;
 

import org.eclipse.emf.ecore.EObject;
import org.unicase.model.trace.LineHash;
import org.unicase.ui.common.ModelElementOpener;

/**
 * Opener for the LineHash class.
 * @author snogina
 *
 */
public class LineHashOpener implements ModelElementOpener  {
	
	/**
	 * {@inheritDoc}
	 */
	public int canOpen(EObject me) {
		if (me instanceof LineHash){
				return 1;
			}
		
		return DONOTOPEN;
	}
	
	/**
	 * Opens a certain model element.
	 * @param modelElement the model element who will be opened
	 */
	public void openModelElement(EObject modelElement) {
		if(!(modelElement instanceof LineHash)){
			
			throw new IllegalArgumentException("Opener not available");
		} 

	}

}
