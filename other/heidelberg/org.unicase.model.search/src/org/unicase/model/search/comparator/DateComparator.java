package org.unicase.model.search.comparator;

import java.util.Comparator;

import org.eclipse.emf.ecore.EObject;
import org.unicase.metamodel.ModelElement;

public class DateComparator implements Comparator<EObject> {

	@Override
	public int compare(EObject obj1, EObject obj2) {		
		ModelElement elem1 = (ModelElement) obj1;
		ModelElement elem2 = (ModelElement) obj2;
				
		return elem1.getCreationDate().compareTo(elem2.getCreationDate());
	}

}
