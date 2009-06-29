/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols.commentcontrol;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;

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
import org.unicase.model.rationale.Comment;
import org.unicase.ui.meeditor.Activator;

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
	 * @param enableReplies show/hide replies
	 */
	public MECommentWidget(Comment comment, Composite composite, boolean enableReplies) {
		super(composite, SWT.NONE);
		this.comment = comment;
		replies = new ArrayList<MECommentWidget>();
		localResources = new ArrayList<Resource>();
		listeners = new HashSet<MECommentWidgetListener>();
		GridLayoutFactory.fillDefaults().spacing(0, 0).applyTo(this);

		Composite commentTitleBar = new Composite(this, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(4).equalWidth(false).margins(2, 2).applyTo(commentTitleBar);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(commentTitleBar);
		Color titlebarColor = new Color(getDisplay(), 231, 208, 159);
		localResources.add(titlebarColor);
		commentTitleBar.setBackground(titlebarColor);

		if (enableReplies) {
			final ImageHyperlink toggleButton = new ImageHyperlink(commentTitleBar, SWT.TOP);
			final int numReplies = MECommentsLinkControl.sizeOf(comment) - 1;
			final Image expandedImage = Activator.getImageDescriptor("icons/expanded.png").createImage();
			final Image collapsedImage = Activator.getImageDescriptor("icons/collapsed.png").createImage();
			localResources.add(expandedImage);
			localResources.add(collapsedImage);
			if (numReplies > 0) {
				toggleButton.setImage(expandedImage);
			} else {
				toggleButton.setImage(collapsedImage);
			}
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
		}

		Label commentAuthor = new Label(commentTitleBar, SWT.WRAP);

		final OrgUnit sender = comment.getSender();
		if (sender == null) {
			commentAuthor.setText(comment.getCreator());
		} else {
			commentAuthor.setText(sender.getName() + "");
		}
		GridDataFactory.fillDefaults().grab(true, false).applyTo(commentAuthor);

		Composite toolbar = new Composite(commentTitleBar, SWT.NONE);
		RowLayout toolbarLayout = new RowLayout();
		toolbarLayout.marginBottom = 0;
		toolbarLayout.marginTop = 0;
		toolbarLayout.spacing = 0;
		toolbar.setLayout(toolbarLayout);

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		Label commentTime = new Label(commentTitleBar, SWT.WRAP);
		commentTime.setText(dateFormat.format(comment.getCreationDate()));

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
			userComment.setText(comment.getDescription());
		}
		GridDataFactory.fillDefaults().grab(true, false).applyTo(userComment);

		ImageHyperlink replyButton = new ImageHyperlink(toolbar, SWT.TOP);
		if (comment.eContainer() != null) {
			Image replyImage = Activator.getImageDescriptor("icons/commentReply.png").createImage();
			localResources.add(replyImage);
			replyButton.setImage(replyImage);
			replyButton.setToolTipText("Reply");
		}
		replyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				createInputEntry();
				toggleInput = false;
				notifyListeners();
			}
		});

		inputComposite = new Composite(this, SWT.NONE);
		GridLayoutFactory.fillDefaults().applyTo(inputComposite);
		GridDataFactory.fillDefaults().grab(true, false).hint(-1, 0).applyTo(inputComposite);

		if (!comment.getComments().isEmpty() && enableReplies) {
			reloadReplies();
		}
	}

	private void createInputEntry() {
		if (!toggleInput) {
			return;
		}
		GridDataFactory.fillDefaults().grab(true, false).applyTo(inputComposite);
		final MECommentReplyWidget replyWidget = new MECommentReplyWidget(comment, inputComposite);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(replyWidget);
		replyWidget.addCommentWidgetListener(new MECommentWidgetListener() {
			public void commentAdded() {
				for (MECommentWidgetListener l : listeners) {
					l.commentAdded();
				}
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

	private void reloadReplies() {
		if (!toggleReplies) {
			if (repliesComposite != null) {
				repliesComposite.dispose();
				notifyListeners();
			}
			return;
		}
		repliesComposite = new Composite(this, SWT.NONE);
		GridLayoutFactory.fillDefaults().spacing(0, 0).applyTo(repliesComposite);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(repliesComposite);

		for (Comment c : comment.getComments()) {
			MECommentWidget reply = new MECommentWidget(c, repliesComposite);
			GridDataFactory.fillDefaults().indent(30, 0).grab(true, false).applyTo(reply);
			replies.add(reply);
			for (MECommentWidgetListener l : listeners) {
				reply.addCommentWidgetListener(l);
			}
		}
		notifyListeners();
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
