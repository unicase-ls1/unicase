/*
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 *   accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.classDiagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.unicase.model.classes.Dependency;
import org.unicase.model.diagram.ClassDiagram;

/**
 * @generated
 */
public class ModelNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		org.unicase.ui.diagram.classDiagram.part.ModelDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		org.unicase.ui.diagram.classDiagram.part.ModelDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof org.unicase.ui.diagram.classDiagram.navigator.ModelNavigatorItem
				&& !isOwnView(((org.unicase.ui.diagram.classDiagram.navigator.ModelNavigatorItem) element)
						.getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof org.unicase.ui.diagram.classDiagram.navigator.ModelNavigatorGroup) {
			org.unicase.ui.diagram.classDiagram.navigator.ModelNavigatorGroup group = (org.unicase.ui.diagram.classDiagram.navigator.ModelNavigatorGroup) element;
			return org.unicase.ui.diagram.classDiagram.part.ModelDiagramEditorPlugin
					.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof org.unicase.ui.diagram.classDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.diagram.classDiagram.navigator.ModelNavigatorItem navigatorItem = (org.unicase.ui.diagram.classDiagram.navigator.ModelNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.diagram.classDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://unicase.org/model/diagram?ClassDiagram", org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.ClassDiagram_1000); //$NON-NLS-1$
		case org.unicase.ui.diagram.classDiagram.edit.parts.ClassEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/classes?Class", org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Class_2001); //$NON-NLS-1$
		case org.unicase.ui.diagram.classDiagram.edit.parts.PackageEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/classes?Package", org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Package_2002); //$NON-NLS-1$
		case org.unicase.ui.diagram.classDiagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/classes?Attribute", org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Attribute_3001); //$NON-NLS-1$
		case org.unicase.ui.diagram.classDiagram.edit.parts.MethodEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://unicase.org/model/classes?Method", org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Method_3002); //$NON-NLS-1$
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/classes?Association", org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4001); //$NON-NLS-1$
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/classes?Association", org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4002); //$NON-NLS-1$
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association3EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/classes?Association", org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4003); //$NON-NLS-1$
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association4EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/classes?Association", org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4004); //$NON-NLS-1$
		case org.unicase.ui.diagram.classDiagram.edit.parts.ClassSuperClassesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/classes?Class?superClasses", org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.ClassSuperClasses_4007); //$NON-NLS-1$
		case org.unicase.ui.diagram.classDiagram.edit.parts.DependencyEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/classes?Dependency", org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Dependency_4006); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = org.unicase.ui.diagram.classDiagram.part.ModelDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null
				&& elementType != null
				&& org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes
						.isKnownElementType(elementType)) {
			image = org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes
					.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof org.unicase.ui.diagram.classDiagram.navigator.ModelNavigatorGroup) {
			org.unicase.ui.diagram.classDiagram.navigator.ModelNavigatorGroup group = (org.unicase.ui.diagram.classDiagram.navigator.ModelNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof org.unicase.ui.diagram.classDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.diagram.classDiagram.navigator.ModelNavigatorItem navigatorItem = (org.unicase.ui.diagram.classDiagram.navigator.ModelNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.diagram.classDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getClassDiagram_1000Text(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.ClassEditPart.VISUAL_ID:
			return getClass_2001Text(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.PackageEditPart.VISUAL_ID:
			return getPackage_2002Text(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getAttribute_3001Text(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.MethodEditPart.VISUAL_ID:
			return getMethod_3002Text(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.AssociationEditPart.VISUAL_ID:
			return getAssociation_4001Text(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association2EditPart.VISUAL_ID:
			return getAssociation_4002Text(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association3EditPart.VISUAL_ID:
			return getAssociation_4003Text(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.Association4EditPart.VISUAL_ID:
			return getAssociation_4004Text(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.ClassSuperClassesEditPart.VISUAL_ID:
			return getClassSuperClasses_4007Text(view);
		case org.unicase.ui.diagram.classDiagram.edit.parts.DependencyEditPart.VISUAL_ID:
			return getDependency_4006Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getClassDiagram_1000Text(View view) {
		ClassDiagram domainModelElement = (ClassDiagram) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			org.unicase.ui.diagram.classDiagram.part.ModelDiagramEditorPlugin
					.getInstance()
					.logError(
							"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getClass_2001Text(View view) {
		IParser parser = org.unicase.ui.diagram.classDiagram.providers.ModelParserProvider
				.getParser(
						org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Class_2001,
						view.getElement() != null ? view.getElement() : view,
						org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
								.getType(org.unicase.ui.diagram.classDiagram.edit.parts.ClassNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			org.unicase.ui.diagram.classDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPackage_2002Text(View view) {
		IParser parser = org.unicase.ui.diagram.classDiagram.providers.ModelParserProvider
				.getParser(
						org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Package_2002,
						view.getElement() != null ? view.getElement() : view,
						org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
								.getType(org.unicase.ui.diagram.classDiagram.edit.parts.PackageNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			org.unicase.ui.diagram.classDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAttribute_3001Text(View view) {
		IParser parser = org.unicase.ui.diagram.classDiagram.providers.ModelParserProvider
				.getParser(
						org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Attribute_3001,
						view.getElement() != null ? view.getElement() : view,
						org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
								.getType(org.unicase.ui.diagram.classDiagram.edit.parts.AttributeEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			org.unicase.ui.diagram.classDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 3001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMethod_3002Text(View view) {
		IParser parser = org.unicase.ui.diagram.classDiagram.providers.ModelParserProvider
				.getParser(
						org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Method_3002,
						view.getElement() != null ? view.getElement() : view,
						org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
								.getType(org.unicase.ui.diagram.classDiagram.edit.parts.MethodEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			org.unicase.ui.diagram.classDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 3002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAssociation_4001Text(View view) {
		IParser parser = org.unicase.ui.diagram.classDiagram.providers.ModelParserProvider
				.getParser(
						org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4001,
						view.getElement() != null ? view.getElement() : view,
						org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
								.getType(org.unicase.ui.diagram.classDiagram.edit.parts.AssociationTypeEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			org.unicase.ui.diagram.classDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAssociation_4002Text(View view) {
		IParser parser = org.unicase.ui.diagram.classDiagram.providers.ModelParserProvider
				.getParser(
						org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4002,
						view.getElement() != null ? view.getElement() : view,
						org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
								.getType(org.unicase.ui.diagram.classDiagram.edit.parts.AssociationType2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			org.unicase.ui.diagram.classDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 6004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAssociation_4003Text(View view) {
		IParser parser = org.unicase.ui.diagram.classDiagram.providers.ModelParserProvider
				.getParser(
						org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4003,
						view.getElement() != null ? view.getElement() : view,
						org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
								.getType(org.unicase.ui.diagram.classDiagram.edit.parts.AssociationType3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			org.unicase.ui.diagram.classDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 6007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAssociation_4004Text(View view) {
		IParser parser = org.unicase.ui.diagram.classDiagram.providers.ModelParserProvider
				.getParser(
						org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Association_4004,
						view.getElement() != null ? view.getElement() : view,
						org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
								.getType(org.unicase.ui.diagram.classDiagram.edit.parts.AssociationType4EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			org.unicase.ui.diagram.classDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 6010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getClassSuperClasses_4007Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getDependency_4006Text(View view) {
		Dependency domainModelElement = (Dependency) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			org.unicase.ui.diagram.classDiagram.part.ModelDiagramEditorPlugin
					.getInstance()
					.logError(
							"No domain element for view with visualID = " + 4006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return org.unicase.ui.diagram.classDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
				.equals(org.unicase.ui.diagram.classDiagram.part.ModelVisualIDRegistry
						.getModelID(view));
	}

}
