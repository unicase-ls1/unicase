/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */


package org.unicase.ui.visualization.tree;

import org.eclipse.emf.ecore.EObject;

/**
 * Represents a cross reference.
 * 
 * @author Julian Sommerfeldt
 *
 */
public class ReferenceUnicaseNode extends UnicaseNode {
	
	/**
	 * @param obj The {@link EObject}.
	 */
	public ReferenceUnicaseNode(EObject obj) {
		super(obj);		
	}
	
	@Override
	public String toString(){
		return super.toString();
	}
}
