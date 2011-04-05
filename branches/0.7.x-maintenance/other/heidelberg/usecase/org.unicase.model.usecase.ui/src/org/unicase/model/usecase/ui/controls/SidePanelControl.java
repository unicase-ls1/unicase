package org.unicase.model.usecase.ui.controls;

import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.usecase.UseCase;
import org.unicase.ui.meeditor.ControlFactory;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;

/**
 * @author phil
 * @brief Renders the text fields positioned right beneath the flow of events
 */
public class SidePanelControl extends AbstractMEControl {

	private Composite mainComposite;
	private Composite infoComposite;
	private int style;

	private Color standardColor;

	private AbstractMEControl preconditionAbstract;
	private Control precondition;
	private AbstractMEControl descriptionAbstract;
	private Control description;
	private AbstractMEControl rulesAbstract;
	private Control rules;
	private AbstractMEControl postconditionAbstract;
	private Control postcondition;
	private AbstractMEControl exceptionAbstract;
	private Control exception;

	@Override
	protected Control createControl(Composite parent, int style) {

		this.style = style;
		mainComposite = getToolkit().createComposite(parent);
		mainComposite.setLayout(new GridLayout(1, true));
		standardColor = mainComposite.getDisplay().getSystemColor(SWT.COLOR_WHITE);
		initControl();
		return mainComposite;
	}

	/**
	 * Initializes all fields of the side panel control
	 */
	public void initControl() {
		if (infoComposite != null)
			infoComposite.dispose();
		infoComposite = getToolkit().createComposite(mainComposite);
		infoComposite.setLayout(new GridLayout());
		GridData grid_infoComposite = new GridData(GridData.FILL_BOTH);
		infoComposite.setLayoutData(grid_infoComposite);
		infoComposite.setBackground(standardColor);

		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		ControlFactory controlFactory = new ControlFactory(getEditingDomain(), getToolkit());

		// Precondition
		Label overview = getToolkit().createLabel(infoComposite, "Precondition");
		overview.setBackground(standardColor);
		Composite preconditionComposite = getToolkit().createComposite(infoComposite);
		GridLayout grid_preconditionComposite = new GridLayout();
		grid_preconditionComposite.marginHeight = 0;
		GridData gridData_precondition = new GridData(270, 80);
		gridData_precondition.grabExcessHorizontalSpace = true;
		preconditionComposite.setLayout(grid_preconditionComposite);
		preconditionComposite.setLayoutData(gridData_precondition);
		preconditionComposite.setBackground(standardColor);
		if (preconditionAbstract != null)
			preconditionAbstract.dispose();
		if (precondition != null)
			precondition.dispose();
		IItemPropertyDescriptor propertyDescriptor_precondition = adapterFactoryItemDelegator.getPropertyDescriptor(
			(UseCase) getModelElement(), "precon");
		preconditionAbstract = controlFactory.createControl(propertyDescriptor_precondition,
			(UseCase) getModelElement());
		precondition = preconditionAbstract.createControl(preconditionComposite, style,
			propertyDescriptor_precondition, (UseCase) getModelElement(), getEditingDomain(), getToolkit());
		precondition.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true));

		// Description
		Label overview2 = getToolkit().createLabel(infoComposite, "Description");
		overview2.setBackground(standardColor);
		Composite descriptionComposite = getToolkit().createComposite(infoComposite);
		GridLayout grid_descriptionComposite = new GridLayout();
		grid_descriptionComposite.marginHeight = 0;
		GridData gridData_description = new GridData(270, 80);
		gridData_description.grabExcessHorizontalSpace = true;
		descriptionComposite.setLayout(grid_descriptionComposite);
		descriptionComposite.setLayoutData(gridData_description);
		descriptionComposite.setBackground(standardColor);
		if (descriptionAbstract != null)
			descriptionAbstract.dispose();
		if (description != null)
			description.dispose();
		IItemPropertyDescriptor propertyDescriptor_description = adapterFactoryItemDelegator.getPropertyDescriptor(
			(UseCase) getModelElement(), "description");
		descriptionAbstract = controlFactory.createControl(propertyDescriptor_description, (UseCase) getModelElement());
		description = descriptionAbstract.createControl(descriptionComposite, style, propertyDescriptor_description,
			(UseCase) getModelElement(), getEditingDomain(), getToolkit());
		description.setBackground(standardColor);
		description.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true));

		// Rules
		Label overview3 = getToolkit().createLabel(infoComposite, "Rules");
		overview3.setBackground(standardColor);
		Composite rulesComposite = getToolkit().createComposite(infoComposite);
		GridLayout grid_rulesComposite = new GridLayout();
		grid_rulesComposite.marginHeight = 0;
		GridData gridData_rules = new GridData(270, 80);
		gridData_rules.grabExcessHorizontalSpace = true;
		rulesComposite.setLayout(grid_rulesComposite);
		rulesComposite.setLayoutData(gridData_rules);
		rulesComposite.setBackground(standardColor);
		if (rulesAbstract != null)
			rulesAbstract.dispose();
		if (rules != null)
			rules.dispose();
		IItemPropertyDescriptor propertyDescriptor_rules = adapterFactoryItemDelegator.getPropertyDescriptor(
			(UseCase) getModelElement(), "rul");
		rulesAbstract = controlFactory.createControl(propertyDescriptor_rules, (UseCase) getModelElement());
		rules = rulesAbstract.createControl(rulesComposite, style, propertyDescriptor_rules,
			(UseCase) getModelElement(), getEditingDomain(), getToolkit());
		rules.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true));

		// Postcondition
		Label overview4 = getToolkit().createLabel(infoComposite, "Postcondition");
		overview4.setBackground(standardColor);
		Composite postconditionComposite = getToolkit().createComposite(infoComposite);
		GridLayout grid_postconditionComposite = new GridLayout();
		grid_postconditionComposite.marginHeight = 0;
		GridData gridData_postcondition = new GridData(270, 80);
		gridData_postcondition.grabExcessHorizontalSpace = true;
		postconditionComposite.setLayout(grid_postconditionComposite);
		postconditionComposite.setLayoutData(gridData_postcondition);
		postconditionComposite.setBackground(standardColor);
		if (postconditionAbstract != null)
			postconditionAbstract.dispose();
		if (postcondition != null)
			postcondition.dispose();
		IItemPropertyDescriptor propertyDescriptor_postcondition = adapterFactoryItemDelegator.getPropertyDescriptor(
			(UseCase) getModelElement(), "postcon");
		postconditionAbstract = controlFactory.createControl(propertyDescriptor_postcondition,
			(UseCase) getModelElement());
		postcondition = postconditionAbstract.createControl(postconditionComposite, style,
			propertyDescriptor_postcondition, (UseCase) getModelElement(), getEditingDomain(), getToolkit());
		postcondition.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true));

		// Exception
		Label overview5 = getToolkit().createLabel(infoComposite, "Exception");
		overview5.setBackground(standardColor);
		Composite exceptionComposite = getToolkit().createComposite(infoComposite);
		GridLayout grid_exceptionComposite = new GridLayout();
		grid_exceptionComposite.marginHeight = 0;
		GridData gridData_exception = new GridData(270, 80);
		gridData_exception.grabExcessHorizontalSpace = true;
		exceptionComposite.setLayout(grid_exceptionComposite);
		exceptionComposite.setLayoutData(gridData_exception);
		exceptionComposite.setBackground(standardColor);
		if (exceptionAbstract != null)
			exceptionAbstract.dispose();
		if (exception != null)
			exception.dispose();
		IItemPropertyDescriptor propertyDescriptor_exception = adapterFactoryItemDelegator.getPropertyDescriptor(
			(UseCase) getModelElement(), "exc");
		exceptionAbstract = controlFactory.createControl(propertyDescriptor_exception, (UseCase) getModelElement());
		exception = exceptionAbstract.createControl(exceptionComposite, style, propertyDescriptor_exception,
			(UseCase) getModelElement(), getEditingDomain(), getToolkit());
		exception.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true));

		mainComposite.layout();
	}

	@Override
	public void dispose() {
		if (preconditionAbstract != null)
			preconditionAbstract.dispose();
		if (precondition != null)
			precondition.dispose();
		if (descriptionAbstract != null)
			descriptionAbstract.dispose();
		if (description != null)
			description.dispose();
		if (rulesAbstract != null)
			rulesAbstract.dispose();
		if (rules != null)
			rules.dispose();
		if (postconditionAbstract != null)
			postconditionAbstract.dispose();
		if (postcondition != null)
			postcondition.dispose();
		if (exceptionAbstract != null)
			exceptionAbstract.dispose();
		if (exception != null)
			exception.dispose();

		super.dispose();
	}

	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, ModelElement modelElement) {
		// TODO Auto-generated method stub
		return -1;
	}

}
