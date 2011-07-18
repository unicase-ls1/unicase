package org.eclipse.emf.emfstore.client.ui.views.changes;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.util.UiUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.server.model.provider.AbstractOperationCustomLabelProvider;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation;

public class DefaultOperationLabelProvider extends AbstractOperationCustomLabelProvider {

	protected static String UNKOWN_ELEMENT = "(Unkown Element)";
	protected static int MAX_NAME_SIZE = 30;
	// private final Map<ModelElementId, EObject> modelElementMap;
	private AdapterFactoryLabelProvider adapterFactoryLabelProvider;

	public DefaultOperationLabelProvider() {
		adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	@Override
	public String getDescription(AbstractOperation operation) {

		if (operation instanceof CompositeOperation) {
			CompositeOperation compositeOperation = (CompositeOperation) operation;
			// artificial composite because of opposite ref, take description of
			// mainoperation
			if (compositeOperation.getMainOperation() != null) {
				return getDescription(compositeOperation.getMainOperation());
			}
		}

		return UiUtil.getNameForModelElement(operation);
	}

	@Override
	public Object getImage(AbstractOperation operation) {
		return adapterFactoryLabelProvider.getImage(operation);
	}

	@Override
	public int canRender(AbstractOperation operation) {
		return 1;
	}

	@Override
	public String getModelElementName(Map<ModelElementId, EObject> modelElementMap, ModelElementId modelElementId) {
		if (modelElementId == null) {
			return UNKOWN_ELEMENT;
		}
		return getModelElementName(modelElementMap.get(modelElementId));
	}

	private String getModelElementName(EObject modelElement) {
		if (modelElement == null) {
			return UNKOWN_ELEMENT;
		}
		// String className = modelElement.eClass().getName();
		// return className + " \"" + trim(UiUtil.getNameForModelElement(modelElement)) + "\"";
		return " \"" + trim(UiUtil.getNameForModelElement(modelElement)) + "\"";
	}

	private String trim(Object object) {
		if (object == null) {
			return "(Unkown Element)";
		}
		String string = object.toString();
		String result = string.trim();
		if (result.length() > MAX_NAME_SIZE) {
			return result.substring(0, MAX_NAME_SIZE) + "...";
		}
		if (result.length() == 0) {
			return "(empty name)";
		}
		return result;
	}
}
