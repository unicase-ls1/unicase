package org.unicase.uiModeling.diagram;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.unicase.ui.unicasecommon.diagram.util.EditPartUtility;
import org.unicase.uiModeling.UiModelingPackage;
import org.unicase.uiModeling.diagram.util.UiModelingDiagramUtil;

/**
 * This adapter extension will update elements in UI Modeling diagrams based on attribute changes of the underlying
 * model elements.
 * 
 * @author mharut
 */
public class UiModelingAdapter extends AdapterImpl {
	/**
	 * The attribute specifying whether or not positioning is enabled for a UI Modeling diagram.
	 */
	private static final EAttribute POSITIONING_ENABLED = UiModelingPackage.eINSTANCE.getPanel_PositioningEnabled();
	/**
	 * The attribute specifying whether or not automatic sizing is enabled for a UI Modeling diagram.
	 */
	private static final EAttribute SIZING_ENABLED = UiModelingPackage.eINSTANCE.getPanel_SizingEnabled();
	/**
	 * The attribute specifying a widget's width.
	 */
	private static final EAttribute WIDGET_WIDTH = UiModelingPackage.eINSTANCE.getWidget_Width();
	/**
	 * The attribute specifying a widget's height.
	 */
	private static final EAttribute WIDGET_HEIGHT = UiModelingPackage.eINSTANCE.getWidget_Height();
	/**
	 * The attribute specifying a widget's X-coordinate.
	 */
	private static final EAttribute WIDGET_X = UiModelingPackage.eINSTANCE.getWidget_X();
	/**
	 * The attribute specifying a widget's Y-coordinate.
	 */
	private static final EAttribute WIDGET_Y = UiModelingPackage.eINSTANCE.getWidget_Y();
	/**
	 * The edit part to update on model element changes.
	 */
	private final ShapeNodeEditPart editPart;
	/**
	 * The container of the UI Modeling diagram.
	 */
	private final EObject diagramContainer;
	/**
	 * The element this adapter is listening to attribute changes for.
	 */
	private final EObject element;
	/**
	 * The computed size of {@link #editPart}.
	 */
	protected Dimension size;
	/**
	 * The computed location of {@link #editPart}.
	 */
	protected Point location;

	/**
	 * Constructs a new adapter for a specific edit part.
	 * 
	 * @param editPart the edit part to construct this adapter for
	 */
	public UiModelingAdapter(ShapeNodeEditPart editPart) {
		this.editPart = editPart;
		this.element = EditPartUtility.getElement(editPart);
		diagramContainer = EditPartUtility.getDiagramEditPart(editPart).getDiagramView().eContainer();
	}

	/**
	 * {@inheritDoc}
	 */
	public void notifyChanged(Notification notification) {
		Object notifier = notification.getNotifier();

		// only change layout if this element or the diagram element changed
		if (element == notifier || diagramContainer == notifier) {

			boolean changed = false;
			Point newLocation = getLocation(notification);
			if (newLocation != null) {
				location = newLocation;
				changed = true;
			}
			Dimension newSize = getSize(notification);
			if (newSize != null) {
				size = newSize;
				changed = true;
			}

			// only update layout if either size or location have changed
			if (changed) {
				updateLayout();
			}
		}
	}

	/**
	 * Retrieves the new size of the edit part of this adapter.
	 */
	private Dimension getSize(Notification notification) {
		Dimension result;
		if (requiresUpdate(notification, SIZING_ENABLED, WIDGET_WIDTH, WIDGET_HEIGHT)) {
			result = UiModelingDiagramUtil.getSize(editPart);
		} else {
			result = null;
		}
		return result;
	}

	/**
	 * Retrieves the new location of the edit part of this adapter.
	 */
	private Point getLocation(Notification notification) {
		Point result;
		if (requiresUpdate(notification, POSITIONING_ENABLED, WIDGET_X, WIDGET_Y)) {
			result = UiModelingDiagramUtil.getLocation(editPart);
		} else {
			result = null;
		}
		return result;
	}

	/**
	 * Checks whether an update for the layout of this edit part is required or not.
	 * 
	 * @param notification the notification that initially notified this adapter
	 * @param boolAttribute the boolean attribute to check for notification changes
	 * @param firstFeature first feature to check for changes
	 * @param secondFeature second feature to check for changes
	 * @return whether the layout of this edit part needs to be updated or not
	 */
	private boolean requiresUpdate(Notification notification, EAttribute boolAttribute, EAttribute firstFeature,
		EAttribute secondFeature) {
		Object feature = notification.getFeature();
		EObject notifier = (EObject) notification.getNotifier();
		if (boolAttribute.equals(feature) && notification.getNewBooleanValue() == true && diagramContainer == notifier) {
			return true;
		}
		if ((firstFeature.equals(feature) || secondFeature.equals(feature)) && notifier.eIsSet(firstFeature)
			&& notifier.eIsSet(secondFeature) && element == notifier) {
			return true;
		}
		return false;
	}

	/**
	 * Updates the layout of this edit part based on {@link #size} and {@link #location}.
	 */
	private void updateLayout() {
		if (size == null) {
			size = UiModelingDiagramUtil.getSize(editPart);
		}
		if (location == null) {
			location = UiModelingDiagramUtil.getLocation(editPart);
		}
		Rectangle layoutConstraint = new Rectangle(location.x, location.y, size.width, size.height);
		editPart.setLayoutConstraint(editPart, editPart.getFigure(), layoutConstraint);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isAdapterForType(Object type) {
		return element.eClass().isInstance(type);
	}

	/**
	 * Adds this adapter to the adapter list of its element.
	 */
	public void adapt() {
		element.eAdapters().add(this);
	}
}
