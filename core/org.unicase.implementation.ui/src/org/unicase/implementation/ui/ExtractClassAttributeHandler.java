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
import org.unicase.implementation.operations.ExtractClassOperation;
import org.unicase.implementation.operations.OperationsFactory;
import org.unicase.implementation.operations.util.OperationHelper;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.Attribute;
import org.unicase.model.classes.Package;

/**
 * Handler for {@link ExtractClassOperation} when several attributes and associations to be extracted are selected.
 * 
 * @author herrmi
 */
public class ExtractClassAttributeHandler extends OperationHandlerBase {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected SemanticCompositeOperation initOperation(IStructuredSelection structuredSelection) {
		List<UnicaseModelElement> elements = SelectionHelper.getSelectedElements(structuredSelection);
		List<Attribute> attributes = new ArrayList<Attribute>();
		List<Association> associations = new ArrayList<Association>();

		org.unicase.model.classes.Class contextClass = null;
		for (UnicaseModelElement element : elements) {
			if (element instanceof Attribute) {
				Attribute attribute = (Attribute) element;
				attributes.add(attribute);
				if (contextClass == null) {
					contextClass = attribute.getDefiningClass();
				}
			} else {
				Association association = (Association) element;
				associations.add(association);
				if (contextClass == null) {
					contextClass = association.getSource();
				}
			}
		}

		ExtractClassOperation operation = OperationsFactory.eINSTANCE.createExtractClassOperation();
		operation.getAttributes().addAll(OperationHelper.getIds(attributes));
		operation.getOutgoingAssociations().addAll(OperationHelper.getIds(associations));
		if (contextClass != null) {
			operation.setContextClass(OperationHelper.getId(contextClass));
			Package targetPackage = contextClass.getParentPackage();
			if (targetPackage != null) {
				operation.setTargetPackage(OperationHelper.getId(targetPackage));
			}
		}

		return operation;
	}

}
