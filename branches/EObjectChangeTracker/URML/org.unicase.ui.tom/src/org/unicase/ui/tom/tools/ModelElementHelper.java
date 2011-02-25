package org.unicase.ui.tom.tools;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IMetamodelType;

public class ModelElementHelper {

	public static IElementType getDefaultConnectionModelElementType(EObject object) {
		IClientContext cc = ClientContextManager.getDefaultClientContext();

		cc = ClientContextManager.getInstance().getClientContextFor(object);

		IMetamodelType[] metamodelTypes = ElementTypeRegistry.getInstance().getMetamodelTypes(cc);
		IElementType[] containedTypes = ElementTypeRegistry.getInstance().getElementTypes(cc);

		for (IElementType elementType : containedTypes) {
			elementType.getDisplayName();
			System.out.println(elementType);
		}		
		return null;
	}
}
