/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */

package org.unicase.ui.common.util;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.model.ModelPackage;

/**
 * Utility class for the unicase project. 
 * @author shterev
 *
 */
public final class UnicaseUtil {
	
	private UnicaseUtil(){
		
	}
	
	/**
	 * @param clazz the input class
	 * @param ePackage the input package
	 * @return Returns all subclasses of the given input in the given package.
	 */
	public static ArrayList<EClass> getSubclasses(EClass clazz, EPackage ePackage) {
		ArrayList<EClass> ret = new ArrayList<EClass>();

		if (clazz.isAbstract() || clazz.isInterface()) {
			for (EObject eObject : ePackage.eContents()) {
				if (eObject instanceof EClass && !eObject.equals(ModelPackage.eINSTANCE.getProject())) {
					EClass eClass = (EClass) eObject;
					if (clazz.isSuperTypeOf(eClass) && !(eClass.isAbstract() || eClass.isInterface())) {
						ret.add(eClass);
					}
				}else if (eObject instanceof EPackage) {
					EPackage eSubPackage = (EPackage) eObject;
					ret.addAll(getSubclasses(clazz, eSubPackage));
				}
			}
		} else {
			ret.add(clazz);
		}
		return ret;
	}

	/**
	 * @param clazz the input super class
	 * @return Returns all subclasses of the given input.
	 * Looks in whole graph starting from the root package - i.e. ModelPackage.
	 */
	public static ArrayList<EClass> getSubclasses(EClass clazz) {
		return UnicaseUtil.getSubclasses(clazz, ModelPackage.eINSTANCE);
	}
	
	
	/**.
	 * This shows a standard dialog with some given initial contents to
	 * select model elements.
	 * @param shell shell
	 * @param initialContent initilaContents
	 * @param title title
	 * @param multiSelection if multiSelection is allowed
	 * @return
	 */
	public static Object[] showMESelectionDialog(Shell shell,
								Collection<?> initialContent,
								String title,
								boolean multiSelection){
		
		ElementListSelectionDialog dlg = new ElementListSelectionDialog(shell
				.getShell(), new AdapterFactoryLabelProvider(
							new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));

		dlg.setElements(initialContent.toArray(new Object[initialContent.size()]));
		dlg.setTitle(title);
		dlg.setBlockOnOpen(true);
		dlg.setMultipleSelection(multiSelection);
		Object[] result = new Object[0];
		if (dlg.open() == Window.OK) {
			result = dlg.getResult();
		}
		return result;
	}

}
