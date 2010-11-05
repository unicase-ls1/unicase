package MultiAttribute;

import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ETypedElementImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;
import org.unicase.ui.common.commands.ECPCommand;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;

public class MultiAttributeControl extends AbstractMEControl {

	private static final int PRIORITY = 2;
	public MultiAttributeControl() {
		
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
		Composite composite = getToolkit().createComposite(parent, style);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		composite.setLayout(gridLayout);
		//list you actually work on
		final List listCtrl = new List(composite, SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		//feature
		final EStructuralFeature feature = (EStructuralFeature) getItemPropertyDescriptor().getFeature(getModelElement());
		//list containing Strings
		final EDataTypeEList<String> data = (EDataTypeEList<String>) getModelElement().eGet(feature);
		for (Object obj : data) {
			listCtrl.add(obj.toString());
		}
		
		//Add-Button
		Button btnAdd = new Button(composite, SWT.PUSH);
		btnAdd.setText("+");
		btnAdd.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				new ECPCommand(getModelElement()) {
					
					@Override
					protected void doRun() {
						// open window to let user enter a String
						InputDialog dlg = new InputDialog(null, "New Middlename", "Enter new middlename here", null, null);
						dlg.setBlockOnOpen(true);
						dlg.open();
						String input = dlg.getValue();
						//add String to listCtrl and data
						listCtrl.add(input);
						data.addUnique(input);
					};
				}.run();
			}
		});
		
		//Edit-Button
		Button btnEdit = new Button(composite, SWT.PUSH);
		btnEdit.setText("...");
		btnEdit.addSelectionListener(new SelectionAdapter(){
	
			@Override
			public void widgetSelected(SelectionEvent e){
			
				new ECPCommand(getModelElement()) {
				
					@Override
					protected void doRun() {
						int SelectedIndex = listCtrl.getSelectionIndex();
						// open window to let user edit a value
						InputDialog dlg = new InputDialog(null, "Edit Middlename", "Edit middlename here", listCtrl.getItem(SelectedIndex) , null);
						//remove selected entry from data
						data.remove(listCtrl.getItem(SelectedIndex));
						dlg.setBlockOnOpen(true);
						dlg.open();
						String input = dlg.getValue();
						//if pressing cancel or close to ensure that the edited entry stays in the list 
						if (input.isEmpty()){
							return;
						}
						else
							//edit value of the chosen entry
							listCtrl.remove(SelectedIndex);
							listCtrl.add(input, SelectedIndex);
							data.remove(listCtrl.getItem(SelectedIndex));
							data.addUnique(SelectedIndex, input);
						}
				}.run();
			}
		});
		
		//Delete-Button
		Button btnDelete = new Button(composite, SWT.PUSH);
		btnDelete.setText("-");
		btnDelete.addSelectionListener(new SelectionAdapter() {
			
				@Override
				public void widgetSelected(SelectionEvent e) {
					
					new ECPCommand(getModelElement()) {
					
						@Override
						protected void doRun() {
							//delete selected value
							int SelectedIndex = listCtrl.getSelectionIndex();
							listCtrl.remove(SelectedIndex);
							data.remove(SelectedIndex);
						}
					}.run();
				}
		});
		
		//Sort-Button
		Button btnSort = new Button(composite, SWT.PUSH);
		btnSort.setText("Sort");
		btnSort.addSelectionListener(new SelectionAdapter() {
			
				@Override
				public void widgetSelected(SelectionEvent e){
				
					new ECPCommand(getModelElement()) {
					
						@Override
						protected void doRun() {
							// new list with Strings to sort, because data cannot be sorted easily
							ArrayList<String> al = new ArrayList<String>();
						
							// add all strings from data to new list
							for(int i = 0; i < data.size(); i++){
								al.add(data.get(i));
							}
							
							// remove all the unsorted Strings
							data.removeAll(al); 
							
							// remove all visible Strings
							listCtrl.removeAll(); 
						
							//sort list => list is sorted
							Collections.sort(al); 			
							
							//copy the sorted arrayList back into data and listCtrl
							for(String s: al) {
								listCtrl.add(s);
								data.addUnique(s);
							}
						}
					}.run();
				}
		});
		
		//create widget
		GridDataFactory.fillDefaults().span(4, 2).hint(SWT.DEFAULT, SWT.DEFAULT).applyTo(listCtrl);
		GridDataFactory.generate(btnAdd, 1, 1);
		GridDataFactory.generate(btnEdit, 1, 1);
		GridDataFactory.generate(btnDelete, 1, 1);
		GridDataFactory.generate(btnSort, 1, 1);
		gridLayout.makeColumnsEqualWidth = true;
		
		
		return composite;
	}

}
