/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.common;

import org.eclipse.emf.ecore.EObject;
import org.unicase.changetracking.exceptions.CancelledByUserException;
import org.unicase.model.UnicaseModelElement;

/**
 * A decision provider provides methods to decide certain decisions which occur
 * during the changetracking workflow. An implementation usually asks the user
 * for the decision. This class decouples the UI from the logic code, since the
 * business logic only uses this interface. The UI plug-in provides an
 * implementation for it.
 * 
 * @author jfinis
 * 
 */
public interface IDecisionProvider {

	/**
	 * The result of a name and placement decision.
	 * 
	 * This decision occurs when a new model element is to be inserted in a
	 * unicase project. Its place in the project and the disred name have to be
	 * chosen.
	 * 
	 * @author jfinis
	 * 
	 */
	public class PlacementAndNameDecision {
		private String desiredName;
		private EObject placeInto;
		private UnicaseModelElement elementToPlace;

		/**
		 * Default constructor.
		 * 
		 * @param elementToPlace the model element to be placed.
		 * @param desiredName the desired name for the element.
		 * @param placeInto target model element into which to put the new model
		 *            element.
		 */
		public PlacementAndNameDecision(UnicaseModelElement elementToPlace, String desiredName, EObject placeInto) {
			super();
			this.elementToPlace = elementToPlace;
			this.desiredName = desiredName;
			this.placeInto = placeInto;
		}

		/**
		 * Executes the decision. This means that the model element is put into
		 * the project at the desired location and its name is set.
		 * 
		 * Since this method alters the project model, it must be executed in a
		 * unicase command.
		 */
		public void executeDecision() {
			elementToPlace.setName(desiredName);
			ChangeTrackingUtil.putInto(elementToPlace, placeInto);
		}

		/**
		 * Retrieves the target object in which the new model element is to be
		 * put.
		 * 
		 * @return target object.
		 */
		public EObject getDestination() {
			return placeInto;
		}

	}

	/**
	 * Decides where to put a newly created model element and which name to give
	 * it. Returns a decision object which provides a method to execute the
	 * decision, hence placing and renaming the model element appropriately.
	 * 
	 * @param elementToPlace element to be placed
	 * @param defaultName default name for the model element
	 * @return decision the decision
	 * @throws CancelledByUserException if the use decides to cancel the process
	 */
	PlacementAndNameDecision decideModelElementPlacementAndName(UnicaseModelElement elementToPlace, String defaultName) throws CancelledByUserException;

	/**
	 * Decides whether to create a repository location in a unicase project.
	 * Should be called when no appropriate location was found.
	 * 
	 * @return true if the user whishes to create a unicase project, false
	 *         otherwise
	 * @throws CancelledByUserException if the user decides to cancel the
	 *             process
	 * @exception CancelledByUserException if the user decided to cancel the
	 *                process.
	 */
	boolean decideCreateRepoLocation() throws CancelledByUserException;

	/**
	 * Decides if an update from the remote repository should be conducted.
	 * 
	 * @return whether the update should be conducted.
	 */
	boolean decideUpdateFromRemote();

}
