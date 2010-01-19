package org.unicase.workspace.ui.dialogs.merge;

import static org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil.isAttribute;
import static org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil.isComposite;
import static org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil.isCompositeRef;
import static org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil.isDelete;
import static org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil.isDiagramLayout;
import static org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil.isMultiRef;
import static org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil.isSingleRef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.unicase.emfstore.conflictDetection.ConflictDetector;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.workspace.ui.dialogs.merge.conflict.Conflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.conflicts.AttributeConflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.conflicts.CompositeConflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.conflicts.DeletionConflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.conflicts.DiagramLayoutConflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.conflicts.MultiReferenceConflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.conflicts.ReferenceConflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.conflicts.SingleReferenceConflict;
import org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil;
import org.unicase.workspace.ui.dialogs.merge.util.EventLogger;
import org.unicase.workspace.ui.views.changes.ChangePackageVisualizationHelper;

public class DecisionManager {

	private final Project project;
	private final ChangePackage myChangePackage;
	private final List<ChangePackage> theirChangePackages;
	private ConflictDetector conflictDetector;

	private ArrayList<Conflict> conflicts;
	private ArrayList<AbstractOperation> notInvolvedInConflict;
	private ArrayList<AbstractOperation> acceptedMine;
	private ArrayList<AbstractOperation> rejectedTheirs;
	private final PrimaryVersionSpec baseVersion;
	private final PrimaryVersionSpec targetVersion;
	private ChangePackageVisualizationHelper visualizationHelper;
	private EventLogger eventLogger;

	public DecisionManager(Project project, ChangePackage myChangePackage,
			List<ChangePackage> theirChangePackages,
			PrimaryVersionSpec baseVersion, PrimaryVersionSpec targetVersion) {
		this.project = project;
		this.myChangePackage = myChangePackage;
		this.theirChangePackages = theirChangePackages;
		this.baseVersion = baseVersion;
		this.targetVersion = targetVersion;
		conflictDetector = new ConflictDetector();
		init();
		getEventLogger().createMergeEvent(baseVersion, targetVersion,
				conflicts.size(), myChangePackage.getOperations());
	}

	private void init() {
		// flatten operations
		List<AbstractOperation> myOperations = myChangePackage.getOperations();
		List<AbstractOperation> theirOperations = new ArrayList<AbstractOperation>();
		for (ChangePackage cp : theirChangePackages) {
			theirOperations.addAll(cp.getOperations());
		}

		acceptedMine = new ArrayList<AbstractOperation>();
		rejectedTheirs = new ArrayList<AbstractOperation>();
		notInvolvedInConflict = new ArrayList<AbstractOperation>();

		conflicts = new ArrayList<Conflict>();
		ArrayList<Conflicting> conflicting = new ArrayList<Conflicting>();

		// Collect all conflicting
		ListIterator<AbstractOperation> myIterator = myOperations
				.listIterator(myOperations.size());
		while (myIterator.hasPrevious()) {
			AbstractOperation myOperation = myIterator.previous();
			boolean involved = false;
			ListIterator<AbstractOperation> theirIterator = theirOperations
					.listIterator(theirOperations.size());
			while (theirIterator.hasPrevious()) {
				AbstractOperation theirOperation = theirIterator.previous();
				if (conflictDetector.doConflict(myOperation, theirOperation)) {
					involved = true;
					boolean conflictingYet = false;
					for (Conflicting conf : conflicting) {
						if (conf.add(myOperation, theirOperation)) {
							conflictingYet = true;
							break;
						}
					}
					if (!conflictingYet) {
						conflicting.add(new Conflicting(myOperation,
								theirOperation));
					}
				}
			}
			if (!involved) {
				notInvolvedInConflict.add(myOperation);
			}
		}

		// Create Conflicts from Conflicting
		for (Conflicting conf : conflicting) {
			AbstractOperation my = conf.getMyOperation();
			AbstractOperation their = conf.getTheirOperation();

			if (isDiagramLayout(my) && isDiagramLayout(their)) {

				addConflict(createDiagramLayoutDecision(conf));

			} else if (isAttribute(my) && isAttribute(their)) {

				addConflict(createAttributeAttributeDecision(conf));

			} else if (isSingleRef(my) && isSingleRef(their)) {

				addConflict(createSingleSingleConflict(conf));

			} else if (isMultiRef(my) && isMultiRef(their)) {

				addConflict(createMultiMultiConflict(conf));

			} else if (isCompositeRef(my) && isCompositeRef(their)) {

				addConflict(createReferenceConflict(conf));

			} else if ((isCompositeRef(my) && (isMultiRef(their) || isSingleRef(their)))
					|| ((isMultiRef(my) || isSingleRef(my)) && isCompositeRef(their))) {

				addConflict(createReferenceCompVSSingleMulti(conf));

			} else if (isComposite(my) || isComposite(their)) {

				addConflict(createCompositeConflict(conf));

			} else if (isDelete(my) || isDelete(their)) {

				addConflict(createDeleteOtherConflict(conf));

			}
		}
	}

	private Conflict createReferenceCompVSSingleMulti(Conflicting conf) {
		if (isCompositeRef(conf.getMyOperation())) {
			return createRefFromSub(conf, ((CompositeOperation) conf
					.getMyOperation()).getSubOperations(), Arrays.asList(conf
					.getTheirOperation()));
		} else {
			return createRefFromSub(conf, Arrays.asList(conf.getMyOperation()),
					((CompositeOperation) conf.getTheirOperation())
							.getSubOperations());
		}
	}

	private Conflict createReferenceConflict(Conflicting conf) {
		EList<AbstractOperation> myOperations = ((CompositeOperation) conf
				.getMyOperation()).getSubOperations();
		EList<AbstractOperation> theirOperations = ((CompositeOperation) conf
				.getTheirOperation()).getSubOperations();

		return createRefFromSub(conf, myOperations, theirOperations);
	}

	private Conflict createRefFromSub(Conflicting conf,
			List<AbstractOperation> myOperations,
			List<AbstractOperation> theirOperations) {

		for (AbstractOperation myOp : myOperations) {
			for (AbstractOperation theirOp : theirOperations) {
				if (conflictDetector.doConflict(myOp, theirOp)) {
					if (isSingleRef(myOp)) {

						return new ReferenceConflict(
								createSingleSingleConflict(myOp, theirOp), conf
										.getMyOperations(), conf
										.getTheirOperations());

					} else if (isMultiRef(myOp)) {

						return new ReferenceConflict(createMultiMultiConflict(
								myOp, theirOp), conf.getMyOperations(), conf
								.getTheirOperations());

					} else {
						return null;
					}
				}
			}
		}
		return null;
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

	private Conflict createDiagramLayoutDecision(Conflicting conflicting) {
		return new DiagramLayoutConflict(conflicting.getMyOperations(),
				conflicting.getTheirOperations(), this);
	}

	private Conflict createSingleSingleConflict(Conflicting conflicting) {
		return new SingleReferenceConflict(conflicting.getMyOperations(),
				conflicting.getTheirOperations(), this);
	}

	private Conflict createSingleSingleConflict(AbstractOperation my,
			AbstractOperation their) {
		return new SingleReferenceConflict(Arrays.asList(my), Arrays
				.asList(their), this);
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
			return new MultiReferenceConflict(Arrays.asList(my), Arrays
					.asList(their), this, true);
		} else {
			return new MultiReferenceConflict(Arrays.asList(their), Arrays
					.asList(my), this, false);
		}
	}

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
		if (isComposite(conf.getMyOperation())) {
			return new CompositeConflict(conf.getMyOperations(), conf
					.getTheirOperations(), this, true);
		} else {
			return new CompositeConflict(conf.getTheirOperations(), conf
					.getMyOperations(), this, false);
		}
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

	public List<AbstractOperation> getAcceptedMine() {
		return acceptedMine;
	}

	public List<AbstractOperation> getRejectedTheirs() {
		return rejectedTheirs;
	}

	public void calcResult() {
		if (!isResolved()) {
			return;
		}
		// collect my acknowledge operations
		for (AbstractOperation myOp : myChangePackage.getOperations()) {
			if (notInvolvedInConflict.contains(myOp)) {
				acceptedMine.add(myOp);
			} else {
				for (Conflict conflict : conflicts) {
					if (conflict.getAcceptedMine().contains(myOp)) {
						acceptedMine.add(myOp);
					}
				}
			}
		}

		// Collect other accepted, which were generated in the merge process
		for (Conflict conflict : conflicts) {
			for (AbstractOperation ao : conflict.getAcceptedMine()) {
				if (!acceptedMine.contains(ao)) {
					acceptedMine.add(ao);
				}
			}
		}

		for (ChangePackage theirCP : theirChangePackages) {
			for (AbstractOperation theirOp : theirCP.getOperations()) {
				for (Conflict conflict : conflicts) {
					if (conflict.getRejectedTheirs().contains(theirOp)) {
						rejectedTheirs.add(theirOp);
					}
				}
			}
		}
	}

	public ConflictDetector getConflictDetector() {
		return conflictDetector;
	}

	public String getModelElementName(ModelElementId modelElementId) {
		return getModelElementName(getModelElement(modelElementId));
	}

	public String getModelElementName(ModelElement modelElement) {
		AdapterFactoryLabelProvider adapterFactory = DecisionUtil
				.getAdapterFactory();
		return adapterFactory.getText(modelElement);
	}

	public ModelElement getModelElement(ModelElementId modelElementId) {
		ModelElement modelElement = project.getModelElement(modelElementId);
		if (modelElement == null) {
			modelElement = searchForCreatedME(modelElementId, myChangePackage
					.getOperations());
			if (modelElement == null) {
				for (ChangePackage cp : theirChangePackages) {
					modelElement = searchForCreatedME(modelElementId, cp
							.getOperations());
					if (modelElement != null) {
						break;
					}
				}
			}
		}
		return modelElement;
	}

	private ModelElement searchForCreatedME(ModelElementId modelElementId,
			List<AbstractOperation> operations) {
		for (AbstractOperation operation : operations) {
			ModelElement result = null;
			if (operation instanceof CreateDeleteOperation) {
				result = searchCreateAndDelete(
						(CreateDeleteOperation) operation, modelElementId);

			} else if (operation instanceof CompositeOperation) {
				EList<AbstractOperation> subOperations = ((CompositeOperation) operation)
						.getSubOperations();
				result = searchForCreatedME(modelElementId, subOperations);
			} else {
				continue;
			}
			if (result != null) {
				return result;
			}
		}
		return null;
	}

	private ModelElement searchCreateAndDelete(CreateDeleteOperation cdo,
			ModelElementId modelElementId) {
		ModelElement modelElement = cdo.getModelElement();
		if (modelElement == null) {
			return null;
		}
		Set<ModelElement> containedModelElements = modelElement
				.getAllContainedModelElements();
		containedModelElements.add(modelElement);

		for (ModelElement child : containedModelElements) {
			if (child != null
					&& child.getModelElementId().equals(modelElementId)) {
				return child;
			}
		}
		return null;
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
			for (AbstractOperation ao : getTheirOperations()) {
				if (conflictDetector.doConflict(myOp, ao)) {
					addToList(myOp, theirOp);
					return true;
				}
			}
			for (AbstractOperation ao : getMyOperations()) {
				if (conflictDetector.doConflict(ao, theirOp)) {
					addToList(myOp, theirOp);
					return true;
				}
			}
			return false;
		}

		private void addToList(AbstractOperation my, AbstractOperation their) {
			if (!myOps.contains(my)) {
				myOps.add(my);
			}
			if (!theirOps.contains(my)) {
				theirOps.add(their);
			}
		}
	}

	public String getAuthorForOperation(AbstractOperation theirOperation) {
		for (ChangePackage cp : theirChangePackages) {
			for (AbstractOperation op : cp.getOperations()) {
				List<AbstractOperation> tmpList = new ArrayList<AbstractOperation>();
				if (op instanceof CompositeOperation) {
					tmpList.add(op);
					tmpList
							.addAll(((CompositeOperation) op)
									.getSubOperations());
				} else {
					tmpList.add(op);
				}
				for (AbstractOperation ao : tmpList) {
					if (ao.equals(theirOperation)) {
						LogMessage log = cp.getLogMessage();
						if (log == null) {
							return "";
						}
						return (log.getAuthor() == null) ? "" : log.getAuthor();

					}
				}
			}
		}
		return "";
	}

	public Project getProject() {
		return project;
	}

	public ChangePackageVisualizationHelper getChangePackageVisualizationHelper() {
		if (visualizationHelper == null) {
			ArrayList<ChangePackage> list = new ArrayList<ChangePackage>();
			list.add(myChangePackage);
			list.addAll(theirChangePackages);
			visualizationHelper = new ChangePackageVisualizationHelper(list,
					project);
		}
		return visualizationHelper;
	}

	public EventLogger getEventLogger() {
		if (eventLogger == null) {
			eventLogger = new EventLogger(project);
		}
		return eventLogger;
	}

	public PrimaryVersionSpec getBaseVersion() {
		return baseVersion;
	}

	public PrimaryVersionSpec getTargetVersion() {
		return targetVersion;
	}
}
