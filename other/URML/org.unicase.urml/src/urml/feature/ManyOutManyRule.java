/**
 * <copyright> </copyright> $Id$
 */
package urml.feature;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Many Out Many Rule</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link urml.feature.ManyOutManyRule#getConstraint <em>Constraint</em>}</li>
 * </ul>
 * </p>
 * 
 * @see urml.feature.FeaturePackage#getManyOutManyRule()
 * @model
 * @generated
 */
public interface ManyOutManyRule extends VariationPointRule {
	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint</em>' attribute.
	 * @see #setConstraint(int)
	 * @see urml.feature.FeaturePackage#getManyOutManyRule_Constraint()
	 * @model
	 * @generated
	 */
	int getConstraint();

	/**
	 * Sets the value of the '{@link urml.feature.ManyOutManyRule#getConstraint <em>Constraint</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Constraint</em>' attribute.
	 * @see #getConstraint()
	 * @generated
	 */
	void setConstraint(int value);

} // ManyOutManyRule
