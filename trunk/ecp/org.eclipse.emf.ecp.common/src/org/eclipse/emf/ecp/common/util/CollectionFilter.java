/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author schroech
 */
public final class CollectionFilter {

	private CollectionFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param <T> The classType to filter for
	 * @param objects The objects to be filtered
	 * @param classType The classType to filter for
	 * @return A filtered {@link Collection}
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> filter(@SuppressWarnings("rawtypes") Collection objects, java.lang.Class<T> classType) {
		List<T> filteredObjects = new ArrayList<T>();
		for (Object object : objects) {
			if (classType.isInstance(object)) {
				filteredObjects.add((T) object);
			}
		}
		return filteredObjects;
	}
}
