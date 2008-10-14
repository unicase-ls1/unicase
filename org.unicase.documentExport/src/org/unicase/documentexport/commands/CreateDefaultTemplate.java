package org.unicase.documentexport.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.unicase.documentexport.TemplateSaveHelper;
import org.unicase.documentexport.documentTemplate.DefaultDocumentTemplateBuilder;
import org.unicase.documentexport.documentTemplate.DocumentTemplate;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;

public class CreateDefaultTemplate extends AbstractHandler {

	ArrayList<EClass> modelElementTypes = new ArrayList<EClass>();

	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		
		getModelElements(ModelPackage.eINSTANCE);
		

		DefaultDocumentTemplateBuilder builder = new DefaultDocumentTemplateBuilder();
		
		builder.setModelElementTypes(modelElementTypes);
		
		DocumentTemplate template = builder.build();
		TemplateSaveHelper.createdDefaultTemplate = template;
		
		System.out.println("default template created");

		
		return null;
	}

	
	
	public void getFeatures(ModelElement me) {
		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE
				)
		);
		
		List<IItemPropertyDescriptor> propertyDescriptors = adapterFactoryItemDelegator.
			getPropertyDescriptors(me);
		if (propertyDescriptors != null){	
			for (IItemPropertyDescriptor itemPropertyDescriptor : propertyDescriptors) {
				EStructuralFeature feature = (EStructuralFeature)itemPropertyDescriptor.getFeature(me);
				System.out.println(feature.getName());
			}
		}
	}
	
	
	private void getModelElements(EObject object) {
		
		if (object instanceof EClass) {
			EClass eClass = (EClass) object;
			//System.out.println("EClass: " + ((EClass)object).getName());
			EObject me;
			if (!(eClass.isAbstract() || eClass.isInterface())) {
				me = eClass.getEPackage().getEFactoryInstance().create(eClass);
				//System.out.println(me.eClass().getInstanceClassName());
				if (me instanceof ModelElement)
					modelElementTypes.add((EClass) object);
			}
		}
		
		if (object instanceof EPackage) {
			for (EObject obj : ((EPackage)object).eContents()) {
				getModelElements(obj);
			}
		}
	}
}
