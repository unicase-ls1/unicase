/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.teamprovider.ui;

import java.util.StringTokenizer;

import org.eclipse.jface.preference.IPreferenceStore;

/**
 * This manager class is responsible to load and save the supported extension configuration. The can self-configure
 * which extensions should be managed by this plugin. The preferences are stored in an IPreferenceStore (meta-data
 * folder).
 * 
 * @author Adrian Staudt
 */
public final class PreferenceManager {

	/**
	 * The entry delimiter.
	 */
	private static final String PREFERENCE_DELIMITER = ";";

	/**
	 * The identifiers for the preferences.
	 */
	private static final String EXTENSIONS_PREFERENCE = "extensions";

	// private static final String ECORE_EDITOR = "org.unicase.emfstore.jdt.editor.ecore.EMFStoreEcoreEditorID";
	// private static final String GENMODEL_EDITOR = "org.unicase.emfstore.jdt.editor.ecore.EMFStoreGenModelEditorID";

	/**
	 * Constructor.
	 */
	private PreferenceManager() {
	}

	/**
	 * Convert the supplied PREFERENCE_DELIMITER delimited String to a String array.
	 * 
	 * @return String[]
	 */
	private static String[] convert(String preferenceValue) {
		StringTokenizer tokenizer = new StringTokenizer(preferenceValue, PREFERENCE_DELIMITER);
		int tokenCount = tokenizer.countTokens();
		String[] elements = new String[tokenCount];

		for (int i = 0; i < tokenCount; i++) {
			elements[i] = tokenizer.nextToken();
		}

		return elements;
	}

	/**
	 * Gathers from the preference store the current supported extensions.
	 * 
	 * @return Current supported extensions are returned by an string array.
	 */
	public static String[] getExtensionPreference() {
		return convert(getPreferenceStore().getString(EXTENSIONS_PREFERENCE));
	}

	/**
	 * Returns the default supported extensions. These are ecore and genmodel.
	 * 
	 * @return An array of supported extensions.
	 */
	public static String[] getDefaultExtensionPreference() {
		return new String[] { "*.ecore", "*.genmodel" };
	}

	/**
	 * Sets an array of extensions that will be supported.
	 * 
	 * @param extensions String array that to be converted and saved to the preference value.
	 */
	public static void setExtensionPreference(String[] extensions) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < extensions.length; i++) {
			buffer.append(extensions[i]);
			buffer.append(PREFERENCE_DELIMITER);
		}
		getPreferenceStore().setValue(EXTENSIONS_PREFERENCE, buffer.toString());

	}

	/**
	 * The location where the preferences will be stored.
	 * 
	 * @return A preference store.
	 */
	public static IPreferenceStore getPreferenceStore() {
		return Activator.getDefault().getPreferenceStore();
	}

	/**
	 * Methods allows to check if an extensions is supported by this plugin.
	 * 
	 * @param fileExtension The file extension that has to be checked.
	 * @return True if the extension is supported, false otherwise.
	 */
	public static boolean isExtensionRegistered(String fileExtension) {
		String[] extensions = getExtensionPreference();
		for (String extension : extensions) {
			String[] extensionParts = extension.split("\\.");
			if (extensionParts.length == 2 && extensionParts[1].equalsIgnoreCase(fileExtension)) {
				return true;
			}
		}

		return false;
	}
}
