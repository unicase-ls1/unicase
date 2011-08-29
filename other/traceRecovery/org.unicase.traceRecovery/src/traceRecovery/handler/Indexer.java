/**
 * 
 */
package traceRecovery.handler;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.unicase.model.UnicaseModelElement;

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

//		File index = new File(this.indexDir.getPath());
		File code = new File(this.codeDir.getPath());

		File[] files = code.listFiles();
//		JavaSourceCodeIndexer javaIndexer = new JavaSourceCodeIndexer();
		FortranCodeIndexer fortranIndexer = new FortranCodeIndexer();

		if (files == null && code != null) {
			if (code.getName().endsWith(".java")
					&& writer.getAnalyzer() instanceof JavaSourceCodeAnalyzer) {
				JavaSourceCodeIndexer.indexFileJava(writer, code);
			} else if ((code.getName().endsWith(".f")
					|| code.getName().endsWith(".for")
					|| code.getName().endsWith(".f90") || code.getName()
					.endsWith(".f95"))
					&& writer.getAnalyzer() instanceof FortranSourceCodeAnalyzer) {
				fortranIndexer.indexFileFortran(writer, code);
			}
		} else {
			for (int i = 0; i < files.length; i++) {
				File f = files[i];
				Directory d = TraceRecoveryFactory.eINSTANCE.createDirectory();
				d.setPath(f.getAbsolutePath());
				if (f.isDirectory() && !f.isHidden()) {
					indexDir(writer, d, indexDir);
				} else if (f.getName().endsWith(".java")
						&& writer.getAnalyzer() instanceof JavaSourceCodeAnalyzer) {

					JavaSourceCodeIndexer.indexFileJava(writer, f);
				} else if ((f.getName().endsWith(".f")
						|| f.getName().endsWith(".for")
						|| f.getName().endsWith(".f90") || f.getName()
						.endsWith(".f95"))
						&& writer.getAnalyzer() instanceof FortranSourceCodeAnalyzer) {

					fortranIndexer.indexFileFortran(writer, f);
				}
			}
		}

	}

	/**
	 * index a certain given directory
	 * @param writer
	 * @param codeDir
	 * @param indexDir
	 * @param javIndexer
	 * @param fortIndexer
	 * @throws IOException
	 */
	public void indexDir(IndexWriter writer, Directory codeDir,
			Directory indexDir, JavaSourceCodeIndexer javIndexer,
			FortranCodeIndexer fortIndexer) throws IOException {
		this.writer = writer;
		this.codeDir = codeDir;
		this.indexDir = indexDir;

//		File index = new File(this.indexDir.getPath());
		File code = new File(this.codeDir.getPath());

		File[] files = code.listFiles();
//		JavaSourceCodeIndexer javaIndexer = javIndexer;
		FortranCodeIndexer fortranIndexer = fortIndexer;

		if (files == null && code != null) {
			if (code.getName().endsWith(".java")
					&& writer.getAnalyzer() instanceof JavaSourceCodeAnalyzer) {
				JavaSourceCodeIndexer.indexFileJava(writer, code);
			} else if ((code.getName().endsWith(".f")
					|| code.getName().endsWith(".for")
					|| code.getName().endsWith(".f90") || code.getName()
					.endsWith(".f95"))
					&& writer.getAnalyzer() instanceof FortranSourceCodeAnalyzer) {
				fortranIndexer.indexFileFortran(writer, code);
			}
		} else {
			for (int i = 0; i < files.length; i++) {
				File f = files[i];
				Directory d = TraceRecoveryFactory.eINSTANCE.createDirectory();
				d.setPath(f.getAbsolutePath());
				if (f.isDirectory() && !f.isHidden()) {
					indexDir(writer, d, indexDir);
				} else if (f.getName().endsWith(".java")
						&& writer.getAnalyzer() instanceof JavaSourceCodeAnalyzer) {

					JavaSourceCodeIndexer.indexFileJava(writer, f);
				} else if ((f.getName().endsWith(".f")
						|| f.getName().endsWith(".for")
						|| f.getName().endsWith(".f90") || f.getName()
						.endsWith(".f95"))
						&& writer.getAnalyzer() instanceof FortranSourceCodeAnalyzer) {

					fortranIndexer.indexFileFortran(writer, f);
				}
			}
		}

	}

	// public void MEIndexer(Query query, Directory dir) {
	// try {
	// for (int j = 0; j < query.getModelElements().size(); j++) {
	// IndexWriter index = new IndexWriter(dir.getPath(),
	// new StandardAnalyzer(), true);
	// IndexME(query.getModelElements().get(j), index);
	//
	// }
	//
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }

	/**
	 * indexes model elements
	 * @param me 
	 * 			this is the model element that will be indexed
	 * @param writer
	 * 			this is the writer that will be used to index the model element
	 */
	public void IndexME(UnicaseModelElement me, IndexWriter writer) {
		this.writer = writer;
		Document doc = new Document();
		if (me.getDescription() != null) {
			Field field = new Field("text", me.getDescription(),
					Field.Store.YES, Field.Index.TOKENIZED);
			doc.add(field);
		}

		if (me.getName() != null) {

			
			
			Field id = new Field("id", me.getModelElementId().getId(),
					Field.Store.YES, Field.Index.NO);

			Field name = new Field("name", me.getName(), Field.Store.YES,
					Field.Index.NO);
			doc.add(name);
			doc.add(id);
			
			
		}
		
		try {
			this.writer.addDocument(doc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}