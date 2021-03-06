/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecpemfstorebridge;

import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.ui.common.MetaModelElementContext;

/**
 * {@link MetaModelElementContext} for the EMFStore.
 * 
 * @author helming
 */
public class EMFStoreMetaModelElementContext extends MetaModelElementContext {

	private static MetaModelElementContext instance;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.MetaModelElementContext#getAllModelElementEClassesImpl()
	 */
	@Override
	public Set<EClass> getAllModelElementEClassesImpl() {
		return ModelUtil.getAllModelElementEClasses();
	}

	/**
	 * Singleton.
	 * 
	 * @return the instance
	 */
	public static MetaModelElementContext getInstance() {
		if (instance == null) {
			instance = new EMFStoreMetaModelElementContext();
		}
		return instance;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.MetaModelElementContext#isAssociationClassElement(org.eclipse.emf.ecore.EClass)
	 */
	@Override
	public boolean isAssociationClassElement(EClass eClazz) {
		return ModelUtil.isAssociationClassElement(eClazz);
	}
}
