/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.ModelElement;

/**
 * Implementation of an XMI Resource that will ignore the id attributes of EMFStore {@link ModelElement}s.
 * 
 * @author koegel
 */
public class EMFStoreXMIResourceImpl extends XMIResourceImpl {

	private static final EClass MODEL_ELEMENT_ECLASS = MetamodelPackage.eINSTANCE.getModelElement();

	/**
	 * Default Construtor.
	 */
	public EMFStoreXMIResourceImpl() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param uri URI
	 */
	public EMFStoreXMIResourceImpl(URI uri) {
		super(uri);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl#getURIFragment(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public String getURIFragment(EObject eObject) {
		String uriFragment;
		if (MODEL_ELEMENT_ECLASS.isInstance(eObject)) {
			ModelElement modelElement = (ModelElement) eObject;
			// save old values
			boolean deliveryMode = modelElement.eDeliver();
			String id = modelElement.getIdentifier();

			// turn off notification delivery and set id to null
			modelElement.eSetDeliver(false);
			modelElement.setIdentifier(null);

			// retrieve fragment when id is set to null
			uriFragment = super.getURIFragment(eObject);

			// restore old values and delivery mode
			modelElement.setIdentifier(id);
			modelElement.eSetDeliver(deliveryMode);
		} else {
			uriFragment = super.getURIFragment(eObject);
		}
		return uriFragment;
	}

}
