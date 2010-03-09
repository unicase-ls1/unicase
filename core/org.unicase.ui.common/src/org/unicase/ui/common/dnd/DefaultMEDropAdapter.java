package org.unicase.ui.common.dnd;

import org.eclipse.emf.ecore.EClass;
import org.unicase.metamodel.MetamodelPackage;

public class DefaultMEDropAdapter extends MEDropAdapter {

	@Override
	public EClass isDropAdapterfor() {
		
		return MetamodelPackage.eINSTANCE.getModelElement();
	}

}
