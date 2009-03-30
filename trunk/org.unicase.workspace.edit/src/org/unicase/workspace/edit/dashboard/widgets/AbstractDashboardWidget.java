/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.dashboard.widgets;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.unicase.workspace.edit.dashboard.DashboardPage;

/**
 * The common functions for a dashboard widget.
 * 
 * @author Shterev
 */
public abstract class AbstractDashboardWidget extends Composite {

	private String title;
	private Composite panel;
	private Display display;
	private Color bg = new Color(display, 233, 244, 255);
	private DashboardPage dashboard;
	private AdapterFactoryLabelProvider labelProvider;
	private Composite toolbar;
	private Composite systemToolbar;
	private final String prefix = "org.unicase.dashboard.";

	/**
	 * Default constructor.
	 * 
	 * @param parent the parent.
	 * @param style the style.
	 * @param dashboard the dashboard.
	 */
	public AbstractDashboardWidget(final Composite parent, int style, DashboardPage dashboard) {
		super(parent, style);
		this.dashboard = dashboard;
		labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		title = "";
		display = Display.getCurrent();
		GridLayoutFactory.fillDefaults().numColumns(2).extendedMargins(12, 12, 35, 5).applyTo(this);
		setBackgroundMode(SWT.INHERIT_FORCE);
		setBackground(bg);
		addPaintListener(new PaintListener() {

			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				int x = getClientArea().x;
				int y = getClientArea().y;
				gc.setAntialias(SWT.ON);
				gc.setBackground(bg);
				gc.fillRoundRectangle(x, y, getSize().x - 1, getSize().y - 1, 20, 20);
				gc.setForeground(new Color(display, 20, 74, 180));
				gc.drawRoundRectangle(x, y, getSize().x - 1, getSize().y - 1, 20, 20);
				x += 15;
				Font headerFont = JFaceResources.getBannerFont();
				gc.setFont(headerFont);
				gc.drawString(title, x, y + 10);
				FontMetrics titleMetrics = gc.getFontMetrics();
				y = y + titleMetrics.getHeight() + 12;
				gc.drawLine(x - 3, y, getSize().x - 13, y);
			}
		});
		panel = new Composite(this, SWT.NONE);
		GridDataFactory.fillDefaults().span(2, 1).hint(150, SWT.DEFAULT).grab(true, false).applyTo(panel);

		toolbar = new Composite(this, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(toolbar);
		final RowLayout layout = new RowLayout();
		layout.spacing = 1;
		layout.marginLeft = 0;
		toolbar.setLayout(layout);

		systemToolbar = new Composite(this, SWT.NONE);
		GridDataFactory.fillDefaults().applyTo(systemToolbar);
		final RowLayout sysLayout = new RowLayout();
		sysLayout.spacing = 1;
		sysLayout.marginRight = 0;
		systemToolbar.setLayout(sysLayout);

		DashboardWidgetAction down = new DashboardWidgetAction(systemToolbar, "down.png");
		down.setToolTipText("Move widget down");
		DashboardWidgetAction up = new DashboardWidgetAction(systemToolbar, "up.png");
		up.setToolTipText("Move widget up");
		DashboardWidgetAction settings = new DashboardWidgetAction(systemToolbar, "cog.png");
		settings.setToolTipText("Settings");
		settings.addHyperlinkListener(new HyperlinkAdapter() {
			@Override
			public void linkActivated(HyperlinkEvent e) {
				PreferenceDialog preferenceDialog = PreferencesUtil.createPreferenceDialogOn(getShell(), prefix
					+ getId(), null, null);
				preferenceDialog.open();
			}
		});
	}

	/**
	 * @return the dashboard this widget is created in
	 */
	protected DashboardPage getDashboard() {
		return dashboard;
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
	protected Composite getPanel() {
		return panel;
	}

	/**
	 * @return the toolbar panel
	 */
	protected Composite getToolbar() {
		return toolbar;
	}

	/**
	 * @return the {@link AdapterFactoryLabelProvider}
	 */
	protected AdapterFactoryLabelProvider getLabelProvider() {
		return labelProvider;
	}

	/**
	 * @return the id for this widget
	 */
	protected abstract String getId();
}
