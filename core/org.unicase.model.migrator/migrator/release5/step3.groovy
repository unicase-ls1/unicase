import org.eclipse.emf.ecore.*

modelChangePackageClass = model.change.ModelChangePackage

// change migration
getElementById = { id ->
	def element = model.UnicaseModelElement.allInstances.find{e -> id.equals(e.identifier)} 
	if(element == null) {
		println "id " + id + " not found"
	}
	return element
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

// FeatureOperation
for(operation in esmodel.versioning.operations.FeatureOperation.allInstances) {
	def element = getElementById(operation.modelElementId.id)
	if(element != null && element.instanceOf(modelChangePackageClass)) {
		deleteOperation(operation)
	}
}

// SingleReferenceOperation
for(operation in esmodel.versioning.operations.SingleReferenceOperation.allInstances) {
	if(operation.oldValue != null) {
		def element = getElementById(operation.oldValue.id)
		if(element != null && element.instanceOf(modelChangePackageClass)) {
			deleteOperation(operation)
		}
	}
	if(operation.newValue != null) {
		def element = getElementById(operation.newValue.id)
		if(element != null && element.instanceOf(modelChangePackageClass)) {
			deleteOperation(operation)
		}
	}
}

// MultiReferenceOperation
for(operation in esmodel.versioning.operations.MultiReferenceOperation.allInstances) {
	for(modelElementId in new ArrayList(operation.referencedModelElements)) {
		def element = getElementById(modelElementId.id)
		if(element != null && element.instanceOf(modelChangePackageClass)) {
			operation.referencedModelElements.remove(modelElementId)
		}
	}
	if(operation.referencedModelElements.isEmpty()) {
		deleteOperation(operation)
	}
}

// MultiReferenceMoveOperation
for(operation in esmodel.versioning.operations.MultiReferenceMoveOperation.allOperations) {
	def element = getElementById(referencedModelElementId.id)
	if(element != null && element.instanceOf(modelChangePackageClass)) {
		deleteOperation(operation)
	}
}

// CreateDeleteOperation
for(operation in esmodel.versioning.operations.CreateDeleteOperation.allInstances) {
	def element = operation.modelElement
	if(element != null && element.instanceOf(modelChangePackageClass)) {
		deleteOperation(operation)
	}
}

// model migration
def project = model.Project.instances[0]

for(mcp in modelChangePackageClass.allInstances) {
	for(child in mcp.contents) {
		def reference = child.containerReference
		if(reference.isMany()) {
			mcp.remove(reference, child)
		}
		else {
			mcp.set(reference, null)
		}
		project.modelElements.add(child)
	}
	mcp.delete()
}

// metamodel adaptation
modelChangePackageClass.delete()
