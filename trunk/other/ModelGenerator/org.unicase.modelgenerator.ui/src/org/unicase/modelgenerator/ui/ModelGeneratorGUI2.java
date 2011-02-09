package org.unicase.modelgenerator.ui;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;


public class ModelGeneratorGUI2 extends WizardPage{


	protected ModelGeneratorGUI2(String pageName) {
		super(pageName);
		// TODO Auto-generated constructor stub
	}

	public void createControl(Composite arg0) {
		Button b= new Button(arg0, SWT.PUSH);
		b.setText("Generieren");
		b.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent arg0) {
				IHandlerService service = (IHandlerService)PlatformUI.getWorkbench().getService(IHandlerService.class);
			}
		});
	}




	

}
