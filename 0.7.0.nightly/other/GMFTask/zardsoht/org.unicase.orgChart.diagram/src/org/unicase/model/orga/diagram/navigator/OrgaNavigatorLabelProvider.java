package org.unicase.model.orga.diagram.navigator;

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
import org.unicase.model.orga.OrgDiagram;
import org.unicase.model.orga.diagram.edit.parts.EmployeeEditPart;
import org.unicase.model.orga.diagram.edit.parts.EmployeeNameEditPart;
import org.unicase.model.orga.diagram.edit.parts.OrgDiagramEditPart;
import org.unicase.model.orga.diagram.edit.parts.TeamEditPart;
import org.unicase.model.orga.diagram.edit.parts.TeamHasOrgUnitEditPart;
import org.unicase.model.orga.diagram.edit.parts.TeamNameEditPart;
import org.unicase.model.orga.diagram.part.OrgaDiagramEditorPlugin;
import org.unicase.model.orga.diagram.part.OrgaVisualIDRegistry;
import org.unicase.model.orga.diagram.providers.OrgaElementTypes;
import org.unicase.model.orga.diagram.providers.OrgaParserProvider;

/**
 * @generated
 */
public class OrgaNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		OrgaDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		OrgaDiagramEditorPlugin
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
		if (element instanceof OrgaNavigatorItem
				&& !isOwnView(((OrgaNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof OrgaNavigatorGroup) {
			OrgaNavigatorGroup group = (OrgaNavigatorGroup) element;
			return OrgaDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof OrgaNavigatorItem) {
			OrgaNavigatorItem navigatorItem = (OrgaNavigatorItem) element;
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
		switch (OrgaVisualIDRegistry.getVisualID(view)) {
		case OrgDiagramEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://unicase.org/model/orga?OrgDiagram", OrgaElementTypes.OrgDiagram_1000); //$NON-NLS-1$
		case EmployeeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/orga?Employee", OrgaElementTypes.Employee_2001); //$NON-NLS-1$
		case TeamEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/orga?Team", OrgaElementTypes.Team_2002); //$NON-NLS-1$
		case TeamHasOrgUnitEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/orga?Team?hasOrgUnit", OrgaElementTypes.TeamHasOrgUnit_4001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = OrgaDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& OrgaElementTypes.isKnownElementType(elementType)) {
			image = OrgaElementTypes.getImage(elementType);
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
		if (element instanceof OrgaNavigatorGroup) {
			OrgaNavigatorGroup group = (OrgaNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof OrgaNavigatorItem) {
			OrgaNavigatorItem navigatorItem = (OrgaNavigatorItem) element;
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
		switch (OrgaVisualIDRegistry.getVisualID(view)) {
		case OrgDiagramEditPart.VISUAL_ID:
			return getOrgDiagram_1000Text(view);
		case EmployeeEditPart.VISUAL_ID:
			return getEmployee_2001Text(view);
		case TeamEditPart.VISUAL_ID:
			return getTeam_2002Text(view);
		case TeamHasOrgUnitEditPart.VISUAL_ID:
			return getTeamHasOrgUnit_4001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getOrgDiagram_1000Text(View view) {
		OrgDiagram domainModelElement = (OrgDiagram) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			OrgaDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEmployee_2001Text(View view) {
		IParser parser = OrgaParserProvider.getParser(
				OrgaElementTypes.Employee_2001,
				view.getElement() != null ? view.getElement() : view,
				OrgaVisualIDRegistry.getType(EmployeeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			OrgaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTeam_2002Text(View view) {
		IParser parser = OrgaParserProvider.getParser(
				OrgaElementTypes.Team_2002, view.getElement() != null ? view
						.getElement() : view, OrgaVisualIDRegistry
						.getType(TeamNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			OrgaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTeamHasOrgUnit_4001Text(View view) {
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
		return OrgDiagramEditPart.MODEL_ID.equals(OrgaVisualIDRegistry
				.getModelID(view));
	}

}
