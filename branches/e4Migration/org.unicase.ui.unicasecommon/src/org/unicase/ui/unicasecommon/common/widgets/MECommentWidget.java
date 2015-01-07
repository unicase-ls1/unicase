/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.widgets;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;

import org.eclipse.emf.emfstore.internal.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.internal.client.model.util.WorkspaceUtil;
import org.eclipse.emf.emfstore.internal.common.model.util.ModelUtil;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Resource;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;
import org.unicase.model.rationale.Comment;
import org.unicase.ui.unicasecommon.Activator;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;

/**
 * Standard widget to show a comment and all its replies.
 * 
 * @author Shterev
 */
public class MECommentWidget extends Composite {

	private ArrayList<Resource> localResources;
	private ArrayList<MECommentWidget> replies;
	private HashSet<MECommentWidgetListener> listeners;
	private boolean toggleReplies = true;
	private boolean toggleInput = true;
	private Comment comment;
	private Composite repliesComposite;
	private Composite inputComposite;
	private User currentUser;
	private ImageHyperlink toggleButton;
	private Image expandedImage;
	private Image collapsedImage;
	private Image nocommentsImage;
	private Image deleteImage;
	private ImageHyperlink deleteButton;
	private MECommentWidget parentWidget;

	/**
	 * Default constructor.
	 * 
	 * @param comment the comment object
	 * @param composite the parent composite
	 */
	public MECommentWidget(Comment comment, Composite composite) {
		this(comment, composite, true);
	}

	/**
	 * Default constructor.
	 * 
	 * @param comment the comment object
	 * @param composite the parent composite
	 * @param showReplies show/hide replies
	 */
	public MECommentWidget(final Comment comment, Composite composite, boolean showReplies) {
		super(composite, SWT.NONE);
		this.comment = comment;
		replies = new ArrayList<MECommentWidget>();
		localResources = new ArrayList<Resource>();
		listeners = new HashSet<MECommentWidgetListener>();

		if (comment.eContainer() != null) {
			try {
				currentUser = OrgUnitHelper.getUser(WorkspaceManager.getProjectSpace(comment));
			} catch (NoCurrentUserException e1) {
				WorkspaceUtil.logWarning("You don't have a valid user! ", e1);
			} catch (CannotMatchUserInProjectException e1) {
				WorkspaceUtil.logWarning("Your user cannot be matched in the project! ", e1);
			}
		}

		GridLayoutFactory.fillDefaults().spacing(0, 0).applyTo(this);

		Composite commentTitleBar = new Composite(this, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(4).equalWidth(false).margins(2, 2).applyTo(commentTitleBar);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(commentTitleBar);
		Color titlebarColor = new Color(getDisplay(), 231, 208, 159);
		localResources.add(titlebarColor);
		commentTitleBar.setBackground(titlebarColor);

		if (showReplies) {
			toggleButton = new ImageHyperlink(commentTitleBar, SWT.WRAP);
			toggleButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseUp(MouseEvent e) {
					if (MECommentWidget.this.comment.getComments().isEmpty()) {
						return;
					}
					toggleReplies = !toggleReplies;
					if (toggleReplies) {
						toggleButton.setImage(expandedImage);
					} else {
						toggleButton.setImage(collapsedImage);
					}
					reloadReplies();
				}
			});
			expandedImage = Activator.getImageDescriptor("icons/expanded.png").createImage();
			collapsedImage = Activator.getImageDescriptor("icons/collapsed.png").createImage();
			nocommentsImage = Activator.getImageDescriptor("icons/nocomments.png").createImage();
			localResources.add(expandedImage);
			localResources.add(collapsedImage);
			localResources.add(nocommentsImage);
		}

		Label commentAuthor = new Label(commentTitleBar, SWT.WRAP);
		commentAuthor.setText(getTitlebarText(comment));
		GridDataFactory.fillDefaults().grab(true, false).applyTo(commentAuthor);

		Composite toolbar = new Composite(commentTitleBar, SWT.NONE);
		RowLayout toolbarLayout = new RowLayout();
		toolbarLayout.marginBottom = 0;
		toolbarLayout.marginTop = 0;
		toolbarLayout.spacing = 0;
		toolbar.setLayout(toolbarLayout);
		GridDataFactory.fillDefaults().grab(true, false).hint(-1, 19).align(SWT.END, SWT.BEGINNING).applyTo(toolbar);

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		Label commentTime = new Label(commentTitleBar, SWT.WRAP);
		if (comment.getCreationDate() != null) {
			commentTime.setText(dateFormat.format(comment.getCreationDate()));
		}

		Composite commentTitleBarBorder = new Composite(this, SWT.NONE);
		GridDataFactory.fillDefaults().span(2, 1).hint(SWT.DEFAULT, 1).grab(true, false).applyTo(commentTitleBarBorder);
		Color borderColor = new Color(getDisplay(), 189, 157, 95);
		localResources.add(borderColor);
		commentTitleBarBorder.setBackground(borderColor);

		Composite commentEntry = new Composite(this, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).spacing(3, 0).applyTo(commentEntry);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(commentEntry);
		commentEntry.setBackground(new Color(getDisplay(), 255, 245, 209));

		Label userAvatar = new Label(commentEntry, SWT.WRAP);
		userAvatar.setImage(getImage());
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(userAvatar);

		Label userComment = new Label(commentEntry, SWT.WRAP);
		if (comment.getDescription() != null) {
			userComment.setText(comment.getDescription().replaceAll("&", "&&"));
		}
		GridDataFactory.fillDefaults().hint(200, -1).grab(true, false).applyTo(userComment);

		if (comment.eContainer() != null && currentUser != null) {
			// only if contained in a project - i.e. not for pushed comments
			ImageHyperlink replyButton = new ImageHyperlink(toolbar, SWT.TOP);
			Image replyImage = Activator.getImageDescriptor("icons/commentReply.png").createImage();
			localResources.add(replyImage);
			replyButton.setImage(replyImage);
			replyButton.setToolTipText("Reply");
			replyButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseUp(MouseEvent e) {
					createInputEntry();
					toggleInput = false;
					notifyListeners();
				}
			});

			if (comment.getSender() != null && comment.getSender().equals(currentUser)) {
				deleteButton = new ImageHyperlink(toolbar, SWT.TOP);
				deleteImage = Activator.getImageDescriptor("icons/delete_edit.gif").createImage();
				localResources.add(deleteImage);
				deleteButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseUp(MouseEvent e) {
						new EMFStoreCommand() {
							@Override
							protected void doRun() {
								ModelUtil.getProject(comment).deleteModelElement(comment);
								MECommentWidget.this.dispose();
								MECommentWidget parent = MECommentWidget.this.getParentWidget();
								if (parent != null && parent.getParentWidget() != null) {
									parent.updateTitleBar();
									parent.getParentWidget().reloadReplies();
								} else if (parent != null) {
									parent.updateTitleBar();
									parent.reloadReplies();
								}
							}
						}.run();
					}
				});
			}

		} else {
			commentTime.setText("");
		}

		inputComposite = new Composite(this, SWT.NONE);
		GridLayoutFactory.fillDefaults().applyTo(inputComposite);
		GridDataFactory.fillDefaults().grab(true, false).hint(-1, 0).applyTo(inputComposite);

		if (!comment.getComments().isEmpty() && showReplies) {
			reloadReplies();
		}
		updateTitleBar();
	}

	private String getTitlebarText(Comment comment) {
		StringBuilder builder = new StringBuilder();

		// author
		final OrgUnit sender = comment.getSender();
		if (sender == null) {
			builder.append(comment.getCreator());
		} else {
			builder.append(sender.getName() + "");
		}
		// recipients
		if (!comment.getRecipients().isEmpty()) {
			builder.append(" @ ");
			int size = comment.getRecipients().size();
			for (int i = 0; i < size; i++) {
				builder.append(comment.getRecipients().get(i).getName());
				if (i < size - 1) {
					builder.append(", ");
				}
			}
		}

		return builder.toString();
	}

	/**
	 * @return the parent widget.
	 */
	protected MECommentWidget getParentWidget() {
		return parentWidget;
	}

	private void createInputEntry() {
		if (!toggleInput) {
			return;
		}
		GridDataFactory.fillDefaults().grab(true, false).applyTo(inputComposite);
		final MECommentReplyWidget replyWidget = new MECommentReplyWidget(comment, inputComposite, currentUser);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(replyWidget);
		replyWidget.addCommentWidgetListener(new MECommentWidgetListener() {
			public void commentAdded(Comment newComment) {
				updateTitleBar();
				reloadReplies();
				commentInputClosed();
			}

			public void commentInputClosed() {
				replyWidget.dispose();
				GridDataFactory.fillDefaults().grab(true, false).hint(-1, 0).applyTo(inputComposite);
				commentLayoutUpdated();
				toggleInput = true;
			}

			public void commentLayoutUpdated() {
				for (MECommentWidgetListener l : listeners) {
					l.commentLayoutUpdated();
				}
			}
		});
	}

	/**
	 * Updates the titlebar buttons.
	 */
	protected void updateTitleBar() {
		if (comment.getComments().isEmpty()) {
			toggleButton.setImage(nocommentsImage);
		} else {
			toggleButton.setImage(expandedImage);
		}
		if (deleteButton != null) {
			if (comment.getComments().isEmpty()) {
				deleteButton.setImage(deleteImage);
				deleteButton.setToolTipText("Delete");
			} else {
				deleteButton.setImage(null);
			}
		}

	}

	/**
	 * Reloads all replies and relayouts the widget.
	 */
	protected void reloadReplies() {
		if (repliesComposite != null) {
			repliesComposite.dispose();
		}
		if (!toggleReplies) {
			notifyListeners();
			return;
		}
		repliesComposite = new Composite(this, SWT.NONE);
		GridLayoutFactory.fillDefaults().spacing(0, 0).applyTo(repliesComposite);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(repliesComposite);

		for (Comment c : comment.getComments()) {
			MECommentWidget reply = new MECommentWidget(c, repliesComposite);
			GridDataFactory.fillDefaults().indent(30, 0).grab(true, false).applyTo(reply);
			replies.add(reply);
			reply.setParentWidget(this);
			for (MECommentWidgetListener l : listeners) {
				reply.addCommentWidgetListener(l);
			}
		}
		notifyListeners();
	}

	/**
	 * Sets the parent.
	 * 
	 * @param parentWidget the parent
	 */
	protected void setParentWidget(MECommentWidget parentWidget) {
		this.parentWidget = parentWidget;
	}

	private void notifyListeners() {
		for (MECommentWidgetListener l : listeners) {
			l.commentLayoutUpdated();
		}
	}

	/**
	 * Disposes this widget.
	 */
	@Override
	public void dispose() {
		for (Resource r : localResources) {
			r.dispose();
		}
		for (MECommentWidget widget : replies) {
			widget.dispose();
		}
		super.dispose();
	}

	private Image getImage() {
		// TODO: add user images
		Image guest = Activator.getImageDescriptor("icons/guest_thumb.png").createImage();
		localResources.add(guest);
		return guest;
	}

	/**
	 * Registers a new listener.
	 * 
	 * @param listener the listener.
	 */
	public void addCommentWidgetListener(MECommentWidgetListener listener) {
		listeners.add(listener);
		for (MECommentWidget widget : replies) {
			widget.addCommentWidgetListener(listener);
		}
	}
}
