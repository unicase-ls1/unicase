/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.sysml.diagram.part;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.unicase.papyrus.PapyrusFactory;
import org.unicase.papyrus.SysMLClass;
import org.unicase.papyrus.SysMLModel;

/**
 * Utility class for initializing SysML elements.
 * 
 * @author mharut
 */
public final class SysMLInitUtil {

	private SysMLInitUtil() {

	}

	/**
	 * Initializes a {@link SysMLClass} or a {@link SysMLModel}, i.e. creates the corresponding diagrams and further
	 * initializes required elements.
	 * 
	 * @param eObject the {@link EObject} to initialize
	 * @see #defaultInitialization(SysMLModel, PackageableElement, String, PreferencesHint)
	 */
	public static void initialize(EObject eObject) {
		if (eObject instanceof SysMLModel) {
			SysMLModel model = (SysMLModel) eObject;
			switch (model.getDiagramType()) {
			case BLOCK_DEFINITION:
				defaultInitialization(model, null, "BlockDefinition",
					org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				break;
			case INTERNAL_BLOCK:
				defaultInitialization(model, null, "InternalBlock",
					org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				break;
			case REQUIREMENT:
				defaultInitialization(model, null, "RequirementDiagram",
					org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				break;
			case PARAMETRIC:
				initParametricDiagram(model);
				break;
			default:
				throw new IllegalArgumentException("Invalid diagram type!");
			}
		} else {
			throw new IllegalArgumentException("Invalid element type!");
		}
	}

	private static void initParametricDiagram(final SysMLModel model) {

		new ECPCommand(model) {
			@Override
			protected void doRun() {
				SysMLClass sysMLClass = null;
				for (Type type : model.getOwnedTypes()) {
					if (type instanceof SysMLClass) {
						sysMLClass = (SysMLClass) type;
						break;
					}
				}
				if (sysMLClass == null) {
					sysMLClass = PapyrusFactory.eINSTANCE.createSysMLClass();
					sysMLClass.setName("Parametric");
					model.getOwnedTypes().add(sysMLClass);
				}

				org.eclipse.uml2.uml.Class tempClass = UMLFactory.eINSTANCE.createClass();
				final Diagram diagram = ViewService.createDiagram(tempClass, ParametricEditPart.MODEL_ID,
					SysmlDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);

				diagram.setElement(sysMLClass);
				sysMLClass.setGmfDiagram(diagram);
			}
		}.run(true);
	}

	private static void defaultInitialization(final SysMLModel model, final PackageableElement element,
		final String id, final PreferencesHint hint) {
		final Diagram diagram = ViewService.createDiagram(model, id, hint);
		diagram.setElement(model);
		final Profile sysml = (Profile) PackageUtil.loadPackage(URI.createURI(SysmlResource.SYSML_PROFILE_URI), model
			.eResource().getResourceSet());
		new ECPCommand(model) {
			@Override
			protected void doRun() {
				model.setGmfDiagram(diagram);
				if (sysml != null) {
					PackageUtil.applyProfile(model, sysml, true);
				}
				if (element != null) {
					model.getPackagedElements().add(element);
					ViewService.getInstance().createView(org.eclipse.gmf.runtime.notation.Node.class,
						new EObjectAdapter(element), diagram, null, ViewUtil.APPEND, true, hint);
				}
			}
		}.run(true);
	}
}
