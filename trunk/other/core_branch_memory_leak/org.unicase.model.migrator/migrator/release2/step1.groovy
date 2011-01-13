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
		def id = operation.modelElementId.id
		def element = getElementById(id)
		if(element == null || element.instanceOf(feature.eContainingClass)) {
			return true
		}
	}
	return false
}

for(operation in esmodel.versioning.operations.AttributeOperation.allInstances) {
	if(isFeatureChange(operation, model.bug.BugReport.Status)) {
		if(operation.newValue.literal == model.bug.BugStatus.CLOSED.literal) {
			operation.featureName = "done"
			operation.oldValue = Boolean.FALSE
			operation.newValue = Boolean.TRUE
		}
		else if(operation.oldValue.literal == model.bug.BugStatus.CLOSED.literal) {
			operation.featureName = "done"
			operation.oldValue = Boolean.TRUE
			operation.newValue = Boolean.FALSE
		}
		else {
			operation.delete()
		}
	}
}

// metamodel adaptation
statusAttribute = model.bug.BugReport.Status

newAttribute(model.bug.BugReport, "done", emf.EBoolean, 0, 1, null)
statusAttribute.delete()

// model migration
for(report in model.bug.BugReport.allInstances) {
	def status = report.unset(statusAttribute)
	if(status == model.bug.BugStatus.CLOSED) {
		report.done = true
	}
	else {
		report.done = false
	}
}