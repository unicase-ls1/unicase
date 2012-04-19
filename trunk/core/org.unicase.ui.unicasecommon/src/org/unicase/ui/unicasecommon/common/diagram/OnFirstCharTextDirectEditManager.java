/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.diagram;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;

/**
 * @author schroech A {@link TextDirectEditManager} starting editing at the very first entered char. A revolution!
 */
public class OnFirstCharTextDirectEditManager extends TextDirectEditManager {

	/**
	 * Constructs a new OnFirstCharTextDirectEditManager for the given source edit part. The cell editor will be created
	 * by instantiating the type <i>editorType</i>. The cell editor will be placed using the given CellEditorLocator.
	 * 
	 * @param source the source edit part
	 * @param editorType the cell editor type
	 * @param locator the locator
	 */
	@SuppressWarnings("unchecked")
	public OnFirstCharTextDirectEditManager(GraphicalEditPart source, Class editorType, CellEditorLocator locator) {
		super(source, editorType, locator);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager#show(char) Overrides the superclass
	 *      behaviour: if (SWT.getPlatform() != "carbon") { setEditText(initialString.toString()); } which translates
	 *      to: if (SWT.getPlatform() != "Mac OS X") { behaveLikeShit(); } so that typing in text field does not require
	 *      ttyping eevery ffirst lletter ttwice.
	 * @param initialChar The very first char being entered.
	 */
	@Override
	public void show(char initialChar) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(initialChar);
		show();
		setEditText(stringBuffer.toString());
	}

}
