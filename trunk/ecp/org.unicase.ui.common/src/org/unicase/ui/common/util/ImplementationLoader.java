/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.unicase.ui.common.util;

import org.unicase.ui.common.Activator;

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
			// TODO: ChainSaw logging done
			String msgException = "Class " + name + "Impl not found.";
			Activator.getDefault().logException(msgException, e);
			throw new RuntimeException(msgException, e);
		} catch (InstantiationException e) {
			// TODO: ChainSaw logging done
			String msgException = "Could not instantiate class " + name + "Impl.";
			Activator.getDefault().logException(msgException, e);
			throw new RuntimeException(msgException, e);
		} catch (IllegalAccessException e) {
			// TODO: ChainSaw logging done
			String msgException = "Could not access class " + name + "Impl.";
			Activator.getDefault().logException(msgException, e);
			throw new RuntimeException(msgException, e);
		}
		return result;
	}

}
