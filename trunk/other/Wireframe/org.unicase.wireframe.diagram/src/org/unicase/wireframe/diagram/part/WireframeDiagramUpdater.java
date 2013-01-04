package org.unicase.wireframe.diagram.part;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.unicase.wireframe.Panel;
import org.unicase.wireframe.Widget;
import org.unicase.wireframe.diagram.edit.parts.ButtonEditPart;
import org.unicase.wireframe.diagram.edit.parts.ImageEditPart;
import org.unicase.wireframe.diagram.edit.parts.LabelEditPart;
import org.unicase.wireframe.diagram.edit.parts.PanelEditPart;
import org.unicase.wireframe.diagram.edit.parts.TextEditPart;
import org.unicase.wireframe.diagram.edit.parts.TextFieldEditPart;
import org.unicase.wireframe.diagram.edit.parts.WindowEditPart;

/**
 * @generated
 */
public class WireframeDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<WireframeNodeDescriptor> getSemanticChildren(View view) {
		switch (WireframeVisualIDRegistry.getVisualID(view)) {
		case PanelEditPart.VISUAL_ID:
			return getPanel_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WireframeNodeDescriptor> getPanel_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Panel modelElement = (Panel) view.getElement();
		LinkedList<WireframeNodeDescriptor> result = new LinkedList<WireframeNodeDescriptor>();
		for (Iterator<?> it = modelElement.getWidgets().iterator(); it.hasNext();) {
			Widget childElement = (Widget) it.next();
			int visualID = WireframeVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == WindowEditPart.VISUAL_ID) {
				result.add(new WireframeNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LabelEditPart.VISUAL_ID) {
				result.add(new WireframeNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TextFieldEditPart.VISUAL_ID) {
				result.add(new WireframeNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ButtonEditPart.VISUAL_ID) {
				result.add(new WireframeNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TextEditPart.VISUAL_ID) {
				result.add(new WireframeNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ImageEditPart.VISUAL_ID) {
				result.add(new WireframeNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WireframeLinkDescriptor> getContainedLinks(View view) {
		switch (WireframeVisualIDRegistry.getVisualID(view)) {
		case PanelEditPart.VISUAL_ID:
			return getPanel_1000ContainedLinks(view);
		case WindowEditPart.VISUAL_ID:
			return getWindow_2003ContainedLinks(view);
		case LabelEditPart.VISUAL_ID:
			return getLabel_2004ContainedLinks(view);
		case TextFieldEditPart.VISUAL_ID:
			return getTextField_2005ContainedLinks(view);
		case ButtonEditPart.VISUAL_ID:
			return getButton_2006ContainedLinks(view);
		case TextEditPart.VISUAL_ID:
			return getText_2007ContainedLinks(view);
		case ImageEditPart.VISUAL_ID:
			return getImage_2008ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WireframeLinkDescriptor> getIncomingLinks(View view) {
		switch (WireframeVisualIDRegistry.getVisualID(view)) {
		case WindowEditPart.VISUAL_ID:
			return getWindow_2003IncomingLinks(view);
		case LabelEditPart.VISUAL_ID:
			return getLabel_2004IncomingLinks(view);
		case TextFieldEditPart.VISUAL_ID:
			return getTextField_2005IncomingLinks(view);
		case ButtonEditPart.VISUAL_ID:
			return getButton_2006IncomingLinks(view);
		case TextEditPart.VISUAL_ID:
			return getText_2007IncomingLinks(view);
		case ImageEditPart.VISUAL_ID:
			return getImage_2008IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WireframeLinkDescriptor> getOutgoingLinks(View view) {
		switch (WireframeVisualIDRegistry.getVisualID(view)) {
		case WindowEditPart.VISUAL_ID:
			return getWindow_2003OutgoingLinks(view);
		case LabelEditPart.VISUAL_ID:
			return getLabel_2004OutgoingLinks(view);
		case TextFieldEditPart.VISUAL_ID:
			return getTextField_2005OutgoingLinks(view);
		case ButtonEditPart.VISUAL_ID:
			return getButton_2006OutgoingLinks(view);
		case TextEditPart.VISUAL_ID:
			return getText_2007OutgoingLinks(view);
		case ImageEditPart.VISUAL_ID:
			return getImage_2008OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WireframeLinkDescriptor> getPanel_1000ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WireframeLinkDescriptor> getWindow_2003ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WireframeLinkDescriptor> getLabel_2004ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WireframeLinkDescriptor> getTextField_2005ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WireframeLinkDescriptor> getButton_2006ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WireframeLinkDescriptor> getText_2007ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WireframeLinkDescriptor> getImage_2008ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WireframeLinkDescriptor> getWindow_2003IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WireframeLinkDescriptor> getLabel_2004IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WireframeLinkDescriptor> getTextField_2005IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WireframeLinkDescriptor> getButton_2006IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WireframeLinkDescriptor> getText_2007IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WireframeLinkDescriptor> getImage_2008IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WireframeLinkDescriptor> getWindow_2003OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WireframeLinkDescriptor> getLabel_2004OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WireframeLinkDescriptor> getTextField_2005OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WireframeLinkDescriptor> getButton_2006OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WireframeLinkDescriptor> getText_2007OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WireframeLinkDescriptor> getImage_2008OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		 * @generated
		 */

		public List<WireframeNodeDescriptor> getSemanticChildren(View view) {
			return WireframeDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */

		public List<WireframeLinkDescriptor> getContainedLinks(View view) {
			return WireframeDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */

		public List<WireframeLinkDescriptor> getIncomingLinks(View view) {
			return WireframeDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */

		public List<WireframeLinkDescriptor> getOutgoingLinks(View view) {
			return WireframeDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
