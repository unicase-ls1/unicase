package org.unicase.link.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class LinkDialog extends Dialog {
	
	private String labelText;
	private String msg;
	
	public LinkDialog(Shell parent, String labelText, String message) {
	    super(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.ICON_INFORMATION);
	    setLabelText(labelText);
	    setText("Input Dialog");
	    setMessage(message);
	}

	public void setMessage(String msg) {
		this.msg = msg;
	}

	public String getMessage() {
		return msg;
	}
	

	  /**
	   * Opens the dialog and returns the input
	   * 
	   * @return String
	   */
	  public void open() {
	    // Create the dialog window
	    Shell shell = new Shell(getParent(), getStyle());
	    shell.setText(getText());
	    createContents(shell);
	    shell.pack();
	    shell.open();
	    Display display = getParent().getDisplay();
	    while (!shell.isDisposed()) {
	      if (!display.readAndDispatch()) {
	        display.sleep();
	      }
	    }	    
	  }

	  /**
	   * Creates the dialog's contents
	   * 
	   * @param shell the dialog window
	   */
	  private void createContents(final Shell shell) {
	    shell.setLayout(new GridLayout(1, true));

	    // Show the message
	    Label label = new Label(shell, SWT.NONE);
	    label.setText(getLabelText());
	    GridData data = new GridData();
	    data.horizontalSpan = 1;
	    label.setLayoutData(data);

	    // Display the input box
	    final Text text = new Text(shell, SWT.BORDER);
	    data = new GridData(GridData.CENTER);
	    data.horizontalSpan = 1;
	    text.setLayoutData(data);
	    text.setEditable(false);
	    text.setText(msg);
	    
	    // Create the OK button and add a handler
	    // so that pressing it will set input
	    // to the entered value
	    Button ok = new Button(shell, SWT.PUSH);
	    ok.setText("OK");
	    data = new GridData(GridData.CENTER);
	    ok.setLayoutData(data);
	    ok.addSelectionListener(new SelectionAdapter() {
	      public void widgetSelected(SelectionEvent event) {
	        shell.close();
	      }
	    });

	    // Create the cancel button and add a handler
	    // so that pressing it will set input to null
	    
	    // Set the OK button as the default, so
	    // user can type input and press Enter
	    // to dismiss
	    shell.setDefaultButton(ok);
	  }

	public void setLabelText(String labelText) {
		this.labelText = labelText;
	}

	public String getLabelText() {
		return labelText;
	}
}
