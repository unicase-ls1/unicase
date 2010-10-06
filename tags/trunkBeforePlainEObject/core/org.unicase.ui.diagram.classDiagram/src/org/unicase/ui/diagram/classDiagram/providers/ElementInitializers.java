/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.classDiagram.providers;

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
	public static void init_Association_4001(Association instance) {
		try {
			Object value_0 = org.unicase.ui.diagram.classDiagram.expressions.ModelOCLFactory
					.getExpression("AssociationType::UNDIRECTED_ASSOCIATION",
							ClassesPackage.eINSTANCE.getAssociation())
					.evaluate(instance);

			value_0 = org.unicase.ui.diagram.classDiagram.expressions.ModelAbstractExpression
					.performCast(value_0, ClassesPackage.eINSTANCE
							.getAssociationType());
			instance.setType((AssociationType) value_0);
		} catch (RuntimeException e) {
			org.unicase.ui.diagram.classDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Association_4002(Association instance) {
		try {
			Object value_0 = org.unicase.ui.diagram.classDiagram.expressions.ModelOCLFactory
					.getExpression("AssociationType::AGGREGATION",
							ClassesPackage.eINSTANCE.getAssociation())
					.evaluate(instance);

			value_0 = org.unicase.ui.diagram.classDiagram.expressions.ModelAbstractExpression
					.performCast(value_0, ClassesPackage.eINSTANCE
							.getAssociationType());
			instance.setType((AssociationType) value_0);
		} catch (RuntimeException e) {
			org.unicase.ui.diagram.classDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Association_4003(Association instance) {
		try {
			Object value_0 = org.unicase.ui.diagram.classDiagram.expressions.ModelOCLFactory
					.getExpression("AssociationType::COMPOSITION",
							ClassesPackage.eINSTANCE.getAssociation())
					.evaluate(instance);

			value_0 = org.unicase.ui.diagram.classDiagram.expressions.ModelAbstractExpression
					.performCast(value_0, ClassesPackage.eINSTANCE
							.getAssociationType());
			instance.setType((AssociationType) value_0);
		} catch (RuntimeException e) {
			org.unicase.ui.diagram.classDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Association_4004(Association instance) {
		try {
			Object value_0 = org.unicase.ui.diagram.classDiagram.expressions.ModelOCLFactory
					.getExpression("AssociationType::DIRECTED_ASSOCIATION",
							ClassesPackage.eINSTANCE.getAssociation())
					.evaluate(instance);

			value_0 = org.unicase.ui.diagram.classDiagram.expressions.ModelAbstractExpression
					.performCast(value_0, ClassesPackage.eINSTANCE
							.getAssociationType());
			instance.setType((AssociationType) value_0);
		} catch (RuntimeException e) {
			org.unicase.ui.diagram.classDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

}
