package org.eclipse.emf.ecp.riena;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.emf.ecp.editor.mecontrols.AbstractMEControl;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.swt.SwtRidgetFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.ImageHyperlink;

/**
 * @author Lee
 * */

public class RienaDateControl extends AbstractMEControl {

private static final int PRIORITY = 2;
	
	private EAttribute attribute;
	private ImageHyperlink dateDeleteButton;
	private Composite dateComposite;
	private DateTime dateWidget;
	private IDateTimeRidget dateRidget;


	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject modelElement) {
		return PRIORITY;
	}

	@Override
	protected Control createControl(Composite parent, int style) {
		this.attribute = (EAttribute) getItemPropertyDescriptor().getFeature(getModelElement());
		dateComposite = getToolkit().createComposite(parent);
		GridLayoutFactory.fillDefaults().numColumns(2).spacing(2, 0).applyTo(dateComposite);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(dateComposite);
		dateComposite.setBackgroundMode(SWT.INHERIT_FORCE);
		
		createDateWidget();
		createDateRidget();
		
		IObservableValue model = EMFEditObservables.observeValue(getEditingDomain(), getModelElement(), attribute);
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		dbc.bindValue(SWTObservables.observeSelection(dateWidget), model, null, null);
		
		return dateWidget;
	}

	private void createDateRidget() {
		IDateTimeRidget dateRidget = (IDateTimeRidget) SwtRidgetFactory.createRidget(dateWidget);
		dateRidget.setUIControl(dateWidget);		
	}

	private void createDateWidget() {
		dateWidget = new DateTime(dateComposite, SWT.DATE);
		dateWidget.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		dateDeleteButton = new ImageHyperlink(dateComposite, SWT.TOP);
		dateDeleteButton.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE));
		dateDeleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				new ECPCommand(getModelElement()) {

					@Override
					protected void doRun() {
						getModelElement().eSet(attribute, null);
					}
				}.run(true);
			}
		});
	}
	
	public IDateTimeRidget getDateRidget() {
		return dateRidget;
	}
}
