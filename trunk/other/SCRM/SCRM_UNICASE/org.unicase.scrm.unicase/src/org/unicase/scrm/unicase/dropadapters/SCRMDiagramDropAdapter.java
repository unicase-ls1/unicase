package org.unicase.scrm.unicase.dropadapters;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.ui.unicasecommon.dnd.dropadapters.UCDropAdapter;

import scrm.SCRMDiagram;
import scrm.SCRMModelElement;
import scrm.ScrmPackage;

public class SCRMDiagramDropAdapter extends UCDropAdapter {
	
	@Override
	public void drop(DropTargetEvent event, EObject target, List<EObject> source) {
		for (EObject eObject : source) {
			if(eObject instanceof SCRMModelElement) {
				((SCRMDiagram) target).getElements().add((SCRMModelElement) eObject);
			}
		}
	}

	
	@Override
	public EClass isDropAdapterfor() {
		return ScrmPackage.eINSTANCE.getSCRMDiagram();
	}

}
