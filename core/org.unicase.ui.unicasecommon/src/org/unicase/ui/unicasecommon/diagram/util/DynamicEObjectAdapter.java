/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.diagram.util;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.ui.common.util.CollectionFilter;

/**
 * @author schroech
 */
/**
 * @author schroech
 */
public class DynamicEObjectAdapter implements IAdaptable {

	private EditPart editPart;
	private View view;
	private final EObject object;
	private final DiagramEditPart host;

	/**
	 * @param object The object which should be adapted
	 * @param host The {@link DiagramEditPart} which will be asked for the {@link View} of the object
	 */
	public DynamicEObjectAdapter(EObject object, DiagramEditPart host) {
		if (object == null) {
			throw new IllegalArgumentException();
		}

		if (host == null) {
			throw new IllegalArgumentException();
		}

		this.object = object;
		this.host = host;
	}

	/**
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 * @param adapter the adapter class to look up
	 * @return a object castable to the given class, or the view of the {@link EditPart} associated with the object in
	 *         the context of the host
	 */
	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
		if (adapter.isInstance(getView())) {
			return getView();
		}

		if (adapter.isInstance(getEditPart())) {
			return getEditPart();
		}

		if (adapter.isInstance(object)) {
			return object;
		}

		if (adapter.isInstance(this)) {
			return this;
		}

		return null;
	}

	/**
	 * @return The host
	 */
	public DiagramEditPart getHost() {
		return host;
	}

	/**
	 * @return The object
	 */
	public EObject getObject() {
		return object;
	}

	/**
	 * @return The view
	 */
	public View getView() {
		if (view == null) {

			if (getEditPart() != null) {
				view = EditPartUtility.getView(getEditPart());
			}
		}
		return view;
	}

	/**
	 * @return The editpart
	 */
	public EditPart getEditPart() {
		if (editPart == null) {
			if (getObject() != null) {
				Set<EditPart> editParts = EditPartUtility.findEditParts(getHost(), Collections.singleton(getObject()));
				List<ShapeNodeEditPart> shapeNodeEditParts = CollectionFilter
					.filter(editParts, ShapeNodeEditPart.class);

				List<ConnectionEditPart> connectionEditParts = CollectionFilter.filter(editParts,
					ConnectionEditPart.class);

				if (shapeNodeEditParts.size() > 0) {
					editPart = shapeNodeEditParts.get(0);
				} else if (connectionEditParts.size() > 0) {
					editPart = connectionEditParts.get(0);
				}
			}
		}
		return editPart;
	}

}
