/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dashboard;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.versioning.events.EventsFactory;
import org.unicase.emfstore.esmodel.versioning.events.PluginFocusEvent;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.notification.provider.UpdateNotificationProvider;
import org.unicase.workspace.ui.dashboard.widgets.AbstractDashboardWidget;
import org.unicase.workspace.ui.dashboard.widgets.DashboardEventWidget;
import org.unicase.workspace.ui.dashboard.widgets.DashboardTaskWidget;

/**
 * The default page for the dashboard.
 * 
 * @author Shterev
 */
public class DashboardPage extends FormPage {
	private FormToolkit toolkit;

	private ScrolledForm form;
	private Composite notificationsComposite;
	private Composite widgetsComposite;

	private ProjectSpace projectSpace;

	private List<ESNotification> notifications;

	private TransactionalEditingDomain domain;

	private ArrayList<AbstractDashboardWidget> widgets;

	/**
	 * Default constructor.
	 * 
	 * @param editor the editor
	 * @param id the page id
	 * @param title the title
	 */
	public DashboardPage(DashboardEditor editor, String id, String title) {
		super(editor, id, title);
		domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");
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
		widgets.add(new DashboardTaskWidget(this));
		widgets.add(new DashboardEventWidget(this));
//		widgets.add(new DashboardRelatedTasksWidget(this));
		
		form = managedForm.getForm();
		toolkit = this.getEditor().getToolkit();
		toolkit.decorateFormHeading(form.getForm());
		form.setText(getEditorInput().getName());
		form.setImage(DashboardImageUtil.getImage("dashboard.png"));
		form.setExpandVertical(true);
		form.setExpandHorizontal(true);

		Composite body = form.getBody();
		body.setLayout(new GridLayout());
		final SashForm globalSash = new SashForm(body, SWT.HORIZONTAL);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(globalSash);
		toolkit.adapt(globalSash, true, true);
		globalSash.setSashWidth(4);

		notificationsComposite = toolkit.createComposite(globalSash, SWT.NONE);
		notificationsComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		notificationsComposite.setBackgroundMode(SWT.INHERIT_FORCE);
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).spacing(0, 0).applyTo(notificationsComposite);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(notificationsComposite);

		widgetsComposite = toolkit.createComposite(globalSash, SWT.NONE);
		widgetsComposite.setBackgroundMode(SWT.INHERIT_FORCE);
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).extendedMargins(5, 5, 6, 0).applyTo(
			widgetsComposite);
		GridDataFactory.fillDefaults().applyTo(widgetsComposite);

		int[] topWeights = { 80, 20 };
		globalSash.setWeights(topWeights);

		createWidgets();

		createNotifications();

		// is it just me, or this should be done by the sash form itself?, Shterev 20090401
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
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				projectSpace.addEvent(focusEvent);
			}
		});
	}

	private void createNotifications() {
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				for (ESNotification n : notifications) {
					if (!n.isSeen()) {
						AbstractDashboardEntry entry;
						if (n.getSender() != null && n.getSender().equals(UpdateNotificationProvider.NAME)) {
							entry = new UpdateDashboardEntry(DashboardPage.this, notificationsComposite, SWT.NONE, n,
								projectSpace);
						} else {
							entry = new NotificationDashboardEntry(DashboardPage.this, notificationsComposite,
								SWT.NONE, n, projectSpace);
						}
						GridDataFactory.fillDefaults().grab(true, false).applyTo(entry);
					}
				}
			}
		});
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
		widgetsComposite.layout(true);
	}
}
