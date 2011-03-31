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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.eclipse.emf.emfstore.server.exceptions.FileTransferException;

/**
 * File transfer utility class.
 * 
 * @author pfeifferc
 */
public final class FilePartitionerUtil {

	// chunk size. consider that changing this value means that old file transfers will fail.
	private static final int CHUNK_SIZE = 100000;

	// error messages
	private static final String COULD_NOT_FIND_THE_FILE = "Could not find the file!";
	private static final String COULD_NOT_READ_THE_FILE = "Could not read the file!";

	private FilePartitionerUtil() {

	}

	/**
	 * Writes a file chunk to a file.
	 * 
	 * @param file file to be written to
	 * @param fileChunk file chunk
	 * @throws FileTransferException if any error occurs writing to the file.
	 */
	public static synchronized void writeChunk(File file, FileChunk fileChunk) throws FileTransferException {
		try {
			RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rws");
			// skips to the position where the file chunk should be written
			randomAccessFile.skipBytes(fileChunk.getChunkNumber() * CHUNK_SIZE);
			randomAccessFile.write(fileChunk.getData());
			// make sure everything is written instantly
			randomAccessFile.close();
		} catch (FileNotFoundException e) {
			throw new FileTransferException(COULD_NOT_FIND_THE_FILE, e);
		} catch (IOException e) {
			throw new FileTransferException("Could not write to the file!", e);
		}
	}

	/**
	 * Reads a file chunk from a file.
	 * 
	 * @param file to be read from
	 * @param fileInformation containing file transfer attributes
	 * @return fileChunk
	 * @throws FileTransferException if any error occurs reading the file
	 */
	public static synchronized FileChunk readChunk(File file, FileTransferInformation fileInformation)
		throws FileTransferException {
		boolean end = false;
		byte[] data;
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			int absoluteSize = fileInputStream.available();
			// start reading the chunk from the position specified by the chunk number and chunk size
			fileInputStream.skip(fileInformation.getChunkNumber() * CHUNK_SIZE);
			int remainingSize = fileInputStream.available();
			// if the remaining size is chunk size or smaller, set end flag to true, which means this is the last chunk
			if (remainingSize <= CHUNK_SIZE && remainingSize >= 0) {
				end = true;
				data = new byte[remainingSize];
			} else {
				data = new byte[CHUNK_SIZE];
			}
			fileInputStream.read(data);
			fileInputStream.getChannel().close();
			fileInputStream.close();
			fileInformation.setFileSize(absoluteSize);
			return new FileChunk(fileInformation, end, data);
		} catch (IOException e) {
			throw new FileTransferException(COULD_NOT_READ_THE_FILE, e);
		}
	}

	/**
	 * Returns the number of chunks for a given file.
	 * 
	 * @param file file
	 * @return number of chunks
	 * @throws FileTransferException if any error occurs obtaining the file handle.
	 */
	public static int getNumberOfChunks(File file) throws FileTransferException {
		try {
			return (int) Math.ceil(new FileInputStream(file).available() / (float) CHUNK_SIZE);
		} catch (FileNotFoundException e) {
			throw new FileTransferException(COULD_NOT_FIND_THE_FILE, e);
		} catch (IOException e) {
			throw new FileTransferException(COULD_NOT_READ_THE_FILE, e);
		}
	}

	/**
	 * @param file file
	 * @return file size
	 * @throws FileTransferException if any error occurs reading file size
	 */
	public static int getFileSize(File file) throws FileTransferException {
		try {
			return new FileInputStream(file).available();
		} catch (FileNotFoundException e) {
			throw new FileTransferException(COULD_NOT_FIND_THE_FILE, e);
		} catch (IOException e) {
			throw new FileTransferException(COULD_NOT_READ_THE_FILE, e);
		}
	}

	/**
	 * @return the chunk size
	 */
	public static int getChunkSize() {
		return CHUNK_SIZE;
	}
}
