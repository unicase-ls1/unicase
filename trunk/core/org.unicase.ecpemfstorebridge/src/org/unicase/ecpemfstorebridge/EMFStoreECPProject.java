/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecpemfstorebridge;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.widgets.Display;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.NonDomainElement;
import org.unicase.ui.common.MetaModelElementContext;
import org.unicase.ui.navigator.workSpaceModel.ECPProject;
import org.unicase.ui.navigator.workSpaceModel.impl.ECPProjectImpl;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.observers.SimpleOperationListener;

/**
 * ECPproject for the EMFStore.
 * 
 * @author helming
 */
public class EMFStoreECPProject extends ECPProjectImpl implements ECPProject {

	private final ProjectSpace projectSpace;
	private SimpleOperationListener simpleOperationListener;

	/**
	 * Default constructor.
	 * 
	 * @param projectSpace the projectspace
	 */
	public EMFStoreECPProject(ProjectSpace projectSpace) {
		this.projectSpace = projectSpace;
		simpleOperationListener = new SimpleOperationListener() {

			@Override
			public void operationPerformed(AbstractOperation operation) {
				Display.getDefault().asyncExec(new Runnable() {

					public void run() {
						projectChanged();
					}

				});
			}

		};
		projectSpace.addOperationListener(simpleOperationListener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.ECPModelelementContext#getAllModelElements()
	 */
	public Collection<EObject> getAllModelElements() {
		ArrayList<EObject> ret = new ArrayList<EObject>();
		ret.addAll(projectSpace.getProject().getAllModelElements());
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.ECPModelelementContext#getEditingDomain()
	 */
	public EditingDomain getEditingDomain() {
		return Configuration.getEditingDomain();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.navigator.workSpaceModel.ECPProject#contains(org.eclipse.emf.ecore.EObject)
	 */
	public boolean contains(EObject eObject) {
		return (((ModelElement) eObject).getProject().equals(projectSpace.getProject()));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.navigator.workSpaceModel.ECPProject#getAllModelElement()
	 */
	public Collection<EObject> getAllModelElement() {
		Collection<EObject> ret = new BasicEList<EObject>();
		ret.addAll(projectSpace.getProject().getAllModelElements());
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.navigator.workSpaceModel.ECPProject#getAllModelElementsbyClass(org.eclipse.emf.ecore.EClass,
	 *      org.eclipse.emf.common.util.BasicEList)
	 */
	public Collection<EObject> getAllModelElementsbyClass(EClass clazz, BasicEList<EObject> basicEList) {
		Collection<EObject> ret = new BasicEList<EObject>();
		ret.addAll(projectSpace.getProject().getAllModelElementsbyClass(clazz, new BasicEList<ModelElement>()));
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.navigator.workSpaceModel.ECPProject#getMetaModelElementContext()
	 */
	public MetaModelElementContext getMetaModelElementContext() {
		return EMFStoreMetaModelElementContext.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.navigator.workSpaceModel.ECPProject#isNonDomainElement(org.eclipse.emf.ecore.EObject)
	 */
	public boolean isNonDomainElement(EObject eObject) {
		return (eObject instanceof NonDomainElement);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.navigator.workSpaceModel.ECPProject#getRootObject()
	 */
	public EObject getRootObject() {
		return projectSpace;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.navigator.workSpaceModel.ECPProject#dispose()
	 */
	public void dispose() {
		projectSpace.removeOperationListener(simpleOperationListener);

	}

}
