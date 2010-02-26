package org.unicase.ui.web.projectview;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.model.ModelPackage;
import org.unicase.model.task.TaskPackage;
import org.unicase.ui.web.views.AbstractETableViewer;

public class WorkItemsTableViewer extends AbstractETableViewer {

	public WorkItemsTableViewer(Composite composite) {
		super(composite);
	}
	
	@Override
	protected void init() {		
		super.init();
		GridData tableData = new GridData(SWT.FILL, SWT.FILL, true, true);
		tableData.horizontalSpan = 2;
		getTable().setLayoutData(tableData);
	}

	@Override
	public ArrayList<EStructuralFeature> getFeaturesList() {
		ArrayList<EStructuralFeature> list = new ArrayList<EStructuralFeature>();
		list.add(ModelPackage.Literals.UNICASE_MODEL_ELEMENT__STATE);
		list.add(ModelPackage.Literals.UNICASE_MODEL_ELEMENT__NAME);
		list.add(TaskPackage.Literals.WORK_ITEM__ASSIGNEE);
		list.add(MetamodelPackage.Literals.MODEL_ELEMENT__CREATION_DATE);
		list.add(MetamodelPackage.Literals.MODEL_ELEMENT__CREATOR);
		list.add(TaskPackage.Literals.WORK_ITEM__CONTAINING_WORKPACKAGE);
		list.add(TaskPackage.Literals.WORK_ITEM__DUE_DATE);
		list.add(TaskPackage.Literals.WORK_ITEM__PRIORITY);
		return list;
	}


}
