/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.editor.mecontrols.melinkcontrol.associationclasscontrol;

import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecp.common.MEClassLabelProvider;
import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.emf.ecp.common.model.ECPModelelementContext;
import org.eclipse.emf.ecp.common.model.workSpaceModel.util.AssociationClassHelper;
import org.eclipse.emf.ecp.common.util.ActionHelper;
import org.eclipse.emf.ecp.common.util.OverlayImageDescriptor;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * This class provides the icon and command to create a new object and link it with a given object over an
 * AssociationClassElement.
 * 
 * @author Michael Haeger
 */
public class NewAssociationClassAction extends Action {

	private static final String DIALOG_MESSAGE = "Select a model element type to be created:";

	private EReference eReference;
	private EObject modelElement;
	private final ECPModelelementContext context;

	/**
	 * The create command.
	 * 
	 * @author Michael Haeger
	 */
	private final class NewAssociationClassCommand extends ECPCommand {

		public NewAssociationClassCommand(EObject eObject) {
			super(eObject);
		}

		@SuppressWarnings({ "unchecked" })
		@Override
		protected void doRun() {
			EClass relatedModelElementClass = null;
			Set<EClass> subclasses = context.getMetaModelElementContext().getAllSubEClasses(modelElement.eClass(),
				false);
			// select object type to create
			if (subclasses.size() == 1) {
				relatedModelElementClass = subclasses.iterator().next();
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
					relatedModelElementClass = (EClass) result;
				}
			}
			// create the other side of the association
			EPackage ePackage = relatedModelElementClass.getEPackage();
			final EObject relatedModelElement = ePackage.getEFactoryInstance().create(relatedModelElementClass);
			if (!eReference.isContainer()) {
				EObject parent = modelElement.eContainer();
				while (!(parent == null) && relatedModelElement.eContainer() == null) {
					EReference reference = context.getMetaModelElementContext().getPossibleContainingReference(
						relatedModelElement, parent);
					if (reference != null && reference.isMany()) {
						Object object = parent.eGet(reference);
						EList<EObject> eList = (EList<EObject>) object;
						eList.add(relatedModelElement);
					}
					parent = parent.eContainer();
				}
				if (relatedModelElement.eContainer() == null) {
					throw new RuntimeException("No matching container for model element found");
				}
			}
			// create the association
			AssociationClassHelper.createAssociation(eReference, modelElement, relatedModelElement,
				context.getMetaModelElementContext());
			ActionHelper.openModelElement(relatedModelElement, this.getClass().getName());
		}
	}

	/**
	 * Default constructor.
	 * 
	 * @param modelElement the object
	 * @param eReference the reference to the AssociationClassElement
	 * @param descriptor the descriptor used to generate display content
	 * @param context model element context
	 */
	public NewAssociationClassAction(EObject modelElement, EReference eReference, IItemPropertyDescriptor descriptor,
		ECPModelelementContext context) {
		this.modelElement = modelElement;
		this.eReference = eReference;
		this.context = context;
		Object obj = null;
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
		new NewAssociationClassCommand(modelElement).run(true);
	}
}
