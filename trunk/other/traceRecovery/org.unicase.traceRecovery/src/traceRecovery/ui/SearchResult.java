/**
 * 
 */
package traceRecovery.ui;



import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.task.WorkItem;

import traceRecovery.Directory;
import traceRecovery.Link;
import traceRecovery.Query;
import traceRecovery.TraceRecoveryFactory;
import traceability.handler.Search;

/**
 * @author taher
 *
 */
public class SearchResult implements SelectionListener,Listener{
	Display display;
	Shell shell;
	TableCursor cursor;
	Table table;
	public void run(RunRecovery recovery){
		try{
			recovery.shell.dispose();
		display = Display.getCurrent();
		Query query = TraceRecoveryFactory.eINSTANCE.createQuery(); 
		UnicaseModelElement me = (UnicaseModelElement) recovery.e.get(0);
		System.out.println(me + " law nulllllllllllllll yekon moshkela :D");
		query.getModelElements().add((UnicaseModelElement)recovery.e.get(0));
//		
		Directory dir = TraceRecoveryFactory.eINSTANCE.createDirectory();
		dir.setPath("lucene-index");
//		
		ArrayList <Link> link = recovery.recovery.runRecoveryMEToCode(query, dir);
//		
		
		
		shell = new Shell(display);
		shell.setLayout(new GridLayout(3, false));
		
		table = new Table(shell, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.heightHint = 200;
		table.setLayoutData(data);		
		TableColumn source = new TableColumn(table, SWT.V_SCROLL | SWT.H_SCROLL);
		
		TableColumn target = new TableColumn(table, SWT.V_SCROLL | SWT.H_SCROLL);
		TableColumn score = new TableColumn(table, SWT.V_SCROLL | SWT.H_SCROLL);
		TableColumn linkType = new TableColumn(table, SWT.V_SCROLL | SWT.H_SCROLL);
		
		source.setText("Source");
		target.setText("Target");
		score.setText("Score");
		linkType.setText("Link Type");
		
		
		for(int i=0; i< link.size();i++){
			TableItem item = new TableItem(table, SWT.NONE);
			Link result = link.get(i);
			String [] text = new String[4];
			text [0] = result.getSource().getName();
			text [1] = result.getTarget().getName();
			text [2] = result.getConfidence() + "";
			text [3] = result.getType();
			
			item.setText(text);
			
		}
		
		cursor = new TableCursor(table, SWT.NONE);
		cursor.addListener(SWT.Selection, this);
		
		
//		TableItem item = new TableItem(table, SWT.NONE);
//		
//		Link result = link.get(0);
//		
//		String [] text = new String [4];
//		text [0] = result.getSource().getName();
//		text [1] = result.getTarget().getName();
//		text [2] = result.getConfidence() + "";
//		text [3] = result.getType();
//		
//		System.out.println(text[1] + " kalam keter keda kan lazem yet2l lama ne3mel keda");
//		
//		item.setText(text);
//		TableItem item2 = new TableItem(table, SWT.NONE);
//		item2.setText("bardo kalam fare3'");
		
		
		for(int i=0;i<table.getColumnCount();i++){
			table.getColumn(i).pack();
		}
		
		
		shell.open();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent(Event event) {
		if(event.widget == cursor){
			int col = cursor.getColumn();
			System.out.println(table.getSelectionIndex());
		}
		
		
	}

}
