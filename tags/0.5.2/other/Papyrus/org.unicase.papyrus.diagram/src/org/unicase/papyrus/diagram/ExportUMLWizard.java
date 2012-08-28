/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.diagram;

import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.jface.wizard.Wizard;

public class ExportUMLWizard extends Wizard {

	private final Project project;

	public ExportUMLWizard(Project project) {
		super();
		this.project = project;
	}

	public void addPages() {
		addPage(new ExportUMLWizardPage(project, "Export UML"));
	}

	@Override
	public boolean performFinish() {
		return true;
	}

}
