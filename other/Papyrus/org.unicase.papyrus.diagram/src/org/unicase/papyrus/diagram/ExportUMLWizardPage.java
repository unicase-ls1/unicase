package org.unicase.papyrus.diagram;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.editor.MESuggestedSelectionDialog;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.umlutils.MessageUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.swt.widgets.Label;

public class ExportUMLWizardPage extends WizardPage {
	
	private final Project project;


	protected ExportUMLWizardPage(Project project, String pageName) {
		super(pageName);
		this.project = project;
	}

	public void createControl(Composite parent) {
		Composite content = new Composite(parent, SWT.NONE);
		
		EList<org.eclipse.uml2.uml.Package> allPackages = new BasicEList<org.eclipse.uml2.uml.Package>();
		List<EObject> selectableElements = new ArrayList<EObject>(allPackages.size());

		project.getAllModelElementsbyClass(UMLPackage.eINSTANCE.getPackage(), allPackages, true);
		for (Package umlPackage : allPackages) {
			selectableElements.add(umlPackage);
		}
		
		// prompt the user to select packages
		MESuggestedSelectionDialog selectionDialog = new MESuggestedSelectionDialog("Package Selection",
			"Please select the packages you would like to export.", true, UMLFactory.eINSTANCE.createPackage(),
			UMLPackage.eINSTANCE.getPackage_PackagedElement(), selectableElements);
		if(selectionDialog.open() != Dialog.OK) {
			return;
		}
		
		// set title and description for the page

		this.setTitle("Format selection");
		this.setDescription("Please select the format you would like to export to.");
		
		// create the desired layout for this wizard page
		GridLayout gl = new GridLayout();
	
		int ncol = 4;
		gl.numColumns = ncol;
		content.setLayout(gl);		
		
		// create the widgets and their grid data objects 
		new Label (content, SWT.NONE).setText("Format:");						
		final Combo formats = new Combo(content, SWT.BORDER | SWT.READ_ONLY);
		
		// set the formats available for exporting to
		formats.setItems(new String[]{"ecore", "Java", "C++"});
		formats.select(0);
		  
		GridData gd = new GridData();
		gd.horizontalAlignment = GridData.BEGINNING;
		gd.widthHint = 75;
		formats.setLayoutData(gd);
		
		
		setControl(content);
	}


}
