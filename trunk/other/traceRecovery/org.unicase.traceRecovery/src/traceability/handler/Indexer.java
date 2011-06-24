/**
 * 
 */
package traceability.handler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.unicase.model.Attachment;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.activity.ActivityObject;
import org.unicase.model.bug.BugReport;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.Attribute;
import org.unicase.model.classes.Dependency;
import org.unicase.model.classes.Literal;
import org.unicase.model.classes.Method;
import org.unicase.model.classes.MethodArgument;
import org.unicase.model.classes.PackageElement;
import org.unicase.model.component.Component;
import org.unicase.model.component.ComponentService;
import org.unicase.model.component.DeploymentNode;
import org.unicase.model.document.Section;
import org.unicase.model.meeting.Meeting;
import org.unicase.model.meeting.MeetingSection;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.profile.Profile;
import org.unicase.model.profile.Stereotype;
import org.unicase.model.profile.StereotypeAttribute;
import org.unicase.model.profile.StereotypeAttributeInstance;
import org.unicase.model.profile.StereotypeInstance;
import org.unicase.model.rationale.Assessment;
import org.unicase.model.rationale.Comment;
import org.unicase.model.rationale.Criterion;
import org.unicase.model.rationale.Proposal;
import org.unicase.model.rationale.Solution;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.ActorInstance;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.Scenario;
import org.unicase.model.requirement.Step;
import org.unicase.model.requirement.SystemFunction;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.requirement.UserTask;
import org.unicase.model.state.StateNode;
import org.unicase.model.state.Transition;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.WorkItem;
import org.unicase.workspace.Workspace;

import traceRecovery.Directory;
import traceRecovery.Query;
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

					javaIndexer.indexFileJava(writer, f);
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

	public void indexDir(IndexWriter writer, Directory codeDir,
			Directory indexDir, JavaSourceCodeIndexer javIndexer,
			FortranCodeIndexer fortIndexer) throws IOException {
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

					javaIndexer.indexFileJava(writer, f);
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

	public void MEIndexer(Query query, Directory dir) {
		try {
			for (int j = 0; j < query.getModelElements().size(); j++) {
				IndexWriter index = new IndexWriter(dir.getPath(),
						new StandardAnalyzer(), true);
				IndexME(query.getModelElements().get(j), index);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void IndexME(UnicaseModelElement me, IndexWriter writer) {
		Document doc = new Document();
		Field field = new Field("text", me.getDescription(), Field.Store.YES,
				Field.Index.TOKENIZED);
		doc.add(field);
		Field name = new Field("name", me.getName(), Field.Store.YES,
				Field.Index.NO);
		doc.add(name);
		Field type = null;
		if (me instanceof OrgUnit) {
			type = new Field("type", "orgunit", Field.Store.YES, Field.Index.NO);
		} else if (me instanceof BugReport) {
			type = new Field("type", "bugreport", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof WorkItem) {
			type = new Field("type", "workitem", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof Checkable) {
			type = new Field("type", "checkable", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof PackageElement) {
			type = new Field("type", "packageelement", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof Association) {
			type = new Field("type", "association", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof Attribute) {
			type = new Field("type", "attribute", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof Method) {
			type = new Field("type", "method", Field.Store.YES, Field.Index.NO);
		} else if (me instanceof MethodArgument) {
			type = new Field("type", "methodargument", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof Dependency) {
			type = new Field("type", "dependency", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof Literal) {
			type = new Field("type", "literal", Field.Store.YES, Field.Index.NO);
		} else if (me instanceof Section) {
			type = new Field("type", "section", Field.Store.YES, Field.Index.NO);
		} else if (me instanceof FunctionalRequirement) {
			type = new Field("type", "functionalrequirement", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof UseCase) {
			type = new Field("type", "usecase", Field.Store.YES, Field.Index.NO);
		} else if (me instanceof Scenario) {
			type = new Field("type", "scenario", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof Actor) {
			type = new Field("type", "actor", Field.Store.YES, Field.Index.NO);
		} else if (me instanceof ActorInstance) {
			type = new Field("type", "actorinstance", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof Step) {
			type = new Field("type", "step", Field.Store.YES, Field.Index.NO);
		} else if (me instanceof SystemFunction) {
			type = new Field("type", "systemfunction", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof UserTask) {
			type = new Field("type", "usertask", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof Workspace) {
			type = new Field("type", "workspace", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof Proposal) {
			type = new Field("type", "propsal", Field.Store.YES, Field.Index.NO);
		} else if (me instanceof Solution) {
			type = new Field("type", "solution", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof Criterion) {
			type = new Field("type", "criterion", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof Assessment) {
			type = new Field("type", "assessment", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof Comment) {
			type = new Field("type", "comment", Field.Store.YES, Field.Index.NO);
		} else if (me instanceof Component) {
			type = new Field("type", "component", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof ComponentService) {
			type = new Field("type", "componentservice", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof DeploymentNode) {
			type = new Field("type", "deploymentnode", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof Meeting) {
			type = new Field("type", "meeting", Field.Store.YES, Field.Index.NO);
		} else if (me instanceof MeetingSection) {
			type = new Field("type", "meetingsection", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof Transition) {
			type = new Field("type", "transiton", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof StateNode) {
			type = new Field("type", "statenode", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof Attachment) {
			type = new Field("type", "attatchment", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof Profile) {
			type = new Field("type", "profile", Field.Store.YES, Field.Index.NO);
		} else if (me instanceof Stereotype) {
			type = new Field("type", "stereotype", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof StereotypeInstance) {
			type = new Field("type", "sterotypeinstance", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof StereotypeAttribute) {
			type = new Field("type", "stereotypeattribute", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof StereotypeAttributeInstance) {
			type = new Field("type", "stereotypeattirbuteinstance",
					Field.Store.YES, Field.Index.NO);
		} else if (me instanceof ActivityObject) {
			type = new Field("type", "activityobject", Field.Store.YES,
					Field.Index.NO);
		} else if (me instanceof org.unicase.model.activity.Transition) {
			type = new Field("type", "transition activity", Field.Store.YES,
					Field.Index.NO);
		}
		if(type != null){
			doc.add(type);
		}
		try {
			writer.addDocument(doc);
		} catch (IOException e) {
			e.printStackTrace();
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
