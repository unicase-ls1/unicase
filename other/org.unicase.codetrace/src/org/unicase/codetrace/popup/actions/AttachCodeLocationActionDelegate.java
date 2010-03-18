package org.unicase.codetrace.popup.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.source.IVerticalRulerInfo;
import org.eclipse.ui.texteditor.AbstractRulerActionDelegate;
import org.eclipse.ui.texteditor.ITextEditor;

public class AttachCodeLocationActionDelegate extends AbstractRulerActionDelegate{

	@Override
	protected IAction createAction(ITextEditor editor, IVerticalRulerInfo rulerInfo) {
		return new AttachLocationAction(editor, rulerInfo);
	}

}
