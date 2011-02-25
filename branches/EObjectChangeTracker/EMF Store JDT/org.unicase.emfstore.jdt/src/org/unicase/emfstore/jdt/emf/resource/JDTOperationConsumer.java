package org.unicase.emfstore.jdt.emf.resource;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.jdt.operationstore.OperationSet;
import org.unicase.emfstore.jdt.operationstore.OperationStore;
import org.unicase.emfstore.jdt.operationstore.OperationstoreFactory;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.workspace.OperationConsumer;

public class JDTOperationConsumer implements OperationConsumer, SaveObserver {

	private OperationSet operationSet;

	public JDTOperationConsumer(OperationStore operationStore) {
		EList<OperationSet> operationSets = operationStore.getOperationSets();
		if (operationSets.isEmpty()) {
			operationSet = OperationstoreFactory.eINSTANCE.createOperationSet();
			operationSets.add(operationSet);

		} else {
			OperationSet operationSet = operationSets.get(operationSets.size() - 1);
			// create only a new OperationSet for new "sessions"
			if (operationSet.getBaseVersion() == null) {
				this.operationSet = operationSet;

			} else {
				operationSet = OperationstoreFactory.eINSTANCE.createOperationSet();
				operationSets.add(operationSet);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.OperationConsumer#handleOperations(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	public void handleOperations(List<AbstractOperation> operations) {
		for (AbstractOperation operation : operations) {
			AbstractOperation operationClone = ModelUtil.clone(operation);
			operationSet.getOperations().add(operationClone);
		}

		// String path = Configuration.getWorkspaceDirectory() + "ps-" + EcoreUtil.generateUUID() + File.separatorChar
		// + "operations";
		// new AutoSplitAndSaveResourceContainmentList<AbstractOperation>(operation, operationComposite.getOperations(),
		// null, path, ".off");
	}

	public void saved() {
		try {
			operationSet.eResource().save(null);

		} catch (IOException e) {
			ModelUtil.logException(e);
		}
	}

}
