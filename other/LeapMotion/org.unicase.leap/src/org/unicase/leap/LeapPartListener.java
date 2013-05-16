/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.leapmotion.leap.Controller;

/**
 * A Eclipse UI startup listener implementation as well as a listener for Workbench Part actions. On startup, this
 * listener will add itself to the corresponding workbench parts, in order to get notified about part events. Once a
 * part is opened, any <code>org.unicase.leap.leapActions</code> extension which specifies the part's ID will be
 * processed. Processing includes adding a {@link LeapInputListener} to the leap motion controller, as well as adding
 * {@link ILeapActionHandler}s to the input listener for every specified action.
 * 
 * @author mharut
 */
public class LeapPartListener implements IStartup, IPartListener2 {

	/**
	 * Extension point restriction for the screen tap gesture type.
	 */
	private static final String SCREEN_TAP_GESTURE_TYPE = "screenTap";
	/**
	 * Extension point restriction for the key tap gesture type.
	 */
	private static final String KEY_TAP_GESTURE_TYPE = "keyTap";
	/**
	 * Extension point restriction for the swipe gesture type.
	 */
	private static final String SWIPE_GESTURE_TYPE = "swipe";
	/**
	 * Extension point restriction for the circle gesture type.
	 */
	private static final String CIRCLE_GESTURE_TYPE = "circle";

	/**
	 * The leap motion controller responsible for tracking sensor data.
	 */
	private Controller controller;
	/**
	 * Mapping from workbench parts to the corresponding leap input listener. This is used to keep track of parts the
	 * leap motion controller tracks data for. Once the part is closed, the leap input listener will be stopped.
	 */
	private final Map<IWorkbenchPartReference, LeapInputListener> partToListener = new HashMap<IWorkbenchPartReference, LeapInputListener>();

	@Override
	public void earlyStartup() {
		controller = new Controller();

		IWorkbenchPage page = null;
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window != null) {
			page = window.getActivePage();
		}

		if (page == null) {
			// Look for a window and get the page of it
			IWorkbenchWindow[] windows = PlatformUI.getWorkbench().getWorkbenchWindows();
			for (int i = 0; i < windows.length; i++) {
				if (windows[i] != null) {
					window = windows[i];
					page = windows[i].getActivePage();
					if (page != null) {
						break;
					}
				}
			}
		}

		if (page != null) {
			page.addPartListener(this);
		}
	}

	@Override
	public void partActivated(IWorkbenchPartReference partRef) {
		// TODO Maybe activate leap motion tracking

	}

	@Override
	public void partBroughtToTop(IWorkbenchPartReference partRef) {
		// TODO Maybe activate leap motion tracking

	}

	@Override
	public void partClosed(IWorkbenchPartReference partRef) {
		LeapInputListener listener = partToListener.get(partRef);
		if (listener != null) {
			listener.stop();
			partToListener.remove(partRef);
		}
	}

	@Override
	public void partDeactivated(IWorkbenchPartReference partRef) {
		// TODO Maybe deactivate leap motion tracking

	}

	@Override
	public void partOpened(IWorkbenchPartReference partRef) {
		// get all extension point elements
		IConfigurationElement[] extensions = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.leap.leapActions");
		for (IConfigurationElement extension : extensions) {
			// find all extensions where the specified ID matches the part's ID
			String editorId = extension.getAttribute("id");
			if (partRef.getId().equals(editorId)) {
				LeapInputListener listener;
				// check if a listener has been created for this part already
				if (partToListener.get(partRef) == null) {
					boolean toolsEnabled = false;
					boolean fingersEnabled = false;
					boolean visualizeAll = false;
					IConfigurationElement[] mouseMoverExtensions = extension.getChildren("mouseMover");
					if (mouseMoverExtensions.length == 1) { // only one mouseMover element may exist
						IConfigurationElement mouseMoverExtension = mouseMoverExtensions[0];
						toolsEnabled = Boolean.parseBoolean(mouseMoverExtension.getAttribute("toolsEnabled"));
						fingersEnabled = Boolean.parseBoolean(mouseMoverExtension.getAttribute("fingersEnabled"));
						visualizeAll = Boolean.parseBoolean(mouseMoverExtension.getAttribute("visualizeAll"));
					}
					listener = new LeapInputListener(controller, toolsEnabled, fingersEnabled, visualizeAll);
					listener.start();
				} else {
					listener = partToListener.get(partRef);
				}

				// fetch action extension elements
				IConfigurationElement[] actionExtensions = extension.getChildren("action");
				if (actionExtensions.length > 0) {
					for (IConfigurationElement actionExtension : actionExtensions) {
						try {
							// try to create leap action handlers and to add them to the input listener
							ILeapActionHandler handler = (ILeapActionHandler) actionExtension
								.createExecutableExtension("leapHandler");
							String gestureType = actionExtension.getAttribute("gestureType");
							if (SCREEN_TAP_GESTURE_TYPE.equals(gestureType)) {
								listener.addScreenTapHandler(handler);
							} else if (KEY_TAP_GESTURE_TYPE.equals(gestureType)) {
								listener.addKeyTapHandler(handler);
							} else if (SWIPE_GESTURE_TYPE.equals(gestureType)) {
								listener.addSwipeHandler(handler);
							} else if (CIRCLE_GESTURE_TYPE.equals(gestureType)) {
								listener.addCircleHandler(handler);
							}
						} catch (CoreException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	@Override
	public void partHidden(IWorkbenchPartReference partRef) {
		// TODO Maybe deactivate leap motion tracking
	}

	@Override
	public void partVisible(IWorkbenchPartReference partRef) {
		// TODO Maybe activate leap motion tracking
	}

	@Override
	public void partInputChanged(IWorkbenchPartReference partRef) {
		// do nothing...
	}

}
