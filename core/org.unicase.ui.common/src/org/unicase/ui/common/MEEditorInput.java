/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common;

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
import org.unicase.model.ModelElement;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * The {@link IEditorInput} for the {@link MEEditor}.
 * 
 * @author helming
 * @author shterev
 * @author naughton
 */
public class MEEditorInput implements IEditorInput {

	private ModelElement modelElement;
	private EStructuralFeature problemFeature;

	/**
	 * Default constructor.
	 * 
	 * @param me the modelElement
	 */
	public MEEditorInput(ModelElement me) {
		super();
		this.modelElement = me;
		if (modelElement.getName() == null) {
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
			final String finalName = newName;
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					modelElement.setName(finalName);
				}
			}.run();
		}
	}

	/**
	 * Constructor marking a feature as having a problem.
	 * 
	 * @param me the modelElement
	 * @param problemFeature the feature having a problem
	 */
	public MEEditorInput(ModelElement me, EStructuralFeature problemFeature) {
		this(me);
		this.problemFeature = problemFeature;
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
		AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
		DecoratingLabelProvider labelProvider = new DecoratingLabelProvider(adapterFactoryLabelProvider,
			decoratorManager.getLabelDecorator());
		ImageDescriptor descriptor = ImageDescriptor.createFromImage(labelProvider.getImage(modelElement));
		return descriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getName() {
		return modelElement.getName();
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
	public ModelElement getModelElement() {
		return modelElement;
	}

	/**
	 * Setter for the modelElement.
	 * 
	 * @param modelElement the modelElement
	 */
	public void setModelElement(ModelElement modelElement) {
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

		if (clazz.equals(ModelElement.class)) {
			return getModelElement();
		}
		return null;
	}

}