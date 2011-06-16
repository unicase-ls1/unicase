package org.eclipse.emf.emfstore.client.properties;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.model.ModelFactory;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.PropertyStringValue;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.common.model.EMFStoreProperty;
import org.eclipse.emf.emfstore.common.model.EMFStorePropertyType;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;

public final class PropertyManager {

	private final ProjectSpace projectSpace;
	private Map<String, EObject> sharedProperties;
	private Map<String, EObject> localProperties;

	public PropertyManager(ProjectSpace pS) {
		this.projectSpace = pS;
	}

	public void setLocalProperty(String key, EObject value) {
		EMFStoreProperty prop = createProperty(key, value);
		this.projectSpace.setEMFStoreProperty(prop);
		this.localProperties.put(key, value);

	}

	public EObject getLocalProperty(String key) {
		if (this.localProperties == null) {
			this.localProperties = new HashMap<String, EObject>();
			createMap(this.localProperties, EMFStorePropertyType.LOCAL);
		}
		return getProperty(this.localProperties, key);
	}

	public void setLocalStringProperty(String key, String value) {
		PropertyStringValue propertyValue = ModelFactory.eINSTANCE
				.createPropertyStringValue();
		propertyValue.setValue(value);
		setLocalProperty(key, propertyValue);

	}

	public String getLocalStringProperty(String key) {
		PropertyStringValue propertyValue = (PropertyStringValue) getLocalProperty(key);
		return propertyValue.getValue();
	}

	public void setSharedStringProperty(String key, String value) {
		PropertyStringValue propertyValue = ModelFactory.eINSTANCE
				.createPropertyStringValue();
		propertyValue.setValue(value);
		setSharedProperty(key, propertyValue);
	}

	public String getSharedStringProperty(String key) {
		PropertyStringValue propertyValue = (PropertyStringValue) getSharedProperty(key);
		return propertyValue.getValue();
	}

	public void setSharedProperty(String key, EObject value) {
		EMFStoreProperty prop = createProperty(key, value);
		this.projectSpace.setEMFStoreProperty(prop);
		this.projectSpace.setChangedEMFStoreProperty(prop);
		this.sharedProperties.put(key, value);
	}

	public EObject getSharedProperty(String key) {
		if (this.sharedProperties == null) {
			this.sharedProperties = new HashMap<String, EObject>();
			createMap(this.sharedProperties, EMFStorePropertyType.SHARED);
		}
		return getProperty(this.sharedProperties, key);
	}

	public void transmit() throws EmfStoreException {
		EMap<String, EMFStoreProperty> changedProperties = this.projectSpace
				.getChangedSharedProperties();
		for (EMFStoreProperty prop : changedProperties.values()) {
			WorkspaceManager
					.getInstance()
					.getConnectionManager()
					.transmitEMFProperty(
							this.projectSpace.getUsersession().getSessionId(),
							prop, this.projectSpace.getProjectId());
		}
	}

	private EMFStoreProperty createProperty(String key, EObject value) {
		EMFStoreProperty prop = org.eclipse.emf.emfstore.common.model.ModelFactory.eINSTANCE
				.createEMFStoreProperty();
		prop.setKey(key);
		prop.setValue(value);
		return prop;
	}

	private void createMap(Map<String, EObject> map, EMFStorePropertyType type) {
		EMap<String, EMFStoreProperty> persistendProperties = this.projectSpace
				.getProperties();
		for (EMFStoreProperty prop : persistendProperties.values()) {
			if (prop.getType() == type) {
				map.put(prop.getKey(), prop.getValue());
			}
		}
	}

	private EObject getProperty(Map<String, EObject> map, String key) {
		if (map.containsKey(key)) {
			return map.get(key);
		} else {
			return null;
		}
	}

}
