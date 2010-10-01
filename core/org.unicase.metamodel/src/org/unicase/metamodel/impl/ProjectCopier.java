/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel.impl;

import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;

/**
 * @author emueller
 */
public class ProjectCopier extends Copier {

	private Project orgProject;
	private ProjectImpl copiedProject;
	private HashMap<EObject, ModelElementId> eObjectToIdMap;
	private HashMap<ModelElementId, EObject> idToEObjectMap;

	public ProjectCopier() {
		eObjectToIdMap = new HashMap<EObject, ModelElementId>();
		idToEObjectMap = new HashMap<ModelElementId, EObject>();
	}

	@Override
	public EObject copy(EObject eObject) {
		if (eObject instanceof Project) {
			orgProject = (Project) eObject;
		}
		EObject copiedEObject = super.copy(eObject);

		if (copiedEObject instanceof Project) {
			// TODO: PlainEObjectMode, make sure that project is really returned as the last element
			copiedProject = (ProjectImpl) copiedEObject;
			copiedProject.initCaches(eObjectToIdMap, idToEObjectMap);
			return copiedProject;
		}

		ModelElementId eObjectId = orgProject.getModelElementId(eObject);
		eObjectToIdMap.put(copiedEObject, eObjectId);
		idToEObjectMap.put(eObjectId, copiedEObject);

		return copiedEObject;
	}
}
