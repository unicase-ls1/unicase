/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols.melinkcontrol.associationclasscontrol;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Image;
import org.unicase.ecp.model.ModelElementContext;
import org.unicase.ecp.model.workSpaceModel.util.AssociationClassHelper;
import org.unicase.ui.common.commands.ECPCommand;
import org.unicase.ui.meeditor.MESuggestedSelectionDialog;
import org.unicase.ui.util.OverlayImageDescriptor;

/**
 * This class provides the icon and command to link to a existing object over an AssociationClassElement.
 * 
 * @author Michael Haeger
 */
public class AddAssociationClassAction extends Action {
	private static final String DIALOG_MESSAGE = "Enter model element name prefix or pattern (e.g. *Trun?)";

	/**
	 * The link command.
	 * 
	 * @author Michael Haeger
	 */
	private final class AddAssociationClassCommand extends ECPCommand {

		public AddAssociationClassCommand(EObject eObject) {
			super(eObject);
		}

		@Override
		protected void doRun() {
			Collection<EObject> allElements = context.getAllModelElementsbyClass(modelElement.eClass(), false);
			MESuggestedSelectionDialog dlg = new MESuggestedSelectionDialog("Select Elements", DIALOG_MESSAGE, true,
				modelElement, eReference, allElements);
			if (dlg.open() == Window.OK) {
				if (eReference.isMany()) {
					for (Object result : dlg.getResult()) {
						AssociationClassHelper.createAssociation(eReference, modelElement, (EObject) result, context);
					}
				} else {
					AssociationClassHelper.createAssociation(eReference, modelElement, (EObject) dlg.getFirstResult(),
						context);
				}
			}
		}
	}

	private EReference eReference;
	private EObject modelElement;
	private final ModelElementContext context;

	/**
	 * Default constructor.
	 * 
	 * @param modelElement the object
	 * @param eReference the reference to the AssociationClassElement
	 * @param descriptor the descriptor used to generate display content
	 * @param context model element context
	 */
	public AddAssociationClassAction(EObject modelElement, EReference eReference, IItemPropertyDescriptor descriptor,
		ModelElementContext context) {
		this.modelElement = modelElement;
		this.eReference = eReference;
		this.context = context;
		Object obj = null;
		if (!eReference.getEReferenceType().isAbstract()) {
			obj = eReference.getEReferenceType().getEPackage().getEFactoryInstance().create(
				eReference.getEReferenceType());
		}
		// hkq: done
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		AdapterFactoryLabelProvider labelprovider = new AdapterFactoryLabelProvider(adapterFactory);
		Image image = labelprovider.getImage(obj);
		ImageDescriptor addOverlay = org.unicase.ui.common.Activator.getImageDescriptor("icons/link_overlay.png");
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
		setToolTipText("Link " + attribute);
		adapterFactory.dispose();
		labelprovider.dispose();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		new AddAssociationClassCommand(modelElement).run();
	}

}
