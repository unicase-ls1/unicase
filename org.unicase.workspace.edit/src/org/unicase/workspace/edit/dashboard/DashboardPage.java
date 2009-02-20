/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.dashboard;

import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.model.Project;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.edit.Activator;
import org.unicase.workspace.edit.dashboard.widgets.DashboardTaskWidget;

/**
 * The default page for the dashboard.
 * 
 * @author Shterev
 */
public class DashboardPage extends FormPage {
	private FormToolkit toolkit;

	private ScrolledForm form;
	private Composite main;
	private Composite widgets;

	private Project project;

	private List<ESNotification> notifications;

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
	 * {@inheritDoc}
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		super.createFormContent(managedForm);

		// // --------------- TEST DATA ----------------------
		// notifications = new ArrayList<ESNotification>();
		//
		// ESNotification n1 = NotificationFactory.eINSTANCE.createESNotification();
		// n1.setCreationDate(new Date());
		// n1.setMessage("You have been assigned " + "<a href=\"more\">3</a> new BugReports.");
		// final ActionItem ai = TaskFactory.eINSTANCE.createActionItem();
		// final BugReport br = BugFactory.eINSTANCE.createBugReport();
		// final Issue i = RationaleFactory.eINSTANCE.createIssue();
		//
		// n1.getRelatedModelElements().add(br.getModelElementId());
		// n1.getRelatedModelElements().add(br.getModelElementId());
		// n1.getRelatedModelElements().add(br.getModelElementId());
		//
		// ESNotification n2 = NotificationFactory.eINSTANCE.createESNotification();
		// n2.setCreationDate(new Date());
		// n2
		// .setMessage("You have been assigned "
		// + "<a href=\"unicase://localhost/coldphusion/_stWbEJ63Ed2sqfORmUtZjA\">Should we have a entrance class?</a>."
		// +
		// "DHGJASFDGHAS <a href=\"unicase://localhost/coldphusion/_stWbEJ63Ed2sqfORmUtZjA\">Should we have a ?</a>.");
		// n2.getRelatedModelElements().add(i.getModelElementId());
		//
		// ESNotification n3 = NotificationFactory.eINSTANCE.createESNotification();
		// n3.setCreationDate(new Date());
		// n3.setMessage("You have been assigned " + "<a href=\"more\">2</a> new ActionItems.");
		// n3.getRelatedModelElements().add(ai.getModelElementId());
		// n3.getRelatedModelElements().add(ai.getModelElementId());
		//
		// ESNotification updated = NotificationFactory.eINSTANCE.createESNotification();
		// updated.setCreationDate(new Date());
		// updated.setMessage("revision 178");
		// //
		// notifications.add(updated);
		// notifications.add(n1);
		// notifications.add(n2);
		// notifications.add(n3);
		// notifications.add(updated);
		// notifications.add(n3);
		// notifications.add(n3);
		// notifications.add(n3);
		// notifications.add(n3);
		// notifications.add(updated);
		// notifications.add(n2);
		// notifications.add(n1);
		// notifications.add(n3);
		// // --------------- TEST DATA ----------------------

		// Layout form
		form = managedForm.getForm();
		toolkit = this.getEditor().getToolkit();
		toolkit.decorateFormHeading(form.getForm());
		DashboardEditorInput editorInput = (DashboardEditorInput) getEditorInput();
		ProjectSpace projectSpace = editorInput.getProjectSpace();

		notifications = projectSpace.getNotifications();

		project = projectSpace.getProject();
		form.setText("Dashboard - " + projectSpace.getProjectName());
		form.setImage(Activator.getImageDescriptor("/icons/dashboard.png").createImage());
		form.setExpandVertical(true);
		form.setExpandHorizontal(true);

		Composite body = form.getBody();
		body.setLayout(new GridLayout());
		SashForm globalSash = new SashForm(body, SWT.HORIZONTAL);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(globalSash);
		toolkit.adapt(globalSash, true, true);
		globalSash.setSashWidth(4);

		main = toolkit.createComposite(globalSash, SWT.NONE);
		main.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		main.setBackgroundMode(SWT.INHERIT_FORCE);
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).spacing(0, 0).applyTo(main);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(main);

		widgets = toolkit.createComposite(globalSash, SWT.NONE);
		// widgets.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GRAY));
		widgets.setBackgroundMode(SWT.INHERIT_FORCE);
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).extendedMargins(5, 5, 6, 0).applyTo(widgets);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).applyTo(widgets);

		DashboardTaskWidget tasks = new DashboardTaskWidget(widgets, SWT.NONE, projectSpace);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(tasks);

		// DashboardRelatedTasksWidget related = new DashboardRelatedTasksWidget(widgets, SWT.NONE);
		// GridDataFactory.fillDefaults().grab(true, false).applyTo(related);
		//
		// DashboardEventWidget events = new DashboardEventWidget(widgets, SWT.NONE);
		// GridDataFactory.fillDefaults().grab(true, false).applyTo(events);

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				// project.addModelElement(ai);
				// project.addModelElement(br);
				// project.addModelElement(i);
				loadNotifications(notifications);
			}
		});

		int[] topWeights = { 80, 20 };
		globalSash.setWeights(topWeights);

		form.setFocus();
		form.pack();
	}

	private void loadNotifications(List<ESNotification> notifications) {
		for (ESNotification n : notifications) {
			DashboardEntry entry = new DashboardEntry(this, main, SWT.NONE, n, project);
			GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(entry);
		}
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
		main.setFocus();
	}
}
