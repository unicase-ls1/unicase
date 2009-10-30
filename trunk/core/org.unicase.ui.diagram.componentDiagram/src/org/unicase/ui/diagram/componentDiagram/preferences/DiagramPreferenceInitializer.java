package org.unicase.ui.diagram.componentDiagram.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * @generated
	 */
	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		org.unicase.ui.diagram.componentDiagram.preferences.DiagramPrintingPreferencePage.initDefaults(store);
		org.unicase.ui.diagram.componentDiagram.preferences.DiagramGeneralPreferencePage.initDefaults(store);
		org.unicase.ui.diagram.componentDiagram.preferences.DiagramAppearancePreferencePage.initDefaults(store);
		org.unicase.ui.diagram.componentDiagram.preferences.DiagramConnectionsPreferencePage.initDefaults(store);
		org.unicase.ui.diagram.componentDiagram.preferences.DiagramRulersAndGridPreferencePage.initDefaults(store);
	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return org.unicase.ui.diagram.componentDiagram.part.ModelDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
