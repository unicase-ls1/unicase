package org.unicase.ui.taskview;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.unicase.model.ModelPackage;

public class EClassFilterItemProvider extends FilteredItemProvider {

	private EClass itemClass;

	public EClassFilterItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
		this.itemClass = ModelPackage.eINSTANCE.getIdentifiableElement();
	}

	public EClassFilterItemProvider(AdapterFactory adapterFactory,
			EClass itemClass) {
		super(adapterFactory);
		this.itemClass = itemClass;
	}

	@Override
	protected boolean permitsObject(Object objectToTest) {
		if (objectToTest instanceof EObject) {
			return ((EObject) objectToTest).eClass().equals(itemClass);
		} else {
			return false;
		}
	}

}
