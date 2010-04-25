/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.emfstore.filetransfer;

import java.io.Serializable;

/**
 * Data object for file transfer information.
 * 
 * @author pfeifferc
 */
public class FileInformation implements Serializable {

	private static final long serialVersionUID = 1L;

	private int fileVersion;

	private int chunkNumber;

	private int fileSize;

	private String fileIdentifier;

	private String fileName;

	/**
	 * Default constructor.
	 */
	public FileInformation() {

	}

	/**
	 * @return the file name
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName file name
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the file version
	 */
	public int getFileVersion() {
		return fileVersion;
	}

	/**
	 * @param fileVersion file version
	 */
	public void setFileVersion(int fileVersion) {
		this.fileVersion = fileVersion;
	}

	/**
	 * @return the chunk number
	 */
	public int getChunkNumber() {
		return chunkNumber;
	}

	/**
	 * @param chunkNumber chunk number
	 */
	public void setChunkNumber(int chunkNumber) {
		this.chunkNumber = chunkNumber;
	}

	/**
	 * @return the file identifier
	 */
	public String getFileIdentifier() {
		return fileIdentifier;
	}

	/**
	 * @param fileIdentifier file identifier
	 */
	public void setFileAttachmentId(String fileIdentifier) {
		this.fileIdentifier = fileIdentifier;
	}

	/**
	 * @return the file size
	 */
	public int getFileSize() {
		return fileSize;
	}

	/**
	 * @param fileSize the file size
	 */
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("File Identifier: ");
		string.append(fileIdentifier);
		string.append("\nFile Version: ");
		string.append(fileVersion);
		string.append("\nFile Name: ");
		string.append(fileName);
		string.append("\nCurrent Chunk Number: ");
		string.append(chunkNumber);
		string.append("\nTotal File (ALL chunks) Size: ");
		string.append(fileSize);
		return string.toString();
	}
}