package org.unicase.model.search.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.unicase.model.search.model.Condition;
import org.unicase.model.search.model.SearchModel;
import org.unicase.model.search.views.editingsupport.ConditionEditingSupport;

/**
 * Helper class for the conditions table implemented as Singleton.
 * @author Markus Fischer
 *
 */
public class TableConditionsHelper {
	
	private static TableConditionsHelper instance;
	private HashMap<String, EReference> references;
	
	private TableConditionsHelper() {
	}
	
	/**
	 * @return An instance of the helper.
	 */
	public static TableConditionsHelper getInstance() {
		if (instance == null) {
			instance = new TableConditionsHelper();
		}
		return instance;
	}
	
	/**
	 * Returns the EReference Object for a given field name or null if the references 
	 * are not loaded yet.
	 * @param fieldName the field name of the reference
	 * @return the EReference Object
	 */
	public EReference getEReferenceByFieldName(String fieldName) {
		if (references == null) {
			return null;
		}
		return references.get(fieldName);
	}
	
	/**
	 * Updates the available fields for the given type selection and removes conditions which 
	 * use now invalid fields. Also reinitializes the EditingSupport object of the table column 
	 * that displays the available fields.
	 * @param conditions the current conditions
	 * @param types the type selection.
	 * @param viewerColumn the column for the fields
	 * @param columnIndex the index of this column
	 * @param viewer the table viewer of the conditions table
	 */
	@SuppressWarnings("unchecked")
	public void updateFields(SearchModel model, List<EClass> types, TableViewerColumn viewerColumn, 
							int columnIndex, TableViewer viewer) {
		List<Object> fieldsAndReferences = initializeFields(types);
		List<Condition> toRemove = new ArrayList<Condition>();
		for (Condition condition : model.getConditions()) {
			boolean found = false;
			for (String field : (List<String>) fieldsAndReferences.get(0)) {
				if (condition.getField() == null || field.equals(condition.getField())) {
					found = true;
					break;
				}
			}
			if (!found) {
				toRemove.add(condition);
			}
		}
		model.getConditions().removeAll(toRemove);

		ConditionEditingSupport editingSupport = new ConditionEditingSupport(viewer, columnIndex,
			(List<String>) fieldsAndReferences.get(0), (HashMap<String, EReference>) fieldsAndReferences.get(1), model);
		viewerColumn.setEditingSupport(editingSupport);
	}
	
	/**
	 * Initializes the fields for a given type selection.
	 * @param types the type selection
	 * @return A list that contains a List<String> as first element and a HashMap<String, EReference> 
	 * as second element. The first element is a simple list of all field names. The second element 
	 * can be used to simply get the EReference object of a field name.
	 */
	public List<Object> initializeFields(Collection<EClass> types) {
		List<String> fields = new ArrayList<String>();
		references = new HashMap<String, EReference>();
		
		for (EClass type : types) {
			String baseName = type.getEPackage().getName() + "." + type.getName() + ".";
			EList<EReference> refs = type.getEReferences();
			for (EReference eReference : refs) {
				String fieldName = baseName + eReference.getName() + ".name";
				fields.add(fieldName);
				references.put(fieldName, eReference);
			}
		}
		
		List<Object> resultList = new ArrayList<Object>();
		resultList.add(fields);
		resultList.add(references);
		
		return resultList;
	}

}
