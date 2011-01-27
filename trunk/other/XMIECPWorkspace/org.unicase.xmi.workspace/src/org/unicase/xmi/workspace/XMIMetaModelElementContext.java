package org.unicase.xmi.workspace;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.unicase.ecp.model.MetaModelElementContext;
import org.unicase.util.UnicaseUtil;

public class XMIMetaModelElementContext extends MetaModelElementContext {
	
	/**
	 * Project specific model
	 */
	private List<String> model;

	/**
	 * Context of the project containing related model
	 * @param project
	 */
	public XMIMetaModelElementContext() {
		this.model = new ArrayList<String>();
	}
	
	@Override
	public boolean isAssociationClassElement(EClass eClazz) {
		return false; // CAUTION: this feature is not supported by this plugin!
	}
	
	@Override
	public Set<EClass> getAllModelElementEClassesImpl() {
		//TODO filter all classes for the registered ones.
		Set<EClass> result = new HashSet<EClass>();
		
		Set<EClass> allModels = UnicaseUtil.getAllModelElementEClasses();
		Iterator<EClass> iterator = allModels.iterator();
		
		while(iterator.hasNext()) {
			EClass next = iterator.next();
			
			if(this.model.contains(next.getEPackage().getNsPrefix())) {
				result.add(next);
			}
		}
		
		// if there is no package registered, just return all packages
		if(result.size() == 0) {
			return UnicaseUtil.getAllModelElementEClasses();
		}
		return result;
	}

	@Override
	public boolean isNonDomainElement(EClass eClass) {
		return false; // CAUTION: this feature is not supported by this plugin!
	}
	
	/**
	 * Adds a model to the model context of the project.
	 * @param model URI of the model
	 */
	public void addModel(String model) {
		if(!this.model.contains(model)) {
			this.model.add(model);
		}
	}
	
	/**
	 * Removes a model from the model context of the project.
	 * @param model URI of the model
	 */
	public void removeModel(String model) {
		this.model.remove(model);
	}
	
	/**
	 * Returns a list of all models registered in this project.
	 * @return List of all models as strings.
	 */
	public List<String> getModels() {
		List<String> result = new ArrayList<String>();
		result.addAll(this.model);
		return result;
	}
	
	/**
	 * Removes all models from context.
	 */
	public void clearModels() {
		this.model.clear();
	}
}
