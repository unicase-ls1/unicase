package scrm.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

import scrm.SCRMDiagram;
import scrm.SCRMModelElement;
import scrm.diagram.edit.parts.MathematicalModelEditPart;
import scrm.diagram.edit.parts.NumericalMethodEditPart;
import scrm.diagram.edit.parts.NumericalMethodMathematicalModelEditPart;
import scrm.diagram.edit.parts.SCRMDiagramEditPart;
import scrm.diagram.providers.ScrmElementTypes;
import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.MathematicalModel;
import scrm.knowledge.NumericalMethod;

/**
 * @generated
 */
public class ScrmDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (ScrmVisualIDRegistry.getVisualID(view)) {
		case SCRMDiagramEditPart.VISUAL_ID:
			return getSCRMDiagram_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getSCRMDiagram_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		SCRMDiagram modelElement = (SCRMDiagram) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getElements().iterator(); it.hasNext();) {
			SCRMModelElement childElement = (SCRMModelElement) it.next();
			int visualID = ScrmVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MathematicalModelEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NumericalMethodEditPart.VISUAL_ID) {
				result.add(new ScrmNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (ScrmVisualIDRegistry.getVisualID(view)) {
		case SCRMDiagramEditPart.VISUAL_ID:
			return getSCRMDiagram_1000ContainedLinks(view);
		case MathematicalModelEditPart.VISUAL_ID:
			return getMathematicalModel_2001ContainedLinks(view);
		case NumericalMethodEditPart.VISUAL_ID:
			return getNumericalMethod_2002ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (ScrmVisualIDRegistry.getVisualID(view)) {
		case MathematicalModelEditPart.VISUAL_ID:
			return getMathematicalModel_2001IncomingLinks(view);
		case NumericalMethodEditPart.VISUAL_ID:
			return getNumericalMethod_2002IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (ScrmVisualIDRegistry.getVisualID(view)) {
		case MathematicalModelEditPart.VISUAL_ID:
			return getMathematicalModel_2001OutgoingLinks(view);
		case NumericalMethodEditPart.VISUAL_ID:
			return getNumericalMethod_2002OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getSCRMDiagram_1000ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMathematicalModel_2001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getNumericalMethod_2002ContainedLinks(View view) {
		NumericalMethod modelElement = (NumericalMethod) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_MathematicalModel_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMathematicalModel_2001IncomingLinks(View view) {
		MathematicalModel modelElement = (MathematicalModel) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_NumericalMethod_MathematicalModel_4003(modelElement,
			crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getNumericalMethod_2002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMathematicalModel_2001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getNumericalMethod_2002OutgoingLinks(View view) {
		NumericalMethod modelElement = (NumericalMethod) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_NumericalMethod_MathematicalModel_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_NumericalMethod_MathematicalModel_4003(
		MathematicalModel target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == KnowledgePackage.eINSTANCE.getNumericalMethod_MathematicalModel()) {
				result.add(new ScrmLinkDescriptor(setting.getEObject(), target,
					ScrmElementTypes.NumericalMethodMathematicalModel_4003,
					NumericalMethodMathematicalModelEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_NumericalMethod_MathematicalModel_4003(
		NumericalMethod source) {
		Collection result = new LinkedList();
		MathematicalModel destination = source.getMathematicalModel();
		if (destination == null) {
			return result;
		}
		result.add(new ScrmLinkDescriptor(source, destination, ScrmElementTypes.NumericalMethodMathematicalModel_4003,
			NumericalMethodMathematicalModelEditPart.VISUAL_ID));
		return result;
	}

}
