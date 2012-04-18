/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.util;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.metamodel.NonDomainElement;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.ModelPackage;
import org.unicase.ui.common.MEClassLabelProvider;

/**
 * Utility class for the unicase project.
 * 
 * @author shterev
 * @author hodaie
 * @author denglerm
 */
public final class UnicaseUiUtil {

	private UnicaseUiUtil() {
		// do nothing
	}

	/**
	 * Shows a list of model element types.
	 * 
	 * @param shell shell
	 * @param showAbstractTypes if also abstract types are shown
	 * @param showNonDomain If non domain elements are shown
	 * @return selected model element type
	 */
	public static EClass showMETypeSelectionDialog(Shell shell, boolean showAbstractTypes, boolean showNonDomain) {
		ElementListSelectionDialog dlg = new ElementListSelectionDialog(shell.getShell(), new MEClassLabelProvider());
		Set<EClass> eClazz;
		if (showAbstractTypes) {
			eClazz = ModelUtil.getAllMETypes(ModelPackage.eINSTANCE);
		} else {
			eClazz = ModelUtil.getNonAbstractMETypes(ModelPackage.eINSTANCE);
		}
		if (!showNonDomain) {
			Set<EClass> filteredEClass = new HashSet<EClass>();
			// Filter out non domain
			for (EClass eClass : eClazz) {
				if (!(NonDomainElement.class.isAssignableFrom(eClass.getInstanceClass()))) {
					filteredEClass.add(eClass);
				}
			}

			eClazz = filteredEClass;
		}
		dlg.setElements(eClazz.toArray());
		dlg.setTitle("Select model element type");
		dlg.setBlockOnOpen(true);
		dlg.setMultipleSelection(false);
		EClass result = null;
		if (dlg.open() == Window.OK) {
			result = (EClass) dlg.getResult()[0];
		}
		return result;
	}
}
