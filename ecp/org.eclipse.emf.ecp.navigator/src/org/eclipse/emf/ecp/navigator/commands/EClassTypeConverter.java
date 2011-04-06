/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.navigator.commands;

import org.eclipse.core.commands.AbstractParameterValueConverter;
import org.eclipse.core.commands.ParameterValueConversionException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * @author Hodaie This is the converter for EClass parameter passed to createME command
 *         (org.eclipse.emf.ecp.navigator.createME).
 */
public class EClassTypeConverter extends AbstractParameterValueConverter {

	/**
	 * . {@inheritDoc} This creates the EClass object back from its string representation.
	 */
	@Override
	public Object convertToObject(String parameterValue) throws ParameterValueConversionException {

		String[] parts = parameterValue.split(";");
		String nsURI = parts[0];
		String name = parts[1];

		EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(nsURI);
		EClass eClass = (EClass) ePackage.getEClassifier(name);

		return eClass;

	}

	/**
	 * . ({@inheritDoc}) This creates a string representation of EClass object to put it in command parameters map.
	 */
	@Override
	public String convertToString(Object parameterValue) throws ParameterValueConversionException {
		// We need and string representation of an EClass that can be
		// turned back to an EClass object.
		// It was tested with serialization method MRIUtil but
		// it has the problem that referenced of this EClass instance are not
		// serialized and we needed them.

		// I found out that all i need to create an EClass instance
		// is the NsURI of its package and its name.
		if (parameterValue instanceof EClass) {

			EClass eClass = (EClass) parameterValue;
			return eClass.getEPackage().getNsURI() + ";" + eClass.getName();
		} else {
			return null;
		}
	}

}
