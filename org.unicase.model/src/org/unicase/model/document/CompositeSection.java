/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.document;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.document.CompositeSection#getSubsections <em>Subsections</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.document.DocumentPackage#getCompositeSection()
 * @model
 * @generated
 */
public interface CompositeSection extends Section {
	/**
	 * Returns the value of the '<em><b>Subsections</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.document.Section}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.document.Section#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subsections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subsections</em>' containment reference list.
	 * @see org.unicase.model.document.DocumentPackage#getCompositeSection_Subsections()
	 * @see org.unicase.model.document.Section#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<Section> getSubsections();

} // CompositeSection
