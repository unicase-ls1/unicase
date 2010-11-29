/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.EPackage.Registry;

/**
 * MetaModelContext used by the editor to determine which model elements belong to the model.
 * 
 * @author helming
 */
public abstract class MetaModelElementContext {

	private Set<EClass> modelElementEClasses;

	/**
	 * Retrieve all EClasses from the ECore package registry that are subclasses of the given EClass. Does not include
	 * abstract classes or interfaces.
	 * 
	 * @param eClass the superClass of the subClasses to retrieve
	 * @return a set of EClasses
	 */
	public Set<EClass> getAllSubEClasses(EClass eClass) {
		return getAllSubEClasses(eClass, true);
	}

	/**
	 * Retrieve all EClasses from the Ecore package registry that are subclasses of the given EClass. Does not include
	 * abstract classes or interfaces. Could exclude {@link AssociationClassElement}'s.
	 * 
	 * @param eClass the superClass of the subClasses to retrieve
	 * @param association whether to include {@link AssociationClassElement}
	 * @return a set of EClasses
	 */
	public Set<EClass> getAllSubEClasses(EClass eClass, boolean association) {
		Set<EClass> allEClasses = getAllModelElementEClasses(association);
		Set<EClass> result = new HashSet<EClass>();
		for (EClass subClass : allEClasses) {
			if ((eClass.equals(EcorePackage.eINSTANCE.getEObject()) || eClass.isSuperTypeOf(subClass))
				&& (!subClass.isAbstract()) && (!subClass.isInterface())) {
				result.add(subClass);
			}
		}
		return result;
	}

	/**
	 * Returns all types of model elements in this context.
	 * 
	 * @return a set of eclasses
	 */
	public Set<EClass> getAllModelElementEClasses() {
		return getAllModelElementEClasses(true);
	}

	/**
	 * Returns all types of model elements in this context. Could exclude {@link AssociationClassElement}'s.
	 * 
	 * @param association whether to include {@link AssociationClassElement}
	 * @return a set of eclasses
	 */
	public Set<EClass> getAllModelElementEClasses(boolean association) {
		Set<EClass> result = new HashSet<EClass>();
		for (EClass subClass : getAllModelElementEClassesImpl()) {
			if (association || !isAssociationClassElement(subClass)) {
				result.add(subClass);
			}
		}
		return result;
	}

	/**
	 * Returns all types of model elements in this context.
	 * 
	 * @return a set of eclasses
	 */
	protected Set<EClass> getAllModelElementEClassesImpl() {
		if (modelElementEClasses != null) {
			return new HashSet<EClass>(modelElementEClasses);
		}
		Set<String> registeredPackages = new HashSet<String>();
		IConfigurationElement[] packages = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.common.ecpModelPackage");
		for (IConfigurationElement element : packages) {
			String packageName = element.getAttribute("modelPackage");
			registeredPackages.add(packageName);
		}
		Set<EClass> result = new HashSet<EClass>();
		Registry registry = EPackage.Registry.INSTANCE;
		if (registeredPackages.isEmpty()) {
			return guessPackages(new HashSet<Entry<String, Object>>(registry.entrySet()));
		}

		for (Entry<String, Object> entry : new HashSet<Entry<String, Object>>(registry.entrySet())) {
			if (!registeredPackages.contains(entry.getKey())) {
				continue;
			}
			try {
				EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(entry.getKey());
				result.addAll(getAllModelElementEClasses(ePackage));
			}
			// BEGIN SUPRESS CATCH EXCEPTION
			catch (RuntimeException exception) {
				// END SUPRESS CATCH EXCEPTION
				Activator.getDefault().logException(
					new RuntimeException("Failed to load model package " + entry.getKey(), exception));
			}

		}
		modelElementEClasses = result;
		return result;
	}

	private Set<EClass> guessPackages(HashSet<Entry<String, Object>> entries) {
		Set<EClass> ret = new HashSet<EClass>();
		for (Entry<String, Object> entry : entries) {
			System.out.print("\"" + entry.getKey() + "\"" + ",");
			if (!isKnownPackage(entry.getKey())) {
				EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(entry.getKey());
				ret.addAll(getAllModelElementEClasses(ePackage));
			}
		}
		return ret;
	}

	private boolean isKnownPackage(String key) {

		String elements[] = { "http://www.eclipse.org/gmf/2008/mappings", "http://www.w3.org/XML/1998/namespace",
			"http://www.eclipse.org/ocl/1.1.0/OCL", "http://www.eclipse.org/ocl/1.1.0/OCL/Expressions",
			"http://www.eclipse.org/emf/2002/GenModel", "http://www.eclipse.org/qvt/1.0/ImperativeOCL",
			"http://unicase.org/emfstore/esmodel", "http://www.cs.tum.edu/cope/migration",
			"http://unicase.org/esmodel/accesscontrol/roles", "http:///com/ibm/etools/dtd.ecore",
			"http:///www.eclipse.org/m2m/qvt/operational/trace.ecore",
			"http://www.eclipse.org/qvt/1.0.0/Operational/Expressions", "http://www.eclipse.org/gmf/2006/GenModel",
			"http://www.eclipse.org/uml2/3.0.0/UML", "http://www.eclipse.org/uml2/2.0.0/UML",
			"http://www.eclipse.org/gmf/runtime/1.0.0/notation", "http://www.eclipse.org/emf/2002/Tree",
			"http://www.eclipse.org/OCL2/1.0.0/ocl/uml", "http://www.eclipse.org/OCL2/1.0.0/ocl/types",
			"http://unicase.org/esmodel/versioning/events", "http://www.eclipse.org/emf/2003/Change",
			"http://www.eclipse.org/OCL2/1.0.0/ocl/query", "http://www.eclipse.org/gmf/2006/Trace",
			"http://www.eclipse.org/QVT2/1.0.0/Operational/cst", "http://unicase.org/esmodel/accesscontrol",
			"http://www.eclipse.org/emf/2005/Ecore2XML", "http://unicase.org/esmodel/versioning/operations",
			"http://www.eclipse.org/emf/2002/Ecore", "http://www.eclipse.org/QVT2/1.0.0/Operational/cst/temp",
			"http://www.eclipse.org/gmf/2005/GenModel/2.0", "http://www.eclipse.org/gmf/2005/ToolDefinition",
			"http://unicase.org/esmodel/versioning", "http://www.cs.tum.edu/cope/declaration",
			"http://www.eclipse.org/gmf/2005/GenModel", "http://www.eclipse.org/gmf/2005/mappings",
			"http://unicase.org/workspace", "http://www.eclipse.org/gmf/2006/GraphicalDefinition",
			"http://www.eclipse.org/gmf/runtime/1.0.1/notation", "http://www.eclipse.org/emf/2003/XMLType",
			"http://www.eclipse.org/uml2/2.1.0/UML", "http://www.eclipse.org/gmf/2005/mappings/2.0",
			"http://www.eclipse.org/ocl/1.1.0/OCL/Types", "http://www.eclipse.org/QVT/1.0.0/Operational",
			"http://www.eclipse.org/gmf/runtime/1.0.2/notation", "http://www.eclipse.org/ocl/1.1.0/OCL/Utilities",
			"moduleCore.xmi", "http://www.eclipse.org/emf/2002/XSD2Ecore", "http://unicase.org/workspaceModel",
			"http://www.eclipse.org/emf/2004/Ecore2Ecore", "http://www.eclipse.org/gmf/2005/GraphicalDefinition",
			"http://www.eclipse.org/gmf/2009/GenModel", "http://www.eclipse.org/xsd/2002/XSD",
			"http://www.eclipse.org/emf/2002/Mapping", "http://unicase.org/metamodel",
			"http://www.eclipse.org/gmf/2008/GenModel", "DTD.xmi", "http://www.eclipse.org/ocl/1.1.0/OCL/CST",
			"http://www.eclipse.org/OCL2/1.0.0/ocl/expressions", "componentcore.xmi",
			"http://www.eclipse.org/ocl/1.1.0/Ecore", "http://unicase.org/esmodel/notification",
			"http://www.eclipse.org/OCL2/1.0.0/oclstdlib", "http://unicase.org/esmodel/versioning/events/server/",
			"http://unicase.org/emfstore/esmodel/url", "http://www.eclipse.org/gmf/2006/mappings",
			"http://www.eclipse.org/OCL2/1.0.0/ocl", "http://unicase.org/esmodel/versioning/operations/semantic",
			"http://www.eclipse.org/OCL2/1.0.0/ocl/utilities" };
		Set<String> knownPackages = new HashSet<String>(Arrays.asList(elements));
		return knownPackages.contains(key);
	}

	/**
	 * Whether a {@link EClass} is a association class. Association classes are not displayed as dedicated elements. A
	 * link from one element to another which goes over an association class is displayed by a dedicated widget. This
	 * widgets allows to trace transparently without seeing the association class.
	 * 
	 * @param eClazz the {@link EClass}
	 * @return if it is an association
	 */
	public abstract boolean isAssociationClassElement(EClass eClazz);

	/**
	 * @param newMEInstance {@link EObject} the new modelElement instance.
	 * @return EReference the Container
	 * @param parent The EObject to get containment references from
	 */
	public EReference getPossibleContainingReference(final EObject newMEInstance, EObject parent) {
		// the value of the 'EAll Containments' reference list.
		List<EReference> eallcontainments = parent.eClass().getEAllContainments();
		EReference reference = null;
		for (EReference containmentitem : eallcontainments) {

			EClass eReferenceType = containmentitem.getEReferenceType();
			if (eReferenceType.equals(newMEInstance)) {
				reference = containmentitem;

				break;
			} else if (eReferenceType.equals(EcorePackage.eINSTANCE.getEObject())
				|| eReferenceType.isSuperTypeOf(newMEInstance.eClass())) {
				reference = containmentitem;
				break;
			}
		}
		return reference;
	}

	/**
	 * Retrieve all EClasses from the Ecore package that are model element subclasses.
	 * 
	 * @param ePackage the package to get the classes from
	 * @return a set of EClasses
	 */
	private static Set<EClass> getAllModelElementEClasses(EPackage ePackage) {
		Set<EClass> result = new HashSet<EClass>();
		for (EPackage subPackage : ePackage.getESubpackages()) {
			result.addAll(getAllModelElementEClasses(subPackage));
		}
		for (EClassifier classifier : ePackage.getEClassifiers()) {
			if (classifier instanceof EClass) {
				EClass subEClass = (EClass) classifier;
				result.add(subEClass);
			}
		}
		return result;
	}

	/**
	 * If the meta model context is guessing the packages. Happens if no model package is registered for EMF Client
	 * Platform.
	 * 
	 * @return if the context is guessed.
	 */
	public boolean isGuessed() {
		IConfigurationElement[] packages = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.common.ecpModelPackage");
		return (packages.length == 0);
	}
}
