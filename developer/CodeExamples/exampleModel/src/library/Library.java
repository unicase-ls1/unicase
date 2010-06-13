/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package library;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Library</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link library.Library#getName <em>Name</em>}</li>
 * <li>{@link library.Library#getWriters <em>Writers</em>}</li>
 * <li>{@link library.Library#getBooks <em>Books</em>}</li>
 * <li>{@link library.Library#getIncludedLibraries <em>Included Libraries</em>}</li>
 * </ul>
 * </p>
 * 
 * @see library.LibraryPackage#getLibrary()
 * @model
 * @generated
 */
public interface Library extends LibraryBase {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see library.LibraryPackage#getLibrary_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link library.Library#getName <em>Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Writers</b></em>' containment reference
	 * list. The list contents are of type {@link library.Writer}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Writers</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Writers</em>' containment reference list.
	 * @see library.LibraryPackage#getLibrary_Writers()
	 * @model containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<Writer> getWriters();

	/**
	 * Returns the value of the '<em><b>Books</b></em>' containment reference
	 * list. The list contents are of type {@link library.Book}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Books</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Books</em>' containment reference list.
	 * @see library.LibraryPackage#getLibrary_Books()
	 * @model containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<Book> getBooks();

	/**
	 * Returns the value of the '<em><b>Included Libraries</b></em>' containment
	 * reference list. The list contents are of type {@link library.Library}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Included Libraries</em>' containment reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Included Libraries</em>' containment
	 *         reference list.
	 * @see library.LibraryPackage#getLibrary_IncludedLibraries()
	 * @model containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<Library> getIncludedLibraries();

} // Library
