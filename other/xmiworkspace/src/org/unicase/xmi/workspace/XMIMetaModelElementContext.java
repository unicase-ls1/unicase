package org.unicase.xmi.workspace;

import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.ui.common.MetaModelElementContext;

public class XMIMetaModelElementContext extends MetaModelElementContext {

	private static MetaModelElementContext instance;
	
	@Override
	public boolean isAssociationClassElement(EClass eClazz) {
		return ModelUtil.isAssociationClassElement(eClazz);
	}
	
	@Override
	public Set<EClass> getAllModelElementEClassesImpl() {
		return ModelUtil.getAllModelElementEClasses();
	}
	
	public static MetaModelElementContext getInstance() {
		if (instance == null) {
			instance = new XMIMetaModelElementContext();
		}
		return instance;
	}

}
