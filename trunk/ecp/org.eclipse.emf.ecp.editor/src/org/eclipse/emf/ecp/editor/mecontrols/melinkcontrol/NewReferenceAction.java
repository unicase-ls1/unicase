/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.editor.mecontrols.melinkcontrol;

import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecp.common.MEClassLabelProvider;
import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.emf.ecp.common.model.ECPModelelementContext;
import org.eclipse.emf.ecp.common.util.ActionHelper;
import org.eclipse.emf.ecp.common.util.DialogHandler;
import org.eclipse.emf.ecp.common.util.OverlayImageDescriptor;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * An Action for adding reference links to a model element. It is mainly used in the {@link MEMultiLinkControl}
 * 
 * @author shterev
 */
public class NewReferenceAction extends ReferenceAction {

	private static final String DIALOG_MESSAGE = "Select a model element type to be created:";

	/**
	 * Command to create a new reference.
	 * 
	 * @author helming
	 */
	private final class NewReferenceCommand extends ECPCommand {

		public NewReferenceCommand(EObject eObject) {
			super(eObject);
		}

		@SuppressWarnings("unchecked")
		@Override
		protected void doRun() {

			if (!checkMultiplicity(false)) {
				return;
			}

			EClass clazz = eReference.getEReferenceType();
			EClass newClass = null;
			Set<EClass> subclasses = modelElementContext.getMetaModelElementContext().getAllSubEClasses(clazz, false);
			if (subclasses.size() == 1) {
				newClass = subclasses.iterator().next();
			} else {
				ElementListSelectionDialog dlg = new ElementListSelectionDialog(PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getShell(), new MEClassLabelProvider());
				dlg.setMessage(DIALOG_MESSAGE);
				dlg.setElements(subclasses.toArray());

				dlg.setTitle("Select Element type");
				dlg.setBlockOnOpen(true);
				if (dlg.open() != Window.OK) {
					return;
				}
				Object result = dlg.getFirstResult();
				if (result instanceof EClass) {
					newClass = (EClass) result;
				}
			}
			final EObject newMEInstance;

			EPackage ePackage = newClass.getEPackage();
			newMEInstance = ePackage.getEFactoryInstance().create(newClass);

			if (!eReference.isContainer()) {
				// Returns the value of the Container
				EObject parent = modelElement.eContainer();
				while (!(parent == null) && newMEInstance.eContainer() == null) {
					EReference reference = modelElementContext.getMetaModelElementContext()
						.getPossibleContainingReference(newMEInstance, parent);
					if (reference != null && reference.isMany()) {
						Object object = parent.eGet(reference);
						EList<EObject> eList = (EList<EObject>) object;
						eList.add(newMEInstance);
					}
					parent = parent.eContainer();
				}

				if (newMEInstance.eContainer() == null) {
					throw new RuntimeException("No matching container for model element found");
				}

			}

			// add the new object to the reference
			Object object = modelElement.eGet(eReference);
			if (isMultiReference()) {
				EList<EObject> eList = (EList<EObject>) object;
				eList.add(newMEInstance);
			} else {
				modelElement.eSet(eReference, newMEInstance);
			}

			ActionHelper.openModelElement(newMEInstance, this.getClass().getName());
		}

	}

	private final ECPModelelementContext modelElementContext;

	/**
	 * Default constructor.
	 * 
	 * @param modelElement the source model element
	 * @param eReference the target reference
	 * @param descriptor the descriptor used to generate display content
	 * @param modelElementContext the model element context
	 */
	public NewReferenceAction(EObject modelElement, EReference eReference, IItemPropertyDescriptor descriptor,
		ECPModelelementContext modelElementContext) {
		this.modelElement = modelElement;
		this.eReference = eReference;
		this.modelElementContext = modelElementContext;

		Object obj = null;
		// Only create a temporary object in order to get the correct icon from the label provider
		// the actual ME is created later on.
		if (!eReference.getEReferenceType().isAbstract()) {
			obj = eReference.getEReferenceType().getEPackage().getEFactoryInstance()
				.create(eReference.getEReferenceType());
		}
		Image image = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE)).getImage(obj);

		ImageDescriptor addOverlay = org.eclipse.emf.ecp.common.Activator.getImageDescriptor("icons/add_overlay.png");
		OverlayImageDescriptor imageDescriptor = new OverlayImageDescriptor(image, addOverlay,
			OverlayImageDescriptor.LOWER_RIGHT);
		setImageDescriptor(imageDescriptor);

		String attribute = descriptor.getDisplayName(eReference);

		// make singular attribute labels
		if (attribute.endsWith("ies")) {
			attribute = attribute.substring(0, attribute.length() - 3) + "y";
		} else if (attribute.endsWith("s")) {
			attribute = attribute.substring(0, attribute.length() - 1);
		}
		setToolTipText("Create and link new " + attribute);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		if (eReference.isContainer()) {
			DialogHandler.showErrorDialog("Operation not permitted for container references!");
			return;
		}
		new NewReferenceCommand(modelElement).run(true);
	}

	private boolean isMultiReference() {
		return (eReference.getUpperBound() != 1 && eReference.getUpperBound() != 0);
	}
}
