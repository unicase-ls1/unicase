/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.xmi.xmiworkspacestructure.impl;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import org.unicase.ecp.model.workSpaceModel.ECPProjectListener;
import org.unicase.xmi.exceptions.XMIFileTypeException;
import org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject;
import org.unicase.xmi.xmiworkspacestructure.XMIECPFolder;
import org.unicase.xmi.xmiworkspacestructure.XMIECPProject;
import org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructurePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XMIECP Folder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.xmi.xmiworkspacestructure.impl.XMIECPFolderImpl#getXmiDirectoryPath <em>Xmi Directory Path</em>}</li>
 *   <li>{@link org.unicase.xmi.xmiworkspacestructure.impl.XMIECPFolderImpl#getContainedFiles <em>Contained Files</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XMIECPFolderImpl extends XMIECPProjectContainerImpl implements XMIECPFolder {
	/**
	 * The default value of the '{@link #getXmiDirectoryPath() <em>Xmi Directory Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXmiDirectoryPath()
	 * @generated
	 * @ordered
	 */
	protected static final String XMI_DIRECTORY_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXmiDirectoryPath() <em>Xmi Directory Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXmiDirectoryPath()
	 * @generated
	 * @ordered
	 */
	protected String xmiDirectoryPath = XMI_DIRECTORY_PATH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContainedFiles() <em>Contained Files</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedFiles()
	 * @generated
	 * @ordered
	 */
	protected EList<File> containedFiles;

	/**
	 * Path to where the folder containing the xmi-resources is.
	 */
	private URI xmiFolderPath = null;
	
	/**
	 * Loadable xmi resources
	 */
	private ResourceSet resources = null;
	
	/**
	 * <!-- begin-user-doc -->
	 * Creates a folder node which represents a directory in the filesystem with xmi resources in it.
	 * Please make sure to set the xmiFolderPath and the ECPWorkspace after creating the object.
	 * <!-- end-user-doc -->
	 */
	protected XMIECPFolderImpl() {
		super();
	}
	
	/**
	 * Initializing project-container
	 * Called when the xmiFilePath is set. 
	 */
	private void init() {
		// check whether xmiFolderPath was set
		if(xmiFolderPath == null) {
			new XMIFileTypeException("The path to the folder has not been set.");
			return;
		}
		
		// creating resources
		File xmiFolder = new File(xmiFolderPath.toFileString());
		resources = new ResourceSetImpl();
		
		// checking whether the file is really a directory
		if(!xmiFolder.isDirectory()) {
			new XMIFileTypeException("The given path " + xmiFolderPath.toPlatformString(false) + " is not a directory.");
			return;
		}
		else if(!xmiFolder.exists()) {
			// folder does not exists and must be created
			if(!xmiFolder.mkdir()) {
				// unable to create folder
				new XMIFileTypeException("Unable to create directory " + xmiFolder.getPath());
			}
		}
		else {
			// the file is a directory and therefore the files within the directory are read
			File[] files = xmiFolder.listFiles();
			for(int i = 0; i < files.length; i++) {
				Resource xmiFile = resources.getResource(URI.createFileURI(files[i].getPath()), true);
				
				// try to load the file to see whether it's a valid resource
				try {
					xmiFile.load(Collections.EMPTY_MAP);
					resources.getResources().add(xmiFile);
					containedFiles.add(files[i]);
				}
				catch(IOException e) {
					new XMIFileTypeException(files[i].getPath() + " is not a valid xmi resource and won't be loaded.", e);
				}
			}
			
			// each valid file has to be build as a XMIECPProject now and added to the internal project management
			for(Resource res: resources.getResources()) {
				XMIECPProject project = (XMIECPFileProject) res.getContents().get(0);
				project.setWorkspace(getWorkspace());
				internalProjects.add(project);
			}
		}
	} // END init
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XmiworkspacestructurePackage.Literals.XMIECP_FOLDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXmiDirectoryPath() {
		return xmiDirectoryPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXmiDirectoryPath(String newXmiDirectoryPath) {
		String oldXmiDirectoryPath = xmiDirectoryPath;
		xmiDirectoryPath = newXmiDirectoryPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmiworkspacestructurePackage.XMIECP_FOLDER__XMI_DIRECTORY_PATH, oldXmiDirectoryPath, xmiDirectoryPath));
		
		init();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<File> getContainedFiles() {
		return containedFiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainedFiles(EList<File> newContainedFiles) {
		EList<File> oldContainedFiles = containedFiles;
		containedFiles = newContainedFiles;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmiworkspacestructurePackage.XMIECP_FOLDER__CONTAINED_FILES, oldContainedFiles, containedFiles));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XmiworkspacestructurePackage.XMIECP_FOLDER__XMI_DIRECTORY_PATH:
				return getXmiDirectoryPath();
			case XmiworkspacestructurePackage.XMIECP_FOLDER__CONTAINED_FILES:
				return getContainedFiles();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case XmiworkspacestructurePackage.XMIECP_FOLDER__XMI_DIRECTORY_PATH:
				setXmiDirectoryPath((String)newValue);
				return;
			case XmiworkspacestructurePackage.XMIECP_FOLDER__CONTAINED_FILES:
				setContainedFiles((EList<File>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case XmiworkspacestructurePackage.XMIECP_FOLDER__XMI_DIRECTORY_PATH:
				setXmiDirectoryPath(XMI_DIRECTORY_PATH_EDEFAULT);
				return;
			case XmiworkspacestructurePackage.XMIECP_FOLDER__CONTAINED_FILES:
				setContainedFiles((EList<File>)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case XmiworkspacestructurePackage.XMIECP_FOLDER__XMI_DIRECTORY_PATH:
				return XMI_DIRECTORY_PATH_EDEFAULT == null ? xmiDirectoryPath != null : !XMI_DIRECTORY_PATH_EDEFAULT.equals(xmiDirectoryPath);
			case XmiworkspacestructurePackage.XMIECP_FOLDER__CONTAINED_FILES:
				return containedFiles != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (xmiDirectoryPath: ");
		result.append(xmiDirectoryPath);
		result.append(", containedFiles: ");
		result.append(containedFiles);
		result.append(')');
		return result.toString();
	}

} //XMIECPFolderImpl
