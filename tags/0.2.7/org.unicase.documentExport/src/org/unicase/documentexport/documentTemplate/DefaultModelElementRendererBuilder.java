package org.unicase.documentexport.documentTemplate;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.unicase.documentexport.renderers.attribute.AttributeRendererMappings;
import org.unicase.documentexport.renderers.attribute.DefaultAttributeRenderer;
import org.unicase.documentexport.renderers.modelElement.DefaultModelElementRenderer;
import org.unicase.documentexport.renderers.options.AttributeOption;
import org.unicase.documentexport.renderers.options.BooleanAttributeOption;
import org.unicase.documentexport.renderers.options.MultiReferenceAttributeOption;
import org.unicase.documentexport.renderers.options.ReferenceOption;
import org.unicase.documentexport.renderers.options.RendererOption;
import org.unicase.documentexport.renderers.options.SingleReferenceAttributeOption;
import org.unicase.documentexport.renderers.options.StringAttributeOption;
import org.unicase.model.ModelElement;

/**
 * This class is a builder for the complex DefaultModelElementRenderer object.
 * There is an AttributeRendererMapping, which defines which AttributeRenderer is used
 * for each Attribute of a ModelElement.
 * Additionally, a RendererOption for each Attribute is created. The RendererOption depends
 * on the Attribute type (Text, Boolean, Reference, Multi References)
 */
public class DefaultModelElementRendererBuilder {
	private DocumentTemplate template;

	public DefaultModelElementRenderer build(EClass eClass, DocumentTemplate template) {
		this.template = template;
		
		ModelElement modelElement = 
			(ModelElement)eClass.getEPackage().getEFactoryInstance().create(eClass);
		
		DefaultModelElementRenderer renderer = new DefaultModelElementRenderer(template);
		
		
		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE
				)
		);
		
		List<IItemPropertyDescriptor> propertyDescriptors = adapterFactoryItemDelegator.
			getPropertyDescriptors(modelElement);
		if (propertyDescriptors != null){
			for (IItemPropertyDescriptor itemPropertyDescriptor : propertyDescriptors) {
				EStructuralFeature feature = (EStructuralFeature)itemPropertyDescriptor.getFeature(modelElement);
				setRendererOption(feature, renderer.rendererOptions);	
				setAttributeRenderer(feature, renderer.attributeRendererMappings);
			}
		}	
		
		return renderer;
	}
	
	
	private void setAttributeRenderer(
			EStructuralFeature feature,
			AttributeRendererMappings attributeRendererMappings
		) {
		DefaultAttributeRendererBuilder rendererBuilder = new DefaultAttributeRendererBuilder();
		DefaultAttributeRenderer renderer = rendererBuilder.build(feature);
		attributeRendererMappings.set(feature, renderer);
	}


	/**
	 * adds a RendererOption to the rendererOptions list of the ModelElement depending on the feature. 
	 * (simple attribute, contained Reference, Linked Reference)
	 * 
	 * @param feature
	 * @param rendererOptions
	 */
	private void setRendererOption(EStructuralFeature feature, ArrayList<RendererOption> rendererOptions) {
		if (feature.eClass().getInstanceClass() == EAttribute.class) {
			EAttribute eAttribute = (EAttribute) feature;
			if (eAttribute.getEAttributeType().getInstanceClassName() == "boolean") {
				BooleanAttributeOption option = new BooleanAttributeOption();
				option.globalOption = 
					(BooleanAttributeOption) template.getGlobalAttributeRendererOption(
							BooleanAttributeOption.class);
				option.setName(feature.getName());
				//option.setAttributeType(feature.eClass().getInstanceClass());
				rendererOptions.add(option);
			} else {
				StringAttributeOption option = new StringAttributeOption();
				option.globalOption = 
					(StringAttributeOption) template.getGlobalAttributeRendererOption(
							StringAttributeOption.class);
				option.setName(feature.getName());
				//option.setAttributeType(feature.eClass().getInstanceClass());
				rendererOptions.add(option);
			}
		} else { //EReference	
			AttributeOption option;
			ReferenceOption referenceOption;
			if (feature.isMany()) {
		
				option = new MultiReferenceAttributeOption();
				((MultiReferenceAttributeOption)option).globalOption = 
					(MultiReferenceAttributeOption) template.getGlobalAttributeRendererOption(
							MultiReferenceAttributeOption.class);
				referenceOption = ((MultiReferenceAttributeOption)option).referenceOption;	
			} else {
				option = new SingleReferenceAttributeOption();
				((SingleReferenceAttributeOption)option).globalOption = 
					(SingleReferenceAttributeOption) template.getGlobalAttributeRendererOption(
							SingleReferenceAttributeOption.class);
				referenceOption = ((SingleReferenceAttributeOption)option).referenceOption;
			}
			
			option.setName(feature.getName());
			if (((EReference) feature).isContainment()) {
				referenceOption.contained = true;
			}
			else {
				referenceOption.contained = false;
			}
			rendererOptions.add(option);
		}
	}

}
