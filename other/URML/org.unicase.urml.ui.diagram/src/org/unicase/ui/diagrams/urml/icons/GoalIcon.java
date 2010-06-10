package org.unicase.ui.diagrams.urml.icons;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.unicase.model.urml.ui.diagram.part.UrmlDiagramEditorPlugin;

public class GoalIcon extends Figure {

	@Override
	protected void paintFigure(Graphics graphics) {
		org.eclipse.draw2d.geometry.Rectangle r = getBounds().getCopy();
		graphics.drawImage(UrmlDiagramEditorPlugin.getBundledImageDescriptor("/icons/goal.jpg").createImage(),r.x,r.y);
	}

}
