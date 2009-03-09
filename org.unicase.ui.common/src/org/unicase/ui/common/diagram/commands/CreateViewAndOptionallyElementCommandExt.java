package org.unicase.ui.common.diagram.commands;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateViewAndOptionallyElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;

public class CreateViewAndOptionallyElementCommandExt extends CreateViewAndOptionallyElementCommand {

	public CreateViewAndOptionallyElementCommandExt(IAdaptable elementAdapter, IGraphicalEditPart containerEP,
		Point location, PreferencesHint preferencesHint) {
		super(elementAdapter, containerEP, location, preferencesHint);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean useExistingView(View view) {
		return true;
	}

}
