package org.unicase.papyrus.diagram;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

public class ExportUMLWizardPage extends WizardPage {

	private final Project project;
	private String format;
	private String destDir;
	private Text destinationDirField;

	private List<org.eclipse.uml2.uml.Package> packages;

	protected ExportUMLWizardPage(Project project, String pageName) {
		super(pageName);
		this.project = project;

		// set title and description for the page
		this.setTitle("Format selection");
		this.setDescription("Please select the format you would like to export to.");
	}

	public void createControl(Composite parent) {
		Composite content = new Composite(parent, SWT.NONE);

		// get the models, the user can select
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
		if (selectionDialog.open() != Dialog.OK) {
			return;
		}

		// add the selected packages
		Collection<EObject> modelElements = selectionDialog.getModelElements();
		packages = new ArrayList<org.eclipse.uml2.uml.Package>(modelElements.size());

		for (EObject eObject : selectionDialog.getModelElements()) {
			if (eObject instanceof org.eclipse.uml2.uml.Package) {
				packages.add((Package) eObject);
			}
		}

		// create the desired layout for this wizard page
		GridLayout gl = new GridLayout();
		gl.numColumns = 3;
		content.setLayout(gl);

		// destination folder
		new Label(content, SWT.NONE).setText("Destination folder: ");
		final GridData gdPath = new GridData();
		gdPath.horizontalAlignment = GridData.BEGINNING;

		destinationDirField = new Text(content, SWT.BORDER);
		destinationDirField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		destinationDirField.setEditable(false);
		destinationDirField.addListener(0, new Listener() {
			public void handleEvent(Event event) {
				browseForDestinationDir();

			}
		});

		final Button destinationBrowseButton = new Button(content, SWT.NONE);
		destinationBrowseButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				browseForDestinationDir();

			}
		});
		destinationBrowseButton.setText("Browse");

		// Export format selection
		new Label(content, SWT.NONE).setText("Format:");
		final Combo formats = new Combo(content, SWT.BORDER | SWT.READ_ONLY);

		// set the formats available for exporting to
		formats.setItems(new String[] { "ecore", "Java", "C++" });
		formats.select(0);
		format = formats.getItem(0);

		GridData gd = new GridData();
		gd.horizontalAlignment = GridData.BEGINNING;
		gd.widthHint = 75;
		formats.setLayoutData(gd);

		formats.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				format = formats.getItem(formats.getSelectionIndex());

			}
		});

		setControl(content);
	}

	public void browseForDestinationDir() {
		IPath path = browse(false);
		if (path == null) {
			return;
		}
		destDir = path.toString();
		destinationDirField.setText(destDir);
	}

	public IPath browse(boolean mustExist) {
		ContainerSelectionDialog dialog = new ContainerSelectionDialog(getShell(), null, true,
			"Select the export folder:");
		dialog.setTitle("Export folder selection");
		if (dialog.open() != Dialog.OK) {
			return null;
		}
		Object result[] = dialog.getResult();
		if (result == null || result.length == 0 || !(result[0] instanceof IPath)) {
			return null;
		}

		return (IPath) result[0];
	}

	public String getFormat() {
		return format;
	}

	public String getDestinationDir() {
		return destDir;
	}

	public List<org.eclipse.uml2.uml.Package> getPackages() {
		return packages;
	}

}
