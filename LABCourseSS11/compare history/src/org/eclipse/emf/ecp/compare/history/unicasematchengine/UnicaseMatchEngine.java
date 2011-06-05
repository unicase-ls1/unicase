package org.eclipse.emf.ecp.compare.history.unicasematchengine;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.match.engine.GenericMatchEngine;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;



public class UnicaseMatchEngine extends GenericMatchEngine {

	@Override
	protected EObject findMostSimilar(EObject eObj, List<EObject> list) throws FactoryException {
		EObject resultObject = null;
		final Iterator<EObject> it = list.iterator();
		while (it.hasNext()) {
			final EObject next = it.next();
			if (isSimilar(eObj, next)) {
				resultObject = next;
			}

		}
		return resultObject;
	}

		@Override
	protected boolean isSimilar(EObject obj1, EObject obj2) throws FactoryException {	
//		return EcoreUtil.equals(obj1.eClass().getEIDAttribute(), obj2.eClass().getEIDAttribute());
		Project proj1 = ModelUtil.getProject(obj1);
		Project proj2 = ModelUtil.getProject(obj2);
		return proj1.getModelElementId(obj1).equals(proj2.getModelElementId(obj2));
		}
}
