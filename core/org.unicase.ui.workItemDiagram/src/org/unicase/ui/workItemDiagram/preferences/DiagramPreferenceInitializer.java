package org.unicase.ui.workItemDiagram.preferences;

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
		org.unicase.ui.workItemDiagram.preferences.DiagramPrintingPreferencePage
				.initDefaults(store);
		org.unicase.ui.workItemDiagram.preferences.DiagramGeneralPreferencePage
				.initDefaults(store);
		org.unicase.ui.workItemDiagram.preferences.DiagramAppearancePreferencePage
				.initDefaults(store);
		org.unicase.ui.workItemDiagram.preferences.DiagramConnectionsPreferencePage
				.initDefaults(store);
		org.unicase.ui.workItemDiagram.preferences.DiagramRulersAndGridPreferencePage
				.initDefaults(store);
	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return org.unicase.ui.workItemDiagram.part.ModelDiagramEditorPlugin
				.getInstance().getPreferenceStore();
	}
}
