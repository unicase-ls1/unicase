package org.unicase.historyExport;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * Abstract superclass for all history writers of each repository type. This writer provides the possibility to export
 * history from a repository.
 * 
 * @author mharut
 */
public abstract class HistoryWriter {

	List<String> URLs;
	String name;
	String password;
	Long start;
	Long end;
	String filePrefix;
	String fileExtension;
	int fileCounter;
	@SuppressWarnings("rawtypes")
	Map<String, Iterable> urlToLogEntries;

	/**
	 * Constructs a {@link HistoryWriter} with all required arguments. This will also initialize the writer using
	 * {@link #init()}.
	 * 
	 * @param URLs the locations of all repositories
	 * @param name the name to use for authentication
	 * @param password the password to use for authentication
	 * @param start the revision to start with
	 * @param end the revision to end with (use -1 for all revisions)
	 * @param filename the name of the file to write to
	 * @throws Exception if {@link #init() initializing} fails
	 */
	@SuppressWarnings("rawtypes")
	public HistoryWriter(List<String> URLs, String name, String password, Long start, Long end, String filename)
		throws Exception {
		this.URLs = URLs;
		this.name = name;
		this.password = password;
		this.start = start;
		this.end = end;
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
		final CountDownLatch latch = new CountDownLatch(URLs.size());

		// for every repository location...
		for (final String URL : URLs) {
			// use a thread to fetch history
			new Thread(new Runnable() {

				public void run() {
					try {
						// fetch history and save it
						urlToLogEntries.put(URL, getLogEntries(URL));
						// thread is finish -> count down the latch
						latch.countDown();
					} catch (Exception e) {
						e.printStackTrace();
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
	 * Writes and saves the exported history to a file specified by {@link #filename}.
	 * 
	 * @throws IOException if file operations fail
	 */
	public abstract void writeToFile() throws IOException;

	/**
	 * Obtains all log entries (i.e. history) for a repository specified by <code>URL</code>.
	 * 
	 * @param URL the location of the repository
	 * @return all log entries as an {@link Iterable}
	 * @throws Exception if obtaining the log entries fails
	 */
	@SuppressWarnings("rawtypes")
	protected abstract Iterable getLogEntries(String URL) throws Exception;

}
