/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.navigator.commands;

import org.eclipse.core.commands.AbstractParameterValueConverter;
import org.eclipse.core.commands.ParameterValueConversionException;
import org.unicase.model.diagram.DiagramType;

/**
 * @author denglerm This is the converter for DiagramType parameter passed to createME command
 *         (org.unicase.ui.unicasecommon.navigator.createME).
 */
public class DiagramTypeConverter extends AbstractParameterValueConverter {

	/**
	 * . {@inheritDoc} This creates the DiagramType object back from its string representation.
	 */
	@Override
	public Object convertToObject(String parameterValue) throws ParameterValueConversionException {
		return DiagramType.getByName(parameterValue);
	}

	/**
	 * . ({@inheritDoc}) This creates a string representation of DiagramType object to put it in command parameters map.
	 */
	@Override
	public String convertToString(Object parameterValue) throws ParameterValueConversionException {

		if (parameterValue instanceof DiagramType) {
			return ((DiagramType) parameterValue).getName();
		} else {
			return null;
		}
	}

}
