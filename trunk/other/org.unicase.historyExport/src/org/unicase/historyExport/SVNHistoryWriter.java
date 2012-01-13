package org.unicase.historyExport;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import org.unicase.historyExport.ExportManager.ExportType;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Exports history for SVN repositories. See {@link HistoryWriter} for details.
 * 
 * @author mharut
 */
public class SVNHistoryWriter extends HistoryWriter {

	/**
	 * @see HistoryWriter#HistoryWriter(List, String, String, Long, Long, ExportType, String)
	 */
	public SVNHistoryWriter(List<String> URLs, String name, String password, Long start, Long end,
		ExportType exportType, String filename) throws Exception {
		super(URLs, name, password, start, end, exportType, filename);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void writeToTxt() throws IOException {
		// for every repository location...
		for (String URL : URLs) {
			Iterable logEntries = urlToLogEntries.get(URL);
			if (logEntries == null) {
				System.out.println("Failed to export history for repository at " + URL);
				continue;
			}

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

	@SuppressWarnings("rawtypes")
	public void writeToPdf() throws FileNotFoundException, DocumentException {
		// initialize the PDF document
		Document document = new Document(PageSize.A4, 20, 20, 20, 20);
		PdfWriter.getInstance(document, new FileOutputStream(filePrefix + fileExtension));
		document.open();

		// for every repository location...
		for (String URL : URLs) {
			// check if revisions were received successfully
			Iterable logEntries = urlToLogEntries.get(URL);
			if (logEntries == null) {
				System.out.println("Failed to export history for repository at " + URL);
				continue;
			}
			document.newPage();

			// counter for status updates shown to the user
			int counter = 0;

			System.out.println("Writing history to file for repository at " + URL);
			Chapter chapter = new Chapter(new Paragraph("Repository at " + URL, FontFactory.getFont(
				FontFactory.HELVETICA, 18, Font.BOLD, new BaseColor(0, 0, 255))), 0);
			chapter.setNumberDepth(0);
			chapter.add(new Paragraph(" "));
			chapter.add(new Paragraph(" "));
			document.add(chapter);

			// initialize the table that will show the revisions's content
			PdfPTable table = new PdfPTable(4);

			table.setWidths(new float[] { 0.135f, 0.2f, 0.3f, 0.4f });

			PdfPCell revisionHeader = new PdfPCell(new Phrase("Revision"));
			revisionHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(revisionHeader);

			PdfPCell authorHeader = new PdfPCell(new Phrase("Author"));
			authorHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(authorHeader);

			PdfPCell dateHeader = new PdfPCell(new Phrase("Date"));
			dateHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(dateHeader);

			PdfPCell messageHeader = new PdfPCell(new Phrase("Log Message"));
			messageHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(messageHeader);
			table.setHeaderRows(1);

			for (Iterator entries = logEntries.iterator(); entries.hasNext();) {
				// print basic information about the entry
				SVNLogEntry logEntry = (SVNLogEntry) entries.next();

				if (table == null) {
					table = new PdfPTable(4);

					table.setWidths(new float[] { 0.135f, 0.2f, 0.3f, 0.4f });
				}

				// print basic information of this log entry
				PdfPCell revisionCell = new PdfPCell(new Phrase(String.valueOf(logEntry.getRevision())));
				revisionCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(revisionCell);

				PdfPCell authorCell = new PdfPCell(new Phrase(logEntry.getAuthor()));
				authorCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(authorCell);

				table.addCell(logEntry.getDate().toString());
				table.addCell(logEntry.getMessage());

				// if available, print more detailed information on paths that
				// have changed
				if (logEntry.getChangedPaths().size() > 0) {
					PdfPCell pathHeader = new PdfPCell(new Phrase("Changed Paths:"));
					pathHeader.setColspan(4);
					pathHeader.setBorderWidthBottom(0);
					table.addCell(pathHeader);

					Set changedPathsSet = logEntry.getChangedPaths().keySet();

					for (Iterator changedPaths = changedPathsSet.iterator(); changedPaths.hasNext();) {
						SVNLogEntryPath entryPath = (SVNLogEntryPath) logEntry.getChangedPaths().get(
							changedPaths.next());
						PdfPCell pathEntry = new PdfPCell(new Phrase(" "
							+ entryPath.getType()
							+ " "
							+ entryPath.getPath()
							+ ((entryPath.getCopyPath() != null) ? " (from " + entryPath.getCopyPath() + " revision "
								+ entryPath.getCopyRevision() + ")" : "")));
						pathEntry.setColspan(4);
						pathEntry.setBorderWidthTop(0);
						pathEntry.setBorderWidthBottom(0);
						table.addCell(pathEntry);
					}
				}
				document.add(table);
				table = null;

				// inform the user every 5000 finished revisions
				if ((++counter % 5000) == 0) {
					System.out.println("Finished " + counter + " revisions!");
				}
			}
			System.out.println("Finished repository at " + URL);
		}
		document.close();
	}
	
	@Override
	public void exportToDatabase() {
		// TODO Implement database export mechanism
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
		final Collection[] logArray = new Collection[(int) ((maxEnd - start) / 1000) + 1];

		// counter to determine the next index
		int counter = 0;

		// latch for synchronizing threads
		final CountDownLatch latch = new CountDownLatch(logArray.length);

		// for each 500 entries...
		for (Long i = start; i <= maxEnd; i += 1000) {
			// determine start and end revision
			final Long startRevision = i;
			final Long endRevision = (startRevision + 999) > maxEnd ? maxEnd : (startRevision + 999);
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
						latch.countDown();
					}
				}

			}).start();
		}

		// update status for the user
		System.out.println("Starting to fetch revisions for repository at " + URL);

		// while there is still a thread running...
		while (latch.getCount() > 0) {
			// compute how many revisions have been fetched already
			long remainingRevisions = latch.getCount() * 1000;
			if (remainingRevisions > maxEnd) {
				remainingRevisions = maxEnd;
			}
			// tell the user about the current status
			System.out.println("Remaining revisions to fetch for " + URL + ": " + remainingRevisions);
			// wait for all threads to finish or until 10 seconds have passed
			latch.await(15, TimeUnit.SECONDS);
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
