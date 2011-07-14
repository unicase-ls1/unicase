package org.unicase.model.orga.diagram.providers;

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
import org.unicase.model.orga.diagram.edit.parts.EmployeeNameEditPart;
import org.unicase.model.orga.diagram.edit.parts.TeamNameEditPart;
import org.unicase.model.orga.diagram.parsers.MessageFormatParser;
import org.unicase.model.orga.diagram.part.OrgaVisualIDRegistry;

/**
 * @generated
 */
public class OrgaParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser employeeName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getEmployeeName_5001Parser() {
		if (employeeName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE
					.getUnicaseModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			employeeName_5001Parser = parser;
		}
		return employeeName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser teamName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getTeamName_5002Parser() {
		if (teamName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE
					.getUnicaseModelElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			teamName_5002Parser = parser;
		}
		return teamName_5002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case EmployeeNameEditPart.VISUAL_ID:
			return getEmployeeName_5001Parser();
		case TeamNameEditPart.VISUAL_ID:
			return getTeamName_5002Parser();
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
			return getParser(OrgaVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(OrgaVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (OrgaElementTypes.getElement(hint) == null) {
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
