/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.historyExport;

import java.util.LinkedList;
import java.util.List;

/**
 * Main class of the Version-Control-History-Export tool. Running this will fetch history of all provided version
 * control URLs and export them.<br>
 * Possible options include:
 * <ul>
 * <li>Export history from multiple projects at once</li>
 * <li>Use name and password for authentication</li>
 * <li>Define at which revision to start and/or at which revision to end the export</li>
 * <li>Save the export to a certain file name</li>
 * <li>Support for SVN and Git</li>
 * <li>Export to .txt or .pdf files</li>
 * </ul>
 * 
 * @author mharut
 */
public final class ExportManager {

	private ExportManager() {
		// nothing to do
	}

	/**
	 * Supported version control types.
	 */
	enum VcsType {
		/**
		 * Literal for SVN repositories.
		 */
		SVN,

		/**
		 * Literal for Git repositories.
		 */
		GIT
	};

	/**
	 * Supported export types.
	 */
	enum ExportType {
		/**
		 * Literal for text files.
		 */
		TXT,

		/**
		 * Literal for pdf files.
		 */
		PDF
	};

	public static void main(String[] args) {
		try {
			if (args.length <= 0) {
				// no URLs were provided -> print help and exit
				printHelp();
			} else {
				HistoryWriter historyWriter = parseArgs(args);
				if (historyWriter != null) {
					historyWriter.export();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Parses the arguments provided to the user to determine the required URLs and optionally name, password, start
	 * and/or end revision, filename and repository type.
	 * 
	 * @param args the arguments to construct a {@link HistoryWriter} from
	 * @return a {@link HistoryWriter} constructed from the provided arguments
	 * @throws Exception if constructing the {@link HistoryWriter} fails
	 */
	private static HistoryWriter parseArgs(String[] args) throws Exception {
		int i = 0;
		List<String> urls = new LinkedList<String>();
		while (i < args.length && !args[i].startsWith("-")) {
			urls.add(args[i]);
			i++;
		}
		String name = "";
		String password = "";
		Long start = new Long(0);
		Long end = new Long(-1);
		String filename = null;
		VcsType vcsType = VcsType.SVN;
		ExportType exportType = ExportType.TXT;
		for (int j = i; j < args.length; j++) {
			if (args[j].equals("-name")) {
				j++;
				if (j >= args.length) {
					printHelp();
					return null;
				}
				name = args[j];
			} else if (args[j].equals("-password")) {
				j++;
				if (j >= args.length) {
					printHelp();
					return null;
				}
				password = args[j];
			} else if (args[j].equals("-start")) {
				j++;
				if (j >= args.length) {
					printHelp();
					return null;
				}
				start = Long.parseLong(args[j]);
			} else if (args[j].equals("-end")) {
				j++;
				if (j >= args.length) {
					printHelp();
					return null;
				}
				end = Long.parseLong(args[j]);
			} else if (args[j].equals("-filename")) {
				j++;
				if (j >= args.length) {
					printHelp();
					return null;
				}
				filename = args[j];
			} else if (args[j].equals("-git")) {
				vcsType = VcsType.GIT;
			} else if (args[j].equals("-pdf")) {
				exportType = ExportType.PDF;
			} else {
				printHelp();
				return null;
			}
		}
		if (filename == null) {
			switch (exportType) {
			case TXT:
				filename = "myHistory.txt";
				break;
			case PDF:
				filename = "myHistory.pdf";
				break;
			default:
				break;
			}
		}
		switch (vcsType) {
		case GIT:
			return new GitHistoryWriter(urls, name, password, start, end, exportType, filename);
		case SVN:
		default:
			return new SVNHistoryWriter(urls, name, password, start, end, exportType, filename);
		}
	}

	/**
	 * Prints a help message to the command line to show how to use the tool.
	 */
	private static void printHelp() {
		System.out
			.println("Usage: ExportManager repository-urls [-name name] [-password password] [-start start] [-end end] [-filename filename] [-git] [-pdf]");
	}

}
