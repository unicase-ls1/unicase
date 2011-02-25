/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.util;

/**
 * This class is used for loading the implementation of classes in fragments.
 * 
 * @author stefan.bleibinhaus
 */
public final class ImplementationLoader {

	private ImplementationLoader() {

	}

	/**
	 * @param type type of class you want to load
	 * @return the implementation of that class loaded
	 */
	public static Object newInstance(@SuppressWarnings("rawtypes") final Class type) {
		String name = type.getName();
		Object result = null;
		try {
			result = type.getClassLoader().loadClass(name + "Impl").newInstance();
		} catch (ClassNotFoundException e) {
			// TODO: ChainSaw logging
			// ModelUtil.logException("Class " + name + "Impl not found.", e);
			throw new RuntimeException("Class " + name + "Impl not found.", e);
		} catch (InstantiationException e) {
			// TODO: ChainSaw logging
			// ModelUtil.logException("Could not instantiate class " + name + "Impl.", e);
			throw new RuntimeException("Could not instantiate class " + name + "Impl.", e);
		} catch (IllegalAccessException e) {
			// TODO: ChainSaw logging
			// ModelUtil.logException("Could not access class " + name + "Impl.", e);
			throw new RuntimeException("Could not access class " + name + "Impl.", e);
		}
		return result;
	}

}
