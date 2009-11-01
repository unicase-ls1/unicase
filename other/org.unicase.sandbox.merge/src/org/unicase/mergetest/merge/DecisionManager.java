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
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;

public class DecisionManager {

	private final Project project;
	private final ChangePackage myChangePackage;
	private final List<ChangePackage> theirChangePackages;
	private ConflictDetector conflictDetector;

	public DecisionManager(Project project, ChangePackage myChangePackage,
			List<ChangePackage> theirChangePackages) {
				this.project = project;
				this.myChangePackage = myChangePackage;
				this.theirChangePackages = theirChangePackages;
				conflictDetector = new ConflictDetector();
	}
	
	public List<Conflict> getConflicts() {
		//flatten operations
		List<AbstractOperation> myOperations = myChangePackage.getOperations();
		List<AbstractOperation> theirOperations = new ArrayList<AbstractOperation>();
		for(ChangePackage cp : theirChangePackages) {
			theirOperations.addAll(cp.getOperations());
		}
		
		List<Conflict> conflicts = new ArrayList<Conflict>();
		
		for(AbstractOperation myOperation : myOperations) {
			for(AbstractOperation theirOperation : theirOperations) {
				if(conflictDetector.doConflict(myOperation, theirOperation)) {
					if(myOperation instanceof AttributeOperation && theirOperation instanceof AttributeOperation) {
						conflicts.add(new AttributeConflict(myOperation,theirOperation,this));
					}
					
					if(myOperation instanceof CompositeOperation && theirOperation instanceof CompositeOperation) {
						conflicts.add(new LinkConflict(myOperation, theirOperation,this));
					}
					
					if(isDeleteOp(myOperation) || isDeleteOp(theirOperation)) {
						if(isDeleteOp(myOperation)) {
							conflicts.add(new DeleteConflict(myOperation,theirOperation,this,true));
						} else {
							conflicts.add(new DeleteConflict(myOperation,theirOperation,this,false));
						}
					}
					
				}
			}
		}
		
		return conflicts;
	}

	private boolean isDeleteOp(AbstractOperation myOperation) {
		return myOperation instanceof CreateDeleteOperation && ((CreateDeleteOperation)myOperation).isDelete();
	}

	public ConflictDetector getConflictDetector() {
		return conflictDetector;
	}
	
	public String getModelElementName(ModelElementId modelElementId) {
		AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		return adapterFactoryLabelProvider.getText(project.getModelElement(modelElementId));
	}
}
