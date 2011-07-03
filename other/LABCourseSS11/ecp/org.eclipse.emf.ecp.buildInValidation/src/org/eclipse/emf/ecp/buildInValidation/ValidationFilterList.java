package org.eclipse.emf.ecp.buildInValidation;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ListSelectionDialog;

/**
 * The list of the validation filters.
 * 
 * @author Carmen Carlan
 */
public class ValidationFilterList extends ListSelectionDialog {

	/**
	 * @param parentShell
	 *            the
	 * @param input
	 *            the
	 * @param contentProvider
	 *            the
	 * @param labelProvider
	 *            the
	 * @param message
	 *            the
	 */
	public ValidationFilterList(Shell parentShell, Object input,
			IStructuredContentProvider contentProvider,
			ILabelProvider labelProvider, String message) {
		super(parentShell, input, contentProvider, labelProvider, message);
	}

}
