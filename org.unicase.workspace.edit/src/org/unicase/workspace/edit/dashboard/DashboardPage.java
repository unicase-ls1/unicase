/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.dashboard;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.notification.NotificationFactory;
import org.unicase.model.Project;
import org.unicase.model.bug.BugFactory;
import org.unicase.model.bug.BugReport;
import org.unicase.model.rationale.Issue;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.edit.Activator;

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

	private Image left;

	private Image right;

	private Image line;

	private Project project;

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

		left = Activator.getImageDescriptor("icons/left.png").createImage();
		right = Activator.getImageDescriptor("icons/right.png").createImage();
		line = Activator.getImageDescriptor("icons/line.png").createImage();

		// Layout form
		form = managedForm.getForm();
		toolkit = this.getEditor().getToolkit();
		toolkit.decorateFormHeading(form.getForm());
		DashboardEditorInput editorInput = (DashboardEditorInput) getEditorInput();
		form.setText("Dashboard - " + editorInput.getProjectSpace().getProjectName());
		form.setImage(Activator.getImageDescriptor("/icons/dashboard.png").createImage());

		Composite body = form.getBody();
		body.setLayout(new GridLayout());
		SashForm globalSash = new SashForm(body, SWT.HORIZONTAL);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(globalSash);
		toolkit.adapt(globalSash, true, true);
		globalSash.setSashWidth(4);

		main = toolkit.createComposite(globalSash, SWT.NONE);
		main.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).spacing(0, 0).applyTo(main);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).applyTo(main);

		widgets = toolkit.createComposite(globalSash, SWT.NONE);
		widgets.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GRAY));
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).extendedMargins(2, 5, 0, 0).applyTo(widgets);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).applyTo(widgets);

		// --------------- TEST DATA ----------------------
		final List<ESNotification> notifications = new ArrayList<ESNotification>();
		// WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace().getNotifications();

		ESNotification n1 = NotificationFactory.eINSTANCE.createESNotification();
		n1.setCreationDate(new Date());
		n1.setMessage("You have been assigned "
			+ "<a href=\"unicase://localhost/coldphusion/myBugReport/2134\">3</a> new BugReports.");
		final ActionItem ai = TaskFactory.eINSTANCE.createActionItem();
		final BugReport br = BugFactory.eINSTANCE.createBugReport();
		final Issue i = RationaleFactory.eINSTANCE.createIssue();

		n1.getRelatedModelElements().add(br.getModelElementId());

		ESNotification n2 = NotificationFactory.eINSTANCE.createESNotification();
		n2.setCreationDate(new Date());
		n2.setMessage("You have been assigned "
			+ "<a href=\"unicase://localhost/coldphusion/newIssue/894\">1</a> new Issue.");
		n2.getRelatedModelElements().add(i.getModelElementId());

		ESNotification n3 = NotificationFactory.eINSTANCE.createESNotification();
		n3.setCreationDate(new Date());
		n3.setMessage("You have been assigned "
			+ "<a href=\"unicase://localhost/coldphusion/myActionItems/2134\">2</a> new ActionItems.");
		n3.getRelatedModelElements().add(ai.getModelElementId());

		ESNotification updated = NotificationFactory.eINSTANCE.createESNotification();
		updated.setCreationDate(new Date());
		updated.setMessage("revision 178");
		//
		notifications.add(updated);
		notifications.add(n1);
		notifications.add(n2);
		notifications.add(n3);
		notifications.add(updated);
		notifications.add(n3);
		notifications.add(n3);
		notifications.add(n3);
		notifications.add(n3);
		notifications.add(updated);
		notifications.add(n2);
		notifications.add(n1);
		notifications.add(n3);
		// --------------- TEST DATA ----------------------

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				project = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace().getProject();
				project.addModelElement(ai);
				project.addModelElement(br);
				project.addModelElement(i);
				loadNotifications(notifications);
			}
		});

		int[] topWeights = { 80, 20 };
		globalSash.setWeights(topWeights);

		form.pack();
	}

	private void loadNotifications(List<ESNotification> notifications) {
		for (ESNotification n : notifications) {
			final Composite c = toolkit.createComposite(main, SWT.NONE);
			c.setBackgroundMode(SWT.INHERIT_FORCE);
			GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(c);
			Display display = Display.getCurrent();
			SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy mm:HH");
			final Color lightBlue = new Color(display, 233, 244, 255);

			// update notifications
			if (n.getMessage().startsWith("revision")) {
				GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(c);
				GridLayoutFactory.fillDefaults().numColumns(5).equalWidth(false).extendedMargins(0, 0, 6, 6).spacing(0,
					0).applyTo(c);

				Composite updated = createRoundedLabel(c, "Updated " + n.getMessage());
				GridDataFactory.fillDefaults().applyTo(updated);

				Composite space = new Composite(c, SWT.NONE);
				GridDataFactory.fillDefaults().grab(true, false).hint(10, 15).applyTo(space);
				space.setBackgroundImage(line);

				Composite date = createRoundedLabel(c, format.format(n.getCreationDate()));
				GridDataFactory.fillDefaults().applyTo(date);

				GridDataFactory.fillDefaults().align(SWT.END, SWT.BEGINNING).applyTo(date);
				continue;
			}

			// normal notifications
			GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).extendedMargins(3, 3, 6, 6).applyTo(c);
			final Color notificationColor = display.getSystemColor(SWT.COLOR_WHITE);
			c.setBackground(notificationColor);

			Composite image = new Composite(c, SWT.NONE);
			GridDataFactory.fillDefaults().hint(16, 16).applyTo(image);
			AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

			image.setBackgroundImage(labelProvider
				.getImage(project.getModelElement(n.getRelatedModelElements().get(0))));

			Link link = new Link(c, SWT.NONE);
			link.setText(n.getMessage());
			GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(link);
			// link.setBackground(notificationColor);
			link.addSelectionListener(new SelectionListener() {

				public void widgetDefaultSelected(SelectionEvent e) {
					//
				}

				public void widgetSelected(SelectionEvent e) {
					String text = e.text;
					URLResolver url = new URLResolver(text);
					MessageDialog.openInformation(getSite().getShell(), text, "Opening " + "model element with id "
						+ url.getMID() + "\n in revision " + url.getRevision() + "\n on " + url.getProject() + "@"
						+ url.getServer());
				}

			});
			Label date = new Label(c, SWT.NONE);
			date.setText(format.format(n.getCreationDate()));
			// date.setBackground(notificationColor);
			GridDataFactory.fillDefaults().align(SWT.END, SWT.BEGINNING).applyTo(date);
			date.setForeground(display.getSystemColor(SWT.COLOR_GRAY));

			MouseTrackAdapter hoverListener = new MouseTrackAdapter() {
				@Override
				public void mouseEnter(MouseEvent e) {
					c.setBackground(lightBlue);
				}

				@Override
				public void mouseExit(MouseEvent e) {
					c.setBackground(notificationColor);
				}
			};
			c.addMouseTrackListener(hoverListener);
			link.addMouseTrackListener(hoverListener);
			date.addMouseTrackListener(hoverListener);
		}
	}

	private Composite createRoundedLabel(Composite parent, String text) {
		final Color blue = new Color(Display.getCurrent(), 191, 222, 255);

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
