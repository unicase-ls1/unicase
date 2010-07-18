/**
 * <copyright> </copyright> $Id$
 */
package urml.goal;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Type</b></em>', and utility
 * methods for working with them. <!-- end-user-doc -->
 * 
 * @see urml.goal.GoalPackage#getGoalType()
 * @model
 * @generated
 */
public enum GoalType implements Enumerator {
	/**
	 * The '<em><b>BUSINESS GOAL</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #BUSINESS_GOAL_VALUE
	 * @generated
	 * @ordered
	 */
	BUSINESS_GOAL(0, "BUSINESS_GOAL", "Business Goal"),

	/**
	 * The '<em><b>PRODUCT GOAL</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #PRODUCT_GOAL_VALUE
	 * @generated
	 * @ordered
	 */
	PRODUCT_GOAL(1, "PRODUCT_GOAL", "Product Goal"),

	/**
	 * The '<em><b>CUSTOMER GOAL</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #CUSTOMER_GOAL_VALUE
	 * @generated
	 * @ordered
	 */
	CUSTOMER_GOAL(2, "CUSTOMER_GOAL", "Customer Goal"),

	/**
	 * The '<em><b>END USER GOAL</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #END_USER_GOAL_VALUE
	 * @generated
	 * @ordered
	 */
	END_USER_GOAL(3, "END_USER_GOAL", "End User Goal");

	/**
	 * The '<em><b>BUSINESS GOAL</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BUSINESS GOAL</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #BUSINESS_GOAL
	 * @model literal="Business Goal"
	 * @generated
	 * @ordered
	 */
	public static final int BUSINESS_GOAL_VALUE = 0;

	/**
	 * The '<em><b>PRODUCT GOAL</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PRODUCT GOAL</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #PRODUCT_GOAL
	 * @model literal="Product Goal"
	 * @generated
	 * @ordered
	 */
	public static final int PRODUCT_GOAL_VALUE = 1;

	/**
	 * The '<em><b>CUSTOMER GOAL</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CUSTOMER GOAL</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #CUSTOMER_GOAL
	 * @model literal="Customer Goal"
	 * @generated
	 * @ordered
	 */
	public static final int CUSTOMER_GOAL_VALUE = 2;

	/**
	 * The '<em><b>END USER GOAL</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>END USER GOAL</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #END_USER_GOAL
	 * @model literal="End User Goal"
	 * @generated
	 * @ordered
	 */
	public static final int END_USER_GOAL_VALUE = 3;

	/**
	 * An array of all the '<em><b>Type</b></em>' enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final GoalType[] VALUES_ARRAY = new GoalType[] { BUSINESS_GOAL, PRODUCT_GOAL, CUSTOMER_GOAL,
		END_USER_GOAL, };

	/**
	 * A public read-only list of all the '<em><b>Type</b></em>' enumerators. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public static final List<GoalType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Type</b></em>' literal with the specified literal value. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static GoalType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GoalType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type</b></em>' literal with the specified name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static GoalType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GoalType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type</b></em>' literal with the specified integer value. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static GoalType get(int value) {
		switch (value) {
		case BUSINESS_GOAL_VALUE:
			return BUSINESS_GOAL;
		case PRODUCT_GOAL_VALUE:
			return PRODUCT_GOAL;
		case CUSTOMER_GOAL_VALUE:
			return CUSTOMER_GOAL;
		case END_USER_GOAL_VALUE:
			return END_USER_GOAL;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private GoalType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} // GoalType
