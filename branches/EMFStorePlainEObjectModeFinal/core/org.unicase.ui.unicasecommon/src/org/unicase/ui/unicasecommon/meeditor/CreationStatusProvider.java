/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.meeditor;

import java.text.SimpleDateFormat;

import org.eclipse.emf.ecore.EObject;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.meeditor.StatusMessageProvider;

/**
 * Creates a status message for meeditor including the creator and the creation date.
 * 
 * @author helming
 */
public class CreationStatusProvider implements StatusMessageProvider {
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.meeditor.StatusMessageProvider#canRender(org.eclipse.emf.ecore.EObject)
	 */
	public int canRender(EObject modelelement) {
		if (modelelement instanceof UnicaseModelElement) {
			return 1;
		}
		return 0;
	}

	/**
	 * Builds status from creator and creation date.
	 * 
	 * @see org.unicase.ui.meeditor.StatusMessageProvider#getMessage(org.eclipse.emf.ecore.EObject) @ the status string
	 * @return the status string
	 * @param modelElement the model element
	 */
	public String getMessage(EObject modelElement) {
		if (!(modelElement instanceof UnicaseModelElement)) {
			throw new IllegalArgumentException();
		}
		UnicaseModelElement unicaseModelElement = (UnicaseModelElement) modelElement;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		StringBuffer stringBuffer = new StringBuffer();
		// TODO: PlainEObjectMode, getCreationDate
		// Date creationDate = unicaseModelElement.getCreationDate();
		String creatorHint = "";
		// if (creationDate != null) {
		// creationDate = unicaseModelElement.getCreationDate();
		// stringBuffer.append("Created on ");
		// stringBuffer.append(dateFormat.format(creationDate));
		// stringBuffer.append(" at ");
		// stringBuffer.append(timeFormat.format(creationDate));
		// stringBuffer.append(" by ");
		// stringBuffer.append(unicaseModelElement.getCreator());
		// creatorHint = stringBuffer.toString();
		// }
		return creatorHint;
	}

}
