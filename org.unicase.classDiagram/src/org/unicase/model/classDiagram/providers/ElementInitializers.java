package org.unicase.model.classDiagram.providers;

import org.unicase.model.classes.Association;
import org.unicase.model.classes.AssociationType;
import org.unicase.model.classes.ClassesPackage;

/**
 * @generated
 */
public class ElementInitializers {

	/**
	 * @generated
	 */
	public static void init_Association_3001(Association instance) {
		try {
			Object value0 = org.unicase.model.classDiagram.expressions.ModelOCLFactory
					.getExpression("AssociationType::UNDIRECTED_ASSOCIATION",
							ClassesPackage.eINSTANCE.getAssociation())
					.evaluate(instance);

			value0 = org.unicase.model.classDiagram.expressions.ModelAbstractExpression
					.performCast(value0, ClassesPackage.eINSTANCE
							.getAssociationType());
			instance.setType((AssociationType) value0);
		} catch (RuntimeException e) {
			org.unicase.model.classDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Association_3002(Association instance) {
		try {
			Object value0 = org.unicase.model.classDiagram.expressions.ModelOCLFactory
					.getExpression("AssociationType::AGGREGATION",
							ClassesPackage.eINSTANCE.getAssociation())
					.evaluate(instance);

			value0 = org.unicase.model.classDiagram.expressions.ModelAbstractExpression
					.performCast(value0, ClassesPackage.eINSTANCE
							.getAssociationType());
			instance.setType((AssociationType) value0);
		} catch (RuntimeException e) {
			org.unicase.model.classDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

}
