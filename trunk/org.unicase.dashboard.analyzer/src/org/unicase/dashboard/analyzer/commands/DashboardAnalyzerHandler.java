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
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.analyzer.ProjectVersionIterator;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
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

		int start = 1;
		int end = 10;
		int step = 1;

		ProjectVersionIterator iterator = new ProjectVersionIterator(session, projectSpace.getProjectId(), step, start,
			end, "forward");
		FileWriter fileWriter = null;
		try {
			FileDialog dialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.SAVE);
			String path = dialog.open();
			if (path == null) {
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
			writer.write("ModelElements");
			writer.write("\n\n");

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String[] users = { "shterevg", "super" };
			while (iterator.hasNext()) {
				try {
					ProjectAnalysisData analysisData = iterator.next();
					// System.out.println("Writing revision "+analysisData.getPrimaryVersionSpec().getIdentifier());
					for (String user : users) {
						List<ESNotification> notifications = NotificationGenerator.getInstance().generateNotifications(
							analysisData.getChangePackages(), user, projectSpace);
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
							writer.write(dateFormat.format(n.getCreationDate()));
							writer.write(",");
							for (ModelElementId mid : n.getRelatedModelElements()) {
								writer.write("{");
								writer.write(mid.getId());
								writer.write("|");
								ModelElement modelElement = projectSpace.getProject().getModelElement(mid);
								if (modelElement == null) {
									writer.write("deleted");
								} else {
									writer.write(modelElement.getName());
									writer.write("|");
									writer.write(modelElement.eClass().getName());
								}
								writer.write("}");
							}
							writer.write("\n\n");
						}
					}
				} catch (Exception e) {
					System.out.println(e);
					//
				} finally {
					writer.flush();
				}
			}
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return null;
	}

}
