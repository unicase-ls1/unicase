package org.unicase.ui.web.tabs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import org.unicase.ui.web.util.ExampleUtil;

/**
 * 
 * @author fxulusoy
 *
 */
public class InputTab extends AbstractTab {

	private boolean isContentCreated;
	private final CTabFolder tabFolder;
	private final CTabItem tabItem;
	
	
	public InputTab(CTabFolder parent) {
		tabFolder = parent;
		isContentCreated = false;
	    tabItem = new CTabItem( tabFolder, SWT.NONE );
	    tabItem.setText("Input Exp. Tab");
	}
	
	public void createContent() {
		if (!isContentCreated) {
		    Composite com = new Composite(tabFolder, SWT.NONE);
		    createTabContent(com);
		    tabItem.setControl(com);
			isContentCreated = true;
		}
	}
	
	/**
	 * 
	 * @param parent
	 */
	private void createTabContent(Composite parent) {
		parent.setLayout( ExampleUtil.createGridLayout( 1, false, 10, 20 ) );
		createForm(parent);
	}
	
	  private void createForm( final Composite parent ) {
		    GridData gridData;
		    Group group = new Group( parent, SWT.NONE );
		    group.setText( "Simple Form" );
		    group.setLayout( ExampleUtil.createGridLayout( 1, false, 10, 20 ) );
		    group.setLayoutData( new GridData( SWT.FILL, SWT.TOP, true, false ) );

		    Composite formComp = new Composite( group, SWT.NONE );
		    formComp.setLayout( new GridLayout( 2, false ) );

		    new Label( formComp, SWT.NONE ).setText( "First Name:" );
		    final Text firstNameText = new Text( formComp, SWT.SINGLE | SWT.BORDER );
		    gridData = new GridData( SWT.FILL, SWT.TOP, true, false );
		    gridData.minimumWidth = 250;
		    firstNameText.setLayoutData( gridData );

		    new Label( formComp, SWT.NONE ).setText( "Last Name:" );
		    final Text lastNameText = new Text( formComp, SWT.SINGLE | SWT.BORDER );
		    gridData = new GridData( SWT.FILL, SWT.TOP, true, false );
		    lastNameText.setLayoutData( gridData );

		    new Label( formComp, SWT.NONE ).setText( "Passphrase:" );
		    final Text passwordText
		      = new Text( formComp, SWT.SINGLE | SWT.PASSWORD | SWT.BORDER );
		    gridData = new GridData( SWT.FILL, SWT.TOP, true, false );
		    passwordText.setLayoutData( gridData );
		    passwordText.setText( "Password" );

		    new Label( formComp, SWT.NONE ).setText( "Age:" );
		    final Spinner spinner = new Spinner( formComp, SWT.BORDER );
		    gridData = new GridData( SWT.FILL, SWT.TOP, true, false );
		    spinner.setLayoutData( gridData );
		    spinner.setSelection( 23 );

		    new Label( formComp, SWT.NONE ).setText( "Country:" );
		    final Combo countryCombo = new Combo( formComp, SWT.BORDER );
		    String[] countries
		      = new String[] { "Germany", "Canada", "USA", "Bulgaria" };
		    countryCombo.setItems( countries );
		    gridData = new GridData( SWT.FILL, SWT.TOP, true, false );
		    countryCombo.setLayoutData( gridData );
		    countryCombo.select( 0 );

		    new Label( formComp, SWT.NONE ).setText( "Class:" );
		    final Combo classCombo = new Combo( formComp, SWT.READ_ONLY | SWT.BORDER );
		    String[] classes = new String[] { "Business", "Economy", "Economy Plus" };
		    classCombo.setItems( classes );
		    gridData = new GridData( SWT.FILL, SWT.TOP, true, false );
		    classCombo.setLayoutData( gridData );
		    classCombo.select( 0 );

		    new Label( formComp, SWT.NONE ).setText( "Date:" );
		    int dateTimeStyle = SWT.READ_ONLY | SWT.BORDER;
		    final DateTime dateTime = new DateTime( formComp, dateTimeStyle );

		    new Label( formComp, SWT.NONE );
		    final Button editableCheckbox = new Button( formComp, SWT.CHECK );
		    editableCheckbox.setText( "Editable" );
		    editableCheckbox.setSelection( true );
		    editableCheckbox.addSelectionListener( new SelectionAdapter() {
		      public void widgetSelected( final SelectionEvent e ) {
		        boolean editable = editableCheckbox.getSelection();
		        firstNameText.setEditable( editable );
		        lastNameText.setEditable( editable );
		        passwordText.setEditable( editable );
		        spinner.setEnabled( editable );
		        countryCombo.setEnabled( editable );
		        classCombo.setEnabled( editable );
		        dateTime.setEnabled( editable );
		      }
		    } );
		  }

}
