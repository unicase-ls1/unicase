/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.dashboard;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.TypedEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.url.ModelElementUrl;
import org.unicase.emfstore.esmodel.url.ModelElementUrlFragment;
import org.unicase.emfstore.esmodel.url.UrlFactory;
import org.unicase.emfstore.esmodel.versioning.events.EventsFactory;
import org.unicase.emfstore.esmodel.versioning.events.NotificationIgnoreEvent;
import org.unicase.emfstore.esmodel.versioning.events.NotificationReadEvent;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.common.util.ModelElementClassTooltip;
import org.unicase.ui.common.util.URLHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.edit.Activator;
import org.unicase.workspace.exceptions.MEUrlResolutionException;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * A dashboard entry widget.
 * 
 * @author Shterev
 */
public class NotificationDashboardEntry extends AbstractDashboardEntry {

	/**
	 * Selection listener for the links.
	 * 
	 * @author Shterev
	 */
	private final class LinkSelectionListener implements SelectionListener {

		private String source;

		public LinkSelectionListener(String source) {
			super();
			this.source = source;
		}

		public void widgetDefaultSelected(SelectionEvent e) {
			//
		}

		public void widgetSelected(SelectionEvent e) {
			String text = e.text;
			if (text.equals("more")) {
				return;
			}
			try {
				ModelElementUrl modelElementUrl = UrlFactory.eINSTANCE.createModelElementUrl(text);
				ModelElement modelElement = null;
				ModelElementUrlFragment modelElementUrlFragment = modelElementUrl.getModelElementUrlFragment();
				try {
					modelElement = getProject().resolve(modelElementUrlFragment);
				} catch (MEUrlResolutionException e1) {
				}
				ActionHelper.openModelElement(modelElement, DashboardEditor.ID);
				logEvent(modelElementUrlFragment.getModelElementId(), source);
			} catch (MalformedURLException ex) {
				WorkspaceUtil.logException("Invalid unicase URL pattern", ex);
			}
		}
	}

	private Color lightBlue;
	private Color notificationColor;
	private SimpleDateFormat format;
	private Composite drawer;
	private Composite entry;
	private boolean mouseOver;
	private boolean mouseOverClose;

	private boolean open = true;
	private AdapterFactoryLabelProvider labelProvider;

	/**
	 * Default constructor.
	 * 
	 * @param parent the parent composite.
	 * @param style the style.
	 * @param notification the notification.
	 * @param project the project.
	 * @param page a back link to the dashboard page (needed only for layout purposes).
	 */
	public NotificationDashboardEntry(DashboardPage page, Composite parent, int style, ESNotification notification,
		ProjectSpace project) {
		super(page, parent, style, notification, project);

		lightBlue = new Color(getDisplay(), 233, 244, 255);
		notificationColor = getDisplay().getSystemColor(SWT.COLOR_WHITE);
		format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		createEntry();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createEntry() {
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).margins(3, 0).applyTo(this);

		entry = new Composite(this, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).margins(0, 6).spacing(3, 0).applyTo(entry);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(entry);
		setBackground(notificationColor);

		if (getNotification().getRelatedModelElements().size() == 0) {
			return;
		}
		ModelElement modelElement = getProject().getProject().getModelElement(
			getNotification().getRelatedModelElements().get(0));
		Link link = createImageLink(modelElement, entry, getNotification().getMessage());
		link.addSelectionListener(new LinkSelectionListener("link"));

		Label date = new Label(entry, SWT.NONE);
		date.setText(format.format(getNotification().getCreationDate()));
		GridDataFactory.fillDefaults().align(SWT.END, SWT.BEGINNING).applyTo(date);
		date.setForeground(getDisplay().getSystemColor(SWT.COLOR_GRAY));

		final Image closeImage = Activator.getImageDescriptor("icons/close.png").createImage();
		final Image closeImageRed = Activator.getImageDescriptor("icons/cross.png").createImage();
		final Composite closeLink = new Composite(this, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(18, 26).applyTo(closeLink);
		closeLink.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				if (mouseOver) {
					Rectangle area = closeLink.getClientArea();
					Image image = closeImage;
					if (mouseOverClose) {
						image = closeImageRed;
					}
					e.gc.drawImage(image, area.x, area.y + 5);
				}
			}
		});
		closeLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				boolean hide = MessageDialog
					.openQuestion(
						getShell(),
						"Reject notification",
						"Are you sure you are NOT interested in this notification? Your choice will be used to filter notifications you will receive in the future.");
				if (hide) {
					TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
						.getEditingDomain("org.unicase.EditingDomain");
					domain.getCommandStack().execute(new RecordingCommand(domain) {

						@Override
						protected void doExecute() {
							getNotification().setSeen(true);
							logEvent(getNotification(), getProject());
							((DashboardEditor) getPage().getEditor()).refresh();
						}
					});
				}
			}
		});

		MouseTrackAdapter hoverListener = new MouseTrackAdapter() {

			@Override
			public void mouseEnter(MouseEvent e) {
				setBackground(lightBlue);
				mouseOver = true;
				if (e.widget.equals(closeLink)) {
					mouseOverClose = true;
				}
			}

			@Override
			public void mouseExit(MouseEvent e) {
				setBackground(notificationColor);
				mouseOver = false;
				if (e.widget.equals(closeLink)) {
					mouseOverClose = false;
				}
			}
		};

		MouseListener clickListener = new MouseAdapter() {

			@Override
			public void mouseDown(MouseEvent e) {
				toggleDrawer(e, open);
				open = !open;
			}
		};

		addMouseTrackListener(hoverListener);
		entry.addMouseTrackListener(hoverListener);
		link.addMouseTrackListener(hoverListener);
		date.addMouseTrackListener(hoverListener);

		closeLink.addMouseTrackListener(hoverListener);

		drawer = new Composite(entry, SWT.NONE);
		GridDataFactory.fillDefaults().hint(10, 0).span(3, 1).indent(20, 0).grab(true, false).applyTo(drawer);
		GridLayoutFactory.fillDefaults().numColumns(1).spacing(0, 8).extendedMargins(3, 3, 3, 3).applyTo(drawer);
		drawer.setBackground(lightBlue);

		if (getNotification().getRelatedModelElements().size() > 1) {
			entry.addMouseListener(clickListener);
			link.addMouseListener(clickListener);

			for (ModelElementId mid : getNotification().getRelatedModelElements()) {
				Control drawerEntry = URLHelper.getModelElementLink(drawer, mid, getProject(), URLHelper.UNLTD);
				GridDataFactory.fillDefaults().grab(true, false).applyTo(drawerEntry);
			}
		}
	}

	private void toggleDrawer(TypedEvent e, boolean open) {
		int height;
		int indent;
		if (open) {
			indent = 10;
			height = SWT.DEFAULT;
			final NotificationReadEvent readEvent = EventsFactory.eINSTANCE.createNotificationReadEvent();
			readEvent.setNotificationId(getNotification().getIdentifier());
			readEvent.setReadView(DashboardEditor.ID);
			readEvent.setSourceView(DashboardEditor.ID);
			readEvent.setTimestamp(new Date());
			TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					getProject().addEvent(readEvent);
				}
			});
		} else {
			indent = 0;
			height = 0;
		}
		GridDataFactory.fillDefaults().hint(480, height).grab(true, false).span(3, 1).indent(20, indent)
			.applyTo(drawer);
		getParent().layout();
		getPage().getForm().reflow(true);
	}

	private void logEvent(ModelElementId modelElementId, String source) {
		final NotificationReadEvent readEvent = EventsFactory.eINSTANCE.createNotificationReadEvent();
		readEvent.setModelElement(modelElementId);
		readEvent.setNotificationId(getNotification().getIdentifier());
		readEvent.setReadView("org.unicase.ui.meeditor");
		readEvent.setSourceView(DashboardEditor.ID + "." + source);
		readEvent.setTimestamp(new Date());
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				getProject().addEvent(readEvent);
			}
		});
	}

	private Link createImageLink(ModelElement modelElement, Composite parent, String text) {
		final Image image = labelProvider.getImage(modelElement);
		final Composite imageComposite = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().hint(16, 16).applyTo(imageComposite);
		imageComposite.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				Rectangle area = imageComposite.getClientArea();
				e.gc.drawImage(image, area.x, area.y);
			}
		});
		imageComposite.setData(modelElement.eClass());
		ModelElementClassTooltip.enableFor(imageComposite);

		Link link = new Link(parent, SWT.WRAP | SWT.MULTI);
		if (text == null) {
			text = "";
		}
		link.setText(text);
		GridDataFactory.fillDefaults().hint(500, SWT.DEFAULT).grab(true, true).applyTo(link);
		return link;
	}

	private void logEvent(ESNotification n, ProjectSpace projectSpace) {
		NotificationIgnoreEvent notificationIgnoreEvent = EventsFactory.eINSTANCE.createNotificationIgnoreEvent();
		notificationIgnoreEvent.setTimestamp(new Date());
		notificationIgnoreEvent.setNotificationId(n.getIdentifier());
		projectSpace.addEvent(notificationIgnoreEvent);
	}

}
