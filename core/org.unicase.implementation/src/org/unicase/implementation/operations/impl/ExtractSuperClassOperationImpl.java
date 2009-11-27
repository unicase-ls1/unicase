/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
import org.unicase.emfstore.esmodel.versioning.operations.semantic.impl.SemanticCompositeOperationImpl;
import org.unicase.implementation.operations.ExtractSuperClassOperation;
import org.unicase.implementation.operations.OperationsPackage;
import org.unicase.implementation.operations.util.OperationHelper;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.model.implementation.IClass;
import org.unicase.model.implementation.IPackage;
import org.unicase.model.implementation.ImplementationFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extract Super Class Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.implementation.operations.impl.ExtractSuperClassOperationImpl#getSubClasses <em>Sub Classes</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.impl.ExtractSuperClassOperationImpl#getSuperClassName <em>Super Class Name</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.impl.ExtractSuperClassOperationImpl#getTargetPackage <em>Target Package</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.impl.ExtractSuperClassOperationImpl#getSuperSuperClasses <em>Super Super Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtractSuperClassOperationImpl extends SemanticCompositeOperationImpl implements ExtractSuperClassOperation {
	/**
	 * The cached value of the '{@link #getSubClasses() <em>Sub Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElementId> subClasses;

	/**
	 * The default value of the '{@link #getSuperClassName() <em>Super Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String SUPER_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuperClassName() <em>Super Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperClassName()
	 * @generated
	 * @ordered
	 */
	protected String superClassName = SUPER_CLASS_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTargetPackage() <em>Target Package</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetPackage()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId targetPackage;

	/**
	 * The cached value of the '{@link #getSuperSuperClasses() <em>Super Super Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperSuperClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElementId> superSuperClasses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtractSuperClassOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.EXTRACT_SUPER_CLASS_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementId> getSubClasses() {
		if (subClasses == null) {
			subClasses = new EObjectContainmentEList<ModelElementId>(ModelElementId.class, this, OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUB_CLASSES);
		}
		return subClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSuperClassName() {
		return superClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperClassName(String newSuperClassName) {
		String oldSuperClassName = superClassName;
		superClassName = newSuperClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUPER_CLASS_NAME, oldSuperClassName, superClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId getTargetPackage() {
		return targetPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementId> getSuperSuperClasses() {
		if (superSuperClasses == null) {
			superSuperClasses = new EObjectContainmentEList<ModelElementId>(ModelElementId.class, this, OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUPER_SUPER_CLASSES);
		}
		return superSuperClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IClass> getSubClasses(Project project) {
		return OperationHelper.getElements(project, getSubClasses());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPackage getTargetPackage(Project project) {
		return OperationHelper.getElement(project, getTargetPackage());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IClass> getSuperSuperClasses(Project project) {
		return OperationHelper.getElements(project, getSuperSuperClasses());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<IClass> getPossibleSuperSuperClasses(Project project) {
		Iterator<IClass> i = getSubClasses(project).iterator();
		EList<IClass> classes = new BasicEList<IClass>(i.next()
				.getSuperClasses());
		while (i.hasNext()) {
			IClass subClass = i.next();
			for (Iterator<IClass> j = classes.iterator(); j.hasNext();) {
				IClass c = j.next();
				if (!subClass.getSuperClasses().contains(c)) {
					j.remove();
				}
			}
		}
		return classes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUB_CLASSES:
				return ((InternalEList<?>)getSubClasses()).basicRemove(otherEnd, msgs);
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__TARGET_PACKAGE:
				return basicSetTargetPackage(null, msgs);
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUPER_SUPER_CLASSES:
				return ((InternalEList<?>)getSuperSuperClasses()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUB_CLASSES:
				return getSubClasses();
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUB_CLASSES:
				getSubClasses().clear();
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION__SUB_CLASSES:
				return subClasses != null && !subClasses.isEmpty();
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
		List<IClass> subClasses = getSubClasses(project);
		IPackage targetPackage = getTargetPackage(project);
		String superClassName = getSuperClassName();
		List<IClass> superSuperClasses = getSuperSuperClasses(project);
		
		IClass superClass = ImplementationFactory.eINSTANCE.createIClass();
		targetPackage.getClasses().add(superClass);
		superClass.setName(superClassName);
		superClass.setAbstract(true);
		superClass.getSuperClasses().addAll(superSuperClasses);

		for (IClass subClass : subClasses) {
			subClass.getSuperClasses().removeAll(superSuperClasses);
			subClass.getSuperClasses().add(superClass);
		}
	}

} //ExtractSuperClassOperationImpl
