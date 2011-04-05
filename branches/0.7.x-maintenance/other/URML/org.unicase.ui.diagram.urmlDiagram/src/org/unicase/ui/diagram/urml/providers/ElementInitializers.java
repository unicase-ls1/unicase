package org.unicase.ui.diagram.urml.providers;

import org.unicase.model.urml.goal.GoalPackage;
import org.unicase.model.urml.goal.GoalReference;
import org.unicase.model.urml.goal.GoalReferenceType;
import org.unicase.ui.diagram.urml.expressions.UrmlAbstractExpression;
import org.unicase.ui.diagram.urml.expressions.UrmlOCLFactory;
import org.unicase.ui.diagram.urml.part.UrmlDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {
	/**
	 * @generated
	 */
	public static void init_GoalReference_4016(GoalReference instance) {
		try {
			Object value_0 = UrmlOCLFactory.getExpression("GoalReferenceType::PLUS_PLUS",
				GoalPackage.eINSTANCE.getGoalReference()).evaluate(instance);

			value_0 = UrmlAbstractExpression.performCast(value_0, GoalPackage.eINSTANCE.getGoalReferenceType());
			instance.setWeight((GoalReferenceType) value_0);
		} catch (RuntimeException e) {
			UrmlDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_GoalReference_4023(GoalReference instance) {
		try {
			Object value_0 = UrmlOCLFactory.getExpression("GoalReferenceType::PLUS",
				GoalPackage.eINSTANCE.getGoalReference()).evaluate(instance);

			value_0 = UrmlAbstractExpression.performCast(value_0, GoalPackage.eINSTANCE.getGoalReferenceType());
			instance.setWeight((GoalReferenceType) value_0);
		} catch (RuntimeException e) {
			UrmlDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_GoalReference_4024(GoalReference instance) {
		try {
			Object value_0 = UrmlOCLFactory.getExpression("GoalReferenceType::MINUS",
				GoalPackage.eINSTANCE.getGoalReference()).evaluate(instance);

			value_0 = UrmlAbstractExpression.performCast(value_0, GoalPackage.eINSTANCE.getGoalReferenceType());
			instance.setWeight((GoalReferenceType) value_0);
		} catch (RuntimeException e) {
			UrmlDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_GoalReference_4025(GoalReference instance) {
		try {
			Object value_0 = UrmlOCLFactory.getExpression("GoalReferenceType::MINUS_MINUS",
				GoalPackage.eINSTANCE.getGoalReference()).evaluate(instance);

			value_0 = UrmlAbstractExpression.performCast(value_0, GoalPackage.eINSTANCE.getGoalReferenceType());
			instance.setWeight((GoalReferenceType) value_0);
		} catch (RuntimeException e) {
			UrmlDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

}
