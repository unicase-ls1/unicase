package org.unicase.papyrus.own;

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
import org.eclipse.papyrus.diagram.statemachine.providers.ElementInitializers;
import org.eclipse.papyrus.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseDiagramEditPart;
import org.eclipse.papyrus.umlutils.NamedElementUtil;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.UMLFactory;
import org.unicase.papyrus.UMLModel;
import org.unicase.workspace.util.UnicaseCommand;

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
				initializeStateMachine(model, UMLFactory.eINSTANCE.createStateMachine(),
						org.eclipse.papyrus.diagram.statemachine.edit.parts.PackageEditPart.MODEL_ID, 
						org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				break;
			case USE_CASE:
				defaultInitialization(model, UMLFactory.eINSTANCE.createInteraction(),
						UseCaseDiagramEditPart.MODEL_ID, 
						org.eclipse.papyrus.diagram.usecase.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				break;
			default:
				throw new IllegalArgumentException("Diagram type not supported!");
		}
	}
	
	private static void defaultInitialization(final UMLModel model,
			final PackageableElement element, 
			final String id, final PreferencesHint hint) {
		final Diagram diagram = ViewService.createDiagram(model, id, hint);
		diagram.setElement(model);
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				model.setGmfDiagram(diagram);
				if(element != null) {
					model.getPackagedElements().add(element);
					ViewService.getInstance().createView(org.eclipse.gmf.runtime.notation.Node.class, new EObjectAdapter(element), diagram, null, ViewUtil.APPEND, true, hint);
				}
			}
		}.run(true);
	}
	
	private static void initializeStateMachine(final UMLModel model,
			final StateMachine stateMachine,
			final String id, final PreferencesHint hint) {
		
		final Diagram diagram = ViewService.createDiagram(model, id, hint);
		
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				model.setGmfDiagram(diagram);
				model.getPackagedElements().add(stateMachine);
				
				ElementInitializers.getInstance().init_StateMachine_2000(stateMachine);
				
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
}
