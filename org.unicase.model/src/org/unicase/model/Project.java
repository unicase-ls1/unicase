/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model;

import java.util.Collection;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Project</b></em>'.
 * @implements IAdaptable
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.Project#getModelElements <em>Model Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.ModelPackage#getProject()
 * @model
 * @generated
 */
public interface Project extends EObject, IAdaptable {
	/**
	 * Returns the value of the '<em><b>Model Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.ModelElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Elements</em>' containment reference list.
	 * @see org.unicase.model.ModelPackage#getProject_ModelElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelElement> getModelElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addModelElement(ModelElement modelElement);

	/**
	 * @param elementClass
	 * @return
	 * * @generated NOT
	 */
	Collection<ModelElement> getElementsByClass(
			Class<? extends EObject> elementClass);

} // Project
