package multiattributewidget_naguib;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ETypedElementImpl;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;

/**
 * This class creates a widget with multiple text fields for model attributes 
 * which upper bound is greater than 1 or less than 1 .
 * It renders strings only.
 */


public class MultiAttributeControl extends AbstractMEControl {
	private static final int PRIORITY = 2;
	private Button btnAdd;
	public MultiAttributeControl() {
		
	}
	
	@Override
	public int canRender(IItemPropertyDescriptor arg0, EObject arg1) {
		EStructuralFeature feature = (EStructuralFeature) arg0.getFeature(arg0);
		int attrUpperBound = getUpperBound(feature);
		if(attrUpperBound <1 || attrUpperBound ==-1)
		{
			return PRIORITY;
		}
		else
			return DO_NOT_RENDER;
	}

	@Override
	protected Control createControl(Composite parent, int style) {
		final Composite composite = new Composite(parent, style);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridLayout gridLayout = new GridLayout(3, false);
		composite.setLayout(gridLayout);
		// getting model elemets properties and data (feature= Model element's properties and data= data values of the Model element)
		final EStructuralFeature feature = (EStructuralFeature) getItemPropertyDescriptor().getFeature(getModelElement());
		//final EDataTypeEList<String> data = (EDataTypeEList<String>) getModelElement().eGet(feature);
		Label middleLabel = new Label(composite, SWT.LEFT);
		middleLabel.setText(feature.getName());
		final Text attText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		attText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		btnAdd = new Button(composite, SWT.PUSH);
		btnAdd.setText("+");
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				createTextField(btnAdd.getParent());
				btnAdd.getParent().layout();
				
			}
		});
		/*final Text attText2 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		attText2.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		*/
		return composite;			
	
	}
	

	/**
	 * Returns the upperbound of the model element that should be checked for rendering.
	 * @param feature is used to get the model element properties from it. 
	 * @return the upperbound value of the model element 
	 */
	
private int getUpperBound(Object feature) {
		
		ETypedElementImpl attr = null;
		int attrUpperBound = 0;
		if (feature instanceof ETypedElementImpl) {
			 attr = (ETypedElementImpl) feature;
			 attrUpperBound = attr.getUpperBound();
		}
		return attrUpperBound;
}

private Text createTextField (Composite parent)
{
	Text tempText= new Text(parent, SWT.SINGLE | SWT.BORDER);
 tempText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			return tempText;
}

}

