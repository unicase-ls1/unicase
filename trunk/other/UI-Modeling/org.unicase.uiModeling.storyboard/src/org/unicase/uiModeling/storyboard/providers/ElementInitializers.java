/*
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling.storyboard.providers;


/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	 * @generated
	 */
	public static ElementInitializers getInstance() {
		ElementInitializers cached = org.unicase.uiModeling.storyboard.part.StoryboardDiagramEditorPlugin.getInstance()
			.getElementInitializers();
		if (cached == null) {
			org.unicase.uiModeling.storyboard.part.StoryboardDiagramEditorPlugin.getInstance().setElementInitializers(
				cached = new ElementInitializers());
		}
		return cached;
	}
}
