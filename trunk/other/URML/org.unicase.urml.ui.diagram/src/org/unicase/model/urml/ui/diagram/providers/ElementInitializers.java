package org.unicase.model.urml.ui.diagram.providers;

import org.unicase.model.urml.ui.diagram.expressions.UrmlAbstractExpression;
import org.unicase.model.urml.ui.diagram.expressions.UrmlOCLFactory;
import org.unicase.model.urml.ui.diagram.part.UrmlDiagramEditorPlugin;

import urml.goal.GoalPackage;
import urml.goal.GoalReference;
import urml.goal.GoalReferenceType;

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
