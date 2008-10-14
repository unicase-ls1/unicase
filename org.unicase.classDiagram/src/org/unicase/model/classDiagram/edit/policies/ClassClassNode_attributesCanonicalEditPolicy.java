package org.unicase.model.classDiagram.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.classes.ClassesPackage;

/**
 * @generated
 */
public class ClassClassNode_attributesCanonicalEditPolicy extends
		CanonicalEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		List result = new LinkedList();
		for (Iterator it = org.unicase.model.classDiagram.part.ModelDiagramUpdater
				.getClassClassNode_attributes_7001SemanticChildren(viewObject)
				.iterator(); it.hasNext();) {
			result
					.add(((org.unicase.model.classDiagram.part.ModelNodeDescriptor) it
							.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = org.unicase.model.classDiagram.part.ModelVisualIDRegistry
				.getVisualID(view);
		switch (visualID) {
		case org.unicase.model.classDiagram.edit.parts.AttributeEditPart.VISUAL_ID:
			if (!semanticChildren.contains(view.getElement())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(ClassesPackage.eINSTANCE
					.getClass_Attributes());
		}
		return myFeaturesToSynchronize;
	}

}
