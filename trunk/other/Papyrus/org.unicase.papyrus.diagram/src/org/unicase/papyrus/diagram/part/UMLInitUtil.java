package org.unicase.papyrus.diagram.part;

import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityDiagramEditPart;
import org.eclipse.papyrus.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.diagram.composite.edit.parts.CompositeStructureDiagramEditPart;
import org.eclipse.papyrus.diagram.statemachine.CreateStateMachineDiagramCommand;
import org.eclipse.papyrus.diagram.statemachine.custom.helpers.Zone;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineCompartmentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseDiagramEditPart;
import org.eclipse.papyrus.umlutils.NamedElementUtil;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.UMLFactory;
import org.unicase.papyrus.UMLModel;
import org.unicase.ui.common.commands.ECPCommand;

public class UMLInitUtil {
	
	public static void initialize(UMLModel model) {
		switch(model.getDiagramType()) {
			case ACTIVITY:
				defaultInitialization(model, UMLFactory.eINSTANCE.createActivity(),
						ActivityDiagramEditPart.MODEL_ID, 
						org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				break;
			case CLASS:
				defaultInitialization(model, null,
						org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPart.MODEL_ID, 
						org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				break;
			case COMMUNICATION:
				defaultInitialization(model, UMLFactory.eINSTANCE.createInteraction(),
						org.eclipse.papyrus.diagram.communication.edit.parts.ModelEditPart.MODEL_ID, 
						org.eclipse.papyrus.diagram.communication.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				break;
			case COMPOSITE:
				defaultInitialization(model, null,
						CompositeStructureDiagramEditPart.MODEL_ID, 
						org.eclipse.papyrus.diagram.composite.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				break;
			// FIXME: Wrong ID, unable to find the right one!
//			case PACKAGE:
//				diagram = ViewService.createDiagram(model, UseCaseDiagramEditPart.MODEL_ID,
//				org.eclipse.papyrus.diagram.usecase.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
//				break;
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
				defaultInitialization(model, null,
						UseCaseDiagramEditPart.MODEL_ID, 
						org.eclipse.papyrus.diagram.usecase.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				break;
			default:
				throw new IllegalArgumentException("Diagram type not supported!");
		}
	}
	
	private static void initStateMachine(final UMLModel model,
			final StateMachine stateMachine,
			final String id, final PreferencesHint hint) {
		
		final Diagram diagram = ViewService.createDiagram(model, id, hint);
		
		new ECPCommand(model) {
			@Override
			protected void doRun() {
				model.setGmfDiagram(diagram);
				model.getPackagedElements().add(stateMachine);
				
				org.eclipse.papyrus.diagram.statemachine.providers.ElementInitializers
		 			.getInstance().init_StateMachine_2000(stateMachine);
				
				int defaultX = CreateStateMachineDiagramCommand.defaultX;
				int defaultY = CreateStateMachineDiagramCommand.defaultY;
				int defaultWidth = CreateStateMachineDiagramCommand.defaultWidth;
				int defaultHeight = CreateStateMachineDiagramCommand.defaultHeight;
				int defaultHeader = CreateStateMachineDiagramCommand.defaultHeader;
				
				View stateMachineView = ViewService.getInstance().createView(Node.class, new EObjectAdapter(stateMachine), model.getGmfDiagram(), null, ViewUtil.APPEND, true, hint);
				Zone.setX(stateMachineView, defaultX);
				Zone.setY(stateMachineView, defaultY);
				Zone.setWidth(stateMachineView, defaultWidth);
				Zone.setHeight(stateMachineView, defaultHeight);
				
				View compartmentView = null;

				Iterator<Node> it = stateMachineView.getChildren().iterator();

				while(it.hasNext()) {
					Node currentNode = it.next();
					if(currentNode.getLayoutConstraint() == null) {
						currentNode.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
					}
					if(UMLVisualIDRegistry.getVisualID(currentNode.getType()) == StateMachineNameEditPart.VISUAL_ID) {
						Zone.setWidth(currentNode, defaultWidth);
						Zone.setHeight(currentNode, defaultHeader);
					} else if(UMLVisualIDRegistry.getVisualID(currentNode.getType()) == StateMachineCompartmentEditPart.VISUAL_ID) {
						Zone.setY(currentNode, defaultHeader);
						Zone.setWidth(currentNode, defaultWidth);
						Zone.setHeight(currentNode, defaultHeight - defaultHeader);
						compartmentView = currentNode;
					}
				}

				Region region = null;
				EList<Region> regions = stateMachine.getRegions();
				if (regions.isEmpty()) {
					region = UMLFactory.eINSTANCE.createRegion();
					regions.add(region);
					region.setName(NamedElementUtil.getDefaultNameWithIncrement(region, regions));
				} else {
					region = stateMachine.getRegions().get(0);
				}

				IAdaptable regionAdaptable = new SemanticAdapter(region, null);
				String semanticHint = ((IHintedType)UMLElementTypes.Region_3000).getSemanticHint();

				if(compartmentView != null) {
					Node regionNode = ViewService.getInstance().createNode(regionAdaptable, compartmentView, semanticHint, ViewUtil.APPEND, hint);
					if(regionNode.getLayoutConstraint() == null) {
						regionNode.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
					}
					// add region specifics
					Zone.createRegionDefaultAnnotation(regionNode);
					Zone.setWidth(regionNode, defaultWidth);
					Zone.setHeight(regionNode, defaultHeight - defaultHeader);

				}
				
			}
		}.run(true);
		
	}
	
	private static void defaultInitialization(final UMLModel model,
			final PackageableElement element, 
			final String id, final PreferencesHint hint) {
		final Diagram diagram = ViewService.createDiagram(model, id, hint);
		diagram.setElement(model);
		new ECPCommand(model) {
			@Override
			protected void doRun() {
				model.setGmfDiagram(diagram);
				if(element != null) {
					model.getPackagedElements().add(element);
					initElement(element, hint);
					ViewService.getInstance().createView(org.eclipse.gmf.runtime.notation.Node.class, new EObjectAdapter(element), diagram, null, ViewUtil.APPEND, true, hint);
				}
			}
		}.run(true);
	}

	private static void initElement(PackageableElement element,
			PreferencesHint hint) {
		if(hint.equals(org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT)
				&& element instanceof Activity) {
			initActivity((Activity) element);
		} else if(hint.equals(org.eclipse.papyrus.diagram.communication.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT)
				&& element instanceof Interaction) {
			initCommunicationInteraction((Interaction) element);
		} else if(hint.equals(org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT)
				&& element instanceof Interaction) {
			initSequenceInteraction((Interaction) element);
		}
		
	}
	
	private static void initActivity(Activity activity) {
		org.eclipse.papyrus.diagram.activity.providers.ElementInitializers.
			getInstance().init_Activity_2001(activity);
	}
	
	private static void initCommunicationInteraction(Interaction interaction) {
		org.eclipse.papyrus.diagram.communication.providers.ElementInitializers.
			getInstance().init_Interaction_8002(interaction);
	}
	
	private static void initSequenceInteraction(Interaction interaction) {
		org.eclipse.papyrus.diagram.sequence.providers.ElementInitializers.
		getInstance().init_Interaction_2001(interaction);
	}
}
