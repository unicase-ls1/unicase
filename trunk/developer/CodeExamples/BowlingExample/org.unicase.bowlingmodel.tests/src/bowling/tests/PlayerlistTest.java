/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package bowling.tests;

import bowling.BowlingFactory;
import bowling.Playerlist;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Playerlist</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PlayerlistTest extends TestCase {

	/**
	 * The fixture for this Playerlist test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Playerlist fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PlayerlistTest.class);
	}

	/**
	 * Constructs a new Playerlist test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlayerlistTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Playerlist test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Playerlist fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Playerlist test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Playerlist getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(BowlingFactory.eINSTANCE.createPlayerlist());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //PlayerlistTest
