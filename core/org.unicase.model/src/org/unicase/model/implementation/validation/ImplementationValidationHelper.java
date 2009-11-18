/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.implementation.validation;

import java.util.ArrayList;
import java.util.List;

import org.unicase.model.implementation.IAttribute;
import org.unicase.model.implementation.IClass;
import org.unicase.model.implementation.IFeature;

/**
 * Helper for implementation validation.
 * 
 * @author herrmama
 */
public final class ImplementationValidationHelper {

	private ImplementationValidationHelper() {
		// this class should not be instantiated
	}

	/**
	 * Get all super classes of a class.
	 * 
	 * @param c Class
	 * @return Super classes
	 */
	public static List<IClass> getAllSuperClasses(IClass c) {
		List<IClass> superClasses = new ArrayList<IClass>();
		collectAllSuperClasses(c, superClasses);
		return superClasses;
	}

	private static void collectAllSuperClasses(IClass c, List<IClass> superClasses) {
		superClasses.addAll(c.getSuperClasses());
		for (IClass s : c.getSuperClasses()) {
			if (!superClasses.contains(s)) {
				collectAllSuperClasses(s, superClasses);
			}
		}
	}

	/**
	 * Get all features of a class.
	 * 
	 * @param clazz Class
	 * @return Features
	 */
	public static List<IFeature> getAllFeatures(IClass clazz) {
		List<IClass> classes = ImplementationValidationHelper.getAllSuperClasses(clazz);
		classes.add(clazz);
		List<IFeature> features = new ArrayList<IFeature>();
		for (IClass c : classes) {
			features.addAll(c.getAttributes());
			features.addAll(c.getOutgoingReferences());
		}
		return features;
	}

	/**
	 * Get all attributes of a clazz.
	 * 
	 * @param clazz Class
	 * @return Attributes
	 */
	public static List<IAttribute> getAllAttributes(IClass clazz) {
		List<IClass> classes = ImplementationValidationHelper.getAllSuperClasses(clazz);
		classes.add(clazz);
		List<IAttribute> attributes = new ArrayList<IAttribute>();
		for (IClass c : classes) {
			attributes.addAll(c.getAttributes());
		}
		return attributes;
	}
}
