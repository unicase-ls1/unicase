/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui.widgets;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.CompositeImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.unicase.changetracking.release.ChangePackageState;
import org.unicase.changetracking.release.ReleaseCheckReport;
import org.unicase.changetracking.release.ReleaseUtil;
import org.unicase.changetracking.ui.Activator;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.task.WorkItem;

/**
 * Label provider for change packages which displays their state by overlaying a
 * decoration icon.
 * 
 * The change package state is only defined during release checking and can be
 * ERROR, MERGED, or UNMERGED.
 * 
 * @author jfinis
 * 
 */
public class ChangePackageStateLabelProvider implements ILabelProvider {

	/* decoration images */
	private static final ImageData ERROR_DECORATION_IMAGE = Activator.getImageDescriptor("icons/decorators/error.gif").getImageData();
	private static final ImageData MERGED_DECORATION_IMAGE = Activator.getImageDescriptor("icons/decorators/merged.gif").getImageData();
	private static final ImageData UNMERGED_DECORATION_IMAGE = Activator.getImageDescriptor("icons/decorators/unmerged.gif").getImageData();
	private static final ImageData OPEN_DECORATION_IMAGE = Activator.getImageDescriptor("icons/decorators/open.png").getImageData();
	private static final ImageData WARNING_DECORATION_IMAGE = Activator.getImageDescriptor("icons/decorators/warning.gif").getImageData();

	/* Basic change package image */
	private static final Image CHANGE_PACKAGE_IMAGE = Activator.getImageDescriptor("icons/ChangePackage.gif").createImage();

	private static final Map<ChangePackageState, ImageData> DECORATION_MAPPING = new HashMap<ChangePackageState, ImageData>();
	static {
		DECORATION_MAPPING.put(ChangePackageState.ERROR, ERROR_DECORATION_IMAGE);
		DECORATION_MAPPING.put(ChangePackageState.MERGED, MERGED_DECORATION_IMAGE);
		DECORATION_MAPPING.put(ChangePackageState.UNMERGED, UNMERGED_DECORATION_IMAGE);
	}

	/**
	 * Generates an icon for a specific change package state.
	 * 
	 * @param state change package state
	 * @return icon
	 */
	public Image generateImage(ChangePackageState state) {
		return new Image(CHANGE_PACKAGE_IMAGE.getDevice(), new DecorationImageDescriptor(CHANGE_PACKAGE_IMAGE, state).getImageData());
	}

	private AdapterFactoryLabelProvider wrappedProvider;
	private ReleaseCheckReport report;

	/**
	 * default constructor taking a release checking report from which the
	 * package status is taken.
	 * 
	 * @param report release checking report
	 */
	public ChangePackageStateLabelProvider(ReleaseCheckReport report) {
		wrappedProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		this.report = report;
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage(Object element) {
		if (element instanceof ChangePackage) {
			Image img = wrappedProvider.getImage(element);
			ChangePackageState state = report.getChangePackageResults().get(element);
			if (state == null) {
				state = ChangePackageState.ERROR;
			}
			img = new Image(img.getDevice(), new DecorationImageDescriptor(img, state).getImageData());
			return img;
		} else if (element instanceof WorkItem) {
			Image img = wrappedProvider.getImage(element);
			if (!((WorkItem) element).isResolved()) {
				img = new Image(img.getDevice(), new DecorationImageDescriptor(img, OPEN_DECORATION_IMAGE).getImageData());
			} else if (!ReleaseUtil.workItemHasChangePackage(((WorkItem) element))) {
				img = new Image(img.getDevice(), new DecorationImageDescriptor(img, WARNING_DECORATION_IMAGE).getImageData());
			}
			return img;
		} else {
			return wrappedProvider.getImage(element);
		}
	}

	/**
	 * Text is not decorated at all.
	 * 
	 * @param element input element
	 * @return undecorated text.
	 */
	public String getText(Object element) {
		return wrappedProvider.getText(element);
	}

	/**
	 * {@inheritDoc}
	 */
	public void addListener(ILabelProviderListener listener) {
		wrappedProvider.addListener(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		wrappedProvider.dispose();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isLabelProperty(Object element, String property) {
		return wrappedProvider.isLabelProperty(element, property);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeListener(ILabelProviderListener listener) {
		wrappedProvider.removeListener(listener);
	}

	/**
	 * 
	 * Decorator that adds the decorating image to an image.
	 * 
	 * @author jfinis
	 * 
	 */
	private final class DecorationImageDescriptor extends CompositeImageDescriptor {

		private ImageData imageData;
		private ImageData decorationData;

		private DecorationImageDescriptor(Image image, ChangePackageState state) {
			this.imageData = image.getImageData();
			this.decorationData = DECORATION_MAPPING.get(state);
		}

		private DecorationImageDescriptor(Image image, ImageData decoration) {
			this.imageData = image.getImageData();
			this.decorationData = decoration;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected void drawCompositeImage(int width, int height) {

			// Draw base image.
			drawImage(imageData, 0, 0);

			// Add decoration
			drawImage(decorationData, imageData.width - decorationData.width, 0);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected Point getSize() {
			return new Point(imageData.width, imageData.height);
		}

	}

}
