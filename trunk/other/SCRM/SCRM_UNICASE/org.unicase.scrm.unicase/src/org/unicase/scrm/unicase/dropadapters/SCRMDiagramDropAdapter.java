package org.unicase.scrm.unicase.dropadapters;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.ui.unicasecommon.dnd.dropadapters.UCDropAdapter;

import scrm.SCRMDiagram;
import scrm.SCRMModelElement;
import scrm.SCRMSpace;
import scrm.ScrmPackage;
import scrm.knowledge.KnowledgeSpace;
import scrm.knowledge.ScientificKnowledge;
import scrm.requirements.IRequirement;
import scrm.requirements.RequirementSpace;
import scrm.requirements.dataProcess.DataProcessSpace;
import scrm.requirements.dataProcess.Process;

public class SCRMDiagramDropAdapter extends UCDropAdapter {

	@Override
	public void drop(DropTargetEvent event, EObject target, List<EObject> source) {
		for (EObject eObject : source) {
			if (eObject instanceof SCRMModelElement) {
				SCRMModelElement modelElement = (SCRMModelElement) eObject;
				SCRMDiagram diagram = (SCRMDiagram) target;
				SCRMSpace scrmSpace = diagram.getRepresentedSpace();
				if (scrmSpace != null) {
					if(scrmSpace instanceof KnowledgeSpace) {
						if(modelElement instanceof ScientificKnowledge) {
							scrmSpace.getContainedModelElements().add(modelElement);
						}
					} else if(scrmSpace instanceof DataProcessSpace) {
						if(modelElement instanceof Process) {
							scrmSpace.getContainedModelElements().add(modelElement);
						}
					} else if(scrmSpace instanceof RequirementSpace) {
						if(modelElement instanceof IRequirement) {
							scrmSpace.getContainedModelElements().add(modelElement);
						}
					}
					diagram.getRepresentedSpace().getContainedModelElements()
							.add((SCRMModelElement) eObject);
				} else {
					diagram.getElements().add((SCRMModelElement) eObject);
				}
			}
		}
	}

	@Override
	public EClass isDropAdapterfor() {
		return ScrmPackage.eINSTANCE.getSCRMDiagram();
	}

}
