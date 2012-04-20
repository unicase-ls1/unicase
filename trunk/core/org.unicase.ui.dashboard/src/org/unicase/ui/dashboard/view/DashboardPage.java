/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.preferences.DashboardKey;
import org.eclipse.emf.emfstore.client.model.preferences.PreferenceManager;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.server.model.notification.ESNotification;
import org.eclipse.emf.emfstore.server.model.versioning.events.EventsFactory;
import org.eclipse.emf.emfstore.server.model.versioning.events.PluginFocusEvent;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Sash;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.unicase.ui.dashboard.notificationProviders.UpdateNotificationProvider;
import org.unicase.ui.dashboard.view.widgets.AbstractDashboardWidget;

/**
 * The default page for the dashboard.
 * 
 * @author Shterev
 */
public class DashboardPage extends FormPage {

	/**
	 * Recording command to create notification entries.
	 * 
	 * @author shterevg
	 */
	private final class CreateNotificationsCommand extends EMFStoreCommand {

		@Override
		protected void doRun() {
			int count = PreferenceManager.INSTANCE.getProperty(getProjectSpace(), DashboardKey.DASHBOARD_SIZE)
				.getIntegerProperty();
			count = Math.min(count, notifications.size());
			for (int i = 0; i < count; i++) {
				ESNotification n = notifications.get(i);
				if (!sanityCheck(n)) {
					continue;
				}
				if (!n.isSeen()) {
					AbstractDashboardEntry entry;
					if (n.getProvider().equals(UpdateNotificationProvider.NAME)) {
						entry = new UpdateDashboardEntry(DashboardPage.this, notificationsComposite, SWT.NONE, n,
							projectSpace);
					} else {
						entry = new DashboardNotificationEntry(DashboardPage.this, notificationsComposite, SWT.NONE, n,
							projectSpace);
					}
					GridDataFactory.fillDefaults().grab(true, false).applyTo(entry);
				}
			}
		}
	}

	private FormToolkit toolkit;

	private ScrolledForm form;
	private Composite notificationsComposite;
	private Composite widgetsComposite;

	private ProjectSpace projectSpace;

	private List<ESNotification> notifications;

	private ArrayList<AbstractDashboardWidget> widgets;

	private Color sashColor;

	/**
	 * Default constructor.
	 * 
	 * @param editor the editor
	 * @param id the page id
	 * @param title the title
	 */
	public DashboardPage(DashboardEditor editor, String id, String title) {
		super(editor, id, title);
	}

	/**
	 * Performs sanity checks on a notification.
	 * 
	 * @param n the notification.
	 * @return if the notification is valid.
	 */
	protected boolean sanityCheck(ESNotification n) {
		if (n == null) {
			return false;
		}
		if (n.getProject() == null || n.getProvider() == null || n.getCreationDate() == null || n.getMessage() == null
			|| n.getName() == null) {
			return false;
		}
		if (n.getRelatedModelElements().size() > 0) {
			ModelElementId modelElementId = n.getRelatedModelElements().get(0);
			EObject firstModelElement = projectSpace.getProject().getModelElement(modelElementId);
			if (firstModelElement == null) {
				return false;
			}
		}

		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		super.createFormContent(managedForm);

		DashboardEditorInput editorInput = (DashboardEditorInput) getEditorInput();
		projectSpace = editorInput.getProjectSpace();
		logFocusEvent();
		notifications = editorInput.getNotifications();

		widgets = new ArrayList<AbstractDashboardWidget>();
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.dashboard.widgets");
		final HashMap<AbstractDashboardWidget, Integer> widgetsMap = new HashMap<AbstractDashboardWidget, Integer>();
		for (IConfigurationElement e : config) {
			Object o;
			try {
				o = e.createExecutableExtension("class");
				if (o instanceof AbstractDashboardWidget) {
					AbstractDashboardWidget widget = (AbstractDashboardWidget) o;
					widget.setDashboard(this);
					String position = e.getAttribute("position");
					if (position != null) {
						int p = Integer.parseInt(position);
						widgetsMap.put(widget, p);
					}
					widgets.add(widget);
				}
			} catch (CoreException e1) {
				WorkspaceUtil.logException(e1.getMessage(), e1);
			}
		}
		Collections.sort(widgets, new Comparator<AbstractDashboardWidget>() {
			public int compare(AbstractDashboardWidget o1, AbstractDashboardWidget o2) {
				return widgetsMap.get(o1).compareTo(widgetsMap.get(o2));
			}
		});

		form = managedForm.getForm();
		toolkit = this.getEditor().getToolkit();
		toolkit.decorateFormHeading(form.getForm());
		form.setText(getEditorInput().getName());
		form.setImage(DashboardImageUtil.getImage("dashboard.png"));
		form.setExpandVertical(true);
		form.setExpandHorizontal(true);

		Composite body = form.getBody();
		body.setLayout(new FormLayout());

		final Sash sash = new Sash(body, SWT.VERTICAL);

		FormData data = new FormData();
		data.top = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(100, 0);
		data.left = new FormAttachment(80, 0);
		data.width = 3;
		sash.setLayoutData(data);
		sash.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				Rectangle rect = sash.getParent().getClientArea();
				event.x = Math.min(Math.max(event.x, 400), rect.width - 200);
				if (event.detail != SWT.DRAG) {
					sash.setBounds(event.x, event.y, event.width, event.height);
					((FormData) sash.getLayoutData()).left = new FormAttachment(0, event.x);
					sash.getParent().layout();
				}
			}
		});
		sash.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		sashColor = new Color(Display.getCurrent(), 195, 213, 243);
		sash.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				sash.setBackground(sashColor);
			}

			@Override
			public void mouseExit(MouseEvent e) {
				sash.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
			}
		});

		notificationsComposite = toolkit.createComposite(body, SWT.NONE);
		notificationsComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		notificationsComposite.setBackgroundMode(SWT.INHERIT_FORCE);
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).spacing(0, 0).margins(5, 5)
			.applyTo(notificationsComposite);
		data = new FormData();
		data.top = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(100, 0);
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(sash, 0);
		notificationsComposite.setLayoutData(data);

		widgetsComposite = toolkit.createComposite(body, SWT.NONE);
		widgetsComposite.setBackgroundMode(SWT.INHERIT_FORCE);
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).extendedMargins(5, 5, 6, 0)
			.applyTo(widgetsComposite);
		data = new FormData();
		data.top = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(100, 0);
		data.left = new FormAttachment(sash, 0);
		data.right = new FormAttachment(100, 0);
		widgetsComposite.setLayoutData(data);

		createWidgets();

		createNotifications();

		// is it just me, or this should be done by the sash form itself?,
		// Shterev 20090401
		notificationsComposite.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				form.reflow(true);
			}
		});

		form.setFocus();
	}

	private void createWidgets() {
		for (AbstractDashboardWidget widget : widgets) {
			Composite widgetComposite = widget.createWidget(widgetsComposite);
			GridDataFactory.fillDefaults().grab(true, false).applyTo(widgetComposite);
		}
	}

	private void logFocusEvent() {
		final PluginFocusEvent focusEvent = EventsFactory.eINSTANCE.createPluginFocusEvent();
		focusEvent.setPluginId(DashboardEditor.ID);
		focusEvent.setTimestamp(new Date());
		focusEvent.setStartDate(new Date());

		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				projectSpace.addEvent(focusEvent);
			}
		}.run();
	}

	private void createNotifications() {
		new CreateNotificationsCommand().run();
	}

	/**
	 * @return the form
	 */
	public ScrolledForm getForm() {
		return form;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.forms.editor.FormPage#setFocus()
	 */
	@Override
	public void setFocus() {
		super.setFocus();
		notificationsComposite.setFocus();
	}

	/**
	 * @return the project space for this dashboard
	 */
	public ProjectSpace getProjectSpace() {
		return projectSpace;
	}

	/**
	 * @return the list of widgets.
	 */
	public List<AbstractDashboardWidget> getWidgets() {
		return widgets;
	}

	/**
	 * Disposes all widgets and recreates them.
	 */
	public void reloadWidgets() {
		for (AbstractDashboardWidget widget : widgets) {
			widget.dispose();
		}
		createWidgets();
		widgetsComposite.layout();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		sashColor.dispose();
		super.dispose();
	}
}
