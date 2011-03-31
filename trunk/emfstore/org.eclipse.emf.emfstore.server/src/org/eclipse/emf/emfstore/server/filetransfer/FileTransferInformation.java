/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.filetransfer;

import java.io.Serializable;

import org.eclipse.emf.emfstore.server.model.FileIdentifier;
import org.eclipse.emf.emfstore.server.model.ModelFactory;

/**
 * Data object for file transfer information.
 * 
 * @author pfeifferc, jfinis
 */
public class FileTransferInformation implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Constant for specifying unknown file size.
	 */
	public static final int UNKOWN_SIZE = -1;

	private int chunkNumber;

	private int fileSize;

	private String fileIdentifier;

	/**
	 * Default constructor.
	 * 
	 * @param identifier the file identifier
	 * @param fileSize the file size, in bytes
	 */
	public FileTransferInformation(FileIdentifier identifier, int fileSize) {
		this.fileIdentifier = identifier.getIdentifier();
		this.fileSize = fileSize;
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

	public FileIdentifier getFileIdentifier() {
		FileIdentifier fid = ModelFactory.eINSTANCE.createFileIdentifier();
		fid.setIdentifier(fileIdentifier);
		return fid;
	}

	/**
	 * Sets the filde identifer.
	 * 
	 * @param fileId file identifier
	 */
	public void setFileIdentifier(FileIdentifier fileId) {
		fileIdentifier = fileId.getIdentifier();
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
		string.append("\nCurrent Chunk Number: ");
		string.append(chunkNumber);
		string.append("\nTotal File (ALL chunks) Size: ");
		string.append(fileSize);
		return string.toString();
	}
}
