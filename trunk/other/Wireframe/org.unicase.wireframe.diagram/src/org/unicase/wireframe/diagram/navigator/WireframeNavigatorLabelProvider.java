package org.unicase.wireframe.diagram.navigator;

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
import org.unicase.wireframe.Button;
import org.unicase.wireframe.Panel;
import org.unicase.wireframe.diagram.edit.parts.ButtonEditPart;
import org.unicase.wireframe.diagram.edit.parts.ImageEditPart;
import org.unicase.wireframe.diagram.edit.parts.ImageTextEditPart;
import org.unicase.wireframe.diagram.edit.parts.LabelEditPart;
import org.unicase.wireframe.diagram.edit.parts.LabelTextEditPart;
import org.unicase.wireframe.diagram.edit.parts.PanelEditPart;
import org.unicase.wireframe.diagram.edit.parts.TextEditPart;
import org.unicase.wireframe.diagram.edit.parts.TextFieldEditPart;
import org.unicase.wireframe.diagram.edit.parts.TextFieldTextEditPart;
import org.unicase.wireframe.diagram.edit.parts.TextTextEditPart;
import org.unicase.wireframe.diagram.edit.parts.WindowEditPart;
import org.unicase.wireframe.diagram.edit.parts.WindowTextEditPart;
import org.unicase.wireframe.diagram.part.WireframeDiagramEditorPlugin;
import org.unicase.wireframe.diagram.part.WireframeVisualIDRegistry;
import org.unicase.wireframe.diagram.providers.WireframeElementTypes;
import org.unicase.wireframe.diagram.providers.WireframeParserProvider;

/**
 * @generated
 */
public class WireframeNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider,
	ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		WireframeDiagramEditorPlugin.getInstance().getImageRegistry()
			.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		WireframeDiagramEditorPlugin.getInstance().getImageRegistry()
			.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof WireframeNavigatorItem && !isOwnView(((WireframeNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof WireframeNavigatorGroup) {
			WireframeNavigatorGroup group = (WireframeNavigatorGroup) element;
			return WireframeDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof WireframeNavigatorItem) {
			WireframeNavigatorItem navigatorItem = (WireframeNavigatorItem) element;
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
		switch (WireframeVisualIDRegistry.getVisualID(view)) {
		case PanelEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Diagram?http://unicase.org/model/wireframe?Panel", WireframeElementTypes.Panel_1000); //$NON-NLS-1$
		case WindowEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/wireframe?Window", WireframeElementTypes.Window_2003); //$NON-NLS-1$
		case LabelEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/wireframe?Label", WireframeElementTypes.Label_2004); //$NON-NLS-1$
		case TextFieldEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/wireframe?TextField", WireframeElementTypes.TextField_2005); //$NON-NLS-1$
		case ButtonEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/wireframe?Button", WireframeElementTypes.Button_2006); //$NON-NLS-1$
		case TextEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/wireframe?Text", WireframeElementTypes.Text_2007); //$NON-NLS-1$
		case ImageEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/wireframe?Image", WireframeElementTypes.Image_2008); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = WireframeDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && WireframeElementTypes.isKnownElementType(elementType)) {
			image = WireframeElementTypes.getImage(elementType);
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
		if (element instanceof WireframeNavigatorGroup) {
			WireframeNavigatorGroup group = (WireframeNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof WireframeNavigatorItem) {
			WireframeNavigatorItem navigatorItem = (WireframeNavigatorItem) element;
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
		switch (WireframeVisualIDRegistry.getVisualID(view)) {
		case PanelEditPart.VISUAL_ID:
			return getPanel_1000Text(view);
		case WindowEditPart.VISUAL_ID:
			return getWindow_2003Text(view);
		case LabelEditPart.VISUAL_ID:
			return getLabel_2004Text(view);
		case TextFieldEditPart.VISUAL_ID:
			return getTextField_2005Text(view);
		case ButtonEditPart.VISUAL_ID:
			return getButton_2006Text(view);
		case TextEditPart.VISUAL_ID:
			return getText_2007Text(view);
		case ImageEditPart.VISUAL_ID:
			return getImage_2008Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getPanel_1000Text(View view) {
		Panel domainModelElement = (Panel) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			WireframeDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getWindow_2003Text(View view) {
		IParser parser = WireframeParserProvider.getParser(WireframeElementTypes.Window_2003,
			view.getElement() != null ? view.getElement() : view,
			WireframeVisualIDRegistry.getType(WindowTextEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			WireframeDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLabel_2004Text(View view) {
		IParser parser = WireframeParserProvider.getParser(WireframeElementTypes.Label_2004,
			view.getElement() != null ? view.getElement() : view,
			WireframeVisualIDRegistry.getType(LabelTextEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			WireframeDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTextField_2005Text(View view) {
		IParser parser = WireframeParserProvider.getParser(WireframeElementTypes.TextField_2005,
			view.getElement() != null ? view.getElement() : view,
			WireframeVisualIDRegistry.getType(TextFieldTextEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			WireframeDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getButton_2006Text(View view) {
		Button domainModelElement = (Button) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			WireframeDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getText_2007Text(View view) {
		IParser parser = WireframeParserProvider.getParser(WireframeElementTypes.Text_2007,
			view.getElement() != null ? view.getElement() : view,
			WireframeVisualIDRegistry.getType(TextTextEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			WireframeDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getImage_2008Text(View view) {
		IParser parser = WireframeParserProvider.getParser(WireframeElementTypes.Image_2008,
			view.getElement() != null ? view.getElement() : view,
			WireframeVisualIDRegistry.getType(ImageTextEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		} else {
			WireframeDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5006); //$NON-NLS-1$
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
		return PanelEditPart.MODEL_ID.equals(WireframeVisualIDRegistry.getModelID(view));
	}

}
