/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.listener;

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
import org.unicase.leap.action.ILeapActionHandler;
import org.unicase.leap.input.ActionInput;
import org.unicase.leap.input.InputProcessor;
import org.unicase.leap.input.InputUtil;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Gesture.Type;

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
		// TODO: maybe find a better place to put this, so only necessary gestures are enabled
		controller.enableGesture(Type.TYPE_CIRCLE);
		controller.enableGesture(Type.TYPE_KEY_TAP);
		controller.enableGesture(Type.TYPE_SCREEN_TAP);
		controller.enableGesture(Type.TYPE_SWIPE);

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
			// if this fails, all specified extensions will fail
			page.addPartListener(this);
		}
	}

	@Override
	public void partActivated(IWorkbenchPartReference partRef) {
		final LeapInputListener listener = partToListener.get(partRef);
		if (listener != null) {
			listener.start();
		}
	}

	@Override
	public void partBroughtToTop(IWorkbenchPartReference partRef) {
		// TODO Maybe activate leap motion tracking

	}

	@Override
	public void partClosed(IWorkbenchPartReference partRef) {
		if (partToListener.containsKey(partRef)) {
			partToListener.remove(partRef);
		}
	}

	@Override
	public void partDeactivated(IWorkbenchPartReference partRef) {
		LeapInputListener listener = partToListener.get(partRef);
		if (listener != null) {
			listener.stop();
		}
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
					listener = parseEditorElement(extension);
					partToListener.put(partRef, listener);
				} else {
					listener = partToListener.get(partRef);
				}

				// fetch action extension elements
				IConfigurationElement[] actionExtensions = extension.getChildren("action");
				for (IConfigurationElement actionExtension : actionExtensions) {
					InputProcessor inputProcessor = parseActionElement(partRef, actionExtension);
					if (inputProcessor != null) {
						listener.addInputProcessor(inputProcessor);
					}
				}
			}
		}
	}

	/**
	 * Parses the "editor" extension element and returns an input listener for it.
	 * 
	 * @param extension the extension element to parse
	 * @return a new {@link LeapInputListener} instance as specified by the extension
	 */
	private LeapInputListener parseEditorElement(IConfigurationElement extension) {
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
		return new LeapInputListener(controller, toolsEnabled, fingersEnabled, visualizeAll);
	}

	/**
	 * Parses the "action" extension element and returns an input processor which is able to process the specified input
	 * sequence.
	 * 
	 * @param partRef the part reference the resulting input processor is defined for
	 * @param actionExtension the extension to parse
	 * @return an {@link InputProcessor} instance which is able to process the input as specified by the action
	 *         extension
	 */
	private InputProcessor parseActionElement(IWorkbenchPartReference partRef, IConfigurationElement actionExtension) {
		IConfigurationElement[] actionChildren = actionExtension.getChildren();
		if (actionChildren.length < 1) {
			// invalid extension
			return null;
		}
		try {
			ILeapActionHandler handler = (ILeapActionHandler) actionExtension.createExecutableExtension("leapHandler");

			ActionInput[] inputArray = new ActionInput[actionChildren.length];
			for (int i = 0; i < actionChildren.length; i++) {
				IConfigurationElement inputExtension = actionChildren[i];
				ActionInput input = InputUtil.convertToInput(inputExtension);
				if (input == null) {
					// invalid extension
					return null;
				} else {
					inputArray[i] = input;
				}
			}
			return new InputProcessor(partRef.getPage(), inputArray, handler);
		} catch (CoreException e) {
			return null;
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
