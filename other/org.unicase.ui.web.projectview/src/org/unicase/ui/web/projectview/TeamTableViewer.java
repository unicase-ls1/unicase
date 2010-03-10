package org.unicase.ui.web.projectview;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.ui.web.views.AbstractETableViewer;

/**
 * 
 * @author Edgar Mueller
 * @author Fatih Ulusoy
 */
public class TeamTableViewer extends AbstractETableViewer {
	
	/**
	 * 
	 * @param projectSpace
	 * @param composite
	 */
	public TeamTableViewer(Composite composite) {
		super(composite);
	}
	
	@Override
	protected void init() {		
		super.init();
		// TODO: layouts??
		GridData tableData = new GridData(SWT.FILL, SWT.FILL, true, true);
		tableData.horizontalSpan = 2;
		getTable().setLayoutData(tableData);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public ArrayList<EStructuralFeature> getFeaturesList() {
		ArrayList<EStructuralFeature> list = new ArrayList<EStructuralFeature>();
		list.add(OrganizationPackage.Literals.USER__FIRST_NAME);
		list.add(OrganizationPackage.Literals.USER__LAST_NAME);
		list.add(OrganizationPackage.Literals.USER__EMAIL);
		return list;
	}
}
