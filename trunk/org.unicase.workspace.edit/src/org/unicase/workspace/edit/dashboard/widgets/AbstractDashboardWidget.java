/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.dashboard.widgets;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.unicase.workspace.edit.dashboard.DashboardPage;
import org.unicase.workspace.edit.dashboard.DashboardToolbarAction;

/**
 * The common functions for a dashboard widget.
 * 
 * @author Shterev
 */
public abstract class AbstractDashboardWidget {

	/**
	 * A hyperlink adapter to change the position of the widget.
	 * 
	 * @author Shterev
	 */
	private final class PositionAdapter extends MouseAdapter {
		private static final String UP = "up";
		private static final String DOWN = "down";
		private String direction;

		public PositionAdapter(String direction) {
			this.direction = direction;
		}

		@Override
		public void mouseUp(MouseEvent e) {
			List<AbstractDashboardWidget> widgets = getDashboard().getWidgets();
			int index = widgets.indexOf(AbstractDashboardWidget.this);
			if (direction.equals(UP) && index > 0) {
				Collections.swap(widgets, index, index - 1);
				getDashboard().reloadWidgets();
			} else if (direction.equals(DOWN) && index < widgets.size() - 1) {
				Collections.swap(widgets, index, index + 1);
				getDashboard().reloadWidgets();
			}
		}
	}

	private Composite composite;
	private Composite contentPanel;
	private DashboardPage dashboard;
	private Display display;
	private AdapterFactoryLabelProvider labelProvider;
	private final String prefix = "org.unicase.dashboard.";
	private Composite systemToolbar;
	private String title;
	private Composite toolbar;
	private Color bg;

	/**
	 * Default constructor.
	 * 
	 * @param dashboard the dashboard.
	 */
	public AbstractDashboardWidget(DashboardPage dashboard) {
		display = Display.getCurrent();
		bg = new Color(display, 233, 244, 255);
		this.dashboard = dashboard;
		labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		title = "";
	}

	/**
	 * Creates the widget in the given parent.
	 * 
	 * @param parent the parent
	 * @return the widget composite
	 */
	public Composite createWidget(final Composite parent) {
		composite = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).extendedMargins(12, 12, 35, 5).applyTo(composite);
		composite.setBackgroundMode(SWT.INHERIT_FORCE);
		composite.addPaintListener(new PaintListener() {

			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				int x = composite.getClientArea().x;
				int y = composite.getClientArea().y;
				gc.setAntialias(SWT.ON);
				gc.setBackground(bg);
				gc.fillRoundRectangle(x, y, composite.getSize().x - 1, composite.getSize().y - 1, 20, 20);
				gc.setForeground(new Color(display, 20, 74, 180));
				gc.drawRoundRectangle(x, y, composite.getSize().x - 1, composite.getSize().y - 1, 20, 20);
				x += 15;
				Font headerFont = JFaceResources.getBannerFont();
				gc.setFont(headerFont);
				gc.drawString(title, x, y + 10);
				FontMetrics titleMetrics = gc.getFontMetrics();
				y = y + titleMetrics.getHeight() + 12;
				gc.drawLine(x - 3, y, composite.getSize().x - 13, y);
			}
		});

		createContentPanel();
		createToolbar();
		createSystemToolbar();
		for (Control c : composite.getChildren()) {
			c.setBackground(bg);
		}
		return composite;
	}

	/**
	 * 
	 */
	private void createSystemToolbar() {
		systemToolbar = new Composite(composite, SWT.NONE);
		GridDataFactory.fillDefaults().applyTo(systemToolbar);
		final RowLayout sysLayout = new RowLayout();
		sysLayout.spacing = 1;
		sysLayout.marginRight = 0;
		systemToolbar.setLayout(sysLayout);

		DashboardToolbarAction down = new DashboardToolbarAction(systemToolbar, "down.png");
		down.setToolTipText("Move widget down");
		final PositionAdapter upListener = new PositionAdapter(PositionAdapter.DOWN);
		final PositionAdapter downListener = new PositionAdapter(PositionAdapter.UP);
		down.addMouseListener(upListener);
		DashboardToolbarAction up = new DashboardToolbarAction(systemToolbar, "up.png");
		up.setToolTipText("Move widget up");
		up.addMouseListener(downListener);
		DashboardToolbarAction settings = new DashboardToolbarAction(systemToolbar, "cog.png");
		settings.setToolTipText("Settings");
		settings.addHyperlinkListener(new HyperlinkAdapter() {
			@Override
			public void linkActivated(HyperlinkEvent e) {
				PreferenceDialog preferenceDialog = PreferencesUtil.createPreferenceDialogOn(composite.getShell(),
					prefix + getId(), null, null);
				preferenceDialog.open();
			}
		});
	}

	/**
	 * Creates the content for this widget.
	 */
	protected void createContentPanel() {
		contentPanel = new Composite(composite, SWT.NONE);
		GridDataFactory.fillDefaults().span(2, 1).hint(150, SWT.DEFAULT).grab(true, false).applyTo(contentPanel);
	}

	/**
	 * @return the content
	 */
	protected Composite getContentPanel() {
		return contentPanel;
	}

	/**
	 * Creates a toolbar for this widget.
	 */
	protected void createToolbar() {
		toolbar = new Composite(composite, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(toolbar);
		final RowLayout layout = new RowLayout();
		layout.spacing = 1;
		layout.marginLeft = 0;
		toolbar.setLayout(layout);
	}

	/**
	 * @return the toolbar panel
	 */
	protected Composite getToolbar() {
		return toolbar;
	}

	/**
	 * @return the composite for this widget.
	 */
	protected Composite getComposite() {
		return composite;
	}

	/**
	 * @return the dashboard this widget is created in
	 */
	protected DashboardPage getDashboard() {
		return dashboard;
	}

	/**
	 * @return the id for this widget
	 */
	protected abstract String getId();

	/**
	 * @return the {@link AdapterFactoryLabelProvider}
	 */
	protected AdapterFactoryLabelProvider getLabelProvider() {
		return labelProvider;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the new title.
	 */
	protected void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Disposes the widget's composite.
	 */
	public void dispose() {
		composite.dispose();
	}
}
