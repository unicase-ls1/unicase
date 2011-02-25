package org.unicase.findReference;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EReference;
import org.unicase.model.ModelElement;
import org.unicase.model.organization.User;

public interface LinkFinder {
	public List<ModelElement> getRanking(ModelElement source, EReference reference, Set<ModelElement> possibilities, User user);
}
