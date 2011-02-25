package org.unicase.ui.urmlDiagram.view.factories;

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
public class FunctionalRequirementRefinedRequirementViewFactory extends
		ConnectionViewFactory {

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
			semanticHint = org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
					.getType(org.unicase.ui.urmlDiagram.edit.parts.FunctionalRequirementRefinedRequirementEditPart.VISUAL_ID);
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint,
				index, persisted);
		IAdaptable eObjectAdapter = null;
		getViewService()
				.createNode(
						eObjectAdapter,
						view,
						org.unicase.ui.urmlDiagram.part.ModelVisualIDRegistry
								.getType(org.unicase.ui.urmlDiagram.edit.parts.RefineLabelEditPart.VISUAL_ID),
						ViewUtil.APPEND, true, getPreferencesHint());
	}
}
