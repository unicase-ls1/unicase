package org.unicase.rap.ui.labelproviders;

import java.util.Map;
import java.util.HashMap;

import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;

import org.unicase.model.task.WorkItem;
import org.unicase.model.task.util.MEState;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.task.util.CircularDependencyException;

import org.unicase.rap.Activator;


/**
 * This label provider shows the status of a modelelement represented as an image.
 * 
 * @author helming
 */
public class StatusLabelProvider extends ColumnLabelProvider implements IColorProvider {

	private Map<String, Image> images;
	private static final String OPEN = "open";
	private static final String CLOSED = "closed";
	private static final String BLOCKED = "blocked";
	private static final String OPEN_RESOLVED = "open_resolved";

	/**
	 * Constructor.
	 */
	public StatusLabelProvider() {
		images = new HashMap<String, Image>();

		ImageDescriptor imageDescriptor = Activator.getImageDescriptor("icons/open.png");
		images.put(OPEN, imageDescriptor.createImage());

		imageDescriptor = Activator.getImageDescriptor("icons/closed.gif");
		images.put(CLOSED, imageDescriptor.createImage());

		imageDescriptor = Activator.getImageDescriptor("icons/blocked.gif");
		images.put(BLOCKED, imageDescriptor.createImage());

		imageDescriptor = Activator.getImageDescriptor("icons/open_resolved.png");
		images.put(OPEN_RESOLVED, imageDescriptor.createImage());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.BaseLabelProvider#dispose()
	 */
	@Override
	public void dispose() {
		images.clear();
		super.dispose();
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		if (element instanceof UnicaseModelElement) {
			UnicaseModelElement me = (UnicaseModelElement) element;
			String status = MEState.CLOSED;
			try {
				status = me.getMEState().getStatus();
			} catch (CircularDependencyException e) {
				// JH Auto-generated catch block
				e.printStackTrace();
			}

			if (status.equals(MEState.OPEN)) {
				if (me instanceof WorkItem && ((WorkItem) me).isResolved()) {
					return images.get(OPEN_RESOLVED);
				}
				return images.get(OPEN);

			} else if (status.equals(MEState.CLOSED)) {
				return images.get(CLOSED);

			} else if (status.equals(MEState.BLOCKED)) {
				return images.get(BLOCKED);
			}

		}
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		return "";
	}

}