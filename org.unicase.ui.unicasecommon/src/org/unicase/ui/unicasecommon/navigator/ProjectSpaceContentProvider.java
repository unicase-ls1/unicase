/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecp.core.ECPProvider;
import org.eclipse.emf.ecp.core.util.ECPUtil;
import org.eclipse.emf.ecp.internal.ui.model.TreeContentProvider;
import org.eclipse.emf.ecp.spi.core.util.InternalChildrenList;
import org.eclipse.emf.emfstore.internal.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.internal.common.model.Project;

/**
 * Shows the project as orphans folder.
 * 
 * @author helming
 */
public class ProjectSpaceContentProvider extends TreeContentProvider {
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
		EList<EObject> modelElements = project.getModelElementsByClass(
				EcoreFactory.eINSTANCE.createEObject().eClass(),
				new BasicEList<EObject>());
		// FIXME: ugly hack to avoid dependency to model
		for (EObject modelElement : modelElements) {
			EObject econtainer = modelElement.eContainer();
			if ((econtainer instanceof Project)
					&& modelElement.eClass().getName()
							.equals("CompositeSection")) {
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

	@Override
	protected void fillChildren(Object parent, InternalChildrenList childrenList) {
		if (parent == ECPUtil.getECPProviderRegistry()) {
			final Collection<ECPProvider> providers = ECPUtil
					.getECPProviderRegistry().getProviders();
			for (final ECPProvider provider : providers) {
				if (provider.hasCreateRepositorySupport()) {
					childrenList.addChild(provider);
				}
			}
		}
	}

}
