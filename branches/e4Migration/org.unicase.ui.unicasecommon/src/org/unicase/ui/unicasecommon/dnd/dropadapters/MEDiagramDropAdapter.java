/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.dnd.dropadapters;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.internal.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.internal.common.model.util.ModelUtil;
import org.eclipse.gmf.runtime.common.ui.services.editor.EditorService;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.ui.part.EditorPart;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.unicasecommon.common.util.DNDHelper;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;
import org.unicase.ui.unicasecommon.diagram.commands.CreateViewCommand;

/**
 * Drop adapter for MEDiagrams.
 * 
 * @author Hodaie
 */
public class MEDiagramDropAdapter extends MEDropAdapter {
	private List<EObject> mesAdd;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.dnd.MEDropAdapter#drop(org.eclipse.swt.dnd.DropTargetEvent, EObject, java.util.List)
	 */
	@Override
	public void drop(DropTargetEvent event, final EObject target, List<EObject> source) {
		if (DNDHelper.dropMessageCheck(source, mesAdd)) {
			final ECPModelelementContext context = DNDHelper.getECPModelelementContext();
			final MEDiagram diagram = (MEDiagram) target;
			// open the editor because i need a EditPart to call the CreateViewCommand
			UnicaseActionHelper.openModelElement(target, this.getClass().getName());
			final DiagramEditor diagramEditor = getDiagramEditor(diagram);
			if (diagramEditor == null || context == null) {
				return;
			}
			LinkedList<EObject> elements = new LinkedList<EObject>();
			elements.addAll(diagram.getElements());
			mesAdd.addAll(AssociationClassHelper.getRelatedAssociationClassToDrop(mesAdd, elements,
				context.getMetaModelElementContext()));
			new EMFStoreCommand() {
				@Override
				protected void doRun() {
					int counter = 1;
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
						if (!context.getMetaModelElementContext().isAssociationClassElement(me)) {
							counter++;
						}
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
	public boolean canDrop(int eventFeedback, DropTargetEvent event, final List<EObject> source, final EObject target,
		EObject dropee) {
		mesAdd = new LinkedList<EObject>();
		return DNDHelper.canDrop(source, (MEDiagram) target, mesAdd);
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
