package MultiAttribute;

import java.awt.GridBagLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.Icon;
import javax.swing.JOptionPane;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ETypedElementImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
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
		// TODO Auto-generated method stub
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
		
		final List listCtrl = new List(composite, SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		
		final EStructuralFeature feature = (EStructuralFeature) getItemPropertyDescriptor().getFeature(getModelElement());
		final EDataTypeEList<Long> data = (EDataTypeEList<Long>) getModelElement().eGet(feature);
		for (Long i : data) {
			listCtrl.add(i.toString());
		}
		
		Button btnAdd = new Button(composite, SWT.PUSH);
		btnAdd.setText("+");
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				
				new ECPCommand(getModelElement()) {
					
					@Override
					protected void doRun() {
						boolean validInput = false;
						while(validInput == false){
							String input = JOptionPane.showInputDialog("Please enter a Number");
//							InputDialog inputDialog = new InputDialog(null, "New Number", "Enter new number here", null, null);
//							inputDialog.setBlockOnOpen(true);
//							inputDialog.open();
//							String input = inputDialog.getValue();
							
						  
							try {
								if(input == null){
									return;
								}
								else{
								Long i = Long.valueOf(input);
								listCtrl.add(i.toString());
								data.addUnique(i);
								validInput = true;
								}
							}
							
							catch(Exception e) {
//								String[] label = new String[1];
//								label[0] = "OK";
//								MessageDialog md = new MessageDialog(null, "False Entry" , null, "Not a Number!", MessageDialog.ERROR, label , 1);
//								md.setBlockOnOpen(true);
//								md.open();
								JOptionPane.showMessageDialog(null, "Not a Number!", "False Entry", JOptionPane.ERROR_MESSAGE);
							}
						
						}	
					}
				}.run();
			}
			
		});
		
		Button btnEdit = new Button(composite, SWT.PUSH);
		btnEdit.setText("...");
		btnEdit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				
				new ECPCommand(getModelElement()) {
					
					@Override
					protected void doRun() {
						// TODO Auto-generated method stub
						boolean validInput = false;
						int SelectedIndex = listCtrl.getSelectionIndex();
						while(validInput == false){
							String input = JOptionPane.showInputDialog("Please Edit...", listCtrl.getItem(SelectedIndex).toString());
							try{
								if (input == null){
									return;
								}
								Long i = Long.valueOf(input);
							    listCtrl.remove(SelectedIndex);
								listCtrl.add(i.toString(), SelectedIndex);
							    data.remove(SelectedIndex);
							    data.addUnique(SelectedIndex, i);
							    validInput = true;
							}
							    
							catch (Exception e){
								JOptionPane.showMessageDialog(null, "Not a Number!", "False Entry", JOptionPane.ERROR_MESSAGE);
							}
							 
						}
						
					}
				}.run();
			}
			
		});
		
		Button btnDelete = new Button(composite, SWT.PUSH);
		btnDelete.setText("-");
		btnDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				
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
						// TODO Auto-generated method stub
							ArrayList<Long> al = new ArrayList<Long>();
							for(int i = 0; i < data.size(); i++){
								Long output = data.basicGet(i);
								al.add(output);
							}
							data.removeAll(al);
							listCtrl.removeAll();							
							Collections.sort(al);
							
							for (Long i : al){
								listCtrl.add(i.toString());
								data.addUnique(i);
							}
							}
					
							
						
						
					}.run();
				
			}
			
		});
		
		
		GridDataFactory.fillDefaults().span(4, 1).hint(40, 80).applyTo(listCtrl);
		GridDataFactory.fillDefaults().applyTo(btnAdd);
		GridDataFactory.fillDefaults().applyTo(btnEdit);
		GridDataFactory.fillDefaults().applyTo(btnDelete);
		GridDataFactory.fillDefaults().applyTo(btnSort);
		/*
		GridDataFactory.generate(btnAdd, 1, 1);
		GridDataFactory.generate(btnEdit, 1, 1);
		GridDataFactory.generate(btnDelete, 1, 1);
		GridDataFactory.generate(btnSort, 1, 1);
		*/
		gridLayout.makeColumnsEqualWidth = true;
//		GridBagLayout gridBagLayout = new GridBagLayout();
//		double[] doublelayout = new double[2];
//		doublelayout[0] = 5.0d;
//		doublelayout[1] = 2.0d;
//		int[] intlayout = new int[2];
//		intlayout[0] = 5;
//		intlayout[1] = 2;
//		gridBagLayout.columnWeights = doublelayout;
//		gridBagLayout.columnWidths = intlayout;
//		gridBagLayout.rowHeights = intlayout;
//		gridBagLayout.rowWeights = doublelayout;
		
		
		
		return composite;
	
	}

}
