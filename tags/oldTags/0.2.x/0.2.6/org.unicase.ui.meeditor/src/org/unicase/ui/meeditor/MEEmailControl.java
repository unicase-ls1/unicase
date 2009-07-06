package org.unicase.ui.meeditor;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.ui.meeditor.mecontrols.METextAreaControl;
/**
 * @author hamid Control for an email attribute. Includes a button to send an
 *         email.
 */
public class MEEmailControl extends AbstractMEControl {
	private METextAreaControl meAreaControl;

	/**
	 * Default constructor.
	 * 
	 * @param attribute
	 *            The mail attribute
	 * @param toolkit
	 *            The swt toolkit
	 * @param modelElement
	 *            The user
	 * @param editingDomain
	 *            the edititng domain
	 */
	public MEEmailControl(EAttribute attribute, FormToolkit toolkit,
			EObject modelElement, EditingDomain editingDomain) {
		super(editingDomain, modelElement, toolkit);
		meAreaControl = new METextAreaControl(attribute,toolkit,modelElement,editingDomain);
	}

	/**
	 * {@inheritDoc}
	 */
	public Control createControl(Composite parent, int style) {
		Composite composite = getToolkit().createComposite(parent, style);
		GridLayout gridLayout = new GridLayout(2, false);
		composite.setLayout(gridLayout);
		final Text createControl = (Text)meAreaControl.createControl(composite, style);
		createControl.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		final Action mail = new Action("Send email", SWT.PUSH) {

			@Override
			public void run() {
				String email = createControl.getText();
				Program.launch("mailto:" + email);
			}

		};
		Button button = new Button(composite, SWT.PUSH);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mail.run();
			}

		});
		button.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		button.setImage(Activator.getImageDescriptor("icons/mail.png")
				.createImage());

		return parent;
	}


}
