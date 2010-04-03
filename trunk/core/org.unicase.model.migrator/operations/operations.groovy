import org.eclipse.emf.ecore.*

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

unicaseRenameFeature = { EStructuralFeature feature, String name ->
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

@before("rename")
@label("Migrate changes in response to rename operation")
unicaseRenameImpl = {ENamedElement element, String name ->
	if(element instanceof EStructuralFeature) {
		unicaseRenameFeature((EStructuralFeature) element, name)
	}
}
unicaseRename = unicaseRenameImpl


deleteOperation = { operation ->
	def container = operation.container
	operation.delete()
	if(container.instanceOf(esmodel.versioning.operations.CompositeOperation)) {
		if(container.subOperations.isEmpty()) {
			deleteOperation(container)
		}
	}
}


@before("deleteFeature")
@label("Migrate changes in response to deleteFeature operation")
unicaseDeleteFeatureImpl = {EStructuralFeature feature ->
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
unicaseDeleteFeature = unicaseDeleteFeatureImpl


@before("enumerationToSubClasses")
@label("Migrate changes in response to enumerationToSubClasses operation")
unicaseEnumerationToSubClassesImpl = {
	EAttribute enumAttribute,
	EPackage ePackage ->
	
	unicaseDeleteFeature(enumAttribute)
}
unicaseEnumerationToSubClasses = unicaseEnumerationToSubClassesImpl