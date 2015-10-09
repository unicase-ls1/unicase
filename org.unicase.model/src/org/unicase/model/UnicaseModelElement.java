/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model;

import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.view.spi.model.ModelChangeListener;
import org.eclipse.emf.emfstore.internal.common.model.ModelElementId;
import org.unicase.model.document.LeafSection;
import org.unicase.model.profile.StereotypeInstance;
import org.unicase.model.rationale.Comment;
import org.unicase.model.task.util.CircularDependencyException;
import org.unicase.model.task.util.MEState;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Element</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.UnicaseModelElement#getName <em>Name</em>}</li>
 * <li>{@link org.unicase.model.UnicaseModelElement#getDescription <em>
 * Description</em>}</li>
 * <li>{@link org.unicase.model.UnicaseModelElement#getAnnotations <em>
 * Annotations</em>}</li>
 * <li>{@link org.unicase.model.UnicaseModelElement#getAttachments <em>
 * Attachments</em>}</li>
 * <li>
 * {@link org.unicase.model.UnicaseModelElement#getIncomingDocumentReferences
 * <em>Incoming Document References</em>}</li>
 * <li>{@link org.unicase.model.UnicaseModelElement#getState <em>State</em>}</li>
 * <li>
 * {@link org.unicase.model.UnicaseModelElement#getAppliedStereotypeInstances
 * <em>Applied Stereotype Instances</em>}</li>
 * <li>{@link org.unicase.model.UnicaseModelElement#getComments <em>Comments
 * </em>}</li>
 * <li>{@link org.unicase.model.UnicaseModelElement#getCreationDate <em>Creation
 * Date</em>}</li>
 * <li>{@link org.unicase.model.UnicaseModelElement#getCreator <em>Creator</em>}
 * </li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.ModelPackage#getUnicaseModelElement()
 * @model abstract="true"
 * @generated
 */
public interface UnicaseModelElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.unicase.model.ModelPackage#getUnicaseModelElement_Name()
	 * @model 
	 *        annotation="org.eclipse.emf.ecp.editor priority='1.0' position='left'"
	 * @generated
	 */
	String getName();

	/**
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.unicase.model.ModelPackage#getUnicaseModelElement_Description()
	 * @model 
	 *        annotation="org.eclipse.emf.ecp.editor priority='1.0' position='left'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.model.UnicaseModelElement#getDescription
	 * <em>Description</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Annotations</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.Annotation}. It is
	 * bidirectional and its opposite is '
	 * {@link org.unicase.model.Annotation#getAnnotatedModelElements
	 * <em>Annotated Model Elements</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Annotations</em>' reference list.
	 * @see org.unicase.model.ModelPackage#getUnicaseModelElement_Annotations()
	 * @see org.unicase.model.Annotation#getAnnotatedModelElements
	 * @model opposite="annotatedModelElements" annotation=
	 *        "org.eclipse.emf.ecp.editor priority='100.0' position='right'"
	 * @generated
	 */
	EList<Annotation> getAnnotations();

	/**
	 * Returns the value of the '<em><b>Attachments</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.Attachment}. It is
	 * bidirectional and its opposite is '
	 * {@link org.unicase.model.Attachment#getReferringModelElements
	 * <em>Referring Model Elements</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attachments</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Attachments</em>' reference list.
	 * @see org.unicase.model.ModelPackage#getUnicaseModelElement_Attachments()
	 * @see org.unicase.model.Attachment#getReferringModelElements
	 * @model opposite="referringModelElements" annotation=
	 *        "org.eclipse.emf.ecp.editor priority='101.0' position='right'"
	 * @generated
	 */
	EList<Attachment> getAttachments();

	/**
	 * Returns the value of the '<em><b>Incoming Document References</b></em>'
	 * reference list. The list contents are of type
	 * {@link org.unicase.model.document.LeafSection}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Document References</em>' reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Incoming Document References</em>'
	 *         reference list.
	 * @see org.unicase.model.ModelPackage#getUnicaseModelElement_IncomingDocumentReferences()
	 * @model annotation=
	 *        "org.eclipse.emf.ecp.editor priority='102.0' position='right'"
	 * @generated
	 */
	EList<LeafSection> getIncomingDocumentReferences();

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute. The default
	 * value is <code>""</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.unicase.model.ModelPackage#getUnicaseModelElement_State()
	 * @model default="" transient="true" changeable="false" volatile="true"
	 *        derived="true"
	 * @generated
	 */
	String getState();

	/**
	 * Returns the value of the '<em><b>Applied Stereotype Instances</b></em>'
	 * containment reference list. The list contents are of type
	 * {@link org.unicase.model.profile.StereotypeInstance}. It is bidirectional
	 * and its opposite is '
	 * {@link org.unicase.model.profile.StereotypeInstance#getModelElement
	 * <em>Model Element</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applied Stereotype Instances</em>' containment
	 * reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Applied Stereotype Instances</em>'
	 *         containment reference list.
	 * @see org.unicase.model.ModelPackage#getUnicaseModelElement_AppliedStereotypeInstances()
	 * @see org.unicase.model.profile.StereotypeInstance#getModelElement
	 * @model opposite="modelElement" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<StereotypeInstance> getAppliedStereotypeInstances();

	/**
	 * Returns the value of the '<em><b>Comments</b></em>' containment reference
	 * list. The list contents are of type
	 * {@link org.unicase.model.rationale.Comment}. It is bidirectional and its
	 * opposite is '
	 * {@link org.unicase.model.rationale.Comment#getCommentedElement
	 * <em>Commented Element</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comments</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Comments</em>' containment reference list.
	 * @see org.unicase.model.ModelPackage#getUnicaseModelElement_Comments()
	 * @see org.unicase.model.rationale.Comment#getCommentedElement
	 * @model opposite="commentedElement" containment="true"
	 *        resolveProxies="true"
	 *        annotation="org.eclipse.emf.ecp.editor priority='2.0' position='left'"
	 * @generated
	 */
	EList<Comment> getComments();

	/**
	 * Returns the value of the '<em><b>Creator</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creator</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Creator</em>' attribute.
	 * @see org.unicase.model.ModelPackage#getUnicaseModelElement_Creator()
	 * @model changeable="false"
	 * @generated
	 */
	String getCreator();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.model.UnicaseModelElement#getCreator <em>Creator</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Creator</em>' attribute.
	 * @see #getCreator()
	 * @generated NOT
	 */
	void setCreator(String value);

	/**
	 * Returns the value of the '<em><b>Creation Date</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creation Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Creation Date</em>' attribute.
	 * @see org.unicase.model.ModelPackage#getUnicaseModelElement_CreationDate()
	 * @model changeable="false"
	 * @generated
	 */
	Date getCreationDate();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.model.UnicaseModelElement#getCreationDate
	 * <em>Creation Date</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Creation Date</em>' attribute.
	 * @see #getCreationDate()
	 * @generated NOT
	 */
	void setCreationDate(Date value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @throws CircularDependencyException
	 * @model kind="operation"
	 * @generated NOT
	 * @return MEState
	 * @throws CircularDependencyException
	 *             if there is a circular dependency
	 */
	MEState getMEState() throws CircularDependencyException;

	// begin custom code

	/**
	 * Add a model element change listener.
	 *
	 * @param listener
	 *            listener to add.
	 */
	void addModelElementChangeListener(ModelChangeListener listener);

	/**
	 * Remove a model element change listener.
	 *
	 * @param listener
	 *            the listener to remove
	 */
	void removeModelElementChangeListener(ModelChangeListener listener);

	/**
	 * Returns the ID of this model element.
	 * 
	 * @return the model's ID
	 */
	ModelElementId getModelElementId();

	// end custom code

} // UnicaseModelElement
