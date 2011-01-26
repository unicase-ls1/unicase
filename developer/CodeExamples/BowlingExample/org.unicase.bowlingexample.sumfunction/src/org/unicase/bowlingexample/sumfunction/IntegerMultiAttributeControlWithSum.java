package org.unicase.bowlingexample.sumfunction;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.unicase.ui.meeditor.multiattribute.IntegerMultiAttributeControl;

public class IntegerMultiAttributeControlWithSum extends IntegerMultiAttributeControl {
	
	Label label;
	Composite composite;
	int style;

	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor,
			EObject modelElement) {
		int value = super.canRender(itemPropertyDescriptor, modelElement);
		if (value == DO_NOT_RENDER) {
			return DO_NOT_RENDER;
		}
		else {
			return ++value;
		}
	}

	@Override
	public Control createControl(Composite parent, int style) {
		this.style = style;
		composite = (Composite) super.createControl(parent, style);
		label = new Label(composite, style);
		super.reInitializeWidget();
		setSum();
		return composite;
	}
	
	@Override
	protected void refreshWidget() {
		super.refreshWidget();
		setSum();
	}
	
	@Override
	protected void reInitializeWidget() {
		label.dispose();
		label = new Label(composite, style);
		super.reInitializeWidget();
	}
	
	@SuppressWarnings("unchecked")
	private void setSum() {
		if (label != null) {
			// because refresh widget is called during super.createControl()
			int counter = 0;
			for (Integer i : (EDataTypeEList<Integer>) getModelElement().eGet(
					(EStructuralFeature) getItemPropertyDescriptor().getFeature(getModelElement()))) {
				counter += i;
			}
			label.setText("Sum: "+counter);			
		}
	}

}
