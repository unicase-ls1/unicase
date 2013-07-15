/**
 * 
 */
package org.unicase.scrm.review.ui.views;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.unicase.workspace.Configuration;

/**
 * @author liya
 *
 */
public class ExportWizardPage extends WizardPage implements Listener {
	private static final String PAGE_TITLE = "Thanks for reviewing the requirements.";

	private Text path;
	private String incompleteNumber;
	private Text numberOfMissingReq;
	


	protected ExportWizardPage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
//		setDescription(PAGE_DESCRIPTION);

	}

	@Override
	public void createControl(Composite parent) {
		GridData gd;
        Composite composite = new Composite(parent, SWT.NULL);
        GridLayout gl = new GridLayout();
        int ncol = 1;
        gl.numColumns = ncol;
        composite.setLayout(gl);

        Label label = new Label(composite, SWT.NONE);
        label.setText("In additional to these requirements, please specify the number of missing requirements in your opinion.");
        gd = new GridData(GridData.FILL_HORIZONTAL);
        label.setLayoutData(gd);
        

        label = new Label(composite, SWT.BOLD);
        label.setText("Number of missing requirements:");        
        numberOfMissingReq = new Text(composite, SWT.BORDER);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        numberOfMissingReq.setLayoutData(gd);
        
        numberOfMissingReq.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				setIncompleteNumber(numberOfMissingReq.getText());
				
			}
		});

        new Label(composite, SWT.NONE).setText("Specify the destination to save the review result:");
        path = new Text(composite, SWT.BORDER);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        path.setLayoutData(gd);

        path.addListener(SWT.KeyUp, this);


//        Button selectFileLocation = new Button(composite, SWT.PUSH);
//        selectFileLocation.setText("Browse");
//        selectFileLocation.addSelectionListener(new FileLocationSelectionListener());

        Button newFileLocation = new Button(composite, SWT.PUSH);
        newFileLocation.setText("Browse");
        newFileLocation.addSelectionListener(new NewFileLocationSelectionListener());

        setControl(composite);

		
	}
    /**
     * Listener for the file location selection.
     */
    class FileLocationSelectionListener extends SelectionAdapter {
            /**
             * {@inheritDoc}
             */
            @Override
            public void widgetSelected(SelectionEvent e) {
                    FileDialog fd = new FileDialog(((Button) e.widget).getParent().getShell());
                    fd.setText("select the configuration file ");
                    final String directory = Configuration.getPluginDataBaseDirectory();
                    fd.setFilterPath(directory);
                    String selected = fd.open();

                    if (selected != null) {
                    	path.setText(selected);
                    }
            }
    }

    /**
     * Listener for the new conf file location selection.
     */
    class NewFileLocationSelectionListener extends SelectionAdapter {
            /**
             * {@inheritDoc}
             */
            @Override
            public void widgetSelected(SelectionEvent e) {

                    FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                            SWT.SAVE);
                    dialog.setFilterPath(Configuration.getPluginDataBaseDirectory());
                    dialog.setFilterNames(new String[] { "CSV Files(*.csv)", "All Files(*.*)" });
                    dialog.setFilterExtensions(new String[] { ".csv", ".*" });
                    dialog.setOverwrite(true);
                    String initialFileName = "result.csv";
                    dialog.setFileName(initialFileName);

                    // dialog
                    String selected = dialog.open();

                    if (selected != null) {
                            path.setText(selected);
                    }
            }
    }



	@Override
	public void handleEvent(Event event) {
		// TODO Auto-generated method stub
		
	}

	public void setIncompleteNumber(String incompleteNumber) {
		this.incompleteNumber = incompleteNumber;
	}

	public String getIncompleteNumber() {
		return incompleteNumber;
	}

	/**
	 * @return the numberOfMissingReq
	 */
	public Text getNumberOfMissingReq() {
		return numberOfMissingReq;
	}

	/**
	 * @param numberOfMissingReq the numberOfMissingReq to set
	 */
	public void setNumberOfMissingReq(Text numberOfMissingReq) {
		this.numberOfMissingReq = numberOfMissingReq;
	}

	/**
	 * @return the path
	 */
	public Text getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(Text path) {
		this.path = path;
	}

}
