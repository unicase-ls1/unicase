package org.unicase.model.classDiagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.MEDiagram;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented by
 * a domain model object.
 * 
 * @generated
 */
public class ModelVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.unicase.classDiagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static org.unicase.model.classDiagram.expressions.ModelAbstractExpression Association_3001_Constraint;
	/**
	 * @generated
	 */
	private static org.unicase.model.classDiagram.expressions.ModelAbstractExpression Association_3002_Constraint;

	/**
	 * @generated
	 */
	private static org.unicase.model.classDiagram.expressions.ModelAbstractExpression Association_3004_Constraint;

	/**
	 * @generated
	 */
	private static org.unicase.model.classDiagram.expressions.ModelAbstractExpression Association_3003_Constraint;

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
					.equals(view.getType())) {
				return org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.unicase.model.classDiagram.part.ModelVisualIDRegistry
				.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				org.unicase.model.classDiagram.part.ModelDiagramEditorPlugin
						.getInstance().logError(
								"Unable to parse view type as a visualID number: "
										+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (DiagramPackage.eINSTANCE.getMEDiagram().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((MEDiagram) domainElement)) {
			return org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = org.unicase.model.classDiagram.part.ModelVisualIDRegistry
				.getModelID(containerView);
		if (!org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
				.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
				.equals(containerModelID)) {
			containerVisualID = org.unicase.model.classDiagram.part.ModelVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case org.unicase.model.classDiagram.edit.parts.ClassClassNode_attributesEditPart.VISUAL_ID:
			if (ClassesPackage.eINSTANCE.getAttribute().isSuperTypeOf(
					domainElement.eClass())) {
				return org.unicase.model.classDiagram.edit.parts.AttributeEditPart.VISUAL_ID;
			}
			break;
		case org.unicase.model.classDiagram.edit.parts.ClassClassNode_methodsEditPart.VISUAL_ID:
			if (ClassesPackage.eINSTANCE.getMethod().isSuperTypeOf(
					domainElement.eClass())) {
				return org.unicase.model.classDiagram.edit.parts.MethodEditPart.VISUAL_ID;
			}
			break;
		case org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			if (ClassesPackage.eINSTANCE.getClass_().isSuperTypeOf(
					domainElement.eClass())) {
				return org.unicase.model.classDiagram.edit.parts.ClassEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.unicase.model.classDiagram.part.ModelVisualIDRegistry
				.getModelID(containerView);
		if (!org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
				.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
				.equals(containerModelID)) {
			containerVisualID = org.unicase.model.classDiagram.part.ModelVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case org.unicase.model.classDiagram.edit.parts.ClassEditPart.VISUAL_ID:
			if (org.unicase.model.classDiagram.edit.parts.ClassNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.model.classDiagram.edit.parts.ClassClassNode_attributesEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.model.classDiagram.edit.parts.ClassClassNode_methodsEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.model.classDiagram.edit.parts.ClassClassNode_attributesEditPart.VISUAL_ID:
			if (org.unicase.model.classDiagram.edit.parts.AttributeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.model.classDiagram.edit.parts.ClassClassNode_methodsEditPart.VISUAL_ID:
			if (org.unicase.model.classDiagram.edit.parts.MethodEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			if (org.unicase.model.classDiagram.edit.parts.ClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.model.classDiagram.edit.parts.Association1EditPart.VISUAL_ID:
			if (org.unicase.model.classDiagram.edit.parts.AssociationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.model.classDiagram.edit.parts.AssociationSourceMultiplicityEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.model.classDiagram.edit.parts.AssociationTargetMultiplicityEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.model.classDiagram.edit.parts.Association2EditPart.VISUAL_ID:
			if (org.unicase.model.classDiagram.edit.parts.AssociationName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.model.classDiagram.edit.parts.AssociationSourceMultiplicity2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.model.classDiagram.edit.parts.AssociationTargetMultiplicity2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.model.classDiagram.edit.parts.Association3EditPart.VISUAL_ID:
			if (org.unicase.model.classDiagram.edit.parts.AssociationName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.model.classDiagram.edit.parts.AssociationSourceMultiplicity3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.model.classDiagram.edit.parts.AssociationTargetMultiplicity3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.model.classDiagram.edit.parts.Association4EditPart.VISUAL_ID:
			if (org.unicase.model.classDiagram.edit.parts.AssociationName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.model.classDiagram.edit.parts.AssociationSourceMultiplicity4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.model.classDiagram.edit.parts.AssociationTargetMultiplicity4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (ClassesPackage.eINSTANCE.getAssociation().isSuperTypeOf(
				domainElement.eClass())
				&& isAssociation_3001((Association) domainElement)) {
			return org.unicase.model.classDiagram.edit.parts.Association1EditPart.VISUAL_ID;
		}
		if (ClassesPackage.eINSTANCE.getAssociation().isSuperTypeOf(
				domainElement.eClass())
				&& isAssociation_3002((Association) domainElement)) {
			return org.unicase.model.classDiagram.edit.parts.Association2EditPart.VISUAL_ID;
		}
		if (ClassesPackage.eINSTANCE.getAssociation().isSuperTypeOf(
				domainElement.eClass())
				&& isAssociation_3003((Association) domainElement)) {
			return org.unicase.model.classDiagram.edit.parts.Association3EditPart.VISUAL_ID;
		}
		if (ClassesPackage.eINSTANCE.getAssociation().isSuperTypeOf(
				domainElement.eClass())
				&& isAssociation_3004((Association) domainElement)) {
			return org.unicase.model.classDiagram.edit.parts.Association4EditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(MEDiagram element) {
		return true;
	}

	/**
	 * @generated
	 */
	private static boolean isAssociation_3001(Association domainElement) {
		if (Association_3001_Constraint == null) { // lazy initialization
			Association_3001_Constraint = org.unicase.model.classDiagram.expressions.ModelOCLFactory
					.getExpression(
							"self.type = AssociationType::UNDIRECTED_ASSOCIATION", ClassesPackage.eINSTANCE.getAssociation()); //$NON-NLS-1$
		}
		Object result = Association_3001_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isAssociation_3002(Association domainElement) {
		if (Association_3002_Constraint == null) { // lazy initialization
			Association_3002_Constraint = org.unicase.model.classDiagram.expressions.ModelOCLFactory
					.getExpression(
							"self.type = AssociationType::AGGREGATION", ClassesPackage.eINSTANCE.getAssociation()); //$NON-NLS-1$
		}
		Object result = Association_3002_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isAssociation_3004(Association domainElement) {
		if (Association_3004_Constraint == null) { // lazy initialization
			Association_3004_Constraint = org.unicase.model.classDiagram.expressions.ModelOCLFactory
					.getExpression(
							"self.type = AssociationType::DIRECTED_ASSOCIATION", ClassesPackage.eINSTANCE.getAssociation()); //$NON-NLS-1$
		}
		Object result = Association_3004_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isAssociation_3003(Association domainElement) {
		if (Association_3003_Constraint == null) { // lazy initialization
			Association_3003_Constraint = org.unicase.model.classDiagram.expressions.ModelOCLFactory
					.getExpression(
							"self.type = AssociationType::COMPOSITION", ClassesPackage.eINSTANCE.getAssociation()); //$NON-NLS-1$
		}
		Object result = Association_3003_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

}
