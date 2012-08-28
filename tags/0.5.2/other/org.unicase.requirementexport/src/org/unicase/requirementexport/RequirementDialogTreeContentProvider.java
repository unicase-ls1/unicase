/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.requirementexport;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.unicase.metamodel.Project;
import org.unicase.model.document.LeafSection;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;

/**
 * Tree content provider for {@link ExportRequirementDialog}.
 * 
 * @author mharut
 */
public class RequirementDialogTreeContentProvider implements ITreeContentProvider {

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Workspace) {
			// root elements: all project spaces
			Workspace workspace = (Workspace) inputElement;
			return workspace.getProjectSpaces().toArray();
		}
		return new Object[0];
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getChildren(Object parentElement) {
		List<EObject> resultList = new ArrayList<EObject>();

		if (parentElement instanceof ProjectSpace) {
			Project project = ((ProjectSpace) parentElement).getProject();
			// add all leaf sections that aren't contained by other leaf sections
			for (EObject eObject : project.getAllModelElements()) {
				if (eObject instanceof LeafSection && getParent(eObject) == parentElement) {
					resultList.add(eObject);
				}
			}
		} else if (parentElement instanceof LeafSection) {
			LeafSection leafSection = (LeafSection) parentElement;
			// add all leaf sections that are contained by this and only this leaf section
			for (Iterator<EObject> it = leafSection.eAllContents(); it.hasNext();) {
				EObject eObject = it.next();
				if (eObject instanceof LeafSection && (getParent(eObject) == parentElement)) {
					resultList.add(eObject);
				}
			}
		}
		return resultList.toArray();
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getParent(Object element) {
		// only leaf sections can have parents in this dialog
		if (!(element instanceof LeafSection)) {
			return null;
		}
		// search all containers recursively for another leaf section or project space
		EObject eContainer = ((LeafSection) element).eContainer();
		while (eContainer != null) {
			if (eContainer instanceof LeafSection || eContainer instanceof ProjectSpace) {
				return eContainer;
			}
			eContainer = eContainer.eContainer();
		}
		// this shouldn't happen: a leaf section has to be contained by a project space
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasChildren(Object element) {
		// dialog only supports project spaces and leaf sections
		if (!(element instanceof ProjectSpace || element instanceof LeafSection)) {
			return false;
		}

		EObject eObject = (EObject) element;
		// search all contents for a leaf section
		for (Iterator<EObject> it = eObject.eAllContents(); it.hasNext();) {
			EObject possibleChild = it.next();
			if (possibleChild instanceof LeafSection) {
				return true;
			}
		}

		// no leaf section found
		return false;
	}

}
