/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.historyExport;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
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
 * Exports history for Git repositories. See {@link HistoryWriter} for details.
 * 
 * @author mharut
 */
public class GitHistoryWriter extends HistoryWriter {

	/**
	 * @see HistoryWriter#HistoryWriter(List, String, String, Long, Long, ExportType, String)
	 */
	public GitHistoryWriter(List<String> urls, String name, String password, Long start, Long end,
		ExportType exportType, String filename) throws Exception {
		super(urls, name, password, start, end, exportType, filename);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void writeToTxt() throws IOException {

		// for every repository location...
		for (String url : urls) {
			Iterable<RevCommit> logEntries = urlToLogEntries.get(url);
			if (logEntries == null) {
				System.out.println("Failed to export history for repository at " + url);
				continue;
			}
			// initialize the file writing mechanism
			FileWriter writer = new FileWriter(filePrefix + "(" + fileCounter++ + ")" + fileExtension);
			BufferedWriter out = new BufferedWriter(writer);

			// begin writing to the file
			System.out.println("Writing history to file for repository at " + url);
			out.write("############################################");
			out.newLine();
			out.write("Repository at " + url);
			out.newLine();
			out.write("############################################");
			out.newLine();

			List<RevCommit> commits = reverseLog(logEntries);

			// for every log entry...
			for (RevCommit commit : commits) {
				// print basic information about the entry
				out.write("---------------------------------------------");
				out.newLine();
				out.write("committer: " + commit.getCommitterIdent().getName()
					+ commit.getCommitterIdent().getEmailAddress() != null ? (", " + commit.getCommitterIdent()
					.getEmailAddress()) : "");
				out.newLine();
				out.write("author: " + commit.getAuthorIdent().getName() + commit.getAuthorIdent().getEmailAddress() != null ? (", " + commit
					.getAuthorIdent().getEmailAddress()) : "");
				out.newLine();
				out.write("date: " + new Date(commit.getCommitTime()));
				out.newLine();
				out.write("log message: " + commit.getFullMessage());
				out.newLine();
			}
			out.close();
			System.out.println("Finished repository at " + url);
		}
	}

	private List<RevCommit> reverseLog(Iterable<RevCommit> logEntries) {
		List<RevCommit> result = new LinkedList<RevCommit>();

		for (RevCommit commit : logEntries) {
			result.add(commit);
		}

		Collections.reverse(result);

		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void writeToPdf() throws FileNotFoundException, DocumentException {
		Document document = new Document(PageSize.A4, 20, 20, 20, 20);
		PdfWriter.getInstance(document, new FileOutputStream(filePrefix + fileExtension));
		document.open();

		for (String url : urls) {
			Iterable<RevCommit> logEntries = urlToLogEntries.get(url);
			if (logEntries == null) {
				System.out.println("Failed to export history for repository at " + url);
				continue;
			}
			document.newPage();

			int counter = 0;

			System.out.println("Writing history to file for repository at " + url);
			Chapter chapter = new Chapter(new Paragraph("Repository at " + url, FontFactory.getFont(
				FontFactory.HELVETICA, 18, Font.BOLD, new BaseColor(0, 0, 255))), 0);
			chapter.setNumberDepth(0);
			chapter.add(new Paragraph(" "));
			chapter.add(new Paragraph(" "));
			document.add(chapter);

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

			List<RevCommit> commits = reverseLog(logEntries);

			for (RevCommit commit : commits) {
				if (table == null) {
					table = new PdfPTable(4);

					table.setWidths(new float[] { 0.135f, 0.2f, 0.3f, 0.4f });
				}

				PdfPCell revisionCell = new PdfPCell(new Phrase(String.valueOf(commit.getParentCount())));
				revisionCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(revisionCell);

				PdfPCell authorCell = new PdfPCell(new Phrase(commit.getAuthorIdent().getName()));
				authorCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(authorCell);

				table.addCell(new Date(commit.getCommitTime()).toString());
				table.addCell(commit.getFullMessage());

				document.add(table);
				table = null;

				if ((++counter % 5000) == 0) {
					System.out.println("Finished " + counter + " revisions!");
				}
			}
			System.out.println("Finished repository at " + url);
		}
		document.close();
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected Iterable getLogEntries(String url) throws Exception {
		// UsernamePasswordCredentialsProvider credentialsProvider = new UsernamePasswordCredentialsProvider(name,
		// password);
		// RemoteSession session = JschConfigSessionFactory.getInstance().getSession(new URIish(url),
		// credentialsProvider,
		// FS.detect(), 10000);
		// Process process = session.exec("LogCommand", 1000);
		// System.out.println(process.getInputStream().toString());
		FileRepositoryBuilder builder = new FileRepositoryBuilder();
		Repository repository = builder.setGitDir(new File(url)).readEnvironment().findGitDir().build();
		return new Git(repository).log().call();
	}

}