/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.stateDiagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.ModelPackage;
import org.unicase.model.state.StatePackage;

/**
 * @generated
 */
public class ModelParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser stateName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getStateName_5001Parser() {
		if (stateName_5001Parser == null) {
			stateName_5001Parser = createStateName_5001Parser();
		}
		return stateName_5001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStateName_5001Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name(), };
		org.unicase.ui.diagram.stateDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.stateDiagram.parsers.MessageFormatParser(
			features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser stateEntryConditions_5002Parser;

	/**
	 * @generated
	 */
	private IParser getStateEntryConditions_5002Parser() {
		if (stateEntryConditions_5002Parser == null) {
			stateEntryConditions_5002Parser = createStateEntryConditions_5002Parser();
		}
		return stateEntryConditions_5002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStateEntryConditions_5002Parser() {
		EAttribute[] features = new EAttribute[] { StatePackage.eINSTANCE.getState_EntryConditions(), };
		org.unicase.ui.diagram.stateDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.stateDiagram.parsers.MessageFormatParser(
			features);
		parser.setViewPattern("ENTRY/{0}");
		parser.setEditorPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser stateActivities_5003Parser;

	/**
	 * @generated
	 */
	private IParser getStateActivities_5003Parser() {
		if (stateActivities_5003Parser == null) {
			stateActivities_5003Parser = createStateActivities_5003Parser();
		}
		return stateActivities_5003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStateActivities_5003Parser() {
		EAttribute[] features = new EAttribute[] { StatePackage.eINSTANCE.getState_Activities(), };
		org.unicase.ui.diagram.stateDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.stateDiagram.parsers.MessageFormatParser(
			features);
		parser.setViewPattern("DO/{0}");
		parser.setEditorPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser stateExitConditions_5004Parser;

	/**
	 * @generated
	 */
	private IParser getStateExitConditions_5004Parser() {
		if (stateExitConditions_5004Parser == null) {
			stateExitConditions_5004Parser = createStateExitConditions_5004Parser();
		}
		return stateExitConditions_5004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStateExitConditions_5004Parser() {
		EAttribute[] features = new EAttribute[] { StatePackage.eINSTANCE.getState_ExitConditions(), };
		org.unicase.ui.diagram.stateDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.stateDiagram.parsers.MessageFormatParser(
			features);
		parser.setViewPattern("EXIT/{0}");
		parser.setEditorPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser transitionName_6001Parser;

	/**
	 * @generated
	 */
	private IParser getTransitionName_6001Parser() {
		if (transitionName_6001Parser == null) {
			transitionName_6001Parser = createTransitionName_6001Parser();
		}
		return transitionName_6001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createTransitionName_6001Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getUnicaseModelElement_Name(), };
		org.unicase.ui.diagram.stateDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.stateDiagram.parsers.MessageFormatParser(
			features);
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case org.unicase.ui.diagram.stateDiagram.edit.parts.StateNameEditPart.VISUAL_ID:
			return getStateName_5001Parser();
		case org.unicase.ui.diagram.stateDiagram.edit.parts.StateEntryConditionsEditPart.VISUAL_ID:
			return getStateEntryConditions_5002Parser();
		case org.unicase.ui.diagram.stateDiagram.edit.parts.StateActivitiesEditPart.VISUAL_ID:
			return getStateActivities_5003Parser();
		case org.unicase.ui.diagram.stateDiagram.edit.parts.StateExitConditionsEditPart.VISUAL_ID:
			return getStateExitConditions_5004Parser();
		case org.unicase.ui.diagram.stateDiagram.edit.parts.TransitionNameEditPart.VISUAL_ID:
			return getTransitionName_6001Parser();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(org.unicase.ui.diagram.stateDiagram.part.ModelVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static class HintAdapter extends ParserHintAdapter {

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
		@Override
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
