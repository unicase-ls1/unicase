package org.unicase.ui.componentDiagram.preferences;

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
		org.unicase.ui.componentDiagram.preferences.DiagramPrintingPreferencePage
				.initDefaults(store);
		org.unicase.ui.componentDiagram.preferences.DiagramGeneralPreferencePage
				.initDefaults(store);
		org.unicase.ui.componentDiagram.preferences.DiagramAppearancePreferencePage
				.initDefaults(store);
		org.unicase.ui.componentDiagram.preferences.DiagramConnectionsPreferencePage
				.initDefaults(store);
		org.unicase.ui.componentDiagram.preferences.DiagramRulersAndGridPreferencePage
				.initDefaults(store);
	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return org.unicase.ui.componentDiagram.part.ModelDiagramEditorPlugin
				.getInstance().getPreferenceStore();
	}
}
