/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.meeditor;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.model.ModelElement;
import org.unicase.ui.common.decorators.OverlayImageDescriptor;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MEMultiLinkControl;

/**
 * 
 * An Action for adding reference links to a model element. It is mainly used in
 * the {@link MEMultiLinkControl}
 * 
 * @author shterev
 * 
 */
public class AddReferenceAction extends Action {

	private EReference eReference;
	private ModelElement modelElement;

	/**
	 * Default constructor.
	 * 
	 * @param modelElement
	 *            the source model element
	 * @param eReference
	 *            the target reference
	 * @param descriptor
	 *            the descriptor used to generate display content
	 */
	public AddReferenceAction(ModelElement modelElement, EReference eReference,
			IItemPropertyDescriptor descriptor) {
		this.modelElement = modelElement;
		this.eReference = eReference;
		
		
		Object obj = null;
		if(!eReference.getEReferenceType().isAbstract()){
			obj = eReference.getEReferenceType().getEPackage().getEFactoryInstance().create(eReference.getEReferenceType());
		}
		Image image = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)).getImage(obj);
		
		ImageDescriptor addOverlay = org.unicase.ui.common.Activator.getImageDescriptor("icons/link_overlay.png");
		OverlayImageDescriptor imageDescriptor = new OverlayImageDescriptor(image,addOverlay,OverlayImageDescriptor.LOWER_RIGHT);
		setImageDescriptor(imageDescriptor);

		String attribute = descriptor.getDisplayName(eReference);
		// make singular attribute labels
		if (attribute.endsWith("ies")) {
			attribute = attribute.substring(0, attribute.length() - 3) + "y";
		} else if (attribute.endsWith("s")) {
			attribute = attribute.substring(0, attribute.length() - 1);
		}
		
		String action;
		if(isMultiReference()){
			action = "Add";
		}else{
			action = "Set";
		}
		setToolTipText(action+" new " + attribute);

	}

	/**
	 * {@inheritDoc}
	 */
	public void run() {
		TransactionalEditingDomain domain = TransactionUtil
				.getEditingDomain(modelElement);
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@SuppressWarnings("unchecked")
			@Override
			protected void doExecute() {
				EClass clazz = eReference.getEReferenceType();
				ElementListSelectionDialog dlg = new ElementListSelectionDialog(
						PlatformUI.getWorkbench().getActiveWorkbenchWindow()
								.getShell(),
						new AdapterFactoryLabelProvider(
								new ComposedAdapterFactory(
										ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
				Collection<ModelElement> allElements = ((ModelElement) modelElement)
						.getProject().getAllModelElementsbyClass(clazz,
								new BasicEList<ModelElement>());
				allElements.remove(modelElement);
				Object objectList = modelElement.eGet(eReference);
				EList<EObject> list;
				if (objectList instanceof EList) {
					list = (EList<EObject>) objectList;
					for (EObject ref : list) {
						allElements.remove(ref);
					}
					dlg.setMultipleSelection(isMultiReference());
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
	
	private boolean isMultiReference(){
		return eReference.getUpperBound()==-1;
	}

}
