package org.unicase.link.util;

import java.io.File;

import org.eclipse.core.runtime.Platform;

/**
 * Class for retrieving some plugin specific location information.
 * 
 * @author emueller
 */
public class FileLocations {

	/**
	 * Path of the lock file, that is used for passing URL information in case eclipse hasn't already been running.
	 */
	public static final String LOCK_FILE = getPluginFeaturesDirectory() + File.separator + ".unicase-link-lock.file";

	/**
	 * Gets the absolute path of the eclipse installation with a trailing file separator.
	 * 
	 * @return the absolute path of the eclipse installation
	 */
	public static String getEclipseFilePath() {
		return Platform.getInstallLocation().getURL().getFile();
	}

	/**
	 * Gets the <code>lib</code> directory, which is contained within the features directory of the plugin.
	 * 
	 * @return the absolute path of the lib directory
	 */
	public static String getPluginFeaturesDirectory() {
		File featuresDir = new File(getEclipseFilePath() + "features");

		File[] features = featuresDir.listFiles();

		for (File feature : features) {
			if (feature.getName().toLowerCase().contains("org.unicase.link")) {
				return feature.getAbsoluteFile() + File.separator + "lib";
			}
		}

		return null;
	}
}
