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
package org.eclipse.emf.emfstore.client.transaction;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.emfstore.client.model.util.EditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl.FactoryImpl;

/**
 * Transactional EditingDomain provider for the EMFStore.
 * 
 * @author wesendon
 */
public class TransactionalEditingDomainProvider implements EditingDomainProvider {

	private static final String TRANSACTIONAL_EDITINGDOMAIN_ID = "org.eclipse.emf.emfstore.EditingDomain";

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.util.EditingDomainProvider#getEditingDomain(org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public EditingDomain getEditingDomain(ResourceSet resourceSet) {
		TransactionalEditingDomain domain = new TransactionalEditingDomainImpl(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE), new EMFStoreTransactionalCommandStack(), resourceSet);
		((FactoryImpl) TransactionalEditingDomain.Factory.INSTANCE).mapResourceSet(domain);
		TransactionalEditingDomain.Registry.INSTANCE.add(TRANSACTIONAL_EDITINGDOMAIN_ID, domain);
		domain.setID(TRANSACTIONAL_EDITINGDOMAIN_ID);
		return domain;
	}

}
