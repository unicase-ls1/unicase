/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigatormeeditorbridge;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.unicase.ecp.model.ECPAssociationClassElement;
import org.unicase.ecp.model.MetaModelElementContext;
import org.unicase.ecp.model.ModelElementContext;
import org.unicase.ecp.model.NoWorkspaceException;
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.ecp.model.workSpaceModel.ECPProject;
import org.unicase.ecp.model.workSpaceModel.ECPProjectListener;
import org.unicase.ui.navigator.Activator;

/**
 * Context for the meeditor derived from the ECPProject of the navigator.
 * 
 * @author helming
 */
public class NavigatorModelelementContex extends ModelElementContext implements ECPProjectListener {
	private ECPProject project;
	private final EObject modelElement;

	/**
	 * default constructor.
	 * 
	 * @param modelElement the modelelement
	 */
	public NavigatorModelelementContex(EObject modelElement) {
		this.modelElement = modelElement;
		try {
			project = ECPWorkspaceManager.getInstance().getWorkSpace().getProject(modelElement);
			project.addECPProjectListener(this);
		} catch (NoWorkspaceException e) {
			// TODO Add second exception for no project
			Activator.getDefault().logException(e.getMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean contains(EObject eObject) {
		return project.contains(eObject);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		project.removeECPProjectListener(this);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<EObject> getAllModelElements() {
		return project.getAllModelElements();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<EObject> getAllModelElementsbyClass(EClass clazz, boolean association) {
		Collection<EObject> ret = new BasicEList<EObject>();
		for (EObject element : project.getAllModelElementsbyClass(clazz, new BasicEList<EObject>())) {
			if (association || !isAssociationClassElement(element)) {
				ret.add(element);
			}
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EditingDomain getEditingDomain() {
		try {
			return ECPWorkspaceManager.getInstance().getWorkSpace().getEditingDomain();
		} catch (NoWorkspaceException e) {
			Activator.getDefault().logException(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public MetaModelElementContext getMetaModelElementContext() {
		return project.getMetaModelElementContext();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isNonDomainElement(EObject eObject) {
		return project.isNonDomainElement(eObject);
	}

	/**
	 * {@inheritDoc}
	 */
	public void projectChanged() {
		// Do nothing

	}

	/**
	 * {@inheritDoc}
	 */
	public void modelelementDeleted(EObject eobject) {
		if (eobject.equals(modelElement)) {
			super.modelElementDeleted();
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public void projectDeleted() {
		super.contextDeleted();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isAssociationClassElement(EObject eObject) {
		return project.isAssociationClassElement(eObject);
	}

	/**
	 * {@inheritDoc}
	 */
	public ECPAssociationClassElement getAssociationClassElement(EObject eObject) {
		return project.getAssociationClassElement(eObject);
	}
}
