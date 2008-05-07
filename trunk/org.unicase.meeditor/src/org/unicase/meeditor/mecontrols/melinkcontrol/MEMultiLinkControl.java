package org.unicase.meeditor.mecontrols.melinkcontrol;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.forms.HyperlinkGroup;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.unicase.meeditor.mecontrols.AbstractMEControl;
import org.unicase.model.ModelElement;
import org.unicase.model.provider.ModelItemProviderAdapterFactory;

public class MEMultiLinkControl extends AbstractMEControl {

	
	final EReference eReference;
	
	Section section;
	Composite composite;
	EList<EObject> value;
	HyperlinkGroup hyperLinkGroup;
	List<Composite> linkComposites;
	Composite linkArea;
	int style;
	private IItemPropertyDescriptor descriptor;

	public MEMultiLinkControl(EObject modelElement, EReference reference,
			FormToolkit toolkit, EditingDomain editingDomain, IItemPropertyDescriptor descriptor) {
		super(editingDomain, modelElement, toolkit);
		this.eReference = reference;
		this.descriptor=descriptor;
		linkComposites = new ArrayList<Composite>();
		
		modelElement.eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.getFeature().equals(eReference)) {
					rebuildLinkSection();
				}
				super.notifyChanged(msg);
			}

		});
	}

	public Control createControl(final Composite parent, int style) {
		this.style = style;
		section = toolkit.createSection(parent, Section.DESCRIPTION
				| Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		section.setText(descriptor.getDisplayName(modelElement));
		composite = toolkit.createComposite(section, style);
		composite.setLayout(new GridLayout());

		linkArea = toolkit.createComposite(composite, style);
		linkArea.setLayout(new GridLayout());

		hyperLinkGroup = new HyperlinkGroup(composite.getDisplay());

		rebuildLinkSection();

		// JH: move Button in the titlebar
		Button editButton = toolkit.createButton(composite, "Add", SWT.PUSH);
		editButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				Class<? extends EObject> clazz = (Class<? extends EObject>) eReference
						.getEReferenceType().getInstanceClass();
				ElementListSelectionDialog dlg = new ElementListSelectionDialog(
						parent.getShell(), new AdapterFactoryLabelProvider(
								new ModelItemProviderAdapterFactory()));
				// JH: fill only with right elements
				Collection<ModelElement> allElements = ((ModelElement) modelElement)
						.getProject().getElementsByClass(clazz);
				allElements.remove(modelElement);
				Object objectList = modelElement.eGet(eReference);
				EList<EObject> list;
				if (objectList instanceof EList) {
					list = (EList<EObject>) objectList;
					for(EObject ref: list){
						allElements.remove(ref);
					}
					dlg.setElements(allElements.toArray());
					dlg.setTitle("Select Elements");
					dlg.setBlockOnOpen(true);
					if (dlg.open() == Window.OK) {
						Object[] result = dlg.getResult();
						for (Object object : result) {
							if (object instanceof EObject) {
								EObject eObject = (EObject) object;
								list.add(eObject);
							}
						}

					}
				}
			}

		});

		section.setClient(composite);
		return section;
	}

	public void rebuildLinkSection() {
		value = (EList<EObject>) modelElement.eGet(eReference);
		if (linkComposites != null) {
			for (Composite composite : linkComposites) {
				composite.dispose();
			}
		}
		MELinkControl meControl;
		for (EObject object : value) {
			if (object instanceof ModelElement) {
				
				ModelElement me = (ModelElement) object;
				meControl= new MELinkControl(editingDomain, me, toolkit, modelElement, eReference);
				Composite linkComposite = (Composite)meControl.createControl(linkArea, style);
				linkComposites.add(linkComposite);
			}
		}
		// Force relayout.
		section.setExpanded(false);
		section.setExpanded(true);

	}

}
