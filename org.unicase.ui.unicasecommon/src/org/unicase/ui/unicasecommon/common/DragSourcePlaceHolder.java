package org.unicase.ui.unicasecommon.common;

import java.util.List;

/**
 * This class is just a temporary location to hold dragSource in a DnD
 * operation. Typically we should not have used such a class to keep track of
 * dragSource. Instead, one should use a transfer class. This is not the case
 * because of the following:
 * 
 * <ol>
 * <li>Using a transfer is not guaranteed to work on all platforms and always.</li>
 * <li>On platforms other than Windows, dragSource is not set until drop event
 * fires and we need dragSource during events like dragOver</li>
 * <li>We are not planning to drop something out of ECP environment, i.e. form
 * ECP navigator on file system.</li>
 * </ol>
 * 
 * This class is intended to be used as a singleton.
 * 
 * @author Hodaie
 */
public final class DragSourcePlaceHolder {

	private static Object dragSource;

	/**
	 * Initializes the singleton instance statically.
	 */
	private static class SingletonHolder {
		public static final DragSourcePlaceHolder INSTANCE = new DragSourcePlaceHolder();
	}

	/**
	 * Returns the singleton instance.
	 * 
	 * @return The DragSourcePlaceHolder instance
	 */
	public static DragSourcePlaceHolder getInstance() {
		return SingletonHolder.INSTANCE;
	}

	/**
	 * Private constructor.
	 */
	private DragSourcePlaceHolder() {

	}

	/**
	 * This method will be called from drag adaptors, in dragStart() event. This
	 * sets the drag source on which initially the drag started. This can be a
	 * single object of a collection.
	 * 
	 * @param dragSource
	 *            the drag source
	 */
	@SuppressWarnings("rawtypes")
	public static void setDragSource(Object dragSource) {
		if ((dragSource instanceof List) && ((List) dragSource).size() == 0) {
			DragSourcePlaceHolder.dragSource = null;
		}
		DragSourcePlaceHolder.dragSource = dragSource;
	}

	/**
	 * This will be called from drop adaptors to get the drag source.
	 * 
	 * @return drag source; object(s) on which drag started
	 */
	public static Object getDragSource() {
		return dragSource;
	}

}
