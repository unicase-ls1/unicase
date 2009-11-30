package org.unicase.workspace.ui.dialogs.merge.conflict;

import java.util.HashMap;
import java.util.Map;

public class ConflictDescription {

	private Map<String, Object> values;
	private final String description;
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

	public String getResolvedDescription() {
		String result = description;
		for (String token : values.keySet()) {
			String tmp = "[" + token + "]";
			Object value = values.get(token);
			result.replace(tmp, (value != null) ? value.toString() : "");
		}
		return description;
	}
}
