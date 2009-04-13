/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.dashboard.analyzer.commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.analyzer.VersionIterator;
import org.unicase.analyzer.exceptions.ItertorException;
import org.unicase.dashboard.analyzer.providers.CreatorNotificationProvider;
import org.unicase.dashboard.analyzer.providers.ModifierNotificationProvider;
import org.unicase.dashboard.analyzer.providers.TaskNotificationProvider;
import org.unicase.dashboard.analyzer.providers.TaskTraceNotificationProvider;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.bug.BugPackage;
import org.unicase.model.rationale.RationalePackage;
import org.unicase.model.task.TaskPackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.edit.views.changes.ChangePackageVisualizationHelper;
import org.unicase.workspace.notification.NotificationGenerator;

/**
 * Exports the esnotifications that were generated/used in the dashboard.
 */
public class DashboardAnalyzerHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent executionEvent) throws ExecutionException {

		ProjectSpace projectSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace();

		Usersession session = projectSpace.getUsersession();

		if (!session.isLoggedIn()) {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Login required", "Log in first!");
			return null;
		}
		ProjectId pid = (ProjectId) EcoreUtil.copy(projectSpace.getProjectId());
		int step = 1;

		PrimaryVersionSpec start = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		start.setIdentifier(1);
		PrimaryVersionSpec end = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		end.setIdentifier(10);
		VersionIterator iterator;
		ProgressMonitorDialog progressDialog = null;
		try {

			progressDialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
			progressDialog.open();
			progressDialog.getProgressMonitor().beginTask("Exporting notifications", IProgressMonitor.UNKNOWN);

			iterator = new VersionIterator(session, pid, step, start, end, true, true);

			FileWriter fileWriter = null;
			FileDialog dialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.SAVE);
			String path = dialog.open();
			if (path == null) {
				progressDialog.close();
				return null;
			}

			fileWriter = new FileWriter(path);
			BufferedWriter writer = new BufferedWriter(fileWriter);

			writer.write("Version,");
			writer.write("NotificationId,");
			writer.write("Provider,");
			writer.write("Message,");
			writer.write("User,");
			writer.write("Date,");
			writer.write("ME Id,");
			writer.write("ME Name,");
			writer.write("ME Class");
			writer.write("\n");

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String[] users = { "shterevg", "helming", "koegel", "naughton" };

			NotificationGenerator generator = new NotificationGenerator();

			TaskPackage taskPackage = TaskPackage.eINSTANCE;
			generator.addNotificationProvider(new TaskNotificationProvider(taskPackage.getActionItem()));
			generator.addNotificationProvider(new TaskNotificationProvider(RationalePackage.eINSTANCE.getIssue()));
			generator.addNotificationProvider(new TaskNotificationProvider(BugPackage.eINSTANCE.getBugReport()));
			generator.addNotificationProvider(new TaskNotificationProvider(taskPackage.getWorkPackage()));
			generator.addNotificationProvider(new TaskTraceNotificationProvider());
			generator.addNotificationProvider(new CreatorNotificationProvider());
			ModifierNotificationProvider modifierProvider = new ModifierNotificationProvider();
			generator.addNotificationProvider(modifierProvider);

			while (iterator.hasNext()) {
				try {
					ProjectAnalysisData analysisData = iterator.next();
					if (analysisData == null) {
						break;
					}
					progressDialog.getProgressMonitor().beginTask(
						"Writing revision " + analysisData.getPrimaryVersionSpec().getIdentifier(),
						IProgressMonitor.UNKNOWN);
					System.out.println("Writing revision " + analysisData.getPrimaryVersionSpec().getIdentifier());

					for (String user : users) {

						EList<ChangePackage> changePackages = analysisData.getChangePackages();

						// update the list of modifies elements for the modifier provider.
						updateModifiedElements(projectSpace, modifierProvider, user, changePackages);

						List<ESNotification> notifications = generator.generateNotifications(changePackages, user,
							projectSpace, false);
						for (ESNotification n : notifications) {
							writer.write(analysisData.getPrimaryVersionSpec().getIdentifier() + "");
							writer.write(",");
							writer.write(n.getIdentifier());
							writer.write(",");
							writer.write(n.getSender());
							writer.write(",");
							writer.write(n.getMessage().replaceAll("\n", " "));
							writer.write(",");
							writer.write(user);
							writer.write(",");
							final Date creationDate = n.getCreationDate();
							if (creationDate != null) {
								writer.write(dateFormat.format(creationDate));
							} else {
								writer.write("null");
							}
							writer.write(",");
							final ModelElementId modelElementId = n.getRelatedModelElements().get(0);
							if (modelElementId != null) {
								ModelElement modelElement = projectSpace.getProject().getModelElement(modelElementId);
								writer.write(modelElementId.getId());
								writer.write(",");
								if (modelElement == null) {
									writer.write("deleted");
									writer.write(",");
									writer.write("deleted");
								} else {
									writer.write(modelElement.getName());
									writer.write(",");
									writer.write(modelElement.eClass().getName());
								}
							} else {
								writer.write(",,");
							}
							writer.write("\n");
						}
					}
				} catch (RuntimeException e) {
					System.out.println(e);
					//
				} finally {
					writer.flush();
				}
			}
			writer.close();
		} catch (ItertorException e2) {
			e2.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		progressDialog.close();

		return null;
	}

	private void updateModifiedElements(ProjectSpace projectSpace, ModifierNotificationProvider modifierProvider,
		String user, EList<ChangePackage> changePackages) {
		ChangePackageVisualizationHelper visualizationHelper = new ChangePackageVisualizationHelper(
			changePackages, projectSpace.getProject());
		for (ChangePackage cp : changePackages) {
			if (cp.getLogMessage().getAuthor().equals(user)) {
				Set<EObject> allModelElements = visualizationHelper.getAllModelElements(cp);
				for (EObject eObject : allModelElements) {
					if (eObject instanceof ModelElement) {
						ModelElement modelElement = (ModelElement) eObject;
						if (modelElement.getCreator().equals(user)) {
							// discard all elements included in the creator provider
							continue;
						}
						modifierProvider.getWatchList().add(modelElement.getModelElementId());
					} else if (eObject instanceof ModelElementId) {
						modifierProvider.getWatchList().add((ModelElementId) eObject);
					}
				}
			}
		}
	}
}
