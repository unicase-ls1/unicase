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
import org.unicase.ui.common.MetaModelElementContext;
import org.unicase.ui.common.ModelElementContext;
import org.unicase.ui.navigator.Activator;
import org.unicase.ui.navigator.NoWorkspaceException;
import org.unicase.ui.navigator.WorkspaceManager;
import org.unicase.ui.navigator.workSpaceModel.ECPProject;

/**
 * Context for the meeditor derived from the ECPProject of the navigator.
 * 
 * @author helming
 */
public class NavigatorModelelementContex extends ModelElementContext {
	private ECPProject project;

	/**
	 * default constructor.
	 * 
	 * @param modelElement the modelelement
	 */
	public NavigatorModelelementContex(EObject modelElement) {
		try {
			project = WorkspaceManager.getInstance().getWorkSpace().getProject(modelElement);
		} catch (NoWorkspaceException e) {
			// TODO Add second exception for no project
			Activator.logException(e);
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
		// TODO: remove listeners.

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<EObject> getAllModelElements() {
		// TODO Auto-generated method stub
		return project.getAllModelElement();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<EObject> getAllModelElementsbyClass(EClass clazz, BasicEList<EObject> basicEList) {
		// TODO Auto-generated method stub
		return project.getAllModelElementsbyClass(clazz, basicEList);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EditingDomain getEditingDomain() {
		try {
			return WorkspaceManager.getInstance().getWorkSpace().getEditingDomain();
		} catch (NoWorkspaceException e) {
			Activator.logException(e);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
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

}
