package org.unicase.ui.diagram.activityDiagram.preferences;

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
		org.unicase.ui.diagram.activityDiagram.preferences.DiagramPrintingPreferencePage.initDefaults(store);
		org.unicase.ui.diagram.activityDiagram.preferences.DiagramGeneralPreferencePage.initDefaults(store);
		org.unicase.ui.diagram.activityDiagram.preferences.DiagramAppearancePreferencePage.initDefaults(store);
		org.unicase.ui.diagram.activityDiagram.preferences.DiagramConnectionsPreferencePage.initDefaults(store);
		org.unicase.ui.diagram.activityDiagram.preferences.DiagramRulersAndGridPreferencePage.initDefaults(store);
	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return org.unicase.ui.diagram.activityDiagram.part.ModelDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
