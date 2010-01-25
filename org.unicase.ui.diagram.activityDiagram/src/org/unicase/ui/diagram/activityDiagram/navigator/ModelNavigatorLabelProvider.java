/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.activityDiagram.navigator;

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
import org.unicase.model.activity.ActivityEnd;
import org.unicase.model.activity.ActivityInitial;
import org.unicase.model.activity.Branch;
import org.unicase.model.activity.Fork;
import org.unicase.model.diagram.MEDiagram;

/**
 * @generated
 */
public class ModelNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		org.unicase.ui.diagram.activityDiagram.part.ModelDiagramEditorPlugin.getInstance().getImageRegistry().put(
			"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		org.unicase.ui.diagram.activityDiagram.part.ModelDiagramEditorPlugin.getInstance().getImageRegistry().put(
			"Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof org.unicase.ui.diagram.activityDiagram.navigator.ModelNavigatorItem
			&& !isOwnView(((org.unicase.ui.diagram.activityDiagram.navigator.ModelNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	@Override
	public Image getImage(Object element) {
		if (element instanceof org.unicase.ui.diagram.activityDiagram.navigator.ModelNavigatorGroup) {
			org.unicase.ui.diagram.activityDiagram.navigator.ModelNavigatorGroup group = (org.unicase.ui.diagram.activityDiagram.navigator.ModelNavigatorGroup) element;
			return org.unicase.ui.diagram.activityDiagram.part.ModelDiagramEditorPlugin.getInstance().getBundledImage(
				group.getIcon());
		}

		if (element instanceof org.unicase.ui.diagram.activityDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.diagram.activityDiagram.navigator.ModelNavigatorItem navigatorItem = (org.unicase.ui.diagram.activityDiagram.navigator.ModelNavigatorItem) element;
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
		switch (org.unicase.ui.diagram.activityDiagram.part.ModelVisualIDRegistry.getVisualID(view)) {
		case org.unicase.ui.diagram.activityDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Diagram?http://unicase.org/model/diagram?MEDiagram", org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.MEDiagram_22); //$NON-NLS-1$
		case org.unicase.ui.diagram.activityDiagram.edit.parts.ActivityEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/activity?Activity", org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Activity_2002); //$NON-NLS-1$
		case org.unicase.ui.diagram.activityDiagram.edit.parts.ForkEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/activity?Fork", org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Fork_2003); //$NON-NLS-1$
		case org.unicase.ui.diagram.activityDiagram.edit.parts.ActivityInitialEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/activity?ActivityInitial", org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.ActivityInitial_2004); //$NON-NLS-1$
		case org.unicase.ui.diagram.activityDiagram.edit.parts.ActivityEndEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/activity?ActivityEnd", org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.ActivityEnd_2005); //$NON-NLS-1$
		case org.unicase.ui.diagram.activityDiagram.edit.parts.BranchEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/activity?Branch", org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Branch_2006); //$NON-NLS-1$
		case org.unicase.ui.diagram.activityDiagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/activity?Transition", org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Transition_4001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = org.unicase.ui.diagram.activityDiagram.part.ModelDiagramEditorPlugin
			.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
			&& org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.isKnownElementType(elementType)) {
			image = org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.getImage(elementType);
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
	@Override
	public String getText(Object element) {
		if (element instanceof org.unicase.ui.diagram.activityDiagram.navigator.ModelNavigatorGroup) {
			org.unicase.ui.diagram.activityDiagram.navigator.ModelNavigatorGroup group = (org.unicase.ui.diagram.activityDiagram.navigator.ModelNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof org.unicase.ui.diagram.activityDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.diagram.activityDiagram.navigator.ModelNavigatorItem navigatorItem = (org.unicase.ui.diagram.activityDiagram.navigator.ModelNavigatorItem) element;
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
		switch (org.unicase.ui.diagram.activityDiagram.part.ModelVisualIDRegistry.getVisualID(view)) {
		case org.unicase.ui.diagram.activityDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getMEDiagram_22Text(view);
		case org.unicase.ui.diagram.activityDiagram.edit.parts.ActivityEditPart.VISUAL_ID:
			return getActivity_2002Text(view);
		case org.unicase.ui.diagram.activityDiagram.edit.parts.ForkEditPart.VISUAL_ID:
			return getFork_2003Text(view);
		case org.unicase.ui.diagram.activityDiagram.edit.parts.ActivityInitialEditPart.VISUAL_ID:
			return getActivityInitial_2004Text(view);
		case org.unicase.ui.diagram.activityDiagram.edit.parts.ActivityEndEditPart.VISUAL_ID:
			return getActivityEnd_2005Text(view);
		case org.unicase.ui.diagram.activityDiagram.edit.parts.BranchEditPart.VISUAL_ID:
			return getBranch_2006Text(view);
		case org.unicase.ui.diagram.activityDiagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return getTransition_4001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getMEDiagram_22Text(View view) {
		MEDiagram domainModelElement = (MEDiagram) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			org.unicase.ui.diagram.activityDiagram.part.ModelDiagramEditorPlugin.getInstance().logError(
				"No domain element for view with visualID = " + 22); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActivity_2002Text(View view) {
		IAdaptable hintAdapter = new org.unicase.ui.diagram.activityDiagram.providers.ModelParserProvider.HintAdapter(
			org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Activity_2002,
			(view.getElement() != null ? view.getElement() : view),
			org.unicase.ui.diagram.activityDiagram.part.ModelVisualIDRegistry
				.getType(org.unicase.ui.diagram.activityDiagram.edit.parts.ActivityNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE.intValue());
		} else {
			org.unicase.ui.diagram.activityDiagram.part.ModelDiagramEditorPlugin.getInstance().logError(
				"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getFork_2003Text(View view) {
		Fork domainModelElement = (Fork) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			org.unicase.ui.diagram.activityDiagram.part.ModelDiagramEditorPlugin.getInstance().logError(
				"No domain element for view with visualID = " + 2003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActivityInitial_2004Text(View view) {
		ActivityInitial domainModelElement = (ActivityInitial) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			org.unicase.ui.diagram.activityDiagram.part.ModelDiagramEditorPlugin.getInstance().logError(
				"No domain element for view with visualID = " + 2004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActivityEnd_2005Text(View view) {
		ActivityEnd domainModelElement = (ActivityEnd) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			org.unicase.ui.diagram.activityDiagram.part.ModelDiagramEditorPlugin.getInstance().logError(
				"No domain element for view with visualID = " + 2005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getBranch_2006Text(View view) {
		Branch domainModelElement = (Branch) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			org.unicase.ui.diagram.activityDiagram.part.ModelDiagramEditorPlugin.getInstance().logError(
				"No domain element for view with visualID = " + 2006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTransition_4001Text(View view) {
		IAdaptable hintAdapter = new org.unicase.ui.diagram.activityDiagram.providers.ModelParserProvider.HintAdapter(
			org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Transition_4001,
			(view.getElement() != null ? view.getElement() : view),
			org.unicase.ui.diagram.activityDiagram.part.ModelVisualIDRegistry
				.getType(org.unicase.ui.diagram.activityDiagram.edit.parts.TransitionConditionEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE.intValue());
		} else {
			org.unicase.ui.diagram.activityDiagram.part.ModelDiagramEditorPlugin.getInstance().logError(
				"Parser was not found for label " + 6001); //$NON-NLS-1$
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
		return org.unicase.ui.diagram.activityDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
			.equals(org.unicase.ui.diagram.activityDiagram.part.ModelVisualIDRegistry.getModelID(view));
	}

}
