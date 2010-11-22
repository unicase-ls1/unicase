/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.examples.mindmap;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Resource#getComments <em>Comments</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Resource#getEmail <em>Email</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Resource#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Resource#getTopics <em>Topics</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getResource()
 * @model extendedMetaData="name='Resource' kind='empty'"
 * @generated
 */
public interface Resource extends EObject {
	/**
	 * Returns the value of the '<em><b>Comments</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.mindmap.Thread}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.examples.mindmap.Thread#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comments</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comments</em>' reference list.
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getResource_Comments()
	 * @see org.eclipse.gmf.examples.mindmap.Thread#getAuthor
	 * @model opposite="author"
	 *        extendedMetaData="kind='attribute' name='comments'"
	 * @generated
	 */
	EList<org.eclipse.gmf.examples.mindmap.Thread> getComments();

	/**
	 * Returns the value of the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Email</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Email</em>' attribute.
	 * @see #setEmail(String)
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getResource_Email()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='email'"
	 * @generated
	 */
	String getEmail();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.mindmap.Resource#getEmail <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Email</em>' attribute.
	 * @see #getEmail()
	 * @generated
	 */
	void setEmail(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getResource_Name()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.mindmap.Resource#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Topics</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.mindmap.Topic}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.examples.mindmap.Topic#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Topics</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Topics</em>' reference list.
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getResource_Topics()
	 * @see org.eclipse.gmf.examples.mindmap.Topic#getResources
	 * @model opposite="resources"
	 *        extendedMetaData="kind='attribute' name='topics'"
	 * @generated
	 */
	EList<Topic> getTopics();

} // Resource
