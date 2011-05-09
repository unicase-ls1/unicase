/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.util;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * Utility class for the unicase project.
 * 
 * @author shterev
 * @author hodaie
 * @author denglerm
 */
public final class UiUtil {

	private UiUtil() {
		// do nothing
	}

	/**
	 * . This shows a standard dialog with some given initial contents to select model elements.
	 * 
	 * @param shell shell
	 * @param initialContent initilaContents
	 * @param title title
	 * @param multiSelection if multiSelection is allowed
	 * @return The selected objects
	 */
	// ZH Why does this return Objects?:
	public static Object[] showMESelectionDialog(Shell shell, Collection<?> initialContent, String title,
		boolean multiSelection) {

		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		AdapterFactoryLabelProvider factoryLabelProvider = new AdapterFactoryLabelProvider(adapterFactory);
		ElementListSelectionDialog dlg = new ElementListSelectionDialog(shell.getShell(),
			factoryLabelProvider);
		//hkq: done

		dlg.setElements(initialContent.toArray(new Object[initialContent.size()]));
		dlg.setTitle(title);
		dlg.setBlockOnOpen(true);
		dlg.setMultipleSelection(multiSelection);
		Object[] result = new Object[0];
		if (dlg.open() == Window.OK) {
			result = dlg.getResult();
		}
		dlg.close();
		adapterFactory.dispose();
		factoryLabelProvider.dispose();
		return result;
	}


	/**
	 * Get the name of a model element.
	 * 
	 * @param modelElement the model element
	 * @return the name for the model element
	 */
	public static String getNameForModelElement(EObject modelElement) {
		AdapterFactoryLabelProvider labelProvider;
		String result;
		//hkq: done
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
		
		result = labelProvider.getText(modelElement);
		adapterFactory.dispose();
		labelProvider.dispose();
		return result;
	}

}
