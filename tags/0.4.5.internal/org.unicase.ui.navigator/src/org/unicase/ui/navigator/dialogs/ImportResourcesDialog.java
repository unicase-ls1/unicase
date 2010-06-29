/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigator.dialogs;

import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.util.ModelUtil;

/**
 * A dialog which allows to selected models to import.
 */
public class ImportResourcesDialog extends ResourceDialog {

	private StringBuffer errors;

	/**
	 * Constructor.
	 * 
	 * @param parent the parent
	 * @param title the title
	 * @param style the style
	 */
	public ImportResourcesDialog(Shell parent, String title, int style) {
		super(parent, title, style);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.common.ui.dialogs.ResourceDialog#processResources()
	 */
	@Override
	protected boolean processResources() {

		errors = new StringBuffer();

		validateURIs();

		if (errors.length() > 0) {
			MessageDialog.openError(getShell(), "Errors", errors.toString());
		}

		return errors.length() == 0 ? super.processResources() : false;
	}

	/**
	 * Validate the selected uris.
	 */
	protected void validateURIs() {
		ResourceSet resourceSet = new ResourceSetImpl();
		for (URI uri : getURIs()) {
			try {
				Resource resource = resourceSet.getResource(uri, true);
				EList<EObject> contents = resource.getContents();
				if (contents.size() > 0) {
					for (int i = 0; i < contents.size(); i++) {
						EObject content = contents.get(i);
						if (!(content instanceof ModelElement)) {
							if (contents.size() > 1) {
								errors.append(String.format(
									"%s - resourceIndex:%s is no instance of org.unicase.metamodel.ModelElement\n\n",
									uri.toString(), i));
							} else {
								errors.append(String.format(
									"%s is no instance of org.unicase.metamodel.ModelElement\n\n", uri.toString()));
							}
						}
						if (!ModelUtil.isSelfContained(content)) {
							if (contents.size() > 1) {
								errors.append(String.format("%s - resourceIndex:%s is not self contained.\n\n", uri
									.toString(), i));
							} else {
								errors.append(String.format("%s is not self contained.\n\n", uri.toString()));
							}
						}
					}
				} else {
					errors.append(String.format("%s could no be loaded.\n\n", uri.toString()));
				}
				// BEGIN SUPRESS CATCH EXCEPTION
			} catch (RuntimeException e) {
				// END SUPRESS CATCH EXCEPTION
				errors.append(e.toString());
			}
		}
	}
}
