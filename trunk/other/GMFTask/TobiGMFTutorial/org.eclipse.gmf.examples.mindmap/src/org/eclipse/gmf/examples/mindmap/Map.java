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
 * A representation of the model object '<em><b>Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Map#getRootTopics <em>Root Topics</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Map#getRelations <em>Relations</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Map#getResources <em>Resources</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Map#getTitle <em>Title</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getMap()
 * @model extendedMetaData="name='Map' kind='elementOnly'"
 * @generated
 */
public interface Map extends EObject {
	/**
	 * Returns the value of the '<em><b>Root Topics</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.mindmap.Topic}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Topics</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Topics</em>' containment reference list.
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getMap_RootTopics()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='rootTopics'"
	 * @generated
	 */
	EList<Topic> getRootTopics();

	/**
	 * Returns the value of the '<em><b>Relations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.mindmap.Relationship}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relations</em>' containment reference list.
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getMap_Relations()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='relations'"
	 * @generated
	 */
	EList<Relationship> getRelations();

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.mindmap.Resource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getMap_Resources()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='resources'"
	 * @generated
	 */
	EList<Resource> getResources();

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getMap_Title()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='title'"
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.mindmap.Map#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

} // Map
