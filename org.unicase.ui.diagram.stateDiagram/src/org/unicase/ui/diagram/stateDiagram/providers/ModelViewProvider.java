/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.stateDiagram.providers;

import java.util.ArrayList;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.providers.IViewProvider;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewOperation;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.MeasurementUnit;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.unicase.model.diagram.DiagramFactory;
import org.unicase.model.diagram.MERelativeBendpoints;

/**
 * @generated
 */
public class ModelViewProvider extends AbstractProvider implements IViewProvider {

	/**
	 * @generated
	 */
	public final boolean provides(IOperation operation) {
		if (operation instanceof CreateViewForKindOperation) {
			return provides((CreateViewForKindOperation) operation);
		}
		assert operation instanceof CreateViewOperation;
		if (operation instanceof CreateDiagramViewOperation) {
			return provides((CreateDiagramViewOperation) operation);
		} else if (operation instanceof CreateEdgeViewOperation) {
			return provides((CreateEdgeViewOperation) operation);
		} else if (operation instanceof CreateNodeViewOperation) {
			return provides((CreateNodeViewOperation) operation);
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateViewForKindOperation op) {
		/*
		 * if (op.getViewKind() == Node.class) return getNodeViewClass(op.getSemanticAdapter(), op.getContainerView(),
		 * op.getSemanticHint()) != null; if (op.getViewKind() == Edge.class) return
		 * getEdgeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;
		 */
		return true;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateDiagramViewOperation op) {
		return org.unicase.ui.diagram.stateDiagram.edit.parts.MEDiagramEditPart.MODEL_ID.equals(op.getSemanticHint())
			&& org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry.getDiagramVisualID(getSemanticElement(op
				.getSemanticAdapter())) != -1;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateNodeViewOperation op) {
		if (op.getContainerView() == null) {
			return false;
		}
		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		EObject domainElement = getSemanticElement(op.getSemanticAdapter());
		int visualID;
		if (op.getSemanticHint() == null) {
			// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
			// In this situation there should be NO elementType, visualID will be determined
			// by VisualIDRegistry.getNodeVisualID() for domainElement.
			if (elementType != null || domainElement == null) {
				return false;
			}
			visualID = org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry.getNodeVisualID(
				op.getContainerView(), domainElement);
		} else {
			visualID = org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry.getVisualID(op.getSemanticHint());
			if (elementType != null) {
				if (!org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.isKnownElementType(elementType)
					|| (!(elementType instanceof IHintedType))) {
					return false; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
				if (!op.getSemanticHint().equals(elementTypeHint)) {
					return false; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null
					&& visualID != org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry.getNodeVisualID(
						op.getContainerView(), domainElement)) {
					return false; // visual id for node EClass should match visual id from element type
				}
			} else {
				if (!org.unicase.ui.diagram.stateDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
					.equals(org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry.getModelID(op
						.getContainerView()))) {
					return false; // foreign diagram
				}
				switch (visualID) {
				case org.unicase.ui.diagram.stateDiagram.edit.parts.StateEditPart.VISUAL_ID:
				case org.unicase.ui.diagram.stateDiagram.edit.parts.StateInitialEditPart.VISUAL_ID:
				case org.unicase.ui.diagram.stateDiagram.edit.parts.StateEndEditPart.VISUAL_ID:
					if (domainElement == null
						|| visualID != org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry.getNodeVisualID(
							op.getContainerView(), domainElement)) {
						return false; // visual id in semantic hint should match visual id for domain element
					}
					break;
				default:
					return false;
				}
			}
		}
		return org.unicase.ui.diagram.stateDiagram.edit.parts.StateEditPart.VISUAL_ID == visualID
			|| org.unicase.ui.diagram.stateDiagram.edit.parts.StateInitialEditPart.VISUAL_ID == visualID
			|| org.unicase.ui.diagram.stateDiagram.edit.parts.StateEndEditPart.VISUAL_ID == visualID;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateEdgeViewOperation op) {
		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		if (!org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.isKnownElementType(elementType)
			|| (!(elementType instanceof IHintedType))) {
			return false; // foreign element type
		}
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		if (elementTypeHint == null || (op.getSemanticHint() != null && !elementTypeHint.equals(op.getSemanticHint()))) {
			return false; // our hint is visual id and must be specified, and it should be the same as in element type
		}
		int visualID = org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(op.getSemanticAdapter());
		if (domainElement != null
			&& visualID != org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry
				.getLinkWithClassVisualID(domainElement)) {
			return false; // visual id for link EClass should match visual id from element type
		}
		return true;
	}

	/**
	 * @generated
	 */
	public Diagram createDiagram(IAdaptable semanticAdapter, String diagramKind, PreferencesHint preferencesHint) {
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		diagram.getStyles().add(NotationFactory.eINSTANCE.createDiagramStyle());
		diagram.setType(org.unicase.ui.diagram.stateDiagram.edit.parts.MEDiagramEditPart.MODEL_ID);
		diagram.setElement(getSemanticElement(semanticAdapter));
		diagram.setMeasurementUnit(MeasurementUnit.PIXEL_LITERAL);
		return diagram;
	}

	/**
	 * @generated
	 */
	public Node createNode(IAdaptable semanticAdapter, View containerView, String semanticHint, int index,
		boolean persisted, PreferencesHint preferencesHint) {
		final EObject domainElement = getSemanticElement(semanticAdapter);
		final int visualID;
		if (semanticHint == null) {
			visualID = org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry.getNodeVisualID(containerView,
				domainElement);
		} else {
			visualID = org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry.getVisualID(semanticHint);
		}
		switch (visualID) {
		case org.unicase.ui.diagram.stateDiagram.edit.parts.StateEditPart.VISUAL_ID:
			return createState_2001(domainElement, containerView, index, persisted, preferencesHint);
		case org.unicase.ui.diagram.stateDiagram.edit.parts.StateInitialEditPart.VISUAL_ID:
			return createStateInitial_2002(domainElement, containerView, index, persisted, preferencesHint);
		case org.unicase.ui.diagram.stateDiagram.edit.parts.StateEndEditPart.VISUAL_ID:
			return createStateEnd_2003(domainElement, containerView, index, persisted, preferencesHint);
		}
		// can't happen, provided #provides(CreateNodeViewOperation) is correct
		return null;
	}

	/**
	 * @generated
	 */
	public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index,
		boolean persisted, PreferencesHint preferencesHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		switch (org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry.getVisualID(elementTypeHint)) {
		case org.unicase.ui.diagram.stateDiagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return createTransition_4001(getSemanticElement(semanticAdapter), containerView, index, persisted,
				preferencesHint);
		}
		// can never happen, provided #provides(CreateEdgeViewOperation) is correct
		return null;
	}

	/**
	 * @generated
	 */
	public Node createState_2001(EObject domainElement, View containerView, int index, boolean persisted,
		PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry
			.getType(org.unicase.ui.diagram.stateDiagram.edit.parts.StateEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
			IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(),
			FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
			IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
			FigureUtilities.RGBToInteger(fillRGB));
		Node label5001 = createLabel(node,
			org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry
				.getType(org.unicase.ui.diagram.stateDiagram.edit.parts.StateNameEditPart.VISUAL_ID));
		Node label5002 = createLabel(node,
			org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry
				.getType(org.unicase.ui.diagram.stateDiagram.edit.parts.StateEntryConditionsEditPart.VISUAL_ID));
		Node label5003 = createLabel(node,
			org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry
				.getType(org.unicase.ui.diagram.stateDiagram.edit.parts.StateActivitiesEditPart.VISUAL_ID));
		Node label5004 = createLabel(node,
			org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry
				.getType(org.unicase.ui.diagram.stateDiagram.edit.parts.StateExitConditionsEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createStateInitial_2002(EObject domainElement, View containerView, int index, boolean persisted,
		PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry
			.getType(org.unicase.ui.diagram.stateDiagram.edit.parts.StateInitialEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
			IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(),
			FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		return node;
	}

	/**
	 * @generated
	 */
	public Node createStateEnd_2003(EObject domainElement, View containerView, int index, boolean persisted,
		PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFillStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry
			.getType(org.unicase.ui.diagram.stateDiagram.edit.parts.StateEndEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
			IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
			FigureUtilities.RGBToInteger(fillRGB));
		return node;
	}

	/**
	 * @generated
	 */
	public Edge createTransition_4001(EObject domainElement, View containerView, int index, boolean persisted,
		PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		MERelativeBendpoints bendpoints = DiagramFactory.eINSTANCE.createMERelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry
			.getType(org.unicase.ui.diagram.stateDiagram.edit.parts.TransitionEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
			IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getLineStyle_LineColor(),
			FigureUtilities.RGBToInteger(lineRGB));
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6001 = createLabel(edge,
			org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry
				.getType(org.unicase.ui.diagram.stateDiagram.edit.parts.TransitionConditionNameEditPart.VISUAL_ID));
		label6001.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6001 = (Location) label6001.getLayoutConstraint();
		location6001.setX(0);
		location6001.setY(40);
		return edge;
	}

	/**
	 * @generated
	 */
	private void stampShortcut(View containerView, Node target) {
		if (!org.unicase.ui.diagram.stateDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
			.equals(org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put(
				"modelID", org.unicase.ui.diagram.stateDiagram.edit.parts.MEDiagramEditPart.MODEL_ID); //$NON-NLS-1$
			target.getEAnnotations().add(shortcutAnnotation);
		}
	}

	/**
	 * @generated
	 */
	private Node createLabel(View owner, String hint) {
		DecorationNode rv = NotationFactory.eINSTANCE.createDecorationNode();
		rv.setType(hint);
		ViewUtil.insertChildView(owner, rv, ViewUtil.APPEND, true);
		return rv;
	}

	/**
	 * @generated
	 */
	private EObject getSemanticElement(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
		if (eObject != null) {
			return EMFCoreUtil.resolve(TransactionUtil.getEditingDomain(eObject), eObject);
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
