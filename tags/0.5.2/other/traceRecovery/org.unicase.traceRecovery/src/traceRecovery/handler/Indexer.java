/**
 * 
 */
package traceRecovery.handler;

import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.unicase.model.UnicaseModelElement;

import traceRecovery.Directory;

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
			Directory indexDir)  {

	}

	

	

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