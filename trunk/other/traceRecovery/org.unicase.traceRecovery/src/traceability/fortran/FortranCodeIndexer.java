/**
 * 
 */
package traceability.fortran;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.eclipse.photran.internal.core.analysis.binding.ScopingNode;

import traceRecovery.handler.Indexer;

/**
 * @author liya
 * 
 */
public class FortranCodeIndexer extends Indexer {

	public FortranCodeIndexer() {
		super();

	}

	// private static final String PROGRAM = "PROGRAM";
	// private static final String MODULE = "MODULE";
	// private static final String INTERFACE = "INTERFACE";
	// private static final String SUBROUTINE = "SUBROUTINE";
	// private static final String CODE = "code";
	private static final String COMMENT = "comment";

	// private static final String FUNCTION = "FUNCTION";
	// private static final String PARAMETER = "parameter";
	// private static final String DATA = "DATA";

	// public static void main(String[] args) {
	//
	// try {
	// File indexDir = new File("lucene-index");
	// File dataDir = new File("code");
	// IndexWriter writer = new IndexWriter(indexDir,
	// new JavaSourceCodeAnalyzer(), true);
	// indexDirectory(writer, dataDir);
	// int numFiles = writer.docCount();
	// writer.close();
	// System.out.println("Indexing " + numFiles);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	// public static void indexDirectory(IndexWriter writer, File dir)
	// throws IOException {
	// File[] files = dir.listFiles();
	// for (int i = 0; i < files.length; i++) {
	// File f = files[i];
	// if (f.isDirectory())
	// indexDirectory(writer, f);
	// else if (f.getName().endsWith(".f90"))
	// indexFileFortran(writer, f);
	// }
	// }

	public void indexFileFortran(IndexWriter writer, File f) {
		if (f.isHidden() || !f.exists() || !f.canRead())
			return;
		Document doc = new Document();
		FortranSourceCodeParser parser = new FortranSourceCodeParser(f);
		// parser.getSubroutines();
		addSubroutines(doc, parser);
		addComments(doc, parser);
		// addModules(doc, parser);
		// addInterfaces(doc, parser);

		// addFunctions(doc,parser);
		// addData(doc,parser);
		// addComments(doc, parser);
		Field fileName = new Field("filename", f.getName(), Field.Store.YES,
				Field.Index.NO);
		Field path = new Field("path", f.getPath(), Field.Store.YES,
				Field.Index.NO);
		doc.add(fileName);
		doc.add(path);
		try {
			writer.addDocument(doc);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void addSubroutines(Document doc,
			FortranSourceCodeParser parser) {
		ArrayList<ScopingNode> subroutines = parser.getSubroutines();
		if (subroutines == null)
			return;
		for (int i = 0; i < subroutines.size(); i++) {
			String docSubroutine = subroutines.get(i).getName(true);

			Field subRoutine = new Field("class", docSubroutine,
					Field.Store.YES, Field.Index.TOKENIZED);

			doc.add(subRoutine);
		}

	}

	private static void addComments(Document doc, FortranSourceCodeParser parser) {
		ArrayList<String> comments = parser.getComments();
		if (comments == null)
			return;
		for (int i = 0; i < comments.size(); i++) {
			Field com = new Field(COMMENT, comments.get(i), Field.Store.YES,
					Field.Index.TOKENIZED);
			doc.add(com);
		}
	}

}
