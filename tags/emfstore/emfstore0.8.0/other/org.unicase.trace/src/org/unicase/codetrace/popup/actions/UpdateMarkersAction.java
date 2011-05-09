/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.codetrace.popup.actions;

import java.util.HashMap;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.unicase.codetrace.tracer.FoundLocation;
import org.unicase.codetrace.tracer.LocationFinder;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.trace.CodeLocation;
import org.unicase.workspace.WorkspaceManager;

/**
 * This action loads all code locations from unicase project and sets the
 * markers. If there ist already a marker for a code location, old marker will
 * be deleted and the new one will be set.
 * 
 * @author snogina
 * 
 */
public class UpdateMarkersAction implements IEditorActionDelegate {

	private IEditorPart editorPart;

	private HashMap<String, IMarker> map;

	/**
	 * @see IActionDelegate#run(IAction)
	 * @param action
	 *            ignored
	 */
	public void run(IAction action) {
		IEditorInput editorInput = editorPart.getEditorInput();

		IResource resource = ResourceUtil.getResource(editorInput);

		if (map == null) {
			map = new HashMap<String, IMarker>();
		}
		getAllCodeLocationsForProject(resource);

	}

	/**
	 * This method searches for all code locations in this project.
	 */
	private void getAllCodeLocationsForProject(IResource resource) {
		// get active unicase project
		Project activeUnicaseProject = WorkspaceManager.getInstance()
				.getCurrentWorkspace().getActiveProjectSpace().getProject();

		EList<ModelElement> elements;

		elements = activeUnicaseProject.getAllModelElements();

		IMarker tmp;
		for (ModelElement element : elements) {
			if (element instanceof CodeLocation) {
				// find the code line for this code location
				LocationFinder finder = LocationFinder.getInstance();
				FoundLocation location = finder.find((CodeLocation) element);

				if (map
						.containsKey(getCodeLocationId(((CodeLocation) element)))) {
					try {
						map.get(getCodeLocationId((CodeLocation) element))
								.delete();
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
				tmp = setMarkerForCodeLocation(location,
						((CodeLocation) element), resource);
				map.put(getCodeLocationId(((CodeLocation) element)), tmp);

			}
		}
	}

	private IMarker setMarkerForCodeLocation(FoundLocation location,
			CodeLocation codeLocation, IResource resource) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put(IMarker.LINE_NUMBER, location.getLineNumber());
		map.put(IMarker.MESSAGE, location.getLineNumber());
		map.put(IMarker.LOCATION, getCodeLocationId(codeLocation));

		IMarker marker = null;

		try {
			MarkerUtilities.createMarker(location.getFile(), map,
					"org.unicase.taskmarker");
		} catch (CoreException e) {
			e.printStackTrace();
		}

		return marker;
	}

	/**
	 * Returns a unique id for a code Location.
	 * 
	 * @param codeLocation
	 *            the code location to get an id for
	 * @return the uid
	 */
	public static String getCodeLocationId(ModelElement codeLocation) {

		// Get model element id
		String meId = codeLocation.getModelElementId().getId();

		String projectId = ""; // ps.getProjectId().getId();

		// Assemble the link
		String link = "/" + projectId + "/" + meId;
		return link;
	}

	/**
	 * Does nothing. {@inheritDoc}
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

	/**
	 * Does nothing. {@inheritDoc}
	 */
	public void init(IViewPart view) {

	}

	/**
	 * Saves the active editor in. {@inheritDoc}
	 */
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		this.editorPart = targetEditor;

	}

}
