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

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;

import org.unicase.ecp.model.ECPAssociationClassElement;
import org.unicase.ecp.model.MetaModelElementContext;
import org.unicase.ecp.model.workSpaceModel.ECPProjectListener;
import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;
import org.unicase.ecp.model.workSpaceModel.impl.ECPProjectImpl;
import org.unicase.metamodel.AssociationClassElement;
import org.unicase.metamodel.NonDomainElement;
import org.unicase.xmi.exceptions.XMIWorkspaceException;
import org.unicase.xmi.views.DeletedObjectDialog;
import org.unicase.xmi.workspace.XMIECPWorkspace;
import org.unicase.xmi.workspace.XMIMetaModelElementContext;
import org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject;
import org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructurePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XMIECP File Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.xmi.xmiworkspacestructure.impl.XMIECPFileProjectImpl#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link org.unicase.xmi.xmiworkspacestructure.impl.XMIECPFileProjectImpl#getProjectDescription <em>Project Description</em>}</li>
 *   <li>{@link org.unicase.xmi.xmiworkspacestructure.impl.XMIECPFileProjectImpl#getXmiFilePath <em>Xmi File Path</em>}</li>
 *   <li>{@link org.unicase.xmi.xmiworkspacestructure.impl.XMIECPFileProjectImpl#getBaseElements <em>Base Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XMIECPFileProjectImpl extends ECPProjectImpl implements XMIECPFileProject {
	/**
	 * The default value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_NAME_EDEFAULT = "New Project";

	/**
	 * The cached value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected String projectName = PROJECT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getProjectDescription() <em>Project Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_DESCRIPTION_EDEFAULT = "Empty new project.";

	/**
	 * The cached value of the '{@link #getProjectDescription() <em>Project Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectDescription()
	 * @generated
	 * @ordered
	 */
	protected String projectDescription = PROJECT_DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getXmiFilePath() <em>Xmi File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXmiFilePath()
	 * @generated
	 * @ordered
	 */
	protected static final String XMI_FILE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXmiFilePath() <em>Xmi File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXmiFilePath()
	 * @generated
	 * @ordered
	 */
	protected String xmiFilePath = XMI_FILE_PATH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBaseElements() <em>Base Elements</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * Holds the elements of the first level in the TreeView.
	 * <!-- end-user-doc -->
	 * @see #getBaseElements()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> baseElements;

	/**
	 * The xmi-file-resource for the given xmiFilePath.
	 */
	protected Resource resource;
	
	/**
	 * Listeners that need to be informed when the project changes.
	 */
	protected List<ECPProjectListener> listeners = new ArrayList<ECPProjectListener>();
	
	/**
	 * The workspace this project is contained in.
	 */
	protected XMIECPWorkspace workspace;
	
	/**
	 * EContentAdapter that writes changes when a model-element of the project changes.
	 */
	private EContentAdapter listenerAdapter;
	
	/**
	 * Creates a new XMIECPFileProject representing one xmi-file.
	 * Uses the default file path and sets the workspace to null.
	 * Make sure to set the workspace correctly after creating the
	 * object. 
	 */
	protected XMIECPFileProjectImpl() {
		super();
		
		workspace = null;
		
		buildEContentAdapter();
	}
	
	/**
	 * Initializes project
	 */
	private void init() {
		// set the root object to this
		setRootObject(this);
		
		baseElements = new BasicEList<EObject>();
		
		// file resources
		File xmiFile = new File(xmiFilePath);
		URI xmiUri = URI.createFileURI(xmiFilePath);
		
		// build a correct resource set
		ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		BasicCommandStack commandStack = new BasicCommandStack();
		AdapterFactoryEditingDomain editingDomain = new AdapterFactoryEditingDomain(composedAdapterFactory, commandStack);
		ResourceSet resourceSetImpl = editingDomain.getResourceSet();
		
		if(!xmiFile.exists()) {
			// check if the file is contained in a resource, cause then it's not a new project!
			if(eResource() != null) {
				// ask what to do
				DeletedObjectDialog dialog = new DeletedObjectDialog(false, xmiFilePath);
				switch(dialog.getResult()) {
					case 1: // remove from workspace
						workspace.removeProject(this);
						break;
					case 2: // import from another location
						final FileDialog importDialog = new FileDialog(PlatformUI
							.getWorkbench().getDisplay().getActiveShell());
						String importPath = importDialog.open();
						
						if(importPath != null) {
							loadResource(resourceSetImpl, URI.createFileURI(importPath));
						}
						
						break;
					default: // create new file
						createResource(resourceSetImpl, xmiUri);
						break;
				}
				
			}
			else {
				// there is not resource -> it can be assumed this is a new project
				createResource(resourceSetImpl, xmiUri);
			}
		}
		else {
			loadResource(resourceSetImpl, xmiUri);
		}
	}
	
	/**
	 * Creates a blank resource in the given resource set and with the given URI
	 * @param set ResourceSet where the Resource is contained in.
	 * @param uri URI with the path to the file.
	 */
	private void createResource(ResourceSet set, URI uri) {
		// create the resource
		this.resource = set.createResource(uri);
		
		// in the beginning just save the resource without any content
		saveResource();
	}
	
	/**
	 * Loads the resource with the given URI into the resource set.
	 * @param set ResourceSet where the Resource is contained in.
	 * @param uri URI with the path to the file.
	 */
	private void loadResource(ResourceSet set, URI uri) {
		// get the resource, if it exists
		this.resource = set.getResource(uri, true);
		
		// try to load the resource
		try {
			this.resource.load(Collections.EMPTY_MAP);
		}
		catch(IOException e) {
			new XMIWorkspaceException("Resource " + xmiFilePath + " cannot be loaded.", e);
		}
		
		// add contained objects to the project
		for(EObject rootLevelObject: resource.getContents()) {
			addModelElementToRoot(rootLevelObject);
		}
	}
	
	/**
	 * Implements listenerAdapter to save resources when they change.
	 */
	private void buildEContentAdapter() {
		listenerAdapter = new EContentAdapter() {
			
			/**
			 * This method is being called when an object in the model changes,
			 * it persists the changes instantely to the xmi resource
			 */
			@Override
			public void notifyChanged(Notification notification) {
				// save the changed objects
				Object changedObj = notification.getNotifier();
				
				if(changedObj instanceof EObject) {
					EObject changedEObj = (EObject) changedObj; // cast the object to an EObject

					// try to save object to the attached resource
					try {
						if(changedEObj.eResource() != null) { // Prevents error messages for resources that aren't directory contained in a xmi-resource.
							changedEObj.eResource().save(Collections.EMPTY_MAP); // save changes into resource
						}
					} catch (IOException e) {
						new XMIWorkspaceException("Wasn't able to persist object to xmi resource.", e);
					} catch (NullPointerException e) {
						new XMIWorkspaceException("Unable to persist object. Attached resource missing.", e);
					}
					
					// call changed on listeners
					projectChanged();
				}
				
				// continue
				super.notifyChanged(notification);
			}
		};
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XmiworkspacestructurePackage.Literals.XMIECP_FILE_PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectName(String newProjectName) {
		String oldProjectName = projectName;
		projectName = newProjectName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmiworkspacestructurePackage.XMIECP_FILE_PROJECT__PROJECT_NAME, oldProjectName, projectName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProjectDescription() {
		return projectDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectDescription(String newProjectDescription) {
		String oldProjectDescription = projectDescription;
		projectDescription = newProjectDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmiworkspacestructurePackage.XMIECP_FILE_PROJECT__PROJECT_DESCRIPTION, oldProjectDescription, projectDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXmiFilePath() {
		return xmiFilePath;
	}

	/**
	 * Sets the path to the xmi-file where the project contents are stored.
	 * @param newXmiFilePath The complete path to the xmi-file.
	 */
	public void setXmiFilePath(String newXmiFilePath) {
		String oldXmiFilePath = xmiFilePath;
		xmiFilePath = newXmiFilePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmiworkspacestructurePackage.XMIECP_FILE_PROJECT__XMI_FILE_PATH, oldXmiFilePath, xmiFilePath));
		
		init();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getBaseElements() {
		if (baseElements == null) {
			baseElements = new EDataTypeUniqueEList<EObject>(EList.class, this, XmiworkspacestructurePackage.XMIECP_FILE_PROJECT__BASE_ELEMENTS);
		}
		return baseElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XmiworkspacestructurePackage.XMIECP_FILE_PROJECT__PROJECT_NAME:
				return getProjectName();
			case XmiworkspacestructurePackage.XMIECP_FILE_PROJECT__PROJECT_DESCRIPTION:
				return getProjectDescription();
			case XmiworkspacestructurePackage.XMIECP_FILE_PROJECT__XMI_FILE_PATH:
				return getXmiFilePath();
			case XmiworkspacestructurePackage.XMIECP_FILE_PROJECT__BASE_ELEMENTS:
				return getBaseElements();
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
			case XmiworkspacestructurePackage.XMIECP_FILE_PROJECT__PROJECT_NAME:
				setProjectName((String)newValue);
				return;
			case XmiworkspacestructurePackage.XMIECP_FILE_PROJECT__PROJECT_DESCRIPTION:
				setProjectDescription((String)newValue);
				return;
			case XmiworkspacestructurePackage.XMIECP_FILE_PROJECT__XMI_FILE_PATH:
				setXmiFilePath((String)newValue);
				return;
			case XmiworkspacestructurePackage.XMIECP_FILE_PROJECT__BASE_ELEMENTS:
				getBaseElements().clear();
				getBaseElements().addAll((Collection<? extends EObject>)newValue);
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
			case XmiworkspacestructurePackage.XMIECP_FILE_PROJECT__PROJECT_NAME:
				setProjectName(PROJECT_NAME_EDEFAULT);
				return;
			case XmiworkspacestructurePackage.XMIECP_FILE_PROJECT__PROJECT_DESCRIPTION:
				setProjectDescription(PROJECT_DESCRIPTION_EDEFAULT);
				return;
			case XmiworkspacestructurePackage.XMIECP_FILE_PROJECT__XMI_FILE_PATH:
				setXmiFilePath(XMI_FILE_PATH_EDEFAULT);
				return;
			case XmiworkspacestructurePackage.XMIECP_FILE_PROJECT__BASE_ELEMENTS:
				getBaseElements().clear();
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
			case XmiworkspacestructurePackage.XMIECP_FILE_PROJECT__PROJECT_NAME:
				return PROJECT_NAME_EDEFAULT == null ? projectName != null : !PROJECT_NAME_EDEFAULT.equals(projectName);
			case XmiworkspacestructurePackage.XMIECP_FILE_PROJECT__PROJECT_DESCRIPTION:
				return PROJECT_DESCRIPTION_EDEFAULT == null ? projectDescription != null : !PROJECT_DESCRIPTION_EDEFAULT.equals(projectDescription);
			case XmiworkspacestructurePackage.XMIECP_FILE_PROJECT__XMI_FILE_PATH:
				return XMI_FILE_PATH_EDEFAULT == null ? xmiFilePath != null : !XMI_FILE_PATH_EDEFAULT.equals(xmiFilePath);
			case XmiworkspacestructurePackage.XMIECP_FILE_PROJECT__BASE_ELEMENTS:
				return baseElements != null && !baseElements.isEmpty();
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
		result.append(" (projectName: ");
		result.append(projectName);
		result.append(", projectDescription: ");
		result.append(projectDescription);
		result.append(", xmiFilePath: ");
		result.append(xmiFilePath);
		result.append(", baseElements: ");
		result.append(baseElements);
		result.append(')');
		return result.toString();
	}

	public void addECPProjectListener(ECPProjectListener listener) {
		this.listeners.add(listener);
	}

	public boolean contains(EObject eObject) {
		if(eObject == this) return true;
		return getAllModelElements().contains(eObject);
	}

	public void dispose() {
		// remove all references to other objects
		// so the garbage collector can remove this object
		projectDeleted();
		
		workspace = null;
		listeners = null;
		listenerAdapter = null;
	}

	public Collection<EObject> getAllModelElement() {
		return getAllModelElements();
	}

	/**
	 * Returns all elements contained in the project that have the specified class type.
	 * @return Returns only objects with the given EClass.
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

	public boolean isNonDomainElement(EObject eObject) {
		return (eObject instanceof NonDomainElement);
	}
	
	/**
	 * Calls save on the resource of this project.
	 */
	private void saveResource() {
		// simply call save on the resource
		try {
			this.resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			new XMIWorkspaceException("Cannot save changes to xmi-project-file.", e);
		}
	}

	public void modelelementDeleted(EObject eobject) {
		// Remove model element from xmi-file -> just save it.
		saveResource();
		
		// tell listeners about the event
		for(ECPProjectListener listener : listeners) {
			listener.modelelementDeleted(eobject);
		}
	}

	public void projectChanged() {
		// Save all objects into the xmi-file
		saveResource();
		
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
		this.rootObject = value;
		
	}

	public void setWorkspace(ECPWorkspace value) {
		if(value instanceof XMIECPWorkspace) {
			workspace = (XMIECPWorkspace) value;
		}
		else {
			new XMIWorkspaceException("Project can only be contained in an xmi-workspace!");
		}
	}

	public Collection<EObject> getAllModelElements() {
		// make new result list that no pointer is returned
		ArrayList<EObject> result = new ArrayList<EObject>();
		
		// go through all baseElements and add their tree to result		
		for(EObject eo: baseElements) {
			result.add(eo);
			TreeIterator<EObject> contents = eo.eAllContents();
			while(contents.hasNext()) {
				result.add(contents.next());
			}
		}
		
		// return complete list of all elements contained in this project
		return result;
	}

	public ECPAssociationClassElement getAssociationClassElement(EObject eObject) {
		if (isAssociationClassElement(eObject)) {
			AssociationClassElement ace = (AssociationClassElement) eObject;
			return new ECPAssociationClassElement(ace.getSourceFeature(), ace.getTargetFeature(), ace
				.getAssociationFeatures());
		}
		return null;
	}

	public EditingDomain getEditingDomain() {
		if(workspace == null) return null;
		return workspace.getEditingDomain();
	}

	public MetaModelElementContext getMetaModelElementContext() {
		return new XMIMetaModelElementContext();
	}

	public boolean isAssociationClassElement(EObject eObject) {
		return (eObject instanceof AssociationClassElement);
	}
	
	public void addModelElementToRoot(EObject eObject) {
		// add a listener adapter so all changes can be saved
		eObject.eAdapters().add(listenerAdapter);
		
		// add the element to the resource so it will be saved in the xmi-file
		resource.getContents().add(eObject);
		saveResource();
		
		// add the object to the first-level-list
		baseElements.add(eObject);
	}
	
	public Collection<EObject> getRootLevel() {
		ArrayList<EObject> arrayList = new ArrayList<EObject>();
		arrayList.addAll(baseElements);
		return arrayList;
	}

} //XMIECPFileProjectImpl
