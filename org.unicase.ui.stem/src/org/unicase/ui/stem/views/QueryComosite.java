package org.unicase.ui.stem.views;



import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


public class QueryComosite extends Composite {


	public QueryComosite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new GridLayout());
		createSections();
	}

	private void createSections() {
		ExpandBar expandBar = new ExpandBar(this, SWT.V_SCROLL);
		expandBar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			
		createExpandItem(expandBar, "Range", createRangeComposite(expandBar));
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
	
	private Composite createElementTypesComposite(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(5, false));
				
		Label lblUsers = new Label(composite, SWT.NONE);
		lblUsers.setText("Element Types");
		
		Button btnAdd = new Button(composite, SWT.PUSH);
		GridData gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
		gridData.widthHint = 55;
		gridData.heightHint = SWT.DEFAULT;
		btnAdd.setLayoutData(gridData);
		btnAdd.setText("Add");
		
		Button btnRemove = new Button(composite, SWT.PUSH);
		btnRemove.setText("Remove");
		
		Text txtElementType = new Text(composite, SWT.BORDER);
		GridData gridData1 = new GridData(SWT.FILL, SWT.CENTER, true, true);
		txtElementType.setLayoutData(gridData1);
				
		ListViewer list = new ListViewer(composite, SWT.V_SCROLL | SWT.BORDER);
		list.getList().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 5, 1));
				
		return composite;
	}
	
	private Composite createUsersComposite(Composite parent) {
		
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(5, false));
		
		
		Label lblUsers = new Label(composite, SWT.NONE);
		lblUsers.setText("Users");
		
		Button btnAdd = new Button(composite, SWT.PUSH);
		GridData gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
		gridData.widthHint = 55;
		gridData.heightHint = SWT.DEFAULT;
		btnAdd.setLayoutData(gridData);
		btnAdd.setText("Add");
		
		Button btnRemove = new Button(composite, SWT.PUSH);
		btnRemove.setText("Remove");
				
		ListViewer list = new ListViewer(composite, SWT.V_SCROLL | SWT.BORDER);
		list.getList().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 5, 1));
				
		return composite;
		
	}

	private Composite createElementsComposite(Composite parent) {
		
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(5, false));
		
		Label lblElements = new Label(composite, SWT.NONE);
		lblElements.setText("Elements");
		
		Button btnAdd = new Button(composite, SWT.PUSH);
		GridData gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
		gridData.widthHint = 55;
		gridData.heightHint = SWT.DEFAULT;
		btnAdd.setLayoutData(gridData);
		btnAdd.setText("Add");
		
		Button btnRemove = new Button(composite, SWT.PUSH);
		btnRemove.setText("Remove");
				
		Button btnIncludeChildren = new Button(composite, SWT.CHECK);
		btnIncludeChildren.setText("Include Children");
		
		Button btnIncludeAnnotations = new Button(composite, SWT.CHECK);
		btnIncludeAnnotations.setText("Include Annotations");
		
		ListViewer list = new ListViewer(composite, SWT.V_SCROLL |SWT.BORDER);
		list.getList().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 5, 1));
		
		return composite;
		
	}

	private Composite createRangeComposite(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(6, false));
		
		Button btnVer = new Button(composite, SWT.RADIO);
		btnVer.setText("Versions");
		Label lblVerFrom = new Label(composite, SWT.NONE);
		lblVerFrom.setText("From:");
		Text txtVerFrom = new Text(composite, SWT.BORDER);
		Label lblVerTo = new Label(composite, SWT.NONE);
		lblVerTo.setText("To:");
		Text txtVerTo	= new Text(composite, SWT.BORDER);
		Label lblVerTip = new Label(composite, SWT.NONE);
		lblVerTip.setText("Enter a positive integer or any tag like BASE, CURRENT, HEAD, etc.");
		
		Button btnNumOfDays = new Button(composite, SWT.RADIO);
		btnNumOfDays.setText("Number of days:");
		Label filler = new Label(composite, SWT.NONE);
		Text txtNumOfDays = new Text(composite, SWT.BORDER);
		GridData gridData1 = new GridData(SWT.LEFT, SWT.CENTER, true, true, 4, 1);
		txtNumOfDays.setLayoutData(gridData1);
		
		
		Button btnDate = new Button(composite, SWT.RADIO);
		btnDate.setText("Date");
		Label lblDateFrom = new Label(composite, SWT.NONE);
		lblDateFrom.setText("From:");
		CDateTime dtFrom = new CDateTime(composite, CDT.BORDER | CDT.DROP_DOWN| CDT.COMPACT);
		Label lblDateTo = new Label(composite, SWT.NONE);
		lblDateTo.setText("To:");
		CDateTime dtTo = new  CDateTime(composite, CDT.BORDER | CDT.DROP_DOWN | CDT.COMPACT);
		
		return composite;
		
	}

}
