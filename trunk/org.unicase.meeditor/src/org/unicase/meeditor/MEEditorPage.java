package org.unicase.meeditor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.unicase.meeditor.mecontrols.MEControl;
import org.unicase.model.ModelElement;
import org.unicase.model.edit.uihint.FeatureUIHint;
import org.unicase.model.edit.uihint.UIHintAdapter;
import org.unicase.model.edit.uihint.UIHintAdapterImpl;
import org.unicase.model.provider.ModelItemProviderAdapterFactory;

public class MEEditorPage extends FormPage {

	EditingDomain editingDomain;
	ModelElement modelElement;
	Composite body;
	FormToolkit toolkit;
	List<MEControl> meControls = new ArrayList<MEControl>();
	UIHintAdapter uiHintAdapter;
	private ScrolledForm form;
	private List<IItemPropertyDescriptor> simpleAttributes = new ArrayList<IItemPropertyDescriptor>();
	private List<IItemPropertyDescriptor> multiReferences = new ArrayList<IItemPropertyDescriptor>();

	public MEEditorPage(MEEditor editor, String id, String title,
			EditingDomain editingDomain, ModelElement modelElement) {
		super(editor, id, title);
		this.editingDomain = editingDomain;
		this.modelElement = modelElement;
		uiHintAdapter = new UIHintAdapterImpl();
	}

	@Override
	protected void createFormContent(IManagedForm managedForm) {
		super.createFormContent(managedForm);
		toolkit = this.getEditor().getToolkit();
		form = managedForm.getForm();
		body = form.getBody();
		body.setLayout(new GridLayout());

		// Layout form
		form.setText(modelElement.getName());
		form.setImage(new AdapterFactoryLabelProvider(
				new ModelItemProviderAdapterFactory()).getImage(modelElement));
		// form.setHeadClient(toolkit.createButton(form, "Hallo", SWT.WRAP));

		// Sort and order attributes

		sortAndOrderAttributes();

		// Create attributes
		createSimpleAttributes();

		// Create Sections for every Reference
		createMultiReferences();

	}

	private void sortAndOrderAttributes() {
		AdapterFactoryItemDelegator adapterFactoryItemDelegator =new AdapterFactoryItemDelegator(new ModelItemProviderAdapterFactory());
		List<IItemPropertyDescriptor> propertyDescriptors = adapterFactoryItemDelegator.getPropertyDescriptors(modelElement);
		for (IItemPropertyDescriptor itemPropertyDescriptor: propertyDescriptors){
			if(itemPropertyDescriptor.isMany(modelElement)){
				multiReferences.add(itemPropertyDescriptor);
			}
			else{
				simpleAttributes.add(itemPropertyDescriptor);
			}
		}
		
	}

	private void createMultiReferences() {
		ControlFactory controlFactory = new ControlFactory(editingDomain,
				modelElement, this.getEditor().getToolkit());
		for (IItemPropertyDescriptor itemPropertyDescriptor : multiReferences) {
			MEControl meControl = controlFactory.createControl(itemPropertyDescriptor);
			if (meControl != null) {
				Control control = meControl.createControl(body, SWT.WRAP);
				control.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			}
		}

	}

	private void createSimpleAttributes() {

		Section attributeSection = toolkit.createSection(body,
				Section.DESCRIPTION | Section.TITLE_BAR | Section.TWISTIE
						| Section.EXPANDED);
		attributeSection.setText("Attributes");
		Composite attributeComposite = toolkit
				.createComposite(attributeSection);
		GridLayout attributeLayout = new GridLayout();
		attributeLayout.numColumns = 2;
		attributeComposite.setLayout(attributeLayout);
		attributeSection.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		ControlFactory controlFactory = new ControlFactory(editingDomain,
				modelElement, this.getEditor().getToolkit());
		for (IItemPropertyDescriptor itemPropertyDescriptor : simpleAttributes) {
			toolkit.createLabel(attributeComposite, itemPropertyDescriptor.getDisplayName(modelElement));
			MEControl meControl = controlFactory.createControl(itemPropertyDescriptor);
			Control control = meControl.createControl(attributeComposite,
					SWT.WRAP);
			control.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		}
		attributeSection.setClient(attributeComposite);

	}

}