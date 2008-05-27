package org.unicase.ui.tableview.viewer;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.jface.viewers.ColumnLabelProvider;


/**
 * 
 * @author Hodaie
 *
 */
public class TableViewColumnLabelProvider extends ColumnLabelProvider {

	private IItemPropertyDescriptor propertyDescriptor;
	private static final String PROPERTY_NOT_SET = "N/A";
	
	
	/**
	 * 
	 * @param propertyDescriptor IItemPropertyDescriptor
	 */
	public TableViewColumnLabelProvider(IItemPropertyDescriptor propertyDescriptor) {
		this.propertyDescriptor = propertyDescriptor;
	}

	
	/**.
	 * 
	 * ({@inheritDoc})
	 */
	@Override
	public String getText(Object element) {

		String result = "";
		if (propertyDescriptor.isPropertySet(element)) {
			ItemPropertyDescriptor.PropertyValueWrapper valueWrapper = 
				(ItemPropertyDescriptor.PropertyValueWrapper) propertyDescriptor
					.getPropertyValue(element);
			result = valueWrapper.getText(element);
		} else {
			result = PROPERTY_NOT_SET;
		}
	
		return result;

	}
}
