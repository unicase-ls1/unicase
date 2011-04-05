package org.unicase.ui.diagram.urml.own.icons;

import org.eclipse.draw2d.ImageFigure;
import org.unicase.ui.diagram.urml.part.UrmlDiagramEditorPlugin;

public class VariationPointInstanceIcon extends ImageFigure {

	public VariationPointInstanceIcon() {
		super(UrmlDiagramEditorPlugin.getBundledImageDescriptor("/icons/variationpointinstance.jpg").createImage());
	}

	// @Override
	// protected void paintFigure(Graphics graphics) {
	// org.eclipse.draw2d.geometry.Rectangle r = getBounds().getCopy();
	// graphics.drawImage(UrmlDiagramEditorPlugin.getBundledImageDescriptor("/icons/goal.jpg").createImage(),r.x,r.y);
	// }

}
