/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.unicase.modelgenerator;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.metamodel.Project;
import org.unicase.modelgenerator.ModelGenerator;
import org.unicase.modelgenerator.common.ModelGeneratorConfiguration;
import org.unicase.modelgenerator.common.ModelGeneratorUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Handler for the "Generate Model" context menu command.
 * The command is available if nothing or an EObject is selected.
 * This handler generates a model using values from the selection made,
 * the package defined in <code>MODEL_KEY</code> and width
 * and depth as defined in <code>WIDTH</code> and <code>DEPTH</code>.
 */
public class GenerateModelHandler extends AbstractHandler {
	
	/**
	 * The NsURI of the EPackage to generate EObjects from.
	 * This is only used if a project or nothing is selected,
	 * otherwise the root package of the selected EObject will be used.
	 */
	private final String modelKey = "http://unicase.org/model";
	
	/**
	 * The maximum number of children for each EObject.
	 */
	private final int width = 5;
	
	/**
	 * The maximum hierarchy depth of the project.
	 */
	private final int depth = 5;

	/**
	 * ({@inheritDoc}).
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
				
		final ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				EObject rootObject = validateSelection(selection);
				EPackage pckge = getRootPackage(rootObject);
				generate(rootObject, pckge);
			}
		}.run(false);

		return null;
	}

	/**
	 * Creates a {@link ModelGeneratorConfiguration} and calls
	 * {@link ModelGenerator#generateModel(ModelGeneratorConfiguration)} with it.
	 * If <code>rootObject</code> is a Project, another method is called:
	 * {@link #generateProject(Project, EPackage)}
	 * 
	 * @param rootObject the rootObject of the model to generate
	 * @param pckge the EPackage to use for the generation process
	 * @see #generateProject(Project, EPackage)
	 */
	private void generate(EObject rootObject, EPackage pckge) {
		if(rootObject instanceof Project) {
			generateProject((Project) rootObject, pckge);
		} else {
			List<EClass> ignoredClasses = new LinkedList<EClass>();
			ignoredClasses.add((EClass) pckge.getEClassifier("Project"));
			ModelGeneratorConfiguration config = new ModelGeneratorConfiguration(pckge, rootObject, 
				ignoredClasses, width, depth, System.currentTimeMillis(), true);
			ModelGenerator.generateModel(config);
		}
	}

	/**
	 * Takes <code>WIDTH</code> random EClasses from <code>pckge</code> and
	 * uses each as a root of a generation process. All these roots, and all
	 * their children with them, are afterwards added to the Project.<p>
	 * 
	 * This procedure is necessary to ensure good performance. Using the 
	 * project directly as the root of the generation process results in
	 * very long generation time.
	 * 
	 * @param project the Project the generated models will be added to
	 * @param pckge the EPackage to use for the generation process
	 */
	private void generateProject(Project project, EPackage pckge) {
		List<EClass> ignoredClasses = new LinkedList<EClass>();
		ignoredClasses.add((EClass) pckge.getEClassifier("Project"));
		for(int i=0; i<width; i++) {
			EClass subRootClass = getValidEClass(project, pckge);
			if(subRootClass == null) {
				return;
			}
			ModelGeneratorConfiguration config = new ModelGeneratorConfiguration(pckge, subRootClass, 
				ignoredClasses, width, depth-1, System.currentTimeMillis(), true);
			(project).addModelElement(ModelGenerator.generateModel(config));
		}
	}

	/**
	 * Returns the root EPackage of an EObject or the EPackage
	 * specified by <code>MODEL_KEY</code> if <code>eObject</code>
	 * is a Project.
	 * 
	 * @param eObject the EObject to get the root package for
	 * @return the root EPackage of <code>eObject</code>
	 */
	private EPackage getRootPackage(EObject eObject) {
		if(eObject instanceof Project) {
			return ModelGeneratorUtil.getEPackage(modelKey);
		} else {
			EPackage pckge;
			pckge = eObject.eClass().getEPackage();
			while(pckge.getESuperPackage() != null) {
				pckge = pckge.getESuperPackage();
			}
			return pckge;
		}
	}

	/**
	 * Returns the selected EObject, or a project if a ProjectSpace was selected.
	 * If nothing was selected, creates and returns a new Project.
	 * Otherwise this method shouldn't be called, and therefore an 
	 * IllegalArgumentException is thrown.
	 * 
	 * @param selection the current selection made
	 * @return the valid EObject made from the selection
	 * @throws IllegalArgumentException if selection failed or no EObject is selected
	 */
	private EObject validateSelection(ISelection selection) {
		if(selection != null && selection instanceof IStructuredSelection) {
			IStructuredSelection strucSel = (IStructuredSelection) selection;
			Object selectedElement = strucSel.getFirstElement();
			if(selectedElement instanceof ProjectSpace) {
				return ((ProjectSpace) selectedElement).getProject();
			} else if(selectedElement instanceof EObject) {
				return (EObject) selectedElement;
			} else if(selectedElement==null) {
				return WorkspaceManager.getInstance().getCurrentWorkspace().createLocalProject("Generated Project", "Generated").getProject();
			} else {
				throw new IllegalArgumentException("No EObject selected!");
			}
		} else {
			throw new IllegalArgumentException("Selection Error!");
		}
	}
	
	/**
	 * Returns the next valid EClass, that is an EClass that is neither
	 * abstract, nor an interface, from a list of all possible EClasses.
	 * 
	 * @param allEClasses all EClasses to choose from
	 * @return the next EClass that can be instantiated or <code>null</code>
	 * if there is no such EClass.
	 */
	private EClass getValidEClass(EObject root, EPackage pckge) {
		List<EClass> allEClasses = ModelGeneratorUtil.getAllEContainments(root.eClass());
		allEClasses.retainAll(ModelGeneratorUtil.getAllEClasses(pckge));
		if(allEClasses.isEmpty()) {
			return null;
		}
		Collections.shuffle(allEClasses);
		return allEClasses.get(0);
	}
}
