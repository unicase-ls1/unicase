/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.dnd.dropadapters;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.ui.services.editor.EditorService;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.ui.part.EditorPart;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.common.dnd.MEDropAdapter;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;
import org.unicase.ui.unicasecommon.diagram.commands.CreateViewCommand;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Drop adapter for MEDiagrams.
 * 
 * @author Hodaie
 */
public class MEDiagramDropAdapter extends MEDropAdapter {
	private List<ModelElement> mesAdd;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.dnd.MEDropAdapter#drop(org.eclipse.swt.dnd.DropTargetEvent,
	 *      org.unicase.metamodel.ModelElement, java.util.List)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void drop(DropTargetEvent event, final ModelElement target, List<ModelElement> source) {
		int messageResult;
		if (mesAdd.size() != source.size()) {
			// if not all elements could be added
			MessageDialog dialog = new MessageDialog(null, "Confirmation", null, "Only " + mesAdd.size() + " of "
				+ source.size() + " item(s) could be added. Add item(s)?", MessageDialog.QUESTION, new String[] {
				"Yes", "No" }, 0);
			messageResult = dialog.open();
		} else {
			messageResult = MessageDialog.OK;
		}
		if (messageResult == MessageDialog.OK) {
			// open the editor because i need a EditPart to call the CreateViewCommand
			UnicaseActionHelper.openModelElement(target, this.getClass().getName());
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					MEDiagram diagram = (MEDiagram) target;
					int counter = 1;
					DiagramEditor diagramEditor = getDiagramEditor(diagram);
					if (diagramEditor == null) {
						return;
					}
					for (EObject me : mesAdd) {
						// add reference to the element
						diagram.getElements().add((UnicaseModelElement) me);
						// create the View for the element
						CreateViewCommand command = new CreateViewCommand(new EObjectAdapter(me),
							diagramEditor.getDiagramEditPart(), new Point(20 * counter, 20 * counter),
							PreferencesHint.USE_DEFAULTS);
						try {
							command.execute(null, null);
						} catch (ExecutionException e) {
							ModelUtil.logException("Could not create a view for the droped content.", e);
						}
						counter++;
					}
				}
			}.run();
		}
		mesAdd = null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.dnd.MEDropAdapter#canDrop(org.eclipse.swt.dnd.DropTargetEvent, java.util.List,
	 *      org.unicase.metamodel.UnicaseModelElement, org.unicase.metamodel.UnicaseModelElement)
	 */
	@Override
	public boolean canDrop(int eventFeedback, DropTargetEvent event, final List<ModelElement> source,
		final ModelElement target, ModelElement dropee) {
		if (!source.isEmpty()) {
			MEDiagram diagram = (MEDiagram) target;
			mesAdd = new ArrayList<ModelElement>();
			for (ModelElement me : source) {
				// do not add elements that are already added and check if they are allowed for the diagram
				if (!diagram.getElements().contains(me) && isAllowedType(diagram, me)) {
					mesAdd.add(me);
				}
			}
			if (!mesAdd.isEmpty()) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	private boolean isAllowedType(MEDiagram diagram, ModelElement dropee) {
		// get all registered contexts
		Set<IClientContext> clientContexts = ClientContextManager.getInstance().getClientContexts();
		for (IClientContext clientContext : clientContexts) {
			IElementType[] containedTypes = ElementTypeRegistry.getInstance().getElementTypes(clientContext);
			IElementType diagramType = ElementTypeRegistry.getInstance().getElementType(diagram, clientContext);
			IElementType dropeeType = ElementTypeRegistry.getInstance().getElementType(dropee, clientContext);
			boolean containedDropee = false;
			boolean containedDiagram = false;
			// checks all types in a given context if they contain the diagram and the dropped element
			for (IElementType containedType : containedTypes) {
				if (containedType.equals(diagramType)) {
					containedDiagram = true;
				}
				if (containedType.equals(dropeeType)) {
					containedDropee = true;
				}
			}
			if (containedDiagram && containedDropee) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	private DiagramEditor getDiagramEditor(MEDiagram diagram) {
		if (diagram != null) {
			// checks all editors if they contain the diagram
			List<EditorPart> editors = EditorService.getInstance().getRegisteredEditorParts();
			for (EditorPart editor : editors) {
				if (editor instanceof DiagramEditor) {
					if (((DiagramEditor) editor).getDiagram().equals(diagram.getGmfdiagram())) {
						return (DiagramEditor) editor;
					}
				}
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.unicasecommon.dnd.dropadapters.UCDropAdapter#isDropAdapterfor()
	 */
	@Override
	public EClass isDropAdapterfor() {
		return DiagramPackage.eINSTANCE.getMEDiagram();
	}
}
