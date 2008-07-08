/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.meeditor.mecontrols.melinkcontrol;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.unicase.model.ModelElement;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;

/**
 * GUI Control for the ME reference multilinks.
 * 
 * @author helming
 * 
 */
public class MEMultiLinkControl extends AbstractMEControl {

	private final EReference eReference;

	private int style;
	private IItemPropertyDescriptor descriptor;

	private Composite linkArea;

	private Section section;

	private Composite composite;
	
	private ArrayList<MELinkControl> linkControls;
	private Adapter eAdapter;

	/**
	 * Default constructor. Default constructor.
	 * 
	 * @param toolkit
	 *            see {@link AbstractMEControl}
	 * @param modelElement
	 *            see {@link AbstractMEControl}
	 * @param editingDomain
	 *            see {@link AbstractMEControl}
	 * @param reference
	 *            the reference link
	 * @param descriptor
	 * 				?
	 */
	public MEMultiLinkControl(EObject modelElement, EReference reference, FormToolkit toolkit, EditingDomain editingDomain,
			IItemPropertyDescriptor descriptor) {
		super(editingDomain, modelElement, toolkit);
		this.eReference = reference;
		this.descriptor = descriptor;
		linkControls = new ArrayList<MELinkControl>();
		eAdapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.getFeature()!=null && msg.getFeature().equals(eReference)) {
					rebuildLinkSection();
				}
				super.notifyChanged(msg);
			}

		};
		this.modelElement.eAdapters().add(eAdapter);
	}

	/**
	 * {@inheritDoc}
	 */
	public Control createControl(final Composite parent, int style) {
		this.style = style;
		section = toolkit.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		section.setText(descriptor.getDisplayName(modelElement));
		composite = toolkit.createComposite(section, style);
		composite.setLayout(new GridLayout());
		linkArea = toolkit.createComposite(composite, style);
		linkArea.setLayout(new GridLayout());

		rebuildLinkSection();

		// JH: move Button in the titlebar
		Button addButton = toolkit.createButton(composite, "Add", SWT.PUSH);
		addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(modelElement);
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@SuppressWarnings("unchecked")
					@Override
					protected void doExecute() {
						EClass clazz = eReference.getEReferenceType();
						ElementListSelectionDialog dlg = new ElementListSelectionDialog(parent.getShell(), new AdapterFactoryLabelProvider(
								new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
						// JH: fill only with right elements
						Collection<ModelElement> allElements = ((ModelElement) modelElement).getProject().getAllModelElementsbyClass(clazz,
								new BasicEList<ModelElement>());
						allElements.remove(modelElement);
						Object objectList = modelElement.eGet(eReference);
						EList<EObject> list;
						if (objectList instanceof EList) {
							list = (EList<EObject>) objectList;
							for (EObject ref : list) {
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
			}
		});

		section.setClient(composite);
		return section;
	}

	/**
	 * Method for refreshing (rebuilding) the composite section.
	 */
	private void rebuildLinkSection() {
		for(MELinkControl link : linkControls){
			link.dispose();
		}
		linkControls.clear();
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(modelElement);
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@SuppressWarnings("unchecked")
			@Override
			protected void doExecute() {
				Object objectList = modelElement.eGet(eReference);
				if (objectList instanceof EList) {
					EList<EObject> eList = (EList<EObject>) objectList;
					for (EObject object : eList) {
						if (object instanceof ModelElement) {
							ModelElement me = (ModelElement) object;
							MELinkControl meControl = new MELinkControl(editingDomain, me, toolkit, modelElement, eReference);
							meControl.createControl(linkArea, style);
							linkControls.add(meControl);
						}
					}
				}
			}
		});
		linkArea.layout(true);
		section.setExpanded(false);
		section.setExpanded(true);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose(){
		modelElement.eAdapters().remove(eAdapter);
	}

}