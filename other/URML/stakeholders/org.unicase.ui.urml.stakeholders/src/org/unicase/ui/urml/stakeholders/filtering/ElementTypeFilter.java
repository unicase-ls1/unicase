package org.unicase.ui.urml.stakeholders.filtering;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.unicase.model.urml.UrmlModelElement;

public class ElementTypeFilter {

	private EClass filterToType;
	
	public ElementTypeFilter(EClass filterToType) {
		this.filterToType = filterToType;
	}
	
	public Collection<UrmlModelElement> filter(Collection<UrmlModelElement> elements){
		Collection<UrmlModelElement> result = new ArrayList<UrmlModelElement>();
		if(filterToType == null){
			return result;
		}
		for (UrmlModelElement e : elements) {
			if (filterToType.isSuperTypeOf(e.eClass())) {
				result.add(e);
			}
		}
		return result;
	}
	
}
