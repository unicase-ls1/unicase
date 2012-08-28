for(attachment in model.attachment.FileAttachment.allInstances) {
	
	def FILE_NAME_DELIMITER = "_";
	
	//	protection against double migration
	if(attachment.fileID.contains(FILE_NAME_DELIMITER)){
		throw new RuntimeException("Already migrated")
	}
	
	String meId = attachment.uuid;
	String version = attachment.fileID;
	String fileName = attachment.fileName;
	
	String newId = meId + FILE_NAME_DELIMITER + version + FILE_NAME_DELIMITER + fileName;
	
	attachment.fileID = newId;
}

