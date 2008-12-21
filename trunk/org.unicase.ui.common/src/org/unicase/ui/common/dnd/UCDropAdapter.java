/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */

package org.unicase.ui.common.dnd;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.TreeItem;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.ui.common.dnd.dropadapters.MEDropAdapter;

/**
 * This is the central drop adapter for unicase views. This class acts as a
 * dispatcher. It has a map of (EClass, MEDropAdapter) which contains a
 * reference to a specific drop adapter for each model element type.
 * 
 * 
 * @author Hodaie
 * 
 */
public class UCDropAdapter extends DropTargetAdapter {

	private TransactionalEditingDomain domain;
	private Viewer viewer;

	private List<ModelElement> source;
	private ModelElement target;
	private ModelElement dropee;

	private Map<EClass, MEDropAdapter> dropAdapters;

	/**
	 * this is used for performance, so that drop method do not need to find the
	 * appropriate drop adapter again.
	 */
	private MEDropAdapter targetDropAdapter;

	/**
	 * Actually I should be able to get event feedback from event.feedback But
	 * the problem is, the event feedback is correctly set in helper() method,
	 * but in drop() method it is set to 1 (only selection). That's why I save
	 * event feedback at the end of helper() in a variable, and check this
	 * variable in drop() instead of event.feedback
	 */
	//private int eventFeedback;

	/**
	 * Constructor.
	 * 
	 * @param editingDomain
	 *            editing domain
	 * @param viewer
	 *            viewer
	 */
	public UCDropAdapter(TransactionalEditingDomain editingDomain,
			TreeViewer viewer) {

		super();
		this.domain = editingDomain;
		this.viewer = viewer;

		dropAdapters = new HashMap<EClass, MEDropAdapter>();
		
		//MEDropAdapter
		dropAdapters.put(ModelPackage.eINSTANCE.getModelElement(),
				new MEDropAdapter(domain));
		
		//LeafSectionDropAdapter
		
		//CompositeSectionDropAdapter
		
		//WorkPackageDropAdapter
		
		//MeetingDropAdpater
		
		//WorkItemMeetingSectionDropAdapter
		
		//MEDiagramDropAdapter
		
		

	}

	/**
	 * 
	 * 
	 * @param event
	 *            DropTargetEvent
	 */
	@Override
	public void drop(DropTargetEvent event) {

		targetDropAdapter.drop(event, target, source);
	}

	/**
	 * This is called continually from dragOver() event handler. This checks
	 * drop target and drop source to be not Null, and sets the target, source,
	 * and dropee fields.
	 * 
	 * @param event
	 *            DropTargetEvent
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private boolean extractDnDSourceAndTarget(DropTargetEvent event) {
		boolean result = true;
		List<Object> tmpSource = (List<Object>) DragSourcePlaceHolder
				.getDragSource();
		if (tmpSource == null) {
			result = false;
		}

		for (Object obj : tmpSource) {
			if (!(obj instanceof ModelElement)) {
				result = false;
			}
		}

		source = (List<ModelElement>) DragSourcePlaceHolder.getDragSource();

		// take care that you cannot drop anything on project (project is not a
		// ModelElement)
		if (event.item == null || event.item.getData() == null
				|| !(event.item.getData() instanceof ModelElement)) {
			result = false;
		}

		// check if source and target are in the same project
		if (result) {
			dropee = source.get(0);
			target = (ModelElement) event.item.getData();
			if (!target.getProject().equals(dropee.getProject())) {
				result = false;
			}
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dragOver(DropTargetEvent event) {
		event.detail = DND.DROP_COPY;
		if (!extractDnDSourceAndTarget(event)) {
			event.detail = DND.DROP_NONE;
			return;
		}

		setInitialEventFeedback(event);
		//eventFeedback = event.feedback;
		
		targetDropAdapter = getTargetDropAdapter(target.eClass());
		if (!targetDropAdapter.canDrop(event, source, target, dropee)) {
			event.detail = DND.DROP_NONE;
		}

	}

	/**
	 * This method searches drop adaptors map recursively to find the
	 * appropriate drop adapter for this model element type or one of its super
	 * types in model hierarchy.
	 * 
	 * @param targetEClass
	 * @return specific drop target for this model element type or one of its
	 *         super types in model hierarchy.
	 */
	private MEDropAdapter getTargetDropAdapter(EClass targetEClass) {

		MEDropAdapter ret = dropAdapters.get(targetEClass);
		if (ret == null) {
			ret = getTargetDropAdapter(getSuperTypeHavingADropAdapter(targetEClass
					.getESuperTypes()));
		}

		return ret;
	}

	/**
	 * This is used by getDropTarget() method. It takes super classes of
	 * targetEClass and tries to find a unique drop adapter that matches one of
	 * super types. If there are more than one matching drop adapters, an
	 * exception is thrown. If there is no matching drop adapter, this method
	 * searches recursively until it finds one, or throws the exception.
	 * 
	 * @param superClazz
	 *            super classes of targetEClass. If there is no match at the
	 *            first call of method, this will be a collection of super
	 *            classes of each input super class.
	 * @return an EClass that is both super class of targetEClass (directly of
	 *         indirectly) and has a drop adapter.
	 */
	private EClass getSuperTypeHavingADropAdapter(Collection<EClass> superClazz) {

		EClass ret = null;

		Set<EClass> intersection = new HashSet<EClass>(dropAdapters.keySet());
		intersection.retainAll(superClazz);

		if (intersection.size() > 1) {
			throw new IllegalStateException(
					"More than one drop adapter for this type found!");
		} else if (intersection.size() == 0) {
			Set<EClass> eclazz = new HashSet<EClass>();
			for (EClass superClass : superClazz) {
				eclazz.addAll(superClass.getESuperTypes());
			}
			ret = getSuperTypeHavingADropAdapter(eclazz);
		} else {
			ret = (EClass) intersection.toArray()[0];
		}

		return ret;
	}

	/**
	 * This sets the initial event feedback, and is also responsible for showing
	 * INSERT_AFTER and INSERT_BEFORE feedbacks according to mouse cursor
	 * position.
	 * 
	 * @param event
	 *            DropTargetEvent
	 */
	private void setInitialEventFeedback(DropTargetEvent event) {
		event.feedback = DND.FEEDBACK_SELECT;

		if (event.item != null) {
			Rectangle rect = ((TreeItem) event.item).getBounds();
			Point pt = viewer.getControl().toControl(event.x, event.y);
			if (pt.y < rect.y + 5) {
				event.feedback = DND.FEEDBACK_INSERT_BEFORE;
			}
			if (pt.y > rect.y + rect.height - 5) {
				event.feedback = DND.FEEDBACK_INSERT_AFTER;
			}

		}
		event.feedback |= DND.FEEDBACK_SCROLL | DND.FEEDBACK_EXPAND;
	}

}
