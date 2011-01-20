package org.unicase.xmi.workspace;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.unicase.ecp.model.MetaModelElementContext;
import org.unicase.util.UnicaseUtil;
import org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject;

public class XMIMetaModelElementContext extends MetaModelElementContext {
	
	/**
	 * The Project for which this content is for
	 */
	private final XMIECPFileProject project;
	
	/**
	 * Project specific model
	 */
	private String model;

	/**
	 * Context of the project containing related model
	 * @param project
	 */
	public XMIMetaModelElementContext (XMIECPFileProject project){
		this.project = project;
	}
	
	@Override
	public boolean isAssociationClassElement(EClass eClazz) {
		return false; // CAUTION: this feature is not supported by this plugin!
	}
	
	@Override
	public Set<EClass> getAllModelElementEClassesImpl() {
		//TODO filter all classes for the registered ones.
		Set<EClass> allModels = UnicaseUtil.getAllModelElementEClasses();
		Iterator<EClass> iterator = allModels.iterator();
		
		while(iterator.hasNext()) {
			EClass next = iterator.next();
//			System.out.println(next.eClass().getEPackage().toString() + " --> " + next.getName().toString());
		}
		return UnicaseUtil.getAllModelElementEClasses();
	}

	@Override
	public boolean isNonDomainElement(EClass eClass) {
		return false; // CAUTION: this feature is not supported by this plugin!
	}
	
	/**
	 * Sets the model of the related project
	 * @param model
	 */
	public void setModel(String model){
		this.model = model;
	}
}
