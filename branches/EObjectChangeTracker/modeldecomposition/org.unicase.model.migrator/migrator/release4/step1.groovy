import org.eclipse.emf.ecore.*

attachmentsReference = model.ModelElement.attachments

// model migration
for(me in model.ModelElement.allInstances) {
	deleteFeatureValue(me, attachmentsReference)
}

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

deleteFeature_Changes = { EStructuralFeature feature ->

	for(operation in esmodel.versioning.operations.FeatureOperation.allInstances) {
		if(isFeatureChange(operation, feature)) {
			operation.delete()
		}
	}
	if(feature instanceof EReference) {
		def opposite = feature.eOpposite
		if(opposite != null) {
			for(operation in esmodel.versioning.operations.ReferenceOperation.allInstances) {
				if(isFeatureChange(operation, opposite)) {
					operation.delete()
				}
			}
		}		
	}
}


deleteFeature_Changes(attachmentsReference)

// metamodel adaptation
attachmentsReference = model.ModelElement.attachments
attachmentsReference.containment = true
referringModelElementsReference = model.Attachment.referringModelElements
referringModelElementsReference.name = "attachedElement"
referringModelElementsReference.upperBound = 1
