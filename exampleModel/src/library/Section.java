/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package library;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link library.Section#getBooks <em>Books</em>}</li>
 *   <li>{@link library.Section#getCategory <em>Category</em>}</li>
 *   <li>{@link library.Section#getSectionName <em>Section Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see library.LibraryPackage#getSection()
 * @model
 * @generated
 */
public interface Section extends LibraryBase {
	/**
	 * Returns the value of the '<em><b>Books</b></em>' containment reference list.
	 * The list contents are of type {@link library.Book}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Books</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Books</em>' containment reference list.
	 * @see library.LibraryPackage#getSection_Books()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Book> getBooks();

	/**
	 * Returns the value of the '<em><b>Category</b></em>' attribute.
	 * The literals are from the enumeration {@link library.BookCategory}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' attribute.
	 * @see library.BookCategory
	 * @see #setCategory(BookCategory)
	 * @see library.LibraryPackage#getSection_Category()
	 * @model
	 * @generated
	 */
	BookCategory getCategory();

	/**
	 * Sets the value of the '{@link library.Section#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see library.BookCategory
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(BookCategory value);

	/**
	 * Returns the value of the '<em><b>Section Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Section Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Section Name</em>' attribute.
	 * @see #setSectionName(String)
	 * @see library.LibraryPackage#getSection_SectionName()
	 * @model
	 * @generated
	 */
	String getSectionName();

	/**
	 * Sets the value of the '{@link library.Section#getSectionName <em>Section Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Section Name</em>' attribute.
	 * @see #getSectionName()
	 * @generated
	 */
	void setSectionName(String value);

} // Section
