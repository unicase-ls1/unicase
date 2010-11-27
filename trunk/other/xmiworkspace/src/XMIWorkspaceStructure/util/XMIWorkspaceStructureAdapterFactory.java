/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package XMIWorkspaceStructure.util;

import XMIWorkspaceStructure.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see XMIWorkspaceStructure.XMIWorkspaceStructurePackage
 * @generated
 */
public class XMIWorkspaceStructureAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static XMIWorkspaceStructurePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMIWorkspaceStructureAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = XMIWorkspaceStructurePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XMIWorkspaceStructureSwitch<Adapter> modelSwitch =
		new XMIWorkspaceStructureSwitch<Adapter>() {
			@Override
			public Adapter caseXMIECPProject(XMIECPProject object) {
				return createXMIECPProjectAdapter();
			}
			@Override
			public Adapter caseXMIECPFileProject(XMIECPFileProject object) {
				return createXMIECPFileProjectAdapter();
			}
			@Override
			public Adapter caseXMIECPContainer(XMIECPContainer object) {
				return createXMIECPContainerAdapter();
			}
			@Override
			public Adapter caseXMIECPVirtualContainer(XMIECPVirtualContainer object) {
				return createXMIECPVirtualContainerAdapter();
			}
			@Override
			public Adapter caseXMIECPFolder(XMIECPFolder object) {
				return createXMIECPFolderAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link XMIWorkspaceStructure.XMIECPProject <em>XMIECP Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see XMIWorkspaceStructure.XMIECPProject
	 * @generated
	 */
	public Adapter createXMIECPProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link XMIWorkspaceStructure.XMIECPFileProject <em>XMIECP File Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see XMIWorkspaceStructure.XMIECPFileProject
	 * @generated
	 */
	public Adapter createXMIECPFileProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link XMIWorkspaceStructure.XMIECPContainer <em>XMIECP Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see XMIWorkspaceStructure.XMIECPContainer
	 * @generated
	 */
	public Adapter createXMIECPContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link XMIWorkspaceStructure.XMIECPVirtualContainer <em>XMIECP Virtual Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see XMIWorkspaceStructure.XMIECPVirtualContainer
	 * @generated
	 */
	public Adapter createXMIECPVirtualContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link XMIWorkspaceStructure.XMIECPFolder <em>XMIECP Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see XMIWorkspaceStructure.XMIECPFolder
	 * @generated
	 */
	public Adapter createXMIECPFolderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //XMIWorkspaceStructureAdapterFactory
