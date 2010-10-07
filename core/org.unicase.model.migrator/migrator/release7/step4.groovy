modelElementClass = metamodel.ModelElement
identifiableElementClass = metamodel.IdentifiableElement
modelElementClass.eSuperTypes.remove(identifiableElementClass)

for(element in model.UnicaseModelElement.allInstances) {
	def id = element.unset(modelElementClass.identifier)
	element.setUuid(id)
}