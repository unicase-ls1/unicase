/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Performance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.requirements.Performance#getProblemSize <em>Problem Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.RequirementsPackage#getPerformance()
 * @model
 * @generated
 */
public interface Performance extends Requirement {
	/**
	 * Returns the value of the '<em><b>Problem Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Problem Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Problem Size</em>' attribute.
	 * @see #setProblemSize(String)
	 * @see scrm.requirements.RequirementsPackage#getPerformance_ProblemSize()
	 * @model annotation="org.unicase.ui.meeditor position='left' priority='5'"
	 * @generated
	 */
	String getProblemSize();

	/**
	 * Sets the value of the '{@link scrm.requirements.Performance#getProblemSize <em>Problem Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Problem Size</em>' attribute.
	 * @see #getProblemSize()
	 * @generated
	 */
	void setProblemSize(String value);

} // Performance
