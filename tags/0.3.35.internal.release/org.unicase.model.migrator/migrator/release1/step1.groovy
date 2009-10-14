fileAttachmentClass = model.attachment.FileAttachment
requiredOfflineAttribute = fileAttachmentClass.newEAttribute()
requiredOfflineAttribute.name = "requiredOffline"
eBooleanDataType = emf.EBoolean
requiredOfflineAttribute.eType = eBooleanDataType
commentClass = model.rationale.Comment
nonDomainElementClass = model.NonDomainElement
commentClass.eSuperTypes.add(nonDomainElementClass)
