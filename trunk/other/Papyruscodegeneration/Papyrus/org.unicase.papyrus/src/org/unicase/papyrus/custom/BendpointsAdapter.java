/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.custom;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.gmf.runtime.notation.Bendpoints;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.unicase.model.diagram.DiagramFactory;
import org.unicase.model.diagram.MERelativeBendpoints;

/**
 * Adapter that will exchange {@link RelativeBendpoints} with {@link MERelativeBendpoints} for all edges in a
 * {@link Diagram} to allow diagrams to be serialized.
 * 
 * @author mharut
 */
public class BendpointsAdapter extends AdapterImpl {

	private final Diagram gmfDiagram;

	/**
	 * Constructs a new adapter with a diagram to handle.
	 * 
	 * @param gmfDiagram the {@link Diagram} to exchange edges for
	 */
	public BendpointsAdapter(Diagram gmfDiagram) {
		super();
		this.gmfDiagram = gmfDiagram;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);

		// for all edges...
		for (Object object : gmfDiagram.getEdges()) {
			if (object instanceof Edge) {

				Edge edge = (Edge) object;
				Bendpoints bendpoints = edge.getBendpoints();

				// check if bendpoints need to be exchanged
				if (bendpoints instanceof RelativeBendpoints && !(bendpoints instanceof MERelativeBendpoints)) {
					// pass the old bendpoints's values to the new bendpoints
					List oldPoints = ((RelativeBendpoints) bendpoints).getPoints();
					MERelativeBendpoints newBendpoints = DiagramFactory.eINSTANCE.createMERelativeBendpoints();
					newBendpoints.setPoints(oldPoints);
					edge.setBendpoints(newBendpoints);
				}

			}
		}
	}

}
