/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.diagram.part;

import org.eclipse.core.expressions.PropertyTester;
import org.unicase.model.diagram.DiagramType;
import org.unicase.model.diagram.MEDiagram;

// dengler clarify with schroech
/**
 * @author schroech
 */
public class DiagramTypeTester extends PropertyTester {

	/**
	 * Default constructor.
	 */
	public DiagramTypeTester() {
		super();
	}

	/**
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[],
	 *      java.lang.Object)
	 * @param receiver The MEDiagram to test
	 * @param property The "type" property
	 * @param args Additional arguments ignored by this tester
	 * @param expectedValue the expected value of the property. Can be any literal value defined in {@link DiagramType}
	 * @return Returns <code>true</code> if the type of the diagram type matches the expected value; otherwise
	 *         <code>false</code> is returned
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		// START Sanity checks
		if (!(receiver instanceof MEDiagram)) {
			throw new IllegalArgumentException();
		}

		if (!(property.equals("isDiagramType"))) {
			throw new IllegalArgumentException();
		}

		if (args != null && args.length > 0) {
			throw new IllegalArgumentException();
		}

		if (!(expectedValue instanceof String)) {
			throw new IllegalArgumentException();
		}
		// END Sanity checks

		DiagramType expectedType = getExpectedType((String) expectedValue);

		DiagramType diagramType;
		MEDiagram diagram = (MEDiagram) receiver;
		// TODO : EMFPlainEObjectTransition: diagram type
		// diagramType = diagram.getType();
		//
		// if (expectedType.equals(diagramType)) {
		// return true;
		// }

		return false;
	}

	/**
	 * Gets the expected {@link DiagramType} identified by the expectedValue string.
	 * 
	 * @param expectedValue The literal or name of the expected {@link DiagramType}
	 * @return The {@link DiagramType} or null
	 */
	protected DiagramType getExpectedType(String expectedValue) {
		DiagramType expectedTypeByLiteral = DiagramType.get(expectedValue);
		DiagramType expectedTypeByName = DiagramType.getByName(expectedValue);

		if (expectedTypeByLiteral == null && expectedTypeByName == null) {
			throw new IllegalArgumentException();
		}

		DiagramType expectedType;
		if (expectedTypeByLiteral != null) {
			expectedType = expectedTypeByLiteral;
		} else {
			expectedType = expectedTypeByName;
		}

		return expectedType;
	}

}
