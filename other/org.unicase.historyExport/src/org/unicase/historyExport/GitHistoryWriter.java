package org.unicase.historyExport;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

/**
 * Exports history for Git repositories. See {@link HistoryWriter} for details.
 * 
 * @author mharut
 */
public class GitHistoryWriter extends HistoryWriter {

	/**
	 * @see HistoryWriter#HistoryWriter(List, String, String, Long, Long, String)
	 */
	public GitHistoryWriter(List<String> URLs, String name, String password, Long start, Long end, String filename)
		throws Exception {
		super(URLs, name, password, start, end, filename);
	}

	@SuppressWarnings("unchecked")
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

			// for every log entry...
			Iterable<RevCommit> log = urlToLogEntries.get(URL);
			for (RevCommit commit : log) {
				// print basic information about the entry
				out.write("---------------------------------------------");
				out.newLine();
				out.write("revision: " + commit.getParentCount());
				out.newLine();
				out.write("author: " + commit.getAuthorIdent().getName());
				out.newLine();
				out.write("date: " + new Date(commit.getCommitTime()));
				out.newLine();
				out.write("log message: " + commit.getFullMessage());
				out.newLine();
			}
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected Iterable getLogEntries(String URL) throws Exception {
		FileRepositoryBuilder builder = new FileRepositoryBuilder();
		Repository repository = builder.setGitDir(new File(URL)).readEnvironment().findGitDir().build();
		return new Git(repository).log().call();
	}

}
