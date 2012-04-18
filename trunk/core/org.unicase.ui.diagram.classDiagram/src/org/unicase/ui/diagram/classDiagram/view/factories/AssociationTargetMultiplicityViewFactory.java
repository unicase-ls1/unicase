/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.classDiagram.view.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractLabelViewFactory;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class AssociationTargetMultiplicityViewFactory extends AbstractLabelViewFactory {

	/**
	 * @generated
	 */
	public View createView(IAdaptable semanticAdapter, View containerView, String semanticHint, int index,
		boolean persisted, PreferencesHint preferencesHint) {
		Node view = (Node) super.createView(semanticAdapter, containerView, semanticHint, index, persisted,
			preferencesHint);
		return view;
	}

	/**
	 * @generated
	 */
	protected List createStyles(View view) {
		List styles = new ArrayList();
		return styles;
	}
}
