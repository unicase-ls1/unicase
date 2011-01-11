package org.unicase.xmi.workspace;

import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.unicase.ecp.model.MetaModelElementContext;
import org.unicase.util.UnicaseUtil;

public class XMIMetaModelElementContext extends MetaModelElementContext {

	private static MetaModelElementContext instance;
	
	@Override
	public boolean isAssociationClassElement(EClass eClazz) {
		/*//TODO AssociationClassElement-Issue
		return ModelUtil.isAssociationClassElement(eClazz);
		*/
		return false;
	}
	
	@Override
	public Set<EClass> getAllModelElementEClassesImpl() {
		return UnicaseUtil.getAllModelElementEClasses();
	}
	
	public static MetaModelElementContext getInstance() {
		if (instance == null) {
			instance = new XMIMetaModelElementContext();
		}
		return instance;
	}

	@Override
	public boolean isNonDomainElement(EClass eClass) {
		// ignore
		return false;
	}

}
