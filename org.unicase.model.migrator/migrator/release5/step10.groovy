issueClass = model.rationale.Issue
assessmentsReference = issueClass.newEReference()
assessmentsReference.derived = true
assessmentsReference.'volatile' = true
assessmentsReference.changeable = false
assessmentClass = model.rationale.Assessment
assessmentsReference.eType = assessmentClass
assessmentsReference.upperBound = -1
assessmentsReference.name = "assessments"
assessmentsReference.'transient' = true
eAnnotation = assessmentsReference.newEAnnotation()
eAnnotation.source = "org.unicase.ui.meeditor"
eStringToStringMapEntry = eAnnotation.newEStringToStringMapEntry()
eStringToStringMapEntry.key = "priority"
eStringToStringMapEntry.value = "30"
eStringToStringMapEntry2 = eAnnotation.newEStringToStringMapEntry()
eStringToStringMapEntry2.key = "position"
eStringToStringMapEntry2.value = "bottom"
useCaseStepsReference = model.requirement.UseCase.useCaseSteps
eAnnotation2 = useCaseStepsReference.newEAnnotation()
eAnnotation2.source = "org.unicase.ui.meeditor"
eStringToStringMapEntry3 = eAnnotation2.newEStringToStringMapEntry()
eStringToStringMapEntry3.key = "priority"
eStringToStringMapEntry3.value = "10.1"
eStringToStringMapEntry4 = eAnnotation2.newEStringToStringMapEntry()
eStringToStringMapEntry4.key = "position"
eStringToStringMapEntry4.value = "bottom"
sourceRoleAttribute = model.classes.Association.sourceRole
sourceRoleAttribute.defaultValueLiteral = null
targetRoleAttribute = model.classes.Association.targetRole
targetRoleAttribute.defaultValueLiteral = null
stepClass = model.requirement.Step
nonDomainElementClass = metamodel.NonDomainElement
stepClass.eSuperTypes.add(nonDomainElementClass)
proposalClass = model.rationale.Proposal
proposalClass.eSuperTypes.add(nonDomainElementClass)
solutionClass = model.rationale.Solution
solutionClass.eSuperTypes.add(nonDomainElementClass)
assessmentClass.eSuperTypes.add(nonDomainElementClass)
commentClass = model.rationale.Comment
commentClass.eSuperTypes.add(nonDomainElementClass)
