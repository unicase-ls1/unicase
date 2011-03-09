package org.unicase.model.usecase.ui.pages;

import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.usecase.UseCase;
import org.unicase.model.usecase.ui.controls.FlowOfEventsControl;
import org.unicase.ui.meeditor.AbstractMEEditorPage;
import org.unicase.ui.meeditor.MEEditor;
import org.unicase.workspace.Configuration;

/**
 * @author phil
 * @brief Flow of events page. This implementation is based on MEDescriptionPage.java in
 *        org.unicase.ui.unicasecommon.meeditor due to shterev & koegel
 */
public class MEFlowOfEventsPage extends AbstractMEEditorPage {

	private final class FormPageExtended extends FormPage {
		private FormPageExtended(FormEditor editor, String id, String title) {
			super(editor, id, title);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected void createFormContent(IManagedForm managedForm) {

			super.createFormContent(managedForm);

			// create standard UNICASE design for page
			toolkit = this.getEditor().getToolkit();

			if (form != null) {
				form.dispose();
			}

			form = managedForm.getForm();

			toolkit.decorateFormHeading(form.getForm());
			form.setText(getEditor().getTitle() + ": Flow of Events");

			if (flowOfEventsArea != null) {
				flowOfEventsArea.dispose();
			}
			// set standard Grid Layout for Flow of Events Area
			form.getBody().setLayout(new GridLayout());
			flowOfEventsArea = new Composite(form.getBody(), SWT.NONE);
			flowOfEventsArea.setLayout(new GridLayout());

			// create a property descriptor required by the AbstractMEControl interface
			AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
				new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
			IItemPropertyDescriptor propertyDescriptor = adapterFactoryItemDelegator.getPropertyDescriptor(
				parentUseCase, "actorSteps");
			TransactionalEditingDomain domain = Configuration.getEditingDomain();

			// create Flow of Events Control (explicitly instead of registering it as an extension)
			if (abstractFlowOfEventsControl != null)
				abstractFlowOfEventsControl.dispose();
			if (flowOfEventsControl != null)
				flowOfEventsControl.dispose();
			abstractFlowOfEventsControl = new FlowOfEventsControl();
			flowOfEventsControl = abstractFlowOfEventsControl.createControl(flowOfEventsArea, SWT.WRAP,
				propertyDescriptor, parentUseCase, domain, toolkit);

			// set bounds and background color
			Color colorWhite = form.getDisplay().getSystemColor(SWT.COLOR_WHITE);
			flowOfEventsArea.setBackground(colorWhite);
			flowOfEventsArea.setBounds(0, 0, 1220, 1020);
			flowOfEventsControl.setBounds(10, 10, 1200, 1000);

			abstractFlowOfEventsControl.setContext(form);
			form.pack();

			form.addDisposeListener(new DisposeListener() {

				public void widgetDisposed(DisposeEvent e) {
					abstractFlowOfEventsControl.dispose();
					if (!flowOfEventsControl.isDisposed())
						flowOfEventsControl.dispose();
				}

			});
		}

		@Override
		public void setFocus() {
			flowOfEventsControl.setFocus();
		}

	}

	// register page as extension with the following id:
	private static final String ID = "org.unicase.model.usecase.ui.pages.meflowofevents";
	private static final String NAME = "Flow of Events";

	private ModelElement parentUseCase;
	private Composite flowOfEventsArea;
	// The control for the use Case Steps
	private FlowOfEventsControl abstractFlowOfEventsControl;
	private Control flowOfEventsControl;

	// Standard variables needed for the layout of page in UNICASE design
	private FormToolkit toolkit;
	private ScrolledForm form;

	@Override
	public FormPage createPage(MEEditor editor, EditingDomain editingDomain, ModelElement modelElement) {
		if (!(modelElement instanceof UseCase)) {
			// Page only relevant for Use Cases, but Model Element is not
			return null;
		} else {
			// Model Element is a Use Case
			parentUseCase = modelElement;
			FormPage page = new FormPageExtended(editor, ID, NAME);

			return page;
		}

	}

}
