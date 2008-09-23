/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.meeditor.mecontrols.melinkcontrol;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
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
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.model.ModelElement;
import org.unicase.ui.common.MEClassLabelProvider;
import org.unicase.ui.common.commands.ActionHelper;
import org.unicase.ui.common.decorators.OverlayImageDescriptor;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.ui.common.util.UnicaseUtil;

/**
 * 
 * An Action for adding reference links to a model element. It is mainly used in
 * the {@link MEMultiLinkControl}
 * 
 * @author shterev
 * 
 */
public class NewReferenceAction extends Action {
	/**
	 * Command to create a new reference.
	 * 
	 * @author helming
	 * 
	 */
	private final class NewReferenceCommand extends RecordingCommand {
		private NewReferenceCommand(TransactionalEditingDomain domain) {
			super(domain);
		}

		@SuppressWarnings("unchecked")
		@Override
		protected void doExecute() {
			EClass clazz = eReference.getEReferenceType();
			EClass newClass = null;
			ArrayList<EClass> subclasses = UnicaseUtil.getSubclasses(clazz);
			if (subclasses.size() == 1) {
				newClass = clazz;
			} else {
				ElementListSelectionDialog dlg = new ElementListSelectionDialog(
						PlatformUI.getWorkbench().getActiveWorkbenchWindow()
								.getShell(), new MEClassLabelProvider());
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
			final ModelElement newMEInstance;

			EPackage ePackage = newClass.getEPackage();
			newMEInstance = (ModelElement) ActionHelper.createModelElement(
					ePackage.getEFactoryInstance(), newClass);
			newMEInstance.setName("new " + newClass.getName());

			if (!eReference.isContainer()) {
				modelElement.getProject().addModelElement(newMEInstance);
			}

			// add the new object to the reference
			Object object = modelElement.eGet(eReference);
			if (isMultiReference()) {
				EList<EObject> eList = (EList<EObject>) object;
				eList.add(newMEInstance);
			} else {
				modelElement.eSet(eReference, newMEInstance);
			}

			ActionHelper.openModelElement(newMEInstance);
		}
	}

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
	public NewReferenceAction(ModelElement modelElement, EReference eReference,
			IItemPropertyDescriptor descriptor) {
		this.modelElement = modelElement;
		this.eReference = eReference;

		Object obj = null;
		if (!eReference.getEReferenceType().isAbstract()) {
			obj = eReference.getEReferenceType().getEPackage()
					.getEFactoryInstance().create(
							eReference.getEReferenceType());
		}
		Image image = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE))
				.getImage(obj);

		ImageDescriptor addOverlay = org.unicase.ui.common.Activator
				.getImageDescriptor("icons/add_overlay.png");
		OverlayImageDescriptor imageDescriptor = new OverlayImageDescriptor(
				image, addOverlay, OverlayImageDescriptor.LOWER_RIGHT);
		setImageDescriptor(imageDescriptor);

		String attribute = descriptor.getDisplayName(eReference);

		// make singular attribute labels
		if (attribute.endsWith("ies")) {
			attribute = attribute.substring(0, attribute.length() - 3) + "y";
		} else if (attribute.endsWith("s")) {
			attribute = attribute.substring(0, attribute.length() - 1);
		}
		setToolTipText("Create and add new " + attribute);

	}

	/**
	 * {@inheritDoc}
	 */
	public void run() {
		if (eReference.isContainer()) {
			DialogHandler
					.showErrorDialog("Operation not permitted for container references!");
			return;
		}
		TransactionalEditingDomain domain = TransactionUtil
				.getEditingDomain(modelElement);
		domain.getCommandStack().execute(new NewReferenceCommand(domain));

	}

	private boolean isMultiReference() {
		return eReference.getUpperBound() == -1;
	}

}
