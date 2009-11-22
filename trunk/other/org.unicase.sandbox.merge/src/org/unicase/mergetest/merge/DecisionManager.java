package org.unicase.mergetest.merge;

import static org.unicase.mergetest.merge.util.DecisionUtil.isAttribute;
import static org.unicase.mergetest.merge.util.DecisionUtil.isCompositeRef;
import static org.unicase.mergetest.merge.util.DecisionUtil.isDelete;
import static org.unicase.mergetest.merge.util.DecisionUtil.isMultiRef;
import static org.unicase.mergetest.merge.util.DecisionUtil.isSingleRef;
import static org.unicase.mergetest.merge.util.DecisionUtil.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.unicase.emfstore.conflictDetection.ConflictDetector;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.mergetest.merge.conflict.Conflict;
import org.unicase.mergetest.merge.conflict.conflicts.AttributeConflict;
import org.unicase.mergetest.merge.conflict.conflicts.CompositeConflict;
import org.unicase.mergetest.merge.conflict.conflicts.DeletionConflict;
import org.unicase.mergetest.merge.conflict.conflicts.MultiReferenceConflict;
import org.unicase.mergetest.merge.conflict.conflicts.ReferenceConflict;
import org.unicase.mergetest.merge.conflict.conflicts.SingleReferenceConflict;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;

public class DecisionManager {

	private final Project project;
	private final ChangePackage myChangePackage;
	private final List<ChangePackage> theirChangePackages;
	private ConflictDetector conflictDetector;
	private ArrayList<Conflict> conflicts;

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
		ArrayList<Conflicting> conflicting = new ArrayList<Conflicting>();

		// Collect all conflicting
		for (AbstractOperation myOperation : myOperations) {
			for (AbstractOperation theirOperation : theirOperations) {
				if (conflictDetector.doConflict(myOperation, theirOperation)) {
					boolean conflictingYet = false;
					// for (Conflicting conf : conflicting) {
					// if (!conf.add(myOperation, theirOperation)) {
					// conflictingYet = true;
					// break;
					// }
					// }
					if (!conflictingYet) {
						conflicting.add(new Conflicting(myOperation,
								theirOperation));
					}
				}
			}
		}

		// Create Conflicts from Conflicting
		for (Conflicting conf : conflicting) {
			if (isAttribute(conf.getMyOperation())
					&& isAttribute(conf.getTheirOperation())) {

				addConflict(createAttributeAttributeDecision(conf));

			} else if (isCompositeRef(conf.getMyOperation())
					&& isCompositeRef(conf.getTheirOperation())) {

				Conflict conflict = null;
				for (AbstractOperation myOp : ((CompositeOperation) conf
						.getMyOperation()).getSubOperations()) {
					for (AbstractOperation theirOp : ((CompositeOperation) conf
							.getTheirOperation()).getSubOperations()) {
						if (conflictDetector.doConflict(myOp, theirOp)) {
							if (isSingleRef(myOp)) {
								conflict = createSingleSingleConflict(myOp,
										theirOp);
							} else if (isMultiRef(myOp)) {
								conflict = createMultiMultiConflict(myOp,
										theirOp);
							} else {
								return;
							}
							break;
						}
					}
					break;
				}
				addConflict(createReferenceConflict(conf, conflict));

			} else if (isSingleRef(conf.getMyOperation())
					&& isSingleRef(conf.getTheirOperation())) {

				addConflict(createSingleSingleConflict(conf));

			} else if (isMultiRef(conf.getMyOperation())
					&& isMultiRef(conf.getTheirOperation())) {

				addConflict(createMultiMultiConflict(conf));

			} else if (isDelete(conf.getMyOperation())
					|| isDelete(conf.getTheirOperation())) {

				addConflict(createDeleteOtherConflict(conf));

			} else if (isComposite(conf.getMyOperation())
					|| isComposite(conf.getTheirOperation())) {

				addConflict(createCompositeConflict(conf));

			}
		}
	}

	private Conflict createReferenceConflict(Conflicting conf, Conflict conflict) {
		return new ReferenceConflict(conflict, conf.getMyOperations(), conf
				.getTheirOperations());
	}

	private void addConflict(Conflict conflict) {
		if (conflict == null) {
			return;
		}
		conflicts.add(conflict);
	}

	private Conflict createAttributeAttributeDecision(Conflicting conflicting) {
		return new AttributeConflict(conflicting.getMyOperations(), conflicting
				.getTheirOperations(), this);
	}

	private Conflict createSingleSingleConflict(Conflicting conflicting) {
		return new SingleReferenceConflict(conflicting.getMyOperations(),
				conflicting.getTheirOperations(), this);
	}

	private Conflict createSingleSingleConflict(AbstractOperation my, AbstractOperation their) {
		return new SingleReferenceConflict(Arrays.asList(my), Arrays.asList(their), this);
	}

	private Conflict createMultiMultiConflict(Conflicting conf) {
		if (((MultiReferenceOperation) conf.getMyOperation()).isAdd()) {
			return new MultiReferenceConflict(conf.getMyOperations(), conf
					.getTheirOperations(), this, true);
		} else {
			return new MultiReferenceConflict(conf.getMyOperations(), conf
					.getTheirOperations(), this, false);
		}
	}

	private Conflict createMultiMultiConflict(AbstractOperation my,
			AbstractOperation their) {
		if (((MultiReferenceOperation) my).isAdd()) {
			return new MultiReferenceConflict(Arrays.asList(my), Arrays.asList(their), this, true);
		} else {
			return new MultiReferenceConflict(Arrays.asList(their), Arrays.asList(my), this, false);
		}
	}

	// TODO remove debug list.
	private Conflict createDeleteOtherConflict(Conflicting conf) {
		if (isDelete(conf.getMyOperation())) {
			return new DeletionConflict(conf.getMyOperations(), conf
					.getTheirOperations(), true, this);
		} else {
			return new DeletionConflict(conf.getTheirOperations(), conf
					.getMyOperations(), false, this);
		}
	}

	private Conflict createCompositeConflict(Conflicting conf) {
		return new CompositeConflict(conf.getMyOperations(), conf
				.getTheirOperations(), this, true);
	}

	public ArrayList<Conflict> getConflicts() {
		return conflicts;
	}

	public boolean isResolved() {
		boolean isResolved = true;
		for (Conflict conflict : conflicts) {
			isResolved = isResolved && conflict.isResolved();
		}
		return isResolved;
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

	public ModelElement getModelElement(ModelElementId modelElementId) {
		return project.getModelElement(modelElementId);
	}

	private class Conflicting {

		private ArrayList<AbstractOperation> myOps;
		private ArrayList<AbstractOperation> theirOps;

		public Conflicting(AbstractOperation myOp, AbstractOperation theirOp) {
			myOps = new ArrayList<AbstractOperation>();
			myOps.add(myOp);
			theirOps = new ArrayList<AbstractOperation>();
			theirOps.add(theirOp);
		}

		public AbstractOperation getTheirOperation() {
			return theirOps.get(0);
		}

		public AbstractOperation getMyOperation() {
			return myOps.get(0);
		}

		public List<AbstractOperation> getTheirOperations() {
			return theirOps;
		}

		public List<AbstractOperation> getMyOperations() {
			return myOps;
		}

		public boolean add(AbstractOperation myOp, AbstractOperation theirOp) {
			if (myOps.contains(myOp)) {
				if (!theirOps.contains(theirOp)) {
					theirOps.add(theirOp);
				}
				return true;
			} else if (theirOps.contains(theirOp)) {
				myOps.add(myOp);
				return true;
			}
			return false;
		}
	}
}
