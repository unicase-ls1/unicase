/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;

public class AdvancedMessageDialog extends MessageDialog {
	
	private static final String NO_LOCAL_REPO_CAPTION = "No matching local repository found";
	private static final String NO_LOCAL_REPO_MESSAGE = "No local repository matching the remote repository found!\n\nPress clone to clone from the remote repository.\nOpen will allow you to specify another location for the local repository, in the case you have already cloned it, but outside your workspace.";
	private static final String NO_REMOTE_REPO_CAPTION = "No matching remote repository found";
	private static final String NO_REMOTE_REPO_MESSAGE = "No repository location matching the local repository found in the selected UNICASE project!\n\nPress \"create\" to create a new repository location, \"don't create\" to leave this branch without a repository location or \"cancel\" to abort the process.";
	 
	public static enum NoLocalRepoChoices{
		CLONE, OPEN, CANCEL;
	}
	
	public static enum NoRemoteRepoChoices{
		CREATE, DO_NOT_CREATE, CANCEL;
	}
	
	

	private AdvancedMessageDialog(Shell parentShell, String dialogTitle,
			Image dialogTitleImage, String dialogMessage, int dialogImageType,
			String[] dialogButtonLabels, int defaultIndex) {
		super(parentShell, dialogTitle, dialogTitleImage, dialogMessage,
				dialogImageType, dialogButtonLabels, defaultIndex);
	}


	
	public static int openAdvancedMessageDialog(Shell parent, String caption, String message, int image, String[] buttons ){
		AdvancedMessageDialog dialog = new AdvancedMessageDialog(parent, caption, null, message,
				image, buttons, 0);
		int style = SWT.SHEET;
		dialog.setShellStyle(dialog.getShellStyle() | style);
		return dialog.open();
	}
	
	public static NoLocalRepoChoices openNoLocalRepoFoundDialog(Shell parent){
		int result = openAdvancedMessageDialog(parent, NO_LOCAL_REPO_CAPTION, NO_LOCAL_REPO_MESSAGE,
				MessageDialog.QUESTION, new String[]{"Clone...","Open","Cancel"});
		return NoLocalRepoChoices.values()[result];
	}
	
	public static NoRemoteRepoChoices openNoRemoteRepoFoundDialog(Shell parent){
		int result = openAdvancedMessageDialog(parent, NO_REMOTE_REPO_CAPTION, NO_REMOTE_REPO_MESSAGE,
				MessageDialog.QUESTION, new String[]{"Create","Don't Create","Cancel"});
		return NoRemoteRepoChoices.values()[result];
	}
}
