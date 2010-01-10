package org.unicase.ui.tom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.FreeformViewport;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.swt.graphics.Color;
import org.unicase.ui.tom.notifications.MultiTouchAdapterImpl;
import org.unicase.ui.tom.notifications.TouchAdapterImpl;
import org.unicase.ui.tom.tools.TouchConstants;
import org.unicase.ui.tom.touches.MultiTouch;
import org.unicase.ui.tom.touches.SingleTouch;
import org.unicase.ui.tom.touches.Touch;
import org.unicase.ui.unicasecommon.diagram.part.ModelDiagramEditor;

public class TouchVisualizer {

	private final Map<SingleTouch, TouchFigure> touchMap = new HashMap<SingleTouch, TouchFigure>();
	private Map<MultiTouch, Color> colorMap = new HashMap<MultiTouch, Color>();;

	private FreeformViewport freeformViewport;

	private ModelDiagramEditor activeEditor;
	private final MySingleTouchAdapterImpl singleTouchAdapter = new MySingleTouchAdapterImpl();
	private final MyMultiTouchAdapterImpl multiTouchAdapter = new MyMultiTouchAdapterImpl();

	private class MyMultiTouchAdapterImpl extends MultiTouchAdapterImpl {

		@Override
		public void handleTouchClaimed(MultiTouch touch) {
			handleMultiTouchClaimed(touch);
		}
		
	}
	
	private class MySingleTouchAdapterImpl extends TouchAdapterImpl {

		@Override
		public void handleTouchAdded(SingleTouch touch) {
			handleSingleTouchAdded(touch);
		}

		@Override
		public void handleTouchChanged(SingleTouch touch) {
			handleSingleTouchChanged(touch);
		}

		@Override
		public void handleTouchRemoved(SingleTouch touch) {
			handleSingleTouchRemoved(touch);
		}
		
	}
	
	private static final class ColorSwitch {
		static int colorIndex = 0;

		protected static Color getNext() {
			colorIndex++;
			colorIndex %= 5;

			switch (colorIndex) {
			case 0:
				return ColorConstants.lightBlue;
			case 1:
				return ColorConstants.orange;
			case 2:
				return ColorConstants.lightGreen;
			case 3:
				return ColorConstants.yellow;
			case 4:
				return ColorConstants.red;
			default:
				return ColorConstants.black;
			}
		}
	}

	private void addTouch(SingleTouch addedTouch) {

		MultiTouch multiTouch = addedTouch.getMultiTouch();
		Color color = colorMap.get(multiTouch);

		if (color == null) {
			color = ColorSwitch.getNext();
			colorMap.put(multiTouch, color);
		}

		TouchFigure touchFigure = new TouchFigure(addedTouch, color);

		touchMap.put(addedTouch, touchFigure);
		freeformViewport.add(touchFigure);

		Point point = new Point(addedTouch.getX() - touchFigure.getSize().width
				/ 2, addedTouch.getY() - touchFigure.getSize().height / 2);

		touchFigure.setLocation(point);
	}

	private void removeAllTouches() {
		for (TouchFigure touchFigure : touchMap.values()) {
			freeformViewport.remove(touchFigure);
		}
		touchMap.clear();
	}

	private void removeTouch(Touch removedTouch) {
		TouchFigure touchFigure = touchMap.get(removedTouch);
		freeformViewport.remove(touchFigure);
		touchMap.remove(removedTouch);
	}

	private class TouchFigure extends Shape {

		private int innerCircleDiameter;
		private int outerCircleDiameter;

		public TouchFigure(Touch touch, Color color) {
			super();

			outerCircleDiameter = TouchConstants.MULTITOUCH_DIAMETER;
			innerCircleDiameter = TouchConstants.TOUCH_DIAMETER;

			setMaximumSize(new Dimension(outerCircleDiameter,
					outerCircleDiameter));
			setMinimumSize(new Dimension(outerCircleDiameter,
					outerCircleDiameter));

			setSize(new Dimension(outerCircleDiameter, outerCircleDiameter));

			setBackgroundColor(color);
			setForegroundColor(color);
		}

		/**
		 * Fills the ellipse.
		 * 
		 * @see org.eclipse.draw2d.Shape#fillShape(org.eclipse.draw2d.Graphics)
		 */
		protected void fillShape(Graphics graphics) {

			Rectangle r = Rectangle.SINGLETON;
			r.setBounds(getBounds());
			r.x += outerCircleDiameter / 2 - innerCircleDiameter / 2;
			r.y += outerCircleDiameter / 2 - innerCircleDiameter / 2;

			r.width = innerCircleDiameter;
			r.height = innerCircleDiameter;

			graphics.fillOval(r);
		}

		/**
		 * Outlines the ellipse.
		 * 
		 * @see org.eclipse.draw2d.Shape#outlineShape(org.eclipse.draw2d.Graphics)
		 */
		protected void outlineShape(Graphics graphics) {
			Rectangle r = Rectangle.SINGLETON;
			r.setBounds(getBounds());
			r.width--;
			r.height--;
			r.shrink((lineWidth - 1) / 2, (lineWidth - 1) / 2);
			graphics.drawOval(r);

			r.setBounds(getBounds());
			r.x += outerCircleDiameter / 2 - innerCircleDiameter / 2;
			r.y += outerCircleDiameter / 2 - innerCircleDiameter / 2;

			r.width = innerCircleDiameter;
			r.height = innerCircleDiameter;

			r.width--;
			r.height--;
			r.shrink((lineWidth - 1) / 2, (lineWidth - 1) / 2);
			graphics.drawOval(r);
		}

	}
	
	public void handleMultiTouchClaimed(MultiTouch claimedTouch) {
		List<SingleTouch> activeTouches = claimedTouch.getActiveTouches();
		for (Touch touch : activeTouches) {
			TouchFigure touchFigure = touchMap.get(touch);
			if (touchFigure == null) {
				continue;
			}
			Color someColor = ColorConstants.lightGray;
			Color gray = new Color(someColor.getDevice(), 230, 230, 230);
			touchFigure.setForegroundColor(gray);
			touchFigure.setBackgroundColor(gray);			
		}
	}
	
	public void handleSingleTouchAdded(SingleTouch addedTouch) {
		if (activeEditor == null) {
			return;
		}
		addTouch(addedTouch);
	}

	public void handleSingleTouchChanged(Touch changedTouch) {
		if (activeEditor == null) {
			return;
		}
		TouchFigure touchFigure = touchMap.get(changedTouch);
		if (touchFigure == null) {
			return;
		}

		Point point = new Point(changedTouch.getX()
				- touchFigure.getSize().width / 2,
				changedTouch.getY() - touchFigure.getSize().height / 2);

		touchFigure.setLocation(point);
	}

	public void handleSingleTouchRemoved(Touch removedTouch) {
		if (activeEditor == null) {
			return;
		}
		removeTouch(removedTouch);
	}

	public void setActiveEditor(ModelDiagramEditor activeEditor) {
		this.activeEditor = activeEditor;

		if (activeEditor == null) {
			removeAllTouches();

			freeformViewport = null;
		} else {
			FigureCanvas canvas;
			ModelDiagramEditor activeModelDiagramEditor;
			GraphicalViewer graphicalViewer;

			activeModelDiagramEditor = (ModelDiagramEditor) getActiveEditor();
			graphicalViewer = (GraphicalViewer) activeModelDiagramEditor
					.getAdapter(GraphicalViewer.class);
			if (graphicalViewer != null) {
				canvas = (FigureCanvas) graphicalViewer.getControl();

				LightweightSystem activeLightweightSystem = canvas
						.getLightweightSystem();
				IFigure rootFigure = activeLightweightSystem.getRootFigure();

				if (rootFigure != null) {
					freeformViewport = (FreeformViewport) rootFigure
							.getChildren().get(0);
				}
			}
		}
	}

	public ModelDiagramEditor getActiveEditor() {
		return activeEditor;
	}

	public TouchAdapterImpl getSingleTouchAdapter() {
		return singleTouchAdapter;
	}

	public MyMultiTouchAdapterImpl getMultiTouchAdapter() {
		return multiTouchAdapter;
	}
}
