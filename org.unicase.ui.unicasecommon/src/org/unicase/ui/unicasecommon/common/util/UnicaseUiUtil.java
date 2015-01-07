/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.util;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecp.common.MEClassLabelProvider;
import org.eclipse.emf.emfstore.common.model.NonDomainElement;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.model.ModelPackage;

/**
 * Utility class for the unicase project.
 * 
 * @author shterev
 * @author hodaie
 * @author denglerm
 */
public final class UnicaseUiUtil {

	private UnicaseUiUtil() {
		// do nothing
	}

	/**
	 * Shows a list of model element types.
	 * 
	 * @param shell shell
	 * @param showAbstractTypes if also abstract types are shown
	 * @param showNonDomain If non domain elements are shown
	 * @return selected model element type
	 */
	public static EClass showMETypeSelectionDialog(Shell shell, boolean showAbstractTypes, boolean showNonDomain) {
		ElementListSelectionDialog dlg = new ElementListSelectionDialog(shell.getShell(), new MEClassLabelProvider());
		Set<EClass> eClazz;
		if (showAbstractTypes) {
			eClazz = ModelUtil.getAllMETypes(ModelPackage.eINSTANCE);
		} else {
			eClazz = ModelUtil.getNonAbstractMETypes(ModelPackage.eINSTANCE);
		}
		if (!showNonDomain) {
			Set<EClass> filteredEClass = new HashSet<EClass>();
			// Filter out non domain
			for (EClass eClass : eClazz) {
				if (!(NonDomainElement.class.isAssignableFrom(eClass.getInstanceClass()))) {
					filteredEClass.add(eClass);
				}
			}

			eClazz = filteredEClass;
		}
		dlg.setElements(eClazz.toArray());
		dlg.setTitle("Select model element type");
		dlg.setBlockOnOpen(true);
		dlg.setMultipleSelection(false);
		EClass result = null;
		if (dlg.open() == Window.OK) {
			result = (EClass) dlg.getResult()[0];
		}
		return result;
	}

	/**
	 * Retrieve all EPackages that are model packages for unicase starting with the unicase model prefix as defined in
	 * {@link MetamodelPackage}.
	 * 
	 * @return a set of EPackages
	 */
	public static Set<EPackage> getAllModelPackages() {
		Set<EPackage> result = new HashSet<EPackage>();
		Registry registry = EPackage.Registry.INSTANCE;

		for (Entry<String, Object> entry : registry.entrySet()) {
			if (entry.getKey().startsWith(ModelPackage.eNS_URI)) {
				try {
					EPackage model = EPackage.Registry.INSTANCE.getEPackage(entry.getKey());
					result.add(model);
				}
				// BEGIN SUPRESS CATCH EXCEPTION
				catch (RuntimeException exception) {
					// END SUPRESS CATCH EXCEPTION
					// logException("Failed to load model package " + entry.getKey(), exception);
				}
			}
		}
		return result;
	}

	/**
	 * Returns all non-abstract, non-interface subclasses of the given input class in the given package. In other words
	 * returns all classes that have direct instances.
	 * 
	 * @param clazz the eClass, must be a subtype of ModelElement
	 * @return a set of EClasses IMPORTANT: Will throw an IllegalArgumentException if given EClass is not a subtype of
	 *         ModelElement
	 */
	public static Set<EClass> getSubclasses(EClass clazz) {
		return getSubclasses(clazz, false);
	}

	/**
	 * Returns all subclasses of the given input class in the given package.
	 * 
	 * @param clazz the eClass, must be a subtype of ModelElement
	 * @param includeAbstractClassesAndInterfaces true if interfaces and abstract classes should be included in the
	 *            result
	 * @return a set of EClasses IMPORTANT: Will throw an IllegalArgumentException if given EClass is not a subtype of
	 *         ModelElement
	 */
	public static Set<EClass> getSubclasses(EClass clazz, boolean includeAbstractClassesAndInterfaces) {
		Set<EClass> ret = new HashSet<EClass>();
		for (EPackage ePackage : getAllModelPackages()) {
			getSubclasses(clazz, ret, ePackage, includeAbstractClassesAndInterfaces);
		}
		return ret;
	}

	private static void getSubclasses(EClass clazz, Set<EClass> ret, EPackage ePackage,
		boolean includeAbstractClassesAndInterfaces) {

		for (EClassifier classifier : ePackage.getEClassifiers()) {
			if (EcorePackage.eINSTANCE.getEClass().isInstance(classifier)) {
				EClass subClass = (EClass) classifier;
				if ((clazz.isSuperTypeOf(subClass) || clazz.equals(EcorePackage.eINSTANCE.getEObject()))
					&& (includeAbstractClassesAndInterfaces || canHaveInstances(subClass))) {
					ret.add(subClass);
				}
			}
		}
		for (EPackage subPackage : ePackage.getESubpackages()) {
			getSubclasses(clazz, ret, subPackage, includeAbstractClassesAndInterfaces);
		}
	}

	private static boolean canHaveInstances(EClass eClass) {
		return !(eClass.isAbstract() || eClass.isInterface());
	}

}
