/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.activityDiagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.ModelPackage;
import org.unicase.model.activity.ActivityPackage;

/**
 * @generated
 */
public class ModelParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser activityName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getActivityName_5001Parser() {
		if (activityName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE
					.getUnicaseModelElement_Name() };
			org.unicase.ui.diagram.activityDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.activityDiagram.parsers.MessageFormatParser(
					features);
			activityName_5001Parser = parser;
		}
		return activityName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser transitionCondition_6001Parser;

	/**
	 * @generated
	 */
	private IParser getTransitionCondition_6001Parser() {
		if (transitionCondition_6001Parser == null) {
			EAttribute[] features = new EAttribute[] { ActivityPackage.eINSTANCE
					.getTransition_Condition() };
			org.unicase.ui.diagram.activityDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.activityDiagram.parsers.MessageFormatParser(
					features);
			transitionCondition_6001Parser = parser;
		}
		return transitionCondition_6001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case org.unicase.ui.diagram.activityDiagram.edit.parts.ActivityNameEditPart.VISUAL_ID:
			return getActivityName_5001Parser();
		case org.unicase.ui.diagram.activityDiagram.edit.parts.TransitionConditionEditPart.VISUAL_ID:
			return getTransitionCondition_6001Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object,
			String parserHint) {
		return ParserService.getInstance().getParser(
				new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(org.unicase.ui.diagram.activityDiagram.part.ModelVisualIDRegistry
					.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(org.unicase.ui.diagram.activityDiagram.part.ModelVisualIDRegistry
					.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes
					.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
