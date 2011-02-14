package MultiAttribute;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EAttributeImpl;
import org.eclipse.emf.ecore.impl.ETypedElementImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.MessageBox;
import org.unicase.ui.common.commands.ECPCommand;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;

public class MultiAttributeControl extends AbstractMEControl {

	private static final int PRIORITY = 2;
	public MultiAttributeControl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int canRender(IItemPropertyDescriptor arg0, EObject arg1) {
		Object feature = arg0.getFeature(arg0);
		ETypedElementImpl attr = null;
		
		if (feature instanceof ETypedElementImpl) {
			 attr = (ETypedElementImpl) feature;
			 if (attr.getUpperBound() == -1) {
				return PRIORITY; 
			 }
			 else return DO_NOT_RENDER;
		}
		else return DO_NOT_RENDER;
		
	}

	@Override
	protected Control createControl(Composite parent, int style) {
		// TODO Auto-generated method stub
		Composite composite = getToolkit().createComposite(parent, style);
		GridLayout gridLayout = new GridLayout(2, false);
		composite.setLayout(gridLayout);
		final List listCtrl = new List(composite, SWT.SINGLE | SWT.BORDER);
		final EStructuralFeature feature = (EStructuralFeature) getItemPropertyDescriptor().getFeature(getModelElement());
		final EDataTypeEList<String> data = (EDataTypeEList<String>) getModelElement().eGet(feature);
		for (Object obj : data) {
			listCtrl.add(obj.toString());
		}
		/*
		listCtrl.add("Test1");
		listCtrl.add("Test2");
		listCtrl.add("Test3");
		*/
		/*
		GridData gridData = new GridData();
		gridData.verticalSpan = 4;
		gridData.heightHint = 200;
		gridData.widthHint = 100;
		listCtrl.setLayoutData(gridData);
		*/
		Button btnAdd = new Button(composite, SWT.PUSH);
		btnAdd.setText("Add");
		
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				new ECPCommand(getModelElement()) {
					
					@Override
					protected void doRun() {
						// TODO Auto-generated method stub
						InputDialog dlg = new InputDialog(null, null, null, null, null);
						dlg.setBlockOnOpen(true);
						dlg.open();
						String input = dlg.getValue();
						listCtrl.add(input);
						Object test = (Object) input;
						data.add(input);
						//getModelElement().eSet(feature, data);
					};
				}.run();
			}
		});
		
		Button btnEdit = new Button(composite, SWT.PUSH);
		btnEdit.setText("Edit");
		Button btnDelete = new Button(composite, SWT.PUSH);
		btnDelete.setText("Delete");
		btnDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				listCtrl.remove(listCtrl.getSelectionIndex());
			}
		});
		
		GridDataFactory.fillDefaults().span(1, 4).hint(100, 200).applyTo(listCtrl);
		GridDataFactory.fillDefaults().applyTo(btnAdd);
		GridDataFactory.fillDefaults().applyTo(btnEdit);
		GridDataFactory.fillDefaults().applyTo(btnDelete);
		
		
		return composite;
	}

}
