/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations.util;

import org.unicase.model.classes.Association;
import org.unicase.model.classes.Attribute;
import org.unicase.model.classes.Class;
import org.unicase.model.classes.PrimitiveType;
import org.unicase.model.classes.validation.ClassesHelper;

/**
 * Helper class for UML class refactorings.
 * @author herrmi
 *
 */
public final class ClassesOperationHelper {

	private ClassesOperationHelper() {
		// hide constructor
	}

	/**
	 * Get all attributes of a class that look like the given attribute.
	 * @param c the other class
	 * @param attribute the original attribute
	 * @return a list of same attributes
	 */
	public static Attribute getSameAttribute(Class c, Attribute attribute) {
		for (Attribute a : c.getAttributes()) {
			try {
				boolean sameName = attribute.getName().equals(a.getName());
				boolean sameType = attribute.getImplementationType() == a.getImplementationType()
					&& (attribute.getImplementationType() != PrimitiveType.ENUMERATION || attribute
						.getImplementationEnumeration() == a.getImplementationEnumeration());
				boolean sameId = attribute.isId() == a.isId();
				boolean sameTransient = attribute.isTransient() == a.isTransient();
				if (sameName && sameType && sameId && sameTransient) {
					return a;
				}
			} catch (NullPointerException e) {
				// ignore
				//FIXME herrmi: BAD design
			}
		}
		return null;
	}

	/**
	 * Get all outgoing associations of a class that look like the given association.
	 * @param c the other class
	 * @param association the original association
	 * @return a list of same associations
	 */
	public static Association getSameOutgoingAssociation(Class c, Association association) {
		for (Association a : c.getOutgoingAssociations()) {
			if (sameOutgoingAssociation(association, a)) {
				return a;
			}
		}
		return null;
	}

	private static boolean sameOutgoingAssociation(Association association, Association a) {
		try {
			boolean sameTarget = association.getTarget() == a.getTarget();
			boolean sameName = association.getTargetRole().equals(a.getTargetRole());
			return sameName && sameTarget && sameAssociation(association, a);
		} catch (NullPointerException e) {
			return false;
		}
	}
	
	/**
	 * Get all incoming associations of a class that look like the given association.
	 * @param c the other class
	 * @param association the original association
	 * @return a list of same associations
	 */
	public static Association getSameIncomingAssociation(Class c, Association association) {
		for (Association a : c.getOutgoingAssociations()) {
			if (sameIncomingAssociation(association, a)) {
				return a;
			}
		}
		return null;
	}

	private static boolean sameIncomingAssociation(Association association, Association a) {
		try {
			boolean sameSource = association.getSource() == a.getSource();
			boolean sameName = association.getSourceRole().equals(a.getSourceRole());
			return sameName && sameSource && sameAssociation(association, a);
		} catch (NullPointerException e) {
			return false;
		}
	}

	private static boolean sameAssociation(Association association1, Association association2) {
		try {
			boolean sameMultiplicity = ClassesHelper.getMinimumMultiplicity(association1.getTargetMultiplicity()) == ClassesHelper
				.getMinimumMultiplicity(association2.getTargetMultiplicity())
				&& ClassesHelper.getMaximumMultiplicity(association1.getTargetMultiplicity()) == ClassesHelper
					.getMaximumMultiplicity(association2.getTargetMultiplicity())
				&& ClassesHelper.getMinimumMultiplicity(association1.getSourceMultiplicity()) == ClassesHelper
					.getMinimumMultiplicity(association2.getSourceMultiplicity())
				&& ClassesHelper.getMaximumMultiplicity(association1.getSourceMultiplicity()) == ClassesHelper
					.getMaximumMultiplicity(association2.getSourceMultiplicity());
			boolean sameTransient = association1.isTransient() == association2.isTransient();
			boolean sameKind = association1.getType() == association2.getType();
			return sameMultiplicity && sameTransient && sameKind;
		} catch (NullPointerException e) {
			return false;
		}
	}
}
