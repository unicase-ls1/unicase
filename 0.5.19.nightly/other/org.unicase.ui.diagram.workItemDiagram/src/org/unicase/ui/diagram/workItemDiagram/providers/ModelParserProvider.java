package org.unicase.ui.diagram.workItemDiagram.providers;

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

/**
 * @generated
 */
public class ModelParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser actionItemName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getActionItemName_5001Parser() {
		if (actionItemName_5001Parser == null) {
			actionItemName_5001Parser = createActionItemName_5001Parser();
		}
		return actionItemName_5001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createActionItemName_5001Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE
				.getUnicaseModelElement_Name(), };
		org.unicase.ui.diagram.workItemDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.workItemDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser issueName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getIssueName_5002Parser() {
		if (issueName_5002Parser == null) {
			issueName_5002Parser = createIssueName_5002Parser();
		}
		return issueName_5002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createIssueName_5002Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE
				.getUnicaseModelElement_Name(), };
		org.unicase.ui.diagram.workItemDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.workItemDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser bugReportName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getBugReportName_5003Parser() {
		if (bugReportName_5003Parser == null) {
			bugReportName_5003Parser = createBugReportName_5003Parser();
		}
		return bugReportName_5003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createBugReportName_5003Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE
				.getUnicaseModelElement_Name(), };
		org.unicase.ui.diagram.workItemDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.diagram.workItemDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case org.unicase.ui.diagram.workItemDiagram.edit.parts.ActionItemNameEditPart.VISUAL_ID:
			return getActionItemName_5001Parser();
		case org.unicase.ui.diagram.workItemDiagram.edit.parts.IssueNameEditPart.VISUAL_ID:
			return getIssueName_5002Parser();
		case org.unicase.ui.diagram.workItemDiagram.edit.parts.BugReportNameEditPart.VISUAL_ID:
			return getBugReportName_5003Parser();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(org.unicase.ui.diagram.workItemDiagram.part.ModelVisualIDRegistry
					.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(org.unicase.ui.diagram.workItemDiagram.part.ModelVisualIDRegistry
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
			if (org.unicase.ui.diagram.workItemDiagram.providers.ModelElementTypes
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
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
