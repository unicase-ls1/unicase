/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classDiagram.preferences;

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
		org.unicase.model.classDiagram.preferences.DiagramPrintingPreferencePage
				.initDefaults(store);
		org.unicase.model.classDiagram.preferences.DiagramGeneralPreferencePage
				.initDefaults(store);
		org.unicase.model.classDiagram.preferences.DiagramAppearancePreferencePage
				.initDefaults(store);
		org.unicase.model.classDiagram.preferences.DiagramConnectionsPreferencePage
				.initDefaults(store);
		org.unicase.model.classDiagram.preferences.DiagramRulersAndGridPreferencePage
				.initDefaults(store);
	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return org.unicase.model.classDiagram.part.ModelDiagramEditorPlugin
				.getInstance().getPreferenceStore();
	}
}
