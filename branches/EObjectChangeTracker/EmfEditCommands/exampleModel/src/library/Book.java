/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package library;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Book</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link library.Book#getTitle <em>Title</em>}</li>
 *   <li>{@link library.Book#getPages <em>Pages</em>}</li>
 *   <li>{@link library.Book#getAuthor <em>Author</em>}</li>
 *   <li>{@link library.Book#getPublicationYear <em>Publication Year</em>}</li>
 * </ul>
 * </p>
 *
 * @see library.LibraryPackage#getBook()
 * @model
 * @generated
 */
public interface Book extends LibraryBase {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see library.LibraryPackage#getBook_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link library.Book#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Pages</b></em>' attribute.
	 * The default value is <code>"100"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pages</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pages</em>' attribute.
	 * @see #setPages(int)
	 * @see library.LibraryPackage#getBook_Pages()
	 * @model default="100"
	 * @generated
	 */
	int getPages();

	/**
	 * Sets the value of the '{@link library.Book#getPages <em>Pages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pages</em>' attribute.
	 * @see #getPages()
	 * @generated
	 */
	void setPages(int value);

	/**
	 * Returns the value of the '<em><b>Author</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link library.Writer#getBooks <em>Books</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author</em>' reference.
	 * @see #setAuthor(Writer)
	 * @see library.LibraryPackage#getBook_Author()
	 * @see library.Writer#getBooks
	 * @model opposite="books" required="true"
	 * @generated
	 */
	Writer getAuthor();

	/**
	 * Sets the value of the '{@link library.Book#getAuthor <em>Author</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Author</em>' reference.
	 * @see #getAuthor()
	 * @generated
	 */
	void setAuthor(Writer value);

	/**
	 * Returns the value of the '<em><b>Publication Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Publication Year</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Publication Year</em>' attribute.
	 * @see #setPublicationYear(int)
	 * @see library.LibraryPackage#getBook_PublicationYear()
	 * @model
	 * @generated
	 */
	int getPublicationYear();

	/**
	 * Sets the value of the '{@link library.Book#getPublicationYear <em>Publication Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Publication Year</em>' attribute.
	 * @see #getPublicationYear()
	 * @generated
	 */
	void setPublicationYear(int value);

} // Book
