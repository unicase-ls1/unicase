/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.xmi.XMIWorkspaceStructure.util;


import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.unicase.xmi.XMIWorkspaceStructure.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.unicase.xmi.XMIWorkspaceStructure.XMIWorkspaceStructurePackage
 * @generated
 */
public class XMIWorkspaceStructureSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static XMIWorkspaceStructurePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMIWorkspaceStructureSwitch() {
		if (modelPackage == null) {
			modelPackage = XMIWorkspaceStructurePackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case XMIWorkspaceStructurePackage.XMIECP_PROJECT: {
				XMIECPProject xmiecpProject = (XMIECPProject)theEObject;
				T result = caseXMIECPProject(xmiecpProject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XMIWorkspaceStructurePackage.XMIECP_FILE_PROJECT: {
				XMIECPFileProject xmiecpFileProject = (XMIECPFileProject)theEObject;
				T result = caseXMIECPFileProject(xmiecpFileProject);
				if (result == null) result = caseXMIECPProject(xmiecpFileProject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XMIWorkspaceStructurePackage.XMIECP_CONTAINER: {
				XMIECPContainer xmiecpContainer = (XMIECPContainer)theEObject;
				T result = caseXMIECPContainer(xmiecpContainer);
				if (result == null) result = caseXMIECPProject(xmiecpContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XMIWorkspaceStructurePackage.XMIECP_VIRTUAL_CONTAINER: {
				XMIECPVirtualContainer xmiecpVirtualContainer = (XMIECPVirtualContainer)theEObject;
				T result = caseXMIECPVirtualContainer(xmiecpVirtualContainer);
				if (result == null) result = caseXMIECPContainer(xmiecpVirtualContainer);
				if (result == null) result = caseXMIECPProject(xmiecpVirtualContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XMIWorkspaceStructurePackage.XMIECP_FOLDER: {
				XMIECPFolder xmiecpFolder = (XMIECPFolder)theEObject;
				T result = caseXMIECPFolder(xmiecpFolder);
				if (result == null) result = caseXMIECPContainer(xmiecpFolder);
				if (result == null) result = caseXMIECPProject(xmiecpFolder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XMIECP Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XMIECP Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXMIECPProject(XMIECPProject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XMIECP File Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XMIECP File Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXMIECPFileProject(XMIECPFileProject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XMIECP Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XMIECP Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXMIECPContainer(XMIECPContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XMIECP Virtual Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XMIECP Virtual Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXMIECPVirtualContainer(XMIECPVirtualContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XMIECP Folder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XMIECP Folder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXMIECPFolder(XMIECPFolder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //XMIWorkspaceStructureSwitch
