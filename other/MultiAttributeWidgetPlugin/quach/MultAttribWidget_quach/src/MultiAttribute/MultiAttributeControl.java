package MultiAttribute;



import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ETypedElementImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.unicase.ui.common.commands.ECPCommand;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;

import org.eclipse.jface.action.Action;

/*
 * This class creates a widget for model attributes 
 * which upper bound is greater than 2.
 * Currently it renders string objects and integer object only. 
 */
public class MultiAttributeControl extends AbstractMEControl {

	private static final int PRIORITY = 2;
	private List listCtrl = null;
	private EDataTypeEList<Object> data; 
	
	public MultiAttributeControl() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * Changes position from items in listcontrol. This method
	 * is used e.g. by the Up and Down buttons.
	 */
	private void changeListCtrlItems(int targetIndex, int sourceIndex) {
		
		data.move(targetIndex, sourceIndex);
		String tmp = listCtrl.getItem(targetIndex);
		listCtrl.setItem(targetIndex, listCtrl.getItem(sourceIndex));
		listCtrl.setItem(sourceIndex, tmp);
		listCtrl.deselect(sourceIndex);
		listCtrl.select(targetIndex);		
	}

	private int getUpperBound(Object feature) {
		
		ETypedElementImpl attr = null;
		int attrUpperBound = 0;
		if (feature instanceof ETypedElementImpl) {
			 attr = (ETypedElementImpl) feature;
			 attrUpperBound = attr.getUpperBound();
		}
		return attrUpperBound;
	}
	
	/*
	 * Returns data type from current model attribute as string.
	 */
	private String getEType(Object feature) {
		
		ETypedElementImpl attr = null;
		String result = null ;
		if (feature instanceof ETypedElementImpl) {
			 attr = (ETypedElementImpl) feature;
			 result = attr.getEType().getInstanceClassName();
		}
		return result;
	}
	
	/*
	 * Creates an inputdialog in block mode. Returns typed string. 
	 */
	private String InputDialog(String title, String msg, String value, IInputValidator validator) {
		InputDialog dlg = new InputDialog(null, title, msg, value, validator);
		dlg.setBlockOnOpen(true);
		dlg.open();
		return dlg.getValue();
	}
	
	
	/*
	 * Factory function for input validator.
	 */
	private  IInputValidator FactoryInputValidator(EStructuralFeature feature) {
		
		if (modelAttrIsInteger(feature)) {
			
		
			return new IInputValidator() {
				
				public String isValid(String newText) {
					
					try {
						if (newText.equals("")) return null;
						Integer.parseInt(newText);
						return null;
					}
					catch(NumberFormatException e) {
						return "Only integer values are allowed!";
					}
				}
			};
		}
		else return null;
	}
	
	/*
	 * Checking whether the current attribute in model is an integer object.
	 */
	private boolean modelAttrIsInteger(EStructuralFeature feature) {
		String classname = getEType(feature);
		if (classname.equalsIgnoreCase("java.lang.Integer")) return true;
		return false;
	}
	
	/*
	 * Checking whether current attribute in model is an string object.
	 */
	private boolean modelAttrIsString(EStructuralFeature feature) {
		String classname = getEType(feature);
		if (classname.equalsIgnoreCase("java.lang.String")) return true;
		return false;
	}
	
	@Override
	public int canRender(IItemPropertyDescriptor arg0, EObject arg1) {
		
		EStructuralFeature feature = (EStructuralFeature) arg0.getFeature(arg0);
		int attrUpperBound = getUpperBound(feature);
		if (modelAttrIsString(feature) || modelAttrIsInteger(feature)) {
			if (attrUpperBound == -1 || attrUpperBound > 1 ) return PRIORITY;
		}
		 
		return DO_NOT_RENDER;
		
	}

	@Override
	protected Control createControl(Composite parent, int style) {
		Composite composite = getToolkit().createComposite(parent, style);
		GridLayout gridLayout = new GridLayout(2, false);
		composite.setLayout(gridLayout);
		listCtrl = new List(composite, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		Button btnAdd = new Button(composite, SWT.PUSH);
		btnAdd.setText("Add");
		Button btnDelete = new Button(composite, SWT.PUSH);
		btnDelete.setText("Delete");
		Button btnUp = new Button(composite, SWT.PUSH);
		btnUp.setText("Up");
		Button btnDown = new Button(composite, SWT.PUSH);
		btnDown.setText("Down");
		
		final EStructuralFeature feature = (EStructuralFeature) getItemPropertyDescriptor().getFeature(getModelElement());
		data = (EDataTypeEList<Object>) getModelElement().eGet(feature);
		
		// filling Values:
		for (Object obj :data) {
			listCtrl.add(obj.toString());
		}
		
		// actions:
		
		final Action add = new Action("Add", SWT.PUSH) {
			
			@Override 
			public void run() {
				new ECPCommand(getModelElement()) {
									
					@Override
					protected void doRun() {
						
						int upperBound = getUpperBound(feature);
						if (upperBound == -1 || listCtrl.getItemCount() < upperBound ) {
							String input = InputDialog("Adding new value", "Please insert new value.", null,FactoryInputValidator(feature));
							if (!input.equals("")) {
								
								Object obj = null;
								if(modelAttrIsInteger(feature)) obj = Integer.parseInt(input);
								else obj = input;
								data.add(obj);
								//getModelElement().eSet(feature, data);
								listCtrl.add(input);
							}
						}
						else {
							Shell shell = new Shell(listCtrl.getDisplay());
							MessageBox msgBox = new MessageBox(shell, SWT.ICON_ERROR);
							msgBox.setMessage("Model supports " + upperBound + " Item only!");
							msgBox.open();
						}
						
					};
				}.run();
			}
		};
		
		final Action edit = new Action() {
			
			@Override 
			public void run() {
				new ECPCommand(getModelElement()) {
									
					@Override
					protected void doRun() {

						int idx = listCtrl.getSelectionIndex();
						String defaultVal = listCtrl.getItem(idx);						
						String input = InputDialog("Edit value...", "Please insert new value.", defaultVal, null);
						if (!input.equals("")) {
							Object obj = null;
							if (modelAttrIsInteger(feature)) obj = Integer.parseInt(input);
							obj = input;
							data.set(idx, obj);
							listCtrl.setItem(idx, input);
							//getModelElement().eSet(feature, data);
						}
						
					};
				}.run();
			}
		};
		
		final Action delete = new Action() {
			
			@Override
			public void run() {
				
				new ECPCommand(getModelElement()) {
					
					@Override
					protected void doRun() {
						int[] indices = listCtrl.getSelectionIndices();
						
						for (int idx = indices.length-1; idx>=0; idx--) {
							data.remove(indices[idx]);
						}
						listCtrl.remove(indices);
					}
				}.run();
			}
		};
		
		final Action up = new Action() {
			
			@Override
			public void run() {
				
				new ECPCommand(getModelElement()) {
					
					@Override
					protected void doRun() {
						
						if (listCtrl.getSelectionCount() == 1) {
							int idx = listCtrl.getSelectionIndex();
							if (idx != 0) {
								changeListCtrlItems(idx-1, idx);
							}
						}
					}
				}.run();
			}
		};

		final Action down = new Action() {
			
			@Override
			public void run() {
				
				new ECPCommand(getModelElement()) {
					
					@Override
					protected void doRun() {
						
						if (listCtrl.getSelectionCount() == 1) {
							int idx = listCtrl.getSelectionIndex();
							if (idx != listCtrl.getItemCount()-1) {
								changeListCtrlItems(idx+1, idx);
							}
						}
					}
				}.run();
			}
		};

		
		// Listeners:
		
		listCtrl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				if (listCtrl.getSelectionCount() == 1) {
					edit.run();
				}
			}
		});
		
		listCtrl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.stateMask & SWT.CTRL)!=0) {
					if (e.keyCode == SWT.ARROW_UP) up.run();
					else if (e.keyCode == SWT.ARROW_DOWN) down.run();
				}
				else {
					switch (e.keyCode) {
						case SWT.DEL:
							delete.run();
							break;
						case 43:	// '+'
							add.run();
							break;
						case 13:	// 'enter'
							edit.run();
							break;
					}
				}
			}
		});
		
		
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				add.run();
				
			}
		});
		
		
		btnDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//listCtrl.remove(listCtrl.getSelectionIndex());
				delete.run();
			}
		});
		
		btnUp.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				up.run();
			}
		});

		btnDown.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				down.run();
			}
		});

		
		// layouting
		GridDataFactory.fillDefaults().span(1, 5).hint(100, 200).applyTo(listCtrl);
		GridDataFactory.fillDefaults().applyTo(btnAdd);
		GridDataFactory.fillDefaults().applyTo(btnDelete);
		GridDataFactory.fillDefaults().applyTo(btnUp);
		GridDataFactory.fillDefaults().applyTo(btnDown);
		
		return composite;
	}

}
