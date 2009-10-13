/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.test.fileapi.clientside;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.junit.Test;
import org.unicase.emfstore.exceptions.FileTransferException;
import org.unicase.model.ModelElement;
import org.unicase.model.attachment.AttachmentPackage;
import org.unicase.model.attachment.FileAttachment;
import org.unicase.workspace.PendingFileTransfer;
import org.unicase.workspace.test.fileapi.AbstractFileAPIClientSideTest;
import org.unicase.workspace.util.FileTransferUtil;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * @author pfeifferc
 */
public class AddPendingFileTransfersTest extends AbstractFileAPIClientSideTest {

	private ArrayList<PendingFileTransfer> pendingFileTransfersDownload;
	private ArrayList<PendingFileTransfer> pendingFileTransfersUpload;
	private ArrayList<FileAttachment> fileAttachments;
	private ArrayList<File> filesInCache;
	private EList<ModelElement> modelElements;

	/**
	 * 
	 */
	@Test
	public void addPendingFileTransfers() {
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				loadFiles();
				checkConsistencyBefore();
				retrieveFileAttachmentForTest();
				generatePendingFileTransfers();
				addPendingFileTransfersToWorkspace();
				checkConsistencyAfter();
			}

		};
	}

	private void loadFiles() {
		// TODO: load files dedicated for upload testing purposes into the array list
		filesInCache = new ArrayList<File>();
	}

	@Test
	private void checkConsistencyBefore() {
		// There should not be any pending file transfers before the test has been run. This is a simple consistency
		// check to verify that the setup is clean.
		assertEquals(0, getTestProjectSpace().getPendingFileTransfers().size());
		// TODO: check number of files in cache for uploading purposes
	}

	private void retrieveFileAttachmentForTest() {
		modelElements = getTestProject().getAllModelElements();
		fileAttachments = new ArrayList<FileAttachment>();
		for (ModelElement modelElement : modelElements) {
			if (AttachmentPackage.eINSTANCE.getFileAttachment().isInstance(modelElement)) {
				fileAttachments.add((FileAttachment) modelElement);
			}
		}
	}

	private void generatePendingFileTransfers() {
		pendingFileTransfersDownload = new ArrayList<PendingFileTransfer>();
		pendingFileTransfersUpload = new ArrayList<PendingFileTransfer>();
		// firstly, we create pending file transfers for the files on the server that belong to the file attachments
		// contained in the project
		for (FileAttachment fileAttachment : fileAttachments) {
			try {
				pendingFileTransfersDownload.add(FileTransferUtil.createPendingFileTransferFromFileInformation(
					FileTransferUtil.createFileInformationFromFileAttachment(fileAttachment), false));
			} catch (FileTransferException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// secondly, we add pending file transfers for files to be uploaded to the server.
		for (FileAttachment fileAttachment : fileAttachments) {
			try {
				pendingFileTransfersUpload.add(FileTransferUtil.createPendingFileTransferFromFileInformation(
					FileTransferUtil.createFileInformationFromFileAttachment(fileAttachment), true));
			} catch (FileTransferException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test
	private void addPendingFileTransfersToWorkspace() {
		// adding three non-random files to the PendingFileTransfer EList. The server will be initialized after these
		// have been added.
		for (PendingFileTransfer transfer : pendingFileTransfersDownload) {
			try {
				getTestProjectSpace().addFileTransfer(transfer, null, false);
			} catch (FileTransferException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (PendingFileTransfer transfer : pendingFileTransfersUpload) {
			try {
				getTestProjectSpace().addFileTransfer(transfer, filesInCache.get(0), false);
			} catch (FileTransferException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void checkConsistencyAfter() {
		// TODO Auto-generated method stub

	}
}
