import org.eclipse.emf.ecore.*

// change migration
getElementById = { id ->
	def element = model.UnicaseModelElement.allInstances.find{e -> id.equals(e.identifier)} 
	if(element == null) {
		println "id " + id + " not found"
	}
	return element
}

isFeatureChange = { operation, EStructuralFeature feature ->

	if(feature.name.equals(operation.featureName)) {
		if(operation.modelElementId == null) {
			debug(operation, "model element id = null")
			// model element id of an operation can be null.
			// is this legal and what does it mean?
			return true
		}
		def id = operation.modelElementId.id
		def element = getElementById(id)
		if(element == null || element.instanceOf(feature.eContainingClass)) {
			return true
		}
	}
	return false
}

deleteOperation = { operation ->
	def container = operation.container
	operation.delete()
	if(container.instanceOf(esmodel.versioning.operations.CompositeOperation)) {
		if(container.subOperations.isEmpty()) {
			deleteOperation(container)
		}
	}
}

deleteFeature_Changes = { EStructuralFeature feature ->

	if(feature instanceof EAttribute) {
		for(operation in esmodel.versioning.operations.AttributeOperation.allInstances) {
			if(isFeatureChange(operation, feature)) {
				deleteOperation(operation)
			}
		}
	}
	else if(feature instanceof EReference) {
		def opposite = feature.eOpposite
		for(operation in esmodel.versioning.operations.ReferenceOperation.allInstances) {
			if(isFeatureChange(operation, feature)) {
				deleteOperation(operation)
			}
			else if(opposite != null && isFeatureChange(operation, opposite)) {
				operation.bidirectional = false
				operation.oppositeFeatureName = null
			}
		}
	}
}

deleteFeature_Changes(model.change.MergingIssue.resolvingRevision)
deleteFeature_Changes(model.change.MergingProposal.conflictingProposals)
deleteFeature_Changes(model.change.MergingProposal.pendingChanges)
deleteFeature_Changes(model.change.MergingSolution.appliedChanges)
deleteFeature_Changes(model.task.WorkItem.associatedChangePackages)

// model migration
deleteFeature(model.change.MergingIssue.resolvingRevision)
deleteFeature(model.change.MergingProposal.conflictingProposals)
deleteFeature(model.change.MergingProposal.pendingChanges)
deleteFeature(model.change.MergingSolution.appliedChanges)
deleteFeature(model.task.WorkItem.associatedChangePackages)
