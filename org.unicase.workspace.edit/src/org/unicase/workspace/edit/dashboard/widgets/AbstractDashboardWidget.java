/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.dashboard.widgets;

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

/**
 * The common functions for a dashboard widget.
 * 
 * @author Shterev
 */
public abstract class AbstractDashboardWidget extends Composite {

	private String title;
	private Composite content;

	/**
	 * Default constructor.
	 * 
	 * @param parent the parent.
	 * @param style the style.
	 */
	public AbstractDashboardWidget(final Composite parent, int style) {
		super(parent, style);
		title = "";
		GridLayoutFactory.fillDefaults().numColumns(1).extendedMargins(12, 12, 35, 15).applyTo(this);
		setBackgroundMode(SWT.INHERIT_FORCE);
		createContent();
		addPaintListener(new PaintListener() {

			public void paintControl(PaintEvent e) {
				Display display = Display.getCurrent();
				GC gc = e.gc;
				int x = getClientArea().x;
				int y = getClientArea().y;
				gc.setBackground(new Color(display, 233, 244, 255));
				gc.fillRoundRectangle(x, y, getSize().x - 1, getSize().y - 1, 40, 40);
				gc.setForeground(new Color(display, 20, 74, 180));
				gc.drawRoundRectangle(x, y, getSize().x - 1, getSize().y - 1, 40, 40);
				x += 15;
				Font headerFont = JFaceResources.getBannerFont();
				gc.setFont(headerFont);
				gc.drawString(title, x, y + 10);
				FontMetrics titleMetrics = gc.getFontMetrics();
				y = y + titleMetrics.getHeight() + 12;
				gc.drawLine(x - 3, y, getSize().x - 13, y);
			}
		});
	}

	/**
	 * Creates the content for this widget.
	 */
	protected void createContent() {

	}

	/**
	 * @param title the new title.
	 */
	protected void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the content
	 */
	public Composite getContent() {
		return content;
	}
}
