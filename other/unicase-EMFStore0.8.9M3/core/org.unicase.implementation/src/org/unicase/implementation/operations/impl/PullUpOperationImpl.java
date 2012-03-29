/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.impl.SemanticCompositeOperationImpl;
import org.unicase.implementation.operations.OperationsPackage;
import org.unicase.implementation.operations.PullUpOperation;
import org.unicase.implementation.operations.util.ClassesOperationHelper;
import org.unicase.implementation.operations.util.OperationHelper;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.Attribute;
import org.unicase.model.classes.Class;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Pull Up Attribute Operation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.implementation.operations.impl.PullUpOperationImpl#getSuperClass <em>Super Class</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.impl.PullUpOperationImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.impl.PullUpOperationImpl#getOutgoingAssociations <em>Outgoing Associations</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.impl.PullUpOperationImpl#getIncomingAssociations <em>Incoming Associations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PullUpOperationImpl extends SemanticCompositeOperationImpl implements PullUpOperation {
	/**
	 * The cached value of the '{@link #getSuperClass() <em>Super Class</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSuperClass()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId superClass;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElementId> attributes;

	/**
	 * The cached value of the '{@link #getOutgoingAssociations() <em>Outgoing Associations</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOutgoingAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElementId> outgoingAssociations;

	/**
	 * The cached value of the '{@link #getIncomingAssociations() <em>Incoming Associations</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getIncomingAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElementId> incomingAssociations;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PullUpOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.PULL_UP_OPERATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId getSuperClass() {
		return superClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuperClass(ModelElementId newSuperClass, NotificationChain msgs) {
		ModelElementId oldSuperClass = superClass;
		superClass = newSuperClass;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationsPackage.PULL_UP_OPERATION__SUPER_CLASS, oldSuperClass, newSuperClass);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperClass(ModelElementId newSuperClass) {
		if (newSuperClass != superClass) {
			NotificationChain msgs = null;
			if (superClass != null)
				msgs = ((InternalEObject)superClass).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationsPackage.PULL_UP_OPERATION__SUPER_CLASS, null, msgs);
			if (newSuperClass != null)
				msgs = ((InternalEObject)newSuperClass).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationsPackage.PULL_UP_OPERATION__SUPER_CLASS, null, msgs);
			msgs = basicSetSuperClass(newSuperClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.PULL_UP_OPERATION__SUPER_CLASS, newSuperClass, newSuperClass));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementId> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<ModelElementId>(ModelElementId.class, this, OperationsPackage.PULL_UP_OPERATION__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementId> getOutgoingAssociations() {
		if (outgoingAssociations == null) {
			outgoingAssociations = new EObjectContainmentEList<ModelElementId>(ModelElementId.class, this, OperationsPackage.PULL_UP_OPERATION__OUTGOING_ASSOCIATIONS);
		}
		return outgoingAssociations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementId> getIncomingAssociations() {
		if (incomingAssociations == null) {
			incomingAssociations = new EObjectContainmentEList<ModelElementId>(ModelElementId.class, this, OperationsPackage.PULL_UP_OPERATION__INCOMING_ASSOCIATIONS);
		}
		return incomingAssociations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attribute> getAttributes(Project project) {
		return OperationHelper.getElements(project, getAttributes());
	}

	// begin of custom code
	/**
	 * {@inheritDoc}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Attribute> getPossibleAttributes(Project project) {
		List<Attribute> attributes = getAttributes(project);
		Class superClass = getSuperClass(project);
		List<Class> subClasses = superClass.getSubClasses();

		return getPossibleAttributes(attributes, subClasses);
	}

	/**
	 * Retrieve all attributes that could be pulled up.
	 * 
	 * @param attributes the attributes
	 * @param subClasses the subclasses of the target super class
	 * @return a list of attributes a list of candidate attributes
	 * @generated NOT
	 */
	public static EList<Attribute> getPossibleAttributes(List<Attribute> attributes, List<Class> subClasses) {
		EList<Attribute> possibleAttributes = new BasicEList<Attribute>();
		if (!subClasses.isEmpty()) {
			Class subClass = subClasses.get(0);
			EList<Attribute> subClassAttributes = subClass.getAttributes();
			if (subClasses.size() == 1) {
				return subClassAttributes;
			}
			for (Attribute subClassAttribute : subClassAttributes) {
				Attribute attribute = subClassAttribute;
				for (Class c : subClasses) {
					if (c == subClass) {
						continue;
					}
					Attribute sameAttribute = ClassesOperationHelper.getSameAttribute(c, subClassAttribute);
					if (sameAttribute == null) {
						attribute = null;
						break;
					} else if (attributes.contains(sameAttribute)) {
						attribute = sameAttribute;
					}
				}
				if (attribute != null) {
					possibleAttributes.add(attribute);
				}
			}
		}
		return possibleAttributes;
	}

	// end of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Association> getOutgoingAssociations(Project project) {
		return OperationHelper.getElements(project, getOutgoingAssociations());
	}

	// begin of custom code
	/**
	 * {@inheritDoc}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Association> getPossibleOutgoingAssociations(Project project) {
		List<Association> associations = getOutgoingAssociations(project);
		Class superClass = getSuperClass(project);
		List<Class> subClasses = superClass.getSubClasses();

		return getPossibleOutgoingAssociations(associations, subClasses);
	}

	/**
	 * Retrieve all {@link Association}s that could be pulled up.
	 * 
	 * @param associations the {@link Association}
	 * @param subClasses the subclasses of the target super class
	 * @return a list of associations
	 * @generated NOT
	 */
	public static EList<Association> getPossibleOutgoingAssociations(List<Association> associations,
		List<Class> subClasses) {
		EList<Association> possibleAssociations = new BasicEList<Association>();
		if (!subClasses.isEmpty()) {
			Class subClass = subClasses.get(0);
			EList<Association> subClassAssociations = subClass.getOutgoingAssociations();
			if (subClasses.size() == 1) {
				return subClassAssociations;
			}
			for (Association subClassAssociation : subClassAssociations) {
				Association association = subClassAssociation;
				for (Class c : subClasses) {
					if (c == subClass) {
						continue;
					}
					Association sameAssociation = ClassesOperationHelper.getSameOutgoingAssociation(c,
						subClassAssociation);
					if (sameAssociation == null) {
						association = null;
						break;
					} else if (associations.contains(sameAssociation)) {
						association = sameAssociation;
					}
				}
				if (association != null) {
					possibleAssociations.add(association);
				}
			}
		}
		return possibleAssociations;
	}

	// end of custom code
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Association> getIncomingAssociations(Project project) {
		return OperationHelper.getElements(project, getIncomingAssociations());
	}

	// begin of custom code
	/**
	 * {@inheritDoc}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Association> getPossibleIncomingAssociations(Project project) {
		List<Association> associations = getIncomingAssociations(project);
		Class superClass = getSuperClass(project);
		List<Class> subClasses = superClass.getSubClasses();

		return getPossibleIncomingAssociations(associations, subClasses);
	}

	/**
	 * Retrieve all {@link Association}s that could be pulled up.
	 * 
	 * @param associations the {@link Association}
	 * @param subClasses the subclasses of the target super class
	 * @return a list of associations
	 * @generated NOT
	 */
	public static EList<Association> getPossibleIncomingAssociations(List<Association> associations,
		List<Class> subClasses) {
		EList<Association> possibleAssociations = new BasicEList<Association>();
		if (!subClasses.isEmpty()) {
			Class subClass = subClasses.get(0);
			EList<Association> subClassAssociations = subClass.getIncomingAssociations();
			if (subClasses.size() == 1) {
				return subClassAssociations;
			}
			for (Association subClassAssociation : subClassAssociations) {
				Association association = subClassAssociation;
				for (Class c : subClasses) {
					if (c == subClass) {
						continue;
					}
					Association sameAssociation = ClassesOperationHelper.getSameIncomingAssociation(c,
						subClassAssociation);
					if (sameAssociation == null) {
						association = null;
						break;
					} else if (associations.contains(sameAssociation)) {
						association = sameAssociation;
					}
				}
				if (association != null) {
					possibleAssociations.add(association);
				}
			}
		}
		return possibleAssociations;
	}

	/**
	 * {@inheritDoc}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateAttributesAssociations(Project project) {
		List<Attribute> attributes = getAttributes(project);
		List<Association> outgoingAssociations = getOutgoingAssociations(project);
		List<Association> incomingAssociations = getIncomingAssociations(project);

		return attributes.size() + outgoingAssociations.size() + incomingAssociations.size() > 0;
	}

	// end of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public org.unicase.model.classes.Class getSuperClass(Project project) {
		return OperationHelper.getElement(project, getSuperClass());
	}

	// begin of custom code
	// BEGIN COMPLEX CODE
	/**
	 * {@inheritDoc}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<org.unicase.model.classes.Class> getPossibleSuperClasses(Project project) {
		List<Attribute> attributes = getAttributes(project);
		List<Association> outgoingAssociations = getOutgoingAssociations(project);
		List<Association> incomingAssociations = getIncomingAssociations(project);

		EList<Class> possibleSuperClasses = new BasicEList<Class>();
		if (!attributes.isEmpty()) {
			Attribute attribute = attributes.get(0);
			possibleSuperClasses.addAll(attribute.getDefiningClass().getSuperClasses());
			attributes.remove(attribute);
		} else if (!outgoingAssociations.isEmpty()) {
			Association association = outgoingAssociations.get(0);
			if (association.getSource() != null) {
				possibleSuperClasses.addAll(association.getSource().getSuperClasses());
			}
			outgoingAssociations.remove(association);
		} else {
			Association association = incomingAssociations.get(0);
			if (association.getTarget() != null) {
				possibleSuperClasses.addAll(association.getTarget().getSuperClasses());
			}
			incomingAssociations.remove(association);
		}

		for (Attribute attribute : attributes) {
			for (Iterator<Class> i = possibleSuperClasses.iterator(); i.hasNext();) {
				Class superClass = i.next();
				if (!attribute.getDefiningClass().getSuperClasses().contains(superClass)) {
					i.remove();
				}
			}
		}

		for (Association association : outgoingAssociations) {
			for (Iterator<Class> i = possibleSuperClasses.iterator(); i.hasNext();) {
				Class superClass = i.next();
				if (!association.getSource().getSuperClasses().contains(superClass)) {
					i.remove();
				}
			}
		}

		for (Association association : incomingAssociations) {
			for (Iterator<Class> i = possibleSuperClasses.iterator(); i.hasNext();) {
				Class superClass = i.next();
				if (!association.getTarget().getSuperClasses().contains(superClass)) {
					i.remove();
				}
			}
		}

		return possibleSuperClasses;
	}

	// END COMPLEX CODE
	// end of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OperationsPackage.PULL_UP_OPERATION__SUPER_CLASS:
				return basicSetSuperClass(null, msgs);
			case OperationsPackage.PULL_UP_OPERATION__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case OperationsPackage.PULL_UP_OPERATION__OUTGOING_ASSOCIATIONS:
				return ((InternalEList<?>)getOutgoingAssociations()).basicRemove(otherEnd, msgs);
			case OperationsPackage.PULL_UP_OPERATION__INCOMING_ASSOCIATIONS:
				return ((InternalEList<?>)getIncomingAssociations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperationsPackage.PULL_UP_OPERATION__SUPER_CLASS:
				return getSuperClass();
			case OperationsPackage.PULL_UP_OPERATION__ATTRIBUTES:
				return getAttributes();
			case OperationsPackage.PULL_UP_OPERATION__OUTGOING_ASSOCIATIONS:
				return getOutgoingAssociations();
			case OperationsPackage.PULL_UP_OPERATION__INCOMING_ASSOCIATIONS:
				return getIncomingAssociations();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OperationsPackage.PULL_UP_OPERATION__SUPER_CLASS:
				setSuperClass((ModelElementId)newValue);
				return;
			case OperationsPackage.PULL_UP_OPERATION__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends ModelElementId>)newValue);
				return;
			case OperationsPackage.PULL_UP_OPERATION__OUTGOING_ASSOCIATIONS:
				getOutgoingAssociations().clear();
				getOutgoingAssociations().addAll((Collection<? extends ModelElementId>)newValue);
				return;
			case OperationsPackage.PULL_UP_OPERATION__INCOMING_ASSOCIATIONS:
				getIncomingAssociations().clear();
				getIncomingAssociations().addAll((Collection<? extends ModelElementId>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case OperationsPackage.PULL_UP_OPERATION__SUPER_CLASS:
				setSuperClass((ModelElementId)null);
				return;
			case OperationsPackage.PULL_UP_OPERATION__ATTRIBUTES:
				getAttributes().clear();
				return;
			case OperationsPackage.PULL_UP_OPERATION__OUTGOING_ASSOCIATIONS:
				getOutgoingAssociations().clear();
				return;
			case OperationsPackage.PULL_UP_OPERATION__INCOMING_ASSOCIATIONS:
				getIncomingAssociations().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case OperationsPackage.PULL_UP_OPERATION__SUPER_CLASS:
				return superClass != null;
			case OperationsPackage.PULL_UP_OPERATION__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case OperationsPackage.PULL_UP_OPERATION__OUTGOING_ASSOCIATIONS:
				return outgoingAssociations != null && !outgoingAssociations.isEmpty();
			case OperationsPackage.PULL_UP_OPERATION__INCOMING_ASSOCIATIONS:
				return incomingAssociations != null && !incomingAssociations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	public void semanticApply(Project project) {
		List<Attribute> attributes = getAttributes(project);
		List<Association> outgoingAssociations = getOutgoingAssociations(project);
		List<Association> incomingAssociations = getIncomingAssociations(project);
		Class superClass = getSuperClass(project);

		pullUpAttributes(attributes, superClass);
		pullUpOutgoingAssociations(outgoingAssociations, superClass);
		pullUpIncomingAssociations(incomingAssociations, superClass);
	}

	public static void pullUpAttributes(List<Attribute> attributes, Class superClass) {
		for (Attribute attribute : attributes) {
			Attribute superAttribute = ModelUtil.clone(attribute);
			superClass.getAttributes().add(superAttribute);
			for (Class subClass : superClass.getSubClasses()) {
				if (subClass != attribute.getDefiningClass()) {
					Attribute sameAttribute = ClassesOperationHelper.getSameAttribute(subClass, attribute);
					ModelUtil.getProject(sameAttribute).deleteModelElement(sameAttribute);
				}
			}
			ModelUtil.getProject(attribute).deleteModelElement(attribute);
		}
	}

	@SuppressWarnings("unchecked")
	public static void pullUpOutgoingAssociations(List<Association> associations, Class superClass) {
		for (Association association : associations) {
			for (Class subClass : superClass.getSubClasses()) {
				if (subClass != association.getSource()) {
					Association sameAssociation = ClassesOperationHelper.getSameOutgoingAssociation(subClass,
						association);
					ModelUtil.getProject(sameAssociation).deleteModelElement(sameAssociation);
				}
			}
			Association superAssociation = ModelUtil.clone(association);
			((List<Association>) association.eContainer().eGet(association.eContainmentFeature()))
				.add(superAssociation);
			superAssociation.setSource(superClass);
			superAssociation.setTarget(association.getTarget());
			ModelUtil.getProject(association).deleteModelElement(association);
		}
	}

	@SuppressWarnings("unchecked")
	public static void pullUpIncomingAssociations(List<Association> associations, Class superClass) {
		for (Association association : associations) {
			for (Class subClass : superClass.getSubClasses()) {
				if (subClass != association.getSource()) {
					Association sameAssociation = ClassesOperationHelper.getSameIncomingAssociation(subClass,
						association);
					ModelUtil.getProject(sameAssociation).deleteModelElement(sameAssociation);
				}
			}
			Association superAssociation = ModelUtil.clone(association);
			((List<Association>) association.eContainer().eGet(association.eContainmentFeature()))
				.add(superAssociation);
			superAssociation.setSource(association.getSource());
			superAssociation.setTarget(superClass);
			ModelUtil.getProject(association).deleteModelElement(association);
		}
	}
} // PullUpAttributeOperationImpl
