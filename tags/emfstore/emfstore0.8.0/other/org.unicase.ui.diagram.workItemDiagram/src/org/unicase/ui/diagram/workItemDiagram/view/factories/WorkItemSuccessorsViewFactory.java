package org.unicase.ui.diagram.workItemDiagram.view.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.ConnectionViewFactory;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class WorkItemSuccessorsViewFactory extends ConnectionViewFactory {

	/**
	 * @generated
	 */
	protected List createStyles(View view) {
		List styles = new ArrayList();
		styles.add(NotationFactory.eINSTANCE.createConnectorStyle());
		styles.add(NotationFactory.eINSTANCE.createFontStyle());
		return styles;
	}

	/**
	 * @generated
	 */
	protected void decorateView(View containerView, View view,
			IAdaptable semanticAdapter, String semanticHint, int index,
			boolean persisted) {
		if (semanticHint == null) {
			semanticHint = org.unicase.ui.diagram.workItemDiagram.part.ModelVisualIDRegistry
					.getType(org.unicase.ui.diagram.workItemDiagram.edit.parts.WorkItemSuccessorsEditPart.VISUAL_ID);
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint,
				index, persisted);
		IAdaptable eObjectAdapter = null;
		getViewService()
				.createNode(
						eObjectAdapter,
						view,
						org.unicase.ui.diagram.workItemDiagram.part.ModelVisualIDRegistry
								.getType(org.unicase.ui.diagram.workItemDiagram.edit.parts.SuccessorLabelEditPart.VISUAL_ID),
						ViewUtil.APPEND, true, getPreferencesHint());
		getViewService()
				.createNode(
						eObjectAdapter,
						view,
						org.unicase.ui.diagram.workItemDiagram.part.ModelVisualIDRegistry
								.getType(org.unicase.ui.diagram.workItemDiagram.edit.parts.PredecessorLabelEditPart.VISUAL_ID),
						ViewUtil.APPEND, true, getPreferencesHint());
	}
}
