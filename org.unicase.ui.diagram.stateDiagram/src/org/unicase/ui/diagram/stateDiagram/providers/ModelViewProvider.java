/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.stateDiagram.providers;

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
		if (org.unicase.ui.diagram.stateDiagram.edit.parts.MEDiagramEditPart.MODEL_ID.equals(diagramKind)
			&& org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
			return org.unicase.ui.diagram.stateDiagram.view.factories.MEDiagramViewFactory.class;
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
			visualID = org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry.getNodeVisualID(containerView,
				domainElement);
		} else {
			visualID = org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry.getVisualID(semanticHint);
			if (elementType != null) {
				// Semantic hint is specified together with element type.
				// Both parameters should describe exactly the same diagram element.
				// In addition we check that visualID returned by VisualIDRegistry.getNodeVisualID() for
				// domainElement (if specified) is the same as in element type.
				if (!org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.isKnownElementType(elementType)
					|| (!(elementType instanceof IHintedType))) {
					return null; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
				if (!semanticHint.equals(elementTypeHint)) {
					return null; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null
					&& visualID != org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry.getNodeVisualID(
						containerView, domainElement)) {
					return null; // visual id for node EClass should match visual id from element type
				}
			} else {
				// Element type is not specified. Domain element should be present (except pure design elements).
				// This method is called with EObjectAdapter as parameter from:
				// - ViewService.createNode(View container, EObject eObject, String type, PreferencesHint
				// preferencesHint)
				// - generated ViewFactory.decorateView() for parent element
				if (!org.unicase.ui.diagram.stateDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
					.equals(org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry.getModelID(containerView))) {
					return null; // foreign diagram
				}
				switch (visualID) {
				case org.unicase.ui.diagram.stateDiagram.edit.parts.StateEditPart.VISUAL_ID:
				case org.unicase.ui.diagram.stateDiagram.edit.parts.StateInitialEditPart.VISUAL_ID:
				case org.unicase.ui.diagram.stateDiagram.edit.parts.StateEndEditPart.VISUAL_ID:
					if (domainElement == null
						|| visualID != org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry.getNodeVisualID(
							containerView, domainElement)) {
						return null; // visual id in semantic hint should match visual id for domain element
					}
					break;
				case org.unicase.ui.diagram.stateDiagram.edit.parts.StateNameEditPart.VISUAL_ID:
				case org.unicase.ui.diagram.stateDiagram.edit.parts.StateEntryConditionsEditPart.VISUAL_ID:
				case org.unicase.ui.diagram.stateDiagram.edit.parts.StateActivitiesEditPart.VISUAL_ID:
				case org.unicase.ui.diagram.stateDiagram.edit.parts.StateExitConditionsEditPart.VISUAL_ID:
					if (org.unicase.ui.diagram.stateDiagram.edit.parts.StateEditPart.VISUAL_ID != org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry
						.getVisualID(containerView)
						|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case org.unicase.ui.diagram.stateDiagram.edit.parts.TransitionNameEditPart.VISUAL_ID:
					if (org.unicase.ui.diagram.stateDiagram.edit.parts.TransitionEditPart.VISUAL_ID != org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry
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
			|| !org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry.canCreateNode(containerView, visualID)) {
			return null;
		}
		switch (visualID) {
		case org.unicase.ui.diagram.stateDiagram.edit.parts.StateEditPart.VISUAL_ID:
			return org.unicase.ui.diagram.stateDiagram.view.factories.StateViewFactory.class;
		case org.unicase.ui.diagram.stateDiagram.edit.parts.StateNameEditPart.VISUAL_ID:
			return org.unicase.ui.diagram.stateDiagram.view.factories.StateNameViewFactory.class;
		case org.unicase.ui.diagram.stateDiagram.edit.parts.StateEntryConditionsEditPart.VISUAL_ID:
			return org.unicase.ui.diagram.stateDiagram.view.factories.StateEntryConditionsViewFactory.class;
		case org.unicase.ui.diagram.stateDiagram.edit.parts.StateActivitiesEditPart.VISUAL_ID:
			return org.unicase.ui.diagram.stateDiagram.view.factories.StateActivitiesViewFactory.class;
		case org.unicase.ui.diagram.stateDiagram.edit.parts.StateExitConditionsEditPart.VISUAL_ID:
			return org.unicase.ui.diagram.stateDiagram.view.factories.StateExitConditionsViewFactory.class;
		case org.unicase.ui.diagram.stateDiagram.edit.parts.StateInitialEditPart.VISUAL_ID:
			return org.unicase.ui.diagram.stateDiagram.view.factories.StateInitialViewFactory.class;
		case org.unicase.ui.diagram.stateDiagram.edit.parts.StateEndEditPart.VISUAL_ID:
			return org.unicase.ui.diagram.stateDiagram.view.factories.StateEndViewFactory.class;
		case org.unicase.ui.diagram.stateDiagram.edit.parts.TransitionNameEditPart.VISUAL_ID:
			return org.unicase.ui.diagram.stateDiagram.view.factories.TransitionNameViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (!org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.isKnownElementType(elementType)
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
		int visualID = org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(semanticAdapter);
		if (domainElement != null
			&& visualID != org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry
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
		case org.unicase.ui.diagram.stateDiagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return org.unicase.ui.diagram.stateDiagram.view.factories.TransitionViewFactory.class;
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
