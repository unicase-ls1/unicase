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
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.analyzer.VersionIterator;
import org.unicase.analyzer.exceptions.IteratorException;
import org.unicase.dashboard.analyzer.providers.CreatorNotificationProvider;
import org.unicase.dashboard.analyzer.providers.ModifierNotificationProvider;
import org.unicase.dashboard.analyzer.providers.TaskNotificationProvider;
import org.unicase.dashboard.analyzer.providers.TaskTraceNotificationProvider;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.events.Event;
import org.unicase.emfstore.esmodel.versioning.events.EventsPackage;
import org.unicase.emfstore.esmodel.versioning.events.ReadEvent;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.bug.BugPackage;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
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

		HashMap<String, ReadEvent> readEvents = new HashMap<String, ReadEvent>();

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
		end.setIdentifier(622);
		VersionIterator iterator;
		ProgressMonitorDialog progressDialog = null;
		try {

			progressDialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
			progressDialog.open();
			progressDialog.getProgressMonitor().beginTask("Exporting notifications", IProgressMonitor.UNKNOWN);

			iterator = new VersionIterator(session, pid, step, start, end, false, true, true);

			FileWriter notificationsFileWriter = null;
			DirectoryDialog dialog = new DirectoryDialog(Display.getCurrent().getActiveShell(), SWT.SINGLE);
			String path = dialog.open();
			if (path == null) {
				progressDialog.close();
				return null;
			}

			notificationsFileWriter = new FileWriter(path + "/notifications.csv");
			FileWriter eventsFileWriter = new FileWriter(path + "/allReadEvents.csv");
			FileWriter modifierFileWriter = new FileWriter(path + "/modifierEvents.csv");
			FileWriter creatorFileWriter = new FileWriter(path + "/creatorEvents.csv");
			BufferedWriter notificationsWriter = new BufferedWriter(notificationsFileWriter);
			BufferedWriter readEventsWriter = new BufferedWriter(eventsFileWriter);
			BufferedWriter modifierReadEventsWriter = new BufferedWriter(modifierFileWriter);
			BufferedWriter creatorReadEventsWriter = new BufferedWriter(creatorFileWriter);

			// HEADERS
			// //////////////////
			notificationsWriter.write("Version,");
			notificationsWriter.write("NotificationId,");
			notificationsWriter.write("Provider,");
			notificationsWriter.write("Message,");
			notificationsWriter.write("User,");
			notificationsWriter.write("Date,");
			notificationsWriter.write("ME Id,");
			notificationsWriter.write("ME Name,");
			notificationsWriter.write("ME Class");
			notificationsWriter.write("\n");
			// //////////////////
			EList<EStructuralFeature> readEventFeaturesList = EventsPackage.eINSTANCE.getReadEvent()
				.getEAllStructuralFeatures();
			readEventsWriter.write("User,");
			for (EStructuralFeature feature : readEventFeaturesList) {
				readEventsWriter.write(feature.getName() + ",");
			}
			readEventsWriter.write("\n");
			// //////////////////
			modifierReadEventsWriter.write("User,");
			for (EStructuralFeature feature : readEventFeaturesList) {
				modifierReadEventsWriter.write(feature.getName() + ",");
			}
			modifierReadEventsWriter.write("\n");
			// //////////////////
			creatorReadEventsWriter.write("User,");
			for (EStructuralFeature feature : readEventFeaturesList) {
				creatorReadEventsWriter.write(feature.getName() + ",");
			}
			creatorReadEventsWriter.write("\n");
			// //////////////////

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			EList<User> userList = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace()
				.getProject().getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(),
					new BasicEList<User>());
			// String[] users = { "kaserf", "pfaehlem" };

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

					for (User user : userList) {

						String userString = user.getName();

						EList<ChangePackage> changePackages = analysisData.getChangePackages();

						ChangePackageVisualizationHelper visualizationHelper = new ChangePackageVisualizationHelper(
							changePackages, projectSpace.getProject());

						// update the list of modifies elements for the modifier provider.
						updateModifiedElements(projectSpace, modifierProvider, userString, changePackages,
							visualizationHelper);

						List<ESNotification> notifications = generator.generateNotifications(changePackages,
							userString, projectSpace, false);
						for (ESNotification n : notifications) {
							notificationsWriter.write(analysisData.getPrimaryVersionSpec().getIdentifier() + "");
							notificationsWriter.write(",");
							notificationsWriter.write(n.getIdentifier());
							notificationsWriter.write(",");
							notificationsWriter.write(n.getSender());
							notificationsWriter.write(",");
							notificationsWriter.write(n.getMessage().replaceAll("\n", " "));
							notificationsWriter.write(",");
							notificationsWriter.write(userString);
							notificationsWriter.write(",");
							final Date creationDate = n.getCreationDate();
							if (creationDate != null) {
								notificationsWriter.write(dateFormat.format(creationDate));
							} else {
								notificationsWriter.write("null");
							}
							notificationsWriter.write(",");
							final ModelElementId modelElementId = n.getRelatedModelElements().get(0);
							if (modelElementId != null) {
								ModelElement modelElement = projectSpace.getProject().getModelElement(modelElementId);
								notificationsWriter.write(modelElementId.getId());
								notificationsWriter.write(",");
								if (modelElement == null) {
									notificationsWriter.write("deleted");
									notificationsWriter.write(",");
									notificationsWriter.write("deleted");
								} else {
									notificationsWriter.write(modelElement.getName() + "");
									notificationsWriter.write(",");
									notificationsWriter.write(modelElement.eClass().getName());
								}
							} else {
								notificationsWriter.write(",,");
							}
							notificationsWriter.write("\n");
						}

						for (ChangePackage cp : changePackages) {
							if (cp.getLogMessage() != null && cp.getLogMessage().getAuthor() != null
								&& cp.getLogMessage().getAuthor().equals(userString)) {
								for (Event event : cp.getEvents()) {
									if (event instanceof ReadEvent) {
										ReadEvent readEvent = (ReadEvent) event;
										readEvents.put(userString, readEvent);
										readEventsWriter.write(userString + ",");
										for (EStructuralFeature f : readEventFeaturesList) {
											final Object featureData = readEvent.eGet(f);
											String stringValue = featureData+"";
											if (featureData instanceof Date) {
												stringValue = dateFormat.format((Date) featureData);
											}
											readEventsWriter.write(stringValue + ",");
										}
										readEventsWriter.write("\n");

										ModelElementId mid = readEvent.getModelElement();
										ModelElement modelElement = visualizationHelper.getModelElement(mid);
										
										if (modelElement!=null && modelElement.getCreator()!=null && modelElement.getCreator().equals(userString)) {
											creatorReadEventsWriter.write(userString + ",");
											for (EStructuralFeature f : readEventFeaturesList) {
												final Object featureData = readEvent.eGet(f);
												String stringValue = featureData+"";
												if (featureData instanceof Date) {
													stringValue = dateFormat.format((Date) featureData);
												}
												creatorReadEventsWriter.write(stringValue + ",");
											}
											creatorReadEventsWriter.write("\n");
										}
										if (modifierProvider.getWatchList().contains(mid)) {
											if(modelElement!=null && modelElement.getCreator()!=null && modelElement.getCreator().equals(userString)){
												continue;
											}
											modifierReadEventsWriter.write(userString + ",");
											for (EStructuralFeature f : readEventFeaturesList) {
												final Object featureData = readEvent.eGet(f);
												String stringValue = featureData+"";
												if (featureData instanceof Date) {
													stringValue = dateFormat.format((Date) featureData);
												}
												modifierReadEventsWriter.write(stringValue + ",");
											}
											modifierReadEventsWriter.write("\n");

										}
									}
								}
							}
						}

					}
					// BEGIN SUPRESS CATCH EXCEPTION
				} catch (RuntimeException e) {
					e.printStackTrace();
					// END SUPRESS CATCH EXCEPTION
				} finally {
					notificationsWriter.flush();
					readEventsWriter.flush();
				}
			}
			notificationsWriter.close();
			readEventsWriter.close();
		} catch (IteratorException e2) {
			e2.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		progressDialog.close();

		return null;
	}

	private void updateModifiedElements(ProjectSpace projectSpace, ModifierNotificationProvider modifierProvider,
		String user, EList<ChangePackage> changePackages, ChangePackageVisualizationHelper visualizationHelper) {

		for (ChangePackage cp : changePackages) {
			if (cp.getLogMessage().getAuthor() != null && cp.getLogMessage().getAuthor().equals(user)) {
				Set<EObject> allModelElements = visualizationHelper.getAllModelElements(cp);
				for (EObject eObject : allModelElements) {
					if (eObject instanceof ModelElement) {
						ModelElement modelElement = (ModelElement) eObject;
						if (modelElement.getCreator() != null && modelElement.getCreator().equals(user)) {
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
