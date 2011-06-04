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
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.swt.SwtRidgetFactory;
import org.eclipse.riena.ui.ridgets.validation.MinLength;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

/**
 * @author Haunolder
 * **/


public class RienaTextControl extends AbstractMEControl {

	private Text text;
	private ITextRidget textRidget;
	private EAttribute attribute;
	private static final int PRIORITY = 3;

	/**
	 * {@inheritDoc}
	 * 
	 * @return A Text Control.
	 */
	@Override
	public Control createControl(Composite parent, int style) {
		Object feature = getItemPropertyDescriptor().getFeature(getModelElement());
		this.attribute = (EAttribute) feature;
		text = getToolkit().createText(parent, new String(), style | SWT.SINGLE);
		if (!getItemPropertyDescriptor().canSetProperty(getModelElement())) {
			text.setEditable(false);
		}
		
		createTextRidget();
		
		IObservableValue model = EMFEditObservables.observeValue(getEditingDomain(), getModelElement(), attribute);
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		dbc.bindValue(SWTObservables.observeText(text, SWT.FocusOut), model, null, null);
		
		return  text;
	}
	
	private void createTextRidget() {
		textRidget = (ITextRidget) SwtRidgetFactory.createRidget(text);
		textRidget.addValidationRule(new MinLength(5), ValidationTime.ON_UI_CONTROL_EDIT);
		textRidget.setUIControl(text);
	}
	

	public ITextRidget getTextRidget() {
		return textRidget;
	}

	/**
	 * . This sets the keyboard focus in Text control.
	 */
	public void setFocus() {
		this.text.setFocus();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void applyCustomLayoutData() {
		GridDataFactory.fillDefaults().grab(true, false).hint(250, 16).align(SWT.FILL, SWT.TOP).applyTo(text);
	}

	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject modelElement) {
		Object feature = itemPropertyDescriptor.getFeature(modelElement);
		if (feature instanceof EAttribute && ((EAttribute) feature).getEType().getInstanceClass().equals(String.class)) {
			return PRIORITY;
		}
		return AbstractMEControl.DO_NOT_RENDER;
	}
}
