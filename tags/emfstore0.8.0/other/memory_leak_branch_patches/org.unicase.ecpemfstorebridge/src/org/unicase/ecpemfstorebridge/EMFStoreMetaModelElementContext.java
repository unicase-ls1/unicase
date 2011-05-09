/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecpemfstorebridge;

import org.eclipse.emf.ecore.EClass;
import org.unicase.ecp.model.MetaModelElementContext;
import org.unicase.metamodel.NonDomainElement;
import org.unicase.metamodel.util.ModelUtil;

/**
 * {@link MetaModelElementContext} for the EMFStore.
 * 
 * @author helming
 */
public class EMFStoreMetaModelElementContext extends MetaModelElementContext {

	private static MetaModelElementContext instance;

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
	 * @see org.unicase.ecp.model.MetaModelElementContext#isAssociationClassElement(org.eclipse.emf.ecore.EClass)
	 */
	@Override
	public boolean isAssociationClassElement(EClass eClazz) {
		return ModelUtil.isAssociationClassElement(eClazz);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ecp.model.MetaModelElementContext#isNonDomainElement(org.eclipse.emf.ecore.EClass)
	 */
	@Override
	public boolean isNonDomainElement(EClass eClass) {
		return eClass instanceof NonDomainElement;
	}
}
