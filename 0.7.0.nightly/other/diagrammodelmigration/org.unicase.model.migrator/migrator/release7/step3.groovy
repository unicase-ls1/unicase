modelElementsReference = metamodel.Project.modelElements
identifierAttribute = metamodel.IdentifiableElement.identifier
modelElementsReference.eKeys.remove(identifierAttribute)
cutElementsReference = metamodel.Project.cutElements
cutElementsReference.eKeys.remove(identifierAttribute)
