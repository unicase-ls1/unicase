/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticCompositeOperation;
import org.unicase.implementation.operations.OperationsFactory;
import org.unicase.implementation.operations.PushDownOperation;
import org.unicase.implementation.operations.util.OperationHelper;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.Attribute;
import org.unicase.model.classes.Class;


/**
 * Handler for {@link PushDownOperation}.
 * 
 * @author herrmi
 */
public class PushDownAttributeHandler extends OperationHandlerBase {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected SemanticCompositeOperation initOperation(IStructuredSelection structuredSelection) {
		List<UnicaseModelElement> elements = SelectionHelper.getSelectedElements(structuredSelection);
		List<Attribute> attributes = new ArrayList<Attribute>();
		List<Association> associations = new ArrayList<Association>();

		for (UnicaseModelElement element : elements) {
			if (element instanceof Attribute) {
				Attribute attribute = (Attribute) element;
				attributes.add(attribute);
			} else {
				Association association = (Association) element;
				associations.add(association);
			}
		}
		
		Class superClass = null;
		if(!attributes.isEmpty()) {
			superClass = attributes.get(0).getDefiningClass();
		} else {
			superClass = associations.get(0).getSource();
		}
		
		PushDownOperation operation = OperationsFactory.eINSTANCE.createPushDownOperation();
		operation.setSuperClass(OperationHelper.getId(superClass));
		operation.getAttributes().addAll(OperationHelper.getIds(attributes));
		operation.getOutgoingAssociations().addAll(OperationHelper.getIds(associations));

		return operation;
	}

}
