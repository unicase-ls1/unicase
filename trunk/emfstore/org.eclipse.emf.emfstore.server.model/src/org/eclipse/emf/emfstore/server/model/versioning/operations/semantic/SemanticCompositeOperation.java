/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.operations.semantic;

import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Composite Operation</b></em>'. <!-- end-user-doc
 * -->
 * 
 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.SemanticPackage#getSemanticCompositeOperation()
 * @model abstract="true"
 * @generated
 */
public interface SemanticCompositeOperation extends CompositeOperation {

	/**
	 * Apply the operation semantically on the given project. This means that the context of the operation is
	 * reevaluated for the given project.
	 * 
	 * @param project the project to apply the operation on.
	 */
	public void semanticApply(Project project);
} // SemanticCompositeOperation
