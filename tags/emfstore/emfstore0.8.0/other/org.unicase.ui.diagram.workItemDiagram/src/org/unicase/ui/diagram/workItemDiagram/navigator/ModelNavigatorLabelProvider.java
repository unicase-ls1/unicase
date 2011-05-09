package org.unicase.ui.diagram.workItemDiagram.navigator;

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
		org.unicase.ui.diagram.workItemDiagram.part.ModelDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		org.unicase.ui.diagram.workItemDiagram.part.ModelDiagramEditorPlugin
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
		if (element instanceof org.unicase.ui.diagram.workItemDiagram.navigator.ModelNavigatorItem
				&& !isOwnView(((org.unicase.ui.diagram.workItemDiagram.navigator.ModelNavigatorItem) element)
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
		if (element instanceof org.unicase.ui.diagram.workItemDiagram.navigator.ModelNavigatorGroup) {
			org.unicase.ui.diagram.workItemDiagram.navigator.ModelNavigatorGroup group = (org.unicase.ui.diagram.workItemDiagram.navigator.ModelNavigatorGroup) element;
			return org.unicase.ui.diagram.workItemDiagram.part.ModelDiagramEditorPlugin
					.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof org.unicase.ui.diagram.workItemDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.diagram.workItemDiagram.navigator.ModelNavigatorItem navigatorItem = (org.unicase.ui.diagram.workItemDiagram.navigator.ModelNavigatorItem) element;
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
		switch (org.unicase.ui.diagram.workItemDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.diagram.workItemDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://unicase.org/model/diagram?MEDiagram", org.unicase.ui.diagram.workItemDiagram.providers.ModelElementTypes.MEDiagram_33); //$NON-NLS-1$
		case org.unicase.ui.diagram.workItemDiagram.edit.parts.ActionItemEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/task?ActionItem", org.unicase.ui.diagram.workItemDiagram.providers.ModelElementTypes.ActionItem_2001); //$NON-NLS-1$
		case org.unicase.ui.diagram.workItemDiagram.edit.parts.IssueEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/rationale?Issue", org.unicase.ui.diagram.workItemDiagram.providers.ModelElementTypes.Issue_2002); //$NON-NLS-1$
		case org.unicase.ui.diagram.workItemDiagram.edit.parts.BugReportEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/bug?BugReport", org.unicase.ui.diagram.workItemDiagram.providers.ModelElementTypes.BugReport_2003); //$NON-NLS-1$
		case org.unicase.ui.diagram.workItemDiagram.edit.parts.WorkItemSuccessorsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/task?WorkItem?successors", org.unicase.ui.diagram.workItemDiagram.providers.ModelElementTypes.WorkItemSuccessors_4003); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = org.unicase.ui.diagram.workItemDiagram.part.ModelDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null
				&& elementType != null
				&& org.unicase.ui.diagram.workItemDiagram.providers.ModelElementTypes
						.isKnownElementType(elementType)) {
			image = org.unicase.ui.diagram.workItemDiagram.providers.ModelElementTypes
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
		if (element instanceof org.unicase.ui.diagram.workItemDiagram.navigator.ModelNavigatorGroup) {
			org.unicase.ui.diagram.workItemDiagram.navigator.ModelNavigatorGroup group = (org.unicase.ui.diagram.workItemDiagram.navigator.ModelNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof org.unicase.ui.diagram.workItemDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.diagram.workItemDiagram.navigator.ModelNavigatorItem navigatorItem = (org.unicase.ui.diagram.workItemDiagram.navigator.ModelNavigatorItem) element;
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
		switch (org.unicase.ui.diagram.workItemDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.diagram.workItemDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getMEDiagram_33Text(view);
		case org.unicase.ui.diagram.workItemDiagram.edit.parts.ActionItemEditPart.VISUAL_ID:
			return getActionItem_2001Text(view);
		case org.unicase.ui.diagram.workItemDiagram.edit.parts.IssueEditPart.VISUAL_ID:
			return getIssue_2002Text(view);
		case org.unicase.ui.diagram.workItemDiagram.edit.parts.BugReportEditPart.VISUAL_ID:
			return getBugReport_2003Text(view);
		case org.unicase.ui.diagram.workItemDiagram.edit.parts.WorkItemSuccessorsEditPart.VISUAL_ID:
			return getWorkItemSuccessors_4003Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getMEDiagram_33Text(View view) {
		MEDiagram domainModelElement = (MEDiagram) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			org.unicase.ui.diagram.workItemDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"No domain element for view with visualID = " + 33); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActionItem_2001Text(View view) {
		IAdaptable hintAdapter = new org.unicase.ui.diagram.workItemDiagram.providers.ModelParserProvider.HintAdapter(
				org.unicase.ui.diagram.workItemDiagram.providers.ModelElementTypes.ActionItem_2001,
				(view.getElement() != null ? view.getElement() : view),
				org.unicase.ui.diagram.workItemDiagram.part.ModelVisualIDRegistry
						.getType(org.unicase.ui.diagram.workItemDiagram.edit.parts.ActionItemNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			org.unicase.ui.diagram.workItemDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getIssue_2002Text(View view) {
		IAdaptable hintAdapter = new org.unicase.ui.diagram.workItemDiagram.providers.ModelParserProvider.HintAdapter(
				org.unicase.ui.diagram.workItemDiagram.providers.ModelElementTypes.Issue_2002,
				(view.getElement() != null ? view.getElement() : view),
				org.unicase.ui.diagram.workItemDiagram.part.ModelVisualIDRegistry
						.getType(org.unicase.ui.diagram.workItemDiagram.edit.parts.IssueNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			org.unicase.ui.diagram.workItemDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getBugReport_2003Text(View view) {
		IAdaptable hintAdapter = new org.unicase.ui.diagram.workItemDiagram.providers.ModelParserProvider.HintAdapter(
				org.unicase.ui.diagram.workItemDiagram.providers.ModelElementTypes.BugReport_2003,
				(view.getElement() != null ? view.getElement() : view),
				org.unicase.ui.diagram.workItemDiagram.part.ModelVisualIDRegistry
						.getType(org.unicase.ui.diagram.workItemDiagram.edit.parts.BugReportNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			org.unicase.ui.diagram.workItemDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getWorkItemSuccessors_4003Text(View view) {

		IAdaptable hintAdapter = new org.unicase.ui.diagram.workItemDiagram.providers.ModelParserProvider.HintAdapter(
				org.unicase.ui.diagram.workItemDiagram.providers.ModelElementTypes.WorkItemSuccessors_4003,
				(view.getElement() != null ? view.getElement() : view),
				org.unicase.ui.diagram.workItemDiagram.part.ModelVisualIDRegistry
						.getType(org.unicase.ui.diagram.workItemDiagram.edit.parts.SuccessorLabelEditPart.VISUAL_ID));
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
		return org.unicase.ui.diagram.workItemDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
				.equals(org.unicase.ui.diagram.workItemDiagram.part.ModelVisualIDRegistry
						.getModelID(view));
	}

}
