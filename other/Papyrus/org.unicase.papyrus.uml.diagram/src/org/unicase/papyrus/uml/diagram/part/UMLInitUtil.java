/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.uml.diagram.part;

import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.UMLFactory;
import org.unicase.papyrus.UMLModel;

/**
 * Utility class for initializing Papyrus UML diagrams and their model elements, if any.
 * 
 * @author mharut
 */
public final class UMLInitUtil {

	private UMLInitUtil() {
		// nothing to do
	}

	/**
	 * Initializes a Papyrus uml model according to its diagram type. For some diagram types, this will create
	 * additional elements.
	 * 
	 * @param model the {@link UMLModel} to initialize
	 */
	public static void initialize(UMLModel model) {
		switch (model.getDiagramType()) {
		case ACTIVITY:
			defaultInitialization(model, UMLFactory.eINSTANCE.createActivity(), ActivityDiagramEditPart.MODEL_ID,
				org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			break;
		case CLASS:
			defaultInitialization(model, null, org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPart.MODEL_ID,
				org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			break;
		case COMMUNICATION:
			defaultInitialization(model, UMLFactory.eINSTANCE.createInteraction(),
				org.eclipse.papyrus.diagram.communication.edit.parts.ModelEditPart.MODEL_ID,
				org.eclipse.papyrus.diagram.communication.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			break;
		case COMPOSITE:
			defaultInitialization(model, null, CompositeStructureDiagramEditPart.MODEL_ID,
				org.eclipse.papyrus.diagram.composite.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			break;
		case PACKAGE:
			defaultInitialization(model, null, "Package",
				org.eclipse.papyrus.diagram.composite.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			break;
		case SEQUENCE:
			defaultInitialization(model, UMLFactory.eINSTANCE.createInteraction(),
				org.eclipse.papyrus.diagram.sequence.edit.parts.PackageEditPart.MODEL_ID,
				org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			break;
		case STATE_MACHINE:
			initStateMachine(model, UMLFactory.eINSTANCE.createStateMachine(),
				org.eclipse.papyrus.diagram.statemachine.edit.parts.PackageEditPart.MODEL_ID,
				org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			break;
		case USE_CASE:
			defaultInitialization(model, null, UseCaseDiagramEditPart.MODEL_ID,
				org.eclipse.papyrus.diagram.usecase.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			break;
		default:
			throw new IllegalArgumentException("Diagram type not supported!");
		}
	}

	private static void initStateMachine(final UMLModel model, final StateMachine stateMachine, final String id,
		final PreferencesHint hint) {

		final Diagram diagram = ViewService.createDiagram(model, id, hint);

		new StateMachineInitCommand(model, diagram, stateMachine).run(true);

	}

	private static void defaultInitialization(final UMLModel model, final PackageableElement element, final String id,
		final PreferencesHint hint) {
		final Diagram diagram = ViewService.createDiagram(model, id, hint);
		diagram.setElement(model);
		new ECPCommand(model) {
			@Override
			protected void doRun() {
				model.setGmfDiagram(diagram);
				if (element != null) {
					model.getPackagedElements().add(element);
					initElement(element, hint);
					ViewService.getInstance().createView(org.eclipse.gmf.runtime.notation.Node.class,
						new EObjectAdapter(element), diagram, null, ViewUtil.APPEND, true, hint);
				}
			}
		}.run(true);
	}

	private static void initElement(PackageableElement element, PreferencesHint hint) {
		if (hint.equals(org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT)
			&& element instanceof Activity) {
			initActivity((Activity) element);
		} else if (hint
			.equals(org.eclipse.papyrus.diagram.communication.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT)
			&& element instanceof Interaction) {
			initCommunicationInteraction((Interaction) element);
		} else if (hint
			.equals(org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT)
			&& element instanceof Interaction) {
			initSequenceInteraction((Interaction) element);
		}

	}

	private static void initActivity(Activity activity) {
		org.eclipse.papyrus.diagram.activity.providers.ElementInitializers.getInstance().init_Activity_2001(activity);
	}

	private static void initCommunicationInteraction(Interaction interaction) {
		org.eclipse.papyrus.diagram.communication.providers.ElementInitializers.getInstance().init_Interaction_8002(
			interaction);
	}

	private static void initSequenceInteraction(Interaction interaction) {
		org.eclipse.papyrus.diagram.sequence.providers.ElementInitializers.getInstance().init_Interaction_2001(
			interaction);
	}

}
