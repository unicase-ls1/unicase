package org.unicase.documentexport.commands;

import java.util.List;
import java.util.Vector;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.documentexport.TemplateSaveHelper;
import org.unicase.documentexport.documentTemplate.DefaultDocumentTemplateBuilder;
import org.unicase.documentexport.documentTemplate.DocumentTemplate;
import org.unicase.model.ModelElement;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.LeafSection;
import org.unicase.model.document.Section;
import org.unicase.model.impl.ModelElementImpl;

public class CreateDefaultTemplate extends AbstractHandler {

	Vector<ModelElement> modelElements = new Vector<ModelElement>();

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if (!(sel instanceof IStructuredSelection)) {
			return null;
		}
		IStructuredSelection ssel = (IStructuredSelection) sel;
		if (ssel.isEmpty()) {
			return null;
		}
		
		Object o = ssel.getFirstElement();
		if (!(o instanceof ModelElement)) {
			return null;
		}
		
		ModelElementImpl modelElement = (ModelElementImpl) o;
		

		
		readModelElementTypes(modelElement);

		DefaultDocumentTemplateBuilder builder = new DefaultDocumentTemplateBuilder();
		builder.setModelElementTypes(modelElements);
		DocumentTemplate template = builder.build();
		TemplateSaveHelper.createdDefaultTemplate = template;
		
		System.out.println("default template created");

		
//		EPackage modelPackage = ModelPackageImpl.eINSTANCE;
//		for (EClassifier classifier : modelPackage.getEClassifiers().get(0).)) {
//			System.out.println(classifier.getInstanceClassName());
//		}
		
		return null;
	}

	private void readModelElementTypes(ModelElement me) {
		if (me instanceof CompositeSection) {
			CompositeSection cs = (CompositeSection) me;
			EList<Section> subSections = cs.getSubsections();
			for (Section section : subSections) {
				readModelElementTypes(section);
			}
		} else if (me instanceof LeafSection) {
			LeafSection lf = (LeafSection) me;
			EList<ModelElement> modelElements = lf.getModelElements();
			for (ModelElement sub : modelElements) {
				readModelElementTypes(sub);
			}
		} else {
			
			if (!modelElementTypeAlreadyInList(me)) {
				modelElements.add(me);
			
			
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

					
					
					if (feature.isMany()) {
						EReference eReference = (EReference) feature;

						Object attributeValue = me.eGet(feature);

						EList<ModelElement> objectList = (EList<ModelElement>)attributeValue;
							for (ModelElement me3 : objectList) {
								readModelElementTypes(me3);
							}
							
					} else {
						if (feature.eClass().getInstanceClass() == EReference.class) {
							Object content = me.eGet(feature);
							if (((EReference) feature).isContainment() && content != null)
								readModelElementTypes((ModelElement)content);
						}
					} 
				}
			}
		}	
		}
	}
	
	private boolean modelElementTypeAlreadyInList(ModelElement modelElement) {
		for (ModelElement me : modelElements) {
			if (modelElement.eClass().getInstanceClass() 
					== me.eClass().getInstanceClass())
				return true;
		}
		return false;
	}
}
