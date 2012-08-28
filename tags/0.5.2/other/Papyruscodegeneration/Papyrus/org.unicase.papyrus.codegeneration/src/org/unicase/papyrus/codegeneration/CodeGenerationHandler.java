/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.codegeneration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Handler for showing a wizard to generate code from UML models.
 * 
 * @author Sebastian Scheibner
 */
public class CodeGenerationHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		List<org.eclipse.uml2.uml.Package> selection = validateSelection(event);

		WizardDialog wizard = new WizardDialog(Display.getCurrent().getActiveShell(), new UML2CodeWizard(selection));
		wizard.open();
		return null;
	}

	/**
	 * Check if event contains a selection of uml packages is selected and return them. Throws an
	 * IllegalArgumentException if no uml packages are selected.
	 * 
	 * @param event An Execution event with a selection
	 * @return a list of selected uml packages
	 */
	private List<org.eclipse.uml2.uml.Package> validateSelection(ExecutionEvent event) {
		ISelection selection = HandlerUtil.getCurrentSelection(event);

		if (selection instanceof IStructuredSelection) {
			Iterator<?> iter = ((IStructuredSelection) selection).iterator();
			List<org.eclipse.uml2.uml.Package> result = new ArrayList<org.eclipse.uml2.uml.Package>();
			while (iter.hasNext()) {
				Object element = iter.next();
				if (element instanceof org.eclipse.uml2.uml.Package) {
					result.add((org.eclipse.uml2.uml.Package) element);
				}
			}

			if (result.size() > 0) {
				return result;
			}
		}

		throw new IllegalArgumentException("Invalid selection! Please select a Project or any contained model element!");
	}
}
