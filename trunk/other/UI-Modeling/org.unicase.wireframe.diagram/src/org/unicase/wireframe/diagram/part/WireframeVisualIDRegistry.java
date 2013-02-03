package org.unicase.wireframe.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;
import org.unicase.wireframe.Panel;
import org.unicase.wireframe.WireframePackage;
import org.unicase.wireframe.diagram.edit.parts.Button2EditPart;
import org.unicase.wireframe.diagram.edit.parts.ButtonEditPart;
import org.unicase.wireframe.diagram.edit.parts.Image2EditPart;
import org.unicase.wireframe.diagram.edit.parts.ImageEditPart;
import org.unicase.wireframe.diagram.edit.parts.ImageText2EditPart;
import org.unicase.wireframe.diagram.edit.parts.ImageTextEditPart;
import org.unicase.wireframe.diagram.edit.parts.Label2EditPart;
import org.unicase.wireframe.diagram.edit.parts.LabelEditPart;
import org.unicase.wireframe.diagram.edit.parts.LabelText2EditPart;
import org.unicase.wireframe.diagram.edit.parts.LabelTextEditPart;
import org.unicase.wireframe.diagram.edit.parts.PanelEditPart;
import org.unicase.wireframe.diagram.edit.parts.Text2EditPart;
import org.unicase.wireframe.diagram.edit.parts.TextEditPart;
import org.unicase.wireframe.diagram.edit.parts.TextField2EditPart;
import org.unicase.wireframe.diagram.edit.parts.TextFieldEditPart;
import org.unicase.wireframe.diagram.edit.parts.TextFieldText2EditPart;
import org.unicase.wireframe.diagram.edit.parts.TextFieldTextEditPart;
import org.unicase.wireframe.diagram.edit.parts.TextText2EditPart;
import org.unicase.wireframe.diagram.edit.parts.TextTextEditPart;
import org.unicase.wireframe.diagram.edit.parts.WindowEditPart;
import org.unicase.wireframe.diagram.edit.parts.WindowTextEditPart;
import org.unicase.wireframe.diagram.edit.parts.WindowWindowWidgetCompartmentEditPart;

/**
 * This registry is used to determine which type of visual object should be created for the corresponding Diagram, Node,
 * ChildNode or Link represented by a domain model object.
 * 
 * @generated
 */
public class WireframeVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.unicase.wireframe.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (PanelEditPart.MODEL_ID.equals(view.getType())) {
				return PanelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.unicase.wireframe.diagram.part.WireframeVisualIDRegistry.getVisualID(view.getType());
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
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				WireframeDiagramEditorPlugin.getInstance().logError(
					"Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (WireframePackage.eINSTANCE.getPanel().isSuperTypeOf(domainElement.eClass())
			&& isDiagram((Panel) domainElement)) {
			return PanelEditPart.VISUAL_ID;
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
		String containerModelID = org.unicase.wireframe.diagram.part.WireframeVisualIDRegistry
			.getModelID(containerView);
		if (!PanelEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (PanelEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.unicase.wireframe.diagram.part.WireframeVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = PanelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case PanelEditPart.VISUAL_ID:
			if (WireframePackage.eINSTANCE.getWindow().isSuperTypeOf(domainElement.eClass())) {
				return WindowEditPart.VISUAL_ID;
			}
			if (WireframePackage.eINSTANCE.getLabel().isSuperTypeOf(domainElement.eClass())) {
				return LabelEditPart.VISUAL_ID;
			}
			if (WireframePackage.eINSTANCE.getTextField().isSuperTypeOf(domainElement.eClass())) {
				return TextFieldEditPart.VISUAL_ID;
			}
			if (WireframePackage.eINSTANCE.getButton().isSuperTypeOf(domainElement.eClass())) {
				return ButtonEditPart.VISUAL_ID;
			}
			if (WireframePackage.eINSTANCE.getText().isSuperTypeOf(domainElement.eClass())) {
				return TextEditPart.VISUAL_ID;
			}
			if (WireframePackage.eINSTANCE.getImage().isSuperTypeOf(domainElement.eClass())) {
				return ImageEditPart.VISUAL_ID;
			}
			break;
		case WindowWindowWidgetCompartmentEditPart.VISUAL_ID:
			if (WireframePackage.eINSTANCE.getButton().isSuperTypeOf(domainElement.eClass())) {
				return Button2EditPart.VISUAL_ID;
			}
			if (WireframePackage.eINSTANCE.getImage().isSuperTypeOf(domainElement.eClass())) {
				return Image2EditPart.VISUAL_ID;
			}
			if (WireframePackage.eINSTANCE.getLabel().isSuperTypeOf(domainElement.eClass())) {
				return Label2EditPart.VISUAL_ID;
			}
			if (WireframePackage.eINSTANCE.getText().isSuperTypeOf(domainElement.eClass())) {
				return Text2EditPart.VISUAL_ID;
			}
			if (WireframePackage.eINSTANCE.getTextField().isSuperTypeOf(domainElement.eClass())) {
				return TextField2EditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.unicase.wireframe.diagram.part.WireframeVisualIDRegistry
			.getModelID(containerView);
		if (!PanelEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (PanelEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.unicase.wireframe.diagram.part.WireframeVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = PanelEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case PanelEditPart.VISUAL_ID:
			if (WindowEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TextFieldEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ButtonEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TextEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ImageEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case WindowEditPart.VISUAL_ID:
			if (WindowTextEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WindowWindowWidgetCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LabelEditPart.VISUAL_ID:
			if (LabelTextEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TextFieldEditPart.VISUAL_ID:
			if (TextFieldTextEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TextEditPart.VISUAL_ID:
			if (TextTextEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ImageEditPart.VISUAL_ID:
			if (ImageTextEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Image2EditPart.VISUAL_ID:
			if (ImageText2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Label2EditPart.VISUAL_ID:
			if (LabelText2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Text2EditPart.VISUAL_ID:
			if (TextText2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TextField2EditPart.VISUAL_ID:
			if (TextFieldText2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case WindowWindowWidgetCompartmentEditPart.VISUAL_ID:
			if (Button2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Image2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Label2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Text2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TextField2EditPart.VISUAL_ID == nodeVisualID) {
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
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Panel element) {
		return true;
	}

	/**
	 * @generated
	 */
	public static boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	 * @generated
	 */
	public static boolean isCompartmentVisualID(int visualID) {
		switch (visualID) {
		case WindowWindowWidgetCompartmentEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case PanelEditPart.VISUAL_ID:
			return false;
		case LabelEditPart.VISUAL_ID:
		case TextFieldEditPart.VISUAL_ID:
		case ButtonEditPart.VISUAL_ID:
		case TextEditPart.VISUAL_ID:
		case ImageEditPart.VISUAL_ID:
		case Button2EditPart.VISUAL_ID:
		case Image2EditPart.VISUAL_ID:
		case Label2EditPart.VISUAL_ID:
		case Text2EditPart.VISUAL_ID:
		case TextField2EditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
		/**
		 * @generated
		 */

		public int getVisualID(View view) {
			return org.unicase.wireframe.diagram.part.WireframeVisualIDRegistry.getVisualID(view);
		}

		/**
		 * @generated
		 */

		public String getModelID(View view) {
			return org.unicase.wireframe.diagram.part.WireframeVisualIDRegistry.getModelID(view);
		}

		/**
		 * @generated
		 */

		public int getNodeVisualID(View containerView, EObject domainElement) {
			return org.unicase.wireframe.diagram.part.WireframeVisualIDRegistry.getNodeVisualID(containerView,
				domainElement);
		}

		/**
		 * @generated
		 */

		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return org.unicase.wireframe.diagram.part.WireframeVisualIDRegistry.checkNodeVisualID(containerView,
				domainElement, candidate);
		}

		/**
		 * @generated
		 */

		public boolean isCompartmentVisualID(int visualID) {
			return org.unicase.wireframe.diagram.part.WireframeVisualIDRegistry.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */

		public boolean isSemanticLeafVisualID(int visualID) {
			return org.unicase.wireframe.diagram.part.WireframeVisualIDRegistry.isSemanticLeafVisualID(visualID);
		}
	};

}
