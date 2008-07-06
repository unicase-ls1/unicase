package org.unicase.model.task.util;

import java.util.ArrayList;

import org.unicase.model.ModelElement;


public class OpeningLinkTaxonomy {

	/**
	 * Get all openers of a modelelement. Includes Subelements.
	 * 
	 * @param me
	 *            the Modelelement
	 * @return a list of modelelements, the openers
	 */
	public ArrayList<ModelElement> getOpeneners(ModelElement me) {
		ArrayList<ModelElement> openers = new ArrayList<ModelElement>();
		for(ModelElement annotation: me.getAnnotations()){
			openers.add(annotation);
		}
		return openers;
	}

}
