package org.unicase.ui.usecaseDiagram.view.factories;

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
public class ActorParticipatedUseCasesViewFactory extends ConnectionViewFactory {

	/**
	 * @generated
	 */
	protected List createStyles(View view) {
		List styles = new ArrayList();
		styles.add(NotationFactory.eINSTANCE.createRoutingStyle());
		styles.add(NotationFactory.eINSTANCE.createFontStyle());
		return styles;
	}

	/**
	 * @generated
	 */
	protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint,
		int index, boolean persisted) {
		if (semanticHint == null) {
			semanticHint = org.unicase.ui.usecaseDiagram.part.ModelVisualIDRegistry
				.getType(org.unicase.ui.usecaseDiagram.edit.parts.ActorParticipatedUseCasesEditPart.VISUAL_ID);
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
		IAdaptable eObjectAdapter = null;
		getViewService().createNode(
			eObjectAdapter,
			view,
			org.unicase.ui.usecaseDiagram.part.ModelVisualIDRegistry
				.getType(org.unicase.ui.usecaseDiagram.edit.parts.LabelEditPart.VISUAL_ID), ViewUtil.APPEND, true,
			getPreferencesHint());
	}
}
