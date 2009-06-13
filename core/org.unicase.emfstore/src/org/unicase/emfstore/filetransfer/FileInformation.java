/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
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

	private String fileAttachmentId;

	private String fileName;

	/**
	 * @param chunkNumber chunk number
	 * @param fileVersion file version
	 * @param fileName file name
	 * @param fileAttachmentId file attachment id
	 */
	public FileInformation(int chunkNumber, int fileVersion, String fileName, String fileAttachmentId) {
		this.fileVersion = fileVersion;
		this.fileName = fileName;
		this.fileAttachmentId = fileAttachmentId;
	}

	/**
	 * @param fileVersion file version
	 * @param fileName file name
	 * @param fileAttachmentId file attachment id
	 */
	public FileInformation(int fileVersion, String fileName, String fileAttachmentId) {
		this.fileVersion = fileVersion;
		this.fileName = fileName;
		this.fileAttachmentId = fileAttachmentId;
	}

	/**
	 * @param chunkNumber chunk number
	 * @param fileVersion file version
	 * @param fileAttachmentId file attachment id
	 */
	public FileInformation(int chunkNumber, int fileVersion, String fileAttachmentId) {
		this.chunkNumber = chunkNumber;
		this.fileVersion = fileVersion;
		this.fileAttachmentId = fileAttachmentId;
	}

	/**
	 * @param chunkNumber chunk number
	 * @param fileVersion file version
	 */
	public FileInformation(int chunkNumber, int fileVersion) {
		this.chunkNumber = chunkNumber;
		this.fileVersion = fileVersion;
	}

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
	 * @return the file attachment id
	 */
	public String getFileAttachmentId() {
		return fileAttachmentId;
	}

	/**
	 * @param fileAttachmentId file attachment id
	 */
	public void setFileAttachmentId(String fileAttachmentId) {
		this.fileAttachmentId = fileAttachmentId;
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
		String s = "";
		s += "File attachment id: " + fileAttachmentId;
		s += "\nFile version: " + fileVersion;
		s += "\nFile name: " + fileName;
		return s;
	}
}