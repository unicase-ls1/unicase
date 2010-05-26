/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard.view;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TypedEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Resource;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.RowLayout;
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

import org.unicase.metamodel.ModelElementId;
import org.unicase.model.rationale.Comment;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.common.util.ModelElementClassTooltip;
import org.unicase.ui.common.util.URLHelper;
import org.unicase.ui.dashboard.Activator;
import org.unicase.ui.dashboard.notificationProviders.CommentsNotificationProvider;
import org.unicase.ui.dashboard.notificationProviders.PushedNotificationProvider;
import org.unicase.ui.unicasecommon.common.widgets.MECommentWidget;
import org.unicase.ui.unicasecommon.common.widgets.MECommentWidgetListener;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.exceptions.MEUrlResolutionException;
import org.unicase.workspace.preferences.DashboardKey;
import org.unicase.workspace.preferences.PreferenceManager;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * A dashboard entry widget.
 * 
 * @author Shterev.
 */
public class DashboardNotificationEntry extends AbstractDashboardEntry {

	/**
	 * A mouse adapter that toggles the drawer.
	 * 
	 * @author Shterev
	 */
	private final class ToggleDrawerAdapter extends MouseAdapter {
		@Override
		public void mouseUp(MouseEvent e) {
			toggleDrawer(e, showDrawer);
			showDrawer = !showDrawer;
			getPage().getForm().reflow(true);
			notificationComposite.setFocus();
		}
	}

	/**
	 * A hover listener to change the color appearance of the notification.
	 * 
	 * @author Shterev
	 */
	private final class HoverTrackAdapter extends MouseTrackAdapter {
		@Override
		public void mouseEnter(MouseEvent e) {
			setBackground(lightBlue);
			mouseOver = true;
			if (e.widget.equals(closeButton)) {
				mouseOverClose = true;
			}
		}

		@Override
		public void mouseExit(MouseEvent e) {
			setBackground(notificationColor);
			mouseOver = false;
			if (e.widget.equals(closeButton)) {
				mouseOverClose = false;
			}
		}
	}

	/**
	 * Selection listener for the links.
	 * 
	 * @author Shterev
	 */
	private final class LinkSelectionListener extends SelectionAdapter {

		private String source;

		public LinkSelectionListener(String source) {
			super();
			this.source = source;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			String text = e.text;
			if (text.equals("more")) {
				return;
			}
			try {
				ModelElementUrl modelElementUrl = UrlFactory.eINSTANCE
						.createModelElementUrl(text);
				EObject modelElement = null;
				ModelElementUrlFragment modelElementUrlFragment = modelElementUrl
						.getModelElementUrlFragment();
				try {
					modelElement = getProjectSpace().resolve(
							modelElementUrlFragment);
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
	private Composite drawerComposite;
	private Composite notificationComposite;
	private boolean mouseOver;
	private boolean mouseOverClose;

	private boolean showDrawer = true;
	private AdapterFactoryLabelProvider labelProvider;
	private Composite closeButton;
	private Link entryMessage;
	private Composite toolbar;
	private List<Comment> comments;
	private Composite commentsComposite;
	private ArrayList<Resource> localResources;

	/**
	 * Default constructor.
	 * 
	 * @param parent
	 *            the parent composite.
	 * @param style
	 *            the style.
	 * @param notification
	 *            the notification.
	 * @param project
	 *            the project.
	 * @param page
	 *            a back link to the dashboard page (needed only for layout
	 *            purposes).
	 */
	public DashboardNotificationEntry(DashboardPage page, Composite parent,
			int style, ESNotification notification, ProjectSpace project) {
		super(page, parent, style, notification, project);
		localResources = new ArrayList<Resource>();

		lightBlue = new Color(getDisplay(), 233, 244, 255);
		localResources.add(lightBlue);

		notificationColor = getDisplay().getSystemColor(SWT.COLOR_WHITE);
		if (getNotification().getProvider().equals(
				PushedNotificationProvider.NAME)
				&& PreferenceManager.INSTANCE.getProperty(getProjectSpace(),
						DashboardKey.HIGHLIGHT_PUSHED_COMMENTS)
						.getBooleanProperty()) {
			notificationColor = getDisplay().getSystemColor(
					SWT.COLOR_INFO_BACKGROUND);
		}
		format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		labelProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		comments = getComments();
		createEntry();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		for (Resource r : localResources) {
			r.dispose();
		}
		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createEntry() {
		// contains the entry and the close button
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false)
				.margins(3, 0).applyTo(this);
		setBackground(notificationColor);

		// contains the entry - everything apart from the close button
		notificationComposite = new Composite(this, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(
				notificationComposite);
		GridLayoutFactory.fillDefaults().spacing(0, 0).applyTo(
				notificationComposite);

		if (getNotification().getRelatedModelElements().size() == 0) {
			// assuming that _all_ notifications are based on a specific element
			return;
		}

		createNotificationEntry();
		createCloseButton();
		createDrawer();

		MouseTrackAdapter hoverListener = new HoverTrackAdapter();
		addMouseTrackListener(this, hoverListener);
	}

	private void addMouseTrackListener(Control control,
			MouseTrackListener listener) {
		control.addMouseTrackListener(listener);
		if (control instanceof Composite) {
			for (Control c : ((Composite) control).getChildren()) {
				addMouseTrackListener(c, listener);
			}
		}
	}

	private void createComments() {
		commentsComposite = new Composite(notificationComposite, SWT.NONE);
		GridLayoutFactory.fillDefaults().spacing(0, 0).applyTo(
				commentsComposite);
		GridDataFactory.fillDefaults().span(3, 1).indent(20, 0).grab(true,
				false).applyTo(commentsComposite);
		MECommentWidgetListener commentsWidgetListener = new MECommentWidgetListener() {
			public void commentLayoutUpdated() {
				completeLayout(true);
			}

			public void commentAdded(Comment newComment) {
				completeLayout(true);
			}

			public void commentInputClosed() {
				completeLayout(true);
			}
		};
		for (Comment comment : comments) {
			MECommentWidget widget = new MECommentWidget(comment,
					commentsComposite);
			GridDataFactory.fillDefaults().grab(true, false).applyTo(widget);
			widget.addCommentWidgetListener(commentsWidgetListener);
		}
		completeLayout();
	}

	/**
	 * 
	 */
	private void completeLayout() {
		completeLayout(false);
	}

	/**
	 * 
	 */
	private void completeLayout(boolean reflow) {
		commentsComposite.layout();
		getParent().layout();
		// Composite c = commentsComposite;
		// Composite topParent = c;
		// while (c != null) {
		// topParent = c;
		// c = c.getParent();
		// }
		// topParent.layout();
		if (reflow) {
			getPage().getForm().reflow(true);
		}
	}

	private void createDrawer() {

		drawerComposite = new Composite(notificationComposite, SWT.NONE);
		GridDataFactory.fillDefaults().hint(380, 0).grab(true, false)
				.span(3, 1).indent(20, 0).applyTo(drawerComposite);
		GridLayoutFactory.fillDefaults().numColumns(1).spacing(0, 8)
				.extendedMargins(3, 3, 3, 3).applyTo(drawerComposite);
		drawerComposite.setBackground(lightBlue);

		for (ModelElementId mid : getNotification().getRelatedModelElements()) {
			Control drawerEntry = URLHelper.getModelElementLink(
					drawerComposite, mid, getProjectSpace(), URLHelper.UNLTD);
			GridDataFactory.fillDefaults().grab(true, false).applyTo(
					drawerEntry);
		}

	}

	private void createCloseButton() {
		final Image closeImage = Activator
				.getImageDescriptor("icons/close.png").createImage();
		final Image closeImageRed = Activator.getImageDescriptor(
				"icons/cross.png").createImage();
		closeButton = new Composite(this, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.BEGINNING)
				.hint(18, 26).applyTo(closeButton);
		closeButton.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				if (mouseOver) {
					Rectangle area = closeButton.getClientArea();
					Image image = closeImage;
					if (mouseOverClose) {
						image = closeImageRed;
					}
					e.gc.drawImage(image, area.x, area.y + 5);
				}
			}
		});
		closeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				boolean hide = MessageDialog.openQuestion(getShell(),
						"Remove notification",
						"Are you sure you want to delete this notification?");
				if (hide) {
					new UnicaseCommand() {
						@Override
						protected void doRun() {
							getNotification().setSeen(true);
							logEvent(getNotification(), getProjectSpace());
							((DashboardEditor) getPage().getEditor()).refresh();
						}
					}.run();
				}
			}
		});
	}

	private void createNotificationEntry() {
		EObject modelElement = getFirstModelElement();

		// TODO Add the changepackage to the notification OR add the
		// modelelement itself on create/deletes.
		if (modelElement == null) {
			return;
		}

		// the composite that wraps the whole notification
		Composite notificationEntry = new Composite(notificationComposite,
				SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(
				notificationEntry);
		GridLayoutFactory.fillDefaults().numColumns(4).equalWidth(false)
				.margins(6, 6).spacing(3, 0).applyTo(notificationEntry);

		// the image
		final Image image = labelProvider.getImage(modelElement);
		final Composite imageComposite = new Composite(notificationEntry,
				SWT.NONE);
		GridDataFactory.fillDefaults().hint(16, 16).applyTo(imageComposite);
		imageComposite.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				Rectangle area = imageComposite.getClientArea();
				e.gc.drawImage(image, area.x, area.y);
			}
		});
		imageComposite.setData(modelElement.eClass());
		ModelElementClassTooltip.enableFor(imageComposite);

		// the message
		entryMessage = new Link(notificationEntry, SWT.WRAP | SWT.MULTI);
		String text = getNotification().getMessage();
		if (text == null) {
			text = "";
		}
		entryMessage.setText(text);
		GridDataFactory.fillDefaults().hint(400, SWT.DEFAULT).grab(true, false)
				.applyTo(entryMessage);
		entryMessage.addSelectionListener(new LinkSelectionListener("link"));

		// the toolbar
		createToolbar(notificationEntry);

		int commentsCount = comments.size();
		if (commentsCount > 0 && commentsCount < 5) {
			createComments();
		}

		// the date
		Label date = new Label(notificationEntry, SWT.NONE);
		date.setText(format.format(getNotification().getCreationDate()));
		GridDataFactory.fillDefaults().align(SWT.END, SWT.BEGINNING).applyTo(
				date);
		date.setForeground(getDisplay().getSystemColor(SWT.COLOR_GRAY));
	}

	private void createToolbar(Composite parent) {
		toolbar = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.BEGINNING)
				.applyTo(toolbar);
		RowLayout layout = new RowLayout();
		layout.spacing = 0;
		layout.marginTop = 0;
		toolbar.setLayout(layout);
		if (getNotification().getRelatedModelElements().size() > 1) {
			DashboardToolbarAction toogleDrawer = new DashboardToolbarAction(
					toolbar, "details.png", 150);
			toogleDrawer.setToolTipText("Toggle details");
			ToggleDrawerAdapter toggleDrawerAdapter = new ToggleDrawerAdapter();
			toogleDrawer.addMouseListener(toggleDrawerAdapter);
			entryMessage.addMouseListener(toggleDrawerAdapter);
//			notificationComposite.addMouseListener(toggleDrawerAdapter);
		}
		if (comments.size() > 0 && comments.get(0).eContainer() != null) {
			DashboardToolbarAction openThread = new DashboardToolbarAction(
					toolbar, "comments.png", 110);
			openThread.setToolTipText("Open the discussion thread");
			openThread.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseUp(MouseEvent e) {
					EObject modelElement = comments.get(0)
							.getFirstParent();
					ActionHelper.openDiscussion(modelElement, false);
				}
			});
		}
		final EObject modelElement = getFirstModelElement();
		if (modelElement != null
				&& !getNotification().getRelatedOperations().isEmpty()) {
			DashboardToolbarAction showOperations = new DashboardToolbarAction(
					toolbar, "historyview.png", 110);
			showOperations.setToolTipText("View changes");
			showOperations.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseUp(MouseEvent event) {
					//TODO: FIX
//					IWorkbenchPage page = PlatformUI.getWorkbench()
//							.getActiveWorkbenchWindow().getActivePage();
//					HistoryBrowserView historyBrowserView = null;
//					String viewId = "org.unicase.workspace.ui.views.historybrowserview.HistoryBrowserView";
//					try {
//						historyBrowserView = (HistoryBrowserView) page
//								.showView(viewId);
//					} catch (PartInitException e) {
//						DialogHandler.showExceptionDialog(e);
//					}
//					if (historyBrowserView != null) {
//						historyBrowserView.setInput(getProjectSpace(),
//								modelElement);
//						historyBrowserView
//								.highlightOperations(getNotification()
//										.getRelatedOperations());
//					}
				}
			});
		}

	}

	private void toggleDrawer(TypedEvent e, boolean open) {
		if (open) {
			GridDataFactory.createFrom(
					(GridData) drawerComposite.getLayoutData()).hint(380,
					SWT.DEFAULT).applyTo(drawerComposite);
			final NotificationReadEvent readEvent = EventsFactory.eINSTANCE
					.createNotificationReadEvent();
			readEvent.setNotificationId(getNotification().getIdentifier());
			readEvent.setReadView(DashboardEditor.ID);
			readEvent.setSourceView(DashboardEditor.ID);
			readEvent.setTimestamp(new Date());
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					getProjectSpace().addEvent(readEvent);
				}
			}.run();
		} else {
			GridDataFactory.createFrom(
					(GridData) drawerComposite.getLayoutData()).hint(380, 0)
					.applyTo(drawerComposite);
		}
		getParent().layout();
	}

	private void logEvent(ModelElementId modelElementId, String source) {
		final NotificationReadEvent readEvent = EventsFactory.eINSTANCE
				.createNotificationReadEvent();
		readEvent.setModelElement(modelElementId);
		readEvent.setNotificationId(getNotification().getIdentifier());
		readEvent.setReadView("org.unicase.ui.meeditor");
		readEvent.setSourceView(DashboardEditor.ID + "." + source);
		readEvent.setTimestamp(new Date());
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getProjectSpace().addEvent(readEvent);
			}
		}.run();
	}

	private void logEvent(ESNotification n, ProjectSpace projectSpace) {
		NotificationIgnoreEvent notificationIgnoreEvent = EventsFactory.eINSTANCE
				.createNotificationIgnoreEvent();
		notificationIgnoreEvent.setTimestamp(new Date());
		notificationIgnoreEvent.setNotificationId(n.getIdentifier());
		projectSpace.addEvent(notificationIgnoreEvent);
	}

	private List<Comment> getComments() {
		ArrayList<Comment> comments = new ArrayList<Comment>();

		if (getNotification().getProvider().equals(
				PushedNotificationProvider.NAME)) {
			Comment comment = RationaleFactory.eINSTANCE.createComment();
			comment.setDescription(getNotification().getDetails());
			// TODO: set creator and creation date
//			comment.setCreator(getNotification().getSender());
//			comment.setCreationDate(getNotification().getCreationDate());
			comments.add(comment);
			return comments;
		}
		if (getNotification().getProvider().equals(
				CommentsNotificationProvider.NAME)) {
			if (getNotification().getRelatedModelElements().size() < 1) {
				return comments;
			}
			for (ModelElementId mid : getNotification()
					.getRelatedModelElements()) {
				EObject comment = getProjectSpace().getProject()
						.getModelElement(mid);
				if (comment != null) {
					comments.add((Comment) comment);
				}
			}
			return comments;
		}
		return comments;
	}
}
