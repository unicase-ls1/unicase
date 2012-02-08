/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.diagram.part;

import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.diagram.statemachine.CreateStateMachineDiagramCommand;
import org.eclipse.papyrus.diagram.statemachine.custom.helpers.Zone;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineCompartmentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.papyrus.umlutils.NamedElementUtil;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.UMLFactory;
import org.unicase.papyrus.UMLModel;

/**
 * Command to initialize Papyrus state machine diagrams.
 * 
 * @author mharut
 */
public class StateMachineInitCommand extends ECPCommand {

	private UMLModel model;
	private Diagram diagram;
	private StateMachine stateMachine;

	/**
	 * Creates a new initialization command.
	 * 
	 * @param model the model that requires initialization
	 * @param diagram the corresponding GMF-Diagram
	 * @param stateMachine the state machine instance of the diagram
	 */
	public StateMachineInitCommand(UMLModel model, Diagram diagram, StateMachine stateMachine) {
		super(model);
		this.model = model;
		this.diagram = diagram;
		this.stateMachine = stateMachine;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doRun() {
		model.setGmfDiagram(diagram);
		model.getPackagedElements().add(stateMachine);

		org.eclipse.papyrus.diagram.statemachine.providers.ElementInitializers.getInstance().init_StateMachine_2000(
			stateMachine);

		int defaultX = CreateStateMachineDiagramCommand.defaultX;
		int defaultY = CreateStateMachineDiagramCommand.defaultY;
		int defaultWidth = CreateStateMachineDiagramCommand.defaultWidth;
		int defaultHeight = CreateStateMachineDiagramCommand.defaultHeight;
		int defaultHeader = CreateStateMachineDiagramCommand.defaultHeader;

		View stateMachineView = ViewService.getInstance().createView(Node.class, new EObjectAdapter(stateMachine),
			model.getGmfDiagram(), null, ViewUtil.APPEND, true, UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
		Zone.setX(stateMachineView, defaultX);
		Zone.setY(stateMachineView, defaultY);
		Zone.setWidth(stateMachineView, defaultWidth);
		Zone.setHeight(stateMachineView, defaultHeight);

		View compartmentView = null;

		Iterator<Node> it = stateMachineView.getChildren().iterator();

		while (it.hasNext()) {
			Node currentNode = it.next();
			if (currentNode.getLayoutConstraint() == null) {
				currentNode.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
			}
			if (UMLVisualIDRegistry.getVisualID(currentNode.getType()) == StateMachineNameEditPart.VISUAL_ID) {
				Zone.setWidth(currentNode, defaultWidth);
				Zone.setHeight(currentNode, defaultHeader);
			} else if (UMLVisualIDRegistry.getVisualID(currentNode.getType()) == StateMachineCompartmentEditPart.VISUAL_ID) {
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
		String semanticHint = ((IHintedType) UMLElementTypes.Region_3000).getSemanticHint();

		if (compartmentView != null) {
			Node regionNode = ViewService.getInstance().createNode(regionAdaptable, compartmentView, semanticHint,
				ViewUtil.APPEND, UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			if (regionNode.getLayoutConstraint() == null) {
				regionNode.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
			}
			// add region specifics
			Zone.createRegionDefaultAnnotation(regionNode);
			Zone.setWidth(regionNode, defaultWidth);
			Zone.setHeight(regionNode, defaultHeight - defaultHeader);

		}

	}

}
