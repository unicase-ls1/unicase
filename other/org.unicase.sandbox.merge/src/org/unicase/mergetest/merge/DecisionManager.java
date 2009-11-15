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
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.mergetest.merge.conflict.Conflict;
import org.unicase.mergetest.merge.conflict.conflicts.AttributeConflict;
import org.unicase.mergetest.merge.conflict.conflicts.DeleteConflict;
import org.unicase.mergetest.merge.conflict.conflicts.LinkConflict;
import org.unicase.mergetest.merge.conflict.conflicts.MultiReferenceConflict;
import org.unicase.mergetest.merge.conflict.conflicts.SingleReferenceConflict;
import org.unicase.mergetest.merge.util.DecisionUtil;
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
		
		for (AbstractOperation myOperation : myOperations) {
			for (AbstractOperation theirOperation : theirOperations) {
				if (conflictDetector.doConflict(myOperation, theirOperation)) {

					if (DecisionUtil.isAttribute(myOperation) && DecisionUtil.isAttribute(theirOperation)) {
						
						conflicts.add(new AttributeConflict((AttributeOperation)myOperation,
								(AttributeOperation)theirOperation, this));
						
					} else if(DecisionUtil.isCompositeRef(myOperation) && DecisionUtil.isCompositeRef(theirOperation)) {
						//TODO: Link Container
						for(AbstractOperation mySubOp : ((CompositeOperation)myOperation).getSubOperations()) {
							for(AbstractOperation theirSubOp : ((CompositeOperation)theirOperation).getSubOperations()) {
								if(conflictDetector.doConflict(mySubOp, theirSubOp)) {
									if(DecisionUtil.isSingleRef(mySubOp) && DecisionUtil.isSingleRef(theirSubOp)) {
										conflicts.add(new SingleReferenceConflict((SingleReferenceOperation) mySubOp,(SingleReferenceOperation) theirSubOp,this));
									} //else if(DecisionUtil.isMultiRef(mySubOp) && DecisionUtil.isMultiRef(theirSubOp)) {
//										conflicts.add(new MultiReferenceConflict((MultiReferenceOperation) mySubOp, (MultiReferenceOperation) theirSubOp));
//									} else {
//										throw new IllegalStateException();
//									}
									break;
								}
							}
						}
						
					} else if(DecisionUtil.isSingleRef(myOperation) && DecisionUtil.isSingleRef(theirOperation)) {
						
						conflicts.add(new SingleReferenceConflict((SingleReferenceOperation) myOperation,(SingleReferenceOperation) theirOperation,this));
					
					} //else if(DecisionUtil.isMultiRef(myOperation) && DecisionUtil.isMultiRef(theirOperation)) {
//						
//						conflicts.add(new MultiReferenceConflict((MultiReferenceOperation) myOperation, (MultiReferenceOperation) theirOperation));
//				
//					}

				}
			}
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
}
