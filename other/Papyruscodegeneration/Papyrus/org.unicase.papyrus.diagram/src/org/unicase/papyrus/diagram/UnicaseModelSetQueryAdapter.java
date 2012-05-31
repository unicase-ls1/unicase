/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.diagram;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.papyrus.core.modelsetquery.impl.ModelSetQueryAdapter;

/**
 * A {@link ModelSetQueryAdapter} that only returns EObjects as reachable objects, that are in the same project as the
 * EObject in question.
 * 
 * @author mharut
 */
public class UnicaseModelSetQueryAdapter extends ModelSetQueryAdapter {

	/**
	 * {@inheritDoc}
	 */
	public Collection<EObject> getReachableObjectsOfType(EObject object, EClassifier type) {
		Project project = ModelUtil.getProject(object);
		EList<EObject> result = new BasicEList<EObject>();
		if (type instanceof EClass) {
			project.getAllModelElementsbyClass((EClass) type, result);
		}
		return result;

	}

}
