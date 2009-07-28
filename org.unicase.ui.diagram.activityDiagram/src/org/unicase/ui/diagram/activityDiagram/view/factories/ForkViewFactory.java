package org.unicase.ui.diagram.activityDiagram.view.factories;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ForkViewFactory extends AbstractShapeViewFactory {

	/**
	 * @generated
	 */
	@Override
	protected List createStyles(View view) {
		List styles = new ArrayList();
		ShapeStyle style = NotationFactory.eINSTANCE.createShapeStyle();
		style.setFillColor(Color.red.getRGB());
		styles.add(style);
		return styles;
	}

	/**
	 * @generated
	 */
	@Override
	protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint,
		int index, boolean persisted) {
		if (semanticHint == null) {
			semanticHint = org.unicase.ui.diagram.activityDiagram.part.ModelVisualIDRegistry
				.getType(org.unicase.ui.diagram.activityDiagram.edit.parts.ForkEditPart.VISUAL_ID);
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
		if (!org.unicase.ui.diagram.activityDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
			.equals(org.unicase.ui.diagram.activityDiagram.part.ModelVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put(
				"modelID", org.unicase.ui.diagram.activityDiagram.edit.parts.MEDiagramEditPart.MODEL_ID); //$NON-NLS-1$
			view.getEAnnotations().add(shortcutAnnotation);
		}
	}
}
