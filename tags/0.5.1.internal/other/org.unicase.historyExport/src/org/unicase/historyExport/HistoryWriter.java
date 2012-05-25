/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.historyExport;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.unicase.historyExport.ExportManager.ExportType;

import com.itextpdf.text.DocumentException;

/**
 * Abstract superclass for all history writers of each repository type. This writer provides the possibility to export
 * history from a repository.
 * 
 * @author mharut
 */
public abstract class HistoryWriter {

	/**
	 * URLs to the repositories.
	 */
	final List<String> urls;

	/**
	 * Name used for authentication.
	 */
	final String name;

	/**
	 * Password used for authentication.
	 */
	final String password;

	/**
	 * Revision to start with.
	 */
	final Long start;

	/**
	 * Revision to end with.
	 */
	final Long end;

	/**
	 * File format to export to.
	 */
	private final ExportType exportType;

	/**
	 * Prefix for all files to write to.
	 */
	final String filePrefix;

	/**
	 * Extension of the files to write to.
	 */
	final String fileExtension;

	/**
	 * Counts the amount of files already written to.
	 */
	int fileCounter;

	/**
	 * Maps every URL to the corresponding log.
	 */
	@SuppressWarnings("rawtypes")
	Map<String, Iterable> urlToLogEntries;

	/**
	 * Constructs a {@link HistoryWriter} with all required arguments. This will also initialize the writer using
	 * {@link #init()}.
	 * 
	 * @param urls the locations of all repositories
	 * @param name the name to use for authentication
	 * @param password the password to use for authentication
	 * @param start the revision to start with
	 * @param end the revision to end with (use -1 for all revisions)
	 * @param exportType how to export the history
	 * @param filename the name of the file to write to
	 * @throws Exception if {@link #init() initializing} fails
	 */
	@SuppressWarnings("rawtypes")
	public HistoryWriter(List<String> urls, String name, String password, Long start, Long end, ExportType exportType,
		String filename) throws Exception {
		this.urls = urls;
		this.name = name;
		this.password = password;
		this.start = start;
		this.end = end;
		this.exportType = exportType;
		int separatorIndex = filename.lastIndexOf('.');
		filePrefix = filename.substring(0, separatorIndex);
		fileExtension = filename.substring(separatorIndex);
		fileCounter = 1;
		urlToLogEntries = new LinkedHashMap<String, Iterable>();
		init();
	}

	/**
	 * Initializes the {@link HistoryWriter} in that it fetches all log entries for every URL and puts them in
	 * {@link #urlToLogEntries}. History is fetched in parallel using {@link Thread Threads}.
	 */
	private void init() {

		// use a latch to ensure all threads have finished before returning
		final CountDownLatch latch = new CountDownLatch(urls.size());

		// for every repository location...
		for (final String url : urls) {
			// use a thread to fetch history
			new Thread(new Runnable() {

				public void run() {
					try {
						// fetch history and save it
						urlToLogEntries.put(url, getLogEntries(url));
						// thread is finish -> count down the latch
						latch.countDown();
					} catch (Exception e) {
						e.printStackTrace();
						latch.countDown();
					}
				}

			}).start();
		}

		try {
			// wait for all threads to finish
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Writes and saves the exported history to plain text files as specified by {@link #filePrefix} and
	 * {@link #fileExtension}.
	 * 
	 * @throws IOException if file operations fail
	 */
	public abstract void writeToTxt() throws IOException;

	/**
	 * Writes and saves the exported history to a PDF file specified by {@link #filePrefix} and {@link #fileExtension}.
	 * 
	 * @throws FileNotFoundException if the file can't be created
	 * @throws DocumentException if writing to the PDF document fails
	 */
	public abstract void writeToPdf() throws FileNotFoundException, DocumentException;

	/**
	 * Obtains all log entries (i.e. history) for a repository specified by <code>url</code>.
	 * 
	 * @param url the location of the repository
	 * @return all log entries as an {@link Iterable}
	 * @throws Exception if obtaining the log entries fails
	 */
	@SuppressWarnings("rawtypes")
	protected abstract Iterable getLogEntries(String url) throws Exception;

	/**
	 * Exports the log messages to the specified file format.
	 * 
	 * @throws DocumentException if creating the pdf document fails
	 * @throws IOException if creating the file fails
	 */
	public void export() throws DocumentException, IOException {
		switch (exportType) {
		case TXT:
			writeToTxt();
			break;
		case PDF:
			writeToPdf();
			break;
		default:
			break;
		}

	}

}
