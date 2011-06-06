package org.eclipse.emf.ecp.editor;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

public class MEExtendedSuggestedSelectionDialog extends
		MESuggestedSelectionDialog {
	
	Combo contexts;
	
	public MEExtendedSuggestedSelectionDialog(String title, String message,
			boolean blockOnOpen, EObject baseElement, EReference reference,
			Collection<EObject> elements) {
		super(title, message, blockOnOpen, baseElement, reference, elements);
	}

	@Override
	protected Control createExtendedContentArea(Composite parent) {
		
		Label label = new Label(parent, SWT.WRAP);
		label.setText("Please select the context:");
		contexts = new Combo(parent, SWT.DROP_DOWN | SWT.BORDER | SWT.HORIZONTAL | SWT.SINGLE);
		Control[] children = parent.getChildren();
		Control firstChild = children[0];
		contexts.moveAbove(firstChild);
		label.moveAbove(contexts);
		return null;
	}

}
