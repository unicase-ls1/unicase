/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classes.validation;

import java.util.ArrayList;
import java.util.List;

import org.unicase.model.classes.Association;
import org.unicase.model.classes.AssociationType;
import org.unicase.model.classes.Attribute;
import org.unicase.model.classes.Class;

/**
 * Helper for implementation validation.
 * 
 * @author herrmi
 */
public final class ClassesHelper {

	private ClassesHelper() {
		// this class should not be instantiated
	}

	/**
	 * Get all super classes of a class.
	 * 
	 * @param c Class
	 * @return Super classes
	 */
	public static List<Class> getAllSuperClasses(Class c) {
		List<Class> superClasses = new ArrayList<Class>();
		collectAllSuperClasses(c, superClasses);
		return superClasses;
	}

	private static void collectAllSuperClasses(Class c, List<Class> superClasses) {
		superClasses.addAll(c.getSuperClasses());
		for (Class s : c.getSuperClasses()) {
			if (!superClasses.contains(s)) {
				collectAllSuperClasses(s, superClasses);
			}
		}
	}

	/**
	 * Get all attributes of a clazz.
	 * 
	 * @param clazz Class
	 * @return Attributes
	 */
	public static List<Attribute> getAllAttributes(Class clazz) {
		List<Class> classes = ClassesHelper.getAllSuperClasses(clazz);
		classes.add(clazz);
		List<Attribute> attributes = new ArrayList<Attribute>();
		for (Class c : classes) {
			attributes.addAll(c.getAttributes());
		}
		return attributes;
	}

	/**
	 * Get all outgoing associations of a class.
	 * 
	 * @param clazz Class
	 * @return Associations
	 */
	public static List<Association> getAllOutgoingAssociations(Class clazz) {
		List<Class> classes = ClassesHelper.getAllSuperClasses(clazz);
		classes.add(clazz);
		List<Association> associations = new ArrayList<Association>();
		for (Class c : classes) {
			associations.addAll(c.getOutgoingAssociations());
		}
		return associations;
	}

	/**
	 * Get all incoming associations of a class.
	 * 
	 * @param clazz Class
	 * @return Associations
	 */
	public static List<Association> getAllIncomingAssociations(Class clazz) {
		List<Class> classes = ClassesHelper.getAllSuperClasses(clazz);
		classes.add(clazz);
		List<Association> associations = new ArrayList<Association>();
		for (Class c : classes) {
			for (Association a : c.getIncomingAssociations()) {
				if (a.getType() != AssociationType.DIRECTED_ASSOCIATION) {
					associations.add(a);
				}
			}
		}
		return associations;
	}

	/**
	 * Parse multiplicities from a string.
	 * 
	 * @param multiplicityText the string
	 * @return a parse result
	 */
	public static MultiplicityParseResult parseMultiplicity(String multiplicityText) {
		try {
			int parseInt = Integer.parseInt(multiplicityText);
			MultiplicityParseResult result = new MultiplicityParseResult(parseInt, parseInt, true);
			return result;
		} catch (NumberFormatException e) {
			// continue
		}
		String[] strings = multiplicityText.split(",,");

		if (strings.length > 1) {
			int minimumMultiplicity;
			int maximumMultiplicity;
			boolean successfullParse = (strings.length == 2);
			try {
				minimumMultiplicity = Integer.parseInt(strings[0]);
			} catch (NumberFormatException e) {
				minimumMultiplicity = 0;
				successfullParse = false;
			}
			try {
				maximumMultiplicity = Integer.parseInt(strings[1]);
			} catch (NumberFormatException e) {
				maximumMultiplicity = -1;
				successfullParse = false;
			}
			MultiplicityParseResult result = new MultiplicityParseResult(minimumMultiplicity, maximumMultiplicity,
				successfullParse);
			return result;
		}
		return new MultiplicityParseResult(0, -1, false);
	}

	/**
	 * Get the minimum multiplicity from a multiplicity string.
	 * 
	 * @param multiplicityText the string
	 * @return the minimum multiplicity
	 */
	public static int getMinimumMultiplicity(String multiplicityText) {
		MultiplicityParseResult multiplicity = parseMultiplicity(multiplicityText);
		return multiplicity.getMinimumMultiplicity();
	}

	/**
	 * Get the maximum multiplicity from a multiplicity string.
	 * 
	 * @param multiplicityText the string
	 * @return the maximum multiplicity
	 */
	public static int getMaximumMultiplicity(String multiplicityText) {
		MultiplicityParseResult multiplicity = parseMultiplicity(multiplicityText);
		return multiplicity.getMaximumMultiplicity();
	}

}
