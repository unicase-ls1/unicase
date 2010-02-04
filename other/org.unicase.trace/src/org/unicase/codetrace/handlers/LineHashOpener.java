/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.codetrace.handlers;
 

import org.unicase.metamodel.ModelElement;
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
	public int canOpen(ModelElement me) {
		if (me instanceof LineHash){
				return 0;
			}
		
		return 1;
	}

	public void openModelElement(ModelElement modelElement) {
		if(!(modelElement instanceof LineHash)){
			
		//super?
		}
		else throw new IllegalArgumentException("Opener not available");

	}

}
