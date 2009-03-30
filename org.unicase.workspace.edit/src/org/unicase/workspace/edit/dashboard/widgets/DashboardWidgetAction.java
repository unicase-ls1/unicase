/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.dashboard.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.workspace.edit.dashboard.DashboardImageUtil;

/**
 * An action button to be attached to the dashboard widgets.
 * 
 * @author Shterev
 */
public class DashboardWidgetAction extends ImageHyperlink {

	private Image image;
	private Image lightImage;
	private static final int DEFAULT_LIGHT_FACTOR = 200;

	/**
	 * Default constructor.
	 * 
	 * @param parent the parent
	 * @param imagePath the image path
	 */
	public DashboardWidgetAction(Composite parent, String imagePath) {
		this(parent, imagePath, DEFAULT_LIGHT_FACTOR);
	}

	/**
	 * Constructor with a manual light factor.
	 * 
	 * @param parent the parent
	 * @param imagePath the image path
	 * @param lightFactor the light factor
	 */
	public DashboardWidgetAction(Composite parent, String imagePath, int lightFactor) {
		super(parent, SWT.BOTTOM);
		image = DashboardImageUtil.getImage(imagePath);
		lightImage = DashboardImageUtil.getLightImage(imagePath, lightFactor);
		setImage(lightImage);
		addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				setImage(image);
			}

			@Override
			public void mouseExit(MouseEvent e) {
				setImage(lightImage);
			}
		});
	}

}
