package MultiAttribute;


import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ETypedElementImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
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

public class MultiAttrContrNumb extends AbstractMEControl {

	
	public static final int PRIORITY = 2;
	public MultiAttrContrNumb(){
		
	}
	@Override
	public int canRender(IItemPropertyDescriptor arg0, EObject arg1) {
		Object feature = arg0.getFeature(arg1);
		ETypedElementImpl attr = null;
		if (feature instanceof ETypedElementImpl){
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
		gridLayout.numColumns = 1;
		composite.setLayout(gridLayout);
		
		//list you actually work on
		final List listCtrl = new List(composite, SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		
		// feature
		final EStructuralFeature feature = (EStructuralFeature) getItemPropertyDescriptor().getFeature(getModelElement());
		
		//list containing Long numbers
		final EDataTypeEList<Long> data = (EDataTypeEList<Long>) getModelElement().eGet(feature);
		for (Long i : data) {
			listCtrl.add(i.toString());
		}
		
		//Add-Button
		Button btnAdd = new Button(composite, SWT.PUSH);
		btnAdd.setText("+");
		btnAdd.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e){
				
				new ECPCommand(getModelElement()) {
					
					@Override
					protected void doRun() {
						
						//determine if a number was entered or not 
						boolean validInput = false;
						while(validInput == false){
							
							//Input window
							String input = JOptionPane.showInputDialog("Please enter a Number");
							try {
									//if pressing cancel or close
									if(input == null)
									{
										return;
									}
									else
									{
										
										//check if given input is a Long or not
										Long i = Long.valueOf(input);
										listCtrl.add(i.toString());
										data.addUnique(i);
										validInput = true;
									}
								}
							
							catch(Exception e) {
									
									//if it is not a Long/Integer than error message
									JOptionPane.showMessageDialog(null, "Not a Number!", "False Entry", JOptionPane.ERROR_MESSAGE);
							}
						}	
					}
				}.run();
			}
		});
		
		//Edit-Button
		Button btnEdit = new Button(composite, SWT.PUSH);
		btnEdit.setText("...");
		btnEdit.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e){
				
				new ECPCommand(getModelElement()) {
					
					@Override
					protected void doRun() {
						
						//determine if a number was entered or not
						boolean validInput = false;
						int SelectedIndex = listCtrl.getSelectionIndex();
						while(validInput == false){
							
							//Input window
							String input = JOptionPane.showInputDialog("Please Edit...", listCtrl.getItem(SelectedIndex).toString());
							try
								{
									//if pressing cancel or close
									if (input == null){
										return;
									}
									
									//check if given input is a Long or not
									Long i = Long.valueOf(input);
									
									//throw old value out and put new one in
									listCtrl.remove(SelectedIndex);
									listCtrl.add(i.toString(), SelectedIndex);
									data.remove(SelectedIndex);
									data.addUnique(SelectedIndex, i);
									
									//exit while loop
									validInput = true;
								}
							catch (Exception e){
								
								//if it is not a Long/Integer than error message
								JOptionPane.showMessageDialog(null, "Not a Number!", "False Entry", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}.run();
			}
		});
		
		//Delete-Button
		Button btnDelete = new Button(composite, SWT.PUSH);
		btnDelete.setText("-");
		btnDelete.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e){
				
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
							
							//copy everything in an arrayList to be able to sort the entries
							ArrayList<Long> al = new ArrayList<Long>();
							for(int i = 0; i < data.size(); i++)
							{
								Long output = data.basicGet(i);
								al.add(output);
							}
							
							//empty data and listCtrl to have no doubles in the lists
							data.removeAll(al);
							listCtrl.removeAll();							
							
							//sort
							Collections.sort(al);
							
							//copy the sorted arrayList back into data and listCtrl
							for (Long i : al)
							{
								listCtrl.add(i.toString());
								data.addUnique(i);
							}
						}
				}.run();
			}
		});
		
		//create widget
		GridDataFactory.fillDefaults().span(4, 1).hint(40, 80).applyTo(listCtrl);
		GridDataFactory.fillDefaults().applyTo(btnAdd);
		GridDataFactory.fillDefaults().applyTo(btnEdit);
		GridDataFactory.fillDefaults().applyTo(btnDelete);
		GridDataFactory.fillDefaults().applyTo(btnSort);
		gridLayout.makeColumnsEqualWidth = true;
				
		return composite;
	
	}

}
