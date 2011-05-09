///**
// * 
// */
//package traceability.java;
//
//import java.awt.Desktop.Action;
//import java.io.File;
//import java.io.IOException;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Collection;
//import java.util.Iterator;
//
//import org.apache.lucene.analysis.PerFieldAnalyzerWrapper;
//import org.apache.lucene.document.Document;
//import org.apache.lucene.document.Field.TermVector;
//import org.apache.lucene.index.TermVectorOffsetInfo;
//import org.apache.lucene.queryParser.QueryParser;
//import org.apache.lucene.search.Hits;
//import org.apache.lucene.search.IndexSearcher;
////import org.apache.lucene.search.*;
//import org.apache.lucene.store.Directory;
//import org.apache.lucene.store.FSDirectory;
//import org.eclipse.emf.common.util.EList;
//import org.unicase.model.UnicaseModelElement;
//import org.unicase.model.task.ActionItem;
//import org.unicase.model.task.impl.TaskFactoryImpl;
//import org.unicase.model.trace.CodeLocation;
//import org.unicase.model.trace.impl.*;
//
//import traceRecovery.impl.QueryImpl;
//import traceRecovery.impl.TraceRecoveryFactoryImpl;
//import traceRecovery.Link;
//import traceRecovery.Query;
//
///**
// * @author liya
// * 
// */
//public class JavaCodeSearch {
//
//	
//	public static QueryImpl createQuery(Query q,String [] textToSearch){
//		
//		TaskFactoryImpl taskFactory = new TaskFactoryImpl();
//		
//		EList<UnicaseModelElement> list = q.getModelElement();
//		
//		list.clear();
//		
//		QueryImpl query = (QueryImpl)q;
//		
//		for(int i = 0;i < textToSearch.length;i++){
//			ActionItem action = taskFactory.createActionItem();
//			action.setDescription(textToSearch[i]);
//			action.setName("query number "+ i);
//			list.add(action);
//		}
//		
//		//query.eSet(11, list);
//		
//		return query;
//	}
//	
//	/**
//	 * @param args
//	 *            main method that will run the code.
//	 */
////	public static void main(String[] args) {
////		try {
////
////			TraceRecoveryFactoryImpl traceFactory = new TraceRecoveryFactoryImpl();
////			TraceFactoryImpl codeFactory = new TraceFactoryImpl();
////
////			Query query1 = traceFactory.createQuery();
////			
////			
////			
////			
////			String [] text = {"method:main"};
////			
////			createQuery(query1, text);
////						
////			String q = "method:main";
////			
////			
////
////			File indexDir = new File("lucene-index");
////
////			PerFieldAnalyzerWrapper analyzer = new PerFieldAnalyzerWrapper(
////					new JavaSourceCodeAnalyzer());
////			analyzer.addAnalyzer("import", new KeywordAnalyzer());
////			Directory fsDir;
////			fsDir = FSDirectory.getDirectory(indexDir, false);
////			IndexSearcher is = new IndexSearcher(fsDir);
////			QueryParser parser = new QueryParser("code", analyzer);
////			
////			org.apache.lucene.search.Query [] query = new org.apache.lucene.search.Query [query1.getModelElement().size()] ; 
////			
////			Hits [] hits = new Hits [query1.getModelElement().size()]; 
////			
////			for(int i =0;i<query1.getModelElement().size();i++){
////				query[i]= parser.parse(query1.getModelElement().get(i).getDescription());
////				
////				hits[i]  = is.search(query[i]);
////			}
////			
////			long start = System.currentTimeMillis();
////
////			//Hits hits = is.search(query);
////			long end = System.currentTimeMillis();
////
////			for(int i=0;i<hits.length;i++){
////			System.err.println("Found "+i+" " + hits[i].length() + " docs in "
////					+ (end - start) + " millisec");
////			}
////			CodeLocation codeSource = codeFactory.createCodeLocation();
////			
////			
////			
////			
////			
////						
////			for (int i = 0;i<hits.length; i++) {
////				
////				for(int j=0;j<hits[i].length();j++)
////				{
////				
////				Document doc = hits[i].doc(j);
////
////				Link link = traceFactory.createLink();
////				link.setConfidence(hits[i].score(i));
////
////				link.setDescription("link between source code and requirement document");
////				
////				CodeLocation codeTarget = codeFactory.createCodeLocation();
////				
////				Calendar cal = Calendar.getInstance();
////				
////				
////				codeTarget.setCreationDate(cal.getTime());
////				codeTarget.setCreator("JavaCodeSearch");
////				
////				
////				
////				link.setTarget(codeTarget);
////				link.setSource(codeSource);
////				
////				System.out.println(doc.get("filename") + " this is the value of i = " + i + " with a score of "
////						+ hits[i].score(i));
////			}
////				}
////			is.close();
////
////		} catch (org.apache.lucene.queryParser.ParseException e) {
////			e.printStackTrace();
////		}
////
////		catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////
////	}
//}
