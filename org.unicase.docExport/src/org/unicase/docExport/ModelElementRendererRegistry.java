/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.builders.modelElementRenderers.ClassRenderersBuilder;
import org.unicase.docExport.exportModel.builders.modelElementRenderers.MeetingRenderersBuilder;
import org.unicase.docExport.exportModel.builders.modelElementRenderers.MilestoneRenderersBuilder;
import org.unicase.docExport.exportModel.builders.modelElementRenderers.ModelElementRendererBuilder;
import org.unicase.docExport.exportModel.builders.modelElementRenderers.PackageRenderersBuilder;
import org.unicase.docExport.exportModel.renderers.ModelElementRenderer;
import org.unicase.model.ModelPackage;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.meeting.MeetingPackage;
import org.unicase.model.task.TaskPackage;

/**
 * This class creates a mapping from a ModelElement type to a its possible ModelElementRenderers. So if you create a new
 * ModelElementRenderer, it should be returned in the function getSupportedModelElementRenderers for all ModelElement
 * types it supports.
 * 
 * @author Sebastian Hoecht
 */
public final class ModelElementRendererRegistry {

	private ModelElementRendererRegistry() {

	}

	/**
	 * Returns all possible ModelElementRenderers for a given modelElement EClass.
	 * 
	 * @param eClass the EClass of the ModelElement type
	 * @param template the template where the ModelElementRenderers are needed. This parameter is required, because the
	 *            a new default model element renderer is created. The build requires a template (because of the global
	 *            renderer options)
	 * @return all possible ModelElementRenderers
	 */
	public static ArrayList<ModelElementRenderer> getSupportedModelElementRenderers(EClass eClass, Template template) {

		ModelElementRendererBuilder builder = new ModelElementRendererBuilder();

		if (eClass.equals(MeetingPackage.eINSTANCE.getMeeting())) {
			builder = new MeetingRenderersBuilder();
		} else if (eClass.equals(TaskPackage.eINSTANCE.getMilestone())) {
			builder = new MilestoneRenderersBuilder();
		} else if (eClass.equals(ClassesPackage.eINSTANCE.getPackage())) {
			builder = new PackageRenderersBuilder();
		} else if (eClass.equals(ClassesPackage.eINSTANCE.getClass_())) {
			builder = new ClassRenderersBuilder();
		}

		return builder.buildRenderers(template);
	}

	/**
	 * This function looks up the contents of a package for instantiatable ModelELements to add them to the result of
	 * this function. This function looks up the subPackages recursively. Normally you will start this function with
	 * ModelPackage.eINSTANCE.eContents()
	 * 
	 * @param objectList the myPackage.eContents() value where you want to look for EClasses
	 * @return a list of EClasses which represent modelElement types
	 */
	public static ArrayList<EClass> getModelElements(EList<EObject> objectList) {

		/**
		 * Compare two EClasses by EClass name
		 * 
		 * @author Sebastian Hoecht
		 */
		class EClassComparator implements Comparator<EClass> {

			/**
			 * @param o1 first eClass
			 * @param o2 seconds eClass
			 * @return -1; 0 or 1 like the string compareTo function
			 */
			public int compare(EClass o1, EClass o2) {
				return o1.getName().compareTo(o2.getName());
			}

		}

		ArrayList<EClass> modelElementTypes = new ArrayList<EClass>();

		for (EObject object : objectList) {
			if (object instanceof EClass) {
				EClass eClass = (EClass) object;
				EObject me;
				if (!(eClass.isAbstract() || eClass.isInterface())) {
					me = eClass.getEPackage().getEFactoryInstance().create(eClass);
					if (me instanceof UnicaseModelElement) {
						modelElementTypes.add((EClass) object);
					}
				}
			} else if (object instanceof EPackage) {
				modelElementTypes.addAll(getModelElements(object.eContents()));
			}
		}

		Collections.sort(modelElementTypes, new EClassComparator());

		return modelElementTypes;
	}

	/**
	 * @param eClassName the name of the EClass which is searched for.
	 * @return the EClass with the same name like eClassName
	 */
	public static EClass getEClassOfString(String eClassName) {
		ArrayList<EClass> eClasses = getModelElements(ModelPackage.eINSTANCE.eContents());

		for (EClass eClass : eClasses) {
			if (eClassName.equals(eClass.getInstanceClassName())) {
				return eClass;
			}
		}

		return null;
	}

	/**
	 * Returns a unique string of an EClass.
	 * 
	 * @param eClass the EClass
	 * @return a unique string of the EClass
	 */
	public static String getStringOfEClass(EClass eClass) {
		return eClass.getInstanceTypeName();
	}
}
