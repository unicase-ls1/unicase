package org.unicase.changetracking.ui.dialogs;

import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.workspace.util.UnicaseCommand;

public class PutIntoOrphansStrategy implements IModelElementPlacementStrategy{

	@Override
	public void placeModelElementInProject(final Project project,
			final UnicaseModelElement modelElement) {
		new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				project.addModelElement(modelElement);
			}
		}.run(false);
	}

}
