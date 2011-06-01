/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.filetransfer;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.emf.emfstore.client.ProjectSpace;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.exceptions.FileTransferException;
import org.eclipse.emf.emfstore.server.model.FileIdentifier;

/**
 * An object of this class is returned from any workspace method that starts a
 * file transfer. It provides information about this file transfer and allows to
 * add Progressmonitors and Observers
 * 
 * @author jfinis
 */
public final class FileDownloadStatus {

	/* PRIVATE MEMBERS */
	private ProjectSpace transferringProjectSpace;
	private Observable finishedObservable = new Obs();
	private Observable failedObservable = new Obs();

	private FileTransferStatistics statistics = new FileTransferStatistics(this);
	private Status status;
	private File transferredFile;
	private FileIdentifier id;
	private Exception exception;

	private FileDownloadStatus(ProjectSpace transferringProjectSpace,
			FileIdentifier id, Status status, File transferredFile) {
		this.transferringProjectSpace = transferringProjectSpace;
		this.status = status;
		this.id = id;
		this.transferredFile = transferredFile;
	}

	/**
	 * Return value of the getStatus method.
	 * 
	 * @author jfinis
	 */
	public static enum Status {
		/**
		 * The file transfer was not yet started.
		 */
		NOT_STARTED,

		/**
		 * The transfer is actively transfering data.
		 */
		TRANSFERING,

		/**
		 * The transfer is finished.
		 */
		FINISHED,

		/**
		 * The transfer was cancelled.
		 */
		CANCELLED,

		/**
		 * If an exception was thrown. The exception can then be retrieved by
		 * calling getException()
		 */
		FAILED
	}

	/**
	 * Constant signaling "not available".
	 */
	public static final int NOT_AVAILABLE = -1;

	/**
	 * Returns the identifier of the file to be downloaded.
	 * 
	 * @return the identifier
	 */
	public FileIdentifier getFileIdentifier() {
		return id;
	}

	/**
	 * This is the ultimate method for checking in which "stage" a file transfer
	 * currently is. i.e. if it is still waiting, transferring or finished. See
	 * the enum Status for possible values.
	 * 
	 * @return the stage in which the file transfer currently is
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * Adds an observer that is notified once the transfer is finished. If the
	 * transfer is already finished at the moment when this method is called,
	 * then the observer is instantly notified. The object that is passed to the
	 * observer's update message is this instance of FileTransferStatus
	 * 
	 * @param o
	 *            an observer to be notified when the transfer is finished
	 */
	public void addTransferFinishedObserver(Observer o) {
		// Add
		finishedObservable.addObserver(o);

		// Instantly notify if the transfer is already finished
		if (isTransferFinished()) {
			o.update(finishedObservable, this);
		}
	}

	/**
	 * Adds an observer which is notified if the transfer fails due to an
	 * exception. The getException method can then be used to retrieve the
	 * thrown exception.
	 * 
	 * @param o
	 *            an observer that is notified if the transfer fails
	 */
	public void addTransferFailedObserver(Observer o) {

		failedObservable.addObserver(o);

		// If the transfer has already failed, notify instantly
		if (status == Status.FAILED) {
			o.update(failedObservable, this);
		}
	}

	/**
	 * Adds a default observer that is notified when the transfer fails. This
	 * observer logs the failure.
	 */
	public void addDefaultFailObserver() {
		addTransferFailedObserver(new Observer() {

			public void update(Observable arg0, Object arg1) {
				FileDownloadStatus status = (FileDownloadStatus) arg1;
				Exception e = status.getException();
				ModelUtil.logException("File transfer failed!", e);

			}
		});
	}

	/**
	 * Removes a transfer observer from the list of observers.
	 * 
	 * @param o
	 *            an observer to be removed
	 */
	public void deleteTransferFinishedObserver(Observer o) {
		finishedObservable.deleteObserver(o);
	}

	/**
	 * Returns true if the transfer is finished.
	 * 
	 * @return transfer finished?
	 */
	public boolean isTransferFinished() {
		return status == Status.FINISHED;
	}

	/**
	 * Gets the statistics object for this file transfer, which provides useful
	 * information, especially while the transfer is active. It provides
	 * information like the file size, the amount of already transfered bytes
	 * the estimated remaining time and more.
	 * 
	 * @return the statistics for this transfer
	 */
	public FileTransferStatistics getStatistics() {
		return statistics;
	}

	/**
	 * Returns the transferred file. If this is a download, then the file is
	 * only available, if the download is finished. If it is not finished yet,
	 * an file transfer exception is thrown.
	 * 
	 * @return the transferred file or a FileTransferException exception if the
	 *         file is not yet transferred.
	 * @throws FileTransferException
	 *             if the file is not yet fully transferred
	 */
	public File getTransferredFile() throws FileTransferException {
		if (!isTransferFinished()) {
			throw new FileTransferException(
					"Trying to get a transferred file while transfer is not yet finished");
		}
		return transferredFile;
	}

	/**
	 * Similar to {@link #getTransferredFile()}, but this method blocks the
	 * client thread.
	 * 
	 * @param block
	 *            block or not
	 * @return File
	 * @throws FileTransferException
	 *             in case of an error
	 */
	public File getTransferredFile(boolean block) throws FileTransferException {

		if (!isTransferFinished() && block) {
			/**
			 * TODO: Double-check this code
			 */
			final Observer observer = new Observer() {
				public void update(Observable arg0, Object arg1) {
					synchronized (this) {
						notifyAll();
					}
				}
			};
			addTransferFailedObserver(observer);
			addTransferFinishedObserver(observer);
			try {
				synchronized (observer) {
					observer.wait();
				}
			} catch (InterruptedException e) {
				throw new FileTransferException(
						"Failed to initialize blocked get.", e);
			}
		}
		return getTransferredFile();
	}

	/**
	 * Returns the project space which started this file transfer.
	 * 
	 * @return the project space owning this file transfer
	 */
	public ProjectSpace getTransferringProjectSpace() {
		return transferringProjectSpace;
	}

	/**
	 * Returns the exception that caused the download to fail, if the status ==
	 * FAILED. Otherwise, returns null
	 * 
	 * @return the exception that caused the failure or null if not failed
	 */
	public Exception getException() {
		return exception;
	}

	/**
	 * Called internally if the transfer is canceled.
	 */
	void transferCancelled() {
		if (status == Status.FINISHED) {
			return;
		}
		statistics.registerStop();
		status = Status.CANCELLED;
	}

	/**
	 * Called internally when the transfer is started.
	 * 
	 * @param fileSize
	 *            the file size
	 * @throws FileTransferException
	 *             if the transfer has already been started
	 */
	void transferStarted(int fileSize) throws FileTransferException {
		if (status != Status.NOT_STARTED) {
			throw new FileTransferException("Cannot start a job that is "
					+ status.name());
		}
		statistics.registerStart(fileSize);
		status = Status.TRANSFERING;
	}

	/**
	 * Called internally when the transfer is finished.
	 * 
	 * @param result
	 *            the resulting file in the cache
	 */
	void transferFinished(File result) {
		status = Status.FINISHED;
		transferredFile = result;
		statistics.registerStop();
		finishedObservable.notifyObservers(this);
	}

	/**
	 * Called internally if the transfer fails.
	 * 
	 * @param ex
	 *            the exception that caused the failure
	 */
	void transferFailed(Exception ex) {
		status = Status.FAILED;
		statistics.registerStop();
		exception = ex;
		failedObservable.notifyObservers(this);
	}

	/**
	 * This observerable is always changed, so notifying will always notify
	 * Observers.
	 * 
	 * @author jfinis
	 */
	private static class Obs extends Observable {

		@Override
		public void notifyObservers(Object arg) {
			super.setChanged();
			super.notifyObservers(arg);
		}
	}

	/**
	 * This factory class creates the different possible download stats.
	 * 
	 * @author jfinis
	 */
	static class Factory {

		/**
		 * Creates an already finished download status (status FINISHED).
		 * 
		 * @param p
		 *            the project space containing the download
		 * @param id
		 *            the identifier of the download
		 * @param transferredFile
		 *            the file where the download can be found
		 * @return the created status object
		 */
		public static FileDownloadStatus createAlreadyFinished(ProjectSpace p,
				FileIdentifier id, File transferredFile) {
			return new FileDownloadStatus(p, id, Status.FINISHED,
					transferredFile);
		}

		/**
		 * Creates a new download status which is initially in the NOT_STARTED
		 * state.
		 * 
		 * @param p
		 *            the project space containing the download
		 * @param id
		 *            the identifier of the file to be downloaded
		 * @return the created status object
		 */
		public static FileDownloadStatus createNew(ProjectSpace p,
				FileIdentifier id) {
			return new FileDownloadStatus(p, id, Status.NOT_STARTED, null);
		}
	}

}
