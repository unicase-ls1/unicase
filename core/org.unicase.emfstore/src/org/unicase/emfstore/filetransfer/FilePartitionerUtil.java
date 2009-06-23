/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.emfstore.filetransfer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.unicase.emfstore.exceptions.FileTransferException;

/**
 * File transfer utility class.
 * 
 * @author pfeifferc
 */
public final class FilePartitionerUtil {

	private static final int CHUNK_SIZE = 100000;

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
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(file);
			fileOutputStream.getChannel().position(fileChunk.getChunkNumber() * CHUNK_SIZE);
			fileOutputStream.write(fileChunk.getData());
			// make sure everything is written instantly
			fileOutputStream.getChannel().close();
			fileOutputStream.flush();
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			throw new FileTransferException("Could not find file!", e);
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
	public static synchronized FileChunk readChunk(File file, FileInformation fileInformation)
		throws FileTransferException {
		boolean end = false;
		byte[] data;
		try {
			// int numberOfChunks = getNumberOfChunks(file);
			FileInputStream fileInputStream = new FileInputStream(file);
			int absoluteSize = fileInputStream.available();
			fileInputStream.skip(fileInformation.getChunkNumber() * CHUNK_SIZE);
			int remainingSize = fileInputStream.available();
			// if the remaining size is chunk size or smaller, set end flag to true, which means this is the last chunk
			if (remainingSize <= CHUNK_SIZE) {
				end = true;
				data = new byte[remainingSize];
			} else {
				data = new byte[CHUNK_SIZE];
			}
			fileInputStream.read(data);
			// System.out.println("Chunk number " + (fileInformation.getChunkNumber() + 1) + " of " + numberOfChunks
			// + " | end: " + end);
			fileInputStream.getChannel().close();
			fileInputStream.close();
			fileInformation.setFileSize(absoluteSize);
			return new FileChunk(fileInformation, end, data);
		} catch (IOException e) {
			throw new FileTransferException("Could not read from file!", e);
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
			throw new FileTransferException("Could not find file!", e);
		} catch (IOException e) {
			throw new FileTransferException("Could not read file!", e);
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
			throw new FileTransferException("Could not find file!", e);
		} catch (IOException e) {
			throw new FileTransferException("Could not read file!", e);
		}
	}

	/**
	 * @return the chunk size
	 */
	public static int getChunkSize() {
		return CHUNK_SIZE;
	}
}
