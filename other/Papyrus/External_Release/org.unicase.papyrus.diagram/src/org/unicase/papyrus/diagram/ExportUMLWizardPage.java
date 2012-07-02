/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
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
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

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
		if (selectionDialog.open() != Dialog.OK) {
			return;
		}

		setControl(content);
	}

}
