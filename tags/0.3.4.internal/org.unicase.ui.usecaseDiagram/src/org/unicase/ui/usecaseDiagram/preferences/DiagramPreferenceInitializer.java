/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.usecaseDiagram.preferences;

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
		org.unicase.ui.usecaseDiagram.preferences.DiagramPrintingPreferencePage.initDefaults(store);
		org.unicase.ui.usecaseDiagram.preferences.DiagramGeneralPreferencePage.initDefaults(store);
		org.unicase.ui.usecaseDiagram.preferences.DiagramAppearancePreferencePage.initDefaults(store);
		org.unicase.ui.usecaseDiagram.preferences.DiagramConnectionsPreferencePage.initDefaults(store);
		org.unicase.ui.usecaseDiagram.preferences.DiagramRulersAndGridPreferencePage.initDefaults(store);
	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return org.unicase.ui.usecaseDiagram.part.ModelDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
