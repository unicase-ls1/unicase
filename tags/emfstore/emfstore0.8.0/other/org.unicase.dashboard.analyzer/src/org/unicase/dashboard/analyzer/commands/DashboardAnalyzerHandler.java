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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
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
import org.unicase.analyzer.VersionSpecQuery;
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
import org.unicase.workspace.ui.views.changes.ChangePackageVisualizationHelper;
import org.unicase.workspace.notification.NotificationGenerator;
import org.unicase.workspace.notification.NotificationProvider;

/**
 * Exports the esnotifications that were generated/used in the dashboard.
 */
public class DashboardAnalyzerHandler extends AbstractHandler {

	private BufferedWriter modifierReadEventsWriter;
	private BufferedWriter creatorReadEventsWriter;
	private SimpleDateFormat dateFormat;
	private String delimeter;

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
		HashMap<String, ReadEvent> readEvents = new HashMap<String, ReadEvent>();
		ProjectId pid = (ProjectId) EcoreUtil.copy(projectSpace.getProjectId());
		ProgressMonitorDialog progressDialog = null;
		PrimaryVersionSpec start = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		start.setIdentifier(1);
		PrimaryVersionSpec end = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		end.setIdentifier(622);
		
		VersionSpecQuery versionSpecQuery = new VersionSpecQuery(start, end);

		try {
			VersionIterator iterator = new VersionIterator(session, pid, 1, versionSpecQuery, true, true);

			progressDialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
			progressDialog.open();
			progressDialog.getProgressMonitor().beginTask("Exporting notifications", IProgressMonitor.UNKNOWN);
			DirectoryDialog dialog = new DirectoryDialog(Display.getCurrent().getActiveShell(), SWT.SINGLE);
			String path = dialog.open();
			if (path == null) {
				progressDialog.close();
				return null;
			}
			delimeter = "§";
			FileWriter modifierFileWriter = new FileWriter(path + "/modifierEvents.csv");
			FileWriter creatorFileWriter = new FileWriter(path + "/creatorEvents.csv");
			HashMap<String, BufferedWriter> writers = new HashMap<String, BufferedWriter>();
			HashMap<String, BufferedWriter> KWwriters = new HashMap<String, BufferedWriter>();
			modifierReadEventsWriter = new BufferedWriter(modifierFileWriter);
			creatorReadEventsWriter = new BufferedWriter(creatorFileWriter);

			HashMap<String, HashMap<String,ArrayList<String>>> users = new HashMap<String,HashMap<String, ArrayList<String>>>();
			
			EList<EStructuralFeature> readEventFeaturesList = EventsPackage.eINSTANCE.getReadEvent()
				.getEAllStructuralFeatures();
			initWriter(modifierReadEventsWriter, readEventFeaturesList);
			initWriter(creatorReadEventsWriter, readEventFeaturesList);

			dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			EList<User> userList = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace()
				.getProject().getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(),
					new BasicEList<User>());
			HashMap<String, HashMap<Integer, HashMap<String, Integer>>> db = new HashMap<String, HashMap<Integer, HashMap<String, Integer>>>();

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

			final Collection<NotificationProvider> providersList = generator.getProviders();
			for (User user : userList) {

				final BufferedWriter writer = new BufferedWriter(new FileWriter(path + "/" + user.getName() + ".csv"));
				writers.put(user.getName(), writer);
				writer.write("Version");
				writer.write(delimeter);
				writer.write("Provider");
				writer.write(delimeter);
				writer.write("Message");
				writer.write(delimeter);
				writer.write("User");
				writer.write(delimeter);
				writer.write("Date");
				writer.write(delimeter);
				writer.write("ME Id");
				writer.write(delimeter);
				writer.write("ME Name");
				writer.write(delimeter);
				writer.write("ME Class");
				writer.write(delimeter);
				writer.write("ME Desc");
				writer.write("\n");

				final BufferedWriter KWwriter = new BufferedWriter(new FileWriter(path + "/" + user.getName()
					+ "_KW.csv"));
				KWwriters.put(user.getName(), KWwriter);
				KWwriter.write("KW");
				KWwriter.write(delimeter);
				for (NotificationProvider p : providersList) {
					KWwriter.write(p.getName());
					KWwriter.write(delimeter);
				}
				KWwriter.write("\n");

				HashMap<Integer, HashMap<String, Integer>> providersMap = new HashMap<Integer, HashMap<String, Integer>>();
				db.put(user.getName(), providersMap);
				
				users.put(user.getName(), new HashMap<String, ArrayList<String>>());
			}

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
							changePackages, analysisData.getProjectState());

						// update the list of modifies elements for the modifier provider.
						updateModifiedElements(projectSpace, modifierProvider, userString, changePackages,
							visualizationHelper);

						List<ESNotification> notifications = generator.generateNotifications(changePackages,
							userString, projectSpace, false);
						for (ESNotification n : notifications) {
							Date crDate = n.getCreationDate();
							if (crDate == null && changePackages.get(0).getLogMessage() != null) {
								crDate = changePackages.get(0).getLogMessage().getClientDate();
							}
							if (crDate == null) {
								crDate = new Date();
							}
							Integer kw = getKW(crDate);
							HashMap<String, Integer> kw2prov = db.get(userString).get(kw);
							if (kw2prov == null) {
								kw2prov = new HashMap<String, Integer>();
							}
							db.get(userString).put(kw, kw2prov);
							String p = n.getSender();
							Integer count = kw2prov.get(p);
							if (count == null) {
								count = new Integer(0);
//								System.out.println("Null " + userString + " " + p);
							}
							kw2prov.put(p, new Integer(count.intValue() + 1));
//							System.out.println("Writing " + userString + " " + p + " " + kw2prov.get(p).toString());

							StringBuilder output = new StringBuilder();
							
							output.append(analysisData.getPrimaryVersionSpec().getIdentifier() + "");
							output.append(delimeter);
							output.append(n.getSender());
							output.append(delimeter);
							output.append(n.getMessage().replaceAll("\n", " "));
							output.append(delimeter);
							output.append(userString);
							output.append(delimeter);

							output.append(dateFormat.format(crDate));

							output.append(delimeter);
							final ModelElementId modelElementId = n.getRelatedModelElements().get(0);
							if (modelElementId != null) {
								ModelElement modelElement = projectSpace.getProject().getModelElement(modelElementId);
								output.append(modelElementId.getId());
								output.append(delimeter);
								if (modelElement == null) {
									output.append("deleted");
									output.append(delimeter);
									output.append("deleted");
									output.append(delimeter);
									output.append("deleted");
								} else {
									output.append(modelElement.getName() + "");
									output.append(delimeter);
									output.append(modelElement.eClass().getName());
									output.append(delimeter);
									String description = modelElement.getDescription();
									if (description == null) {
										description = "";
									}
									output.append(description.replaceAll("\n", " "));
								}
							} else {
								output.append(delimeter);
								output.append(delimeter);
								output.append(delimeter);
							}
							output.append("\n");
							final String outputString = output.toString();
							writers.get(userString).write(outputString);
							
							ArrayList<String> arrayList = users.get(userString).get(n.getSender());
							if(arrayList == null) {
								arrayList = new ArrayList<String>();
								users.get(userString).put(n.getSender(),arrayList);
							}
							arrayList.add(outputString);
						}

						exportEvents(readEvents, readEventFeaturesList, dateFormat, modifierProvider, userString,
							changePackages, visualizationHelper);
					}
					// BEGIN SUPRESS CATCH EXCEPTION
				} catch (RuntimeException e) {
					e.printStackTrace();
					// END SUPRESS CATCH EXCEPTION
				} finally {
					for (BufferedWriter writer : writers.values()) {
						writer.flush();
					}
					modifierReadEventsWriter.flush();
					creatorReadEventsWriter.flush();
				}
			}
			
			Random random = new Random();
			for (User user : userList) {
				String userString = user.getName();
				final BufferedWriter writer = KWwriters.get(userString);
				HashMap<Integer, HashMap<String, Integer>> kw2provider = db.get(userString);
				for (Integer kw : kw2provider.keySet()) {
					writer.write(kw.toString());
					writer.write(delimeter);
					for (NotificationProvider p : providersList) {
						Integer value = kw2provider.get(kw).get(p.getName());
						if (value == null){
							value = new Integer(0);
						}
						writer.write(value.toString());
						writer.write(delimeter);
					}
					writer.write("\n");
					writer.flush();
				}
				
				
				BufferedWriter randomized = new BufferedWriter(new FileWriter(path + "/" + userString + "_randomized.csv"));
				HashMap<String, ArrayList<String>> userNotifications = users.get(userString);
				for(String provider : userNotifications.keySet()){
					ArrayList<String> arrayList = userNotifications.get(provider);
					Collections.shuffle(arrayList, random);
					for(int i=0; i<12; i++){
						if(arrayList.size() > i){
							randomized.write(arrayList.get(i));
						}else{
							System.out.println(userString + " does not apply ("+provider+")");
						}
					}
				}
				for (NotificationProvider p : generator.getProviders()){
					if(userNotifications.get(p.getName())==null){
						System.out.println(userString + " does not apply ("+p.getName()+")");
					}
				}
				randomized.flush();
				randomized.close();
				
				
			}
			for (BufferedWriter writer : KWwriters.values()) {
				writer.close();
			}
			for (BufferedWriter writer : writers.values()) {
				writer.close();
			}
			modifierReadEventsWriter.close();
			creatorReadEventsWriter.close();
		} catch (IteratorException e2) {
			e2.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		progressDialog.close();
		return null;
	}

	private void initWriter(BufferedWriter writer, EList<EStructuralFeature> readEventFeaturesList) throws IOException {
		writer.write("User" + delimeter);
		for (EStructuralFeature feature : readEventFeaturesList) {
			writer.write(feature.getName() + delimeter);
		}
		writer.write("\n");
	}

	private void exportEvents(HashMap<String, ReadEvent> readEvents, EList<EStructuralFeature> readEventFeaturesList,
		SimpleDateFormat dateFormat, ModifierNotificationProvider modifierProvider, String userString,
		EList<ChangePackage> changePackages, ChangePackageVisualizationHelper visualizationHelper) throws IOException {
		for (ChangePackage cp : changePackages) {
			if (cp.getLogMessage() != null && cp.getLogMessage().getAuthor() != null
				&& cp.getLogMessage().getAuthor().equals(userString)) {
				for (Event event : cp.getEvents()) {
					if (event instanceof ReadEvent) {
						ReadEvent readEvent = (ReadEvent) event;
						readEvents.put(userString, readEvent);
						ModelElementId mid = readEvent.getModelElement();
						ModelElement modelElement = visualizationHelper.getModelElement(mid);

						if (modelElement == null) {
							// cannot procede
							continue;
						}
						if (modelElement.getCreator() != null && modelElement.getCreator().equals(userString)) {
							writeReadEvent(readEventFeaturesList, dateFormat, userString, readEvent,
								creatorReadEventsWriter);
						} else if (modifierProvider.getWatchList().contains(mid)) {
							writeReadEvent(readEventFeaturesList, dateFormat, userString, readEvent,
								modifierReadEventsWriter);
						}
					}
				}
			}
		}
	}

	private void writeReadEvent(EList<EStructuralFeature> readEventFeaturesList, SimpleDateFormat dateFormat,
		String userString, ReadEvent readEvent, BufferedWriter writer) throws IOException {
		writer.write(userString + ",");
		for (EStructuralFeature f : readEventFeaturesList) {
			final Object featureData = readEvent.eGet(f);
			String stringValue = featureData + "";
			if (featureData instanceof Date) {
				stringValue = dateFormat.format((Date) featureData);
			}
			writer.write(stringValue + ",");
		}
		writer.write("\n");
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

	private Integer getKW(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		return cal.get(Calendar.WEEK_OF_YEAR);
	}
}
