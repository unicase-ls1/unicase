package org.unicase.changetracking.ui;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;

public class NoLocalRepoFoundDialog extends MessageDialog {
	
	public static final int CHOICE_CLONE = 0;
	public static final int CHOICE_OPEN = 1;
	public static final int CHOICE_CANCEL = 2;
	

	private NoLocalRepoFoundDialog(Shell parentShell, String dialogTitle,
			Image dialogTitleImage, String dialogMessage, int dialogImageType,
			String[] dialogButtonLabels, int defaultIndex) {
		super(parentShell, dialogTitle, dialogTitleImage, dialogMessage,
				dialogImageType, dialogButtonLabels, defaultIndex);
	}

	private static final String MESSAGE = "No local repository matching the remote repository found!\n\nPress clone to clone from the remote repository.\nOpen will allow you to specify another location for the local repository, in the case you have already cloned it, but outside your workspace.";

	public static int openNoLocalRepoFoundDialog(Shell parent){
		NoLocalRepoFoundDialog dialog = new NoLocalRepoFoundDialog(parent, "No matching local repository found", null, MESSAGE,
				MessageDialog.QUESTION, new String[]{"Clone...","Open","Cancel"}, 0);
		int style = SWT.SHEET;
		dialog.setShellStyle(dialog.getShellStyle() | style);
		return dialog.open();

	}
}
