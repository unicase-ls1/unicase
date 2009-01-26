/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tableview.labelprovider;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

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

	/**
	 * Constructor.
	 */
	public StatusLabelProvider() {
		images = new HashMap<String, Image>();

		String path = "icons/open.gif";
		URL url = FileLocator.find(Platform.getBundle("org.unicase.ui.stem"), new Path(path), null);
		ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL(url);
		images.put(OPEN, imageDescriptor.createImage());

		path = "icons/closed.gif";
		url = FileLocator.find(Platform.getBundle("org.unicase.ui.stem"), new Path(path), null);
		imageDescriptor = ImageDescriptor.createFromURL(url);
		images.put(CLOSED, imageDescriptor.createImage());

		path = "icons/blocked.gif";
		url = FileLocator.find(Platform.getBundle("org.unicase.ui.stem"), new Path(path), null);
		imageDescriptor = ImageDescriptor.createFromURL(url);
		images.put(BLOCKED, imageDescriptor.createImage());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.BaseLabelProvider#dispose()
	 */
	@Override
	public void dispose() {

		images.get(OPEN).dispose();
		images.get(CLOSED).dispose();
		images.get(BLOCKED).dispose();

		images.clear();

		super.dispose();
	}

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

			if (status.equals(MEState.OPEN)) {
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
