package org.unicase.wireframe.diagram.providers;

import org.unicase.wireframe.diagram.part.WireframeDiagramEditorPlugin;

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
		ElementInitializers cached = WireframeDiagramEditorPlugin.getInstance().getElementInitializers();
		if (cached == null) {
			WireframeDiagramEditorPlugin.getInstance().setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
