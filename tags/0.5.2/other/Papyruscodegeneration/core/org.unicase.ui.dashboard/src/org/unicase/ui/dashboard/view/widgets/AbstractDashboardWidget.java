/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard.view.widgets;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
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
import org.unicase.ui.dashboard.view.DashboardPage;
import org.unicase.ui.dashboard.view.DashboardToolbarAction;

/**
 * The common functions for a dashboard widget.
 * 
 * @author Shterev
 */
public abstract class AbstractDashboardWidget implements PaintListener {

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
	private Composite systemToolbar;
	private String title;
	private Composite toolbar;
	private Color bg;

	/**
	 * Default constructor.
	 */
	public AbstractDashboardWidget() {
		display = Display.getCurrent();
		bg = new Color(display, 233, 244, 255);
		labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		title = "";
	}

	/**
	 * Sets the dashboard for this widget.
	 * 
	 * @param dashboard the dashboard.
	 */
	public void setDashboard(DashboardPage dashboard) {
		this.dashboard = dashboard;
	}

	/**
	 * Creates the widget in the given parent.
	 * 
	 * @param parent the parent
	 * @return the widget composite
	 */
	public Composite createWidget(final Composite parent) {
		composite = new Composite(parent, SWT.NONE);

		composite.setBackgroundMode(SWT.INHERIT_FORCE);
		GridLayoutFactory.fillDefaults().numColumns(2).extendedMargins(12, 12, 47, 5).applyTo(composite);

		createContentPanel();
		createToolbar();
		createSystemToolbar();
		for (Control c : composite.getChildren()) {
			c.setBackground(bg);
		}
		composite.addPaintListener(this);
		return composite;
	}

	/**
	 * {@inheritDoc}
	 */
	public void paintControl(PaintEvent e) {
		GC gc = e.gc;
		int x = composite.getClientArea().x;
		int y = composite.getClientArea().y;
		int width = composite.getClientArea().width;
		int height = composite.getClientArea().height;
		gc.setAntialias(SWT.ON);
		gc.setBackground(bg);
		gc.fillRoundRectangle(x, y, width - 1, height - 1, 20, 20);
		gc.setForeground(new Color(display, 20, 74, 180));
		gc.drawRoundRectangle(x, y, width - 1, height - 1, 20, 20);
		x += 15;
		y += 10;
		Font headerFont = JFaceResources.getBannerFont();
		gc.setFont(headerFont);
		FontMetrics titleMetrics = gc.getFontMetrics();
		int lines = 1;
		String[] words = title.split(" ");
		String buffer = "";
		for (String word : words) {
			if (gc.textExtent(buffer + " " + word).x <= width - 30) {
				if (buffer != "") {
					buffer += " " + word;
				} else {
					buffer = word;
				}
			} else {
				gc.drawString(buffer, x + 2, y);
				y += titleMetrics.getHeight();
				buffer = word;
				lines++;
			}
		}
		gc.drawString(buffer, x + 2, y);
		y += titleMetrics.getHeight() + 2;
		gc.drawLine(x - 3, y, width - 13, y);
		GridLayoutFactory.fillDefaults().numColumns(2)
			.extendedMargins(12, 12, 25 + lines * titleMetrics.getHeight(), 5).applyTo(composite);
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
				PreferenceDialog propertyDialog = PreferencesUtil.createPropertyDialogOn(Display.getCurrent()
					.getActiveShell(), WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace()
					.getProject(), "org.unicase.workspace.ui.dashboardWidgetProperties", null, null);
				propertyDialog.open();
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
