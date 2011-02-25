package org.unicase.emfstore.jdt.emf.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.impl.CreateDeleteOperationImpl;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.util.UnicaseUtil;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.OperationConsumer;
import org.unicase.workspace.changeTracking.NotificationToOperationConverter;
import org.unicase.workspace.changeTracking.commands.CommandObserver;
import org.unicase.workspace.changeTracking.commands.EMFStoreTransactionalCommandStack;
import org.unicase.workspace.changeTracking.notification.NotificationInfo;
import org.unicase.workspace.changeTracking.notification.filter.FilterStack;
import org.unicase.workspace.changeTracking.notification.recording.NotificationRecorder;
import org.unicase.workspace.impl.AbstractEObjectChangeObserver;
import org.unicase.workspace.impl.EObjectChangeNotifier;
import org.unicase.workspace.util.WorkspaceUtil;

public class JDTEObjectTracker extends AbstractEObjectChangeObserver implements CommandObserver {

	private boolean isRecording = true;
	private EMFStoreTransactionalCommandStack emfStoreTransactionalCommandStack;
	private TransactionalEditingDomain editingDomain;
	private final JDTIdProvider idProvider;
	private List<EObject> removedElements;
	private Set<EObject> currentClipboard;

	private NotificationToOperationConverter converter;
	private NotificationRecorder notificationRecorder;

	private List<AbstractOperation> operations;
	private CompositeOperation compositeOperation;
	private EObjectChangeNotifier eObjectChangeNotifier;

	public JDTEObjectTracker(JDTIdProvider idProvider, EObject eObjectToTrack) {
		this.idProvider = idProvider;
		editingDomain = Configuration.getEditingDomain();
		CommandStack commandStack = editingDomain.getCommandStack();

		if (!(commandStack instanceof EMFStoreTransactionalCommandStack)) {
			throw new IllegalStateException(
				"Setup of ResourceSet is invalid, there is no EMFStoreTransactionalCommandStack!");
		}
		emfStoreTransactionalCommandStack = (EMFStoreTransactionalCommandStack) commandStack;
		emfStoreTransactionalCommandStack.addCommandStackObserver(this);

		operations = new ArrayList<AbstractOperation>();
		removedElements = new ArrayList<EObject>();
		converter = new NotificationToOperationConverter(idProvider);

		eObjectChangeNotifier = new EObjectChangeNotifier(eObjectToTrack);
		eObjectChangeNotifier.addEObjectChangeObserver(this);
	}

	public void eObjectAdded(EObject eObject) {
		idProvider.addModelElementAndChildrenToCache(eObject);

		// if element was just pasted from clipboard then do nothing
		if (this.getModelElementsFromClipboard().contains(eObject)) {
			return;
		}

		addToResource(eObject);

		// notify post creation listeners
		// for (PostCreationListener l : postCreationListeners) {
		// l.onCreation(projectSpace, modelElement);
		// }

		if (isRecording) {
			CreateDeleteOperation createDeleteOperation = createCreateDeleteOperation(eObject, false);
			if (this.compositeOperation != null) {
				this.compositeOperation.getSubOperations().add(createDeleteOperation);

			} else {
				// projectSpace.addOperation(createDeleteOperation);
				operations.add(createDeleteOperation);

				// for (OperationConsumer opCo : operationConsumer) {
				// opCo.handleOperation(createDeleteOperation);
				// }
			}
		}
	}

	void addToResource(final EObject modelElement) {
		XMIResource oldResource = (XMIResource) modelElement.eResource();
		setModelElementIdAndChildrenIdOnResource(oldResource, modelElement);
	}

	private void setModelElementIdAndChildrenIdOnResource(XMIResource resource, EObject modelElement) {
		String modelElementId = idProvider.getModelElementId(modelElement).getId();
		resource.setID(modelElement, modelElementId);

		TreeIterator<EObject> it = modelElement.eAllContents();
		while (it.hasNext()) {
			EObject child = it.next();
			ModelElementId childId = idProvider.getModelElementId(child);
			resource.setID(child, childId.getId());
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#modelElementRemoved(org.unicase.metamodel.Project,
	 *      org.unicase.metamodel.ModelElement)
	 */
	public void eObjectRemoved(EObject eObject) {
		removedElements.add(eObject);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification,
	 *      org.unicase.metamodel.Project, org.unicase.metamodel.ModelElement)
	 */
	public void notify(Notification notification, EObject eObject) {

		// filter unwanted notifications
		if (FilterStack.DEFAULT.check(new NotificationInfo(notification))) {
			return;
		}

		// save(eObject);
		notificationRecorder.record(notification);
		if (notificationRecorder.isRecordingComplete()) {
			if (isRecording) {
				recordingFinished();
			}
			// saveDirtyResources();
		}
	}

	private void recordingFinished() {
		// create operations from "valid" notifications, log invalid ones, accumulate the ops
		List<AbstractOperation> ops = new LinkedList<AbstractOperation>();
		List<NotificationInfo> rec = notificationRecorder.getRecording().asMutableList();
		for (NotificationInfo n : rec) {
			if (!n.isValid()) {
				WorkspaceUtil.log("INVALID NOTIFICATION MESSAGE DETECTED: " + n.getValidationMessage(), null, 0);
				continue;
			} else {
				AbstractOperation op = converter.convert(n);
				if (op != null) {
					ops.add(op);
				} else {
					// we should never get here, this would indicate a consistency error,
					// n.isValid() should have been false
					WorkspaceUtil.log("INVALID NOTIFICATION CLASSIFICATION,"
						+ " notification is valid, but cannot be converted to an operation: " + n.toString(), null, 0);
					continue;
				}
			}
		}

		// add resulting operations as suboperations to composite or top-level operations
		if (compositeOperation != null) {
			compositeOperation.getSubOperations().addAll(ops);
			// projectSpace.saveResource(compositeOperation.eResource());

		} else {
			if (ops.size() > 1) {
				CompositeOperation op = OperationsFactory.eINSTANCE.createCompositeOperation();
				op.getSubOperations().addAll(ops);
				// set the last operation as the main one for natural composites
				op.setMainOperation(ops.get(ops.size() - 1));
				op.setModelElementId((ModelElementId) EcoreUtil.copy(op.getMainOperation().getModelElementId()));
				// projectSpace.addOperation(op);
				operations.add(op);

			} else if (ops.size() == 1) {
				// projectSpace.addOperation(ops.get(0));
				operations.add(ops.get(0));
			}
		}

	}

	private Set<EObject> getModelElementsFromClipboard() {
		Set<EObject> result = new HashSet<EObject>();
		if (editingDomain == null) {
			return result;
		}
		Collection<Object> clipboard = editingDomain.getClipboard();
		if (clipboard == null) {
			return result;
		}
		for (Object element : clipboard) {
			if (element instanceof EObject) {
				result.add((EObject) element);
			}
		}
		return result;
	}

	/**
	 * Create a CreateDeleteOperation.
	 * 
	 * @param modelElement the model element to delete or create
	 * @param delete whether the element is deleted or created
	 * @return the operation
	 */
	private CreateDeleteOperation createCreateDeleteOperation(EObject modelElement, boolean delete) {
		CreateDeleteOperation createDeleteOperation = OperationsFactory.eINSTANCE.createCreateDeleteOperation();
		createDeleteOperation.setDelete(delete);
		EObject element = modelElement;

		List<EObject> allContainedModelElements = ModelUtil.getAllContainedModelElementsAsList(element, false);
		allContainedModelElements.add(element);
		EObject copiedElement = EcoreUtil.copy(element);
		List<EObject> copiedAllContainedModelElements = ModelUtil.getAllContainedModelElementsAsList(copiedElement,
			false);
		copiedAllContainedModelElements.add(copiedElement);

		for (int i = 0; i < allContainedModelElements.size(); i++) {
			EObject child = allContainedModelElements.get(i);
			EObject copiedChild = copiedAllContainedModelElements.get(i);
			// ModelElementId childId = projectSpace.getProject().getModelElementId(child);
			ModelElementId childId = idProvider.getModelElementId(child);
			((CreateDeleteOperationImpl) createDeleteOperation).getEObjectToIdMap().put(copiedChild, childId);
		}

		createDeleteOperation.setModelElement(copiedElement);
		// createDeleteOperation.setModelElementId(projectSpace.getProject().getModelElementId(modelElement));
		createDeleteOperation.setModelElementId(idProvider.getModelElementId(modelElement));

		createDeleteOperation.setClientDate(new Date());
		return createDeleteOperation;
	}

	/**
	 * Starts change recording on this workspace, resumes previous recordings if there are any.
	 * 
	 * @generated NOT
	 */
	public void startChangeRecording() {
		if (notificationRecorder == null) {
			notificationRecorder = new NotificationRecorder();
		}
		this.removedElements.clear();
		// notificationRecorder;
		isRecording = true;
	}

	/**
	 * Stops current recording of changes and adds recorded changes to this project spaces changes.
	 * 
	 * @generated NOT
	 */
	public void stopChangeRecording() {
		this.isRecording = false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.changeTracking.commands.CommandObserver#commandStarted(org.eclipse.emf.common.command.Command)
	 */
	public void commandStarted(Command command) {
		currentClipboard = getModelElementsFromClipboard();
	}

	public void commandCompleted(Command command) {
		// means that we have not seen a command start yet
		if (currentClipboard == null) {
			return;
		}

		List<EObject> deletedElements = new ArrayList<EObject>();
		for (int i = removedElements.size() - 1; i >= 0; i--) {
			EObject removedElement = removedElements.get(i);
			// if (!projectSpace.getProject().containsInstance(removedElement)) {
			if (!deletedElements.contains(removedElement)) {
				deletedElements.add(0, removedElement);
			}
			// }

		}
		removedElements.clear();

		Set<EObject> newElementsOnClipboardAfterCommand = getModelElementsFromClipboard();
		newElementsOnClipboardAfterCommand.removeAll(currentClipboard);

		// handle deleted elements => cut command
		for (EObject deletedElement : deletedElements) {
			if (newElementsOnClipboardAfterCommand.contains(deletedElement)) {
				// element was cut
				// projectSpace.getProject().getCutElements().add(deletedElement);

			} else {
				// element was deleted
				handleElementDelete(deletedElement);
				// cleanResources(deletedElement);
			}
		}

		// remove all deleted elements
		newElementsOnClipboardAfterCommand.removeAll(deletedElements);

		for (OperationConsumer opCp : operationConsumer) {
			opCp.handleOperations(operations);
		}
		operations.clear();
		// if (projectSpace.getProject() != null) {
		// saveDirtyResources();
		// } else {
		// saveDirtyResources();
		// }
	}

	private void handleElementDelete(EObject deletedElement) {
		deleteOutgoingCrossReferencesOfContainmentTree(deletedElement);

		if (!UnicaseUtil.isSelfContained(deletedElement, true)) {
			throw new IllegalStateException(
				"Element was removed from containment of project but still has cross references!: "
					+ ModelUtil.getProject(deletedElement).getModelElementId(deletedElement).getId());
		}

		if (!isRecording) {
			return;
		}

		CreateDeleteOperation deleteOperation = OperationsFactory.eINSTANCE.createCreateDeleteOperation();
		deleteOperation.setClientDate(new Date());

		List<EObject> allContainedModelElements = ModelUtil.getAllContainedModelElementsAsList(deletedElement, false);
		allContainedModelElements.add(deletedElement);
		EObject copiedElement = EcoreUtil.copy(deletedElement);
		deleteOperation.setModelElement(copiedElement);
		deleteOperation.setModelElementId(idProvider.getDeletedModelElementId(deletedElement));
		List<EObject> copiedAllContainedModelElements = ModelUtil.getAllContainedModelElementsAsList(copiedElement,
			false);
		copiedAllContainedModelElements.add(copiedElement);

		for (int i = 0; i < allContainedModelElements.size(); i++) {
			EObject child = allContainedModelElements.get(i);
			EObject copiedChild = copiedAllContainedModelElements.get(i);
			ModelElementId childId = idProvider.getDeletedModelElementId(child);
			((CreateDeleteOperationImpl) deleteOperation).getEObjectToIdMap().put(copiedChild, childId);
		}

		deleteOperation.setDelete(true);

		List<CompositeOperation> compositeOperationsToDelete = new ArrayList<CompositeOperation>();
		deleteOperation.getSubOperations().addAll(
			extractReferenceOperationsForDelete(deletedElement, compositeOperationsToDelete));
		operations.removeAll(compositeOperationsToDelete);

		if (this.compositeOperation != null) {
			this.compositeOperation.getSubOperations().add(deleteOperation);
			// projectSpace.saveResource(compositeOperation.eResource());
		} else {
			// projectSpace.addOperation(deleteOperation);
			operations.add(deleteOperation);
		}

		// remove deleted model element and children from resource
		ModelUtil.removeModelElementAndChildrenFromResource(deletedElement);
	}

	private void deleteOutgoingCrossReferencesOfContainmentTree(EObject modelElement) {
		deleteOutgoingCrossReferences(modelElement);
		for (EObject child : ModelUtil.getAllContainedModelElements(modelElement, false)) {
			deleteOutgoingCrossReferences(child);
		}
	}

	@SuppressWarnings("unchecked")
	private List<ReferenceOperation> extractReferenceOperationsForDelete(EObject deletedElement,
		List<CompositeOperation> compositeOperationsToDelete) {
		Set<ModelElementId> allDeletedElementsIds = new HashSet<ModelElementId>();
		for (EObject child : ModelUtil.getAllContainedModelElements(deletedElement, false)) {
			ModelElementId childId = idProvider.getDeletedModelElementId(child);
			allDeletedElementsIds.add(childId);
		}
		allDeletedElementsIds.add(idProvider.getDeletedModelElementId(deletedElement));

		// List<AbstractOperation> newOperations = operations.subList(currentOperationListSize, operations.size());
		List<AbstractOperation> newOperations = operations;
		List<ReferenceOperation> referenceOperationsForDelete = new ArrayList<ReferenceOperation>();
		for (int i = newOperations.size() - 1; i >= 0; i--) {
			AbstractOperation operation = newOperations.get(i);
			if (belongsToDelete(operation, allDeletedElementsIds)) {
				referenceOperationsForDelete.add(0, (ReferenceOperation) operation);
				continue;
			}
			if (operation instanceof CompositeOperation && ((CompositeOperation) operation).getMainOperation() != null) {
				CompositeOperation compositeOperation = (CompositeOperation) operation;
				boolean doesNotBelongToDelete = false;
				for (AbstractOperation subOperation : compositeOperation.getSubOperations()) {
					if (!belongsToDelete(subOperation, allDeletedElementsIds)) {
						doesNotBelongToDelete = true;
						break;
					}
				}
				if (!doesNotBelongToDelete) {
					referenceOperationsForDelete.addAll(0,
						(Collection<? extends ReferenceOperation>) compositeOperation.getSubOperations());
					compositeOperationsToDelete.add(compositeOperation);
				}
				continue;
			}
			break;
		}

		return referenceOperationsForDelete;
	}

	private boolean belongsToDelete(AbstractOperation operation, Set<ModelElementId> allDeletedElementsIds) {
		if (operation instanceof ReferenceOperation) {
			ReferenceOperation referenceOperation = (ReferenceOperation) operation;
			Set<ModelElementId> allInvolvedModelElements = referenceOperation.getAllInvolvedModelElements();
			if (allInvolvedModelElements.removeAll(allDeletedElementsIds)) {
				return isDestructorReferenceOperation(referenceOperation);
			}
		}
		return false;
	}

	private boolean isDestructorReferenceOperation(ReferenceOperation referenceOperation) {
		if (referenceOperation instanceof MultiReferenceOperation) {
			MultiReferenceOperation multiReferenceOperation = (MultiReferenceOperation) referenceOperation;
			return !multiReferenceOperation.isAdd();
		} else if (referenceOperation instanceof SingleReferenceOperation) {
			SingleReferenceOperation singleReferenceOperation = (SingleReferenceOperation) referenceOperation;
			return singleReferenceOperation.getOldValue() != null && singleReferenceOperation.getNewValue() == null;
		}
		return false;
	}

	private void deleteOutgoingCrossReferences(EObject modelElement) {
		// delete all non containment cross references to other elments
		for (EReference reference : modelElement.eClass().getEAllReferences()) {
			EClassifier eType = reference.getEType();
			if (reference.isContainer() || reference.isContainment() || !reference.isChangeable()) {
				continue;
			}

			if (eType instanceof EClass) {
				modelElement.eUnset(reference);
			}
		}
	}

	public void commandFailed(Command command, Exception exception) {
		// TODO Auto-generated method stub

	}

	public EObjectChangeNotifier getChangeNotifier() {
		return eObjectChangeNotifier;
	}
}
