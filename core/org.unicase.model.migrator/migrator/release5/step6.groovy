attributesReference = model.classes.Enumeration.attributes
identifierAttribute = metamodel.IdentifiableElement.identifier
attributesReference.eKeys.add(identifierAttribute)
attributeClass = model.classes.Attribute
transientAttribute = attributeClass.newEAttribute()
transientAttribute.name = "transient"
eBooleanDataType = emf.EBoolean
transientAttribute.eType = eBooleanDataType
associationClass = model.classes.Association
transientAttribute2 = associationClass.newEAttribute()
transientAttribute2.name = "transient"
transientAttribute2.eType = eBooleanDataType
classesPackage = model.classes
literalClass = classesPackage.newEClass()
literalClass.name = "Literal"
unicaseModelElementClass = model.UnicaseModelElement
literalClass.eSuperTypes.add(unicaseModelElementClass)
enumerationClass = model.classes.Enumeration
literalsReference = enumerationClass.newEReference()
literalsReference.name = "literals"
literalsReference.eType = literalClass
literalsReference.containment = true
literalsReference.upperBound = -1
literalsReference.eKeys.add(identifierAttribute)
