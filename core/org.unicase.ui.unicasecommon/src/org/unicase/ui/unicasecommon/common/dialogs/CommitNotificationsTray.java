/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecp.common.util.DialogHandler;
import org.eclipse.emf.ecp.common.utilities.CannotMatchUserInProjectException;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.exceptions.NoCurrentUserException;
import org.eclipse.emf.emfstore.client.ui.dialogs.CommitDialog;
import org.eclipse.emf.emfstore.client.ui.dialogs.CommitDialogTray;
import org.eclipse.emf.emfstore.client.ui.views.changes.ChangePackageVisualizationHelper;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.VersioningFactory;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage;
import org.eclipse.emf.emfstore.server.model.versioning.operations.ReferenceOperation;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.dashboard.DashboardFactory;
import org.unicase.dashboard.DashboardNotification;
import org.unicase.dashboard.NotificationOperation;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.ui.unicasecommon.Activator;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;
import org.unicase.ui.unicasecommon.common.util.URLHelper;

/**
 * This class shows a dialog tray for the commit notifications.
 * 
 * @author Shterev
 */
public class CommitNotificationsTray extends CommitDialogTray {

	private List<DashboardNotification> notifications;
	private Image comment;
	private Image remove;
	private Image add;
	private ImageHyperlink removeButton;
	private ImageHyperlink addButton;
	private TableViewer notificationsTable;
	private CommitDialog commitDialog;
	private ColumnLabelProvider notificationLabelProvider;
	private ChangePackageVisualizationHelper visualizationHelper;
	private ProjectSpace projectSpace;

	/**
	 * Default initialization.
	 * 
	 * @param commitDialog the commit dialog
	 */
	@Override
	public void init(CommitDialog commitDialog) {
		notifications = new ArrayList<DashboardNotification>();
		this.commitDialog = commitDialog;
		projectSpace = commitDialog.getActiveProjectSpace();
		visualizationHelper = new ChangePackageVisualizationHelper(Arrays.asList(commitDialog.getChangePackage()),
			projectSpace.getProject());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.DialogTray#createContents(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createContents(Composite parent) {

		comment = Activator.getImageDescriptor("icons/comment.png").createImage();
		add = Activator.getImageDescriptor("icons/add.png").createImage();
		remove = Activator.getImageDescriptor("icons/remove.png").createImage();

		final SearchFilter searchFilter = new SearchFilter();

		Composite root = new Composite(parent, SWT.NONE);

		GridLayoutFactory.fillDefaults().margins(5, 5).applyTo(root);
		GridDataFactory.fillDefaults().hint(80, -1).grab(true, true).applyTo(root);

		Label title = new Label(root, SWT.WRAP);
		title.setText("Notify users about the changes you have made:");

		final Text search = new Text(root, SWT.SEARCH);// | SWT.ICON_CANCEL |
		// SWT.ICON_SEARCH);
		search.setMessage("search for a notification");
		GridDataFactory.fillDefaults().grab(true, false).applyTo(search);
		search.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				searchFilter.setText(search.getText());
				notificationsTable.refresh();
			}
		});

		notificationsTable = new TableViewer(root);
		notificationsTable.setContentProvider(new ArrayContentProvider());
		notificationLabelProvider = new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				DashboardNotification notification = (DashboardNotification) element;
				return notification.getDetails() + "[" + notification.getRecipient() + "]";
			}

			@Override
			public Image getImage(Object element) {
				return comment;
			}
		};
		notificationsTable.setLabelProvider(notificationLabelProvider);
		notificationsTable.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				if (notificationsTable.getSelection().isEmpty()) {
					removeButton.setEnabled(false);
				} else {
					removeButton.setEnabled(true);
				}
			}
		});

		notificationsTable.setFilters(new ViewerFilter[] { searchFilter });
		notificationsTable.setInput(notifications);

		GridDataFactory.fillDefaults().grab(true, true).applyTo(notificationsTable.getControl());

		Composite toolbar = new Composite(root, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).spacing(0, 0).applyTo(toolbar);
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.END).applyTo(toolbar);

		addButton = new ImageHyperlink(toolbar, SWT.TOP);
		addButton.setImage(add);
		addButton.setToolTipText("Add new notification");
		GridDataFactory.fillDefaults().indent(0, 0).applyTo(addButton);
		addButton.addHyperlinkListener(new HyperlinkAdapter() {
			@Override
			public void linkActivated(HyperlinkEvent e) {

				CommitNotificationDialog dialog = new CommitNotificationDialog(commitDialog.getShell(),
					getProjectSpace());
				dialog.open();
			}
		});

		removeButton = new ImageHyperlink(toolbar, SWT.TOP);
		removeButton.setImage(remove);
		removeButton.setToolTipText("Remove the selected notification");
		GridDataFactory.fillDefaults().indent(0, 0).applyTo(removeButton);
		removeButton.addHyperlinkListener(new HyperlinkAdapter() {
			@Override
			public void linkActivated(HyperlinkEvent e) {
				StructuredSelection selection = (StructuredSelection) notificationsTable.getSelection();
				notifications.removeAll(selection.toList());
				notificationsTable.setInput(notifications);
			}
		});

		return root;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void okPressed() {
		super.okPressed();
		if (!notifications.isEmpty()) {
			try {
				NotificationOperation operation = DashboardFactory.eINSTANCE.createNotificationOperation();
				operation.getNotifications().addAll(notifications);
				operation.setClientDate(new Date());
				operation.setModelElementId(OrgUnitHelper.getUser(projectSpace).getModelElementId());
				commitDialog.getChangePackage().getOperations().add(operation);
			} catch (NoCurrentUserException e) {
				ModelUtil.logException("Pushing notifications failed: No current user!", e);
			} catch (CannotMatchUserInProjectException e) {
				ModelUtil.logException("Pushing notifications failed: User couldn't be matched in project!", e);
			}

		}
	}

	/**
	 * @return the pushed notifications.
	 */
	public List<DashboardNotification> getNotifications() {
		return notifications;
	}

	/**
	 * @return the involved project space
	 */
	public ProjectSpace getProjectSpace() {
		return projectSpace;
	}

	/**
	 * The commit notification dialog.
	 * 
	 * @author shtervg
	 */
	private final class CommitNotificationDialog extends TitleAreaDialog {

		private List<User> users;
		private AbstractOperation operation;
		private ProjectSpace projectSpace;
		private Text commentText;

		public CommitNotificationDialog(Shell parentShell, ProjectSpace projectSpace) {
			super(parentShell);
			this.projectSpace = projectSpace;
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			setTitle("Create new notification");
			setMessage("Select the users you want to notify and the operation you want to notify them about");

			final AdapterFactoryLabelProvider userLabelProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

			Composite root = new Composite(parent, SWT.NONE);
			GridLayoutFactory.fillDefaults().numColumns(3).margins(10, 5).applyTo(root);
			GridDataFactory.fillDefaults().grab(true, true).applyTo(root);

			users = new ArrayList<User>();
			Label userLabel = new Label(root, SWT.WRAP);
			userLabel.setText("Users");
			final TableViewer userViewer = new TableViewer(root);
			GridDataFactory.fillDefaults().hint(50, -1).grab(true, false).applyTo(userViewer.getTable());
			userViewer.setLabelProvider(userLabelProvider);
			userViewer.setContentProvider(new ArrayContentProvider());
			userViewer.getTable().getHorizontalBar().setVisible(false);
			Button userButton = new Button(root, SWT.PUSH);
			GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(userButton);
			userButton.setText("Select users");
			userButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					ElementListSelectionDialog dialog = new ElementListSelectionDialog(getShell(), userLabelProvider);
					dialog.setMultipleSelection(true);
					dialog.setElements(projectSpace.getProject()
						.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(), new BasicEList<User>())
						.toArray(new User[0]));
					if (dialog.open() == IDialogConstants.OK_ID) {
						users.clear();
						Object[] result = dialog.getResult();
						for (Object o : result) {
							users.add((User) o);
						}
						userViewer.setInput(result);
					}
				}
			});

			ChangePackage changePackage = VersioningFactory.eINSTANCE.createChangePackage();
			for (AbstractOperation ao : commitDialog.getOperations()) {
				changePackage.getOperations().add(EcoreUtil.copy(ao));
			}
			final ChangePackageVisualizationHelper operationsHelper = new ChangePackageVisualizationHelper(
				Arrays.asList(changePackage), projectSpace.getProject());

			final LabelProvider operationsLabelProvider = new LabelProvider() {
				@Override
				public Image getImage(Object element) {
					return userLabelProvider.getImage(element);
				}

				@Override
				public String getText(Object element) {
					if (element instanceof AbstractOperation) {
						return operationsHelper.getDescription((AbstractOperation) element);
					}
					return "Not an operation.";
				}
			};

			Label operationLabel = new Label(root, SWT.WRAP);
			operationLabel.setText("Operation");
			final TableViewer operationViewer = new TableViewer(root);
			operationViewer.getTable().getHorizontalBar().setVisible(false);
			operationViewer.getTable().getVerticalBar().setVisible(false);
			GridDataFactory.fillDefaults().hint(50, 15).grab(true, false).applyTo(operationViewer.getTable());
			operationViewer.setLabelProvider(operationsLabelProvider);
			operationViewer.setContentProvider(new ArrayContentProvider());
			Button operationButton = new Button(root, SWT.PUSH);
			GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(operationButton);
			operationButton.setText("Select operation");
			operationButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					ElementListSelectionDialog dialog = new ElementListSelectionDialog(getShell(),
						operationsLabelProvider);
					dialog.setMultipleSelection(false);
					dialog.setElements(commitDialog.getOperations().toArray(new AbstractOperation[0]));
					if (dialog.open() == IDialogConstants.OK_ID) {
						Object result = dialog.getFirstResult();
						operationViewer.setInput(new Object[] { result });
						operation = (AbstractOperation) result;
					}
				}
			});

			Label commentLabel = new Label(root, SWT.WRAP);
			commentLabel.setText("Comment");
			commentText = new Text(root, SWT.BORDER);
			GridDataFactory.fillDefaults().span(2, 1).grab(true, false).applyTo(commentText);

			return root;
		}

		@Override
		protected void okPressed() {
			User currentUser;
			try {
				currentUser = OrgUnitHelper.getUser(projectSpace);

				for (User user : users) {
					DashboardNotification notification = DashboardFactory.eINSTANCE.createDashboardNotification();
					notification.setName("Pushed name");
					ProjectId projectIdCopy = EcoreUtil.copy(projectSpace.getProjectId());
					notification.setProject(projectIdCopy);
					notification.setSender(currentUser.getName());
					notification.setRecipient(user.getName());
					List<AbstractOperation> operations = commitDialog.getChangePackage().getOperations();
					notification.setCreationDate(operations.isEmpty() ? new Date(0) : operations.get(
						operations.size() - 1).getClientDate());
					String text = commentText.getText();
					notification.setDetails(text == null ? "" : text);
					notification.setSeen(false);
					StringBuilder msgBuilder = new StringBuilder();
					msgBuilder.append(URLHelper
						.getHTMLLinkForModelElement(currentUser, projectSpace, URLHelper.DEFAULT));
					msgBuilder.append(" sent you a notification about this change:\n");
					ModelElementId modelElementIdCopy = EcoreUtil.copy(operation.getModelElementId());
					msgBuilder.append(visualizationHelper.getDescription(operation));
					msgBuilder.append(" in ");
					msgBuilder.append(URLHelper.getHTMLLinkForModelElement(modelElementIdCopy, projectSpace,
						URLHelper.UNLTD));
					notification.setMessage(msgBuilder.toString());

					notification.getRelatedModelElements().add(modelElementIdCopy);
					if (OperationsPackage.eINSTANCE.getReferenceOperation().isInstance(operation)) {
						ReferenceOperation referenceOp = (ReferenceOperation) operation;
						Set<ModelElementId> otherInvolvedModelElements = referenceOp.getOtherInvolvedModelElements();
						for (ModelElementId id : otherInvolvedModelElements) {
							ModelElementId idCopy = EcoreUtil.copy(id);
							notification.getRelatedModelElements().add(idCopy);
						}
					}

					notifications.add(notification);

				}

			} catch (NoCurrentUserException e) {
				DialogHandler.showErrorDialog("You don't seem to have a valid user");
			} catch (CannotMatchUserInProjectException e) {
				DialogHandler.showErrorDialog("You don't seem to have a valid user");
			}
			notificationsTable.setInput(notifications.toArray());
			close();
		}
	}

	/**
	 * Filter for the notifications table.
	 * 
	 * @author Shterev
	 */
	private class SearchFilter extends ViewerFilter {

		private String text = "";

		/**
		 * Sets the search term.
		 * 
		 * @param text the term.
		 */
		public void setText(String text) {
			this.text = text;
		}

		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			if (notificationLabelProvider.getText(element).contains(text)) {
				return true;
			}
			return false;
		}
	};
}
