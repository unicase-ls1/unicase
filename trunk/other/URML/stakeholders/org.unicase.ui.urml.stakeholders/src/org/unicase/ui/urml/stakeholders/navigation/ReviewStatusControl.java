package org.unicase.ui.urml.stakeholders.navigation;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.ecp.model.NoWorkspaceException;
import org.unicase.metamodel.Project;
import org.unicase.model.urml.StakeholderRole;
import org.unicase.ui.urml.stakeholders.Activator;
import org.unicase.ui.urml.stakeholders.config.UrmlSettingsManager;
import org.unicase.ui.urml.stakeholders.review.ReviewView;

public class ReviewStatusControl extends Composite{
	
	private Observer countObserver;

	private Link unreviewedRequirements, reviewedRequirements;

	private ReviewCountPublisher countPublisher;

	private Table table;

	private String[] titles = {"Type","Reviewed","Total","%"};

	private Observer roleChangeObserver;

	public ReviewStatusControl(Composite parent, int style) {
		super(parent, style);
		countPublisher = UrmlSettingsManager.INSTANCE.getReviewCountpublisher();
		countPublisher.addObserver(
				countObserver = new Observer() {
			@Override
			public void update(Observable o, Object arg) {
				updateStatus();
			}
		});
		Activator.getRoleChangedPublisher().addObserver(countObserver);
		
		setLayout(new FillLayout());
		
		table = new Table(this, SWT.NONE);
		
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		
		for (int i=0; i<titles.length; i++) {
			TableColumn column = new TableColumn (table, SWT.NONE);
			column.setText (titles [i]);
		}
	
		
		updateStatus();
	}

	private void updateStatus() {
		
		StakeholderRole role = UrmlSettingsManager.INSTANCE.getActiveRole();
		table.removeAll();
		
		int rev;
		int total;
		TableItem it;
		if(role != null){
			for(EClass c : role.getReviewSet().keySet()){
				if(c == null) continue;
				it = new TableItem(table, SWT.NONE);
				it.setText(0,c.getName());
				rev = countPublisher.getReviewCount(c);
				total = countPublisher.getTotalCount(c);
				it.setText(1,"" + rev);
				it.setText(2,"" + total);
				it.setText(3,(int)(rev*100./total) + "%");
			}
		}
		
		it = new TableItem(table, SWT.NONE);
		it.setText(0,"All");
		rev = countPublisher.getReviewCount();
		total = countPublisher.getTotalCount();
		it.setText(1,"" + rev);
		it.setText(2,"" + total);
		it.setText(3,(int)(rev*100./total) + "%");
		
		
		for (int i=0; i<titles.length; i++) {
			table.getColumn(i).pack();
		}	
	}
	
	
	@Override
	public void dispose() {
		super.dispose();
		countPublisher.deleteObserver(countObserver);
		Activator.getRoleChangedPublisher().deleteObserver(countObserver);
	}
	
//
//	private Link reviewedRequirementSetup(Composite parent, Project project, final boolean selectReviewed,
//		String linkText, StakeholderRole activeRole) throws NoWorkspaceException {
//		link = new Link(parent, SWT.WRAP);
//		GridData data = new GridData(SWT.FILL, SWT.BEGINNING, false, false);
//		// data.widthHint = 300;
//		link.setLayoutData(data);
//		//+ Activator.getTracker().getReviewedElements(selectReviewed)
//		link.setText("<a>" + linkText + "</a> ");
//
//		link.addSelectionListener(new SelectionAdapter() {
//			public void widgetSelected(SelectionEvent e) {
//				page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
//
//				try {
//					ReviewView reviewView = (ReviewView) page.showView(STATUS_VIEW_ID, null,
//						IWorkbenchPage.VIEW_ACTIVATE);
//					reviewView.showOnlyReviewedElements(selectReviewed);
//				} catch (PartInitException e1) {
//					e1.printStackTrace();
//				}
//			}
//		});
//		return link;
//	}
//	

}
