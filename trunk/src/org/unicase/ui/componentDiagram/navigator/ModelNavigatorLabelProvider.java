package org.unicase.ui.componentDiagram.navigator;

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
import org.unicase.model.component.Component;
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
		org.unicase.ui.componentDiagram.part.ModelDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		org.unicase.ui.componentDiagram.part.ModelDiagramEditorPlugin
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
		if (element instanceof org.unicase.ui.componentDiagram.navigator.ModelNavigatorItem
				&& !isOwnView(((org.unicase.ui.componentDiagram.navigator.ModelNavigatorItem) element)
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
		if (element instanceof org.unicase.ui.componentDiagram.navigator.ModelNavigatorGroup) {
			org.unicase.ui.componentDiagram.navigator.ModelNavigatorGroup group = (org.unicase.ui.componentDiagram.navigator.ModelNavigatorGroup) element;
			return org.unicase.ui.componentDiagram.part.ModelDiagramEditorPlugin
					.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof org.unicase.ui.componentDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.componentDiagram.navigator.ModelNavigatorItem navigatorItem = (org.unicase.ui.componentDiagram.navigator.ModelNavigatorItem) element;
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
		switch (org.unicase.ui.componentDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.componentDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://unicase.org/model/diagram?MEDiagram", org.unicase.ui.componentDiagram.providers.ModelElementTypes.MEDiagram_99); //$NON-NLS-1$
		case org.unicase.ui.componentDiagram.edit.parts.ComponentEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/component?ComponentService", org.unicase.ui.componentDiagram.providers.ModelElementTypes.ComponentService_1001); //$NON-NLS-1$
		case org.unicase.ui.componentDiagram.edit.parts.Component2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/component?Component", org.unicase.ui.componentDiagram.providers.ModelElementTypes.Component_1002); //$NON-NLS-1$
		case org.unicase.ui.componentDiagram.edit.parts.ComponentOfferedServicesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/component?Component?offeredServices", org.unicase.ui.componentDiagram.providers.ModelElementTypes.ComponentOfferedServices_3001); //$NON-NLS-1$
		case org.unicase.ui.componentDiagram.edit.parts.ComponentConsumedServicesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/component?Component?consumedServices", org.unicase.ui.componentDiagram.providers.ModelElementTypes.ComponentConsumedServices_3002); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = org.unicase.ui.componentDiagram.part.ModelDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null
				&& elementType != null
				&& org.unicase.ui.componentDiagram.providers.ModelElementTypes
						.isKnownElementType(elementType)) {
			image = org.unicase.ui.componentDiagram.providers.ModelElementTypes
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
		if (element instanceof org.unicase.ui.componentDiagram.navigator.ModelNavigatorGroup) {
			org.unicase.ui.componentDiagram.navigator.ModelNavigatorGroup group = (org.unicase.ui.componentDiagram.navigator.ModelNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof org.unicase.ui.componentDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.componentDiagram.navigator.ModelNavigatorItem navigatorItem = (org.unicase.ui.componentDiagram.navigator.ModelNavigatorItem) element;
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
		switch (org.unicase.ui.componentDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.componentDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getMEDiagram_99Text(view);
		case org.unicase.ui.componentDiagram.edit.parts.ComponentEditPart.VISUAL_ID:
			return getComponentService_1001Text(view);
		case org.unicase.ui.componentDiagram.edit.parts.Component2EditPart.VISUAL_ID:
			return getComponent_1002Text(view);
		case org.unicase.ui.componentDiagram.edit.parts.ComponentOfferedServicesEditPart.VISUAL_ID:
			return getComponentOfferedServices_3001Text(view);
		case org.unicase.ui.componentDiagram.edit.parts.ComponentConsumedServicesEditPart.VISUAL_ID:
			return getComponentConsumedServices_3002Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getMEDiagram_99Text(View view) {
		MEDiagram domainModelElement = (MEDiagram) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			org.unicase.ui.componentDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"No domain element for view with visualID = " + 99); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getComponentService_1001Text(View view) {
		IAdaptable hintAdapter = new org.unicase.ui.componentDiagram.providers.ModelParserProvider.HintAdapter(
				org.unicase.ui.componentDiagram.providers.ModelElementTypes.ComponentService_1001,
				(view.getElement() != null ? view.getElement() : view),
				org.unicase.ui.componentDiagram.part.ModelVisualIDRegistry
						.getType(org.unicase.ui.componentDiagram.edit.parts.ComponentNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			org.unicase.ui.componentDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 4001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getComponent_1002Text(View view) {
		IAdaptable hintAdapter = new org.unicase.ui.componentDiagram.providers.ModelParserProvider.HintAdapter(
				org.unicase.ui.componentDiagram.providers.ModelElementTypes.Component_1002,
				(view.getElement() != null ? view.getElement() : view),
				org.unicase.ui.componentDiagram.part.ModelVisualIDRegistry
						.getType(org.unicase.ui.componentDiagram.edit.parts.ComponentName2EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			org.unicase.ui.componentDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 4002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getComponentOfferedServices_3001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getComponentConsumedServices_3002Text(View view) {
		return ""; //$NON-NLS-1$
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
		return org.unicase.ui.componentDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
				.equals(org.unicase.ui.componentDiagram.part.ModelVisualIDRegistry
						.getModelID(view));
	}

}
