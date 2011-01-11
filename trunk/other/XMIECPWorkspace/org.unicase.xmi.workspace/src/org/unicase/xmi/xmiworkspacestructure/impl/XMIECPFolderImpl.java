/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.xmi.xmiworkspacestructure.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.EditingDomain;

import org.unicase.ecp.model.ECPAssociationClassElement;
import org.unicase.ecp.model.MetaModelElementContext;
import org.unicase.ecp.model.workSpaceModel.ECPProjectListener;
import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;
import org.unicase.xmi.exceptions.XMIWorkspaceException;
import org.unicase.xmi.workspace.XMIECPWorkspace;
import org.unicase.xmi.workspace.XMIMetaModelElementContext;
import org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject;
import org.unicase.xmi.xmiworkspacestructure.XMIECPProject;
import org.unicase.xmi.xmiworkspacestructure.XMIECPFolder;
import org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructureFactory;
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
	protected EList<String> containedFiles;

	/**
	 * The workspace the folder is contained in.
	 */
	protected ECPWorkspace workspace;
	
	/**
	 * Listeners that need to be informed when a project changes.
	 */
	protected List<ECPProjectListener> listeners = new ArrayList<ECPProjectListener>();

	/**
	 * Root of the "project" and actually this folder itself.
	 */
	private EObject rootObject;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XMIECPFolderImpl() {
		super();
		
		internalProjects = new BasicEList<XMIECPProject>();
		containedFiles = new BasicEList<String>();
		
		workspace = null;
		rootObject = this;
	}

	/**
	 * Initializes Folder, e.g. reads files and creates projects out of them.
	 */
	private void init() {
		File folder = new File(getXmiDirectoryPath());
		
		if(!folder.exists()) {
			// if folder not exists, simply create it.
			folder.mkdir();
		}
		else if(!folder.isDirectory()) {
			// check whether it even is a directory
			new XMIWorkspaceException("The given path (" + getXmiDirectoryPath() + ") is not a directory.");
		}
		else {
			// read all files
			File[] files = folder.listFiles();
			for(int f = 0; f < files.length; f++) {
				if(files[f].isDirectory()) {
					XMIECPFolder newFolder = XmiworkspacestructureFactory.eINSTANCE.createXMIECPFolder();
					newFolder.setXmiDirectoryPath(files[f].getAbsolutePath());
					((XMIECPWorkspace) getWorkspace()).addFolder(newFolder);
				}
				if(files[f].isFile() && isValidXMIFile(files[f])) {
					XMIECPFileProject fileProject = XmiworkspacestructureFactory.eINSTANCE.createXMIECPFileProject();
					fileProject.setXmiFilePath(files[f].getAbsolutePath());
					internalProjects.add(fileProject);
					containedFiles.add(files[f].getAbsolutePath());
				}
			}
		}
	} // END init()

	/**
	 * Checks whether the given File is a valid XMI-File.
	 * @param file File to be checked.
	 * @return true if file is readable, else false.
	 */
	private boolean isValidXMIFile(File file) {
		Resource res = new ResourceSetImpl().getResource(URI.createFileURI(file.getAbsolutePath()), true);
		try {
			res.load(Collections.EMPTY_MAP);
		}
		catch(IOException e) {
			// do nothing, just return false.
			return false;
		}
		res.unload();
		
		return true;
	}

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
	public EList<String> getContainedFiles() {
		return containedFiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainedFiles(EList<String> newContainedFiles) {
		EList<String> oldContainedFiles = containedFiles;
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case XmiworkspacestructurePackage.XMIECP_FOLDER__XMI_DIRECTORY_PATH:
				setXmiDirectoryPath((String)newValue);
				return;
			case XmiworkspacestructurePackage.XMIECP_FOLDER__CONTAINED_FILES:
				setContainedFiles((EList<String>)newValue);
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
				setContainedFiles((EList<String>)null);
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

	public void setWorkspace(ECPWorkspace ws) {
		workspace = ws;
	}

	public void addECPProjectListener(ECPProjectListener listener) {
		this.listeners.add(listener);
	}

	public void addModelElementToRoot(EObject eObject) {
		if(eObject instanceof XMIECPFileProject) {
			XMIECPFileProject project = (XMIECPFileProject) eObject;
			project.setXmiFilePath(getXmiDirectoryPath() + "/" + project.hashCode() + ".ucw");
			internalProjects.add(project);
		}
	}

	public boolean contains(EObject eObject) {
		if(eObject == this) return true;
		if(eObject instanceof XMIECPFileProject) {
			return internalProjects.contains((XMIECPFileProject) eObject);
		}
		return false;
	}

	public void dispose() {
		// remove all references
		projectDeleted();
		
		internalProjects = null;
		containedFiles = null;
		workspace = null;
		listeners = null;
	}

	public Collection<EObject> getAllModelElement() {
		return getAllModelElements();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ecp.model.workSpaceModel.ECPProject.#getAllModelElementsbyClass(EClass, BasicEList)
	 */
	public Collection<EObject> getAllModelElementsbyClass(EClass clazz, BasicEList<EObject> basicEList) {
		EList<EObject> result;
		
		// initialize result-list
		if(basicEList.isEmpty()) {
			result = basicEList;
		}
		else {
			result = new BasicEList<EObject>();
			result.addAll(basicEList);
		}
		
		// get contained elements
		Collection<EObject> allElements = getAllModelElements();

		// filter the elements and add them to the result if they fit
		for(EObject eo: allElements) {
			if(eo.eClass().equals(clazz)) result.add(eo);
		}
		
		return result;
	}

	public EObject getRootObject() {
		return rootObject;
	}

	public ECPWorkspace getWorkspace() {
		return workspace;
	}

	/**
	 * CAUTION: this feature is not supported by this plugin!
	 */
	public boolean isNonDomainElement(EObject eObject) {
		return false; // CAUTION: this feature is not supported by this plugin!
	}

	public void modelelementDeleted(EObject eobject) {
		// tell listeners about the event
		for(ECPProjectListener listener : listeners) {
			listener.projectDeleted();
		}
		
	}

	public void projectChanged() {
		// tell listeners about the event
		for(ECPProjectListener listener : listeners) {
			listener.projectChanged();
		}
	}

	public void projectDeleted() {
		// tell listeners about the event
		for(ECPProjectListener listener : listeners) {
			listener.projectDeleted();
		}
	}

	public void removeECPProjectListener(ECPProjectListener listener) {
		this.listeners.remove(listener);
	}

	public void setRootObject(EObject value) {
		rootObject = value;
	}

	public Collection<EObject> getAllModelElements() {
		List<EObject> result = new ArrayList<EObject>();
		result.addAll(internalProjects);
		return result;
	}

	/**
	 * CAUTION: this feature is not supported by this plugin!
	 */
	public ECPAssociationClassElement getAssociationClassElement(EObject eObject) {
		return null; // CAUTION: this feature is not supported by this plugin!
	}

	public EditingDomain getEditingDomain() {
		if(workspace == null) return null;
		return workspace.getEditingDomain();
	}

	public MetaModelElementContext getMetaModelElementContext() {
		return new XMIMetaModelElementContext();
	}

	/**
	 *  CAUTION: this feature is not supported by this plugin!
	 */
	public boolean isAssociationClassElement(EObject eObject) {
		return false; // CAUTION: this feature is not supported by this plugin!
	}

} //XMIECPFolderImpl
