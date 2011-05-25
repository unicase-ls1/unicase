/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.release;

/**
 * Objects of these class are filled by the build-release
 * dialog and are handed to the adapter when building
 * a release.
 * 
 * They include all settings the user can make to alter
 * the release building process.
 * 
 * @author gex
 *
 */
public class ReleaseBuildingSettings {

	private String tagName;
	private boolean uploadToRemote;
	
	/**
	 * Default constructor.
	 * @param tagName tag name the build revision should receive
	 * @param uploadToRemote whether to upload the building result to the remote repo
	 */
	public ReleaseBuildingSettings(String tagName, boolean uploadToRemote) {
		super();
		this.tagName = tagName;
		this.uploadToRemote = uploadToRemote;
	}
	
	/**
	 * Returns the desired tag name for the built revision.
	 * @return tag name
	 */
	public String getTagName() {
		return tagName;
	}
	
	/**
	 * Returns whether it is desired to directly upload the built
	 * revision (including all modified branches and the created tag)
	 * to the remote repository.
	 * 
	 * @return want upload?
	 */
	public boolean wantUploadToRemote() {
		return uploadToRemote;
	}
	
}
