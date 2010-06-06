/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emailnotifierpreferences.properties;

import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolFactory;
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.model.emailbundle.Bundle;
import org.unicase.model.emailbundle.impl.EmailbundleFactoryImpl;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.exceptions.PropertyNotFoundException;
import org.unicase.workspace.preferences.PropertyKey;


/**
 * Utility class to handle the custom and default properties.
 * 
 * @author fuesescc
 */
public final class PreferenceManager {

	/**
	 * the singleton instance.
	 */
	public static final PreferenceManager INSTANCE = new PreferenceManager();

	private static HashMap<PropertyKey, OrgUnitProperty> defaultsMap;

	private PreferenceManager() {
		defaultsMap = new HashMap<PropertyKey, OrgUnitProperty>();
		Bundle test = EmailbundleFactoryImpl.eINSTANCE.createBundle();
		test.setBundleName("pronto");
		test.getProviders().add(EMailNotifierKey.COMMENTS_PROVIDER);
		defaultsMap.put(EMailNotifierKey.BUNDLES, createProperty(EMailNotifierKey.BUNDLES, new EObject[]{test}));
		defaultsMap.put(EMailNotifierKey.ACTIVATED, createProperty(EMailNotifierKey.ACTIVATED, true, null));
	}

	/**
	 * @param key the key
	 * @param projectSpace the projectSpace
	 * @return the default property for this key of null if not existing.
	 */
	public OrgUnitProperty getProperty(ProjectSpace projectSpace, PropertyKey key) {
		try {
			OrgUnitProperty property = projectSpace.getProperty((org.unicase.workspace.preferences.PropertyKey) key);
			return property;
		} catch (PropertyNotFoundException e) {
			OrgUnitProperty property = defaultsMap.get(key);
			if (property != null) {
				return property;
			}
		}
		throw new IllegalStateException("No default value for key " + key.toString());
	}

	private OrgUnitProperty createProperty(PropertyKey key, boolean value, ProjectId id) {
		OrgUnitProperty property = AccesscontrolFactory.eINSTANCE.createOrgUnitProperty();
		property.setName(key.toString());
		property.setValue(value);
		property.setProject(id);
		return property;
	}

	private OrgUnitProperty createProperty(PropertyKey key, EObject[] value) {
		OrgUnitProperty property = AccesscontrolFactory.eINSTANCE.createOrgUnitProperty();
		property.setName(key.toString());
		property.setValue(value);
		return property;
	}


	/**
	 * Sets a new ModelElementId[] property.
	 * 
	 * @param projectSpace the project space
	 * @param key the key
	 * @param value the value
	 */
	public void setProperty(ProjectSpace projectSpace, PropertyKey key, EObject[] value) {
		OrgUnitProperty property = createProperty(key, value);
		projectSpace.setProperty(property);
	}


	/**
	 * Sets a new boolean property.
	 * 
	 * @param projectSpace the project space
	 * @param key the key
	 * @param value the value
	 */
	public void setProperty(ProjectSpace projectSpace, PropertyKey key, boolean value) {
		OrgUnitProperty property = createProperty(key, value, projectSpace.getProjectId());
		projectSpace.setProperty(property);
	}

	/**
	 * Sets a new default property for the given key.
	 * 
	 * @param key the key.
	 * @param property the property.
	 */
	public void setDefaultProperty(PropertyKey key, OrgUnitProperty property) {
		defaultsMap.put(key, property);
	}
}
