/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations.util;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
import org.unicase.model.classes.Association;
import org.unicase.model.classes.AssociationType;
import org.unicase.model.classes.Attribute;
import org.unicase.model.classes.Class;
import org.unicase.model.classes.Enumeration;
import org.unicase.model.classes.InstantiationType;
import org.unicase.model.classes.Literal;
import org.unicase.model.classes.Package;
import org.unicase.model.classes.PackageElement;
import org.unicase.model.classes.PrimitiveType;
import org.unicase.model.classes.validation.ClassesHelper;
import org.unicase.model.classes.validation.MultiplicityParseResult;

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
	public List<EPackage> generate(List<Package> packages) {
		mapping = new IdentityHashMap<UnicaseModelElement, EObject>();
		List<EPackage> ePackages = generatePackages(packages);
		link(packages);
		return ePackages;
	}

	/*
	 * Transform containment hierarchy
	 */

	private List<EPackage> generatePackages(List<Package> packages) {
		List<EPackage> ePackages = new ArrayList<EPackage>();
		for (Package p : packages) {
			ePackages.add(generatePackage(p));
		}
		return ePackages;
	}

	private EPackage generatePackage(Package p) {
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		initModelElement(p, ePackage);
		String namespace = getNamespace(p);
		ePackage.setNsPrefix(namespace);
		ePackage.setNsURI(namespace);

		for (PackageElement packageElement : p.getContainedPackageElements()) {
			if (packageElement instanceof Package) {
				ePackage.getESubpackages().add(generatePackage((Package) packageElement));
			}
			if (packageElement instanceof Class) {
				ePackage.getEClassifiers().add(generateClass((Class) packageElement));
			}
			if (packageElement instanceof Enumeration) {
				ePackage.getEClassifiers().add(generateEnumeration((Enumeration) packageElement));
			}
		}

		return ePackage;
	}

	private String getNamespace(Package p) {
		String namespace = p.getName();
		if (p.getParentPackage() != null) {
			namespace = getNamespace(p.getParentPackage()) + "." + namespace;
		}
		return namespace;
	}

	private EClass generateClass(Class c) {
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		initModelElement(c, eClass);
		eClass.setAbstract(c.getInstantiationType().equals(InstantiationType.ABSTRACT));

		for (Attribute attribute : c.getAttributes()) {
			eClass.getEStructuralFeatures().add(generateAttribute(attribute));
		}

		return eClass;
	}

	private EStructuralFeature generateAttribute(Attribute attribute) {
		EAttribute eAttribute = EcoreFactory.eINSTANCE.createEAttribute();
		initModelElement(attribute, eAttribute);
		eAttribute.setTransient(attribute.isTransient());
		eAttribute.setID(attribute.isId());
		return eAttribute;
	}

	private EEnum generateEnumeration(Enumeration enumeration) {
		EEnum eEnum = EcoreFactory.eINSTANCE.createEEnum();
		initModelElement(enumeration, eEnum);

		for (Literal literal : enumeration.getLiterals()) {
			eEnum.getELiterals().add(generateLiteral(literal));
		}

		return eEnum;
	}

	private EEnumLiteral generateLiteral(Literal literal) {
		Enumeration enumeration = (Enumeration) literal.eContainer();
		EEnumLiteral eEnumLiteral = EcoreFactory.eINSTANCE.createEEnumLiteral();
		initModelElement(literal, eEnumLiteral);
		eEnumLiteral.setLiteral(literal.getLiteral());
		eEnumLiteral.setValue(enumeration.getLiterals().indexOf(literal));
		return eEnumLiteral;
	}

	private void initModelElement(UnicaseModelElement mElement, ENamedElement eElement) {
		eElement.setName(mElement.getName());
		map(mElement, eElement);
	}

	private void map(UnicaseModelElement mElement, ENamedElement eElement) {
		mapping.put(mElement, eElement);
	}

	/*
	 * Transform cross references
	 */

	private void link(List<Package> packages) {
		for (Package p : packages) {
			linkPackage(p);
		}
	}

	private void linkPackage(Package p) {
		for (PackageElement packageElement : p.getContainedPackageElements()) {
			if (packageElement instanceof Class) {
				linkClass((Class) packageElement);
			}
			if (packageElement instanceof Package) {
				linkPackage((Package) packageElement);
			}

		}
	}

	private void linkClass(Class c) {
		EClass eClass = (EClass) get(c);
		for (Class s : c.getSuperClasses()) {
			eClass.getESuperTypes().add((EClass) get(s));
		}
		for (Attribute attribute : c.getAttributes()) {
			linkAttribute(attribute);
		}
		for (Association association : c.getOutgoingAssociations()) {
			linkAssociation(association);
		}
	}

	private void linkAttribute(Attribute attribute) {
		EAttribute eAttribute = (EAttribute) get(attribute);
		if (attribute.getImplementationType() == PrimitiveType.ENUMERATION) {
			eAttribute.setEType((EDataType) get(attribute.getImplementationEnumeration()));
		} else {
			eAttribute.setEType(getPrimitiveType(attribute.getImplementationType()));
		}
	}

	private EDataType getPrimitiveType(PrimitiveType type) {
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

	private void linkAssociation(Association association) {
		EClass sourceClass = (EClass) get(association.getSource());
		EClass targetClass = (EClass) get(association.getTarget());

		EReference targetReference = EcoreFactory.eINSTANCE.createEReference();
		targetReference.setName(association.getTargetRole());
		targetReference.setEType(targetClass);
		targetReference.setContainment(association.getType() == AssociationType.COMPOSITION);
		targetReference.setTransient(association.isTransient());
		MultiplicityParseResult targetMultiplicity = ClassesHelper.parseMultiplicity(association
			.getTargetMultiplicity());
		targetReference.setLowerBound(targetMultiplicity.getMinimumMultiplicity());
		targetReference.setUpperBound(targetMultiplicity.getMaximumMultiplicity());
		sourceClass.getEStructuralFeatures().add(targetReference);

		if (association.getType() != AssociationType.DIRECTED_ASSOCIATION) {
			EReference sourceReference = EcoreFactory.eINSTANCE.createEReference();
			sourceReference.setName(association.getSourceRole());
			sourceReference.setEType(sourceClass);
			sourceReference.setTransient(association.isTransient());
			MultiplicityParseResult sourceMultiplicity = ClassesHelper.parseMultiplicity(association
				.getTargetMultiplicity());
			sourceReference.setLowerBound(sourceMultiplicity.getMinimumMultiplicity());
			sourceReference.setUpperBound(sourceMultiplicity.getMaximumMultiplicity());
			targetClass.getEStructuralFeatures().add(sourceReference);
		}
	}

	private EObject get(UnicaseModelElement source) {
		EObject target = mapping.get(source);
		if (target == null) {
			throw new NotSelfContainedException(source);
		}
		return target;
	}
}
