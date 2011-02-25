package org.unicase.workspace.impl;

import org.eclipse.emf.ecore.EObject;

public interface ResourceSaveFacility {

	void addElementToResouce(final EObject modelElement);

	void setAutoSave(boolean newValue);

	void saveDirtyResources();

}
