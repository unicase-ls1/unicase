/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.model.util;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.emfstore.client.model.Activator;
import org.eclipse.emf.emfstore.client.model.Configuration;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.observers.ExceptionObserver;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.util.FileUtil;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.events.CheckoutEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.EventsFactory;
import org.eclipse.emf.emfstore.server.model.versioning.events.PluginFocusEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.ReadEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.TraceEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.UpdateEvent;

/**
 * Workspace utility class.
 * 
 * @author koegel
 */
public final class WorkspaceUtil {

	/**
	 * Private constructor.
	 */
	private WorkspaceUtil() {
		// nothing to do
	}

	/**
	 * Log an exception to the error log.
	 * 
	 * @param message the message
	 * @param e the exception
	 */
	public static void logException(String message, Exception e) {
		log(message, e, IStatus.ERROR);
	}

	/**
	 * Log a warning to the error log.
	 * 
	 * @param message the message
	 * @param e the exception
	 */
	public static void logWarning(String message, Exception e) {
		log(message, e, IStatus.WARNING);
	}

	/**
	 * Log a warning to the error log.
	 * 
	 * @param message the message
	 * @param exception the exception or null f not applicable
	 * @param statusInt the status constant as defined in {@link IStatus}
	 */
	public static void log(String message, Exception exception, int statusInt) {
		Activator activator = Activator.getDefault();
		Status status = new Status(statusInt, activator.getBundle().getSymbolicName(), statusInt, message, exception);
		activator.getLog().log(status);
	}

	/**
	 * Log a checkout event to the given projectSpace.
	 * 
	 * @param projectSpace the project space
	 * @param baseVersion the base version that was checked out
	 */
	public static void logCheckout(ProjectSpace projectSpace, PrimaryVersionSpec baseVersion) {
		CheckoutEvent checkoutEvent = EventsFactory.eINSTANCE.createCheckoutEvent();
		checkoutEvent.setBaseVersion(ModelUtil.clone(baseVersion));
		checkoutEvent.setTimestamp(new Date());
		projectSpace.addEvent(checkoutEvent);
	}

	/**
	 * Log a update event to the given projectSpace.
	 * 
	 * @param projectSpace the project space
	 * @param baseVersion the base version of the project space
	 * @param targetVersion the target version to update to
	 */
	public static void logUpdate(ProjectSpace projectSpace, PrimaryVersionSpec baseVersion,
		PrimaryVersionSpec targetVersion) {
		UpdateEvent updateEvent = EventsFactory.eINSTANCE.createUpdateEvent();
		updateEvent.setBaseVersion(ModelUtil.clone(baseVersion));
		updateEvent.setTargetVersion(ModelUtil.clone(targetVersion));
		updateEvent.setTimestamp(new Date());
		projectSpace.addEvent(updateEvent);
	}

	/**
	 * Log a read event to the given projectSpace.
	 * 
	 * @param projectSpace the project space
	 * @param modelElement the model element that is read
	 * @param sourceView the view the read originates
	 * @param readView the view the model element is shown in
	 */
	public static void logReadEvent(ProjectSpace projectSpace, ModelElementId modelElement, String sourceView,
		String readView) {
		ReadEvent readEvent = EventsFactory.eINSTANCE.createReadEvent();
		readEvent.setModelElement(modelElement);
		readEvent.setReadView(readView);
		readEvent.setSourceView(sourceView);
		readEvent.setTimestamp(new Date());
		if (projectSpace == null) {
			logWarning("Read event could not be logged since given project space was null", new NullPointerException());
			return;
		}
		projectSpace.addEvent(readEvent);
	}

	/**
	 * Log a trace event to the given projectSpace.
	 * 
	 * @param projectSpace the project space
	 * @param sourceElement the source element of the trace
	 * @param targetElement the target event of the trace
	 * @param featureName the feature reference which was traced.
	 */
	public static void logTraceEvent(ProjectSpace projectSpace, ModelElementId sourceElement,
		ModelElementId targetElement, String featureName) {
		TraceEvent traceEvent = EventsFactory.eINSTANCE.createTraceEvent();
		traceEvent.setSourceElement(sourceElement);
		traceEvent.setTargetElement(targetElement);
		traceEvent.setTimestamp(new Date());
		traceEvent.setFeatureName(featureName);
		projectSpace.addEvent(traceEvent);
	}

	/**
	 * Log a focus event for the view with the given ID.
	 * 
	 * @param viewId the ID of the view
	 */
	public static void logFocusEvent(String viewId) {
		final PluginFocusEvent pluginFocusEvent = EventsFactory.eINSTANCE.createPluginFocusEvent();
		pluginFocusEvent.setPluginId(viewId);
		pluginFocusEvent.setStartDate(Calendar.getInstance().getTime());
		final ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace()
			.getActiveProjectSpace();
		if (activeProjectSpace != null) {
			// TODO: ChainSaw: check use of EMFStoreCommand here
			new EMFStoreCommand() {

				@Override
				protected void doRun() {
					activeProjectSpace.addEvent(pluginFocusEvent);
				}
			};
		}
	}

	/**
	 * Clean a formatted text from the list formatting.
	 * 
	 * @param text the text which shall be cleaned
	 * @return a string only containing the plain text
	 */
	public static String cleanFormatedText(String text) {
		if (text == null) {
			return "";
		}
		text = text.replaceAll("\n", "\r\n");
		text = text.replaceAll("<br>", "\r\n");
		text = text.replaceAll("<br\\/>", "\r\n");
		text = text.replaceAll("<li><P[^>]*>", "\r\n\u2022 ");
		text = text.replaceAll("<P[^>]*>", "\r\n");
		text = text.replaceAll("<[^<]*>", "");
		text = text.replaceAll("\\&nbsp;", " ");
		return text;
	}

	/**
	 * Opens a file with the default program used on the current computer. This is just the same as Desktop.open() of
	 * java 1.6. This should work with - Mac os X, - windows xp, - as well as the most linux distributions
	 * 
	 * @param fileUrl the url of the file which shall be opened
	 */
	public static void openFile(String fileUrl) {
		String lcOSName = System.getProperty("os.name").toLowerCase();
		String cmd = "";

		if (lcOSName.startsWith("mac os x")) {
			// fileUrl = "'" + fileUrl + "'";
			cmd = "open";
		} else if (lcOSName.startsWith("linux")) {
			// fileUrl = "'" + fileUrl + "'";
			// works for ubuntu and the most common linux systems
			cmd = "xdg-open";
		} else if (lcOSName.startsWith("windows")) {
			cmd = "not empty";
		} else {
			// bad luck .. java 1.5 ;(
			// fall through
		}

		if (!cmd.equals("")) {
			try {
				if (lcOSName.startsWith("windows")) {
					cmd = "cmd.exe /c start \"\" \"" + fileUrl + "\"";
					Runtime.getRuntime().exec(cmd);
				} else {
					Runtime.getRuntime().exec(new String[] { cmd, fileUrl });
				}
			} catch (IOException e) {
				WorkspaceUtil
					.log("could not open the file with the system dependant command: " + cmd, e, IStatus.ERROR);
			}
		}
	}

	/**
	 * Returns a EObject by Uri.
	 * 
	 * @param uri reference on object
	 * @return EObject or null
	 */
	public static EObject getEObjectByUri(URI uri) {
		if (uri == null) {
			return null;
		}
		// Should you test whether the referenced item is within the workspace?
		ResourceSet resourceSet = WorkspaceManager.getInstance().getCurrentWorkspace().eResource().getResourceSet();
		return resourceSet.getEObject(uri, false);
	}

	/**
	 * Returns ModelElement by Uri.
	 * 
	 * @param uri reference on object
	 * @return ModelElement or null
	 */
	public static EObject getModelElementByUri(URI uri) {
		EObject objectByUri = getEObjectByUri(uri);
		// if (objectByUri instanceof ModelElement) {
		return objectByUri;
		// }
	}

	/**
	 * Delete the test workspace.
	 * 
	 * @throws IOException if deletion fails
	 */
	public static void deleteTestWorkspace() throws IOException {
		boolean isTesting = Configuration.isTesting();
		Configuration.setTesting(true);
		String workspaceDirectory = Configuration.getWorkspaceDirectory();
		FileUtil.deleteFolder(new File(workspaceDirectory));
		Configuration.setTesting(isTesting);
	}

	public static void handleException(RuntimeException exception) {
		Boolean errorHandeled = WorkspaceManager.getObserverBus().notify(ExceptionObserver.class)
			.handleError(exception);
		logException("An error occured.", exception);
		if (!errorHandeled.booleanValue()) {
			throw exception;
		}
	}

	public static void handleException(String string, EmfStoreException e) {
		handleException(new RuntimeException(string, e));

	}
}
