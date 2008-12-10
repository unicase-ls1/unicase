/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.meeditor;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.unicase.model.ModelElement;

/**
 * The {@link IEditorInput} for the {@link MEEditor}.
 * @author helming
 * @author naughton
 *
 */
public class MEEditorInput implements IEditorInput {

	private ModelElement modelElement;
	private EStructuralFeature problemFeature;

	/**
	 * Default constructor.
	 * @param me the modelElement
	 */
	public MEEditorInput(ModelElement me) {
		super();
		this.modelElement = me;
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
		ImageDescriptor descriptor = ImageDescriptor
				.createFromImage(new AdapterFactoryLabelProvider(
						new ComposedAdapterFactory(
								ComposedAdapterFactory.Descriptor.Registry.INSTANCE))
						.getImage(modelElement));
		return descriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getName() {
		String name = modelElement.getName();
		return (name==null?"":name);
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
		// TODO Auto-generated method stub
		return "";
	}

	/**
	 * Getter for the modelElement.
	 * @return the modelElement
	 */
	public ModelElement getModelElement() {
		return modelElement;
	}

	/**
	 * Setter for the modelElement.
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
	 * @param obj the compared object.
	 * @return the boolean state.
	 * {@inheritDoc}
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
		
		if(clazz.equals(ModelElement.class)){
			return getModelElement();
		}
		return null;
	}

}
