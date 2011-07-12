/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.properties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.common.model.EMFStoreProperty;
import org.eclipse.emf.emfstore.common.model.EMFStorePropertyType;
import org.eclipse.emf.emfstore.common.model.PropertyStringValue;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;

/**
 * This class handles shared and local properties which are bundled to the
 * project space.
 * 
 * @author haunolder
 * **/
public final class PropertyManager {

	private final ProjectSpace projectSpace;
	private Map<String, EObject> sharedProperties;
	private Map<String, EObject> localProperties;

	/**
	 * PropertyManager constructor.
	 * 
	 * @param pS
	 *            projectSpace for this PropertyManager ProjectSpace
	 * **/
	public PropertyManager(ProjectSpace pS) {
		this.projectSpace = pS;
	}

	/**
	 * Set a local property. If the property already exists it will be updated.
	 * 
	 * @param key
	 *            of the local property as String
	 * @param value
	 *            of the local property as EObject
	 * **/
	public EMFStoreProperty setLocalProperty(String key, EObject value) {
		EMFStoreProperty prop = createProperty(key, value);
		prop.setType(EMFStorePropertyType.LOCAL);
		this.projectSpace.getProperties().put(prop.getKey(), prop);

		if (this.localProperties == null) {
			this.localProperties = new HashMap<String, EObject>();
			createMap(this.localProperties, EMFStorePropertyType.LOCAL);
		}

		this.localProperties.put(key, value);
		return prop;

	}

	/**
	 * Get a local property.
	 * 
	 * @param key
	 *            of the local property
	 * @return EObject the local property
	 * **/
	public EObject getLocalProperty(String key) {
		if (this.localProperties == null) {
			this.localProperties = new HashMap<String, EObject>();
			createMap(this.localProperties, EMFStorePropertyType.LOCAL);
		}
		return getProperty(this.localProperties, key);
	}

	/**
	 * Set a local string property. If the property already exists it will be
	 * updated.
	 * 
	 * @param key
	 *            of the local property
	 * @param value
	 *            of the local property
	 * */
	public EMFStoreProperty setLocalStringProperty(String key, String value) {
		PropertyStringValue propertyValue = org.eclipse.emf.emfstore.common.model.ModelFactory.eINSTANCE
				.createPropertyStringValue();
		propertyValue.setValue(value);
		EMFStoreProperty prop = setLocalProperty(key, propertyValue);
		return prop;

	}

	/**
	 * Get a local string property.
	 * 
	 * @param key
	 *            of the local property
	 * @return property value as String
	 * 
	 * **/
	public String getLocalStringProperty(String key) {
		PropertyStringValue propertyValue = (PropertyStringValue) getLocalProperty(key);
		return propertyValue.getValue();
	}

	/**
	 * Set a shared string property. It will be transmitted to the server. If
	 * the property already exists it will be updated.
	 * 
	 * @param key
	 *            of the shared property as String
	 * @param value
	 *            of the shared property as String
	 * 
	 * **/
	public EMFStoreProperty setSharedStringProperty(String key, String value) {
		PropertyStringValue propertyValue = org.eclipse.emf.emfstore.common.model.ModelFactory.eINSTANCE
				.createPropertyStringValue();
		propertyValue.setValue(value);
		EMFStoreProperty prop = setSharedProperty(key, propertyValue);
		return prop;
	}

	/**
	 * Get shared string property.
	 * 
	 * @param key
	 *            of the shared property as String
	 * @return value of the shared property as String
	 * **/
	public String getSharedStringProperty(String key) {
		if (key != null) {
			PropertyStringValue propertyValue = (PropertyStringValue) getSharedProperty(key);
			return propertyValue.getValue();
		}
		return null;
	}

	/**
	 * Set shared property which is transmitted to the server.
	 * 
	 * @param key
	 *            of the shared property as String
	 * @param value
	 *            of the shared property as EObject
	 * **/
	public EMFStoreProperty setSharedProperty(String key, EObject value) {
		EMFStoreProperty prop = createProperty(key, (EObject) value);
		prop.setType(EMFStorePropertyType.SHARED);
		this.projectSpace.getProperties().put(prop.getKey(), prop);
		this.projectSpace.getChangedSharedProperties().put(prop.getKey(), prop);

		if (this.sharedProperties == null) {
			this.sharedProperties = new HashMap<String, EObject>();
			createMap(this.sharedProperties, EMFStorePropertyType.SHARED);
		}

		this.sharedProperties.put(key, value);
		return prop;
	}

	/**
	 * Get shared property.
	 * 
	 * @param key
	 *            of the shared property as String
	 * @return value of the shared property as EObject
	 * */
	public EObject getSharedProperty(String key) {
		if (this.sharedProperties == null) {
			this.sharedProperties = new HashMap<String, EObject>();
			createMap(this.sharedProperties, EMFStorePropertyType.SHARED);
		}
		return getProperty(this.sharedProperties, key);
	}

	/**
	 * Transmit changed shared properties to the server. Clears the
	 * changedSharedProperties List and fills shareProperties with the actual
	 * properties from the server.
	 * 
	 * @throws EmfStoreException
	 *             if any error occurs in the EmfStore
	 * */
	public void transmit() throws EmfStoreException {
		EMap<String, EMFStoreProperty> changedProperties = this.projectSpace
				.getChangedSharedProperties();
		for (EMFStoreProperty prop : changedProperties.values()) {
			WorkspaceManager
					.getInstance()
					.getConnectionManager()
					.transmitEMFProperties(
							this.projectSpace.getUsersession().getSessionId(),
							prop, this.projectSpace.getProjectId());
		}

		this.projectSpace.getChangedSharedProperties().clear();

		List<EMFStoreProperty> sharedProperties = WorkspaceManager
				.getInstance()
				.getConnectionManager()
				.getEMFProperties(
						this.projectSpace.getUsersession().getSessionId(),
						this.projectSpace.getProjectId());

		for (EMFStoreProperty prop : sharedProperties) {
			this.sharedProperties.put(prop.getKey(), prop);
			this.projectSpace.getProperties().put(prop.getKey(), prop);
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
