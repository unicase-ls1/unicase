/**
 * 
 */
package org.unicase.ui.traceRecovery.traceRecvoery.pages;

import java.io.File;

import javax.swing.filechooser.FileSystemView;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.unicase.metamodel.Project;

/**
 * @author taher
 * 
 */
public class SelecDirectory extends WizardPage implements Listener {

	Button java;
	Button fortran;
	Button checkButton;
	Text directoryString;
	Text indexString;
	Button directory;
	Button setIndexDirectory;
	String lastPath;
	String lastIndexPath;
	String language;
	Project project;

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	public SelecDirectory() {
		super("SelectDirectory");
		setTitle("Select Directory");
		setDescription("select the language and code,index Directory");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		setPageComplete(false);
		Composite controlor = new Composite(parent, SWT.NULL);

		GridLayout layout = new GridLayout(4, false);
		controlor.setLayout(layout);

		Label chooseCodeType = new Label(controlor, SWT.NONE);
		chooseCodeType.setText("Choose Language:");

		new Label(controlor, SWT.NONE);

		java = new Button(controlor, SWT.RADIO);
		java.setText("Java");
		java.addListener(SWT.Selection, this);

		fortran = new Button(controlor, SWT.RADIO);
		fortran.setText("Fortran");
		fortran.addListener(SWT.Selection, this);

		Label code = new Label(controlor, SWT.NONE);
		code.setText("Code Directory: ");

		directoryString = new Text(controlor, SWT.BORDER);
		directoryString.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				false, 2, 1));

		directoryString.setText("");

		directory = new Button(controlor, SWT.NONE);
		directory.addListener(SWT.Selection, this);
		directory.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false,
				0, 1));
		directory.setText("Browse...");

		new Label(controlor, SWT.NONE);
		new Label(controlor, SWT.NONE);
		new Label(controlor, SWT.NONE);
		new Label(controlor, SWT.NONE);

		GridData checkButtonLayout = new GridData(SWT.LEFT, SWT.FILL, false,
				false, 4, 3);

		checkButton = new Button(controlor, SWT.CHECK);
		checkButton.setLayoutData(checkButtonLayout);
		checkButton.setText("Select Lucene Directory");
		checkButton.addListener(SWT.Selection, this);

		Label index = new Label(controlor, SWT.NONE);
		index.setText("Index Directory: ");

		FileSystemView fileview = FileSystemView.getFileSystemView();
		File file = fileview.getHomeDirectory();

		indexString = new Text(controlor, SWT.BORDER);
		indexString.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,
				2, 1));
		indexString.setText(file.getPath());
		indexString.setEnabled(false);

		setIndexDirectory = new Button(controlor, SWT.NONE);
		setIndexDirectory.addListener(SWT.Selection, this);
		setIndexDirectory.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false,
				false, 0, 1));
		setIndexDirectory.setText("Browse...");
		setIndexDirectory.setEnabled(false);

		new Label(controlor, SWT.NONE);
		new Label(controlor, SWT.NONE);
		new Label(controlor, SWT.NONE);
		new Label(controlor, SWT.NONE);

		Label label = new Label(controlor, SWT.WRAP);
		label.setText("Choose a directory to place the Lucene index which will contain the indexing of the text to be searched");
		label.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 4, 1));

		setControl(controlor);

	}

	@Override
	public boolean canFlipToNextPage() {
		if (directoryString.getText().equals("")
				|| indexString.getText().equals("")
				|| !((java.getSelection()) ^ (fortran.getSelection()))) {
			return false;
		} else {
			if (java.getSelection()) {
				language = "java";
			} else if (fortran.getSelection()) {
				language = "fortran";
			}
			// ((RunRecovery)super.getNextPage()).setUp();

			// super.getNextPage().createControl(getShell());
			return true;
		}

		// return false;
	}

	@Override
	public IWizardPage getNextPage() {

		if (super.getNextPage() instanceof RunRecovery) {

			RunRecovery recovery = (RunRecovery) super.getNextPage();

			lastPath = directoryString.getText();
			lastIndexPath = indexString.getText();

			recovery.setP(project);
			recovery.setPath(lastPath);
			recovery.setIndexPath(lastIndexPath);
			recovery.setCodeLanguage(language);
			recovery.treeSetUp();

		}
		return super.getNextPage();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.
	 * Event)
	 */
	@Override
	public void handleEvent(Event event) {
		if (event.widget == directory) {

			DirectoryDialog dir = new DirectoryDialog(getShell());
			if (directoryString.getText().equals(" ")) {
				FileSystemView file = FileSystemView.getFileSystemView();
				File f = file.getHomeDirectory();
				dir.setFilterPath(f.getPath());
			} else {
				dir.setFilterPath(directoryString.getText());
			}

			String path = dir.open();
			// directoryString = new StyledText(shell, SWT.NONE);
			directoryString.setText(path);
			// canFlipToNextPage();
			// lastPath = directoryString.getText();
			setPageComplete(false);
			// directoryString.setSize(500, 100);
			// DirectoryDialog dialog = new DirectoryDialog(shell);

		} else if (event.widget == setIndexDirectory) {
			DirectoryDialog dir = new DirectoryDialog(getShell());
			if (indexString.getText().equals("")) {
				dir.setFilterPath("/home/taher");
			} else {
				dir.setFilterPath(indexString.getText());
			}

			String path = dir.open();
			indexString.setText(path);
			// lastIndexPath = indexString.getText();
			setPageComplete(false);

		} else if (event.widget == java) {
			language = "java";
			setPageComplete(false);
		} else if (event.widget == fortran) {
			language = "fortran";
			setPageComplete(false);
		} else if (event.widget == checkButton) {
			if (checkButton.getSelection()) {
				indexString.setEnabled(true);
				setIndexDirectory.setEnabled(true);
			} else {
				indexString.setEnabled(false);
				setIndexDirectory.setEnabled(false);
			}

		}

		/*
		 * else if (event.widget == setDirectory) {
		 * 
		 * System.out.println("the next button was clicked");
		 * 
		 * File file = new File(directoryString.getText()); File f = new
		 * File(indexString.getText()); lastPath = directoryString.getText();
		 * lastIndexPath = indexString.getText(); if (!file.exists()) {
		 * 
		 * MessageDialog .open(SWT.ERROR, getShell(), "wrong path",
		 * "You entered a wrong CODE path please enter a correct path",
		 * SWT.None); // sh = new Shell(display); // sh.setLayout(new
		 * GridLayout()); // Label text = new Label(sh, SWT.None); //
		 * text.setText
		 * ("the entered path is not correct plz enter another path"); // ok =
		 * new Button(sh, SWT.PUSH); // ok.setText("OK"); //
		 * ok.addListener(SWT.Selection, this);
		 * 
		 * // shell.dispose(); // // sh.open();
		 * 
		 * // while (!sh.isDisposed()) { // if (!display.readAndDispatch()) //
		 * display.sleep(); // } // display.dispose(); } else if (!f.exists()) {
		 * 
		 * MessageDialog .open(SWT.ERROR, getShell(), "wrong path",
		 * "You entered a wrong INDEX path please enter a correct path",
		 * SWT.None);
		 * 
		 * } else {
		 * 
		 * System.out
		 * .println("this will start the check from the java and fortran is choosen"
		 * ); if (!(java.getSelection() || fortran.getSelection())) {
		 * MessageDialog.open(SWT.ERROR, getShell(),
		 * "Programing Language not choosen",
		 * "You must choose a programing language", SWT.None);
		 * 
		 * } else {
		 * 
		 * String language = ""; if (java.getSelection()) { language = "java"; }
		 * else { language = "fortran"; }
		 * 
		 * shell.dispose();
		 * 
		 * new RunRecovery().run(lastPath,lastIndexPath, language); } } }
		 */

	}

	/**
	 * @return the checkButton
	 */
	public Button getCheckButton() {
		return checkButton;
	}

	/**
	 * @param checkButton
	 *            the checkButton to set
	 */
	public void setCheckButton(Button checkButton) {
		this.checkButton = checkButton;
	}

	/**
	 * @return the java
	 */
	public Button getJava() {
		return java;
	}

	/**
	 * @param java
	 *            the java to set
	 */
	public void setJava(Button java) {
		this.java = java;
	}

	/**
	 * @return the fortran
	 */
	public Button getFortran() {
		return fortran;
	}

	/**
	 * @param fortran
	 *            the fortran to set
	 */
	public void setFortran(Button fortran) {
		this.fortran = fortran;
	}

	/**
	 * @return the directoryString
	 */
	public Text getDirectoryString() {
		return directoryString;
	}

	/**
	 * @param directoryString
	 *            the directoryString to set
	 */
	public void setDirectoryString(Text directoryString) {
		this.directoryString = directoryString;
	}

	/**
	 * @return the indexString
	 */
	public Text getIndexString() {
		return indexString;
	}

	/**
	 * @param indexString
	 *            the indexString to set
	 */
	public void setIndexString(Text indexString) {
		this.indexString = indexString;
	}

	/**
	 * @return the directory
	 */
	public Button getDirectory() {
		return directory;
	}

	/**
	 * @param directory
	 *            the directory to set
	 */
	public void setDirectory(Button directory) {
		this.directory = directory;
	}

	/**
	 * @return the setIndexDirectory
	 */
	public Button getSetIndexDirectory() {
		return setIndexDirectory;
	}

	/**
	 * @param setIndexDirectory
	 *            the setIndexDirectory to set
	 */
	public void setSetIndexDirectory(Button setIndexDirectory) {
		this.setIndexDirectory = setIndexDirectory;
	}

	/**
	 * @return the lastPath
	 */
	public String getLastPath() {
		return lastPath;
	}

	/**
	 * @param lastPath
	 *            the lastPath to set
	 */
	public void setLastPath(String lastPath) {
		this.lastPath = lastPath;
	}

	/**
	 * @return the lastIndexPath
	 */
	public String getLastIndexPath() {
		return lastIndexPath;
	}

	/**
	 * @param lastIndexPath
	 *            the lastIndexPath to set
	 */
	public void setLastIndexPath(String lastIndexPath) {
		this.lastIndexPath = lastIndexPath;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language
	 *            the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
}
