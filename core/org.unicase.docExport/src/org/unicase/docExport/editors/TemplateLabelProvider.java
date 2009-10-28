/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.editors;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.docExport.ModelElementRendererRegistry;
import org.unicase.docExport.exportModel.renderers.AttributeRendererMapping;
import org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping;
import org.unicase.model.UnicaseModelElement;

/**
 * Adds The image of each ModelElement type to the ModelElementRendererMappings and prettifies the Label texts.
 * 
 * @author Sebastian Hoecht
 */
public class TemplateLabelProvider extends AdapterFactoryLabelProvider {

	/**
	 * @param adapterFactory {@inheritDoc}
	 */
	public TemplateLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object object) {
		if (object instanceof ModelElementRendererMapping) {
			return ((ModelElementRendererMapping) object).getEClassName().replace("org.unicase.model.", "");
		} else if (object instanceof AttributeRendererMapping) {
			return (((AttributeRendererMapping) object).getFeatureName());
		} else if (object instanceof TemplateEditorTabItem) {
			return ((TemplateEditorTabItem) object).getText();
		} else {
			return super.getText(object);
		}
	}

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	public Image getImage(Object object) {
		if (object instanceof ModelElementRendererMapping) {
			EClass eClass = ModelElementRendererRegistry.getEClassOfString(((ModelElementRendererMapping) object)
				.getEClassName());
			EPackage ePackage = eClass.getEPackage();
			if (!eClass.isAbstract() && !eClass.isInterface()) {
				UnicaseModelElement newMEInstance = (UnicaseModelElement) ePackage.getEFactoryInstance().create(eClass);
				return super.getImage(newMEInstance);
			} else {
				return super.getImage(object);
			}

		}
		return super.getImage(object);
	}

}
