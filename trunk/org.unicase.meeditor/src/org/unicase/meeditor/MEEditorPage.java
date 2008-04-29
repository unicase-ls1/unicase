package org.unicase.meeditor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.EditingDomain;
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
import org.unicase.model.ModelElement;
import org.unicase.model.provider.ModelItemProviderAdapterFactory;

public class MEEditorPage extends FormPage {

	EditingDomain editingDomain;
	ModelElement modelElement;
	Composite body;
	FormToolkit toolkit;
	List<MEControl> meControls = new ArrayList<MEControl>();
	private ScrolledForm form;

	public MEEditorPage(MEEditor editor, String id, String title,
			EditingDomain editingDomain, ModelElement modelElement) {
		super(editor, id, title);
		this.editingDomain = editingDomain;
		this.modelElement = modelElement;
	}

	@Override
	protected void createFormContent(IManagedForm managedForm) {
		super.createFormContent(managedForm);
		toolkit = this.getEditor().getToolkit();
		form = managedForm.getForm();
		body = form.getBody();
		body.setLayout(new GridLayout());
		
		//Layout form
		form.setText(modelElement.getName());
		form.setImage(new AdapterFactoryLabelProvider(new ModelItemProviderAdapterFactory()).getImage(modelElement));
		//form.setHeadClient(toolkit.createButton(form, "Hallo", SWT.WRAP));

		// Sort and order attributes

		// Create attributes
		createAttributes();
		
		

		// Create Sections for every Reference
		createReferences();
				
	}

	private void createReferences() {
		EList<EReference> references = modelElement.eClass()
				.getEAllReferences();
		ControlFactory controlFactory = new ControlFactory(editingDomain,
				modelElement,  this.getEditor().getToolkit());
		for (EReference reference : references) {
			MEControl meControl = controlFactory.createControl(reference);
			if (meControl != null) {
				Control control = meControl.createControl(body, SWT.WRAP);
				control.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			}
		}

	}

	private void createAttributes() {

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
				modelElement,  this.getEditor().getToolkit());
		EList<EAttribute> attributes = modelElement.eClass()
				.getEAllAttributes();
		for (EAttribute attribute : attributes) {
			toolkit.createLabel(attributeComposite, attribute.getName() + ":");
			MEControl meControl = controlFactory.createControl(attribute);
			Control control = meControl.createControl(attributeComposite,
					SWT.WRAP);
			control.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		}
		attributeSection.setClient(attributeComposite);

	}
	
}