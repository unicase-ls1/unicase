/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.common;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * @author Hodaie LabelProvider for TreeViewer that is shown on ModelTreePage
 */
public class MEClassLabelProvider extends AdapterFactoryLabelProvider {

	/**
	 * Constructor.
	 */
	public MEClassLabelProvider() {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	}

	/**
	 * . ({@inheritDoc}) If argument is instance of EClass then return its display name.
	 */
	@Override
	public String getText(Object object) {
		if (object instanceof EPackage) {
			return super.getText(object);
		}
		if (object instanceof EClass) {
			return ((EClass) object).getName();
		}
		return "";
	}

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	public Image getImage(Object object) {
		if (object instanceof EClass) {
			EClass eClass = (EClass) object;
			EPackage ePackage = eClass.getEPackage();
			if (!eClass.isAbstract() && !eClass.isInterface()) {
				EObject newMEInstance = ePackage.getEFactoryInstance().create(eClass);
				return super.getImage(newMEInstance);
			} else {
				return super.getImage(object);
			}

		}
		return super.getImage(object);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getColumnImage(Object object, int columnIndex) {
		if (columnIndex == 0) {
			return getImage(object);
		} else {
			return super.getImage(object);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getColumnText(Object object, int columnIndex) {
		if (columnIndex == 0) {
			return getText(object);
		} else {
			return super.getText(object);
		}
	}

}
