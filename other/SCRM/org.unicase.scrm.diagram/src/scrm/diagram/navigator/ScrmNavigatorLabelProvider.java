package scrm.diagram.navigator;

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

import scrm.SCRMDiagram;
import scrm.diagram.edit.parts.MathematicalModelEditPart;
import scrm.diagram.edit.parts.NumericalMethodEditPart;
import scrm.diagram.edit.parts.NumericalMethodMathematicalModelEditPart;
import scrm.diagram.edit.parts.SCRMDiagramEditPart;
import scrm.diagram.part.ScrmDiagramEditorPlugin;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;
import scrm.knowledge.MathematicalModel;
import scrm.knowledge.NumericalMethod;

/**
 * @generated
 */
public class ScrmNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		ScrmDiagramEditorPlugin.getInstance().getImageRegistry().put(
			"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		ScrmDiagramEditorPlugin.getInstance().getImageRegistry().put(
			"Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof ScrmNavigatorItem && !isOwnView(((ScrmNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof ScrmNavigatorGroup) {
			ScrmNavigatorGroup group = (ScrmNavigatorGroup) element;
			return ScrmDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof ScrmNavigatorItem) {
			ScrmNavigatorItem navigatorItem = (ScrmNavigatorItem) element;
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
		switch (ScrmVisualIDRegistry.getVisualID(view)) {
		case SCRMDiagramEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Diagram?http://unicase.org/model/scrm?SCRMDiagram", ScrmElementTypes.SCRMDiagram_1000); //$NON-NLS-1$
		case MathematicalModelEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/scrm/knowledge?MathematicalModel", ScrmElementTypes.MathematicalModel_2001); //$NON-NLS-1$
		case NumericalMethodEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/scrm/knowledge?NumericalMethod", ScrmElementTypes.NumericalMethod_2002); //$NON-NLS-1$
		case NumericalMethodMathematicalModelEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/scrm/knowledge?NumericalMethod?mathematicalModel", ScrmElementTypes.NumericalMethodMathematicalModel_4003); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = ScrmDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && ScrmElementTypes.isKnownElementType(elementType)) {
			image = ScrmElementTypes.getImage(elementType);
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
		if (element instanceof ScrmNavigatorGroup) {
			ScrmNavigatorGroup group = (ScrmNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof ScrmNavigatorItem) {
			ScrmNavigatorItem navigatorItem = (ScrmNavigatorItem) element;
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
		switch (ScrmVisualIDRegistry.getVisualID(view)) {
		case SCRMDiagramEditPart.VISUAL_ID:
			return getSCRMDiagram_1000Text(view);
		case MathematicalModelEditPart.VISUAL_ID:
			return getMathematicalModel_2001Text(view);
		case NumericalMethodEditPart.VISUAL_ID:
			return getNumericalMethod_2002Text(view);
		case NumericalMethodMathematicalModelEditPart.VISUAL_ID:
			return getNumericalMethodMathematicalModel_4003Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getSCRMDiagram_1000Text(View view) {
		SCRMDiagram domainModelElement = (SCRMDiagram) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getDiagramLayout();
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMathematicalModel_2001Text(View view) {
		MathematicalModel domainModelElement = (MathematicalModel) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getNumericalMethod_2002Text(View view) {
		NumericalMethod domainModelElement = (NumericalMethod) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			ScrmDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getNumericalMethodMathematicalModel_4003Text(View view) {
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
		return SCRMDiagramEditPart.MODEL_ID.equals(ScrmVisualIDRegistry.getModelID(view));
	}

}
