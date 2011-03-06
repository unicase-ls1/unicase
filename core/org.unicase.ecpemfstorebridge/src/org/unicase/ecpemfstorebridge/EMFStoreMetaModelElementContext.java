/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecpemfstorebridge;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.unicase.ecp.model.AbstractECPMetaModelElementContext;
import org.unicase.ecp.model.ECPAssociationClassElement;
import org.unicase.ecp.model.ECPMetaModelElementContext;
import org.unicase.metamodel.AssociationClassElement;
import org.unicase.metamodel.NonDomainElement;
import org.unicase.metamodel.util.ModelUtil;

/**
 * {@link AbstractECPMetaModelElementContext} for the EMFStore.
 * 
 * @author helming
 */
public class EMFStoreMetaModelElementContext extends AbstractECPMetaModelElementContext {

	private static ECPMetaModelElementContext instance;

	/**
	 * Singleton.
	 * 
	 * @return the instance
	 */
	public static ECPMetaModelElementContext getInstance() {
		if (instance == null) {
			instance = new EMFStoreMetaModelElementContext();
		}
		return instance;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ecp.model.ECPMetaModelElementContext#isAssociationClassElement(org.eclipse.emf.ecore.EClass)
	 */
	public boolean isAssociationClassElement(EClass eClazz) {
		return ModelUtil.isAssociationClassElement(eClazz);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ecp.model.workSpaceModel.ECPProject#getAssociationClassElement(org.eclipse.emf.ecore.EObject)
	 */
	public ECPAssociationClassElement getAssociationClassElement(EObject eObject) {

		if (isAssociationClassElement(eObject)) {
			AssociationClassElement ace = (AssociationClassElement) eObject;
			return new ECPAssociationClassElement(ace.getSourceFeature(), ace.getTargetFeature(), ace
				.getAssociationFeatures());
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ecp.model.ECPMetaModelElementContext#isAssociationClassElement(org.eclipse.emf.ecore.EObject)
	 */
	public boolean isAssociationClassElement(EObject eObject) {
		return isAssociationClassElement(eObject.eClass());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ecp.model.AbstractECPMetaModelElementContext#isNonDomainElement(org.eclipse.emf.ecore.EClass)
	 */
	@Override
	public boolean isNonDomainElement(EClass eClass) {
		return eClass instanceof NonDomainElement;
	}
}
