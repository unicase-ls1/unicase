package org.unicase.ui.usecaseDiagram.unicase;

import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

public abstract class ShadowShape extends AbstractProportionalShape {

	private static final Color SHADOW_COLOR = new Color(null, 150, 150, 150);
	private static final int SHADOW_SIZE = 3;
	private static final Insets SHADOW_INSETS = new Insets(0, 0, SHADOW_SIZE, SHADOW_SIZE);

	public ShadowShape(boolean is3D, Color backgroundColor, Color foregroundColor) {
		setForegroundColor(foregroundColor);
		setBackgroundColor(backgroundColor);
		myBorder = new ShadowBorder();
		setBorder(myBorder);
		set3D(is3D);
	}

	protected boolean is3D() {
		return my3D;
	}

	public void set3D(boolean is3D) {
		if (my3D == is3D) {
			return;
		}
		my3D = is3D;
		repaint();
	}

	public Dimension getPreferredSize(int wHint, int hHint) {
		Dimension original = super.getPreferredSize(wHint, hHint);
		if (is3D()) {
			original.expand(SHADOW_SIZE, SHADOW_SIZE);
		}
		return original;
	}

	/**
	 * Paints this figure, including its border and children.
	 * Border is painted first.
	 */
	public void paint(Graphics graphics) {
		paintBorder(graphics);
		if (getBackgroundColor() != null)
			graphics.setBackgroundColor(getBackgroundColor());
		if (getForegroundColor() != null)
			graphics.setForegroundColor(getForegroundColor());
		if (getFont() != null)
			graphics.setFont(getFont());
		paintFigure(graphics);
		paintClientArea(graphics);
	}

	protected void fillShape(Graphics graphics) {
		fillShape(graphics, getProportionalBounds());
	}

	protected abstract void fillShape(Graphics graphics, Rectangle bounds);

	protected void outlineShape(Graphics graphics) {
		outlineShape(graphics, getProportionalBounds());
	}

	protected abstract void outlineShape(Graphics graphics, Rectangle bounds);

	private class ShadowBorder extends AbstractBorder {

		public Insets getInsets(IFigure figure) {
			return is3D() ? SHADOW_INSETS : IFigure.NO_INSETS;
		}

		public boolean isOpaque() {
			return is3D();
		}

		public void paint(IFigure figure, Graphics graphics, Insets insets) {
			if (!is3D()) {
				return;
			}
			graphics.setBackgroundColor(SHADOW_COLOR);
			Rectangle rec = getProportionalBounds().getTranslated(SHADOW_SIZE, SHADOW_SIZE);
			graphics.pushState();
			graphics.clipRect(rec);
			// graphics.setClip(new Rectangle(rec.x, rec.y + rec.height - getShift(), rec.width, getShift()));
			fillShape(graphics, rec);
			graphics.popState();
			// graphics.setClip(new Rectangle(rec.x + rec.width - getShift(), rec.y, getShift(), rec.height));
			// fillShape(graphics, rec);
		}

	}

	private boolean my3D;
	private Border myBorder;

}