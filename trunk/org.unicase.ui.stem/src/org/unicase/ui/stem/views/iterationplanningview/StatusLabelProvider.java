package org.unicase.ui.stem.views.iterationplanningview;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.ModelElement;
import org.unicase.model.task.util.CircularDependencyException;
import org.unicase.model.task.util.MEState;

public class StatusLabelProvider extends ColumnLabelProvider implements
		IColorProvider {

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		if (element instanceof ModelElement) {
			ModelElement me = (ModelElement) element;
			String status = MEState.CLOSED;
			try {
				status = me.getMEState().getStatus();
			} catch (CircularDependencyException e) {
				// JH Auto-generated catch block
				e.printStackTrace();
			}

			String path = "icons/closed.jpg";;
			if (status.equals(MEState.OPEN)) {
				path = "icons/open.gif";
			}
			if (status.equals(MEState.BLOCKED)) {
				path = "icons/blocked.jpg";
			} 
			URL url = FileLocator.find(Platform
					.getBundle("org.unicase.ui.stem"), new Path(path), null);
			ImageDescriptor imageDescriptor = ImageDescriptor
					.createFromURL(url);
			return imageDescriptor.createImage();

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
