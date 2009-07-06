package org.unicase.ui.tom.classDiagram.edit.policies;

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
public class ClassClassNode_methodsCanonicalEditPolicy extends
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
		for (Iterator it = org.unicase.ui.tom.classDiagram.part.ModelDiagramUpdater
				.getClassClassNode_methods_7002SemanticChildren(viewObject)
				.iterator(); it.hasNext();) {
			result
					.add(((org.unicase.ui.tom.classDiagram.part.ModelNodeDescriptor) it
							.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = org.unicase.ui.tom.classDiagram.part.ModelVisualIDRegistry
				.getVisualID(view);
		switch (visualID) {
		case org.unicase.ui.tom.classDiagram.edit.parts.MethodEditPart.VISUAL_ID:
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
					.getClass_Methods());
		}
		return myFeaturesToSynchronize;
	}

}
