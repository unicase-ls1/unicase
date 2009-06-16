/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.common.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.roles.Role;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.NonDomainElement;
import org.unicase.model.Project;
import org.unicase.model.classes.Association;
import org.unicase.model.util.ModelUtil;
import org.unicase.ui.common.MEClassLabelProvider;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;

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

		ElementListSelectionDialog dlg = new ElementListSelectionDialog(shell.getShell(),
			new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
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
	
	/**
	 * Shows a list of all MEs of meType in project.
	 * @param shell shell
	 * @param meType model element type
	 * @param project project
	 * @param multiSelection if multiple elements can be selected
	 * @return selected elements
	 */
	public static Object[] showMESelectionDialog(Shell shell, EClass meType, Project project, boolean multiSelection){
		List<? extends ModelElement> elements = project.getAllModelElementsbyClass(meType, new BasicEList<ModelElement>());
		return showMESelectionDialog(shell, elements, "Select " + meType.getName(), multiSelection);
	}
	
	/**
	 * Shows a list of model element types.
	 * @param shell shell
	 * @param showAbstractTypes if also abstract types are shown
	 * @param showNonDomain If non domain elements are shown
	 * @return selected model element type
	 */
	public static EClass showMETypeSelectionDialog(Shell shell, boolean showAbstractTypes, boolean showNonDomain){
		ElementListSelectionDialog dlg = new ElementListSelectionDialog(shell.getShell(),
			new MEClassLabelProvider());
		Set<EClass> eClazz;
		if(showAbstractTypes){
			eClazz = ModelUtil.getAllMETypes(ModelPackage.eINSTANCE);
		}else{
			eClazz = ModelUtil.getNonAbstractMETypes(ModelPackage.eINSTANCE);
		}
		if(!showNonDomain){
			Set<EClass> filteredEClass = new HashSet<EClass>();
			//Filter out non domain
			for(EClass eClass:eClazz){
				if(!(NonDomainElement.class.isAssignableFrom(eClass.getInstanceClass()))){
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

	/**
	 * This method searches for in- and outgoing associations of a node and returns them in an ArrayList.
	 * 
	 * @param node The diagram node
	 * @return The list of associations
	 */
	public static Set<EObject> getDiagramNodeReferences(ModelElement node) {
		Set<EObject> references = new HashSet<EObject>();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(node.eResource()
			.getResourceSet());
		if (crossReferencer != null) {
			Collection<Setting> inverseReferences = crossReferencer.getInverseReferences(node);
			if (inverseReferences != null) {

				for (Setting setting : inverseReferences) {
					EObject settingObj = setting.getEObject();
					if (settingObj != null && settingObj instanceof Association) {
						references.add(settingObj);
					}
				}
			}
		}
		return references;
	}

	/**
	 * This checks a user session for project administrator rights. If there is no session, the user is project admin.
	 * 
	 * @param session User session to check
	 * @param projectSpace ProjectSpace
	 * @return true if user has project administrator rights
	 */
	public static boolean isProjectAdmin(Usersession session, ProjectSpace projectSpace) {
		if (session == null) {
			return true;
		}
		ACUser user = session.getACUser();
		List<Role> roles = user.getRoles();
		for (Role role : roles) {
			if (role.canAdministrate(projectSpace.getProjectId())) {
				return true;
			}
		}

		return false;
	}
}
