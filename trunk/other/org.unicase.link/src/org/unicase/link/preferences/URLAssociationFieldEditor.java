package org.unicase.link.preferences;



import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.StringButtonFieldEditor;
import org.eclipse.swt.widgets.Composite;

public class URLAssociationFieldEditor extends StringButtonFieldEditor {

	static {
		System.loadLibrary("RegisterURL");
	}
	
    native int registerUrl(String eclipseInfo);
	
    public URLAssociationFieldEditor(String name, String labelText, Composite parent) {
    	super(name, labelText, parent);
    }

	protected String changePressed() {
//		native_method(null);
		if (registerUrl("org.eclipse.eclipse") == 1) {
			int ret = 0;
			MessageDialog.openInformation(getShell(), "Success", 
					"UNICASE protocol handler successfully registered");
			// show msg box
		} else {
			MessageDialog.openInformation(getShell(), "Failure", 
				"Could not find eclipse?");
		}
		
		return null;
	}	
}
