package MultiAttribute;

import java.security.AlgorithmParameterGenerator;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;
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
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		composite.setLayout(gridLayout);
		final List listCtrl = new List(composite, SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
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
		btnAdd.setText("+");
		
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				new ECPCommand(getModelElement()) {
					
					@Override
					protected void doRun() {
						// TODO Auto-generated method stub
						InputDialog dlg = new InputDialog(null, "New Middlename", "Enter new middlename here", null, null);
						dlg.setBlockOnOpen(true);
						dlg.open();
						String input = dlg.getValue();
						listCtrl.add(input);
//						Object test = (Object) input;
						data.addUnique(input);
						//getModelElement().eSet(feature, data);
					};
				}.run();
			}
		});
		
		Button btnEdit = new Button(composite, SWT.PUSH);
		btnEdit.setText("...");
		
		btnEdit.addSelectionListener(new SelectionAdapter(){
		@Override
		public void widgetSelected(SelectionEvent e){
			
			new ECPCommand(getModelElement()) {
				
				@Override
				protected void doRun() {
					// TODO Auto-generated method stub
					
					//data.get(index)
					int SelectedIndex = listCtrl.getSelectionIndex();
					InputDialog dlg = new InputDialog(null, "Edit Middlename", "Edit middlename here", listCtrl.getItem(SelectedIndex) , null);
					data.remove(listCtrl.getItem(SelectedIndex));
					dlg.setBlockOnOpen(true);
					dlg.open();
					String input = dlg.getValue();
					if (input.isEmpty()){
						return;
					}
					else
					//listCtrl.setItem(listCtrl.getSelectionIndex(), input);
					listCtrl.remove(SelectedIndex);
					listCtrl.add(input, SelectedIndex);
					
					data.remove(listCtrl.getItem(SelectedIndex));
					data.addUnique(SelectedIndex, input);
		
				}
			}.run();
		}
		});
		
		
		Button btnDelete = new Button(composite, SWT.PUSH);
		btnDelete.setText("-");
		btnDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				new ECPCommand(getModelElement()) {
					
					@Override
					protected void doRun() {
						// TODO Auto-generated method stub
					
						int SelectedIndex = listCtrl.getSelectionIndex();
						listCtrl.remove(SelectedIndex);
						data.remove(SelectedIndex);
					}
				}.run();
				
			}
		});
		
		Button btnSort = new Button(composite, SWT.PUSH);
		btnSort.setText("Sort");
		btnSort.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				
				new ECPCommand(getModelElement()) {
					
					
					
					@Override
					protected void doRun() {
						// new list with strings to sort, because data cannot be sorted easily
						ArrayList<String> al = new ArrayList<String>();
						
						// add all strings from data to new list
						for(int i = 0; i < data.size(); i++){
							al.add(data.get(i));
						}
						data.removeAll(al); // remove all the unsorted strings
						listCtrl.removeAll(); // remove all visible strings
						
						Collections.sort(al); //sort list => list is sorted				
						
						for(String s: al) {
							listCtrl.add(s);
							data.addUnique(s);
						}
				}
			}.run();
		}
		});
		
		GridDataFactory.fillDefaults().span(4, 2).hint(SWT.DEFAULT, SWT.DEFAULT).applyTo(listCtrl);
		GridDataFactory.generate(btnAdd, 1, 1);
		GridDataFactory.generate(btnEdit, 1, 1);
		GridDataFactory.generate(btnDelete, 1, 1);
		GridDataFactory.generate(btnSort, 1, 1);
		gridLayout.makeColumnsEqualWidth = true;
		
		
		return composite;
	}

}
