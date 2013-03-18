package org.unicase.uiModeling.diagram.preferences;

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
		org.unicase.uiModeling.diagram.preferences.DiagramGeneralPreferencePage.initDefaults(store);
		org.unicase.uiModeling.diagram.preferences.DiagramAppearancePreferencePage.initDefaults(store);
		org.unicase.uiModeling.diagram.preferences.DiagramConnectionsPreferencePage.initDefaults(store);
		org.unicase.uiModeling.diagram.preferences.DiagramPrintingPreferencePage.initDefaults(store);
		org.unicase.uiModeling.diagram.preferences.DiagramRulersAndGridPreferencePage.initDefaults(store);
	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
