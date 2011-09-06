/**
 * 
 */
package traceRecovery.Fortran;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.eclipse.photran.internal.core.analysis.binding.ScopingNode;

import traceRecovery.Directory;
import traceRecovery.TraceRecoveryFactory;
import traceRecovery.handler.Indexer;

/**
 * @author liya
 * 
 */
public class FortranCodeIndexer extends Indexer {

	public FortranCodeIndexer() {
		super();

	}

	private static final String COMMENT = "comment";

	/**
	 * this method will index a single directory
	 * 
	 * @param writer
	 *            the writer that will write in the index file
	 * @param dir
	 *            this is the directory that needs to be indexed
	 */
	public static void indexDir(IndexWriter writer, Directory dir) {
		File file = new File(dir.getPath());
		File[] files = file.listFiles();

		if (files == null && file != null) {
			if(file.getName().endsWith("f") || file.getName().endsWith("f90") || file.getName().endsWith("for")){
				indexFileFortran(writer, file);
			}
			
		} else {

			for (int i = 0; i < files.length; i++) {
				Directory directory = TraceRecoveryFactory.eINSTANCE
						.createDirectory();
				directory.setPath(files[i].getPath());
				if (files[i].isDirectory()) {
					indexDir(writer, directory);
				} else if (files[i].getName().endsWith(".f")
						|| files[i].getName().endsWith(".f90")
						|| files[i].getName().endsWith(".for")) {
					indexFileFortran(writer, files[i]);
				}

			}
		}
	}

	public static void indexFileFortran(IndexWriter writer, File f) {
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
