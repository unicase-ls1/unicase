package org.unicase.model.search.views.editingsupport;

import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.unicase.model.search.exceptions.SearchParameterException;
import org.unicase.model.search.model.Condition;
import org.unicase.model.search.model.SearchModel;

/**
 * Editing support for the condition table.
 * @author Markus Fischer
 *
 */
public class ConditionEditingSupport extends EditingSupport {
	
	public static final int COLUMN_CONDITION = 0;
	public static final int COLUMN_FIELD = 1;
	public static final int COLUMN_OPERATOR = 2;
	public static final int COLUMN_VALUE = 3;
	
	private CellEditor editor;
	private int column;
	private SearchModel searchModel;
	
	private HashMap<String, Integer> conditionsToIndex;
	private HashMap<Integer, String> indexToConditions;
	
	private HashMap<String, Integer> operatorsToIndex;
	private HashMap<Integer, String> indexToOperators;
	
	private HashMap<String, Integer> fieldsToIndex;
	private HashMap<Integer, String> indexToFields;
	private HashMap<String, EReference> fieldsToReferences;
	
	/**
	 * Creates a new editing support object.
	 * @param viewer the columnViewer
	 * @param column the index of the column
	 * @param fields List of field names (only needed for field column)
	 * @param references list of references (only needed for field column)
	 * @param model the search model
	 */
	public ConditionEditingSupport(ColumnViewer viewer, int column, List<String> fields,
		HashMap<String, EReference> references, SearchModel model) {
		super(viewer);
		
		this.searchModel = model;

		switch (column) {
		case COLUMN_CONDITION:
			initConditionMaps();
			editor = new ComboBoxCellEditor(((TableViewer) viewer).getTable(), indexToConditions.values().toArray(
				new String[] {}));
			editor.setStyle(SWT.READ_ONLY);
			break;
		case COLUMN_FIELD:
			initFieldMaps(fields);
			fieldsToReferences = references;
			editor = new ComboBoxCellEditor(((TableViewer) viewer).getTable(), fields.toArray(new String[] {}));
			editor.setStyle(SWT.READ_ONLY);
			break;
		case COLUMN_OPERATOR:
			initOperatorMaps();
			editor = new ComboBoxCellEditor(((TableViewer) viewer).getTable(), indexToOperators.values().toArray(
				new String[] {}));
			editor.setStyle(SWT.READ_ONLY);
			break;
		case COLUMN_VALUE:
			editor = new TextCellEditor(((TableViewer) viewer).getTable());
			break;
		}
		this.column = column;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.EditingSupport#canEdit(java.lang.Object)
	 */
	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.EditingSupport#getCellEditor(java.lang.Object)
	 */
	@Override
	protected CellEditor getCellEditor(Object element) {
		return editor;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.EditingSupport#getValue(java.lang.Object)
	 */
	@Override
	protected Object getValue(Object element) {
		Condition c = (Condition) element;
		switch (this.column) {
		case COLUMN_CONDITION:
			return conditionsToIndex.get(c.getCondition());
		case COLUMN_FIELD:
			if (c.getField() == null) {
				return 0;
			}
			return fieldsToIndex.get(c.getField());
		case COLUMN_OPERATOR:
			return operatorsToIndex.get(c.getOperator());
		case COLUMN_VALUE:
			return c.getValue();
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.EditingSupport#setValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected void setValue(Object element, Object value) {
		Condition c = (Condition) element;
		try {
			switch (this.column) {
			case COLUMN_CONDITION:
				c.setCondition(indexToConditions.get((Integer) value));
				break;
			case COLUMN_FIELD:
				String fieldName = indexToFields.get((Integer) value);
				c.setField(fieldName);
				c.setReference(fieldsToReferences.get(fieldName));
				break;
			case COLUMN_OPERATOR:
				String operator = indexToOperators.get((Integer) value);
				c.setOperator(operator);
				if (operator.equals(Condition.OPERATOR_IS_NULL) || operator.equals(Condition.OPERATOR_NOT_NULL)) {
					c.setValue("");
				}
				break;
			case COLUMN_VALUE:
				c.setValue(String.valueOf(value));
				searchModel.checkSearchCondition(c);
				break;
			}
		} catch(SearchParameterException ex) {
			MessageDialog.openWarning(null, "Parameter Exception", ex.getMessage());
			if (c.getOperator().equals(Condition.OPERATOR_IS_NULL) || c.getOperator().equals(Condition.OPERATOR_NOT_NULL)) {
				c.setValue("");
			}
		}
		getViewer().update(element, null);
	}
	
	/**
	 * Initializes the HashMaps for the operator column.
	 */
	private void initOperatorMaps() {
		operatorsToIndex = new HashMap<String, Integer>();
		operatorsToIndex.put(Condition.OPERATOR_EQUAL, 0);
		operatorsToIndex.put(Condition.OPERATOR_NOT_EQUAL, 1);
		operatorsToIndex.put(Condition.OPERATOR_NOT_NULL, 2);
		operatorsToIndex.put(Condition.OPERATOR_IS_NULL, 3);
		
		indexToOperators = new HashMap<Integer, String>();
		indexToOperators.put(0, Condition.OPERATOR_EQUAL);
		indexToOperators.put(1, Condition.OPERATOR_NOT_EQUAL);
		indexToOperators.put(2, Condition.OPERATOR_NOT_NULL);
		indexToOperators.put(3, Condition.OPERATOR_IS_NULL);
	}

	/**
	 * Initializes the HashMaps for the condition column.
	 */
	private void initConditionMaps() {
		conditionsToIndex = new HashMap<String, Integer>();
		conditionsToIndex.put(Condition.CONDITION_AND, 0);
		conditionsToIndex.put(Condition.CONDITION_OR, 1);
		
		indexToConditions = new HashMap<Integer, String>();
		indexToConditions.put(0, Condition.CONDITION_AND);
		indexToConditions.put(1, Condition.CONDITION_OR);
	}
	
	/**
	 * Initializes the HashMaps for the field column.
	 * @param fields the list of possible field names
	 */
	private void initFieldMaps(List<String> fields) {
		fieldsToIndex = new HashMap<String, Integer>();
		indexToFields = new HashMap<Integer, String>();
		
		int counter = 0;
		for (String field : fields) {
			fieldsToIndex.put(field, counter);
			indexToFields.put(counter, field);
			counter++;
		}
	}

}
