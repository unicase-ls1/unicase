/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SCRM Model Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.SCRMModelElement#getDisplayingDiagrams <em>Displaying Diagrams</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.ScrmPackage#getSCRMModelElement()
 * @model abstract="true"
 * @generated
 */
public interface SCRMModelElement extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * The list contents are of type {@link scrm.SCRMDiagram}.
	 * It is bidirectional and its opposite is '{@link scrm.SCRMDiagram#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Displaying Diagrams</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Displaying Diagrams</em>' reference list.
	 * @see scrm.ScrmPackage#getSCRMModelElement_DisplayingDiagrams()
	 * @see scrm.SCRMDiagram#getElements
	 * @model opposite="elements"
	 * @generated
	 */
	EList<SCRMDiagram> getDisplayingDiagrams();

} // SCRMModelElement
