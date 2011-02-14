/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.services.IDisposable;
import org.unicase.ecp.model.ModelElementContext;

/**
 * The {@link IEditorInput} for the {@link MEEditor}.
 * 
 * @author helming
 * @author shterev
 * @author naughton
 */
public class MEEditorInput implements IEditorInput, IDisposable {

	private EObject modelElement;
	private EStructuralFeature problemFeature;
	private DecoratingLabelProvider labelProvider;
	private ModelElementContext modelElementContext;

	/**
	 * Default constructor.
	 * 
	 * @param me the modelElement
	 * @param context context of the modelelement
	 */
	public MEEditorInput(EObject me, ModelElementContext context) {
		super();
		// hkq: done
		AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
		labelProvider = new DecoratingLabelProvider(adapterFactoryLabelProvider, decoratorManager.getLabelDecorator());
		this.modelElement = me;
		this.modelElementContext = context;
		if (labelProvider.getLabelProvider().getText(modelElement) == null) {
			final Shell activeShell = Display.getCurrent().getActiveShell();
			boolean doSetName = MessageDialog
				.openQuestion(
					activeShell,
					"Missing title",
					"The element you are trying to open does not have a proper name and cannot be opened.\nDo you want to set a custom name for it or use a default one?");
			String newName = "new " + modelElement.eClass().getName();
			if (doSetName) {
				final InputDialog inputDialog = new InputDialog(activeShell, "New title",
					"Please enter the new name for this element", newName, null);
				inputDialog.setBlockOnOpen(true);
				if (inputDialog.open() == IDialogConstants.OK_ID && inputDialog.getValue() != "") {
					newName = inputDialog.getValue();
				}

			}
		}
	}

	/**
	 * Constructor to add a probleFeature.
	 * 
	 * @param me the model lement to open
	 * @param context context of the model element
	 * @param problemFeature the problem feature
	 */
	public MEEditorInput(EObject me, ModelElementContext context, EStructuralFeature problemFeature) {
		this(me, context);
		this.problemFeature = problemFeature;
	}

	/**
	 * Getter for the label provider.
	 * 
	 * @return the label provider
	 */
	public DecoratingLabelProvider getLabelProvider() {
		return labelProvider;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public ImageDescriptor getImageDescriptor() {
		ImageDescriptor descriptor = ImageDescriptor.createFromImage(labelProvider.getImage(modelElement));
		return descriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getName() {
		return labelProvider.getLabelProvider().getText(modelElement);
	}

	/**
	 * {@inheritDoc}
	 */
	public IPersistableElement getPersistable() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getToolTipText() {
		return getName();
	}

	/**
	 * Getter for the modelElement.
	 * 
	 * @return the modelElement
	 */
	public EObject getModelElement() {
		return modelElement;
	}

	/**
	 * Setter for the modelElement.
	 * 
	 * @param modelElement the modelElement
	 */
	public void setModelElement(EObject modelElement) {
		this.modelElement = modelElement;
	}

	/**
	 * @return the problemFeature
	 */
	public EStructuralFeature getProblemFeature() {
		return problemFeature;
	}

	/**
	 * @param problemFeature the problemFeature to set
	 */
	public void setProblemFeature(EStructuralFeature problemFeature) {
		this.problemFeature = problemFeature;
	}

	/**
	 * Custom equals() for this class.
	 * 
	 * @param obj the compared object.
	 * @return the boolean state. {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MEEditorInput) {
			MEEditorInput other = (MEEditorInput) obj;
			boolean ret = modelElement.equals(other.modelElement);
			return ret;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public Object getAdapter(Class clazz) {

		if (clazz.equals(EObject.class)) {
			return getModelElement();
		}
		return null;
	}

	/**
	 * Returns the {@link ModelElementContext}.
	 * 
	 * @return {@link ModelElementContext}
	 */
	public ModelElementContext getModelElementContext() {
		return modelElementContext;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.services.IDisposable#dispose()
	 */
	public void dispose() {
		// TODO Auto-generated method stub
		AdapterFactoryLabelProvider adapterFactoryLabelProvider = (AdapterFactoryLabelProvider) labelProvider
			.getLabelProvider();
		ComposedAdapterFactory adapterFactory = (ComposedAdapterFactory) adapterFactoryLabelProvider
			.getAdapterFactory();
		adapterFactory.dispose();
		// adapterFactoryLabelProvider.dispose();
		labelProvider.dispose();
	}

}