import org.eclipse.emf.ecore.*

participatingActorReference = model.requirement.UserTask.participatingActor

// change migration
getElementById = { id ->
	def element = model.IdentifiableElement.allInstances.find{e -> id.equals(e.identifier)} 
	if(element == null) {
		println "id " + id + " not found"
	}
	return element
}

isFeatureChange = { operation, EStructuralFeature feature ->
	if(feature.name.equals(operation.featureName)) {
		def id = operation.modelElementId.id
		def element = getElementById(id)
		if(element == null || element.instanceOf(feature.eContainingClass)) {
			return true
		}
	}
	return false
}

renameFeature_Changes = { EStructuralFeature feature, String name ->

	for(operation in esmodel.versioning.operations.FeatureOperation.allInstances) {
		if(isFeatureChange(operation, feature)) {
			operation.featureName = name
		}
	}
	if(feature instanceof EReference) {
		def opposite = feature.eOpposite
		if(opposite != null) {
			for(operation in esmodel.versioning.operations.ReferenceOperation.allInstances) {
				if(isFeatureChange(operation, opposite)) {
					operation.oppositeFeatureName = name
				}
			}
		}		
	}
}

renameFeature_Changes(participatingActorReference, "participatingActors")

// model migration
participatingActorReference.name = "participatingActors"
