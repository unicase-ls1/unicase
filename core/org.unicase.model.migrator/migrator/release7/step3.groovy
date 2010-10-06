unicaseModelElementClass = model.UnicaseModelElement
modelElementClass = metamodel.ModelElement
unicaseModelElementClass.eSuperTypes.remove(modelElementClass)

for(element in unicaseModelElementClass.allInstances) {
	def id = element.unset(modelElementClass.identifier)
	element.setUuid(id)
}