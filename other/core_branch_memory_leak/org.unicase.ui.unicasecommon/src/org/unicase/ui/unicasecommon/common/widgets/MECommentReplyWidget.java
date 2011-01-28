/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.widgets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Resource;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.rationale.Comment;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.ui.common.Activator;
import org.unicase.ui.common.util.CannotMatchUserInProjectException;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.InvalidHandleException;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Standard widget to show an input field for comment replies.
 * 
 * @author Shterev
 */
public class MECommentReplyWidget extends Composite {

	/**
	 * Command for creatin a comment.
	 * 
	 * @author helming
	 */
	private final class CreateCommentCommand extends UnicaseCommand {
		private final EList<OrgUnit> recipientsList;
		private final Text inputText;

		private CreateCommentCommand(EList<OrgUnit> recipientsList, Text inputText) {
			super();
			this.recipientsList = recipientsList;
			this.inputText = inputText;
		}

		@Override
		protected void doRun() {
			CompositeOperationHandle compositeOperationHandle = WorkspaceManager.getProjectSpace(modelElement)
				.beginCompositeOperation();
			final Comment newComment = RationaleFactory.eINSTANCE.createComment();

			modelElement.getComments().add(newComment);
			newComment.getRecipients().addAll(recipientsList);
			String text = inputText.getText();
			if ((text != null) && !text.equals("")) {

				String title = text;
				int ende = 20;
				if (ende < (text.length())) {
					title = text.substring(0, ende) + AUTOGEN;
				}
				newComment.setName(title);
				newComment.setDescription(text);
			}
			newComment.setSender(sender);
			try {
				compositeOperationHandle.end("add comment", "Added new comment", ModelUtil.getProject(modelElement)
					.getModelElementId(modelElement));
				notifyCommentAdded(newComment);
			} catch (InvalidHandleException e) {
				WorkspaceUtil.logException("Could not add comment, there was a composite operation handle exception.",
					e);
			}
		}
	}

	private ArrayList<Resource> localResources;
	private HashSet<MECommentWidgetListener> listeners;
	private UnicaseModelElement modelElement;
	private Composite inputComposite;
	private AdapterFactoryLabelProvider labelProvider;
	private User sender;
	/**
	 * Constant for autogenerated comments.
	 */
	public static final String AUTOGEN = "...";

	/**
	 * Default constructor.
	 * 
	 * @param comment the comment object
	 * @param composite the parent composite
	 * @param sender the User which is entering this comment
	 */
	public MECommentReplyWidget(UnicaseModelElement comment, Composite composite, User sender) {
		super(composite, SWT.NONE);
		this.modelElement = comment;
		this.sender = sender;
		localResources = new ArrayList<Resource>();
		listeners = new HashSet<MECommentWidgetListener>();
		labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		// jc: open
		GridLayoutFactory.fillDefaults().spacing(0, 0).applyTo(this);

		inputComposite = new Composite(this, SWT.NONE);
		GridLayoutFactory.fillDefaults().spacing(0, 0).extendedMargins(40, 175, 7, 17).applyTo(inputComposite);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(inputComposite);
		inputComposite.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				int x = inputComposite.getClientArea().x;
				int y = inputComposite.getClientArea().y;
				gc.setAntialias(SWT.ON);
				gc.setBackground(getDisplay().getSystemColor(SWT.COLOR_GRAY));
				gc.fillRoundRectangle(x + 30, y - 25, inputComposite.getSize().x - 200,
					inputComposite.getSize().y + 15, 20, 20);
				gc.setBackground(getDisplay().getSystemColor(SWT.COLOR_GRAY));
				gc.fillRoundRectangle(x + 30, y - 25, inputComposite.getSize().x - 200,
					inputComposite.getSize().y + 15, 20, 20);
				gc.setForeground(getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY));
				gc.drawRoundRectangle(x + 30, y - 25, inputComposite.getSize().x - 200,
					inputComposite.getSize().y + 15, 20, 20);
			}
		});
		createInputEntry();
	}

	private void createInputEntry() {
		Composite inputEntry = new Composite(inputComposite, SWT.NONE);
		inputEntry.setBackgroundMode(SWT.INHERIT_FORCE);
		inputEntry.setBackground(getDisplay().getSystemColor(SWT.COLOR_GRAY));
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(inputEntry);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(inputEntry);

		final Text inputText = new Text(inputEntry, SWT.MULTI | SWT.WRAP | SWT.BORDER | SWT.V_SCROLL);
		GridDataFactory.fillDefaults().grab(true, false).hint(-1, 40).applyTo(inputText);
		inputText.setBackground(getDisplay().getSystemColor(SWT.COLOR_WHITE));

		ImageHyperlink closeButton = new ImageHyperlink(inputEntry, SWT.TOP);
		GridDataFactory.fillDefaults().align(SWT.END, SWT.BEGINNING).applyTo(closeButton);
		Image closeImage = Activator.getImageDescriptor("icons/close.png").createImage();
		localResources.add(closeImage);
		closeButton.setImage(closeImage);
		closeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				inputComposite.dispose();
				notifyListeners();
			}
		});

		final Composite recipientsComposite = new Composite(inputEntry, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).span(2, 1).applyTo(recipientsComposite);
		GridLayoutFactory.fillDefaults().numColumns(5).applyTo(recipientsComposite);

		Label recipientsLabel = new Label(recipientsComposite, SWT.WRAP);
		recipientsLabel.setText("Recipients: ");

		final Label recipients = new Label(recipientsComposite, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.CENTER).applyTo(recipients);

		final EList<OrgUnit> recipientsList = new BasicEList<OrgUnit>();
		ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(ModelUtil.getProject(modelElement));
		try {
			User user = OrgUnitHelper.getUser(projectSpace, modelElement.getCreator());
			recipientsList.add(user);
		} catch (CannotMatchUserInProjectException e1) {

		}
		rebuildRecipientList(recipients, recipientsList);
		recipientsComposite.layout();

		ImageHyperlink addButton = new ImageHyperlink(recipientsComposite, SWT.TOP);
		ImageHyperlink removeButton = new ImageHyperlink(recipientsComposite, SWT.TOP);
		ImageHyperlink acceptButton = new ImageHyperlink(recipientsComposite, SWT.TOP);
		Image addImage = Activator.getImageDescriptor("icons/add.png").createImage();
		Image removeImage = Activator.getImageDescriptor("icons/remove.png").createImage();
		Image acceptImage = Activator.getImageDescriptor("icons/accept.png").createImage();
		localResources.add(addImage);
		localResources.add(removeImage);
		localResources.add(acceptImage);
		addButton.setImage(addImage);
		removeButton.setImage(removeImage);
		acceptButton.setImage(acceptImage);
		GridDataFactory.fillDefaults().align(SWT.END, SWT.CENTER).grab(true, false).applyTo(acceptButton);
		inputText.setFocus();
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				final EList<OrgUnit> list = new BasicEList<OrgUnit>();
				WorkspaceManager.getProjectSpace(modelElement).getProject()
					.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getOrgUnit(), list);
				list.removeAll(recipientsList);
				ElementListSelectionDialog dialog = new ElementListSelectionDialog(getShell(), labelProvider);
				dialog.setMultipleSelection(true);
				dialog.setElements(list.toArray());
				if (dialog.open() == Window.OK) {
					Object[] result = dialog.getResult();
					for (Object o : result) {
						if (o instanceof OrgUnit) {
							recipientsList.add((OrgUnit) o);
						}
					}
					rebuildRecipientList(recipients, recipientsList);
					recipientsComposite.layout();
				}
			}
		});

		removeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ElementListSelectionDialog dialog = new ElementListSelectionDialog(getShell(), labelProvider);
				dialog.setMultipleSelection(true);
				dialog.setElements(recipientsList.toArray());
				if (dialog.open() == Window.OK) {
					Object[] result = dialog.getResult();
					for (Object o : result) {
						recipientsList.remove(o);
					}
					rebuildRecipientList(recipients, recipientsList);
					recipientsComposite.layout();
				}
			}
		});

		acceptButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				new CreateCommentCommand(recipientsList, inputText).run(true);
			}
		});
	}

	private void rebuildRecipientList(Label recipients, List<OrgUnit> list) {
		StringBuilder builder = new StringBuilder();
		String string = "";
		if (list.size() > 0) {
			for (OrgUnit orgUnit : list) {
				builder.append(orgUnit.getName());
				builder.append(", ");
			}
			string = builder.toString();
			string = string.substring(0, string.length() - 2);
		}
		recipients.setText(string);
	}

	private void notifyListeners() {
		for (MECommentWidgetListener l : listeners) {
			l.commentInputClosed();
		}
	}

	private void notifyCommentAdded(Comment newComment) {
		for (MECommentWidgetListener l : listeners) {
			l.commentAdded(newComment);
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
		super.dispose();
	}

	/**
	 * Registers a new listener.
	 * 
	 * @param listener the listener.
	 */
	public void addCommentWidgetListener(MECommentWidgetListener listener) {
		listeners.add(listener);
	}

}
