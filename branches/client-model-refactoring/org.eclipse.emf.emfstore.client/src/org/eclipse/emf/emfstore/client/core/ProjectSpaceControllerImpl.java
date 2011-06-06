package org.eclipse.emf.emfstore.client.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.emfstore.client.WorkspaceManager;
import org.eclipse.emf.emfstore.client.changeTracking.CompositeOperationHandle;
import org.eclipse.emf.emfstore.client.changeTracking.OperationManager;
import org.eclipse.emf.emfstore.client.changeTracking.OperationRecorder;
import org.eclipse.emf.emfstore.client.changeTracking.commands.EMFStoreCommandStack;
import org.eclipse.emf.emfstore.client.connectionmanager.ConnectionManager;
import org.eclipse.emf.emfstore.client.exceptions.ChangeConflictException;
import org.eclipse.emf.emfstore.client.exceptions.CommitCanceledException;
import org.eclipse.emf.emfstore.client.exceptions.IllegalProjectSpaceStateException;
import org.eclipse.emf.emfstore.client.exceptions.MEUrlResolutionException;
import org.eclipse.emf.emfstore.client.exceptions.NoChangesOnServerException;
import org.eclipse.emf.emfstore.client.exceptions.NoLocalChangesException;
import org.eclipse.emf.emfstore.client.exceptions.PropertyNotFoundException;
import org.eclipse.emf.emfstore.client.filetransfer.FileDownloadStatus;
import org.eclipse.emf.emfstore.client.filetransfer.FileInformation;
import org.eclipse.emf.emfstore.client.filetransfer.FileTransferManager;
import org.eclipse.emf.emfstore.client.model.ModelFactory;
import org.eclipse.emf.emfstore.client.model.OperationComposite;
import org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.observers.CommitObserver;
import org.eclipse.emf.emfstore.client.observers.ConflictResolver;
import org.eclipse.emf.emfstore.client.observers.OperationListener;
import org.eclipse.emf.emfstore.client.observers.ShareObserver;
import org.eclipse.emf.emfstore.client.observers.UpdateObserver;
import org.eclipse.emf.emfstore.client.preferences.PropertyKey;
import org.eclipse.emf.emfstore.client.util.Configuration;
import org.eclipse.emf.emfstore.client.util.ModifiedModelElementsCache;
import org.eclipse.emf.emfstore.client.util.StatePersister;
import org.eclipse.emf.emfstore.client.util.WorkspaceUtil;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.impl.ProjectImpl;
import org.eclipse.emf.emfstore.common.model.util.AutoSplitAndSaveResourceContainmentList;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.conflictDetection.ConflictDetector;
import org.eclipse.emf.emfstore.server.exceptions.BaseVersionOutdatedException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.FileTransferException;
import org.eclipse.emf.emfstore.server.model.FileIdentifier;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.OrgUnitProperty;
import org.eclipse.emf.emfstore.server.model.url.ModelElementUrlFragment;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.LogMessage;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.TagVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.VersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.VersioningFactory;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.SemanticCompositeOperation;

public class ProjectSpaceControllerImpl implements
		ProjectSpaceControllerInternal {

	private final ProjectSpaceDataInternal internalProjectSpaceData;
	private List<CommitObserver> commitObservers;
	private List<OperationListener> operationListeners;
	private List<ShareObserver> shareObservers;
	private Map<String, OrgUnitProperty> propertyMap;
	private ModifiedModelElementsCache modifiedModelElementsCache;
	private boolean initCompleted;
	private boolean splitResource;
	private OperationManager operationManager;
	private boolean isTransient;
	private FileTransferManager fileTransferManager;
	private OperationRecorder operationRecorder;
	private StatePersister statePersister;
	private AutoSplitAndSaveResourceContainmentList<AbstractOperation> operationsList;

	public ProjectSpaceControllerImpl(
			ProjectSpaceDataInternal internalProjectSpaceData) {
		this.internalProjectSpaceData = internalProjectSpaceData;
		// TODO remove observer/listeners and use observerbus
		this.commitObservers = new ArrayList<CommitObserver>();
		this.operationListeners = new ArrayList<OperationListener>();
		this.shareObservers = new ArrayList<ShareObserver>();
		this.propertyMap = new HashMap<String, OrgUnitProperty>();
		this.operationListeners = new ArrayList<OperationListener>();
		// TODO: file transfer manager init
		this.fileTransferManager = null;
		// new FileTransferManager(internalProjectSpaceData);
		modifiedModelElementsCache = new ModifiedModelElementsCache(
				internalProjectSpaceData);

		this.addCommitObserver(modifiedModelElementsCache);
		this.splitResource = true;
		shareObservers.add(modifiedModelElementsCache);

	}

	private void addCommitObserver(
			ModifiedModelElementsCache modifiedModelElementsCache2) {

	}

	public void initResources(ResourceSet resourceSet) {
		initCompleted = true;
		String projectSpaceFileNamePrefix = Configuration
				.getWorkspaceDirectory()
				+ Configuration.getProjectSpaceDirectoryPrefix()
				+ internalProjectSpaceData.getIdentifier() + File.separatorChar;
		String projectSpaceFileName = projectSpaceFileNamePrefix
				+ internalProjectSpaceData.getProjectName()
				+ Configuration.getProjectSpaceFileExtension();
		String operationsCompositeFileName = projectSpaceFileNamePrefix
				+ internalProjectSpaceData.getProjectName()
				+ Configuration.getOperationCompositeFileExtension();
		String projectFragementsFileNamePrefix = projectSpaceFileNamePrefix
				+ Configuration.getProjectFolderName() + File.separatorChar;
		URI projectSpaceURI = URI.createFileURI(projectSpaceFileName);
		URI operationCompositeURI = URI
				.createFileURI(operationsCompositeFileName);

		internalProjectSpaceData.setResourceCount(0);
		String fileName = projectFragementsFileNamePrefix
				+ internalProjectSpaceData.getResourceCount()
				+ Configuration.getProjectFragmentFileExtension();
		URI fileURI = URI.createFileURI(fileName);

		List<Resource> resources = new ArrayList<Resource>();
		Resource resource = resourceSet.createResource(fileURI);
		// if resource splitting fails, we need a reference to the old resource
		Resource oldResource = resource;
		resource.getContents().add(internalProjectSpaceData.getProject());
		resources.add(resource);
		internalProjectSpaceData.setResourceCount(internalProjectSpaceData
				.getResourceCount() + 1);
		List<EObject> modelElements = internalProjectSpaceData.getProject()
				.getModelElements();

		boolean crossResource = Configuration.useCrossResourceRefs();

		// int counter = Configuration.getMaxMECountPerResource() + 1;
		int counter = 0;
		for (EObject modelElement : modelElements) {

			if (counter > Configuration.getMaxMECountPerResource()
					&& splitResource) {
				fileName = projectFragementsFileNamePrefix
						+ internalProjectSpaceData.getResourceCount()
						+ Configuration.getProjectFragmentFileExtension();
				fileURI = URI.createFileURI(fileName);
				oldResource = resource;
				resource = resourceSet.createResource(fileURI);
				internalProjectSpaceData
						.setResourceCount(internalProjectSpaceData
								.getResourceCount() + 1);
				resources.add(resource);
				counter = 0;
			}
			counter++;

			if (splitResource) {
				if (!crossResource) {
					EObject parent = modelElement.eContainer();
					ChangeRecorder changeRecorder = new ChangeRecorder();
					changeRecorder
							.beginRecording(Collections.singleton(parent));
					// try to pin resource
					resource.getContents().add(modelElement);
					ChangeDescription changeDesc = changeRecorder
							.endRecording();
					if (modelElement.eContainer() != parent) {
						splitResource = false;
						resource = oldResource;
						// model element lost its parent, revert changes
						changeDesc.apply();
					}
				} else {
					resource.getContents().add(modelElement);
				}
			}

			((XMIResource) resource).setID(
					modelElement,
					internalProjectSpaceData.getProject()
							.getModelElementId(modelElement).getId());
		}

		Resource operationCompositeResource = resourceSet
				.createResource(operationCompositeURI);
		if (internalProjectSpaceData.getLocalOperations() == null) {
			// TODO: check whether operation composite is needed at all
			internalProjectSpaceData.setLocalOperations(ModelFactory.eINSTANCE
					.createOperationComposite());
		}
		operationCompositeResource.getContents().add(
				internalProjectSpaceData.getLocalOperations());
		resources.add(operationCompositeResource);

		Resource projectSpaceResource = resourceSet
				.createResource(projectSpaceURI);
		projectSpaceResource.getContents().add(internalProjectSpaceData);
		resources.add(projectSpaceResource);

		// save all resources that have been created
		for (Resource currentResource : resources) {
			try {
				currentResource.save(Configuration.getResourceSaveOptions());
			} catch (IOException e) {
				WorkspaceUtil.logException(
						"Project Space resource init failed!", e);

			}
		}
		init();
	}

	public OperationManager getOperationManager() {
		return operationManager;
	}

	/**
	 * Stops current recording of changes and adds recorded changes to this
	 * project spaces changes.
	 * 
	 * @generated NOT
	 */
	public void stopChangeRecording() {
		this.operationRecorder.stopChangeRecording();
	}

	/**
	 * Starts change recording on this workspace, resumes previous recordings if
	 * there are any.
	 * 
	 * @generated NOT
	 */
	public void startChangeRecording() {
		this.operationRecorder.startChangeRecording();
		updateDirtyState();
	}

	/**
	 * Updates the dirty state of the project space.
	 */
	public void updateDirtyState() {
		internalProjectSpaceData.setDirty(!getOperations().isEmpty());
	}

	public void addOperation(AbstractOperation operation) {
		this.getOperations().add(operation);
		updateDirtyState();

		// do not notify on composite start, wait until completion
		if (operation instanceof CompositeOperation) {
			// check of automatic composite if yes then continue
			if (((CompositeOperation) operation).getMainOperation() == null) {
				return;
			}
		}
		operationManager.notifyOperationExecuted(operation);
		// this.notifyOperationExecuted(operation);
	}

	public CompositeOperationHandle createCompositeOperation() {
		return this.operationManager.beginCompositeOperation();
	}

	public void init() {
		initCompleted = true;

		// TODO file transfer manager init
		this.fileTransferManager = null;
		// new FileTransferManager(
		// internalProjectSpaceData, this);
		// EObjectChangeNotifier changeNotifier = new EObjectChangeNotifier(
		// this.getProject());
		this.operationRecorder = new OperationRecorder(
				internalProjectSpaceData.getProject(),
				((ProjectImpl) internalProjectSpaceData.getProject())
						.getChangeNotifier());
		this.operationManager = new OperationManager(operationRecorder, this);
		this.operationManager.addOperationListener(modifiedModelElementsCache);
		statePersister = new StatePersister(
				operationRecorder.getChangeNotifier(),
				((EMFStoreCommandStack) Configuration.getEditingDomain()
						.getCommandStack()),
				internalProjectSpaceData.getProject());
		// TODO: initialization order important
		internalProjectSpaceData.getProject().addProjectChangeObserver(
				this.operationRecorder);
		internalProjectSpaceData.getProject().addProjectChangeObserver(
				statePersister);

		// TODO: copy listener, won't be needed anyway
		// internalProjectSpaceData.getProject().addCopyListener(this);

		if (internalProjectSpaceData.getProject() instanceof ProjectImpl) {
			((ProjectImpl) internalProjectSpaceData.getProject())
					.setUndetachable(operationRecorder);
		}
		if (internalProjectSpaceData.getUsersession() != null) {
			// TODO: usersession addloginobserver
			// internalProjectSpaceData.getUsersession().addLoginObserver(this);
			ACUser acUser = internalProjectSpaceData.getUsersession()
					.getACUser();
			if (acUser != null) {
				for (OrgUnitProperty p : acUser.getProperties()) {
					if (p.getProject() != null
							&& p.getProject().equals(
									internalProjectSpaceData.getProjectId())) {
						propertyMap.put(p.getName(), p);
					}
				}
			}
		}
		modifiedModelElementsCache.initializeCache();
		startChangeRecording();
		cleanCutElements();

	}

	public void undoLastOperation() {
		if (!this.getOperations().isEmpty()) {
			List<AbstractOperation> operations = this.getOperations();
			AbstractOperation lastOperation = operations
					.get(operations.size() - 1);
			stopChangeRecording();
			lastOperation.reverse()
					.apply(internalProjectSpaceData.getProject());
			operationManager.notifyOperationUndone(lastOperation);
			startChangeRecording();
			operations.remove(lastOperation);
		}
		updateDirtyState();
	}

	public void applyMergeResult(List<AbstractOperation> mergeResult,
			VersionSpec mergeTargetSpec) throws EmfStoreException {
		revert();
		update(mergeTargetSpec);

		applyOperations(mergeResult);
	}

	public void makeTransient() {
		if (initCompleted) {
			throw new IllegalAccessError(
					"Project Space cannot be set to transient after init.");
		}
		isTransient = true;
	}

	public boolean isTransient() {
		return isTransient;
	}

	public void transmitProperties() {
		List<OrgUnitProperty> temp = new ArrayList<OrgUnitProperty>();
		for (OrgUnitProperty changedProperty : internalProjectSpaceData
				.getUsersession().getChangedProperties()) {
			if (changedProperty.getProject() != null
					&& changedProperty.getProject().equals(
							internalProjectSpaceData.getProjectId())) {
				temp.add(changedProperty);
			}
		}
		ListIterator<OrgUnitProperty> iterator = temp.listIterator();
		while (iterator.hasNext()) {
			try {
				WorkspaceManager
						.getInstance()
						.getConnectionManager()
						.transmitProperty(
								internalProjectSpaceData.getUsersession()
										.getSessionId(),
								iterator.next(),
								internalProjectSpaceData.getUsersession()
										.getACUser(),
								internalProjectSpaceData.getProjectId());
				iterator.remove();
			} catch (EmfStoreException e) {
				WorkspaceUtil.logException(
						"Transmission of properties failed with exception", e);
			}
		}
	}

	public PrimaryVersionSpec commit() throws EmfStoreException {
		LogMessage logMessage = VersioningFactory.eINSTANCE.createLogMessage();
		String commiter = "UNKOWN";
		if (internalProjectSpaceData.getUsersession().getACUser() != null
				&& internalProjectSpaceData.getUsersession().getACUser()
						.getName() != null) {
			commiter = internalProjectSpaceData.getUsersession().getACUser()
					.getName();
		}
		logMessage.setAuthor(commiter);
		logMessage.setClientDate(new Date());
		logMessage.setMessage("");
		return commit(logMessage);
	}

	public PrimaryVersionSpec commit(LogMessage logMessage)
			throws EmfStoreException {
		return commit(logMessage, null);
	}

	public PrimaryVersionSpec commit(LogMessage logMessage,
			CommitObserver commitObserver) throws EmfStoreException,
			BaseVersionOutdatedException {
		ChangePackage changePackage;
		try {
			changePackage = prepareCommit(commitObserver);
			return finalizeCommit(changePackage, logMessage, commitObserver);

		} catch (CommitCanceledException e) {
			return internalProjectSpaceData.getBaseVersion();
		}
	}

	public PrimaryVersionSpec update() throws EmfStoreException {
		return update(VersionSpec.HEAD_VERSION);
	}

	public PrimaryVersionSpec update(VersionSpec version)
			throws EmfStoreException {
		return update(version, null);
	}

	public PrimaryVersionSpec update(VersionSpec version,
			UpdateObserver observer) throws EmfStoreException,
			ChangeConflictException {

		final ConnectionManager connectionManager = WorkspaceManager
				.getInstance().getConnectionManager();
		final PrimaryVersionSpec resolvedVersion = resolveVersionSpec(version);

		if (resolvedVersion
				.compareTo(internalProjectSpaceData.getBaseVersion()) == 0) {
			throw new NoChangesOnServerException();
		}

		List<ChangePackage> changes = new ArrayList<ChangePackage>();

		changes = connectionManager.getChanges(internalProjectSpaceData
				.getUsersession().getSessionId(), internalProjectSpaceData
				.getProjectId(), internalProjectSpaceData.getBaseVersion(),
				resolvedVersion);

		ChangePackage localchanges = getLocalChangePackage(false);

		ConflictDetector conflictDetector = new ConflictDetector();
		for (ChangePackage change : changes) {
			if (conflictDetector.doConflict(change, localchanges)) {
				throw new ChangeConflictException(changes,
						internalProjectSpaceData, conflictDetector);
			}
		}

		// notify updateObserver if there is one
		if (observer != null
				&& !observer.inspectChanges(internalProjectSpaceData, changes)) {
			return internalProjectSpaceData.getBaseVersion();
		}

		final List<ChangePackage> cps = changes;

		// revert
		this.revert();

		// apply changes from repo
		for (ChangePackage change : cps) {
			applyOperations(change.getCopyOfOperations(), false);
		}

		// reapply local changes
		applyOperations(localchanges.getCopyOfOperations(), true);

		internalProjectSpaceData.setBaseVersion(resolvedVersion);
		saveProjectSpaceOnly();

		// create notifications only if the project is updated to a newer
		// version
		if (resolvedVersion
				.compareTo(internalProjectSpaceData.getBaseVersion()) == 1) {
			// TODO: generate notifications
			// generateNotifications(changes);
		}

		// TODO Chainsaw. Do we need this anymore?
		if (observer != null) {
			observer.updateCompleted(internalProjectSpaceData);
		}
		WorkspaceManager.getObserverBus().notify(UpdateObserver.class)
				.updateCompleted(internalProjectSpaceData);

		// check for operations on file attachments: if version has been
		// increased and file is required offline, add to
		// pending file transfers
		// checkUpdatedFileAttachments(changes);

		return resolvedVersion;
	}

	/**
	 * Saves the project space itself only, no containment children.
	 */
	public void saveProjectSpaceOnly() {
		saveResource(internalProjectSpaceData.eResource());
	}

	/**
	 * Save the given resource that is part of the project space resource set.
	 * 
	 * @param resource
	 *            the resource
	 */
	public void saveResource(Resource resource) {
		try {
			if (resource == null) {
				if (!isTransient) {
					WorkspaceUtil
							.logException(
									"Resources of project space are not properly initialized!",
									new IllegalProjectSpaceStateException(
											"Resource to save is null"));
				}
				return;
			}
			resource.save(Configuration.getResourceSaveOptions());
		} catch (IOException e) {
			WorkspaceUtil
					.logException(
							"An error in the data was detected during save! The safest way to deal with this problem is to delete this project and checkout again.",
							e);
		}
	}

	public void shareProject(Usersession usersession) throws EmfStoreException {
		// TODO: usersession addloginobserver
		// usersession.addLoginObserver(this);
		LogMessage logMessage = VersioningFactory.eINSTANCE.createLogMessage();
		logMessage.setAuthor(usersession.getUsername());
		logMessage.setClientDate(new Date());
		logMessage.setMessage("Initial commit");
		ProjectInfo createdProject;

		stopChangeRecording();
		statePersister.setAutoSave(false);

		// TODO: PlainEObjectMode: Set user as creator when sharing a project
		// for (EObject me : this.getProject().getAllModelElements()) {
		// if (me.getCreator() == null || me.getCreator().equals("")
		// || me.getCreator().equals(ProjectChangeTracker.UNKOWN_CREATOR)) {
		// me.setCreator(usersession.getUsername());
		// changeTracker.save(me);
		// }
		// }

		createdProject = WorkspaceManager
				.getInstance()
				.getConnectionManager()
				.createProject(usersession.getSessionId(),
						internalProjectSpaceData.getProjectName(),
						internalProjectSpaceData.getProjectDescription(),
						logMessage, internalProjectSpaceData.getProject());
		statePersister.setAutoSave(true);
		statePersister.saveDirtyResources();
		startChangeRecording();
		internalProjectSpaceData.setBaseVersion(createdProject.getVersion());
		internalProjectSpaceData.setLastUpdated(new Date());
		internalProjectSpaceData.setProjectId(createdProject.getProjectId());
		this.saveProjectSpaceOnly();

		// If any files have already been added, upload them.
		fileTransferManager.uploadQueuedFiles(new NullProgressMonitor());

		notifyShareObservers();
		getOperations().clear();
		// TODO: usersession updateprojectinfos
		// usersession.updateProjectInfos();
		updateDirtyState();
	}

	private void notifyShareObservers() {
		for (ShareObserver shareObserver : shareObservers) {
			try {
				shareObserver.shareDone();
				// BEGIN SUPRESS CATCH EXCEPTION
			} catch (RuntimeException e) {
				// END SUPRESS CATCH EXCEPTION
				WorkspaceUtil.logException(
						"ShareObserver failed with exception", e);
			}
		}
	}

	public void exportProject(String absoluteFileName) throws IOException {
		WorkspaceManager.getInstance().getCurrentWorkspace()
				.exportProject(internalProjectSpaceData, absoluteFileName);
	}

	public void importLocalChanges(String fileName) throws IOException {
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(
				URI.createFileURI(fileName), true);
		EList<EObject> directContents = resource.getContents();
		// sanity check

		if (directContents.size() != 1
				&& (!(directContents.get(0) instanceof ChangePackage))) {
			throw new IOException("File is corrupt, does not contain Changes.");
		}

		ChangePackage changePackage = (ChangePackage) directContents.get(0);
		applyOperationsWithRecording(changePackage.getOperations(), true);
	}

	public List<AbstractOperation> getOperations() {
		// check if operation composite exists
		OperationComposite operationComposite = internalProjectSpaceData
				.getLocalOperations();
		if (operationComposite == null) {
			internalProjectSpaceData.setLocalOperations(ModelFactory.eINSTANCE
					.createOperationComposite());
			operationComposite = internalProjectSpaceData.getLocalOperations();
		}
		if (isTransient) {
			return operationComposite.getOperations();
		}
		if (operationsList == null) {
			operationsList = new AutoSplitAndSaveResourceContainmentList<AbstractOperation>(
					operationComposite, operationComposite.getOperations(),
					internalProjectSpaceData.eResource().getResourceSet(),
					Configuration.getWorkspaceDirectory() + "ps-"
							+ internalProjectSpaceData.getIdentifier()
							+ File.separatorChar + "operations", ".off");
		}
		return operationsList;
	}

	public FileIdentifier addFile(File file) throws FileTransferException {
		return fileTransferManager.addFile(file);
	}

	public FileDownloadStatus getFile(FileIdentifier fileIdentifier)
			throws FileTransferException {
		return fileTransferManager.getFile(fileIdentifier);
	}

	public FileInformation getFileInfo(FileIdentifier fileIdentifier) {
		return fileTransferManager.getFileInfo(fileIdentifier);
	}

	public void addTag(PrimaryVersionSpec versionSpec, TagVersionSpec tag)
			throws EmfStoreException {
		final ConnectionManager cm = WorkspaceManager.getInstance()
				.getConnectionManager();
		cm.addTag(internalProjectSpaceData.getUsersession().getSessionId(),
				internalProjectSpaceData.getProjectId(), versionSpec, tag);
	}

	public void removeTag(PrimaryVersionSpec versionSpec, TagVersionSpec tag)
			throws EmfStoreException {
		final ConnectionManager cm = WorkspaceManager.getInstance()
				.getConnectionManager();
		cm.removeTag(internalProjectSpaceData.getUsersession().getSessionId(),
				internalProjectSpaceData.getProjectId(), versionSpec, tag);
	}

	/**
	 * @generated NOT
	 */
	private void cleanCutElements() {
		for (EObject cutElement : internalProjectSpaceData.getProject()
				.getCutElements()) {
			internalProjectSpaceData.getProject()
					.deleteModelElement(cutElement);
		}

	}

	public ChangePackage prepareCommit(CommitObserver commitObserver)
			throws EmfStoreException {
		// check if there are any changes
		if (!internalProjectSpaceData.isDirty()) {
			throw new NoLocalChangesException();
		}

		cleanCutElements();

		// check if we need to update first
		PrimaryVersionSpec resolvedVersion = resolveVersionSpec(VersionSpec.HEAD_VERSION);
		if ((!internalProjectSpaceData.getBaseVersion().equals(resolvedVersion))) {
			throw new BaseVersionOutdatedException();
		}

		ChangePackage changePackage = getLocalChangePackage(true);
		if (changePackage.getOperations().isEmpty()) {
			for (AbstractOperation operation : getOperations()) {
				operationManager.notifyOperationUndone(operation);
			}
			getOperations().clear();
			updateDirtyState();
			throw new NoLocalChangesException();
		}

		notifyPreCommitObservers(changePackage);

		if (commitObserver != null
				&& !commitObserver.inspectChanges(internalProjectSpaceData,
						changePackage)) {
			throw new CommitCanceledException(
					"Changes have been canceld by the user.");
		}

		return changePackage;
	}

	private void notifyPreCommitObservers(ChangePackage changePackage) {
		for (CommitObserver observer : commitObservers) {
			try {
				observer.inspectChanges(internalProjectSpaceData, changePackage);
				// BEGIN SUPRESS CATCH EXCEPTION
			} catch (RuntimeException e) {
				// END SUPRESS CATCH EXCEPTION
				WorkspaceUtil.logException(
						"CommitObserver failed with exception", e);
			}
		}
	}

	public PrimaryVersionSpec finalizeCommit(ChangePackage changePackage,
			LogMessage logMessage, CommitObserver commitObserver)
			throws EmfStoreException {
		final ConnectionManager connectionManager = WorkspaceManager
				.getInstance().getConnectionManager();

		PrimaryVersionSpec newBaseVersion = connectionManager.createVersion(
				internalProjectSpaceData.getUsersession().getSessionId(),
				internalProjectSpaceData.getProjectId(),
				internalProjectSpaceData.getBaseVersion(), changePackage,
				logMessage);

		internalProjectSpaceData.setBaseVersion(newBaseVersion);
		getOperations().clear();
		// TODO:
		// getEventsFromComposite().clear();

		saveProjectSpaceOnly();

		if (commitObserver != null) {
			commitObserver.commitCompleted(internalProjectSpaceData,
					newBaseVersion);
		}

		fileTransferManager.uploadQueuedFiles(new NullProgressMonitor());

		notifyPostCommitObservers(newBaseVersion);

		updateDirtyState();

		return newBaseVersion;
	}

	private void notifyPostCommitObservers(PrimaryVersionSpec newBaseVersion) {
		for (CommitObserver observer : commitObservers) {
			try {
				observer.commitCompleted(internalProjectSpaceData,
						newBaseVersion);
				// BEGIN SUPRESS CATCH EXCEPTION
			} catch (RuntimeException e) {
				// END SUPRESS CATCH EXCEPTION
				WorkspaceUtil.logException(
						"CommitObserver failed with exception", e);
			}
		}
	}

	public OrgUnitProperty getProperty(PropertyKey name)
			throws PropertyNotFoundException {
		// sanity checks
		if (internalProjectSpaceData.getUsersession() != null
				&& internalProjectSpaceData.getUsersession().getACUser() != null) {
			OrgUnitProperty orgUnitProperty = propertyMap.get(name);
			if (orgUnitProperty != null) {
				return orgUnitProperty;
			}
		}
		throw new PropertyNotFoundException();
	}

	public boolean hasProperty(PropertyKey key) {
		return propertyMap.containsKey(key.toString());
	}

	/**
	 * getter for a string argument - see {@link #setProperty(OrgUnitProperty)}.
	 * 
	 * @generated NOT
	 */
	private OrgUnitProperty getProperty(String name)
			throws PropertyNotFoundException {
		// sanity checks
		if (internalProjectSpaceData.getUsersession() != null
				&& internalProjectSpaceData.getUsersession().getACUser() != null) {
			OrgUnitProperty orgUnitProperty = propertyMap.get(name);
			if (orgUnitProperty != null) {
				return orgUnitProperty;
			}
		}
		throw new PropertyNotFoundException();
	}

	public void setProperty(OrgUnitProperty property) {
		// sanity checks
		if (internalProjectSpaceData.getUsersession() != null
				&& internalProjectSpaceData.getUsersession().getACUser() != null) {
			try {
				if (property.getProject() == null) {
					property.setProject(ModelUtil
							.clone(internalProjectSpaceData.getProjectId()));
				} else if (!property.getProject().equals(
						internalProjectSpaceData.getProjectId())) {
					return;
				}
				OrgUnitProperty prop = getProperty(property.getName());
				prop.setValue(property.getValue());
			} catch (PropertyNotFoundException e) {
				internalProjectSpaceData.getUsersession().getACUser()
						.getProperties().add(property);
				propertyMap.put(property.getName(), property);
			}
			// the properties that have been altered are retained in a separate
			// list
			for (OrgUnitProperty changedProperty : internalProjectSpaceData
					.getUsersession().getChangedProperties()) {
				if (changedProperty.getName().equals(property.getName())
						&& changedProperty.getProject().equals(
								internalProjectSpaceData.getProjectId())) {
					changedProperty.setValue(property.getValue());
					WorkspaceManager.getInstance().getCurrentWorkspace().save();
					return;
				}
			}
			internalProjectSpaceData.getUsersession().getChangedProperties()
					.add(property);
			WorkspaceManager.getInstance().getCurrentWorkspace().save();
		}
	}

	public void revert() {
		while (!getOperations().isEmpty()) {
			undoLastOperation();
		}
		updateDirtyState();
	}

	public PrimaryVersionSpec resolveVersionSpec(VersionSpec versionSpec)
			throws EmfStoreException {
		ConnectionManager connectionManager = WorkspaceManager.getInstance()
				.getConnectionManager();
		return connectionManager.resolveVersionSpec(internalProjectSpaceData
				.getUsersession().getSessionId(), internalProjectSpaceData
				.getProjectId(), versionSpec);
	}

	public List<ChangePackage> getChanges(VersionSpec sourceVersion,
			VersionSpec targetVersion) throws EmfStoreException {
		final ConnectionManager connectionManager = WorkspaceManager
				.getInstance().getConnectionManager();

		List<ChangePackage> changes = connectionManager.getChanges(
				internalProjectSpaceData.getUsersession().getSessionId(),
				internalProjectSpaceData.getProjectId(), sourceVersion,
				targetVersion);
		return changes;
	}

	public EObject resolve(ModelElementUrlFragment modelElementUrlFragment)
			throws MEUrlResolutionException {
		ModelElementId modelElementId = modelElementUrlFragment
				.getModelElementId();
		EObject modelElement = internalProjectSpaceData.getProject()
				.getModelElement(modelElementId);
		if (modelElement == null) {
			throw new MEUrlResolutionException();
		}
		return modelElement;
	}

	public void merge(PrimaryVersionSpec target,
			ConflictResolver conflictResolver) throws EmfStoreException {
		// merge the conflicts
		ChangePackage myCp = this.getLocalChangePackage(true);
		List<ChangePackage> theirCps = this.getChanges(
				internalProjectSpaceData.getBaseVersion(), target);
		if (conflictResolver.resolveConflicts(
				internalProjectSpaceData.getProject(), theirCps, myCp,
				internalProjectSpaceData.getBaseVersion(), target)) {

			// revert the local operations and apply all their operations
			this.revert();

			for (ChangePackage changePackage : theirCps) {
				applyOperations(changePackage.getOperations(), false);
			}

			// generate merge result and apply to local workspace
			List<AbstractOperation> acceptedMine = conflictResolver
					.getAcceptedMine();
			List<AbstractOperation> rejectedTheirs = conflictResolver
					.getRejectedTheirs();
			List<AbstractOperation> mergeResult = new ArrayList<AbstractOperation>();
			for (AbstractOperation operationToReverse : rejectedTheirs) {
				mergeResult.add(0, operationToReverse.reverse());
			}
			mergeResult.addAll(acceptedMine);

			applyOperations(mergeResult, true);

			internalProjectSpaceData.setBaseVersion(target);

			saveProjectSpaceOnly();
		}
	}

	public ChangePackage getLocalChangePackage(boolean canonized) {
		ChangePackage changePackage = VersioningFactory.eINSTANCE
				.createChangePackage();
		// copy operations from projectspace
		for (AbstractOperation abstractOperation : getOperations()) {
			AbstractOperation copy = EcoreUtil.copy(abstractOperation);
			changePackage.getOperations().add(copy);
		}

		// TODO: event composite
		// copy events from projectspace
		// for (Event event : getEventsFromComposite()) {
		// Event copy = EcoreUtil.copy(event);
		// changePackage.getEvents().add(copy);
		// }

		if (canonized) {
			changePackage.cannonize();
		}
		return changePackage;
	}

	public ModifiedModelElementsCache getModifiedModelElementsCache() {
		return modifiedModelElementsCache;
	}

	// TODO: EM, remove
	public void copyBegin() {
		operationRecorder.disableNotifications(true);
	}

	// TODO: EM, remove
	public void copyEnd() {
		operationRecorder.disableNotifications(false);
	}

	public void exportLocalChanges(String fileName) throws IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * Apply a list of operations to the project.
	 * 
	 * @param operations
	 *            the list of operations
	 */
	// TODO: check callers
	public void applyOperations(List<AbstractOperation> operations) {
		applyOperations(operations, true);
	}

	/**
	 * Applies a list of operations to the project. The change tracking is
	 * stopped and the operations are added to the projectspace.
	 * 
	 * @see #applyOperationsWithRecording(List, boolean)
	 * @param operations
	 *            list of operations
	 * @param addOperation
	 *            true if operation should be saved in project space.
	 */
	// TODO: check callers
	public void applyOperations(List<AbstractOperation> operations,
			boolean addOperation) {
		stopChangeRecording();
		for (AbstractOperation operation : operations) {
			operation.apply(internalProjectSpaceData.getProject());
			if (addOperation) {
				addOperation(operation);
			}
		}
		startChangeRecording();
	}

	/**
	 * Applies a list of operations to the project. It is possible to force
	 * import operations. Changetracking isn't deactivated while applying
	 * changes.
	 * 
	 * @param operations
	 *            list of operations
	 * @param force
	 *            if true, no exception is thrown if operation.apply failes
	 * @param semanticApply
	 *            when true, does a semanticApply if possible (see
	 *            {@link SemanticCompositeOperation})
	 */
	// TODO: check callers
	public void applyOperationsWithRecording(
			List<AbstractOperation> operations, boolean force,
			boolean semanticApply) {
		for (AbstractOperation operation : operations) {
			try {
				if (semanticApply
						&& operation instanceof SemanticCompositeOperation) {
					((SemanticCompositeOperation) operation)
							.semanticApply(internalProjectSpaceData
									.getProject());
				} else {
					operation.apply(internalProjectSpaceData.getProject());
				}
			} catch (IllegalStateException e) {
				if (!force) {
					throw e;
				}
			}
		}
	}

	/**
	 * Applies a list of operations to the project. This method is used by
	 * {@link #importLocalChanges(String)}. This method redirects to
	 * {@link #applyOperationsWithRecording(List, boolean, boolean)}, using
	 * false for semantic apply.
	 * 
	 * @param operations
	 *            list of operations
	 * @param force
	 *            if true, no exception is thrown if operation.apply failes
	 */
	// TODO: check callers
	public void applyOperationsWithRecording(
			List<AbstractOperation> operations, boolean force) {
		applyOperationsWithRecording(operations, force, false);
	}

}
