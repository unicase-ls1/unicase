package org.unicase.mergetest.merge;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.unicase.emfstore.conflictDetection.ConflictDetector;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.mergetest.merge.conflicts.AttributeConflict;
import org.unicase.mergetest.merge.conflicts.Conflict;
import org.unicase.mergetest.merge.conflicts.DeleteConflict;
import org.unicase.mergetest.merge.conflicts.LinkConflict;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;

public class DecisionManager {

	private final Project project;
	private final ChangePackage myChangePackage;
	private final List<ChangePackage> theirChangePackages;
	private ConflictDetector conflictDetector;
	private List<Conflict> conflicts;

	public DecisionManager(Project project, ChangePackage myChangePackage,
			List<ChangePackage> theirChangePackages) {
		this.project = project;
		this.myChangePackage = myChangePackage;
		this.theirChangePackages = theirChangePackages;
		conflictDetector = new ConflictDetector();
		init();
	}

	private void init() {
		// flatten operations
		List<AbstractOperation> myOperations = myChangePackage.getOperations();
		List<AbstractOperation> theirOperations = new ArrayList<AbstractOperation>();
		for (ChangePackage cp : theirChangePackages) {
			theirOperations.addAll(cp.getOperations());
		}

		conflicts = new ArrayList<Conflict>();

		for (AbstractOperation myOperation : myOperations) {
			for (AbstractOperation theirOperation : theirOperations) {
				if (conflictDetector.doConflict(myOperation, theirOperation)) {

					if (isAttribute(myOperation) && isAttribute(theirOperation)) {
						conflicts.add(new AttributeConflict(myOperation,
								theirOperation, this));
					} else if (isComposite(myOperation)
							&& isComposite(theirOperation)) {
						conflicts.add(new LinkConflict(
								(CompositeOperation) myOperation,
								(CompositeOperation) theirOperation, this));
					} else if (isDelete(myOperation)
							|| isDelete(theirOperation)) {
						if (isDelete(myOperation)) {
							conflicts.add(new DeleteConflict(myOperation,
									theirOperation, this, true));
						} else {
							conflicts.add(new DeleteConflict(myOperation,
									theirOperation, this, false));
						}
					}

				}
			}
		}
	}

	public List<Conflict> getConflicts() {
		return conflicts;
	}

	public boolean isResolved() {
		boolean isResolved = true;
		for (Conflict conflict : conflicts) {
			isResolved = isResolved && conflict.isResolved();
		}
		return isResolved;
	}

	public boolean isComposite(AbstractOperation operation) {
		return operation instanceof CompositeOperation;
	}

	public boolean isAttribute(AbstractOperation operation) {
		return operation instanceof AttributeOperation;
	}

	public boolean isCreate(AbstractOperation operation) {
		return isCreateDelete(operation)
				&& !((CreateDeleteOperation) operation).isDelete();
	}

	public boolean isDelete(AbstractOperation operation) {
		return isCreateDelete(operation)
				&& ((CreateDeleteOperation) operation).isDelete();
	}

	public boolean isCreateDelete(AbstractOperation operation) {
		return operation instanceof CreateDeleteOperation;
	}

	public ConflictDetector getConflictDetector() {
		return conflictDetector;
	}

	public String getModelElementName(ModelElementId modelElementId) {
		AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		return adapterFactoryLabelProvider.getText(project
				.getModelElement(modelElementId));
	}
}
