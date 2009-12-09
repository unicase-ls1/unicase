package org.unicase.implementation.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticCompositeOperation;
import org.unicase.implementation.operations.OperationsFactory;
import org.unicase.implementation.operations.PullUpOperation;
import org.unicase.implementation.operations.util.OperationHelper;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.Attribute;

public class PullUpAttributeHandler extends OperationHandlerBase {

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

		PullUpOperation operation = OperationsFactory.eINSTANCE.createPullUpOperation();
		operation.getAttributes().addAll(OperationHelper.getIds(attributes));
		operation.getOutgoingAssociations().addAll(OperationHelper.getIds(associations));

		return operation;
	}

}
