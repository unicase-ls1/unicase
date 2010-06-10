package org.unicase.model.urml.ui.diagram.navigator;

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
import org.unicase.model.urml.Stakeholder;
import org.unicase.model.urml.URMLDiagram;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureParentFeatureEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.Stakeholder2EditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.StakeholderEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.StakeholderGoalsEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.URMLDiagramEditPart;
import org.unicase.model.urml.ui.diagram.part.UrmlDiagramEditorPlugin;
import org.unicase.model.urml.ui.diagram.part.UrmlVisualIDRegistry;
import org.unicase.model.urml.ui.diagram.providers.UrmlElementTypes;

import urml.goal.Goal;

/**
 * @generated
 */
public class UrmlNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		UrmlDiagramEditorPlugin.getInstance().getImageRegistry().put(
			"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		UrmlDiagramEditorPlugin.getInstance().getImageRegistry().put(
			"Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof UrmlNavigatorItem && !isOwnView(((UrmlNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof UrmlNavigatorGroup) {
			UrmlNavigatorGroup group = (UrmlNavigatorGroup) element;
			return UrmlDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof UrmlNavigatorItem) {
			UrmlNavigatorItem navigatorItem = (UrmlNavigatorItem) element;
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
		switch (UrmlVisualIDRegistry.getVisualID(view)) {
		case URMLDiagramEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Diagram?http://unicase.org/model/urml?URMLDiagram", UrmlElementTypes.URMLDiagram_1000); //$NON-NLS-1$
		case StakeholderEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/urml?Stakeholder", UrmlElementTypes.Stakeholder_2002); //$NON-NLS-1$
		case GoalEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/urml/goal?Goal", UrmlElementTypes.Goal_2001); //$NON-NLS-1$
		case Stakeholder2EditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml?Stakeholder", UrmlElementTypes.Stakeholder_4001); //$NON-NLS-1$
		case FeatureParentFeatureEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml?Feature?parentFeature", UrmlElementTypes.FeatureParentFeature_4002); //$NON-NLS-1$
		case StakeholderGoalsEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/urml?Stakeholder?goals", UrmlElementTypes.StakeholderGoals_4003); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = UrmlDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && UrmlElementTypes.isKnownElementType(elementType)) {
			image = UrmlElementTypes.getImage(elementType);
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
		if (element instanceof UrmlNavigatorGroup) {
			UrmlNavigatorGroup group = (UrmlNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof UrmlNavigatorItem) {
			UrmlNavigatorItem navigatorItem = (UrmlNavigatorItem) element;
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
		switch (UrmlVisualIDRegistry.getVisualID(view)) {
		case URMLDiagramEditPart.VISUAL_ID:
			return getURMLDiagram_1000Text(view);
		case StakeholderEditPart.VISUAL_ID:
			return getStakeholder_2002Text(view);
		case GoalEditPart.VISUAL_ID:
			return getGoal_2001Text(view);
		case Stakeholder2EditPart.VISUAL_ID:
			return getStakeholder_4001Text(view);
		case FeatureParentFeatureEditPart.VISUAL_ID:
			return getFeatureParentFeature_4002Text(view);
		case StakeholderGoalsEditPart.VISUAL_ID:
			return getStakeholderGoals_4003Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getURMLDiagram_1000Text(View view) {
		URMLDiagram domainModelElement = (URMLDiagram) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStakeholder_2002Text(View view) {
		Stakeholder domainModelElement = (Stakeholder) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getGoal_2001Text(View view) {
		Goal domainModelElement = (Goal) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStakeholder_4001Text(View view) {
		Stakeholder domainModelElement = (Stakeholder) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			UrmlDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 4001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFeatureParentFeature_4002Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getStakeholderGoals_4003Text(View view) {
		return ""; //$NON-NLS-1$
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
		return URMLDiagramEditPart.MODEL_ID.equals(UrmlVisualIDRegistry.getModelID(view));
	}

}
