/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.diagram.services;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.commands.DeleteModelElementCommand;
import org.eclipse.emf.ecp.common.model.ECPWorkspaceManager;
import org.eclipse.emf.ecp.common.utilities.ActionHelper;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.unicase.papyrus.UMLModel;

/**
 * Page manager for Papyrus UML diagrams in Unicase.
 * 
 * @author mharut
 */
public class UnicasePageManager implements IPageMngr {

	private Project project;

	/**
	 * Creates a new page manager for a certain {@link Project}.
	 * 
	 * @param project the project to create the page manager for
	 */
	public UnicasePageManager(Project project) {
		this.project = project;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addPage(Object pageIdentifier) {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 */
	public void removePage(Object pageIdentifier) {
		EObject elementToDelete = null;
		if (pageIdentifier instanceof Diagram) {
			// delete the corresponding UMLModel instead of only the diagram
			elementToDelete = ((Diagram) pageIdentifier).getElement();
		} else if (pageIdentifier instanceof EObject) {
			elementToDelete = (EObject) pageIdentifier;
			// EObject is not contained by project -> can't be deleted
			if (!project.containsInstance(elementToDelete)) {
				return;
			}
		}
		if (elementToDelete == null) {
			return;
		}
		// delete the element from the project
		new DeleteModelElementCommand(elementToDelete, ECPWorkspaceManager.getECPProject(elementToDelete)).run();
	}

	/**
	 * {@inheritDoc}
	 */
	public void closePage(Object pageIdentifier) {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 */
	public void closeAllOpenedPages() {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 */
	public void closeOtherPages(Object pageIdentifier) {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 */
	public void openPage(Object pageIdentifier) {
		if (pageIdentifier instanceof Diagram) {
			ActionHelper.openModelElement(((Diagram) pageIdentifier).getElement(), "");
		} else if (pageIdentifier instanceof EObject) {
			EObject eObject = (EObject) pageIdentifier;
			if (project.containsInstance(eObject)) {
				ActionHelper.openModelElement(eObject, "");
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Object> allPages() {
		final List<Object> result = new LinkedList<Object>();
		for (EObject me : project.getAllModelElements()) {
			if (me instanceof UMLModel) {
				final UMLModel model = (UMLModel) me;
				Diagram diagram = model.getGmfDiagram();
				if (diagram != null) {
					result.add(diagram);
				}

			}

		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isOpen(Object pageIdentifier) {
		return false;
	}

}
