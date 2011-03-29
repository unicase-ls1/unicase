package scrm.diagram.providers;

import scrm.diagram.part.ScrmDiagramEditorPlugin;

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
		ElementInitializers cached = ScrmDiagramEditorPlugin.getInstance()
				.getElementInitializers();
		if (cached == null) {
			ScrmDiagramEditorPlugin.getInstance().setElementInitializers(
					cached = new ElementInitializers());
		}
		return cached;
	}

}
