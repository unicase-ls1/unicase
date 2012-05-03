package org.unicase.papyrus.diagram;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecp.editor.MESuggestedSelectionDialog;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.swt.widgets.Label;

public class ExportUMLWizardPage extends WizardPage {
	
	private final Project project;
	private static String format;
	private static String destDir;
	private Text destinationDirField;
	
	private static List<org.eclipse.uml2.uml.Package> packages;

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

		
		Collection<EObject> modelElements = selectionDialog.getModelElements();
        packages = new ArrayList<org.eclipse.uml2.uml.Package>(modelElements.size());
        
        // add the selected packages
        for (EObject eObject : selectionDialog.getModelElements()) {
                if (eObject instanceof org.eclipse.uml2.uml.Package) {
                        packages.add((Package) eObject);
                }
        }

 
		// set title and description for the page

		this.setTitle("Format selection");
		this.setDescription("Please select the format you would like to export to.");
		
		// create the desired layout for this wizard page
		GridLayout gl = new GridLayout();
	
		int ncol = 3;
		gl.numColumns = ncol;
		content.setLayout(gl);		
		
		// add destination path
		new Label (content, SWT.NONE).setText("Destination folder: ");
		final GridData gdPath = new GridData();
		gdPath.horizontalAlignment = GridData.BEGINNING;
		
		destinationDirField = new Text(content, SWT.BORDER);
		destinationDirField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		destinationDirField.setEditable(false);
		destinationDirField.addListener(0, new Listener(){

			public void handleEvent(Event event) {
				browseForDestinationDir();
				
			}
		});
		
		final Button destinationDirBtn = new Button(content, SWT.NONE);
		destinationDirBtn.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
					browseForDestinationDir();
				
			}
		});
		destinationDirBtn.setText("Browse");
		
		
		// create the widgets and their grid data objects 
		new Label (content, SWT.NONE).setText("Format:");						
		final Combo formats = new Combo(content, SWT.BORDER | SWT.READ_ONLY);
		
		
		// set the formats available for exporting to
		formats.setItems(new String[]{"ecore", "Java", "C++"});
		formats.select(0);
		format = formats.getItem(0);  
		
		GridData gd = new GridData();
		gd.horizontalAlignment = GridData.BEGINNING;
		gd.widthHint = 75;
		formats.setLayoutData(gd);
		
		formats.addListener(SWT.Selection, new Listener(){

			public void handleEvent(Event event) {
				format = formats.getItem(formats.getSelectionIndex());
				
			}
			
		});
		
		setControl(content);
	}
	
	
	public void browseForDestinationDir(){
		
		IPath path = browse(false);
		if(path == null) {
			return;
		}
		destDir = path.toString();
		destinationDirField.setText(path.toString());
	}

	

	public IPath browse(boolean mustExist) {
				
		DirectoryDialog dialog = new DirectoryDialog(getShell(), mustExist ? SWT.OPEN : SWT.SAVE);
		
		String result = dialog.open();
		if( result == null ) {
			return null;
		}
		
		return new Path(result);
	}
	
	public static String getFormat(){
		return format;
	}
	
	public static String getDestinationDir(){
		return destDir;
	}
	
	public static List<org.eclipse.uml2.uml.Package> getPackages(){
		return packages;
	}
	
}
