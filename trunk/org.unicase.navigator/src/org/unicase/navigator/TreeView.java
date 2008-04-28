package org.unicase.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.navigator.CommonNavigator;
import org.unicase.model.impl.ModelFactoryImpl;
import org.unicase.model.impl.ProjectImpl;

public class TreeView extends CommonNavigator {

	@Override
	protected IAdaptable getInitialInput() {

		return (ProjectImpl)ModelFactoryImpl.eINSTANCE.createDummyProject();
		

	}

}
