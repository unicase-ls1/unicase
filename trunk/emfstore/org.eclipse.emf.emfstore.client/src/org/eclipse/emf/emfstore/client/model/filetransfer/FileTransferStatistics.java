/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.model.filetransfer;

/**
 * Statistics class that can be queried to get detailed information about a file transfer. This information might be
 * useful to display pretty progress monitor text for example.
 * 
 * @author jfinis
 */
public class FileTransferStatistics {

	private int fileSize;
	private int transferredBytes;
	private long startTime;
	private long stopTime;
	private FileDownloadStatus status;

	/**
	 * Default constructor.
	 * 
	 * @param status the starting status.
	 */
	FileTransferStatistics(FileDownloadStatus status) {
		this.fileSize = FileDownloadStatus.NOT_AVAILABLE;
		this.status = status;
	}

	/**
	 * .
	 * 
	 * @return the file size
	 */
	public int getFileSize() {
		return fileSize;
	}

	/**
	 * .
	 * 
	 * @return the number of already transferred bytes
	 */
	public int getTransferredBytes() {
		return transferredBytes;
	}

	/**
	 * Returns a value between 0 and 1 stating the percentage of already transfered data. If the transfer has not been
	 * started yet, 0 is returned. If the transfer is finished, 1 is returned.
	 * 
	 * @return percentage of transfered data
	 */
	public float getPercentTransferred() {
		switch (status.getStatus()) {
		case NOT_STARTED:
			return 0;
		case FINISHED:
			return 1;
		default:
		}

		int fileSize = getFileSize();

		// Better not risk a division by zero
		if (fileSize <= 0) {
			return 0;
		}

		return getTransferredBytes() / (float) getFileSize();
	}

	/**
	 * Returns the average throughput in bytes per second.
	 * 
	 * @return average throughput
	 */
	public float getAverageThroughput() {
		switch (status.getStatus()) {
		case NOT_STARTED:
			return 0;
		default:
		}
		long elapsed = getElapsedMilis();

		// No div by zero
		if (elapsed == 0) {
			return 0;
		}

		return getTransferredBytes() * 1000f / elapsed;
	}

	/**
	 * Gets the number of remaining seconds (estimated). Works only if the transfer is running. If it is finished 0 is
	 * returned. If it is not yet started or canceled, then NOT_AVAILABLE is returned. If the throughput is 0, then
	 * NOT_AVAILABLE is returned as well.
	 * 
	 * @return the number of remaining seconds
	 */
	public int getEstimatedRemainingTime() {
		switch (status.getStatus()) {
		case NOT_STARTED:
		case CANCELLED:
			return FileDownloadStatus.NOT_AVAILABLE;
		case FINISHED:
			return 0;
		default:
		}
		int remaining = getRemainingBytes();
		float avgThroughput = getAverageThroughput();

		if (avgThroughput == 0) {
			return FileDownloadStatus.NOT_AVAILABLE;
		}

		return (int) (remaining / avgThroughput);
	}

	/**
	 * returns the amount of bytes that has not yet been transferred.
	 * 
	 * @return remaining bytes
	 */
	public int getRemainingBytes() {
		return fileSize - transferredBytes;
	}

	/**
	 * Returns the number of seconds the download is already active. If it is not yet active, then 0 is returned. If the
	 * download is finished or canceled, then the time in which it was active is returned.
	 * 
	 * @return the elapsed time
	 */
	public int getElapsedTime() {
		return (int) (getElapsedMilis() / 1000);
	}

	/**
	 * .
	 * 
	 * @return the elapsed time since start in milliseconds
	 */
	private long getElapsedMilis() {
		switch (status.getStatus()) {
		case NOT_STARTED:
			return 0;
		case FINISHED:
		case CANCELLED:
			return stopTime - startTime;
		default:
		}
		return System.currentTimeMillis() - startTime;
	}

	/**
	 * Internal method that is called to register the start of the transfer.
	 * 
	 * @param fileSize the size of the file
	 */
	void registerStart(int fileSize) {
		startTime = System.currentTimeMillis();
		this.fileSize = fileSize;
	}

	/**
	 * Internal method that is called to register the stop of the transfer.
	 */
	void registerStop() {
		stopTime = System.currentTimeMillis();
	}
}
