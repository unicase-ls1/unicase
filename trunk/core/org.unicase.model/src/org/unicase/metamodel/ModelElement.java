/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel;

import java.util.Date;
import java.util.Set;

import org.unicase.model.util.ModelElementChangeListener;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Element</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.ModelElement#getName <em>Name</em>}</li>
 * <li>{@link org.unicase.model.ModelElement#getDescription <em>Description</em>}</li>
 * <li>{@link org.unicase.model.ModelElement#getCreator <em>Creator</em>}</li>
 * <li>{@link org.unicase.model.ModelElement#getCreationDate <em>Creation Date</em>}</li>
 * <li>{@link org.unicase.model.ModelElement#getAnnotations <em>Annotations</em>}</li>
 * <li>{@link org.unicase.model.ModelElement#getAttachments <em>Attachments</em>}</li>
 * <li>{@link org.unicase.model.ModelElement#getIncomingDocumentReferences <em>Incoming Document References</em>}</li>
 * <li>{@link org.unicase.model.ModelElement#getLeafSection <em>Leaf Section</em>}</li>
 * <li>{@link org.unicase.model.ModelElement#getState <em>State</em>}</li>
 * <li>{@link org.unicase.model.ModelElement#getAppliedStereotypeInstances <em>Applied Stereotype Instances</em>}</li>
 * <li>{@link org.unicase.model.ModelElement#getComments <em>Comments</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.ModelPackage#getModelElement()
 * @model abstract="true"
 * @generated
 */
public interface ModelElement extends IdentifiableElement {

	/**
	 * Returns the value of the '<em><b>Creator</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creator</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Creator</em>' attribute.
	 * @see #setCreator(String)
	 * @see org.unicase.model.ModelPackage#getModelElement_Creator()
	 * @model
	 * @generated
	 */
	String getCreator();

	/**
	 * Sets the value of the '{@link org.unicase.model.ModelElement#getCreator <em>Creator</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Creator</em>' attribute.
	 * @see #getCreator()
	 * @generated
	 */
	void setCreator(String value);

	/**
	 * Returns the value of the '<em><b>Creation Date</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creation Date</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Creation Date</em>' attribute.
	 * @see #setCreationDate(Date)
	 * @see org.unicase.model.ModelPackage#getModelElement_CreationDate()
	 * @model
	 * @generated
	 */
	Date getCreationDate();

	/**
	 * Sets the value of the '{@link org.unicase.model.ModelElement#getCreationDate <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Creation Date</em>' attribute.
	 * @see #getCreationDate()
	 * @generated
	 */
	void setCreationDate(Date value);

	/**
	 * Retrieve all elements this element links to. Only outgoing and bidrectional links are considered.
	 * 
	 * @return a set of model elements
	 */
	Set<ModelElement> getLinkedModelElements();

	/**
	 * Retrieve the contained model elements of this element. Only includes direct children.
	 * 
	 * @return a set of child model elements
	 */
	Set<ModelElement> getContainedElements();

	/**
	 * Get the container model element of this element. Returns null if there is no parent.
	 * 
	 * @return the parent element
	 */
	ModelElement getContainerModelElement();

	/**
	 * Get all contained element of this element recursivly.
	 * 
	 * @return a set of model elements
	 */
	Set<ModelElement> getAllContainedModelElements();

	/**
	 * Get all model elements that are cross referenced by this element.
	 * 
	 * @return a set of model elements
	 */
	Set<ModelElement> getCrossReferencedModelElements();

	/**
	 * Delete the model element from its project.
	 */
	void delete();

	// end custom code

	/**
	 * Get the id of a model element.
	 * 
	 * @return the id
	 */
	ModelElementId getModelElementId();

	/**
	 * Return the project of a model element if any.
	 * 
	 * @return the project or null if the model element is not in a project
	 */
	Project getProject();

	/**
	 * Add a model element change listener.
	 * 
	 * @param listener listener to add.
	 */
	void addModelElementChangeListener(ModelElementChangeListener listener);

	/**
	 * Remove a model element change listener.
	 * 
	 * @param listener the listener to remove
	 */
	void removeModelElementChangeListener(ModelElementChangeListener listener);

} // ModelElement
