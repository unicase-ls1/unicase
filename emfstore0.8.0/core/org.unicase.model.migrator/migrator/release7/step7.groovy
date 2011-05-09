diagramPackage = model.diagram
diagramPackage.delete()
diagramPackage2 = newEPackage()
diagramPackage2.name = "diagram"
diagramPackage2.nsURI = "http://unicase.org/model/diagram"
diagramPackage2.nsPrefix = "org.unicase.model.diagram"
eAnnotation = diagramPackage2.newEAnnotation()
eAnnotation.source = "http://www.cs.tum.edu/cope"
eStringToStringMapEntry = eAnnotation.newEStringToStringMapEntry()
eStringToStringMapEntry.key = "historyURI"
eStringToStringMapEntry.value = "../../org.unicase.model/model/model.history"
mEDiagramClass = diagramPackage2.newEClass()
mEDiagramClass.name = "MEDiagram"
mEDiagramClass.'abstract' = true
attachmentClass = model.Attachment
mEDiagramClass.eSuperTypes.add(attachmentClass)
elementsReference = mEDiagramClass.newEReference()
elementsReference.name = "elements"
elementsReference.upperBound = -1
unicaseModelElementClass = model.UnicaseModelElement
elementsReference.eType = unicaseModelElementClass
gmfdiagramReference = mEDiagramClass.newEReference()
gmfdiagramReference.name = "gmfdiagram"
gmfdiagramReference.'transient' = true
gmfdiagramReference.containment = true
diagramClass = notation.Diagram
gmfdiagramReference.eType = diagramClass
newElementsReference = mEDiagramClass.newEReference()
newElementsReference.name = "newElements"
newElementsReference.upperBound = -1
newElementsReference.'transient' = true
newElementsReference.containment = true
newElementsReference.eType = unicaseModelElementClass
diagramLayoutAttribute = mEDiagramClass.newEAttribute()
diagramLayoutAttribute.name = "diagramLayout"
eStringDataType = emf.EString
diagramLayoutAttribute.eType = eStringDataType
classDiagramClass = diagramPackage2.newEClass()
classDiagramClass.name = "ClassDiagram"
classDiagramClass.eSuperTypes.add(mEDiagramClass)
useCaseDiagramClass = diagramPackage2.newEClass()
useCaseDiagramClass.name = "UseCaseDiagram"
useCaseDiagramClass.eSuperTypes.add(mEDiagramClass)
componentDiagramClass = diagramPackage2.newEClass()
componentDiagramClass.name = "ComponentDiagram"
componentDiagramClass.eSuperTypes.add(mEDiagramClass)
stateDiagramClass = diagramPackage2.newEClass()
stateDiagramClass.name = "StateDiagram"
stateDiagramClass.eSuperTypes.add(mEDiagramClass)
activityDiagramClass = diagramPackage2.newEClass()
activityDiagramClass.name = "ActivityDiagram"
activityDiagramClass.eSuperTypes.add(mEDiagramClass)
workItemDiagramClass = diagramPackage2.newEClass()
workItemDiagramClass.name = "WorkItemDiagram"
workItemDiagramClass.eSuperTypes.add(mEDiagramClass)
