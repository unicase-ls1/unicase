package org.unicase.ui.diagram.urml.own.icons;

import org.eclipse.draw2d.ImageFigure;
import org.unicase.ui.diagram.urml.part.UrmlDiagramEditorPlugin;

public class StakeholderIcon extends ImageFigure {

	public StakeholderIcon() {
		super(UrmlDiagramEditorPlugin.getBundledImageDescriptor("/icons/stakeholder.jpg").createImage());
	}

	// @Override
	// protected void paintFigure(Graphics graphics) {
	// org.eclipse.draw2d.geometry.Rectangle r = getBounds().getCopy();
	// graphics.drawImage(UrmlDiagramEditorPlugin.getBundledImageDescriptor("/icons/goal.jpg").createImage(),r.x,r.y);
	// }

}
