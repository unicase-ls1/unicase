/**
 * 
 */
package traceRecovery.Java;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;

import traceRecovery.Directory;
import traceRecovery.TraceRecoveryFactory;
import traceRecovery.Java.JavaParser.JClass;
import traceRecovery.Java.JavaParser.JMethod;
import traceRecovery.handler.Indexer;

/**
 * @author taher will index the java code
 */
public class JavaSourceCodeIndexer extends Indexer {
	public JavaSourceCodeIndexer() {
		super();

	}

	// private static final String IMPLEMENTS = "implements";
	// private static final String IMPORT = "import";
	private static final String CLASS = "class";
	private static final String METHOD = "method";
	// private static final String CODE = "code";
	private static final String COMMENT = "comment";

	// private static final String PARAMETER = "parameter";
	// private static final String EXTENDS = "extends";

	/**
	 * this will index a certain directory
	 * 
	 * @param writer
	 *            the writer that will write to the index file
	 * @param directory
	 *            the directory that will be indexed
	 * @throws IOException
	 */
	public static void indexDirectory(IndexWriter writer, Directory directory)
			throws IOException {
		File dir = new File(directory.getPath());
		File[] files = dir.listFiles();

		if (files == null && dir != null) {

			if (dir.getName().endsWith(".java")) {
				indexFileJava(writer, dir);
			}

		} else {

			for (int i = 0; i < files.length; i++) {
				File f = files[i];
				Directory d = TraceRecoveryFactory.eINSTANCE.createDirectory();
				d.setPath(f.getAbsolutePath());
				if (f.isDirectory())
					indexDirectory(writer, d);
				else if (f.getName().endsWith(".java"))
					indexFileJava(writer, f);

			}
		}
	}

	/**
	 * get the certain fileds of the file and index them
	 * 
	 * @param writer
	 *            the writer that will write to the index file
	 * @param f
	 *            the file that should be indexed and data retrieved from
	 */
	public static void indexFileJava(IndexWriter writer, File f) {
		if (f.isHidden() || !f.exists() || !f.canRead())
			return;
		Document doc = new Document();
		JavaParser parser = new JavaParser();
		parser.setSource(f);
		// addImportDeclarations(doc, parser);

		JClass cls = parser.getDeclaredClass();
		if (cls != null) {
			addComments(doc, parser);
			addClass(doc, cls);

			Field name = new Field("filename", f.getName(), Field.Store.YES,
					Field.Index.NO);
			Field path = new Field("path", f.getAbsolutePath(),
					Field.Store.YES, Field.Index.NO);
			doc.add(name);
			doc.add(path);

			try {
				writer.addDocument(doc);
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * add the comments to the document
	 * 
	 * @param doc
	 *            the document to add to
	 * @param parser
	 *            java parser to get the comments
	 */
	private static void addComments(Document doc, JavaParser parser) {
		ArrayList<String> comments = parser.getComments();
		// JavaSourceCodeAnalyzer analyzer = new JavaSourceCodeAnalyzer();
		if (comments == null)
			return;
		for (int i = 0; i < comments.size(); i++) {
			// StringReader reader = new StringReader(comments.get(i));
			// TokenStream comm = analyzer.tokenStream(CLASS, reader);

			String docComment = comments.get(i);
			Field comment = new Field(COMMENT, docComment, Field.Store.YES,
					Field.Index.TOKENIZED);
			doc.add(comment);
		}
	}

	/**
	 * add the class to the document
	 * 
	 * @param doc
	 *            the document to add to
	 * @param cls
	 *            the class
	 */
	private static void addClass(Document doc, JClass cls) {
		if (cls != null) {
			Field cl = new Field(CLASS, cls.className, Field.Store.YES,
					Field.Index.TOKENIZED);
			doc.add(cl);

			addMethods(cls, doc);
			ArrayList<JClass> innerCls = cls.innerClasses;
			for (int i = 0; i < innerCls.size(); i++) {
				addClass(doc, innerCls.get(i));
			}
		}
	}

	/**
	 * add the methods to the document
	 * 
	 * @param cls
	 *            the class
	 * @param doc
	 *            the document to add to
	 */
	private static void addMethods(JClass cls, Document doc) {
		ArrayList<JMethod> methods = cls.methodDeclarations;
		for (int i = 0; i < methods.size(); i++) {
			JMethod method = methods.get(i);
			Field meth = new Field(METHOD, method.methodName, Field.Store.YES,
					Field.Index.TOKENIZED);
			doc.add(meth);

		}
	}

}
