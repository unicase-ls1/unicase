package org.unicase.ui.meeditor.multiattribute;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.unicase.ui.common.commands.ECPCommand;

/**
 * Tool for easily editing EMFCP model elements.
 * <p>
 * The necessary anonymous classes (ECPCommand) are provided in order to
 * make manipulation from everywhere else easier.
 * 
 * @author Christian Kroemer (christian.kroemer@z-corp-online.de)
 *
 * @param <T>
 * 			The type of the corresponding model element.
 */
public class MultiAttributeController<T> {

	// essential references
	private MultiAttributeControl parentItem;
	private EDataTypeEList<T> data;
	
	MultiAttributeController(MultiAttributeControl parentItem, EDataTypeEList<T> data) {
		this.parentItem = parentItem;
		this.data = data;
	}
	
	private MultiAttributeController() {
		// hide default constructor
	}

	/**
	 * Checks if a value exists in the model attribute.
	 * 
	 * @param value
	 * 			The value.
	 * @return
	 * 			Returns true if it exists, false otherwise.
	 */
	public boolean contains(T value) {
		return data.contains(value);
	}

	/**
	 * Adds a value to the model attribute.
	 * 
	 * @param value
	 * 			The value.
	 * @return
	 * 			Returns true if the value was added, false otherwise (it already existed).
	 */
	public boolean add(final T value) {
		if (contains(value)) {
			return false;
		}
		new ECPCommand(parentItem.getModelElement()) {
			@Override
			protected void doRun() {
				data.add(value);
			};
		}.run();
		return true;
	}

	/**
	 * Removes a value from the model attribute.
	 * 
	 * @param value
	 * 			The value.
	 * @return
	 * 			Returns true if the value was removed, false otherwise (it didn't exist).
	 */
	public boolean remove(final T value) {
		if (!contains(value)) {
			return false;
		}
		new ECPCommand(parentItem.getModelElement()) {
			@Override
			protected void doRun() {
				data.remove(value);
			};
		}.run();
		return true;
	}

	/**
	 * Replaces a value of the model attribute with an other one.
	 * 
	 * @param oldValue
	 * 			The old value.
	 * @param newValue
	 * 			The new value.
	 * @return
	 * 			Returns true if the value was replaced, false otherwise (the old value didn't exist).
	 */
	public boolean replace(final T oldValue, final T newValue) {
		if (!contains(oldValue)) {
			return false;
		}
		new ECPCommand(parentItem.getModelElement()) {
			@Override
			protected void doRun() {
				data.set(data.indexOf(oldValue), newValue);
			};
		}.run();
		return true;
	}

	/**
	 * Returns all elements of this attribute as Object array.
	 * 
	 * @return
	 * 			Returns the array.
	 */
	public Object[] getAllStoredElements() {
		return data.toArray();
	}

}
