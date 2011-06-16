/**
 * 
 */
package traceability.handler;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.index.IndexWriter;

import traceRecovery.Directory;
import traceRecovery.TraceRecoveryFactory;
import traceability.fortran.FortranCodeIndexer;
import traceability.fortran.FortranSourceCodeAnalyzer;
import traceability.java.JavaSourceCodeAnalyzer;
import traceability.java.JavaSourceCodeIndexer;

/**
 * Indexer class to index files.
 * 
 * @author taher
 * 
 */
public class Indexer {
	private IndexWriter writer;
	private Directory codeDir;
	private Directory indexDir;

	/**
	 * Will create the indexer that will be used to index the file for search.
	 * 
	 * @param writer
	 *            the type of index writer used.
	 * @param codeDir
	 *            the directory that the code is found in.
	 * @param indexDir
	 *            the directory that the indexed file will be in.
	 */

	public Indexer(IndexWriter writer2, Directory codeDir,
			Directory indexDirectory) {
		writer = writer2;
		this.codeDir = codeDir;
		this.indexDir = indexDirectory;
	}

	public Indexer() {

	}

	public Directory getCodeDir() {
		return codeDir;
	}

	public void setCodeDir(Directory codeDir) {
		this.codeDir = codeDir;
	}

	public Directory getIndexDir() {
		return indexDir;
	}

	public void setIndexDir(Directory indexDir) {
		this.indexDir = indexDir;
	}

	public IndexWriter getWriter() {
		return writer;
	}

	public void setWriter(IndexWriter writer) {
		this.writer = writer;
	}

	public void indexDir(IndexWriter writer, Directory codeDir,
			Directory indexDir) throws IOException {
		this.writer = writer;
		this.codeDir = codeDir;
		this.indexDir = indexDir;

		File index = new File(this.indexDir.getPath());
		File code = new File(this.codeDir.getPath());

		File[] files = code.listFiles();
		JavaSourceCodeIndexer javaIndexer = new JavaSourceCodeIndexer();
		FortranCodeIndexer fortranIndexer = new FortranCodeIndexer();

		if (files == null && code != null) {
			if (code.getName().endsWith(".java")
					&& writer.getAnalyzer() instanceof JavaSourceCodeAnalyzer) {
				javaIndexer.indexFileJava(writer, code);
			}else if((code.getName().endsWith(".f")
					|| code.getName().endsWith(".for")
					|| code.getName().endsWith(".f90") || code.getName().endsWith(
					".f95"))
					&& writer.getAnalyzer() instanceof FortranSourceCodeAnalyzer){
				fortranIndexer.indexFileFortran(writer, code);
			}
		}
		else{
		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			Directory d = TraceRecoveryFactory.eINSTANCE.createDirectory();
			d.setPath(f.getAbsolutePath());
			if (f.isDirectory() && !f.isHidden()) {
				indexDir(writer, d, indexDir);
			} else if (f.getName().endsWith(".java")
					&& writer.getAnalyzer() instanceof JavaSourceCodeAnalyzer) {

				javaIndexer.indexFileJava(writer, f);
			} else if ((f.getName().endsWith(".f")
					|| f.getName().endsWith(".for")
					|| f.getName().endsWith(".f90") || f.getName().endsWith(
					".f95"))
					&& writer.getAnalyzer() instanceof FortranSourceCodeAnalyzer) {

				fortranIndexer.indexFileFortran(writer, f);
			}
		}
	}

	}
	
	public void indexDir(IndexWriter writer, Directory codeDir,
			Directory indexDir,JavaSourceCodeIndexer javIndexer,FortranCodeIndexer fortIndexer) throws IOException {
		this.writer = writer;
		this.codeDir = codeDir;
		this.indexDir = indexDir;

		File index = new File(this.indexDir.getPath());
		File code = new File(this.codeDir.getPath());

		File[] files = code.listFiles();
		JavaSourceCodeIndexer javaIndexer = javIndexer;
		FortranCodeIndexer fortranIndexer = fortIndexer;

		if (files == null && code != null) {
			if (code.getName().endsWith(".java")
					&& writer.getAnalyzer() instanceof JavaSourceCodeAnalyzer) {
				javaIndexer.indexFileJava(writer, code);
			}else if((code.getName().endsWith(".f")
					|| code.getName().endsWith(".for")
					|| code.getName().endsWith(".f90") || code.getName().endsWith(
					".f95"))
					&& writer.getAnalyzer() instanceof FortranSourceCodeAnalyzer){
				fortranIndexer.indexFileFortran(writer, code);
			}
		}
		else{
		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			Directory d = TraceRecoveryFactory.eINSTANCE.createDirectory();
			d.setPath(f.getAbsolutePath());
			if (f.isDirectory() && !f.isHidden()) {
				indexDir(writer, d, indexDir);
			} else if (f.getName().endsWith(".java")
					&& writer.getAnalyzer() instanceof JavaSourceCodeAnalyzer) {

				javaIndexer.indexFileJava(writer, f);
			} else if ((f.getName().endsWith(".f")
					|| f.getName().endsWith(".for")
					|| f.getName().endsWith(".f90") || f.getName().endsWith(
					".f95"))
					&& writer.getAnalyzer() instanceof FortranSourceCodeAnalyzer) {

				fortranIndexer.indexFileFortran(writer, f);
			}
		}
	}

	}

	// private void indexFile(IndexWriter writer2, File f) {
	// if (!f.exists() || !f.canRead()) {
	// return;
	// }
	//
	// }
	//
	// /**
	// * gets the value of the writer of class.
	// *
	// * @return writer
	// */
	// public IndexWriter getWriter() {
	// return writer;
	// }
	//
	// /**
	// * sets the value of the writer of this index.
	// *
	// * @param writer
	// * the value of the writer used
	// */
	// public void setWriter(IndexWriter writer) {
	// this.writer = writer;
	// }
	//
	// /**
	// * gets tha value of the code directory.
	// *
	// * @return codeDir
	// */
	// public Directory getCodeDir() {
	// return codeDir;
	// }
	//
	// /**
	// * sets the value of the code directory.
	// *
	// * @param codeDir
	// * takes the directory that the code index will be found in.
	// */
	// public void setCodeDir(Directory codeDir) {
	// this.codeDir = codeDir;
	// }
	//
	// /**
	// * returns the value of the directory that the index file will be stored
	// in.
	// *
	// * @return indexDir
	// */
	// public Directory getIndexDir() {
	// return indexDir;
	// }
	//
	// /**
	// * set the value of the directory that the index file should be stored in.
	// *
	// * @param indexDir
	// * the directory that i will need.
	// */
	// public void setIndexDir(Directory indexDir) {
	// this.indexDir = indexDir;
	// }
	//
}
