/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.ecp.xmiworkspace.structure.impl;

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
import org.eclipse.emf.ecp.common.model.ECPAssociationClassElement;
import org.eclipse.emf.ecp.common.model.ECPMetaModelElementContext;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPProjectListener;
import org.eclipse.emf.ecp.common.model.workSpaceModel.impl.ECPProjectImpl;
import org.eclipse.emf.ecp.xmiworkspace.XMIMetaModelElementContext;
import org.eclipse.emf.ecp.xmiworkspace.XmiUtil;
import org.eclipse.emf.ecp.xmiworkspace.XmiUtil.PROJECT_STATUS;
import org.eclipse.emf.ecp.xmiworkspace.exceptions.XMIWorkspaceException;
import org.eclipse.emf.ecp.xmiworkspace.structure.StructurePackage;
import org.eclipse.emf.ecp.xmiworkspace.structure.XMIECPFileProject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>XMIECP File Project</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.emf.ecp.xmiworkspace.structure.impl.XMIECPFileProjectImpl#getProjectName
 * <em>Project Name</em>}</li>
 * <li>
 * {@link org.eclipse.emf.ecp.xmiworkspace.structure.impl.XMIECPFileProjectImpl#getProjectDescription
 * <em>Project Description</em>}</li>
 * <li>
 * {@link org.eclipse.emf.ecp.xmiworkspace.structure.impl.XMIECPFileProjectImpl#getXmiFilePath
 * <em>Xmi File Path</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class XMIECPFileProjectImpl extends ECPProjectImpl implements
		XMIECPFileProject {
	/**
	 * The default value of the '{@link #getProjectName() <em>Project Name</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_NAME_EDEFAULT = "\"New Project\"";

	/**
	 * The cached value of the '{@link #getProjectName() <em>Project Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected String projectName = PROJECT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getProjectDescription()
	 * <em>Project Description</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getProjectDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_DESCRIPTION_EDEFAULT = "\"Empty new Project\"";

	/**
	 * The cached value of the '{@link #getProjectDescription()
	 * <em>Project Description</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getProjectDescription()
	 * @generated
	 * @ordered
	 */
	protected String projectDescription = PROJECT_DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getXmiFilePath()
	 * <em>Xmi File Path</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getXmiFilePath()
	 * @generated
	 * @ordered
	 */
	protected static final String XMI_FILE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXmiFilePath() <em>Xmi File Path</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getXmiFilePath()
	 * @generated
	 * @ordered
	 */
	protected String xmiFilePath = XMI_FILE_PATH_EDEFAULT;

	/**
	 * The xmi-file-resource for the given xmiFilePath.
	 */
	protected Resource mainResource;

	/**
	 * Listeners that need to be informed when the project changes.
	 */
	protected List<ECPProjectListener> projectListeners = new ArrayList<ECPProjectListener>();

	/**
	 * EContentAdapter that writes changes when a model-element of the project
	 * changes.
	 */
	private EContentAdapter listenerAdapter;

	/**
	 * Flag whether the object has been initialized or not
	 */
	private boolean objectInitialized = false;

	/**
	 * Contains the status of the project
	 */
	private PROJECT_STATUS projectStatus;

	/**
	 * Flag whether the XMI filepath is relative to the workspace
	 */
	private boolean isWorkspacePath = false;

	/**
	 * The MetaModelElementContext of the project.
	 */
	private XMIMetaModelElementContext metaContext = new XMIMetaModelElementContext();

	/**
	 * Creates a new XMIECPFileProject representing one xmi-file. Uses the
	 * default file path and sets the workspace to null. Make sure to set the
	 * workspace correctly after creating the object. If you add a new project,
	 * you can call loadContents() to create the project file and load the
	 * content initially.
	 */
	protected XMIECPFileProjectImpl() {
		super();
	}

	/**
	 * Initializes project
	 */
	private void init() {
		buildEContentAdapter();
		// for notification for getters set initialization to false
		objectInitialized = false;

		// set the root object to this
		setRootObject(this);

		// build a correct resource set
		ResourceSet resourceSet = getResourceSet();

		// file resources
		File xmiFile = new File(getResolvedXmiFilePath());

		/*
		 * try to load the resources, if it fails (catch-block) simply ask the
		 * user what to do in case the project is new, you still don't know
		 * whether it's imported or not.
		 */
		if ((!xmiFile.exists() && projectStatus != PROJECT_STATUS.FAILED)
				|| (xmiFile.exists() && projectStatus != PROJECT_STATUS.DUPLICATED)) {
			loadResource(resourceSet);
			resourceSet.eAdapters().add(listenerAdapter);
			// set the object as initialized
			objectInitialized = true;
			setProjectStatus(PROJECT_STATUS.LOADED);
		} else {
			setProjectStatus(PROJECT_STATUS.NOTLOADED);
		}

		if (objectInitialized) {
			projectChanged();
		}
	}

	private ResourceSet getResourceSet() {
		ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		BasicCommandStack commandStack = new BasicCommandStack();
		AdapterFactoryEditingDomain editingDomain = new AdapterFactoryEditingDomain(
				composedAdapterFactory, commandStack);
		ResourceSet resourceSetImpl = editingDomain.getResourceSet();
		return resourceSetImpl;
	}

	/**
	 * Loads the resource with the given URI into the resource set.
	 * 
	 * @param set
	 *            ResourceSet where the Resource is contained in.
	 * @param uri
	 *            URI with the path to the file.
	 */
	private void loadResource(ResourceSet set) {
		String path = getResolvedXmiFilePath();
		this.mainResource = set.createResource(URI.createFileURI(path));

		if(!new File(path).exists()) {
			save();
		}
		
		// try to load the resource
		try {
			this.mainResource.load(Collections.EMPTY_MAP);
		} catch (IOException e) {
			projectStatus = PROJECT_STATUS.FAILED;
			new XMIWorkspaceException("Resource " + xmiFilePath
					+ " cannot be loaded.", e);
		}

		// add contained objects to the project
		for (EObject eObject : mainResource.getContents()) {
			metaContext.addModel(eObject.eClass().getEPackage().getNsPrefix());
		}
	}

	/**
	 * Implements listenerAdapter to save resources when they change.
	 */
	private void buildEContentAdapter() {
		listenerAdapter = new EContentAdapter() {
			/**
			 * This method is being called when an object in the model changes,
			 * it persists the changes instantly to the xmi resource
			 */
			@Override
			public void notifyChanged(Notification notification) {

				if (objectInitialized && !notification.isTouch()) {

					// save the changed objects
					Object changedObj = notification.getNotifier();

					// OW: maybe be cleverer about which notification should
					// trigger projectChanged
					if (changedObj instanceof EObject
							|| (changedObj instanceof Resource && Resource.RESOURCE__CONTENTS == notification
									.getFeatureID(null))) {
						projectChanged();
					}
				}
				super.notifyChanged(notification);
			}
		};
	}

	/**
	 * {@inheritDoc}
	 */
	public void addECPProjectListener(ECPProjectListener listener) {
		this.projectListeners.add(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean contains(EObject eObject) {
		if (eObject == this)
			return true;
		return getAllModelElements().contains(eObject);
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		// remove all references to other objects
		// so the garbage collector can remove this object
		projectDeleted();

		projectListeners = null;
		listenerAdapter = null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<EObject> getAllModelElement() {
		return getAllModelElements();
	}

	/**
	 * Returns all elements contained in the project that have the specified
	 * class type.
	 * 
	 * @return Returns only objects with the given EClass.
	 */
	public Collection<EObject> getAllModelElementsbyClass(EClass clazz,
			BasicEList<EObject> basicEList) {
		EList<EObject> result;

		// initialize result-list
		if (basicEList.isEmpty()) {
			result = basicEList;
		} else {
			result = new BasicEList<EObject>();
			result.addAll(basicEList);
		}

		// get contained elements
		Collection<EObject> allElements = getAllModelElements();

		// filter the elements and add them to the result if they fit
		for (EObject eo : allElements) {
			if (eo.eClass().equals(clazz))
				result.add(eo);
		}

		return result;

	}

	/**
	 * {@inheritDoc}
	 */
	public EObject getRootObject() {
		if (!objectInitialized)
			init();
		return rootObject;
	}

	/**
	 * CAUTION: this feature is not supported by this plugin!
	 */
	public boolean isNonDomainElement(EObject eObject) {
		return false; // CAUTION: this feature is not supported by this plugin!
	}

	/**
	 * Calls save on the resource of this project.
	 */
	private void save() {
		// simply call save on the resource
		try {
			if (mainResource == null || mainResource.getResourceSet() == null) {
				return;
			}
			for (Resource res : mainResource.getResourceSet().getResources()) {
				res.save(Collections.EMPTY_MAP);
			}
		} catch (IOException e) {
			projectStatus = PROJECT_STATUS.FAILED;
			new XMIWorkspaceException(
					"Cannot save changes to xmi-project-file.", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void modelelementDeleted(EObject eobject) {
		if (!objectInitialized)
			init();
		// Remove model element from xmi-file -> just save it.
		save();

		// tell listeners about the event
		for (ECPProjectListener listener : projectListeners) {
			listener.modelelementDeleted(eobject);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void projectChanged() {
		if (!objectInitialized)
			init();
		// Save all objects into the xmi-file
		save();

		// tell listeners about the event
		for (ECPProjectListener listener : projectListeners) {
			listener.projectChanged();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void projectDeleted() {
		// tell listeners about the event
		for (ECPProjectListener listener : projectListeners) {
			listener.projectDeleted();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeECPProjectListener(ECPProjectListener listener) {
		this.projectListeners.remove(listener);

	}

	/**
	 * {@inheritDoc}
	 */
	public void setRootObject(EObject value) {
		this.rootObject = value;

	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<EObject> getAllModelElements() {
		if (!objectInitialized)
			init();
		// make new result list that no pointer is returned
		ArrayList<EObject> result = new ArrayList<EObject>();

		// go through all baseElements and add their tree to result
		for (EObject eo : mainResource.getContents()) {
			result.add(eo);
			TreeIterator<EObject> contents = eo.eAllContents();
			while (contents.hasNext()) {
				result.add(contents.next());
			}
		}

		// return complete list of all elements contained in this project
		return result;
	}

	/**
	 * CAUTION: This feature is not supported by this plugin!
	 */
	public ECPAssociationClassElement getAssociationClassElement(EObject eObject) {
		return null; // CAUTION: this feature is not supported by this plugin!
	}

	/**
	 * {@inheritDoc}
	 */
	public EditingDomain getEditingDomain() {
		return getWorkspace().getEditingDomain();
	}

	/**
	 * {@inheritDoc}
	 */
	public ECPMetaModelElementContext getMetaModelElementContext() {
		if (metaContext == null) {
			metaContext = new XMIMetaModelElementContext();
		}
		return metaContext;
	}

	/**
	 * CAUTION: this feature is not supported by this plugin!
	 */
	public boolean isAssociationClassElement(EObject eObject) {
		return false; // CAUTION: this feature is not supported by this plugin!
	}

	/**
	 * {@inheritDoc}
	 */
	public void addModelElementToRoot(EObject eObject) {
		// add the element to the resource so it will be saved in the xmi-file
		mainResource.getContents().add(eObject);
		metaContext.addModel(eObject.eClass().getEPackage().getNsPrefix());
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<EObject> getRootLevel() {
		ArrayList<EObject> arrayList = new ArrayList<EObject>();
		arrayList.addAll(mainResource.getContents());
		return arrayList;
	}

	/**
	 * {@inheritDoc}
	 */
	public PROJECT_STATUS getProjectStatus() {
		return projectStatus;
	}

	/**
	 * Load the projects contents.
	 */
	public void loadContents() {
		if (!objectInitialized)
			init();
	}

	/**
	 * Get the project listeners to inform them when project was deleted.
	 */
	public List<ECPProjectListener> getProjectListeners() {
		return projectListeners;
	}

	/**
	 * Sets the project status, e.g. when a project file is corrupted or not
	 * found.
	 * 
	 * @param status
	 *            Current project status.
	 */
	public void setProjectStatus(XmiUtil.PROJECT_STATUS status) {
		projectStatus = status;
	}

	/**
	 * Retrieve whether the filepath is relative to workspace
	 * 
	 * @return true if the filepath is relative to workspace else false
	 */
	public boolean isWorkspacePath() {
		return isWorkspacePath;
	}

	/**
	 * Sets whether the filepath is relative to workspace
	 * 
	 * @param isWsP
	 */
	public void isWorkspacePath(boolean isWsP) {
		this.isWorkspacePath = isWsP;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructurePackage.Literals.XMIECP_FILE_PROJECT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setProjectName(String newProjectName) {
		String oldProjectName = projectName;
		projectName = newProjectName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					StructurePackage.XMIECP_FILE_PROJECT__PROJECT_NAME,
					oldProjectName, projectName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getProjectDescription() {
		return projectDescription;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setProjectDescription(String newProjectDescription) {
		String oldProjectDescription = projectDescription;
		projectDescription = newProjectDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					StructurePackage.XMIECP_FILE_PROJECT__PROJECT_DESCRIPTION,
					oldProjectDescription, projectDescription));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getXmiFilePath() {
		return xmiFilePath;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getResolvedXmiFilePath() {
		if (isWorkspacePath()) {
			return XmiUtil.WORKSPACE_PATH + File.separator + getXmiFilePath();
		} else {
			return getXmiFilePath();
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setXmiFilePath(String newXmiFilePath) {
		String oldXmiFilePath = xmiFilePath;
		xmiFilePath = newXmiFilePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					StructurePackage.XMIECP_FILE_PROJECT__XMI_FILE_PATH,
					oldXmiFilePath, xmiFilePath));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case StructurePackage.XMIECP_FILE_PROJECT__PROJECT_NAME:
			return getProjectName();
		case StructurePackage.XMIECP_FILE_PROJECT__PROJECT_DESCRIPTION:
			return getProjectDescription();
		case StructurePackage.XMIECP_FILE_PROJECT__XMI_FILE_PATH:
			return getXmiFilePath();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case StructurePackage.XMIECP_FILE_PROJECT__PROJECT_NAME:
			setProjectName((String) newValue);
			return;
		case StructurePackage.XMIECP_FILE_PROJECT__PROJECT_DESCRIPTION:
			setProjectDescription((String) newValue);
			return;
		case StructurePackage.XMIECP_FILE_PROJECT__XMI_FILE_PATH:
			setXmiFilePath((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case StructurePackage.XMIECP_FILE_PROJECT__PROJECT_NAME:
			setProjectName(PROJECT_NAME_EDEFAULT);
			return;
		case StructurePackage.XMIECP_FILE_PROJECT__PROJECT_DESCRIPTION:
			setProjectDescription(PROJECT_DESCRIPTION_EDEFAULT);
			return;
		case StructurePackage.XMIECP_FILE_PROJECT__XMI_FILE_PATH:
			setXmiFilePath(XMI_FILE_PATH_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case StructurePackage.XMIECP_FILE_PROJECT__PROJECT_NAME:
			return PROJECT_NAME_EDEFAULT == null ? projectName != null
					: !PROJECT_NAME_EDEFAULT.equals(projectName);
		case StructurePackage.XMIECP_FILE_PROJECT__PROJECT_DESCRIPTION:
			return PROJECT_DESCRIPTION_EDEFAULT == null ? projectDescription != null
					: !PROJECT_DESCRIPTION_EDEFAULT.equals(projectDescription);
		case StructurePackage.XMIECP_FILE_PROJECT__XMI_FILE_PATH:
			return XMI_FILE_PATH_EDEFAULT == null ? xmiFilePath != null
					: !XMI_FILE_PATH_EDEFAULT.equals(xmiFilePath);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (projectName: ");
		result.append(projectName);
		result.append(", projectDescription: ");
		result.append(projectDescription);
		result.append(", xmiFilePath: ");
		result.append(xmiFilePath);
		result.append(')');
		return result.toString();
	}

	public Resource getMainResource() {
		return mainResource;
	}

} // XMIECPFileProjectImpl
