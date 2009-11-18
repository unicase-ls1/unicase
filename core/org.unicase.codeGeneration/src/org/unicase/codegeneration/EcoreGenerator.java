/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.codegeneration;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.implementation.IAttribute;
import org.unicase.model.implementation.IClass;
import org.unicase.model.implementation.IEnumeration;
import org.unicase.model.implementation.IFeature;
import org.unicase.model.implementation.ILiteral;
import org.unicase.model.implementation.IPackage;
import org.unicase.model.implementation.IPrimitiveType;
import org.unicase.model.implementation.IReference;

/**
 * Generate an Ecore model from an implementation model.
 * 
 * @author herrmama
 */
public class EcoreGenerator {

	private Map<UnicaseModelElement, EObject> mapping;

	/**
	 * Generate a list of ECore Package from UNICASE implementation packages.
	 * 
	 * @param packages the implementation packages
	 * @return the ecore packages
	 */
	public List<EPackage> generate(List<IPackage> packages) {
		mapping = new IdentityHashMap<UnicaseModelElement, EObject>();
		List<EPackage> ePackages = generatePackages(packages);
		link(packages);
		return ePackages;
	}

	/*
	 * Transform containment hierarchy
	 */

	private List<EPackage> generatePackages(List<IPackage> packages) {
		List<EPackage> ePackages = new ArrayList<EPackage>();
		for (IPackage p : packages) {
			ePackages.add(generatePackage(p));
		}
		return ePackages;
	}

	private EPackage generatePackage(IPackage p) {
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		initModelElement(p, ePackage);
		ePackage.setNsPrefix(p.getNamespace());
		ePackage.setNsURI(p.getNamespace());

		ePackage.getESubpackages().addAll(generatePackages(p.getSubPackages()));
		for (IClass c : p.getClasses()) {
			ePackage.getEClassifiers().add(generateClass(c));
		}
		for (IEnumeration enumeration : p.getEnumerations()) {
			ePackage.getEClassifiers().add(generateEnumeration(enumeration));
		}

		return ePackage;
	}

	private EClass generateClass(IClass c) {
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		initModelElement(c, eClass);
		eClass.setAbstract(c.isAbstract());

		for (IAttribute attribute : c.getAttributes()) {
			eClass.getEStructuralFeatures().add(generateAttribute(attribute));
		}
		for (IReference reference : c.getOutgoingReferences()) {
			eClass.getEStructuralFeatures().add(generateReference(reference));
		}

		return eClass;
	}

	private EReference generateReference(IReference reference) {
		EReference eReference = EcoreFactory.eINSTANCE.createEReference();
		initFeature(reference, eReference);
		eReference.setContainment(reference.isContainment());
		return eReference;
	}

	private EStructuralFeature generateAttribute(IAttribute attribute) {
		EAttribute eAttribute = EcoreFactory.eINSTANCE.createEAttribute();
		initFeature(attribute, eAttribute);
		eAttribute.setID(attribute.isId());
		return eAttribute;
	}

	private void initFeature(IFeature feature, EStructuralFeature eFeature) {
		initModelElement(feature, eFeature);
		eFeature.setLowerBound(feature.getMinimumMultiplicity());
		eFeature.setUpperBound(feature.getMaximumMultiplicity());
		eFeature.setTransient(feature.isTransient());
	}

	private EEnum generateEnumeration(IEnumeration enumeration) {
		EEnum eEnum = EcoreFactory.eINSTANCE.createEEnum();
		initModelElement(enumeration, eEnum);

		for (ILiteral literal : enumeration.getLiterals()) {
			eEnum.getELiterals().add(generateLiteral(literal));
		}

		return eEnum;
	}

	private EEnumLiteral generateLiteral(ILiteral literal) {
		IEnumeration enumeration = (IEnumeration) literal.eContainer();
		EEnumLiteral eEnumLiteral = EcoreFactory.eINSTANCE.createEEnumLiteral();
		initModelElement(literal, eEnumLiteral);
		eEnumLiteral.setLiteral(literal.getLiteral());
		eEnumLiteral.setValue(enumeration.getLiterals().indexOf(literal));
		return eEnumLiteral;
	}

	private void initModelElement(UnicaseModelElement mElement, ENamedElement eElement) {
		eElement.setName(mElement.getName());
		mapping.put(mElement, eElement);
	}

	/*
	 * Transform cross references
	 */

	private void link(List<IPackage> packages) {
		for (IPackage p : packages) {
			linkPackage(p);
		}
	}

	private void linkPackage(IPackage p) {
		link(p.getSubPackages());
		for (IClass c : p.getClasses()) {
			linkClass(c);
		}
	}

	private void linkClass(IClass c) {
		EClass eClass = (EClass) get(c);
		for (IClass s : c.getSuperClasses()) {
			eClass.getESuperTypes().add((EClass) get(s));
		}
		for (IAttribute attribute : c.getAttributes()) {
			linkAttribute(attribute);
		}
		for (IReference reference : c.getOutgoingReferences()) {
			linkReference(reference);
		}
	}

	private void linkAttribute(IAttribute attribute) {
		EAttribute eAttribute = (EAttribute) get(attribute);
		if (attribute.getType() == IPrimitiveType.ENUMERATION) {
			eAttribute.setEType((EClassifier) get(attribute.getEnumeration()));
		} else {
			eAttribute.setEType(getPrimitiveType(attribute.getType()));
		}
	}

	private EClassifier getPrimitiveType(IPrimitiveType type) {
		switch (type) {
		case BOOLEAN:
			return EcorePackage.Literals.EBOOLEAN;
		case INTEGER:
			return EcorePackage.Literals.EINT;
		case DOUBLE:
			return EcorePackage.Literals.EDOUBLE;
		case STRING:
			return EcorePackage.Literals.ESTRING;
		case DATE:
			return EcorePackage.Literals.EDATE;
		default:
			return null;
		}
	}

	private void linkReference(IReference reference) {
		EReference eReference = (EReference) get(reference);
		eReference.setEType((EClassifier) get(reference.getType()));
		eReference.setEOpposite((EReference) get(reference.getOppositeReference()));
	}

	private EObject get(UnicaseModelElement source) {
		EObject target = mapping.get(source);
		if (target == null) {
			throw new NotSelfContainedException(source);
		}
		return target;
	}
}
