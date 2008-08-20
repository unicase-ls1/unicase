package org.unicase.ui.stem.views;

import java.util.Random;

import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.unicase.emfstore.esmodel.versioning.operations.AtomicOperation;

public class ChangesTreeLabelProvider extends AdapterFactoryLabelProvider
		implements IBaseLabelProvider {
	
	

	public ChangesTreeLabelProvider() {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		
		
	}

	@Override
	public String getColumnText(Object object, int columnIndex) {
		AtomicOperation operation = (AtomicOperation)object;
		switch(columnIndex){
		case 0 :
			return operation.getName();
			
		case 1 :
			return operation.getDescription();
			
		case 2 : 
			return operation.getUsername();
			
		case 3 :
			if(isAccepted(operation)){
				return "Accepted";
			}else{
				return "Rejected";
			}
		
		default :
			return super.getColumnText(object, columnIndex);
		}
		
	}

	private boolean isAccepted(AtomicOperation operation) {
		Random rnd = new Random();
		return rnd.nextBoolean() ;
	}

}
