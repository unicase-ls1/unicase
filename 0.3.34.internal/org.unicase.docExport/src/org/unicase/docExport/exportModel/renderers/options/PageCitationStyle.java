/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Page Citation Style</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * 
 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getPageCitationStyle()
 * @model
 * @generated
 */
public enum PageCitationStyle implements Enumerator {
	/**
	 * The '<em><b>PAGE</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #PAGE_VALUE
	 * @generated
	 * @ordered
	 */
	PAGE(0, "PAGE", "page"), /**
	 * The '<em><b>EMPTY</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #EMPTY_VALUE
	 * @generated
	 * @ordered
	 */
	EMPTY(1, "EMPTY", "empty"),

	/**
	 * The '<em><b>PAGE AND LAST PAGE</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #PAGE_AND_LAST_PAGE_VALUE
	 * @generated
	 * @ordered
	 */
	PAGE_AND_LAST_PAGE(2, "PAGE_AND_LAST_PAGE", "page / lastpage");

	/**
	 * The '<em><b>PAGE</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PAGE</b></em>' literal object isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #PAGE
	 * @model literal="page"
	 * @generated
	 * @ordered
	 */
	public static final int PAGE_VALUE = 0;

	/**
	 * The '<em><b>EMPTY</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EMPTY</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #EMPTY
	 * @model literal="empty"
	 * @generated
	 * @ordered
	 */
	public static final int EMPTY_VALUE = 1;

	/**
	 * The '<em><b>PAGE AND LAST PAGE</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PAGE AND LAST PAGE</b></em>' literal object isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #PAGE_AND_LAST_PAGE
	 * @model literal="page / lastpage"
	 * @generated
	 * @ordered
	 */
	public static final int PAGE_AND_LAST_PAGE_VALUE = 2;

	/**
	 * An array of all the '<em><b>Page Citation Style</b></em>' enumerators. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	private static final PageCitationStyle[] VALUES_ARRAY = new PageCitationStyle[] { PAGE, EMPTY, PAGE_AND_LAST_PAGE, };

	/**
	 * A public read-only list of all the '<em><b>Page Citation Style</b></em>' enumerators. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<PageCitationStyle> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Page Citation Style</b></em>' literal with the specified literal value. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static PageCitationStyle get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PageCitationStyle result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Page Citation Style</b></em>' literal with the specified name. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static PageCitationStyle getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PageCitationStyle result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Page Citation Style</b></em>' literal with the specified integer value. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static PageCitationStyle get(int value) {
		switch (value) {
		case PAGE_VALUE:
			return PAGE;
		case EMPTY_VALUE:
			return EMPTY;
		case PAGE_AND_LAST_PAGE_VALUE:
			return PAGE_AND_LAST_PAGE;
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
	private PageCitationStyle(int value, String name, String literal) {
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

} // PageCitationStyle
