/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tableview.labelproviders;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.ModelPackage;
import org.unicase.model.task.TaskPackage;

/**
 * A specific ColumnLabelProvider for the display of features of Checkable instances. For the
 * {@link TaskPackage.Literals.CHECKABLE__CHECKED} feature, it returns images of CheckBoxes. For the
 * {@link ModelPackage.Literals.MODEL_ELEMENT__NAME} feature, it uses a {@link DecoratingLabelProvider} to return a
 * decorated image consisting of a symbol corresponding to the model element type and possible decorations.
 * 
 * @author Florian Schneider
 * @author Jonas Helming
 */
public class GenericColumnLabelProvider extends ColumnLabelProvider {
	/**
	 * The feature.
	 */
	private EStructuralFeature feature;
	private DecoratingLabelProvider decoratingLabelProvider;

	/**
	 * Creates a specific ColumnLabelProvider for the display of features of Checkable instances.
	 * 
	 * @param feature the feature that this provider shall return a label for
	 */
	public GenericColumnLabelProvider(EStructuralFeature feature) {
		super();
		this.setFeature(feature);
		IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
		decoratingLabelProvider = new DecoratingLabelProvider(new AdapterFactoryLabelProvider(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)), decoratorManager
			.getLabelDecorator());

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		if (!(element instanceof EObject)) {
			return "";
		}

		EObject eObject = (EObject) element;
		if (feature instanceof EReference) {
			return extractTextFromEReference(eObject);
		} else if (feature instanceof EAttribute) {
			return extractTextFromEAttribute(eObject);
		}
		return "";
	}

	private String extractTextFromEAttribute(EObject item) {
		Object value = item.eGet(feature);
		if (value != null) {
			return value.toString();
		}
		return "";
	}

	@SuppressWarnings("unchecked")
	private String extractTextFromEReference(EObject item) {
		Object value = item.eGet(feature);
		if (value == null) {
			return "";
		}

		if (feature.isMany()) {
			EList<EObject> eList = (EList<EObject>) value;
			return decoratingLabelProvider.getText(eList.get(0));
		} else {
			return decoratingLabelProvider.getText(value);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {
		Image image = null;
		if (this.getFeature().equals(ModelPackage.Literals.MODEL_ELEMENT__NAME)) {
			image = decoratingLabelProvider.getImage(element);
			decoratingLabelProvider.getLabelDecorator().decorateImage(image, element);
		}
		return image;
	}

	/**
	 * set the feature.
	 * 
	 * @param feature the feature.
	 */
	public void setFeature(EStructuralFeature feature) {
		this.feature = feature;
	}

	/**
	 * get the feature.
	 * 
	 * @return the feature.
	 */
	public EStructuralFeature getFeature() {
		return feature;
	}
}
