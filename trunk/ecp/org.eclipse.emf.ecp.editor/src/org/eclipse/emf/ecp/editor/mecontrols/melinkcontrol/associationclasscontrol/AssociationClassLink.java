/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.editor.mecontrols.melinkcontrol.associationclasscontrol;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecp.common.util.ModelElementClassTooltip;
import org.eclipse.emf.ecp.common.util.ShortLabelProvider;
import org.eclipse.emf.ecp.editor.ControlFactory;
import org.eclipse.emf.ecp.editor.ModelElementChangeListener;
import org.eclipse.emf.ecp.editor.mecontrols.AbstractMEControl;
import org.eclipse.emf.ecp.editor.mecontrols.melinkcontrol.MEHyperLinkAdapter;
import org.eclipse.emf.ecp.editor.mecontrols.melinkcontrol.MEHyperLinkDeleteAdapter;
import org.eclipse.emf.ecp.editor.mecontrols.melinkcontrol.MELinkControl;
import org.eclipse.emf.ecp.model.ECPAssociationClassElement;
import org.eclipse.emf.ecp.model.ECPModelelementContext;
import org.eclipse.emf.ecp.model.workSpaceModel.util.AssociationClassHelper;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;

/**
 * This is the association widget. It is displayed instead of the reference to the AssociationClassElement. The other
 * side of the association is displayed and in addition a widget if the AssociationClassElement has only one feature to
 * setup else the link to the association.
 * 
 * @author Michael Haeger
 */
public class AssociationClassLink extends MELinkControl {
	private static final int PRIORITY = 2;
	private Composite composite;
	private ILabelProvider labelProvider;
	private ImageHyperlink imgHyperlink;
	private Hyperlink hyperlink;
	private Image deleteImage;
	private ModelElementChangeListener meChangeListener;
	private ModelElementChangeListener associationChangeListener;
	private IHyperlinkListener linkToMEListener;
	private MEHyperLinkDeleteAdapter delAssociationListener;
	private EObject association;
	private EObject modelElement;
	private EObject relatedModelElement;
	private List<EStructuralFeature> eAttribute;
	private ShortLabelProvider shortLabelProvider = new ShortLabelProvider();
	private EReference eReference;
	private Composite parent;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecp.editor.mecontrols.melinkcontrol.MELinkControl#canRender(org.eclipse.emf.edit.provider.IItemPropertyDescriptor,
	 *      org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject link, EObject contextModelElement) {
		Object ref = itemPropertyDescriptor.getFeature(contextModelElement);
		if (getContext() != null) {
			if (getContext().getMetaModelElementContext().isAssociationClassElement(link) && ref instanceof EReference) {
				ECPAssociationClassElement association = getContext().getMetaModelElementContext()
					.getAssociationClassElement(link);
				if (association.getSourceFeature().equals(((EReference) ref).getEOpposite())
					|| association.getTargetFeature().equals(((EReference) ref).getEOpposite())) {
					return PRIORITY;
				}
			}
		}
		return AbstractMEControl.DO_NOT_RENDER;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecp.editor.mecontrols.melinkcontrol.MELinkControl#createControl(org.eclipse.swt.widgets.Composite,
	 *      int, org.eclipse.emf.edit.provider.IItemPropertyDescriptor, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EObject, org.eclipse.ui.forms.widgets.FormToolkit,
	 *      org.eclipse.emf.ecp.model.ECPModelelementContext)
	 */
	@Override
	public Control createControl(final Composite parent, int style, IItemPropertyDescriptor itemPropertyDescriptor,
		final EObject link, EObject contextModelElement, FormToolkit toolkit, ECPModelelementContext context) {
		association = link;
		modelElement = contextModelElement;
		eReference = (EReference) itemPropertyDescriptor.getFeature(association);
		eAttribute = AssociationClassHelper.getAssociationFeatures(association, context.getMetaModelElementContext());
		this.toolkit = toolkit;
		setContext(context);
		this.parent = parent;
		// create components
		createComponents(parent, style);
		// set all values that depends on other elements
		setupComponents();
		return composite;
	}

	private boolean setupComponents() {
		boolean changed = false;
		if (composite != null && !composite.isDisposed()) {
			EObject newRelatedModelElement = AssociationClassHelper.getRelatedModelElement(modelElement, association,
				getContext());
			// check whether it is a new linked goal
			if (newRelatedModelElement != null && !newRelatedModelElement.equals(relatedModelElement)) {
				// new goal
				relatedModelElement = newRelatedModelElement;
				// remove old listeners
				if (linkToMEListener != null) {
					imgHyperlink.removeHyperlinkListener(linkToMEListener);
					hyperlink.removeHyperlinkListener(linkToMEListener);
				}
				// add new listeners
				linkToMEListener = new MEHyperLinkAdapter(relatedModelElement, modelElement, eReference.getName());
				imgHyperlink.addHyperlinkListener(linkToMEListener);
				hyperlink.addHyperlinkListener(linkToMEListener);
				if (meChangeListener != null) {
					meChangeListener.remove();
				}
				meChangeListener = new AssociationChangeListener(relatedModelElement);
			} else if (newRelatedModelElement == null && relatedModelElement != null) {
				// link to goal is removed so remove listener
				relatedModelElement = newRelatedModelElement;
				imgHyperlink.removeHyperlinkListener(linkToMEListener);
				hyperlink.removeHyperlinkListener(linkToMEListener);
			}
			if (relatedModelElement != null) {
				// create components for linked goal
				imgHyperlink.setData(relatedModelElement.eClass());
				String text = shortLabelProvider.getText(relatedModelElement);
				hyperlink.setText(text);
				hyperlink.setToolTipText(text);
			} else {
				imgHyperlink.setData(null);
				hyperlink.setToolTipText("NULL");
				hyperlink.setText("NULL");
			}
			imgHyperlink.setImage(labelProvider.getImage(relatedModelElement));
			changed = true;
		}
		return changed;
	}

	private void createComponents(final Composite parent, int style) {
		composite = toolkit.createComposite(parent, style);
		composite.setLayout(new GridLayout(5, false));
		// handle element deletion
		delAssociationListener = new MEHyperLinkDeleteAdapter(modelElement, eReference, association, getContext());
		// listen for changes of the goal reference instance
		associationChangeListener = new AssociationChangeListener(association);
		AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
		labelProvider = new DecoratingLabelProvider(adapterFactoryLabelProvider, decoratorManager.getLabelDecorator());
		imgHyperlink = toolkit.createImageHyperlink(composite, style);
		ModelElementClassTooltip.enableFor(imgHyperlink);
		hyperlink = toolkit.createHyperlink(composite, "", style);
		if (eAttribute.size() == 1) {
			ControlFactory controlFactory = new ControlFactory();
			ItemPropertyDescriptor itemPropertyDescriptor = new ItemPropertyDescriptor(null, "", "", eAttribute.get(0));
			AbstractMEControl meControl = controlFactory.createControl(itemPropertyDescriptor, association,
				getContext());
			meControl.createControl(composite, style, itemPropertyDescriptor, association, getContext(), toolkit);
		} else if (eAttribute.size() > 1) {
			Hyperlink associationLink = toolkit.createHyperlink(composite, "[edit]", style);
			associationLink
				.addHyperlinkListener(new MEHyperLinkAdapter(association, modelElement, eReference.getName()));
		}
		if (eReference.isContainment()
			&& (getContext().getMetaModelElementContext().isNonDomainElement(association.eClass()))) {
			deleteImage = org.eclipse.emf.ecp.common.Activator.getImageDescriptor("icons/delete.gif").createImage();
		} else {
			deleteImage = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE);
		}
		ImageHyperlink delHyperlink = toolkit.createImageHyperlink(composite, style);
		delHyperlink.setImage(deleteImage);
		delHyperlink.addMouseListener(delAssociationListener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecp.editor.mecontrols.melinkcontrol.MELinkControl#dispose()
	 */
	@Override
	public void dispose() {
		if (meChangeListener != null) {
			meChangeListener.remove();
		}
		if (associationChangeListener != null) {
			associationChangeListener.remove();
		}
		if (labelProvider != null) {
			labelProvider.dispose();
		}
		if (composite != null) {
			composite.dispose();
		}
		super.dispose();
	}

	/**
	 * Change listener to rebuild links if content changes.
	 * 
	 * @author Michael Haeger
	 */
	private class AssociationChangeListener extends ModelElementChangeListener {
		public AssociationChangeListener(EObject modelElement) {
			super(modelElement);
		}

		@Override
		public void onChange(Notification notification) {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					// if something changes do layouts again
					if (setupComponents()) {
						composite.pack();
						composite.layout(true);
						parent.getParent().layout(true);
					}
				}
			});
		}
	}
}
