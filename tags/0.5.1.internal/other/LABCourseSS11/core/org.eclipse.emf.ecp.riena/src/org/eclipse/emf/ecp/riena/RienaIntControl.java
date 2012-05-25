package org.eclipse.emf.ecp.riena;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.editor.mecontrols.AbstractMEControl;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.ridgets.ISpinnerRidget;
import org.eclipse.riena.ui.ridgets.swt.SwtRidgetFactory;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Spinner;


/**
 * @author Haunolder & Lee
 * **/

public class RienaIntControl extends AbstractMEControl {
	
	private EAttribute attribute;
	private ISpinnerRidget spinnerRidget;
	private Spinner swtSpinner;
	private static final int PRIORITY = 2;
	

	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject modelElement) {
		Object feature = itemPropertyDescriptor.getFeature(modelElement);
		if (feature instanceof EAttribute && ((EAttribute) feature).getEType().getInstanceClass().equals(int.class)
			&& !((EAttribute) feature).isMany()) {

			return PRIORITY;
		}
		return AbstractMEControl.DO_NOT_RENDER;
	}

	@Override
	protected Control createControl(Composite parent, int style) {
		Object feature = getItemPropertyDescriptor().getFeature(getModelElement());
		this.attribute = (EAttribute) feature;
		swtSpinner = new Spinner(parent, style);
		swtSpinner.setMinimum(0);
		swtSpinner.setMaximum(1000);
		
		GridDataFactory.fillDefaults().grab(true, false).applyTo(swtSpinner);
		
		createSpinnerRidget();
		
		IObservableValue model = EMFEditObservables.observeValue(getEditingDomain(), getModelElement(), attribute);	
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		dbc.bindValue(SWTObservables.observeSelection(swtSpinner), model, null, null);

		return swtSpinner;
	}
	
	private void createSpinnerRidget() {
		spinnerRidget = (ISpinnerRidget) SwtRidgetFactory.createRidget(swtSpinner);
		spinnerRidget.setUIControl(swtSpinner);
	}

	public ISpinnerRidget getSpinnerRidget() {
		return spinnerRidget;
	}
	
	
}
