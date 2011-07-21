/**
 * 
 */
package org.unicase.ui.traceRecvoery.pages;

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
public class SelectDirectoryJava extends WizardPage implements Listener {

	Text indexDir;
	Button selectDir;
	Project project;
	String lastIndexPath;
	String lastPath;
	
	/**
	 * @return the lastIndexPath
	 */
	public String getLastIndexPath() {
		return lastIndexPath;
	}

	/**
	 * @param lastIndexPath the lastIndexPath to set
	 */
	public void setLastIndexPath(String lastIndexPath) {
		this.lastIndexPath = lastIndexPath;
	}

	/**
	 * @return the lastPath
	 */
	public String getLastPath() {
		return lastPath;
	}

	/**
	 * @param lastPath the lastPath to set
	 */
	public void setLastPath(String lastPath) {
		this.lastPath = lastPath;
	}

	/**
	 * @return the indexDir
	 */
	public Text getIndexDir() {
		return indexDir;
	}

	/**
	 * @param indexDir the indexDir to set
	 */
	public void setIndexDir(Text indexDir) {
		this.indexDir = indexDir;
	}

	/**
	 * @return the selectDir
	 */
	public Button getSelectDir() {
		return selectDir;
	}

	/**
	 * @param selectDir the selectDir to set
	 */
	public void setSelectDir(Button selectDir) {
		this.selectDir = selectDir;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	public SelectDirectoryJava(){
		super("SelectDirectoryJava");
		setTitle("Select Index Directory");
		setDescription("Select a directory to place the index file in");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout(4, false);
		composite.setLayout(layout);
		
		Label index = new Label(composite, SWT.NONE);
		index.setText("Select index Directory: ");
		
		indexDir = new Text(composite, SWT.NONE);
		indexDir.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				false, 2, 1));
		
		selectDir = new Button(composite, SWT.NONE);
		selectDir.addListener(SWT.Selection, this);
		selectDir.setText("Browse...");
		
		
		
		
		
		
		
		setControl(composite);
		
		// TODO Auto-generated method stub
		
	}

	/**
	 * provides if it is possible to flip to next page or not
	 */
	@Override
	public boolean canFlipToNextPage(){
		if(!indexDir.getText().equals("")){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public IWizardPage getNextPage(){
		if(super.getNextPage()  instanceof RunRecovery){
			RunRecovery recovery = (RunRecovery) super.getNextPage();
			
			recovery.setIndexPath(lastIndexPath);
			recovery.setPath(lastPath);
			recovery.setP(getProject());
			recovery.setCodeLanguage("java");
			recovery.treeSetUp();
		}
		
		
		return super.getNextPage();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	@Override
	public void handleEvent(Event event) {
		
		if(event.widget == selectDir){
			DirectoryDialog dialog = new DirectoryDialog(getShell());
			String path = dialog.open();
			indexDir.setText(path);
			lastIndexPath = indexDir.getText();
			setPageComplete(false);
			
		}
		
	}

}
