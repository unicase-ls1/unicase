/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
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
	@Override
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
