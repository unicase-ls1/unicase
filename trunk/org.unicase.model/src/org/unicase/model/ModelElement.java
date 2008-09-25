/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model;

import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.document.LeafSection;
import org.unicase.model.task.util.CircularDependencyException;
import org.unicase.model.task.util.MEState;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Element</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.ModelElement#getName <em>Name</em>}</li>
 *   <li>{@link org.unicase.model.ModelElement#getDescription <em>Description</em>}</li>
 *   <li>{@link org.unicase.model.ModelElement#getCreator <em>Creator</em>}</li>
 *   <li>{@link org.unicase.model.ModelElement#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link org.unicase.model.ModelElement#getLastModifier <em>Last Modifier</em>}</li>
 *   <li>{@link org.unicase.model.ModelElement#getLastModifiedDate <em>Last Modified Date</em>}</li>
 *   <li>{@link org.unicase.model.ModelElement#getStringReaderInfos <em>String Reader Infos</em>}</li>
 *   <li>{@link org.unicase.model.ModelElement#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.unicase.model.ModelElement#getIncomingDocumentReferences <em>Incoming Document References</em>}</li>
 *   <li>{@link org.unicase.model.ModelElement#getLeafSection <em>Leaf Section</em>}</li>
 *   <li>{@link org.unicase.model.ModelElement#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.ModelPackage#getModelElement()
 * @model abstract="true"
 * @generated
 */
public interface ModelElement extends IdentifiableElement {
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
	 * @see org.unicase.model.ModelPackage#getModelElement_Name()
	 * @model 
	 *        annotation="http://unicase.org/visibility VisibilityValue='MANDATORY'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.unicase.model.ModelElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
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
	 * @see org.unicase.model.ModelPackage#getModelElement_Description()
	 * @model 
	 *        annotation="http://unicase.org/visibility VisibilityValue='VIEWWHENSET'"
	 *        annotation="http://unicase.org/UIHints type='TEXT_AREA'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.unicase.model.ModelElement#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creator</em>' attribute.
	 * @see #setCreator(String)
	 * @see org.unicase.model.ModelPackage#getModelElement_Creator()
	 * @model
	 * @generated
	 */
	String getCreator();

	/**
	 * Sets the value of the '{@link org.unicase.model.ModelElement#getCreator <em>Creator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creator</em>' attribute.
	 * @see #getCreator()
	 * @generated
	 */
	void setCreator(String value);

	/**
	 * Returns the value of the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creation Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creation Date</em>' attribute.
	 * @see #setCreationDate(Date)
	 * @see org.unicase.model.ModelPackage#getModelElement_CreationDate()
	 * @model
	 * @generated
	 */
	Date getCreationDate();

	/**
	 * Sets the value of the '{@link org.unicase.model.ModelElement#getCreationDate <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creation Date</em>' attribute.
	 * @see #getCreationDate()
	 * @generated
	 */
	void setCreationDate(Date value);

	/**
	 * Returns the value of the '<em><b>Last Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Modifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Modifier</em>' attribute.
	 * @see #setLastModifier(String)
	 * @see org.unicase.model.ModelPackage#getModelElement_LastModifier()
	 * @model
	 * @generated
	 */
	String getLastModifier();

	/**
	 * Sets the value of the '{@link org.unicase.model.ModelElement#getLastModifier <em>Last Modifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Modifier</em>' attribute.
	 * @see #getLastModifier()
	 * @generated
	 */
	void setLastModifier(String value);

	/**
	 * Returns the value of the '<em><b>Last Modified Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Modified Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Modified Date</em>' attribute.
	 * @see #setLastModifiedDate(Date)
	 * @see org.unicase.model.ModelPackage#getModelElement_LastModifiedDate()
	 * @model
	 * @generated
	 */
	Date getLastModifiedDate();

	/**
	 * Sets the value of the '{@link org.unicase.model.ModelElement#getLastModifiedDate <em>Last Modified Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Modified Date</em>' attribute.
	 * @see #getLastModifiedDate()
	 * @generated
	 */
	void setLastModifiedDate(Date value);

	/**
	 * Returns the value of the '<em><b>String Reader Infos</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Reader Infos</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Reader Infos</em>' attribute list.
	 * @see org.unicase.model.ModelPackage#getModelElement_StringReaderInfos()
	 * @model changeable="false"
	 * @generated
	 */
	EList<String> getStringReaderInfos();

	/**
	 * Returns the value of the '<em><b>Annotations</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.Annotation}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.Annotation#getAnnotatedModelElements <em>Annotated Model Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotations</em>' reference list.
	 * @see org.unicase.model.ModelPackage#getModelElement_Annotations()
	 * @see org.unicase.model.Annotation#getAnnotatedModelElements
	 * @model opposite="annotatedModelElements" keys="identifier"
	 * @generated
	 */
	EList<Annotation> getAnnotations();

	/**
	 * Returns the value of the '<em><b>Incoming Document References</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.document.LeafSection}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.document.LeafSection#getReferencedModelElements <em>Referenced Model Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Document References</em>' reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Document References</em>' reference list.
	 * @see org.unicase.model.ModelPackage#getModelElement_IncomingDocumentReferences()
	 * @see org.unicase.model.document.LeafSection#getReferencedModelElements
	 * @model opposite="referencedModelElements" keys="identifier"
	 * @generated
	 */
	EList<LeafSection> getIncomingDocumentReferences();

	/**
	 * Returns the value of the '<em><b>Leaf Section</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.document.LeafSection#getModelElements <em>Model Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Leaf Section</em>' container reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Leaf Section</em>' container reference.
	 * @see #setLeafSection(LeafSection)
	 * @see org.unicase.model.ModelPackage#getModelElement_LeafSection()
	 * @see org.unicase.model.document.LeafSection#getModelElements
	 * @model opposite="modelElements" keys="identifier" transient="false"
	 * @generated
	 */
	LeafSection getLeafSection();

	/**
	 * Sets the value of the '{@link org.unicase.model.ModelElement#getLeafSection <em>Leaf Section</em>}' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Leaf Section</em>' container reference.
	 * @see #getLeafSection()
	 * @generated
	 */
	void setLeafSection(LeafSection value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.unicase.model.ModelPackage#getModelElement_State()
	 * @model default="" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getState();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Project getProject();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addReader(String acOrgId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws CircularDependencyException 
	 * @model kind="operation"
	 * @generated NOT
	 * @return MEState
	 * @throws CircularDependencyException if there is a circular dependency
	 */
	MEState getMEState() throws CircularDependencyException;

	/**
	 * @generated
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 */
	ModelElementId getModelElementId();

} // ModelElement
