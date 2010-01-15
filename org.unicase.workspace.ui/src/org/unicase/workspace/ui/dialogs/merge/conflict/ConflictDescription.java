package org.unicase.workspace.ui.dialogs.merge.conflict;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
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
		AdapterFactoryLabelProvider factory = DecisionUtil.getAdapterFactory();
		String result = description;
		for (String token : values.keySet()) {
			String tmp = "[" + token + "]";
			Object value = values.get(token);
			if (value instanceof ModelElement) {
				value = factory.getText(value);
			}
			result = result.replace(tmp, (value != null) ? value.toString()
					: "");
		}
		return result;
	}
}
