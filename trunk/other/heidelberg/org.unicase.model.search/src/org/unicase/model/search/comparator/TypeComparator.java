package org.unicase.model.search.comparator;

import java.util.Comparator;

import org.eclipse.emf.ecore.EObject;
import org.unicase.model.UnicaseModelElement;

public class TypeComparator implements Comparator<EObject> {

	@Override
	public int compare(EObject o1, EObject o2) {
		UnicaseModelElement elem1 = (UnicaseModelElement) o1;
		String type1 = elem1.eClass().getName();
		UnicaseModelElement elem2 = (UnicaseModelElement) o2;
		String type2 = elem2.eClass().getName();
		
		return type1.compareTo(type2);
	}

}
