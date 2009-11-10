package org.unicase.ui.meeditor.commands;

import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.model.attachment.FileAttachment;
import org.unicase.model.attachment.impl.FileAttachmentImpl;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.filetransfer.FileTransferOnDone;
import org.unicase.workspace.util.UnicaseCommand;

public final class FileAttachmentUpdaterImpl implements FileTransferOnDone {

	private ProjectSpace projectSpace;

	/**
	 * {@inheritDoc}
	 */
	public void setProjectSpace(ProjectSpace projectSpace) {
		this.projectSpace = projectSpace;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setFileIdentifier(String fileIdentifier) {

	}

	/**
	 * {@inheritDoc}
	 */
	public void setFileInformation(final FileInformation fileInformation) {
		ModelElementId modelElementId = MetamodelFactory.eINSTANCE.createModelElementId();
		modelElementId.setId(fileInformation.getFileIdentifier());
		final ModelElement modelElement = projectSpace.getProject().getModelElement(modelElementId);
		if (modelElement != null && modelElement instanceof FileAttachmentImpl) {
			new UnicaseCommand() {

				@Override
				protected void doRun() {
					FileAttachment fileAttachment = (FileAttachment) modelElement;
					fileAttachment.setFileID("" + fileInformation.getFileVersion());
					fileAttachment.setFileName(fileInformation.getFileName());
					fileAttachment.setFileSize(fileInformation.getFileSize());
				}
			}.run();
		}
	}
}
