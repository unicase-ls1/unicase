package org.unicase.uiModeling.diagram.providers;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	 * @generated
	 */
	public static ElementInitializers getInstance() {
		ElementInitializers cached = org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance()
			.getElementInitializers();
		if (cached == null) {
			org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().setElementInitializers(
				cached = new ElementInitializers());
		}
		return cached;
	}
}
