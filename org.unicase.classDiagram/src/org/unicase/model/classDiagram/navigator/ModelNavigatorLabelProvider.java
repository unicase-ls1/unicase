package org.unicase.model.classDiagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
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
import org.unicase.model.diagram.MEDiagram;

/**
 * @generated
 */
public class ModelNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		org.unicase.model.classDiagram.part.ModelDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		org.unicase.model.classDiagram.part.ModelDiagramEditorPlugin
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
		if (element instanceof org.unicase.model.classDiagram.navigator.ModelNavigatorItem
				&& !isOwnView(((org.unicase.model.classDiagram.navigator.ModelNavigatorItem) element)
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
		if (element instanceof org.unicase.model.classDiagram.navigator.ModelNavigatorGroup) {
			org.unicase.model.classDiagram.navigator.ModelNavigatorGroup group = (org.unicase.model.classDiagram.navigator.ModelNavigatorGroup) element;
			return org.unicase.model.classDiagram.part.ModelDiagramEditorPlugin
					.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof org.unicase.model.classDiagram.navigator.ModelNavigatorItem) {
			org.unicase.model.classDiagram.navigator.ModelNavigatorItem navigatorItem = (org.unicase.model.classDiagram.navigator.ModelNavigatorItem) element;
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
		switch (org.unicase.model.classDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://unicase.org/model/diagram?MEDiagram", org.unicase.model.classDiagram.providers.ModelElementTypes.MEDiagram_79); //$NON-NLS-1$
		case org.unicase.model.classDiagram.edit.parts.MEDiagram2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/classes?Class", org.unicase.model.classDiagram.providers.ModelElementTypes.Class_1001); //$NON-NLS-1$
		case org.unicase.model.classDiagram.edit.parts.AssociationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/classes?Association", org.unicase.model.classDiagram.providers.ModelElementTypes.Association_3001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = org.unicase.model.classDiagram.part.ModelDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null
				&& elementType != null
				&& org.unicase.model.classDiagram.providers.ModelElementTypes
						.isKnownElementType(elementType)) {
			image = org.unicase.model.classDiagram.providers.ModelElementTypes
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
		if (element instanceof org.unicase.model.classDiagram.navigator.ModelNavigatorGroup) {
			org.unicase.model.classDiagram.navigator.ModelNavigatorGroup group = (org.unicase.model.classDiagram.navigator.ModelNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof org.unicase.model.classDiagram.navigator.ModelNavigatorItem) {
			org.unicase.model.classDiagram.navigator.ModelNavigatorItem navigatorItem = (org.unicase.model.classDiagram.navigator.ModelNavigatorItem) element;
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
		switch (org.unicase.model.classDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getMEDiagram_79Text(view);
		case org.unicase.model.classDiagram.edit.parts.MEDiagram2EditPart.VISUAL_ID:
			return getClass_1001Text(view);
		case org.unicase.model.classDiagram.edit.parts.AssociationEditPart.VISUAL_ID:
			return getAssociation_3001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getMEDiagram_79Text(View view) {
		MEDiagram domainModelElement = (MEDiagram) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			org.unicase.model.classDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"No domain element for view with visualID = " + 79); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getClass_1001Text(View view) {

		IAdaptable hintAdapter = new org.unicase.model.classDiagram.providers.ModelParserProvider.HintAdapter(
				org.unicase.model.classDiagram.providers.ModelElementTypes.Class_1001,
				(view.getElement() != null ? view.getElement() : view),
				org.unicase.model.classDiagram.part.ModelVisualIDRegistry
						.getType(org.unicase.model.classDiagram.edit.parts.MEDiagramNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);
		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getAssociation_3001Text(View view) {

		IAdaptable hintAdapter = new org.unicase.model.classDiagram.providers.ModelParserProvider.HintAdapter(
				org.unicase.model.classDiagram.providers.ModelElementTypes.Association_3001,
				(view.getElement() != null ? view.getElement() : view),
				org.unicase.model.classDiagram.part.ModelVisualIDRegistry
						.getType(org.unicase.model.classDiagram.edit.parts.LabelEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);
		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$ //$NON-NLS-2$
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
		return org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
				.equals(org.unicase.model.classDiagram.part.ModelVisualIDRegistry
						.getModelID(view));
	}

}
