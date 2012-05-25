package org.unicase.scrm.unicase.dropadapters;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.ui.unicasecommon.dnd.dropadapters.UCDropAdapter;

import scrm.SCRMModelElement;
import scrm.SCRMSpace;
import scrm.ScrmPackage;
import scrm.knowledge.KnowledgeSpace;
import scrm.knowledge.ScientificKnowledge;
import scrm.requirements.IRequirement;
import scrm.requirements.RequirementSpace;
import scrm.requirements.dataProcess.DataProcessSpace;

public class SCRMSpaceDropAdapter extends UCDropAdapter {
	
	@Override
	public void drop(DropTargetEvent event, EObject target, List<EObject> source) {
		for (EObject eObject : source) {
			if(eObject instanceof SCRMModelElement) {
				((SCRMSpace) target).getContainedModelElements().add((SCRMModelElement) eObject);
			}
		}
	}
	
	@Override
	public boolean canDrop(int eventFeedback, DropTargetEvent event, List<EObject> source, EObject target,
			EObject dropee) {
		if (target instanceof KnowledgeSpace) {
			for(EObject sourceObject : source) {
				if(!(sourceObject instanceof ScientificKnowledge)) {
					return false;
				}
				return true;
			}
		} else if (target instanceof DataProcessSpace) {
			for(EObject sourceObject : source) {
				if(!(sourceObject instanceof scrm.requirements.dataProcess.Process)) {
					return false;
				}
				return true;
			}
		} else if (target instanceof RequirementSpace) {
			for(EObject sourceObject : source) {
				if(!(sourceObject instanceof IRequirement)) {
					return false;
				}
				return true;
			}
		}
		return super.canDrop(eventFeedback, event, source, target, dropee);
	}

	
	@Override
	public EClass isDropAdapterfor() {
		return ScrmPackage.eINSTANCE.getSCRMSpace();
	}

}
