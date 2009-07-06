package org.unicase.docExport.exportModel.builders;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.AttributeRendererMapping;
import org.unicase.docExport.exportModel.renderers.RenderersFactory;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersFactory;
import org.unicase.model.ModelElement;

/**
 * This class is a builder for the complex DefaultModelElementRenderer object.
 * There is an AttributeRendererMapping, which defines which AttributeRenderer is used
 * for each Attribute of a ModelElement.
 * Additionally, a RendererOption for each Attribute is created. The RendererOption depends
 * on the Attribute type (Text, Boolean, Reference, Multi References)
 */
public class DefaultModelElementRendererBuilder {

	/**
	 * Build the complex Object DefaultModelElementRenderer.
	 * 
	 * @param eClass the EClass of the ModelElement type
	 * @param template the template this renderer is part of
	 * @return the ModelElementRenderer which just has been built
	 */
	public static DefaultModelElementRenderer build(EClass eClass, Template template) {
		
		//create an instance of the ModelElement which eClass refers to, to get
		//a property list
		ModelElement modelElement = 
			(ModelElement)eClass.getEPackage().getEFactoryInstance().create(eClass);
		
		DefaultModelElementRenderer renderer = DefaultRenderersFactory.eINSTANCE.createDefaultModelElementRenderer();
		renderer.setTemplate(template);
		
		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE
				)
		);
		
		List<IItemPropertyDescriptor> propertyDescriptors = adapterFactoryItemDelegator.
			getPropertyDescriptors(modelElement);
		if (propertyDescriptors != null) {
			for (IItemPropertyDescriptor itemPropertyDescriptor : propertyDescriptors) {
				EStructuralFeature feature = (EStructuralFeature) itemPropertyDescriptor.getFeature(modelElement);
				
				AttributeRendererMapping mapping = RenderersFactory.eINSTANCE.createAttributeRendererMapping();
				mapping.setAttributeRenderer(DefaultAttributeRendererBuilder.build(feature, template));
				mapping.setFeatureName(feature.getName());
				renderer.getAttributeRendererMapping().add(mapping);
				
				renderer.getRendererOptions().add(mapping.getAttributeRenderer().getAttributeOption());
			}
		}	
		
		return renderer;
	}
}
