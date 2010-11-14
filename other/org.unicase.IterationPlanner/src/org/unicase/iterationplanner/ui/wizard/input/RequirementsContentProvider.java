package org.unicase.iterationplanner.ui.wizard.input;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.unicase.model.requirement.FunctionalRequirement;

public class RequirementsContentProvider extends AdapterFactoryContentProvider {

	/**
	 * this is a flattened view of all requirements
	 */
	private List<FunctionalRequirement> allReqs;
	
	public RequirementsContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	
	@Override
	public Object[] getChildren(Object object) {
		ArrayList<FunctionalRequirement> result = new ArrayList<FunctionalRequirement>();
		FunctionalRequirement parent = (FunctionalRequirement) object;
		EList<FunctionalRequirement> refiningRequirements = parent.getRefiningRequirements();
		for(FunctionalRequirement fr : refiningRequirements){
			if(allReqs.contains(fr)){
				result.add(fr);
			}
		}
		return result.toArray();
	}

	@Override
	public Object[] getElements(Object object) {
		return getTopLevelReqs().toArray();
	}

	private List<FunctionalRequirement> getTopLevelReqs() {
		List<FunctionalRequirement> result = new ArrayList<FunctionalRequirement>();
		for(FunctionalRequirement fr : allReqs){
			if(fr.getRefinedRequirement() == null){
				result.add(fr);
			}
		}
		return result;
	}


	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		initAllReqs(newInput);
	}

	@SuppressWarnings("unchecked")
	private void initAllReqs(Object newInput) {
		allReqs = new ArrayList<FunctionalRequirement>();
		if(newInput == null){
			return;
		}
		List<FunctionalRequirement> frs = (List<FunctionalRequirement>) newInput;
		for(FunctionalRequirement fr : frs){
			allReqs.add(fr);
			allReqs.addAll(getRefiningReqsRecursive(fr));
		}
	}

	private List<FunctionalRequirement> getRefiningReqsRecursive(FunctionalRequirement fr) {
		List<FunctionalRequirement> result = new ArrayList<FunctionalRequirement>();
		for(FunctionalRequirement refiningFR : fr.getRefiningRequirements()){
			result.add(refiningFR);
			result.addAll(getRefiningReqsRecursive(refiningFR));
		}
		return result;
	}


	@Override
	public void dispose() {
	}
	
	public void removeReq(FunctionalRequirement req){
		allReqs.remove(req);
		allReqs.removeAll(getRefiningReqsRecursive(req));
	}
	
	public void addReq(FunctionalRequirement req){
		if(!allReqs.contains(req)){
			allReqs.add(req);
			List<FunctionalRequirement> parentsRecursive = getParentsRecursive(req);
			for(FunctionalRequirement refined : parentsRecursive) {
				if(!allReqs.contains(refined)){
					allReqs.add(refined);
				}
			}
			List<FunctionalRequirement> refiningReqsRecursive = getRefiningReqsRecursive(req);
			for(FunctionalRequirement refining : refiningReqsRecursive) {
				if(!allReqs.contains(refining)){
					allReqs.add(refining);
				}
			}
		}
	}

	private List<FunctionalRequirement> getParentsRecursive(FunctionalRequirement req) {
		List<FunctionalRequirement> parents = new ArrayList<FunctionalRequirement>();
		if(req.getRefinedRequirement() == null){
			return parents;
		}
		parents.add(req.getRefinedRequirement());
		parents.addAll(getParentsRecursive(req.getRefinedRequirement()));
		
		return parents;
	}


	public List<FunctionalRequirement> getReqs() {
		return allReqs;
		
	}

}
