/*
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling.diagram.providers;

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
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.MeasurementUnit;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;

/**
 * @generated
 */
public class UiModelingViewProvider extends AbstractProvider implements IViewProvider {

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
		 if (op.getViewKind() == Node.class)
		 return getNodeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;
		 if (op.getViewKind() == Edge.class)
		 return getEdgeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;
		 */
		return true;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateDiagramViewOperation op) {
		return org.unicase.uiModeling.diagram.edit.parts.PanelEditPart.MODEL_ID.equals(op.getSemanticHint())
			&& org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getDiagramVisualID(getSemanticElement(op
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
			visualID = org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getNodeVisualID(
				op.getContainerView(), domainElement);
		} else {
			visualID = org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getVisualID(op.getSemanticHint());
			if (elementType != null) {
				if (!org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.isKnownElementType(elementType)
					|| (!(elementType instanceof IHintedType))) {
					return false; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
				if (!op.getSemanticHint().equals(elementTypeHint)) {
					return false; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null
					&& visualID != org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getNodeVisualID(
						op.getContainerView(), domainElement)) {
					return false; // visual id for node EClass should match visual id from element type
				}
			} else {
				if (!org.unicase.uiModeling.diagram.edit.parts.PanelEditPart.MODEL_ID
					.equals(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getModelID(op
						.getContainerView()))) {
					return false; // foreign diagram
				}
				switch (visualID) {
				case org.unicase.uiModeling.diagram.edit.parts.WindowEditPart.VISUAL_ID:
				case org.unicase.uiModeling.diagram.edit.parts.Button2EditPart.VISUAL_ID:
				case org.unicase.uiModeling.diagram.edit.parts.Image2EditPart.VISUAL_ID:
				case org.unicase.uiModeling.diagram.edit.parts.Label2EditPart.VISUAL_ID:
				case org.unicase.uiModeling.diagram.edit.parts.Text2EditPart.VISUAL_ID:
				case org.unicase.uiModeling.diagram.edit.parts.TextField2EditPart.VISUAL_ID:
				case org.unicase.uiModeling.diagram.edit.parts.RadioGroup2EditPart.VISUAL_ID:
				case org.unicase.uiModeling.diagram.edit.parts.RadioButtonEditPart.VISUAL_ID:
				case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroup2EditPart.VISUAL_ID:
				case org.unicase.uiModeling.diagram.edit.parts.CheckboxEditPart.VISUAL_ID:
				case org.unicase.uiModeling.diagram.edit.parts.DropdownList2EditPart.VISUAL_ID:
				case org.unicase.uiModeling.diagram.edit.parts.DropdownItemEditPart.VISUAL_ID:
				case org.unicase.uiModeling.diagram.edit.parts.ImageButton2EditPart.VISUAL_ID:
				case org.unicase.uiModeling.diagram.edit.parts.LabelEditPart.VISUAL_ID:
				case org.unicase.uiModeling.diagram.edit.parts.TextFieldEditPart.VISUAL_ID:
				case org.unicase.uiModeling.diagram.edit.parts.ButtonEditPart.VISUAL_ID:
				case org.unicase.uiModeling.diagram.edit.parts.TextEditPart.VISUAL_ID:
				case org.unicase.uiModeling.diagram.edit.parts.ImageEditPart.VISUAL_ID:
				case org.unicase.uiModeling.diagram.edit.parts.RadioGroupEditPart.VISUAL_ID:
				case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupEditPart.VISUAL_ID:
				case org.unicase.uiModeling.diagram.edit.parts.DropdownListEditPart.VISUAL_ID:
				case org.unicase.uiModeling.diagram.edit.parts.ImageButtonEditPart.VISUAL_ID:
					if (domainElement == null
						|| visualID != org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getNodeVisualID(
							op.getContainerView(), domainElement)) {
						return false; // visual id in semantic hint should match visual id for domain element
					}
					break;
				default:
					return false;
				}
			}
		}
		return org.unicase.uiModeling.diagram.edit.parts.WindowEditPart.VISUAL_ID == visualID
			|| org.unicase.uiModeling.diagram.edit.parts.LabelEditPart.VISUAL_ID == visualID
			|| org.unicase.uiModeling.diagram.edit.parts.TextFieldEditPart.VISUAL_ID == visualID
			|| org.unicase.uiModeling.diagram.edit.parts.ButtonEditPart.VISUAL_ID == visualID
			|| org.unicase.uiModeling.diagram.edit.parts.TextEditPart.VISUAL_ID == visualID
			|| org.unicase.uiModeling.diagram.edit.parts.ImageEditPart.VISUAL_ID == visualID
			|| org.unicase.uiModeling.diagram.edit.parts.RadioGroupEditPart.VISUAL_ID == visualID
			|| org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupEditPart.VISUAL_ID == visualID
			|| org.unicase.uiModeling.diagram.edit.parts.DropdownListEditPart.VISUAL_ID == visualID
			|| org.unicase.uiModeling.diagram.edit.parts.ImageButtonEditPart.VISUAL_ID == visualID
			|| org.unicase.uiModeling.diagram.edit.parts.Button2EditPart.VISUAL_ID == visualID
			|| org.unicase.uiModeling.diagram.edit.parts.Image2EditPart.VISUAL_ID == visualID
			|| org.unicase.uiModeling.diagram.edit.parts.Label2EditPart.VISUAL_ID == visualID
			|| org.unicase.uiModeling.diagram.edit.parts.Text2EditPart.VISUAL_ID == visualID
			|| org.unicase.uiModeling.diagram.edit.parts.TextField2EditPart.VISUAL_ID == visualID
			|| org.unicase.uiModeling.diagram.edit.parts.RadioGroup2EditPart.VISUAL_ID == visualID
			|| org.unicase.uiModeling.diagram.edit.parts.RadioButtonEditPart.VISUAL_ID == visualID
			|| org.unicase.uiModeling.diagram.edit.parts.CheckboxGroup2EditPart.VISUAL_ID == visualID
			|| org.unicase.uiModeling.diagram.edit.parts.CheckboxEditPart.VISUAL_ID == visualID
			|| org.unicase.uiModeling.diagram.edit.parts.DropdownList2EditPart.VISUAL_ID == visualID
			|| org.unicase.uiModeling.diagram.edit.parts.DropdownItemEditPart.VISUAL_ID == visualID
			|| org.unicase.uiModeling.diagram.edit.parts.ImageButton2EditPart.VISUAL_ID == visualID;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateEdgeViewOperation op) {
		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		if (!org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.isKnownElementType(elementType)
			|| (!(elementType instanceof IHintedType))) {
			return false; // foreign element type
		}
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		if (elementTypeHint == null || (op.getSemanticHint() != null && !elementTypeHint.equals(op.getSemanticHint()))) {
			return false; // our hint is visual id and must be specified, and it should be the same as in element type
		}
		int visualID = org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(op.getSemanticAdapter());
		if (domainElement != null
			&& visualID != org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
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
		diagram.setType(org.unicase.uiModeling.diagram.edit.parts.PanelEditPart.MODEL_ID);
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
			visualID = org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getNodeVisualID(containerView,
				domainElement);
		} else {
			visualID = org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getVisualID(semanticHint);
		}
		switch (visualID) {
		case org.unicase.uiModeling.diagram.edit.parts.WindowEditPart.VISUAL_ID:
			return createWindow_2003(domainElement, containerView, index, persisted, preferencesHint);
		case org.unicase.uiModeling.diagram.edit.parts.LabelEditPart.VISUAL_ID:
			return createLabel_2004(domainElement, containerView, index, persisted, preferencesHint);
		case org.unicase.uiModeling.diagram.edit.parts.TextFieldEditPart.VISUAL_ID:
			return createTextField_2005(domainElement, containerView, index, persisted, preferencesHint);
		case org.unicase.uiModeling.diagram.edit.parts.ButtonEditPart.VISUAL_ID:
			return createButton_2006(domainElement, containerView, index, persisted, preferencesHint);
		case org.unicase.uiModeling.diagram.edit.parts.TextEditPart.VISUAL_ID:
			return createText_2007(domainElement, containerView, index, persisted, preferencesHint);
		case org.unicase.uiModeling.diagram.edit.parts.ImageEditPart.VISUAL_ID:
			return createImage_2008(domainElement, containerView, index, persisted, preferencesHint);
		case org.unicase.uiModeling.diagram.edit.parts.RadioGroupEditPart.VISUAL_ID:
			return createRadioGroup_2009(domainElement, containerView, index, persisted, preferencesHint);
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupEditPart.VISUAL_ID:
			return createCheckboxGroup_2010(domainElement, containerView, index, persisted, preferencesHint);
		case org.unicase.uiModeling.diagram.edit.parts.DropdownListEditPart.VISUAL_ID:
			return createDropdownList_2011(domainElement, containerView, index, persisted, preferencesHint);
		case org.unicase.uiModeling.diagram.edit.parts.ImageButtonEditPart.VISUAL_ID:
			return createImageButton_2012(domainElement, containerView, index, persisted, preferencesHint);
		case org.unicase.uiModeling.diagram.edit.parts.Button2EditPart.VISUAL_ID:
			return createButton_3001(domainElement, containerView, index, persisted, preferencesHint);
		case org.unicase.uiModeling.diagram.edit.parts.Image2EditPart.VISUAL_ID:
			return createImage_3002(domainElement, containerView, index, persisted, preferencesHint);
		case org.unicase.uiModeling.diagram.edit.parts.Label2EditPart.VISUAL_ID:
			return createLabel_3003(domainElement, containerView, index, persisted, preferencesHint);
		case org.unicase.uiModeling.diagram.edit.parts.Text2EditPart.VISUAL_ID:
			return createText_3004(domainElement, containerView, index, persisted, preferencesHint);
		case org.unicase.uiModeling.diagram.edit.parts.TextField2EditPart.VISUAL_ID:
			return createTextField_3005(domainElement, containerView, index, persisted, preferencesHint);
		case org.unicase.uiModeling.diagram.edit.parts.RadioGroup2EditPart.VISUAL_ID:
			return createRadioGroup_3009(domainElement, containerView, index, persisted, preferencesHint);
		case org.unicase.uiModeling.diagram.edit.parts.RadioButtonEditPart.VISUAL_ID:
			return createRadioButton_3006(domainElement, containerView, index, persisted, preferencesHint);
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxGroup2EditPart.VISUAL_ID:
			return createCheckboxGroup_3010(domainElement, containerView, index, persisted, preferencesHint);
		case org.unicase.uiModeling.diagram.edit.parts.CheckboxEditPart.VISUAL_ID:
			return createCheckbox_3007(domainElement, containerView, index, persisted, preferencesHint);
		case org.unicase.uiModeling.diagram.edit.parts.DropdownList2EditPart.VISUAL_ID:
			return createDropdownList_3011(domainElement, containerView, index, persisted, preferencesHint);
		case org.unicase.uiModeling.diagram.edit.parts.DropdownItemEditPart.VISUAL_ID:
			return createDropdownItem_3008(domainElement, containerView, index, persisted, preferencesHint);
		case org.unicase.uiModeling.diagram.edit.parts.ImageButton2EditPart.VISUAL_ID:
			return createImageButton_3012(domainElement, containerView, index, persisted, preferencesHint);
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
		switch (org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getVisualID(elementTypeHint)) {
		}
		// can never happen, provided #provides(CreateEdgeViewOperation) is correct
		return null;
	}

	/**
	 * @generated
	 */
	public Node createWindow_2003(EObject domainElement, View containerView, int index, boolean persisted,
		PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
			.getType(org.unicase.uiModeling.diagram.edit.parts.WindowEditPart.VISUAL_ID));
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
		Node label5003 = createLabel(node,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.WindowTextEditPart.VISUAL_ID));
		createCompartment(node,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.WindowWindowWidgetCompartmentEditPart.VISUAL_ID),
			false, false, false, false);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createLabel_2004(EObject domainElement, View containerView, int index, boolean persisted,
		PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
			.getType(org.unicase.uiModeling.diagram.edit.parts.LabelEditPart.VISUAL_ID));
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
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.LabelTextEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createTextField_2005(EObject domainElement, View containerView, int index, boolean persisted,
		PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
			.getType(org.unicase.uiModeling.diagram.edit.parts.TextFieldEditPart.VISUAL_ID));
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
		Node label5004 = createLabel(node,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.TextFieldTextEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createButton_2006(EObject domainElement, View containerView, int index, boolean persisted,
		PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
			.getType(org.unicase.uiModeling.diagram.edit.parts.ButtonEditPart.VISUAL_ID));
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
		Node label5012 = createLabel(node,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.ButtonTextEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createText_2007(EObject domainElement, View containerView, int index, boolean persisted,
		PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
			.getType(org.unicase.uiModeling.diagram.edit.parts.TextEditPart.VISUAL_ID));
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
		Node label5002 = createLabel(node,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.TextTextEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createImage_2008(EObject domainElement, View containerView, int index, boolean persisted,
		PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
			.getType(org.unicase.uiModeling.diagram.edit.parts.ImageEditPart.VISUAL_ID));
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
		Node label5006 = createLabel(node,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.ImageTextEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createRadioGroup_2009(EObject domainElement, View containerView, int index, boolean persisted,
		PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
			.getType(org.unicase.uiModeling.diagram.edit.parts.RadioGroupEditPart.VISUAL_ID));
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
		Node label5014 = createLabel(node,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.RadioGroupTextEditPart.VISUAL_ID));
		createCompartment(
			node,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.RadioGroupRadioButtonsCompartmentEditPart.VISUAL_ID),
			false, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createCheckboxGroup_2010(EObject domainElement, View containerView, int index, boolean persisted,
		PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
			.getType(org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupEditPart.VISUAL_ID));
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
		Node label5015 = createLabel(node,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupTextEditPart.VISUAL_ID));
		createCompartment(
			node,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupCheckboxesCompartmentEditPart.VISUAL_ID),
			false, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDropdownList_2011(EObject domainElement, View containerView, int index, boolean persisted,
		PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
			.getType(org.unicase.uiModeling.diagram.edit.parts.DropdownListEditPart.VISUAL_ID));
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
		Node label5018 = createLabel(node,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.WrappingLabelEditPart.VISUAL_ID));
		createCompartment(
			node,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.DropdownListDropdownItemsCompartmentEditPart.VISUAL_ID),
			false, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createImageButton_2012(EObject domainElement, View containerView, int index, boolean persisted,
		PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
			.getType(org.unicase.uiModeling.diagram.edit.parts.ImageButtonEditPart.VISUAL_ID));
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
		return node;
	}

	/**
	 * @generated
	 */
	public Node createButton_3001(EObject domainElement, View containerView, int index, boolean persisted,
		PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
			.getType(org.unicase.uiModeling.diagram.edit.parts.Button2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
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
		Node label5011 = createLabel(node,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.ButtonText2EditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createImage_3002(EObject domainElement, View containerView, int index, boolean persisted,
		PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
			.getType(org.unicase.uiModeling.diagram.edit.parts.Image2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
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
		Node label5007 = createLabel(node,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.ImageText2EditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createLabel_3003(EObject domainElement, View containerView, int index, boolean persisted,
		PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
			.getType(org.unicase.uiModeling.diagram.edit.parts.Label2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
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
		Node label5008 = createLabel(node,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.LabelText2EditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createText_3004(EObject domainElement, View containerView, int index, boolean persisted,
		PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
			.getType(org.unicase.uiModeling.diagram.edit.parts.Text2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
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
		Node label5009 = createLabel(node,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.TextText2EditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createTextField_3005(EObject domainElement, View containerView, int index, boolean persisted,
		PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
			.getType(org.unicase.uiModeling.diagram.edit.parts.TextField2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
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
		Node label5010 = createLabel(node,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.TextFieldText2EditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createRadioGroup_3009(EObject domainElement, View containerView, int index, boolean persisted,
		PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
			.getType(org.unicase.uiModeling.diagram.edit.parts.RadioGroup2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
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
		Node label5019 = createLabel(node,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.RadioGroupText2EditPart.VISUAL_ID));
		createCompartment(
			node,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.RadioGroupRadioButtonsCompartment2EditPart.VISUAL_ID),
			false, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createRadioButton_3006(EObject domainElement, View containerView, int index, boolean persisted,
		PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
			.getType(org.unicase.uiModeling.diagram.edit.parts.RadioButtonEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
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
		Node label5013 = createLabel(node,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.RadioButtonTextEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createCheckboxGroup_3010(EObject domainElement, View containerView, int index, boolean persisted,
		PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
			.getType(org.unicase.uiModeling.diagram.edit.parts.CheckboxGroup2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
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
		Node label5020 = createLabel(node,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupText2EditPart.VISUAL_ID));
		createCompartment(
			node,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.CheckboxGroupCheckboxesCompartment2EditPart.VISUAL_ID),
			false, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createCheckbox_3007(EObject domainElement, View containerView, int index, boolean persisted,
		PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
			.getType(org.unicase.uiModeling.diagram.edit.parts.CheckboxEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
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
		Node label5016 = createLabel(node,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.CheckboxTextEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDropdownList_3011(EObject domainElement, View containerView, int index, boolean persisted,
		PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
			.getType(org.unicase.uiModeling.diagram.edit.parts.DropdownList2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
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
		Node label5021 = createLabel(node,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.WrappingLabel2EditPart.VISUAL_ID));
		createCompartment(
			node,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.DropdownListDropdownItemsCompartment2EditPart.VISUAL_ID),
			false, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDropdownItem_3008(EObject domainElement, View containerView, int index, boolean persisted,
		PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
			.getType(org.unicase.uiModeling.diagram.edit.parts.DropdownItemEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
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
		Node label5017 = createLabel(node,
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
				.getType(org.unicase.uiModeling.diagram.edit.parts.DropdownItemTextEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createImageButton_3012(EObject domainElement, View containerView, int index, boolean persisted,
		PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
			.getType(org.unicase.uiModeling.diagram.edit.parts.ImageButton2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
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
		return node;
	}

	/**
	 * @generated
	 */
	private void stampShortcut(View containerView, Node target) {
		if (!org.unicase.uiModeling.diagram.edit.parts.PanelEditPart.MODEL_ID
			.equals(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put(
				"modelID", org.unicase.uiModeling.diagram.edit.parts.PanelEditPart.MODEL_ID); //$NON-NLS-1$
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
	private Node createCompartment(View owner, String hint, boolean canCollapse, boolean hasTitle, boolean canSort,
		boolean canFilter) {
		//SemanticListCompartment rv = NotationFactory.eINSTANCE.createSemanticListCompartment();
		//rv.setShowTitle(showTitle);
		//rv.setCollapsed(isCollapsed);
		Node rv;
		if (canCollapse) {
			rv = NotationFactory.eINSTANCE.createBasicCompartment();
		} else {
			rv = NotationFactory.eINSTANCE.createDecorationNode();
		}
		if (hasTitle) {
			TitleStyle ts = NotationFactory.eINSTANCE.createTitleStyle();
			ts.setShowTitle(true);
			rv.getStyles().add(ts);
		}
		if (canSort) {
			rv.getStyles().add(NotationFactory.eINSTANCE.createSortingStyle());
		}
		if (canFilter) {
			rv.getStyles().add(NotationFactory.eINSTANCE.createFilteringStyle());
		}
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
