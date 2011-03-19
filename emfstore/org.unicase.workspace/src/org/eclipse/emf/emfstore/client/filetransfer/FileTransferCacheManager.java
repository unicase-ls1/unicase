/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.filetransfer;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.emfstore.client.Configuration;
import org.eclipse.emf.emfstore.client.impl.ProjectSpaceImpl;
import org.unicase.emfstore.esmodel.FileIdentifier;
import org.unicase.emfstore.exceptions.FileTransferException;
import org.unicase.metamodel.util.FileUtil;

/**
 * This class manages the locally cached files for file transfers. A cache manager instance is contained in every
 * FileTransferManager. No other cache managers should be created.
 * 
 * @author jfinis
 */
public class FileTransferCacheManager {

	/**
	 * tmp folder for file uploads to server.
	 */
	public static final String TEMP_FOLDER = "tmp";

	/**
	 * project folder prefix.
	 */
	public static final String PROJECT_FOLDER_PREFIX = "project-";

	/**
	 * Attachment folder for uploads and downloads.
	 */
	public static final String ATTACHMENT_FOLDER = "attachment";

	/**
	 * The delimiter that separates file attachment id, file version and file name in an uploaded file.
	 */
	public static final String FILE_NAME_DELIMITER = "_";

	/**
	 * The associated project space.
	 */
	private ProjectSpaceImpl projectSpace;

	/**
	 * The cache folder, constructed from the identifier of the project space.
	 */
	private File cacheFolder;

	/**
	 * The temp folder is a folder where unfinished file downloads are stored.
	 */
	private File tempCacheFolder;

	/**
	 * Default constructor for a specific project space.
	 * 
	 * @param projectSpaceImpl the project space to which this cache belongs.
	 */
	public FileTransferCacheManager(ProjectSpaceImpl projectSpaceImpl) {
		this.projectSpace = projectSpaceImpl;
		this.cacheFolder = new File(Configuration.getWorkspaceDirectory() + "ps-" + projectSpace.getIdentifier()
			+ File.separatorChar + "files");
		this.tempCacheFolder = new File(cacheFolder, "temp");
		mkdirs();
	}

	/**
	 * Returns true iff a file with this identifier is present in the cache. After this method has returned true, it is
	 * guaranteed that the getCachedFile method finds the file and does not throw an exception.
	 * 
	 * @param identifier the identifer of the file
	 * @return if the file is present in the cache
	 */
	public boolean hasCachedFile(FileIdentifier identifier) {
		File f = getFileFromId(cacheFolder, identifier);
		return f.exists();
	}

	/**
	 * Returns a cached file with a given identifier. If the file does not exist, a FileTransferException is thrown.
	 * 
	 * @param identifier the idntifier of the file
	 * @return the file
	 * @throws FileTransferException if the file is not present in the cache
	 */
	public File getCachedFile(FileIdentifier identifier) throws FileTransferException {
		File f = getFileFromId(cacheFolder, identifier);
		if (!f.exists()) {
			throw new FileTransferException("The file with the id " + identifier + " is not in the cache");
		}
		return f;
	}

	/**
	 * Adds a file to the cache using a given id. If a file with the given id is already in the cache, it is
	 * overwritten.
	 * 
	 * @param input the file to be cached
	 * @param id the id to be used for the file.
	 * @return the file in the cache folder
	 * @throws IOException any IO Exception that can occur during copying a file
	 */
	public File cacheFile(File input, FileIdentifier id) throws IOException {
		mkdirs();
		File destination = new File(cacheFolder, id.getIdentifier());
		FileUtil.copyFile(input, destination);
		return destination;
	}

	/**
	 * Creates a file in the temp cache folder for a specified file id and returns it. If the file already exists, it is
	 * deleted and newly created.
	 * 
	 * @param id the file id for which to create a temporary file
	 * @return the temporary file
	 * @throws FileTransferException if an io exception occurred during the creation of a new file
	 */
	public File createTempFile(FileIdentifier id) throws FileTransferException {
		mkdirs();
		File cacheFile = getFileFromId(tempCacheFolder, id);
		if (cacheFile.exists()) {
			cacheFile.delete();
		}
		try {
			cacheFile.createNewFile();
		} catch (IOException e) {
			throw new FileTransferException("Could not create temporary file");
		}
		return cacheFile;
	}

	/**
	 * This method moves a file from the temp folder into the cache. It should be called after a temporary file was
	 * written successfully. A file transfer exception is thrown in the following cases: - The file does not exist in
	 * the temp folder - The file already exists in the cache folder - The file cannot be moved to the cache folder (the
	 * rename operation fails)
	 * 
	 * @param id the id of the file which is to be moved
	 * @return the new location of the file after moving it
	 * @throws FileTransferException thrown if the temp file does not exist, the final file already exists, or if the
	 *             rename operation which moves the file fails
	 */
	public File moveTempFileToCache(FileIdentifier id) throws FileTransferException {
		mkdirs();
		File cacheFile = getFileFromId(cacheFolder, id);
		File tmpFile = getFileFromId(tempCacheFolder, id);
		if (!tmpFile.exists()) {
			throw new FileTransferException(
				"Could not move temp file to cache folder. The file does not exist in the temp folder. FileId: "
					+ id.getIdentifier());
		}
		if (cacheFile.exists()) {
			throw new FileTransferException(
				"Could not move temp file to cache folder. The file already exists in the cache folder"
					+ id.getIdentifier());
		}
		if (!tmpFile.renameTo(cacheFile)) {
			throw new FileTransferException("Could not move temp file to cache folder. The move operation failed");
		}
		return cacheFile;
	}

	/**
	 * Builds a file from a cache folder and a file identifier.
	 * 
	 * @param folder the base folder in which the file is
	 * @param id the file identifier of that file
	 * @return the assembled file
	 */
	private File getFileFromId(File folder, FileIdentifier id) {
		return new File(folder, id.getIdentifier());
	}

	/**
	 * Creates all necessary directories (cache and temp).
	 */
	private void mkdirs() {
		cacheFolder.mkdirs();
		tempCacheFolder.mkdirs();
	}

	/**
	 * Removes a file from the cache. Does nothing if no such file is cached. Returns true if the file was successfully
	 * deleted from cache, otherwise false.
	 * 
	 * @param fileIdentifier the identifier of the file to be removed
	 * @return true iff the file was deleted successfully
	 */
	public boolean removeCachedFile(FileIdentifier fileIdentifier) {
		File toRemove = getFileFromId(cacheFolder, fileIdentifier);
		if (toRemove.exists()) {
			return toRemove.delete();
		}
		return false;
	}
}
