/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package traceRecovery;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link traceRecovery.Query#getModelElement <em>Model Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see traceRecovery.TraceRecoveryPackage#getQuery()
 * @model
 * @generated
 */
public interface Query extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Model Element</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.UnicaseModelElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Element</em>' reference list.
	 * @see traceRecovery.TraceRecoveryPackage#getQuery_ModelElement()
	 * @model
	 * @generated
	 */
	EList<UnicaseModelElement> getModelElements();

} // Query
