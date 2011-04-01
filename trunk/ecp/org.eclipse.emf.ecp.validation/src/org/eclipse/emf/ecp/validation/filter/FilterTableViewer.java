/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.validation.filter;

import java.util.ArrayList;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Composite;

/**
 * @author pfeifferc
 */
public class FilterTableViewer extends TableViewer {

	/**
	 * @param parent the
	 * @param style the
	 */
	public FilterTableViewer(Composite parent, int style) {
		super(parent, style);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.StructuredViewer#getFilteredChildren(java.lang.Object)
	 */
	@Override
	protected Object[] getFilteredChildren(Object parent) {
		return filter(getRawChildren(parent));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.StructuredViewer#filter(java.lang.Object[])
	 */
	@Override
	protected Object[] filter(Object[] elements) {
		if (getFilters() != null) {
			ArrayList<Object> filtered = new ArrayList<Object>(elements.length);
			Object root = getRoot();
			for (int i = 0; i < elements.length; i++) {
				boolean add = true;
				for (int j = 0; j < getFilters().length; j++) {
					add = (getFilters()[j]).select(this, root, elements[i]);
					if (add) {
						break;
					}
				}
				if (add) {
					filtered.add(elements[i]);
				}
			}
			return filtered.toArray();
		}
		return elements;
	}

}
