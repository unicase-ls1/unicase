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
import org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.impl.SemanticCompositeOperationImpl;
import org.unicase.implementation.operations.ExtractSuperClassOperation;
import org.unicase.implementation.operations.OperationsPackage;
import org.unicase.implementation.operations.util.OperationHelper;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.Attribute;
import org.unicase.model.classes.Class;
import org.unicase.model.classes.ClassesFactory;
import org.unicase.model.classes.Enumeration;
import org.unicase.model.classes.InstantiationType;
import org.unicase.model.classes.Package;
import org.unicase.model.classes.PackageElement;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Extract Super Class Operation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.implementation.operations.impl.ExtractSuperClassOperationImpl#getSubClasses <em>Sub Classes</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.impl.ExtractSuperClassOperationImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.impl.ExtractSuperClassOperationImpl#getOutgoingAssociations <em>Outgoing Associations</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.impl.ExtractSuperClassOperationImpl#getIncomingAssociations <em>Incoming Associations</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.impl.ExtractSuperClassOperationImpl#getSuperClassName <em>Super Class Name</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.impl.ExtractSuperClassOperationImpl#getTargetPackage <em>Target Package</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.impl.ExtractSuperClassOperationImpl#getSuperSuperClasses <em>Super Super Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtractSuperClassOperationImpl extends SemanticCompositeOperationImpl implements
	ExtractSuperClassOperation {
	/**
	 * The cached value of the '{@link #getSubClasses() <em>Sub Classes</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSubClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElementId> subClasses;

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
	 * The default value of the '{@link #getSuperClassName() <em>Super Class Name</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getSuperClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String SUPER_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuperClassName() <em>Super Class Name</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getSuperClassName()
	 * @generated
	 * @ordered
	 */
	protected String superClassName = SUPER_CLASS_NAME_EDEFAULT;

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
	 * The cached value of the '{@link #getSuperSuperClasses() <em>Super Super Classes</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSuperSuperClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElementId> superSuperClasses;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtractSuperClassOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.EXTRACT_SUPER_CLASS_OPERATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementId> getSubClasses() {
		if (subClasses == null) {
			subClasses = new EObjectContainmentEList<ModelElementId>(ModelElementId.class, this, OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUB_CLASSES);
		}
		return subClasses;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementId> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<ModelElementId>(ModelElementId.class, this, OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementId> getOutgoingAssociations() {
		if (outgoingAssociations == null) {
			outgoingAssociations = new EObjectContainmentEList<ModelElementId>(ModelElementId.class, this, OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__OUTGOING_ASSOCIATIONS);
		}
		return outgoingAssociations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementId> getIncomingAssociations() {
		if (incomingAssociations == null) {
			incomingAssociations = new EObjectContainmentEList<ModelElementId>(ModelElementId.class, this, OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__INCOMING_ASSOCIATIONS);
		}
		return incomingAssociations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSuperClassName() {
		return superClassName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperClassName(String newSuperClassName) {
		String oldSuperClassName = superClassName;
		superClassName = newSuperClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUPER_CLASS_NAME, oldSuperClassName, superClassName));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__TARGET_PACKAGE, oldTargetPackage, newTargetPackage);
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
				msgs = ((InternalEObject)targetPackage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__TARGET_PACKAGE, null, msgs);
			if (newTargetPackage != null)
				msgs = ((InternalEObject)newTargetPackage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__TARGET_PACKAGE, null, msgs);
			msgs = basicSetTargetPackage(newTargetPackage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__TARGET_PACKAGE, newTargetPackage, newTargetPackage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementId> getSuperSuperClasses() {
		if (superSuperClasses == null) {
			superSuperClasses = new EObjectContainmentEList<ModelElementId>(ModelElementId.class, this, OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUPER_SUPER_CLASSES);
		}
		return superSuperClasses;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<org.unicase.model.classes.Class> getSubClasses(Project project) {
		return OperationHelper.getElements(project, getSubClasses());
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
	 * {@inheritDoc}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Attribute> getPossibleAttributes(Project project) {
		List<Class> subClasses = getSubClasses(project);
		List<Attribute> attributes = getAttributes(project);

		return PullUpOperationImpl.getPossibleAttributes(attributes, subClasses);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Association> getOutgoingAssociations(Project project) {
		return OperationHelper.getElements(project, getOutgoingAssociations());
	}

	/**
	 * {@inheritDoc}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Association> getPossibleOutgoingAssociations(Project project) {
		List<Association> associations = getOutgoingAssociations(project);
		List<Class> subClasses = getSubClasses(project);

		return PullUpOperationImpl.getPossibleOutgoingAssociations(associations, subClasses);
	}
	
	/**
	 * {@inheritDoc}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Association> getPossibleIncomingAssociations(Project project) {
		List<Association> associations = getIncomingAssociations(project);
		List<Class> subClasses = getSubClasses(project);

		return PullUpOperationImpl.getPossibleIncomingAssociations(associations, subClasses);
	}

	
	// end of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Association> getIncomingAssociations(Project project) {
		return OperationHelper.getElements(project, getIncomingAssociations());
	}


	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public org.unicase.model.classes.Package getTargetPackage(Project project) {
		return OperationHelper.getElement(project, getTargetPackage());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<org.unicase.model.classes.Class> getSuperSuperClasses(Project project) {
		return OperationHelper.getElements(project, getSuperSuperClasses());
	}

	// begin of custom code
	/**
	 * Retrieve all Super super classes that could be selected. {@inheritDoc} <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated NOT
	 */
	public EList<Class> getPossibleSuperSuperClasses(Project project) {
		Iterator<Class> i = getSubClasses(project).iterator();
		EList<Class> classes = new BasicEList<Class>(i.next().getSuperClasses());
		while (i.hasNext()) {
			Class subClass = i.next();
			for (Iterator<Class> j = classes.iterator(); j.hasNext();) {
				Class c = j.next();
				if (!subClass.getSuperClasses().contains(c)) {
					j.remove();
				}
			}
		}
		return classes;
	}

	/**
	 * {@inheritDoc}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateSuperClassName(Project project) {
		Package targetPackage = getTargetPackage(project);
		String superClassName = getSuperClassName();

		if (superClassName != null && targetPackage != null) {
			for (PackageElement element : targetPackage.getContainedPackageElements()) {
				if (element instanceof Class || element instanceof Enumeration) {
					if (superClassName.equals(element.getName())) {
						return false;
					}
				}
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
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUB_CLASSES:
				return ((InternalEList<?>)getSubClasses()).basicRemove(otherEnd, msgs);
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__OUTGOING_ASSOCIATIONS:
				return ((InternalEList<?>)getOutgoingAssociations()).basicRemove(otherEnd, msgs);
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__INCOMING_ASSOCIATIONS:
				return ((InternalEList<?>)getIncomingAssociations()).basicRemove(otherEnd, msgs);
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__TARGET_PACKAGE:
				return basicSetTargetPackage(null, msgs);
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUPER_SUPER_CLASSES:
				return ((InternalEList<?>)getSuperSuperClasses()).basicRemove(otherEnd, msgs);
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
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUB_CLASSES:
				return getSubClasses();
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__ATTRIBUTES:
				return getAttributes();
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__OUTGOING_ASSOCIATIONS:
				return getOutgoingAssociations();
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__INCOMING_ASSOCIATIONS:
				return getIncomingAssociations();
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUPER_CLASS_NAME:
				return getSuperClassName();
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__TARGET_PACKAGE:
				return getTargetPackage();
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUPER_SUPER_CLASSES:
				return getSuperSuperClasses();
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
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUB_CLASSES:
				getSubClasses().clear();
				getSubClasses().addAll((Collection<? extends ModelElementId>)newValue);
				return;
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends ModelElementId>)newValue);
				return;
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__OUTGOING_ASSOCIATIONS:
				getOutgoingAssociations().clear();
				getOutgoingAssociations().addAll((Collection<? extends ModelElementId>)newValue);
				return;
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__INCOMING_ASSOCIATIONS:
				getIncomingAssociations().clear();
				getIncomingAssociations().addAll((Collection<? extends ModelElementId>)newValue);
				return;
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUPER_CLASS_NAME:
				setSuperClassName((String)newValue);
				return;
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__TARGET_PACKAGE:
				setTargetPackage((ModelElementId)newValue);
				return;
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUPER_SUPER_CLASSES:
				getSuperSuperClasses().clear();
				getSuperSuperClasses().addAll((Collection<? extends ModelElementId>)newValue);
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
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUB_CLASSES:
				getSubClasses().clear();
				return;
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__ATTRIBUTES:
				getAttributes().clear();
				return;
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__OUTGOING_ASSOCIATIONS:
				getOutgoingAssociations().clear();
				return;
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__INCOMING_ASSOCIATIONS:
				getIncomingAssociations().clear();
				return;
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUPER_CLASS_NAME:
				setSuperClassName(SUPER_CLASS_NAME_EDEFAULT);
				return;
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__TARGET_PACKAGE:
				setTargetPackage((ModelElementId)null);
				return;
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUPER_SUPER_CLASSES:
				getSuperSuperClasses().clear();
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
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUB_CLASSES:
				return subClasses != null && !subClasses.isEmpty();
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__OUTGOING_ASSOCIATIONS:
				return outgoingAssociations != null && !outgoingAssociations.isEmpty();
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__INCOMING_ASSOCIATIONS:
				return incomingAssociations != null && !incomingAssociations.isEmpty();
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUPER_CLASS_NAME:
				return SUPER_CLASS_NAME_EDEFAULT == null ? superClassName != null : !SUPER_CLASS_NAME_EDEFAULT.equals(superClassName);
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__TARGET_PACKAGE:
				return targetPackage != null;
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUPER_SUPER_CLASSES:
				return superSuperClasses != null && !superSuperClasses.isEmpty();
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
		result.append(" (superClassName: ");
		result.append(superClassName);
		result.append(')');
		return result.toString();
	}

	public void semanticApply(Project project) {
		// parameters
		List<Class> subClasses = getSubClasses(project);
		List<Attribute> attributes = getAttributes(project);
		List<Association> outgoingAssociations = getOutgoingAssociations(project);
		List<Association> incomingAssociations = getIncomingAssociations(project);
		Package targetPackage = getTargetPackage(project);
		String superClassName = getSuperClassName();
		List<Class> superSuperClasses = getSuperSuperClasses(project);

		// create super class
		Class superClass = ClassesFactory.eINSTANCE.createClass();
		targetPackage.getContainedPackageElements().add(superClass);
		superClass.setName(superClassName);
		superClass.setInstantiationType(InstantiationType.ABSTRACT);
		superClass.getSuperClasses().addAll(superSuperClasses);
		for (Class subClass : subClasses) {
			subClass.getSuperClasses().removeAll(superSuperClasses);
			subClass.getSuperClasses().add(superClass);
		}

		// pull up attribute and associations
		PullUpOperationImpl.pullUpAttributes(attributes, superClass);
		PullUpOperationImpl.pullUpOutgoingAssociations(outgoingAssociations, superClass);
		PullUpOperationImpl.pullUpIncomingAssociations(incomingAssociations, superClass);
	}

} // ExtractSuperClassOperationImpl
