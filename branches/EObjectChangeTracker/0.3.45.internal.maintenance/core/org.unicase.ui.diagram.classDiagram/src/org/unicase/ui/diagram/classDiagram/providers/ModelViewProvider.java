/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.classDiagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ModelViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (org.unicase.ui.diagram.classDiagram.edit.parts.MEDiagramEditPart.MODEL_ID.equals(diagramKind)
			&& org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
			return org.unicase.ui.diagram.classDiagram.view.factories.MEDiagramViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		if (containerView == null) {
			return null;
		}
		IElementType elementType = getSemanticElementType(semanticAdapter);
		EObject domainElement = getSemanticElement(semanticAdapter);
		int visualID;
		if (semanticHint == null) {
			// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
			// In this situation there should be NO elementType, visualID will be determined
			// by VisualIDRegistry.getNodeVisualID() for domainElement.
			if (elementType != null || domainElement == null) {
				return null;
			}
			visualID = org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry.getNodeVisualID(containerView,
				domainElement);
		} else {
			visualID = org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry.getVisualID(semanticHint);
			if (elementType != null) {
				// Semantic hint is specified together with element type.
				// Both parameters should describe exactly the same diagram element.
				// In addition we check that visualID returned by VisualIDRegistry.getNodeVisualID() for
				// domainElement (if specified) is the same as in element type.
				if (!org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.isKnownElementType(elementType)
					|| (!(elementType instanceof IHintedType))) {
					return null; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
				if (!semanticHint.equals(elementTypeHint)) {
					return null; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null
					&& visualID != org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry.getNodeVisualID(
						containerView, domainElement)) {
					return null; // visual id for node EClass should match visual id from element type
				}
			} else {
				// Element type is not specified. Domain element should be present (except pure design elements).
				// This method is called with EObjectAdapter as parameter from:
				// - ViewService.createNode(View container, EObject eObject, String type, PreferencesHint
				// preferencesHint)
				// - generated ViewFactory.decorateView() for parent element
				if (!org.unicase.ui.diagram.classDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
					.equals(org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry.getModelID(containerView))) {
					return null; // foreign diagram
				}
				switch (visualID) {
				case org.unicase.ui.diagram.classDiagram.edit.parts.ClassEditPart.VISUAL_ID:
				case org.unicase.ui.diagram.classDiagram.edit.parts.PackageEditPart.VISUAL_ID:
				case org.unicase.ui.diagram.classDiagram.edit.parts.AttributeEditPart.VISUAL_ID:
				case org.unicase.ui.diagram.classDiagram.edit.parts.MethodEditPart.VISUAL_ID:
					if (domainElement == null
						|| visualID != org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry.getNodeVisualID(
							containerView, domainElement)) {
						return null; // visual id in semantic hint should match visual id for domain element
					}
					break;
				case org.unicase.ui.diagram.classDiagram.edit.parts.ClassNameEditPart.VISUAL_ID:
				case org.unicase.ui.diagram.classDiagram.edit.parts.ClassClassNode_attributesEditPart.VISUAL_ID:
				case org.unicase.ui.diagram.classDiagram.edit.parts.ClassClassNode_methodsEditPart.VISUAL_ID:
					if (org.unicase.ui.diagram.classDiagram.edit.parts.ClassEditPart.VISUAL_ID != org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
						.getVisualID(containerView)
						|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case org.unicase.ui.diagram.classDiagram.edit.parts.PackageNameEditPart.VISUAL_ID:
					if (org.unicase.ui.diagram.classDiagram.edit.parts.PackageEditPart.VISUAL_ID != org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
						.getVisualID(containerView)
						|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationNameEditPart.VISUAL_ID:
				case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicityEditPart.VISUAL_ID:
				case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicityEditPart.VISUAL_ID:
					if (org.unicase.ui.diagram.classDiagram.edit.parts.Association1EditPart.VISUAL_ID != org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
						.getVisualID(containerView)
						|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationName2EditPart.VISUAL_ID:
				case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicity2EditPart.VISUAL_ID:
				case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicity2EditPart.VISUAL_ID:
					if (org.unicase.ui.diagram.classDiagram.edit.parts.Association2EditPart.VISUAL_ID != org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
						.getVisualID(containerView)
						|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationName3EditPart.VISUAL_ID:
				case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicity3EditPart.VISUAL_ID:
				case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicity3EditPart.VISUAL_ID:
					if (org.unicase.ui.diagram.classDiagram.edit.parts.Association3EditPart.VISUAL_ID != org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
						.getVisualID(containerView)
						|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationName4EditPart.VISUAL_ID:
				case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicity4EditPart.VISUAL_ID:
				case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicity4EditPart.VISUAL_ID:
					if (org.unicase.ui.diagram.classDiagram.edit.parts.Association4EditPart.VISUAL_ID != org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
						.getVisualID(containerView)
						|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				default:
					return null;
				}
			}
		}
		return getNodeViewClass(containerView, visualID);
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(View containerView, int visualID) {
		if (containerView == null
			|| !org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry.canCreateNode(containerView, visualID)) {
			return null;
		}
		switch (visualID) {
		case org.unicase.ui.diagram.classDiagram.edit.parts.ClassEditPart.VISUAL_ID:
			return org.unicase.ui.diagram.classDiagram.view.factories.ClassViewFactory.class;
		case org.unicase.ui.diagram.classDiagram.edit.parts.ClassNameEditPart.VISUAL_ID:
			return org.unicase.ui.diagram.classDiagram.view.factories.ClassNameViewFactory.class;
		case org.unicase.ui.diagram.classDiagram.edit.parts.PackageEditPart.VISUAL_ID:
			return org.unicase.ui.diagram.classDiagram.view.factories.PackageViewFactory.class;
		case org.unicase.ui.diagram.classDiagram.edit.parts.PackageNameEditPart.VISUAL_ID:
			return org.unicase.ui.diagram.classDiagram.view.factories.PackageNameViewFactory.class;
		case org.unicase.ui.diagram.classDiagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return org.unicase.ui.diagram.classDiagram.view.factories.AttributeViewFactory.class;
		case org.unicase.ui.diagram.classDiagram.edit.parts.MethodEditPart.VISUAL_ID:
			return org.unicase.ui.diagram.classDiagram.view.factories.MethodViewFactory.class;
		case org.unicase.ui.diagram.classDiagram.edit.parts.ClassClassNode_attributesEditPart.VISUAL_ID:
			return org.unicase.ui.diagram.classDiagram.view.factories.ClassClassNode_attributesViewFactory.class;
		case org.unicase.ui.diagram.classDiagram.edit.parts.ClassClassNode_methodsEditPart.VISUAL_ID:
			return org.unicase.ui.diagram.classDiagram.view.factories.ClassClassNode_methodsViewFactory.class;
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationNameEditPart.VISUAL_ID:
			return org.unicase.ui.diagram.classDiagram.view.factories.AssociationNameViewFactory.class;
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicityEditPart.VISUAL_ID:
			return org.unicase.ui.diagram.classDiagram.view.factories.AssociationSourceMultiplicityViewFactory.class;
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicityEditPart.VISUAL_ID:
			return org.unicase.ui.diagram.classDiagram.view.factories.AssociationTargetMultiplicityViewFactory.class;
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationName2EditPart.VISUAL_ID:
			return org.unicase.ui.diagram.classDiagram.view.factories.AssociationName2ViewFactory.class;
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicity2EditPart.VISUAL_ID:
			return org.unicase.ui.diagram.classDiagram.view.factories.AssociationSourceMultiplicity2ViewFactory.class;
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicity2EditPart.VISUAL_ID:
			return org.unicase.ui.diagram.classDiagram.view.factories.AssociationTargetMultiplicity2ViewFactory.class;
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationName3EditPart.VISUAL_ID:
			return org.unicase.ui.diagram.classDiagram.view.factories.AssociationName3ViewFactory.class;
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicity3EditPart.VISUAL_ID:
			return org.unicase.ui.diagram.classDiagram.view.factories.AssociationSourceMultiplicity3ViewFactory.class;
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicity3EditPart.VISUAL_ID:
			return org.unicase.ui.diagram.classDiagram.view.factories.AssociationTargetMultiplicity3ViewFactory.class;
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationName4EditPart.VISUAL_ID:
			return org.unicase.ui.diagram.classDiagram.view.factories.AssociationName4ViewFactory.class;
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationSourceMultiplicity4EditPart.VISUAL_ID:
			return org.unicase.ui.diagram.classDiagram.view.factories.AssociationSourceMultiplicity4ViewFactory.class;
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTargetMultiplicity4EditPart.VISUAL_ID:
			return org.unicase.ui.diagram.classDiagram.view.factories.AssociationTargetMultiplicity4ViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (!org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.isKnownElementType(elementType)
			|| (!(elementType instanceof IHintedType))) {
			return null; // foreign element type
		}
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		if (elementTypeHint == null) {
			return null; // our hint is visual id and must be specified
		}
		if (semanticHint != null && !semanticHint.equals(elementTypeHint)) {
			return null; // if semantic hint is specified it should be the same as in element type
		}
		int visualID = org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(semanticAdapter);
		if (domainElement != null
			&& visualID != org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
				.getLinkWithClassVisualID(domainElement)) {
			return null; // visual id for link EClass should match visual id from element type
		}
		return getEdgeViewClass(visualID);
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(int visualID) {
		switch (visualID) {
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association1EditPart.VISUAL_ID:
			return org.unicase.ui.diagram.classDiagram.view.factories.Association1ViewFactory.class;
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association2EditPart.VISUAL_ID:
			return org.unicase.ui.diagram.classDiagram.view.factories.Association2ViewFactory.class;
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association3EditPart.VISUAL_ID:
			return org.unicase.ui.diagram.classDiagram.view.factories.Association3ViewFactory.class;
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association4EditPart.VISUAL_ID:
			return org.unicase.ui.diagram.classDiagram.view.factories.Association4ViewFactory.class;
		case org.unicase.ui.diagram.classDiagram.edit.parts.ClassSuperClassesEditPart.VISUAL_ID:
			return org.unicase.ui.diagram.classDiagram.view.factories.ClassSuperClassesViewFactory.class;
		case org.unicase.ui.diagram.classDiagram.edit.parts.DependencyEditPart.VISUAL_ID:
			return org.unicase.ui.diagram.classDiagram.view.factories.DependencyViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		return (IElementType) semanticAdapter.getAdapter(IElementType.class);
	}
}
