/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.classDiagram.part;

import org.unicase.model.classes.Association;
import org.unicase.model.classes.Attribute;
import org.unicase.model.classes.Dependency;
import org.unicase.model.classes.Method;
import org.unicase.model.classes.MethodArgument;
import org.unicase.model.diagram.DiagramType;
import org.unicase.model.diagram.MEDiagram;

/**
 * @author schroech
 *
 */
public class DiagramTypeTester extends org.unicase.ui.common.diagram.part.DiagramTypeTester {

	/**
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
	 * 
	 * @param receiver The EObject to test
	 * @param property The "type" property
	 * @param args Additional arguments ignored by this tester
	 * 
	 * @param expectedValue the expected value of the property.
	 * Can be any literal value defined in {@link DiagramType}
	 * 
	 * @return Returns <code>true</code> if receiver can appear on a class diagram.
	 */
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof MEDiagram) {
			return super.test(receiver, property, args, expectedValue);
		}

		DiagramType expectedType = getExpectedType((String) expectedValue);
		
		if (receiver instanceof org.unicase.model.classes.Class
			|| receiver instanceof Association
			|| receiver instanceof Dependency
			|| receiver instanceof org.unicase.model.classes.Package) {
			
			if (expectedType.getName().equals("CLASS_DIAGRAM")) {
				return true;	
			}
		}

		//Checkstyle mania
		//Nothing different to the if statement above
		if(receiver instanceof Method
			|| receiver instanceof MethodArgument
			|| receiver instanceof Attribute) {
			
			if (expectedType.getName().equals("CLASS_DIAGRAM")) {
				return true;	
			}
		}

		return false;
	}
}
