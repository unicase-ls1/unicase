/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecp.navigator.ContentProvider;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.common.model.Project;

/**
 * Shows the project as orphans folder.
 * 
 * @author helming
 */
public class ProjectSpaceContentProvider implements ContentProvider {
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecp.navigator.ContentProvider#getChildren(EObject)
	 */
	public Collection<?> getChildren(EObject rootObject) {
		ProjectSpace projectSpace;
		if (rootObject instanceof ProjectSpace) {
			projectSpace = (ProjectSpace) rootObject;
		} else {
			return Collections.EMPTY_LIST;
		}

		final Project project = projectSpace.getProject();
		if (project == null) {
			return Collections.EMPTY_LIST;
		}

		Collection<EObject> ret = new ArrayList<EObject>();
		EList<EObject> modelElements = project.getModelElementsByClass(EcoreFactory.eINSTANCE.createEObject().eClass(),
			new BasicEList<EObject>());
		// FIXME: ugly hack to avoid dependency to model
		for (EObject modelElement : modelElements) {
			EObject econtainer = modelElement.eContainer();
			if ((econtainer instanceof Project) && modelElement.eClass().getName().equals("CompositeSection")) {
				ret.add(modelElement);
			}
		}
		ret.add(project);
		return ret;

	}

	/**
	 * Always true since thre is the orphasn folder. {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecp.navigator.ContentProvider#hasChildren(EObject)
	 */
	public boolean hasChildren(EObject rootObject) {
		return true;
	}

}
