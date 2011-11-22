package org.unicase.scrm.unicase.dropadapters;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.ui.unicasecommon.dnd.dropadapters.UCDropAdapter;

import scrm.requirements.Requirement;
import scrm.requirements.RequirementsPackage;

public class RequirementDropAdapter extends UCDropAdapter {
	
	@Override
	public void drop(DropTargetEvent event, EObject target, List<EObject> source) {
		for (EObject eObject : source) {
			if(eObject instanceof Requirement) {
				((Requirement) target).getRefinements().add((Requirement) eObject);
			}
		}
	}

	
	@Override
	public EClass isDropAdapterfor() {
		return RequirementsPackage.eINSTANCE.getRequirement();
	}

}
