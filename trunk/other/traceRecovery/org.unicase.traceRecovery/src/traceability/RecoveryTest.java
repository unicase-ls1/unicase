package traceability;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;

import traceRecovery.Directory;
import traceRecovery.Link;
import traceRecovery.Query;
import traceRecovery.TraceRecoveryFactory;
import traceability.handler.Search;

public class RecoveryTest {
	Search search;
	Query query;
	Directory dir;
	
	
	@Before
	public void startIndex() throws IOException{
		search = new Search();
		
		Directory codeDir = TraceRecoveryFactory.eINSTANCE.createDirectory();
		Directory indexDir = TraceRecoveryFactory.eINSTANCE.createDirectory();
		
		codeDir.setPath("code");
		indexDir.setPath("lucene-index");
		search.setIndexer("java", codeDir, indexDir);
		
		search.setAnalyzer("java");
		search.index();
		
		System.out.println(search.getIndex().getWriter().docCount());
		search.getIndex().getWriter().close();
	}
//	
	@Test
	public void testRecovery() {
		try{
			
		//search = new Search();
		//search.setAnalyzer("java");
		query = TraceRecoveryFactory.eINSTANCE.createQuery();

		ActionItem action = TaskFactory.eINSTANCE.createActionItem();
		action.setDescription("string");
		query.getModelElements().add(action);

		dir = TraceRecoveryFactory.eINSTANCE.createDirectory();
		dir.setPath("lucene-index");
		ArrayList <Link> link = search.runRecoveryMEToCode(query, dir);
//		System.out.println(link);
//		assertEquals(link.size(), 3);
		
//		assertEquals(link.get(0).getSource(), query.getModelElement().get(0));
		
		ActionItem action1 = TaskFactory.eINSTANCE.createActionItem();
		action1.setDescription("System");
		query.getModelElements().add(action1);
		query.getModelElements().add(action);
		
		link = search.runRecoveryMEToCode(query, dir);
		
		
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
