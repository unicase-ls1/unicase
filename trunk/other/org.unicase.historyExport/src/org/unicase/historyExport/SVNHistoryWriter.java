package org.unicase.historyExport;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNLogEntry;
import org.tmatesoft.svn.core.SVNLogEntryPath;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

/**
 * Exports history for SVN repositories. See {@link HistoryWriter} for details.
 * 
 * @author mharut
 */
public class SVNHistoryWriter extends HistoryWriter {

	/**
	 * @see HistoryWriter#HistoryWriter(List, String, String, Long, Long, String)
	 */
	public SVNHistoryWriter(List<String> URLs, String name, String password, Long start, Long end, String filename)
		throws Exception {
		super(URLs, name, password, start, end, filename);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void writeToFile() throws IOException {

		// for every repository location...
		for (String URL : URLs) {
			// initialize the file writing mechanism
			FileWriter writer = new FileWriter(filePrefix + "(" + fileCounter++ + ")" + fileExtension);
			BufferedWriter out = new BufferedWriter(writer);

			// begin writing to the file
			System.out.println("Writing history to file for repository at " + URL);
			out.write("############################################");
			out.newLine();
			out.write("Repository at " + URL);
			out.newLine();
			out.write("############################################");
			out.newLine();

			// for every log entry
			Iterable logEntries = urlToLogEntries.get(URL);
			for (Iterator entries = logEntries.iterator(); entries.hasNext();) {
				// print basic information about the entry
				SVNLogEntry logEntry = (SVNLogEntry) entries.next();
				out.write("---------------------------------------------");
				out.newLine();
				out.write("revision: " + logEntry.getRevision());
				out.newLine();
				out.write("author: " + logEntry.getAuthor());
				out.newLine();
				out.write("date: " + logEntry.getDate());
				out.newLine();
				out.write("log message: " + logEntry.getMessage());
				out.newLine();

				// if available, print more detailed information on paths that
				// have changed
				if (logEntry.getChangedPaths().size() > 0) {
					out.newLine();
					out.write("changed paths:");
					out.newLine();
					Set changedPathsSet = logEntry.getChangedPaths().keySet();

					for (Iterator changedPaths = changedPathsSet.iterator(); changedPaths.hasNext();) {
						SVNLogEntryPath entryPath = (SVNLogEntryPath) logEntry.getChangedPaths().get(
							changedPaths.next());
						out.write(" "
							+ entryPath.getType()
							+ " "
							+ entryPath.getPath()
							+ ((entryPath.getCopyPath() != null) ? " (from " + entryPath.getCopyPath() + " revision "
								+ entryPath.getCopyRevision() + ")" : ""));
						out.newLine();
					}
				}
			}
			out.close();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected Iterable getLogEntries(String URL) throws Exception {
		// initialize the repository
		SVNURL svnURL = SVNURL.parseURIEncoded(URL);

		DAVRepositoryFactory.setup();

		final SVNRepository repository = SVNRepositoryFactory.create(svnURL);
		ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(name, password);

		repository.setAuthenticationManager(authManager);

		// last revision to fetch
		long maxEnd = end >= 0 ? end : repository.getLatestRevision();

		// we have at most maxEnd + 1 log entries
		final List log = new ArrayList((int) (maxEnd - start + 1));

		// array for storing intermediate results for each thread
		final Collection[] logArray = new Collection[(int) ((maxEnd - start) / 500) + 1];

		// counter to determine the next index
		int counter = 0;

		// latch for synchronizing threads
		final CountDownLatch latch = new CountDownLatch(logArray.length);

		// for each 500 entries...
		for (Long i = start; i <= maxEnd; i += 500) {
			// determine start and end revision
			final Long startRevision = i;
			final Long endRevision = (startRevision + 499) > maxEnd ? maxEnd : (startRevision + 499);
			final int index = counter++;

			// create and start thread to fetch the data
			new Thread(new Runnable() {

				public void run() {
					try {
						logArray[index] = repository.log(new String[] { "" }, null, startRevision, endRevision, true,
							true);
						// thread is finished -> count down the latch
						latch.countDown();
					} catch (SVNException e) {
						e.printStackTrace();
					}
				}

			}).start();
		}

		// update status for the user
		System.out.println("Starting to fetch revisions for repository at " + URL);

		// while there is still a thread running...
		while (latch.getCount() > 0) {
			// compute how many revisions have been fetched already
			long remainingRevisions = latch.getCount() * 500;
			if (remainingRevisions > maxEnd) {
				remainingRevisions = maxEnd;
			}
			// tell the user about the current status
			System.out.println("Remaining revisions to fetch for " + URL + ": " + remainingRevisions);
			// wait for all threads to finish or until 10 seconds have passed
			latch.await(10, TimeUnit.SECONDS);
		}

		// add all log entries to a list to ensure their order is correct
		for (int j = 0; j < logArray.length; j++) {
			Collection logPart = logArray[j];
			if (logPart != null) {
				log.addAll(logPart);
			}
		}

		// we are done -> inform the user
		System.out.println("Finished fetching revisions for repository at " + URL);

		return log;
	}

}
