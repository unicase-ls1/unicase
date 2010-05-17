/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.test.fileapi.clientside;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.junit.Test;
import org.unicase.emfstore.exceptions.FileTransferException;
import org.unicase.model.attachment.AttachmentPackage;
import org.unicase.model.attachment.FileAttachment;
import org.unicase.workspace.PendingFileTransfer;
import org.unicase.workspace.test.Activator;
import org.unicase.workspace.test.fileapi.AbstractFileAPIClientSideTest;
import org.unicase.workspace.test.fileapi.FileTransferUtil;

/**
 * @author pfeifferc
 */
public class AddAndExecutePendingFileTransfersTest extends AbstractFileAPIClientSideTest {

	private ArrayList<PendingFileTransfer> pendingFileTransfersDownload;
	private ArrayList<PendingFileTransfer> pendingFileTransfersUpload;
	private ArrayList<FileAttachment> fileAttachments;
	private ArrayList<File> sampleFiles;
	private EList<EObject> modelElements;
	private File cacheFolder;

	/**
	 * Check certain consistencies before running the tests.
	 */
	@Test
	public void checkConsistencyBefore() {
		printStart();
		// There should not be any pending file transfers before the test has been run. This is a simple consistency
		// check to verify that the setup is clean.
		System.out.println("-> There should be 0 pending file transfers...");
		assertEquals(0, getTestProjectSpace().getPendingFileTransfers().size());
		// check that the client-side cache is clean before attempting to transfer files

		File clientCache = new File(FileTransferUtil.constructCacheFolder(getTestProjectSpace().getProjectId()));
		System.out.println("-> There should be 0 files in the client-side cache folder... "
			+ FileTransferUtil.constructCacheFolder(getTestProjectSpace().getProjectId()) + ")");
		assertNull(clientCache.listFiles(new OnlyFilesNotFoldersFilter()));
		printEnd();
	}

	/**
	 * Loads sample files intended for test upload.
	 */
	public void loadFiles() {
		printStart();
		sampleFiles = new ArrayList<File>();
		URL location = FileLocator.find(Activator.getDefault().getBundle(), new Path("sampleFiles"),
			Collections.EMPTY_MAP);
		try {
			cacheFolder = new File(FileLocator.resolve(location).getPath());
		} catch (IOException e) {
			// test will fail if exception is thrown
			e.printStackTrace();
		}
		System.out.println("-> Allocating sample files from " + cacheFolder.getAbsolutePath());
		File[] files = cacheFolder.listFiles(new OnlyFilesNotFoldersFilter());
		// load files dedicated for upload testing purposes into the array list
		int i = 0;
		for (File file : files) {
			if (file.getName().startsWith("sample-")) {
				System.out.println(" -> Allocating file " + ++i + ": " + file.getName());
				sampleFiles.add(file);
			}
		}
		System.out.println("-> Allocation completed. " + sampleFiles.size() + " files loaded.");
		assertNotSame(0, sampleFiles.size());
		printEnd();
	}

	/**
	 * Retrieve file attachments from the project.
	 */
	public void retrieveFileAttachmentForTest() {
		printStart();
		System.out.println("-> Retrieving file attachments from project " + getTestProject() + " for test run...");
		modelElements = getTestProject().getAllModelElements();
		System.out.println("-> Project has " + modelElements.size() + " model elements.");
		fileAttachments = new ArrayList<FileAttachment>();
		for (EObject modelElement : modelElements) {
			if (AttachmentPackage.eINSTANCE.getFileAttachment().isInstance(modelElement)) {
				fileAttachments.add((FileAttachment) modelElement);
			}
		}
		System.out.println("-> Retrieved " + fileAttachments.size() + " file attachments.");
		printEnd();
	}

	/**
	 * 
	 */
	public void generatePendingFileTransfers() {
		printStart();
		pendingFileTransfersDownload = new ArrayList<PendingFileTransfer>();
		pendingFileTransfersUpload = new ArrayList<PendingFileTransfer>();
		// firstly, we create pending file transfers for the files on the server that belong to the file attachments
		// contained in the project
		System.out.println("-> Creating pending file transfers...");
		for (FileAttachment fileAttachment : fileAttachments) {
			try {
				System.out.println(" -> Creating pending file transfer download for " + fileAttachment + ".");
				pendingFileTransfersDownload.add(FileTransferUtil.createPendingFileTransferFromFileInformation(
					FileTransferUtil.createFileInformationFromFileAttachment(fileAttachment), false));
			} catch (FileTransferException e) {
				e.printStackTrace();
			}
		}
		// secondly, we add pending file transfers for files to be uploaded to the server.
		for (FileAttachment fileAttachment : fileAttachments) {
			try {
				System.out.println(" -> Creating pending file transfer upload for " + fileAttachment + ".");
				pendingFileTransfersUpload.add(FileTransferUtil.createPendingFileTransferFromFileInformation(
					FileTransferUtil.createFileInformationFromFileAttachment(fileAttachment), true));
			} catch (FileTransferException e) {
				e.printStackTrace();
			}
		}
		System.out.println("-> Created " + (pendingFileTransfersDownload.size() + pendingFileTransfersUpload.size())
			+ " pending file transfers in total.");
		printEnd();
	}

	/**
	 * 
	 */
	@Test
	public void addPendingFileTransfersToWorkspace() {
		loadFiles();
		retrieveFileAttachmentForTest();
		generatePendingFileTransfers();
		printStart();
		for (PendingFileTransfer transfer : pendingFileTransfersUpload) {
			try {
				getTestProjectSpace().addFileTransfer(
					FileTransferUtil.createFileInformationFromPendingFileTransfer(transfer),
					sampleFiles.get((int) (Math.random() * (sampleFiles.size() - 1))), true, true);
			} catch (FileTransferException e) {
				e.printStackTrace();
			}
		}
		// for (PendingFileTransfer transfer : pendingFileTransfersDownload) {
		// try {
		// getTestProjectSpace().addFileTransfer(
		// FileTransferUtil.createFileInformationFromPendingFileTransfer(transfer), null, true, true);
		// } catch (FileTransferException e) {
		// e.printStackTrace();
		// }
		// }
		System.out.println("There should now be " + pendingFileTransfersUpload.size()
			+ " pending file transfers in the project space.");
		assertEquals(pendingFileTransfersUpload.size(), getTestProjectSpace().getPendingFileTransfers().size());
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		printEnd();
	}

	private void printEnd() {
		System.out.println("END *************************************");
	}

	private void printStart() {
		System.out.println("START *************************************");
	}

	/**
	 * 
	 */
	public void checkConsistencyAfterAddingPendingFileTransfersToWorkspace() {

	}
}

/**
 * @author pfeifferc
 */
class OnlyFilesNotFoldersFilter implements FileFilter {

	/**
	 * @return true if file, false if folder or anything else
	 * @param pathname to be decided for this file
	 */
	public boolean accept(File pathname) {
		if (pathname.isFile()) {
			return true;
		}
		return false;
	}
}
