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
package org.eclipse.emf.emfstore.client.model.preferences;

import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.exceptions.PropertyNotFoundException;
import org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolFactory;
import org.eclipse.emf.emfstore.server.model.accesscontrol.OrgUnitProperty;

/**
 * Utility class to handle the custom and default properties.
 * 
 * @author Shterev
 */
public final class PreferenceManager {

	/**
	 * the singleton instance.
	 */
	public static final PreferenceManager INSTANCE = new PreferenceManager();

	private static HashMap<PropertyKey, OrgUnitProperty> defaultsMap;

	private PreferenceManager() {
		defaultsMap = new HashMap<PropertyKey, OrgUnitProperty>();

		defaultsMap.put(DashboardKey.DASHBOARD_SIZE, createProperty(DashboardKey.DASHBOARD_SIZE, 50));

		defaultsMap.put(DashboardKey.TASK_PROVIDER, createProperty(DashboardKey.TASK_PROVIDER, true));
		defaultsMap.put(DashboardKey.TASK_CHANGE_PROVIDER, createProperty(DashboardKey.TASK_CHANGE_PROVIDER, true));
		defaultsMap.put(DashboardKey.TASK_REVIEW_PROVIDER, createProperty(DashboardKey.TASK_REVIEW_PROVIDER, true));
		defaultsMap.put(DashboardKey.TASK_TRACE_PROVIDER, createProperty(DashboardKey.TASK_TRACE_PROVIDER, true));
		defaultsMap.put(DashboardKey.SUBSCRIPTION_PROVIDER, createProperty(DashboardKey.SUBSCRIPTION_PROVIDER, true));
		defaultsMap.put(DashboardKey.COMMENTS_PROVIDER, createProperty(DashboardKey.COMMENTS_PROVIDER, true));
		defaultsMap.put(DashboardKey.PUSHED_PROVIDER, createProperty(DashboardKey.PUSHED_PROVIDER, true));
		defaultsMap.put(DashboardKey.UPDATE_PROVIDER, createProperty(DashboardKey.UPDATE_PROVIDER, true));

		defaultsMap.put(DashboardKey.HIGHLIGHT_PUSHED_COMMENTS,
			createProperty(DashboardKey.HIGHLIGHT_PUSHED_COMMENTS, true));
		defaultsMap.put(DashboardKey.SHOW_CONTAINMENT_REPLIES,
			createProperty(DashboardKey.SHOW_CONTAINMENT_REPLIES, true));

		defaultsMap.put(DashboardKey.SHOW_AI_TASKS, createProperty(DashboardKey.SHOW_AI_TASKS, true));
		defaultsMap.put(DashboardKey.SHOW_BR_TASKS, createProperty(DashboardKey.SHOW_BR_TASKS, true));
		defaultsMap.put(DashboardKey.SHOW_ISSUE_TASKS, createProperty(DashboardKey.SHOW_ISSUE_TASKS, true));
		defaultsMap.put(DashboardKey.SHOW_WP_TASKS, createProperty(DashboardKey.SHOW_WP_TASKS, true));
		defaultsMap.put(DashboardKey.SHOW_ONLY_READYFORREVIEW,
			createProperty(DashboardKey.SHOW_ONLY_READYFORREVIEW, false));

		defaultsMap.put(DashboardKey.SUBSCRIPTIONS, createProperty(DashboardKey.SUBSCRIPTIONS, new String[0]));

		defaultsMap.put(DashboardKey.TASKTRACE_CLASSES, createProperty(DashboardKey.TASKTRACE_CLASSES, new String[0]));
		defaultsMap.put(DashboardKey.TASKTRACE_LENGTH, createProperty(DashboardKey.TASKTRACE_LENGTH, 3));

	}

	/**
	 * @param key the key
	 * @param projectSpace the projectSpace
	 * @return the default property for this key of null if not existing.
	 */
	public OrgUnitProperty getProperty(ProjectSpace projectSpace, PropertyKey key) {
		try {
			OrgUnitProperty property = projectSpace.getProperty(key);
			return property;
		} catch (PropertyNotFoundException e) {
			OrgUnitProperty property = defaultsMap.get(key);
			if (property != null) {
				return property;
			}
		}
		throw new IllegalStateException("No default value for key " + key.toString());
	}

	private OrgUnitProperty createProperty(PropertyKey key, String value) {
		OrgUnitProperty property = AccesscontrolFactory.eINSTANCE.createOrgUnitProperty();
		property.setName(key.toString());
		property.setValue(value);
		return property;
	}

	private OrgUnitProperty createProperty(PropertyKey key, boolean value) {
		OrgUnitProperty property = AccesscontrolFactory.eINSTANCE.createOrgUnitProperty();
		property.setName(key.toString());
		property.setValue(value);
		return property;
	}

	private OrgUnitProperty createProperty(PropertyKey key, int value) {
		OrgUnitProperty property = AccesscontrolFactory.eINSTANCE.createOrgUnitProperty();
		property.setName(key.toString());
		property.setValue(value);
		return property;
	}

	private OrgUnitProperty createProperty(PropertyKey key, EObject[] value) {
		OrgUnitProperty property = AccesscontrolFactory.eINSTANCE.createOrgUnitProperty();
		property.setName(key.toString());
		property.setValue(value);
		return property;
	}

	private OrgUnitProperty createProperty(PropertyKey key, String[] value) {
		OrgUnitProperty property = AccesscontrolFactory.eINSTANCE.createOrgUnitProperty();
		property.setName(key.toString());
		property.setValue(value);
		return property;
	}

	/**
	 * Sets a new String property.
	 * 
	 * @param projectSpace the project space
	 * @param key the key
	 * @param value the value
	 */
	public void setProperty(ProjectSpace projectSpace, PropertyKey key, String value) {
		OrgUnitProperty property = createProperty(key, value);
		projectSpace.setProperty(property);
	}

	/**
	 * Sets a new String[] property.
	 * 
	 * @param projectSpace the project space
	 * @param key the key
	 * @param value the value
	 */
	public void setProperty(ProjectSpace projectSpace, PropertyKey key, String[] value) {
		OrgUnitProperty property = createProperty(key, value);
		projectSpace.setProperty(property);
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
	 * Sets a new int property.
	 * 
	 * @param projectSpace the project space
	 * @param key the key
	 * @param value the value
	 */
	public void setProperty(ProjectSpace projectSpace, PropertyKey key, int value) {
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
		OrgUnitProperty property = createProperty(key, value);
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
