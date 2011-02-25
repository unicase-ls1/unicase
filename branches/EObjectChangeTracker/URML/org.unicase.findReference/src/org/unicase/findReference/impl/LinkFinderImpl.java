package org.unicase.findReference.impl;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EReference;
import org.unicase.findReference.LinkFinder;
import org.unicase.model.ModelElement;
import org.unicase.model.organization.User;

public class LinkFinderImpl implements LinkFinder {

	public List<ModelElement> getRanking(ModelElement source,
			EReference reference, Set<ModelElement> possibilities, User user) {
		
		return null;
	}

}
