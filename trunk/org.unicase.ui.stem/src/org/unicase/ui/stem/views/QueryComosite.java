package org.unicase.ui.stem.views;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.model.organization.User;
import org.unicase.ui.stem.views.Query.QueryRangeType;


public class QueryComosite extends Composite {


	private Button rbtnVer;
	private Button rbtnNumOfDays;
	private Button rbtnDate;
	
	private Text txtVerFrom;
	private Text txtVerTo;
	private Text txtNumOfDays;
	
	private CDateTime dtFrom;
	private CDateTime dtTo;
	
	private Button chkIncludeChildren;
	private Button chkIncludeAnnotations;
	
	private ListViewer modelElementsList;
	private ListViewer usersList;
	private ListViewer modelElementTypesList;
	
	private Query query;
	

	public QueryComosite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new GridLayout());
		createExpandItems();
	}

	private void createExpandItems() {
		ExpandBar expandBar = new ExpandBar(this, SWT.V_SCROLL);
		expandBar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			
		createExpandItem(expandBar, "Range", createRangeComposite(expandBar));
		rbtnVer.setSelection(true);
		createExpandItem(expandBar, "Elements", createElementsComposite(expandBar));
		createExpandItem(expandBar, "Users", createUsersComposite(expandBar));
		createExpandItem(expandBar, "Element Types", createElementTypesComposite(expandBar));			
	}
	
	
	private void createExpandItem(ExpandBar expandBar, String title,
								Composite composite) {
		
		ExpandItem eitemRange = new ExpandItem(expandBar, SWT.NONE);
		eitemRange.setText(title);
		eitemRange.setExpanded(false);
		eitemRange.setControl(composite);
		eitemRange.setHeight(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		
		
	}
	
	private Composite createElementTypesComposite(final Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(5, false));
				
		Label lblElementTypes = new Label(composite, SWT.NONE);
		lblElementTypes.setText("Element Types");
		
		Button btnAdd = createButtons(composite);
		
		Button btnRemove = new Button(composite, SWT.PUSH);
		btnRemove.setText("Remove");
		
//		Text txtElementType = new Text(composite, SWT.BORDER);
//		GridData gridData1 = new GridData(SWT.FILL, SWT.CENTER, true, true);
//		txtElementType.setLayoutData(gridData1);
				
		modelElementTypesList = new ListViewer(composite, SWT.V_SCROLL | SWT.BORDER);
		modelElementTypesList.getList().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 5, 1));
				
		btnAdd.addSelectionListener(new SelectionListener(){

			public void widgetDefaultSelected(SelectionEvent e) {
				
				
			}

			public void widgetSelected(SelectionEvent e) {
				EClass[] types = shoeMETypeSelectionDialog();
				modelElementTypesList.add(types);
			}
		});
		
		btnRemove.addSelectionListener(new SelectionListener(){

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				modelElementTypesList.remove(modelElementTypesList.getSelection());
			}
			
		});
		
		
		return composite;
	}
	
	protected EClass[] shoeMETypeSelectionDialog() {
		EClass[] result = null;
		return result;
	}

	private Composite createUsersComposite(Composite parent) {
		
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(5, false));
		
		Label lblUsers = new Label(composite, SWT.NONE);
		lblUsers.setText("Users");
		
		Button btnAdd = createButtons(composite);
		
		Button btnRemove = new Button(composite, SWT.PUSH);
		btnRemove.setText("Remove");
				
		usersList = new ListViewer(composite, SWT.V_SCROLL | SWT.BORDER);
		usersList.getList().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 5, 1));
				
		
		btnAdd.addSelectionListener(new SelectionListener(){

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				User[] users = (User[])showMESelectionDialog("users");
				if(users.length != 0){
					usersList.add(users);
				}
			}
		});
		
		btnRemove.addSelectionListener(new SelectionListener(){

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				usersList.remove(usersList.getSelection());
			}
			
		});
		
		return composite;
		
	}

	private Composite createElementsComposite(Composite parent) {
		
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(5, false));
		
		Label lblElements = new Label(composite, SWT.NONE);
		lblElements.setText("Elements");
		
		Button btnAdd = createButtons(composite);
		
		Button btnRemove = new Button(composite, SWT.PUSH);
		btnRemove.setText("Remove");
				
		chkIncludeChildren = new Button(composite, SWT.CHECK);
		chkIncludeChildren.setText("Include Children");
		
		chkIncludeAnnotations = new Button(composite, SWT.CHECK);
		chkIncludeAnnotations.setText("Include Annotations");
		
		modelElementsList = new ListViewer(composite, SWT.V_SCROLL |SWT.BORDER);
		modelElementsList.getList().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 5, 1));
		
		btnAdd.addSelectionListener(new SelectionListener(){

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				ModelElement[] elements = showMESelectionDialog("elements");
				if(elements.length != 0){
					modelElementsList.add(elements);
				}
			}
		});
		
		btnRemove.addSelectionListener(new SelectionListener(){

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				modelElementsList.remove(modelElementsList.getSelection());
			}
			
		});
		
		return composite;
		
	}

	private Button createButtons(Composite composite) {
		Button btnAdd = new Button(composite, SWT.PUSH);
		GridData gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
		gridData.widthHint = 55;
		gridData.heightHint = SWT.DEFAULT;
		btnAdd.setLayoutData(gridData);
		btnAdd.setText("Add");
		return btnAdd;
	}

	private ModelElement[] showMESelectionDialog(String string) {
		ModelElement[] result = null;
		return result;
	}
	
	private Composite createRangeComposite(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(6, false));
		
		rbtnVer = new Button(composite, SWT.RADIO);
		rbtnVer.setText("Versions");
		Label lblVerFrom = new Label(composite, SWT.NONE);
		lblVerFrom.setText("From:");
		txtVerFrom = new Text(composite, SWT.BORDER);
		Label lblVerTo = new Label(composite, SWT.NONE);
		lblVerTo.setText("To:");
		txtVerTo = new Text(composite, SWT.BORDER);
		Label lblVerTip = new Label(composite, SWT.NONE);
		lblVerTip.setText("Enter a positive integer or any tag like BASE, CURRENT, HEAD, etc.");
		rbtnVer.addSelectionListener(new SelectionListener(){

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				txtVerFrom.setEnabled(rbtnVer.getSelection());
				txtVerTo.setEnabled(rbtnVer.getSelection());
			}
			
		});
		
		rbtnNumOfDays = new Button(composite, SWT.RADIO);
		rbtnNumOfDays.setText("Number of days:");
		Label filler = new Label(composite, SWT.NONE);
		txtNumOfDays = new Text(composite, SWT.BORDER);
		GridData gridData1 = new GridData(SWT.LEFT, SWT.CENTER, true, true, 4, 1);
		txtNumOfDays.setLayoutData(gridData1);
		rbtnNumOfDays.addSelectionListener(new SelectionListener(){

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				txtNumOfDays.setEnabled(rbtnNumOfDays.getSelection());
			}
			
		});
		
		
		rbtnDate = new Button(composite, SWT.RADIO);
		rbtnDate.setText("Date");
		Label lblDateFrom = new Label(composite, SWT.NONE);
		lblDateFrom.setText("From:");
		dtFrom = new CDateTime(composite, CDT.BORDER | CDT.DROP_DOWN| CDT.COMPACT);
		Label lblDateTo = new Label(composite, SWT.NONE);
		lblDateTo.setText("To:");
		dtTo = new  CDateTime(composite, CDT.BORDER | CDT.DROP_DOWN | CDT.COMPACT);
		rbtnDate.addSelectionListener(new SelectionListener(){

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				dtFrom.setEnabled(rbtnDate.getSelection());
				dtTo.setEnabled(rbtnDate.getSelection());
			}
			
		});
		
		return composite;
		
	}
	
	
	
	public Query getQuery(){
		if(query == null){
			query = new Query();
		}
		
		if(rbtnVer.getSelection()){
			query.setQueryRangeType(QueryRangeType.VERSION);
		}else if(rbtnNumOfDays.getSelection()){
			query.setQueryRangeType(QueryRangeType.NUMOFDAYS);
		}else if(rbtnDate.getSelection()){
			query.setQueryRangeType(QueryRangeType.DATE);
		}
		
		query.setStartVersion(Integer.parseInt(txtVerFrom.getText()));
		query.setEndVersion(Integer.parseInt(txtVerTo.getText()));
		query.setNumOfDays(Integer.parseInt(txtNumOfDays.getText()));
		query.setStartDate(dtFrom.getSelection());
		query.setEndDate(dtTo.getSelection());
		List<ModelElement> modelElements = new ArrayList<ModelElement>();
		modelElements.addAll((List<ModelElement>)modelElementsList.getInput());
		if (chkIncludeChildren.getSelection()){
			List<ModelElement> children = new ArrayList<ModelElement>();
			for(ModelElement me : modelElements){
				children.addAll(getChildren(me));
			}
			modelElements.addAll(children);
		}
		if(chkIncludeAnnotations.getSelection()){
			List<Annotation> annotations = new ArrayList<Annotation>();
			for(ModelElement me : modelElements){
				annotations.addAll(getAnnotations(me));
			}
			modelElements.addAll(annotations);
		}
		query.setModelElements(modelElements);
		
		query.setUsers((List<ACUser>) usersList.getInput());
		query.setModelElementTypes((List<EClass>)modelElementTypesList.getInput());
			
		return query;
		
	}

	
	private Collection<? extends Annotation> getAnnotations(ModelElement me) {
		List<Annotation> result = new ArrayList<Annotation>();
		return result;
	}

	
	private Collection<? extends ModelElement> getChildren(ModelElement me) {
		List<ModelElement> result = new ArrayList<ModelElement>();
		return result;
	}

}
