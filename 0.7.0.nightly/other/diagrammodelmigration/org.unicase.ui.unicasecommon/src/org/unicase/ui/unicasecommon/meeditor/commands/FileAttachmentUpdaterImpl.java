/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.meeditor.commands;

import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.ModelElementId;
import org.unicase.model.attachment.FileAttachment;
import org.unicase.model.attachment.impl.FileAttachmentImpl;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.filetransfer.FileTransferOnDone;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Updates file attachments on file upload completion.
 * 
 * @author pfeifferc
 */
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
		final EObject modelElement = projectSpace.getProject().getModelElement(modelElementId);
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
