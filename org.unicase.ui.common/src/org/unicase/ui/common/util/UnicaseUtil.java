/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */

package org.unicase.ui.common.util;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.unicase.model.ModelPackage;

/**
 * Utility class for the unicase project. 
 * @author shterev
 *
 */
public final class UnicaseUtil {
	
	private UnicaseUtil(){
		
	}
	
	/**
	 * @param clazz the input class
	 * @param ePackage the input package
	 * @return Returns all subclasses of the given input in the given package.
	 */
	public static ArrayList<EClass> getSubclasses(EClass clazz, EPackage ePackage) {
		ArrayList<EClass> ret = new ArrayList<EClass>();

		if (clazz.isAbstract() || clazz.isInterface()) {
			for (EObject eObject : ePackage.eContents()) {
				if (eObject instanceof EClass && !eObject.equals(ModelPackage.eINSTANCE.getProject())) {
					EClass eClass = (EClass) eObject;
					if (clazz.isSuperTypeOf(eClass) && !(eClass.isAbstract() || eClass.isInterface())) {
						ret.add(eClass);
					}
				}else if (eObject instanceof EPackage) {
					EPackage eSubPackage = (EPackage) eObject;
					ret.addAll(getSubclasses(clazz, eSubPackage));
				}
			}
		} else {
			ret.add(clazz);
		}
		return ret;
	}

	/**
	 * @param clazz the input super class
	 * @return Returns all subclasses of the given input.
	 * Looks in whole graph starting from the root package - i.e. ModelPackage.
	 */
	public static ArrayList<EClass> getSubclasses(EClass clazz) {
		return UnicaseUtil.getSubclasses(clazz, ModelPackage.eINSTANCE);
	}

}
