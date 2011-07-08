/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.impl.SemanticCompositeOperationImpl;
import org.unicase.implementation.operations.ExtractClassOperation;
import org.unicase.implementation.operations.OperationsPackage;
import org.unicase.implementation.operations.util.OperationHelper;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.AssociationType;
import org.unicase.model.classes.Attribute;
import org.unicase.model.classes.Class;
import org.unicase.model.classes.ClassesFactory;
import org.unicase.model.classes.Enumeration;
import org.unicase.model.classes.Package;
import org.unicase.model.classes.PackageElement;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Extract Class Operation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.implementation.operations.impl.ExtractClassOperationImpl#getContextClass <em>Context Class</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.impl.ExtractClassOperationImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.impl.ExtractClassOperationImpl#getOutgoingAssociations <em>Outgoing Associations</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.impl.ExtractClassOperationImpl#getIncomingAssociations <em>Incoming Associations</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.impl.ExtractClassOperationImpl#getCompositionName <em>Composition Name</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.impl.ExtractClassOperationImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.impl.ExtractClassOperationImpl#getTargetPackage <em>Target Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtractClassOperationImpl extends SemanticCompositeOperationImpl implements ExtractClassOperation {
	/**
	 * The cached value of the '{@link #getContextClass() <em>Context Class</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getContextClass()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId contextClass;

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
	 * The default value of the '{@link #getCompositionName() <em>Composition Name</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getCompositionName()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPOSITION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCompositionName() <em>Composition Name</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getCompositionName()
	 * @generated
	 * @ordered
	 */
	protected String compositionName = COMPOSITION_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected String className = CLASS_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTargetPackage() <em>Target Package</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTargetPackage()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId targetPackage;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtractClassOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.EXTRACT_CLASS_OPERATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId getContextClass() {
		return contextClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContextClass(ModelElementId newContextClass, NotificationChain msgs) {
		ModelElementId oldContextClass = contextClass;
		contextClass = newContextClass;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationsPackage.EXTRACT_CLASS_OPERATION__CONTEXT_CLASS, oldContextClass, newContextClass);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextClass(ModelElementId newContextClass) {
		if (newContextClass != contextClass) {
			NotificationChain msgs = null;
			if (contextClass != null)
				msgs = ((InternalEObject)contextClass).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationsPackage.EXTRACT_CLASS_OPERATION__CONTEXT_CLASS, null, msgs);
			if (newContextClass != null)
				msgs = ((InternalEObject)newContextClass).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationsPackage.EXTRACT_CLASS_OPERATION__CONTEXT_CLASS, null, msgs);
			msgs = basicSetContextClass(newContextClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.EXTRACT_CLASS_OPERATION__CONTEXT_CLASS, newContextClass, newContextClass));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementId> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<ModelElementId>(ModelElementId.class, this, OperationsPackage.EXTRACT_CLASS_OPERATION__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementId> getOutgoingAssociations() {
		if (outgoingAssociations == null) {
			outgoingAssociations = new EObjectContainmentEList<ModelElementId>(ModelElementId.class, this, OperationsPackage.EXTRACT_CLASS_OPERATION__OUTGOING_ASSOCIATIONS);
		}
		return outgoingAssociations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementId> getIncomingAssociations() {
		if (incomingAssociations == null) {
			incomingAssociations = new EObjectContainmentEList<ModelElementId>(ModelElementId.class, this, OperationsPackage.EXTRACT_CLASS_OPERATION__INCOMING_ASSOCIATIONS);
		}
		return incomingAssociations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCompositionName() {
		return compositionName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompositionName(String newCompositionName) {
		String oldCompositionName = compositionName;
		compositionName = newCompositionName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.EXTRACT_CLASS_OPERATION__COMPOSITION_NAME, oldCompositionName, compositionName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassName(String newClassName) {
		String oldClassName = className;
		className = newClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.EXTRACT_CLASS_OPERATION__CLASS_NAME, oldClassName, className));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId getTargetPackage() {
		return targetPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetPackage(ModelElementId newTargetPackage, NotificationChain msgs) {
		ModelElementId oldTargetPackage = targetPackage;
		targetPackage = newTargetPackage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationsPackage.EXTRACT_CLASS_OPERATION__TARGET_PACKAGE, oldTargetPackage, newTargetPackage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetPackage(ModelElementId newTargetPackage) {
		if (newTargetPackage != targetPackage) {
			NotificationChain msgs = null;
			if (targetPackage != null)
				msgs = ((InternalEObject)targetPackage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationsPackage.EXTRACT_CLASS_OPERATION__TARGET_PACKAGE, null, msgs);
			if (newTargetPackage != null)
				msgs = ((InternalEObject)newTargetPackage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationsPackage.EXTRACT_CLASS_OPERATION__TARGET_PACKAGE, null, msgs);
			msgs = basicSetTargetPackage(newTargetPackage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.EXTRACT_CLASS_OPERATION__TARGET_PACKAGE, newTargetPackage, newTargetPackage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public org.unicase.model.classes.Class getContextClass(Project project) {
		return OperationHelper.getElement(project, getContextClass());
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
	 * Retrieve a list of attributes that can be extracted.
	 * @param project the project the operation is about to be invoked on
	 * @return a list of attributes
	 * 
	 * @generated NOT
	 */
	public EList<Attribute> getPossibleAttributes(Project project) {
		Class contextClass = getContextClass(project);
		return contextClass.getAttributes();
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
	 * {@inheritDoc}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Association> getPossibleOutgoingAssociations(Project project) {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Association> getIncomingAssociations(Project project) {
		return OperationHelper.getElements(project, getIncomingAssociations());
	}

	/**
	 * {@inheritDoc}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Association> getPossibleIncomingAssociations(Project project) {
		Class contextClass = getContextClass(project);
		return contextClass.getIncomingAssociations();
	}

	/**
	 * {@inheritDoc}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public org.unicase.model.classes.Package getTargetPackage(Project project) {
		return OperationHelper.getElement(project, getTargetPackage());
	}

	/**
	 * {@inheritDoc}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateClassName(Project project) {
		Package targetPackage = getTargetPackage(project);
		String className = getClassName();

		if (className != null && targetPackage != null) {
			for (PackageElement element : targetPackage.getContainedPackageElements()) {
				if (element instanceof Class || element instanceof Enumeration) {
					if (className.equals(element.getName())) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * {@inheritDoc}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateCompositionName(Project project) {
		String compositionName = getCompositeName();
		Class contextClass = getContextClass(project);
		List<Attribute> attributes = getAttributes(project);
		List<Association> outgoingAssociations = getOutgoingAssociations(project);
		List<Association> incomingAssociations = getIncomingAssociations(project);

		for (Attribute attribute : contextClass.getAttributes()) {
			if (!attributes.contains(attribute) && compositionName.equals(attribute.getName())) {
				return false;
			}
		}
		for (Association association : contextClass.getOutgoingAssociations()) {
			if (!outgoingAssociations.contains(association) && compositionName.equals(association.getTarget())) {
				return false;
			}
		}
		for (Association association : contextClass.getIncomingAssociations()) {
			if (!incomingAssociations.contains(association) && compositionName.equals(association.getSource())) {
				return false;
			}
		}

		return true;
	}
	// end of custom code
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OperationsPackage.EXTRACT_CLASS_OPERATION__CONTEXT_CLASS:
				return basicSetContextClass(null, msgs);
			case OperationsPackage.EXTRACT_CLASS_OPERATION__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case OperationsPackage.EXTRACT_CLASS_OPERATION__OUTGOING_ASSOCIATIONS:
				return ((InternalEList<?>)getOutgoingAssociations()).basicRemove(otherEnd, msgs);
			case OperationsPackage.EXTRACT_CLASS_OPERATION__INCOMING_ASSOCIATIONS:
				return ((InternalEList<?>)getIncomingAssociations()).basicRemove(otherEnd, msgs);
			case OperationsPackage.EXTRACT_CLASS_OPERATION__TARGET_PACKAGE:
				return basicSetTargetPackage(null, msgs);
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
			case OperationsPackage.EXTRACT_CLASS_OPERATION__CONTEXT_CLASS:
				return getContextClass();
			case OperationsPackage.EXTRACT_CLASS_OPERATION__ATTRIBUTES:
				return getAttributes();
			case OperationsPackage.EXTRACT_CLASS_OPERATION__OUTGOING_ASSOCIATIONS:
				return getOutgoingAssociations();
			case OperationsPackage.EXTRACT_CLASS_OPERATION__INCOMING_ASSOCIATIONS:
				return getIncomingAssociations();
			case OperationsPackage.EXTRACT_CLASS_OPERATION__COMPOSITION_NAME:
				return getCompositionName();
			case OperationsPackage.EXTRACT_CLASS_OPERATION__CLASS_NAME:
				return getClassName();
			case OperationsPackage.EXTRACT_CLASS_OPERATION__TARGET_PACKAGE:
				return getTargetPackage();
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
			case OperationsPackage.EXTRACT_CLASS_OPERATION__CONTEXT_CLASS:
				setContextClass((ModelElementId)newValue);
				return;
			case OperationsPackage.EXTRACT_CLASS_OPERATION__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends ModelElementId>)newValue);
				return;
			case OperationsPackage.EXTRACT_CLASS_OPERATION__OUTGOING_ASSOCIATIONS:
				getOutgoingAssociations().clear();
				getOutgoingAssociations().addAll((Collection<? extends ModelElementId>)newValue);
				return;
			case OperationsPackage.EXTRACT_CLASS_OPERATION__INCOMING_ASSOCIATIONS:
				getIncomingAssociations().clear();
				getIncomingAssociations().addAll((Collection<? extends ModelElementId>)newValue);
				return;
			case OperationsPackage.EXTRACT_CLASS_OPERATION__COMPOSITION_NAME:
				setCompositionName((String)newValue);
				return;
			case OperationsPackage.EXTRACT_CLASS_OPERATION__CLASS_NAME:
				setClassName((String)newValue);
				return;
			case OperationsPackage.EXTRACT_CLASS_OPERATION__TARGET_PACKAGE:
				setTargetPackage((ModelElementId)newValue);
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
			case OperationsPackage.EXTRACT_CLASS_OPERATION__CONTEXT_CLASS:
				setContextClass((ModelElementId)null);
				return;
			case OperationsPackage.EXTRACT_CLASS_OPERATION__ATTRIBUTES:
				getAttributes().clear();
				return;
			case OperationsPackage.EXTRACT_CLASS_OPERATION__OUTGOING_ASSOCIATIONS:
				getOutgoingAssociations().clear();
				return;
			case OperationsPackage.EXTRACT_CLASS_OPERATION__INCOMING_ASSOCIATIONS:
				getIncomingAssociations().clear();
				return;
			case OperationsPackage.EXTRACT_CLASS_OPERATION__COMPOSITION_NAME:
				setCompositionName(COMPOSITION_NAME_EDEFAULT);
				return;
			case OperationsPackage.EXTRACT_CLASS_OPERATION__CLASS_NAME:
				setClassName(CLASS_NAME_EDEFAULT);
				return;
			case OperationsPackage.EXTRACT_CLASS_OPERATION__TARGET_PACKAGE:
				setTargetPackage((ModelElementId)null);
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
			case OperationsPackage.EXTRACT_CLASS_OPERATION__CONTEXT_CLASS:
				return contextClass != null;
			case OperationsPackage.EXTRACT_CLASS_OPERATION__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case OperationsPackage.EXTRACT_CLASS_OPERATION__OUTGOING_ASSOCIATIONS:
				return outgoingAssociations != null && !outgoingAssociations.isEmpty();
			case OperationsPackage.EXTRACT_CLASS_OPERATION__INCOMING_ASSOCIATIONS:
				return incomingAssociations != null && !incomingAssociations.isEmpty();
			case OperationsPackage.EXTRACT_CLASS_OPERATION__COMPOSITION_NAME:
				return COMPOSITION_NAME_EDEFAULT == null ? compositionName != null : !COMPOSITION_NAME_EDEFAULT.equals(compositionName);
			case OperationsPackage.EXTRACT_CLASS_OPERATION__CLASS_NAME:
				return CLASS_NAME_EDEFAULT == null ? className != null : !CLASS_NAME_EDEFAULT.equals(className);
			case OperationsPackage.EXTRACT_CLASS_OPERATION__TARGET_PACKAGE:
				return targetPackage != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (compositionName: ");
		result.append(compositionName);
		result.append(", className: ");
		result.append(className);
		result.append(')');
		return result.toString();
	}

	public void semanticApply(Project project) {
		Class contextClass = getContextClass(project);
		List<Attribute> attributes = getAttributes(project);
		List<Association> outgoingAssociations = getOutgoingAssociations(project);
		List<Association> incomingAssociations = getIncomingAssociations(project);
		Package targetPackage = getTargetPackage(project);
		String className = getClassName();
		String compositionName = getCompositionName();

		// create extracted class
		Class extractedClass = ClassesFactory.eINSTANCE.createClass();
		targetPackage.getContainedPackageElements().add(extractedClass);
		extractedClass.setName(className);

		// create composition
		Association composition = ClassesFactory.eINSTANCE.createAssociation();
		project.addModelElement(composition);
		composition.setType(AssociationType.COMPOSITION);
		composition.setName(compositionName);
		composition.setSource(contextClass);
		composition.setSourceRole(OperationHelper.firstLower(contextClass.getName()));
		composition.setSourceMultiplicity("1");
		composition.setTarget(extractedClass);
		composition.setTargetRole(compositionName);
		composition.setTargetMultiplicity("1");

		// move attributes and associations
		extractedClass.getAttributes().addAll(attributes);
		for (Association association : outgoingAssociations) {
			association.setSource(extractedClass);
		}
		for (Association association : incomingAssociations) {
			association.setTarget(extractedClass);
		}
	}

} // ExtractClassOperationImpl
