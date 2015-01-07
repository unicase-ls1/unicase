/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Page Numbering Style</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * 
 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getPageNumberingStyle()
 * @model
 * @generated
 */
public enum PageNumberingStyle implements Enumerator {
	/**
	 * The '<em><b>PAGE ONLY</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #PAGE_ONLY_VALUE
	 * @generated
	 * @ordered
	 */
	PAGE_ONLY(0, "PAGE_ONLY", "<page>"),

	/**
	 * The '<em><b>PAGE OF PAGE COUNT</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #PAGE_OF_PAGE_COUNT_VALUE
	 * @generated
	 * @ordered
	 */
	PAGE_OF_PAGE_COUNT(1, "PAGE_OF_PAGE_COUNT", "<page>/<page_count>"),

	/**
	 * The '<em><b>EMPTY</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #EMPTY_VALUE
	 * @generated
	 * @ordered
	 */
	EMPTY(2, "EMPTY", "-");

	/**
	 * The '<em><b>PAGE ONLY</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PAGE ONLY</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #PAGE_ONLY
	 * @model literal="<page>"
	 * @generated
	 * @ordered
	 */
	public static final int PAGE_ONLY_VALUE = 0;

	/**
	 * The '<em><b>PAGE OF PAGE COUNT</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PAGE OF PAGE COUNT</b></em>' literal object isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #PAGE_OF_PAGE_COUNT
	 * @model literal="<page>/<page_count>"
	 * @generated
	 * @ordered
	 */
	public static final int PAGE_OF_PAGE_COUNT_VALUE = 1;

	/**
	 * The '<em><b>EMPTY</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EMPTY</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #EMPTY
	 * @model literal="-"
	 * @generated
	 * @ordered
	 */
	public static final int EMPTY_VALUE = 2;

	/**
	 * An array of all the '<em><b>Page Numbering Style</b></em>' enumerators. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	private static final PageNumberingStyle[] VALUES_ARRAY = new PageNumberingStyle[] { PAGE_ONLY, PAGE_OF_PAGE_COUNT,
		EMPTY, };

	/**
	 * A public read-only list of all the '<em><b>Page Numbering Style</b></em>' enumerators. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<PageNumberingStyle> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Page Numbering Style</b></em>' literal with the specified literal value. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static PageNumberingStyle get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PageNumberingStyle result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Page Numbering Style</b></em>' literal with the specified name. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static PageNumberingStyle getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PageNumberingStyle result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Page Numbering Style</b></em>' literal with the specified integer value. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static PageNumberingStyle get(int value) {
		switch (value) {
		case PAGE_ONLY_VALUE:
			return PAGE_ONLY;
		case PAGE_OF_PAGE_COUNT_VALUE:
			return PAGE_OF_PAGE_COUNT;
		case EMPTY_VALUE:
			return EMPTY;
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
	private PageNumberingStyle(int value, String name, String literal) {
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

} // PageNumberingStyle
