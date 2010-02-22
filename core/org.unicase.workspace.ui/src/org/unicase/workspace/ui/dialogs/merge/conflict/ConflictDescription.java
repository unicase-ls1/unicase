/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs.merge.conflict;

import java.util.HashMap;
import java.util.Map;

import org.unicase.metamodel.ModelElement;
import org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil;

public class ConflictDescription {

	private Map<String, Object> values;
	private String description;
	private String imageName;

	public ConflictDescription(String description) {
		this.description = description;
		values = new HashMap<String, Object>();
	}

	public void add(String key, Object value) {
		values.put(key, value);
	}

	public String getDescription() {
		return description;
	}

	public Map<String, Object> getValues() {
		return values;
	}

	public String getImage() {
		return imageName;
	}

	public void setImage(String name) {
		this.imageName = name;

	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResolvedDescription() {
		String result = description;
		for (String token : values.keySet()) {
			String tmp = "[" + token + "]";
			Object value = values.get(token);
			if (value instanceof ModelElement) {
				value = DecisionUtil.getClassAndName((ModelElement) value);
			}
			result = result.replace(tmp, (value != null) ? value.toString()
					: "");
		}
		return result;
	}
}
