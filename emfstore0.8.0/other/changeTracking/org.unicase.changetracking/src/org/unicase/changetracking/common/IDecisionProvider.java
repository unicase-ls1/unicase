package org.unicase.changetracking.common;

import org.eclipse.emf.ecore.EObject;
import org.unicase.changetracking.exceptions.CancelledByUserException;
import org.unicase.model.UnicaseModelElement;

public interface IDecisionProvider {
	
	public class PlacementAndNameDecision{
		private String desiredName;
		private EObject placeInto;
		private UnicaseModelElement elementToPlace;
		
		public PlacementAndNameDecision(UnicaseModelElement elementToPlace, String desiredName,
				EObject placeInto) {
			super();
			this.elementToPlace = elementToPlace;
			this.desiredName = desiredName;
			this.placeInto = placeInto;
		}
		
		public void executeDecision(){
			elementToPlace.setName(desiredName);
			ChangeTrackingUtil.putInto(elementToPlace, placeInto);
		}

		public EObject getDestination() {
			return placeInto;
		}
		
		
	}
	
	/**
	 * Decides where to put a newly created model element and which name to give it.
	 * Returns a decision object which provides a method to execute the decision, hence
	 * placing and renaming the model element appropriately.
	 * 
	 * @param elementToPlace
	 * @param defaultName
	 * @return
	 * @throws CancelledByUserException if the use decides to cancel the process
	 */
	public PlacementAndNameDecision decideModelElementPlacementAndName(UnicaseModelElement elementToPlace, String defaultName) throws CancelledByUserException;

	/**
	 * Decides whether to create a repository location in a unicase project.
	 * Should be called when no appropriate location was found.
	 * @return true if the user whishes to create a unicase project, false otherwise
	 * @throws CancelledByUserException if the user decides to cancel the process
	 */
	public boolean decideCreateRepoLocation() throws CancelledByUserException;

	public boolean decideUpdateFromRemote();

}
