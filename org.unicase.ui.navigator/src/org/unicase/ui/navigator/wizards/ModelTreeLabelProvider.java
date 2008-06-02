package org.unicase.ui.navigator.wizards;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;

/**
 * 
 * @author Hodaie
 * LabelProvider for TreeViewer that is shown on ModelTreePage
 *
 */
public class ModelTreeLabelProvider extends AdapterFactoryLabelProvider {

	/**.
	 * Constructor
	 */
	public ModelTreeLabelProvider() {
		super(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		
	}

	/**.
	 * ({@inheritDoc})
	 * If argument is instance of EClass and 
	 * it inherits ModelElement then return its display name.
	 */
	@Override
	public String getText(Object object) {
		String text = "";
		//if argument is instance of EClass and 
		//it inherits ModelElement then return its name.
		if (object instanceof EClass){
			EClass eclass = (EClass)object;
			if (eclass.getEAllSuperTypes()
					.contains(ModelPackage.eINSTANCE
							.getModelElement())) {
				//TODO: show getDisplayName()
				text = eclass.getName();
			}
								
		}else{
			//argument is an EPackage
			text = super.getText(object);
		}
		
		return text;
	}

	/**.
	 * ({@inheritDoc})
	 */
	@Override
	public Image getImage(Object object) {
		if(object instanceof EClass){
			EClass eClass = (EClass) object;
			EPackage ePackage = eClass.getEPackage();
			ModelElement newMEInstance = (ModelElement)
			ePackage.getEFactoryInstance().create(eClass);
			return super.getImage(newMEInstance);
		}
		return super.getImage(object);
		
	}
	
	
	

}
