/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.stateDiagram.parsers;

import java.util.Arrays;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;

/**
 * @generated
 */
public class NativeParser extends org.unicase.ui.diagram.stateDiagram.parsers.AbstractParser {

	/**
	 * @generated
	 */
	public NativeParser(EAttribute[] features) {
		super(features);
		if (features.length != 1) {
			throw new IllegalArgumentException(Arrays.toString(features));
		}
	}

	/**
	 * @generated
	 */
	protected EAttribute getAttribute() {
		return features[0];
	}

	/**
	 * @generated
	 */
	public String getPrintString(IAdaptable adapter, int flags) {
		EObject element = (EObject) adapter.getAdapter(EObject.class);
		EAttribute feature = getAttribute();
		String s = EcoreUtil.convertToString(feature.getEAttributeType(), element.eGet(feature));
		return s != null ? s : ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public String getEditString(IAdaptable adapter, int flags) {
		return getPrintString(adapter, flags);
	}

	/**
	 * @generated
	 */
	public IParserEditStatus isValidEditString(IAdaptable adapter, String editString) {
		return ParserEditStatus.EDITABLE_STATUS;
	}

	/**
	 * @generated
	 */
	public ICommand getParseCommand(IAdaptable adapter, String newString, int flags) {
		EAttribute feature = getAttribute();
		Object value = EcoreUtil.createFromString(feature.getEAttributeType(), newString);
		return getParseCommand(adapter, new Object[] { value }, flags);
	}
}
