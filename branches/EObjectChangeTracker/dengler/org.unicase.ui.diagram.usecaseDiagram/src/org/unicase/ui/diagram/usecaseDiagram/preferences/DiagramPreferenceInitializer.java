package org.unicase.ui.diagram.usecaseDiagram.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * @generated
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		org.unicase.ui.diagram.usecaseDiagram.preferences.DiagramPrintingPreferencePage
				.initDefaults(store);
		org.unicase.ui.diagram.usecaseDiagram.preferences.DiagramGeneralPreferencePage
				.initDefaults(store);
		org.unicase.ui.diagram.usecaseDiagram.preferences.DiagramAppearancePreferencePage
				.initDefaults(store);
		org.unicase.ui.diagram.usecaseDiagram.preferences.DiagramConnectionsPreferencePage
				.initDefaults(store);
		org.unicase.ui.diagram.usecaseDiagram.preferences.DiagramRulersAndGridPreferencePage
				.initDefaults(store);
	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return org.unicase.ui.diagram.usecaseDiagram.part.ModelDiagramEditorPlugin
				.getInstance().getPreferenceStore();
	}
}
