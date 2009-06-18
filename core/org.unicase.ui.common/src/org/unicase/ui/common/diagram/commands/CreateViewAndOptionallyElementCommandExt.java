/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.diagram.commands;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateViewAndOptionallyElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This commmand is executed when the users chooses CreateLinkFrom/To existing element
 * This implementation overrides the {@link #useExistingView(View)} method  because we don't want to display the message
 * box of the GMF implementation.
 * @author denglerm
 */
public class CreateViewAndOptionallyElementCommandExt extends CreateViewAndOptionallyElementCommand {

	/**
	 * Creates a new <code>CreateViewAndOptionallyElementCommand</code>.
	 * 
	 * @param elementAdapter
	 *            Adapts to the element, if null at command execution time, an
	 *            element is to be created.
	 * @param containerEP
	 *            The container edit part, where the view request is sent.
	 * @param location
	 *            The location to create the new view. If null, a default
	 *            location is used
	 * @param preferencesHint
	 *            The preference hint that is to be used to find the appropriate
	 *            preference store from which to retrieve diagram preference
	 *            values. The preference hint is mapped to a preference store in
	 *            the preference registry <@link DiagramPreferencesRegistry>.
	 */
	public CreateViewAndOptionallyElementCommandExt(IAdaptable elementAdapter, IGraphicalEditPart containerEP,
		Point location, PreferencesHint preferencesHint) {
		super(elementAdapter, containerEP, location, preferencesHint);
	}

	/**.
	 * ({@inheritDoc})
	 */
	@Override
	protected boolean useExistingView(View view) {
		return true;
	}

}
