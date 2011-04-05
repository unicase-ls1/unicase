package org.unicase.changetracking.ui.dialogs;

import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;

public interface IModelElementPlacementStrategy {

	void placeModelElementInProject(Project project, UnicaseModelElement modelElement);
	
}
