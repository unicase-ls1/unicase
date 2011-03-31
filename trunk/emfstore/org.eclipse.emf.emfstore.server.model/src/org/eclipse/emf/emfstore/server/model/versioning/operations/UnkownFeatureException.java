/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.operations;

import org.eclipse.emf.ecore.EClass;

/**
 * Represents the exception that a feature is not known to a model element.
 * 
 * @author koegel
 */
@SuppressWarnings("serial")
public class UnkownFeatureException extends Exception {

	/**
	 * Constructor.
	 * 
	 * @param eClass the EClass of the element
	 * @param featureName the missing features name
	 */
	public UnkownFeatureException(EClass eClass, String featureName) {
		super("The feature \"" + featureName + " is unkown for EClass \"" + eClass.getName());
	}

}
