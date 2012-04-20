/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard.view;

import java.text.SimpleDateFormat;

import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.server.model.notification.ESNotification;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.unicase.ui.dashboard.Activator;

/**
 * A dashboard entry widget for the update notifications.
 * 
 * @author Shterev
 */
public class UpdateDashboardEntry extends AbstractDashboardEntry {

	private Image left;
	private Image right;
	private Image line;
	private SimpleDateFormat format;

	private Color blue;

	/**
	 * Default constuctor.
	 * 
	 * @param parent the parent composite.
	 * @param style the style.
	 * @param notification the notification.
	 * @param project the project.
	 * @param page a back link to the dashboard page (needed only for layout purposes).
	 */
	public UpdateDashboardEntry(DashboardPage page, Composite parent, int style, ESNotification notification,
		ProjectSpace project) {
		super(page, parent, style, notification, project);

		left = Activator.getImageDescriptor("icons/left.png").createImage();
		right = Activator.getImageDescriptor("icons/right.png").createImage();
		line = Activator.getImageDescriptor("icons/line.png").createImage();
		blue = new Color(getDisplay(), 191, 222, 255);
		format = new SimpleDateFormat("dd.MM.yyyy HH:mm");

		createEntry();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createEntry() {
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(this);
		GridLayoutFactory.fillDefaults().numColumns(5).equalWidth(false).extendedMargins(0, 12, 6, 6).spacing(0, 0)
			.applyTo(this);

		Composite updated = createRoundedLabel(this, getNotification().getMessage());
		GridDataFactory.fillDefaults().applyTo(updated);

		Composite space = new Composite(this, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).hint(10, 15).applyTo(space);
		space.setBackgroundImage(line);

		Composite date = createRoundedLabel(this, format.format(getNotification().getCreationDate()));
		GridDataFactory.fillDefaults().applyTo(date);

		GridDataFactory.fillDefaults().align(SWT.END, SWT.BEGINNING).applyTo(date);
	}

	private Composite createRoundedLabel(Composite parent, String text) {

		Composite c = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).spacing(0, 0).applyTo(c);

		Composite left = new Composite(c, SWT.NONE);
		left.setBackgroundImage(this.left);
		GridDataFactory.fillDefaults().hint(10, 15).applyTo(left);

		Composite main = new Composite(c, SWT.NONE);
		GridDataFactory.fillDefaults().applyTo(main);
		GridLayoutFactory.fillDefaults().numColumns(1).applyTo(main);
		main.setBackground(blue);
		Label label = new Label(main, SWT.NONE);
		label.setText(text);

		Composite right = new Composite(c, SWT.NONE);
		right.setBackgroundImage(this.right);
		GridDataFactory.fillDefaults().hint(10, 15).applyTo(right);

		return c;
	}

}
